package com.unionpay.merch.fileutils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title: FTPUtils</p>
 * <p>Description:FTP服务器操作工具类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月28日 下午4:41:54
 * @version 1.0
 *
 */
public class FTPUtils
{
	private static final Logger logger = LoggerFactory.getLogger(FTPUtils.class);
	
    public FTPClient getFTPClient()
    {
    	String error = null;
    	FTPClient fTPClient = null;
    	try
    	{
    		String ip = LoadConfig.getProperties("FTP_IP");
        	int port = Integer.parseInt(LoadConfig.getProperties("FTP_PORT")); 
        	String username = LoadConfig.getProperties("FTP_USERNAME");
        	String password = LoadConfig.getProperties("FTP_PASSWORD");
//        	String pa = LoadConfig.getProperties("FILE_PATH");
//        	String path = new String(pa.getBytes("ISO-8859-1"),"gbk");
        	fTPClient = new FTPClient();
        	fTPClient.connect(ip,port);// 连接FTP服务器
        	fTPClient.login(username,password);// 登陆FTP服务器
        	if(!FTPReply.isPositiveCompletion(fTPClient.getReplyCode()))
        	{
        		logger.info("未连接到FTP，用户名或密码错误。");
        		fTPClient.disconnect();
        	}
        	else
        	{
				logger.info("FTP连接成功。");
        	}
    	}
    	catch(SocketException se)
    	{
    		se.printStackTrace();
    		logger.info("FTP的IP地址可能错误，请正确配置。");
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    		logger.info("FTP的端口错误,请正确配置。");
    	}
    	catch(Exception e)
    	{
    		error = "客户端-FTP获取服务端的连接失败";
    		logger.error(error, e);
    	}
    	return fTPClient;
    }

	/**
	 * 
	 * <p>Title: unionpay-batch</p>
	 * <p>Description:读取FTP文件</p>
	 * @param ftpClient
	 * @param remotePath
	 * @param fileName
	 * @return
	 * String
	 * @author li liang zhong
	 * @date 2019年3月28日 下午5:26:01
	 * @version 1.0
	 */
	public String readFile(FTPClient ftpClient, String remotePath, String fileName)
	{
		String error = null;
		InputStream ins = null;
		String str = null;
		try
		{
            // 从服务器上读取指定的文件 
			ins = ftpClient.retrieveFileStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while((i = ins.read()) != -1)
            {
            	baos.write(i);
            }
            str = baos.toString();
            if(ins != null)
			    ins.close();
            // 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题 
			ftpClient.getReply();
		}
		catch(Exception e)
		{
			error = "读取文件失败";
			logger.error(error, e);
		}
		finally
		{
			if(ins != null)
				try
				{
					ins.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return str;
	}
}
