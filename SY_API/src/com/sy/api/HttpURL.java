package com.sy.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURL{
	private String url;
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public HttpURL(String url){
		this.url = url;
	}
	
	public String getResult(){
		URL reqURL;
		String reslut = "";
		try {
			reqURL = new URL(url);
			// 拿取链接
			HttpURLConnection httpsConn = (HttpURLConnection) reqURL.openConnection();
			// 取得该连接的输入流，以读取响应内容
			InputStreamReader isr = new InputStreamReader(httpsConn.getInputStream());
			// 读取服务器的响应内容并显示
			char[] chars = new char[1024];
			
			int len;
			while ((len = isr.read(chars)) != -1) {
			  reslut += new String(chars, 0, len);
			  System.out.println(reslut);
			}
			isr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reslut;
	}
}
