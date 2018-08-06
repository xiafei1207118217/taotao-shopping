package com.taotao.controller;

import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.aspectj.util.FileUtil;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient() throws Exception{
		//创建一个FTPclient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接,默认是21
		ftpClient.connect("192.168.2.198", 21);
		//登录服务器，使用用户名和密码
		ftpClient.login("ftpuser", "xiafei1234");
		//读取本地文件
		FileInputStream inputStream = new FileInputStream("G:\\photo\\577f3cb41ce92.jpg");
		//设置上传路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//上传文件 第一个参数是服务器端文档名称
		//第二个参数是上传文档的inputstream
		
		ftpClient.storeFile("577f3cb41ce92.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
	}
	@Test
	public void testFtpUtils() throws Exception{
		FileInputStream inputStream = new FileInputStream("G:\\\\photo\\\\577f3cb41ce92.jpg");
		FtpUtil.uploadFile("192.168.2.198", 21, "ftpuser", "xiafei1234", "/home/ftpuser/www/images", "2018/08/06", "577f3cb41ce92.jpg", inputStream);
	}
	

}
