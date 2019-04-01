package com.yh.hadoop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsDemo {

	private static Configuration conf = new Configuration();
	private static FileSystem fs;

	static {

		// 指定hadoop集群的参数;namenode和jobtraker
		conf.set("fs.defaultFS", "hdfs://172.16.88.11:8020");
		// conf.set("mapred.job.tracker", "172.16.88.11:8021");
		conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
		try {
			fs = FileSystem.get(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件上传
	 */
	public static boolean put2HSFS(String src, String dst, Configuration conf) {
		Path dstPath = new Path(dst);
		try {
			FileSystem hdfs = dstPath.getFileSystem(conf);
			// FileSystem hdfs = FileSystem.get( URI.create(dst), conf) ;
			hdfs.copyFromLocalFile(false, new Path(src), dstPath);
		} catch (IOException ie) {
			ie.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 文件下载
	 */
	public static boolean getFromHDFS(String src, String dst, Configuration conf) {
		Path dstPath = new Path(dst);
		try {
			FileSystem dhfs = dstPath.getFileSystem(conf);
			dhfs.copyToLocalFile(false, new Path(src), dstPath);
		} catch (IOException ie) {
			ie.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 文件检测并删除
	 */
	public static boolean checkAndDel(final String path, Configuration conf) {
		Path dstPath = new Path(path);
		try {
			FileSystem dhfs = dstPath.getFileSystem(conf);
			if (dhfs.exists(dstPath)) {
				dhfs.delete(dstPath, true);
			} else {
				return false;
			}
		} catch (IOException ie) {
			ie.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean getFromHDFS2(String src, String dst, Configuration conf){
		
		//从hdfs将产生的计算结果文件获取下来
		Path filePath = new Path(src);
		try {
			//读取
			FSDataInputStream is = fs.open(filePath);
			FileStatus fileStats = fs.getFileStatus(filePath);
			int len = (int) fileStats.getLen();
			byte[] buffer = new byte[len];
			is.read(buffer);
			is.close();
			
			//写入
			FileOutputStream fos = new FileOutputStream(new File(dst));
			fos.write(buffer, 0, len);
			fos.close();
			
		}catch (IOException ie) {
			ie.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dst = null;
		String src = null;
			
		//指定namenode的URL
		dst = "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		src = "c:\\my-data.txt";
		boolean status = false;

		//将文件传到hdfs上
		status = put2HSFS(src, dst, conf);
		System.out.println("upload status=" + status);

		//将上传的文件下载下来(需要安装cygwin)
		src = "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		dst = "d:\\UC\\tt.txt";
		status = getFromHDFS(src, dst, conf);
		System.out.println("download status=" + status);
	
		
		//文件(含文件夹,不指定文件名就是操作文件夹)检测并删除
		dst = "hdfs://cloudare-server.iflyvoice.com:8020/user/Administrator/demo/input/my-data.txt";
		status = checkAndDel(dst, conf);
		System.out.println("delete status=" + status);
		
	}
}
