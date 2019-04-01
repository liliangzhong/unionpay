package com.yh.hadoop;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.Logger;

public class HDFSTool 
{
    private final static Logger logger = Logger.getLogger(HDFSTool.class);
	private static Configuration conf = new Configuration();
	private static FileSystem hadoopFS;

    private static String hdfsDir = "trans"; //从配置文件加载,文件存储的路径
    private static Configuration hdfsConf = null;
	
	//初始化配置信息
	static 
	{
		// 指定hadoop集群的参数;namenode和jobtraker
		conf.set("fs.defaultFS", "hdfs://172.16.88.11:8020");  //从配置文件加载
		// conf.set("mapred.job.tracker", "172.16.88.11:8021");
		conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
		conf.set("dfs.nameservices", "ns1");
		conf.set("dfs.ha.namenodes.ns1", "nn1,nn2");
		conf.set("dfs.namenode.rpc-address.ns1.nn1", "hadoop01:9000");   //从配置文件加载
		conf.set("dfs.namenode.rpc-address.ns1.nn2", "hadoop02:9000");   //从配置文件加载
		try
		{
		    hadoopFS = FileSystem.get(conf);
			if (!hadoopFS.exists(new Path("/" + hdfsDir)))
			{
	            hadoopFS.mkdirs(new Path("/" + hdfsDir));
	        }
		} 
		catch (IOException e)
		{
			logger.error("*************初始化HDFS配置信息失败*********************", e);
			e.printStackTrace();
		}
	}

	/**
	 * 文件上传
	 */
	public static boolean put2HSFS(String src, String dst, Configuration conf) 
	{
		Path dstPath = new Path(dst);
		try
		{
			FileSystem hdfs = dstPath.getFileSystem(conf);
			// FileSystem hdfs = FileSystem.get( URI.create(dst), conf) ;
			hdfs.copyFromLocalFile(false, new Path(src), dstPath);
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
			logger.error("HDFS上传文件失败", ie);
			return false;
		}
		return true;
	}

	/**
	 * 文件下载
	 */
	public static boolean getFromHDFS(String src, String dst, Configuration conf) 
	{
		Path dstPath = new Path(dst);
		try 
		{
			FileSystem dhfs = dstPath.getFileSystem(conf);
			dhfs.copyToLocalFile(false, new Path(src), dstPath);
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
			logger.error("HDFS文件下载失败", ie);
			return false;
		}
		return true;
	}

	/**
	 * 文件检测并删除
	 */
	public static boolean checkAndDel(final String path, Configuration conf) 
	{
		Path dstPath = new Path(path);
		try
		{
			FileSystem dhfs = dstPath.getFileSystem(conf);
			if (dhfs.exists(dstPath))
			{
				dhfs.delete(dstPath, true);
			}
			else
			{
				return false;
			}
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean getFromHDFS2(String src, String dst, Configuration conf)
	{
		//从hdfs将产生的计算结果文件获取下来
		Path filePath = new Path(src);
		FSDataInputStream is = null;
		FileOutputStream fos = null;
		try 
		{
			//读取
			is = hadoopFS.open(filePath);
			FileStatus fileStats = hadoopFS.getFileStatus(filePath);
			int len = (int) fileStats.getLen();
			byte[] buffer = new byte[len];
			is.read(buffer);
			is.close();
			
			//写入
			fos = new FileOutputStream(new File(dst));
			fos.write(buffer, 0, len);
			
			
		}catch (IOException ie) 
		{
			ie.printStackTrace();
			return false;
		}
		finally
		{
			if(is != null)
			{
				try
				{
				    is.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}	
			if(fos != null)
				try
				{
					fos.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return true;
	}
	
	/**
	 * 
	 * <p>Title: unionpay-gate</p>
	 * <p>Description: 数据写入HDFS</p>
	 * @param message 写入文件内容
	 * @param length  设置文件大小
	 * @return
	 * boolean
	 * @author li liang zhong
	 * @date 2019年3月8日 下午5:48:06
	 * @version 1.0
	 */
	public static boolean writeHDFS(String message, int length)
	{
		boolean result = false;
		if(StringUtils.isBlank(message) || length <= 0)
			return result;
		FileOutputStream fos = null;
		try
		{
			byte[] buffer = new byte[length];
			fos = new FileOutputStream(new File(message));
			fos.write(buffer, 0, length);
			fos.flush();
			result = true;
		}
		catch(Exception e)
		{
			logger.error("数据写入HDFS失败", e);
			result = false;
		}
		finally
		{
			if(fos != null)
				try
				{
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return result;
	}
	
	/**
	 * 
	 * <p>Title: unionpay-gate</p>
	 * <p>Description: </p>
	 * @param tmp
	 * @return
	 * boolean
	 * @author li liang zhong
	 * @date 2019年3月12日 下午2:34:15
	 * @version 1.0
	 */
	public static boolean kafkaConsumerDataWrite(String tmp)
	{
        boolean result = false;
		String fileContent = null;
		if (!tmp.endsWith("\n"))
            fileContent = new String(tmp + "\n");
        else
            fileContent = tmp;
        logger.info("receive: " + fileContent);
        try
        {
            hadoopFS = FileSystem.get(hdfsConf);
            String fileName = "/" + hdfsDir + "/" +
                   (new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())) + ".txt";
            Path dst = new Path(fileName);
            if (!hadoopFS.exists(dst)) 
            {
                FSDataOutputStream output = hadoopFS.create(dst);
                output.close();
            }
            InputStream in = new ByteArrayInputStream(fileContent.getBytes("UTF-8"));
            OutputStream out = hadoopFS.append(dst);
            IOUtils.copyBytes(in, out, 4096, true);
            result = true;
         }
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally
        {
            try
            {
                if(hadoopFS != null)
            	    hadoopFS.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String dst = null;
		String src = null;
			
		//指定namenode的URL
		dst = "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		src = "d:\\test.txt";
		boolean status = false;

		//将文件传到hdfs上
		status = put2HSFS(src, dst, conf);
		System.out.println("upload status=" + status);

		//将上传的文件下载下来(需要安装cygwin)
		src = "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		dst = "d:\\dev\\tt.txt";
		status = getFromHDFS(src, dst, conf);
		System.out.println("download status=" + status);
		
		//文件(含文件夹,不指定文件名就是操作文件夹)检测并删除
		/*
		 * dst =
		 * "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		 * status = checkAndDel(dst, conf); System.out.println("delete status="
		 * + status);
		 */
	}
}
