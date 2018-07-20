package com.sy.api;

import java.util.HashMap;
import java.util.Map;

import com.sy.entity.User;

public class APIFactory {
	private static final String LOGIN_URL = "http://pw.yocent.cn:88/Api/Public/snicLogin.json";
	private static final String CHECK_URL = "http://pw.yocent.cn:88/Api/Ticket/checkTicket.json";
	private static final String GET_URL = "http://pw.yocent.cn:88/Api/Ticket/getTickets.json";
	
	//调用登录接口获取access_token
	public static String login(User user){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", user.getAppid());
		map.put("username", user.getUsername());
		map.put("companyCode", user.getCompanyCode());
		map.put("password", user.getPassword());
		map.put("timestamp", user.getTimestamp());
		map.put("sign_type", user.getSign_type());
		map.put("sign", APISign.createSign3(map, user.getSecretKey()));
		
		return HttpVisitor.sendPost(LOGIN_URL, map);
	}
	
	//获取票务信息
	public static String getTicket(User user){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("qr_code", user.getQrcode());
		map.put("access_token", user.getAccess_token());
		map.put("user_id", user.getUser_id()+"");
		map.put("bid", user.getBid()+"");
		map.put("timestamp", user.getTimestamp());
		map.put("sign_type", user.getSign_type());
		map.put("appid", user.getAppid());
		map.put("sign", APISign.createSign3(map, user.getSecretKey()));
		
		return HttpVisitor.sendPost(GET_URL, map);
	}
	
	//检票
	public static String checkTicket(User user, int check_num){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("assist", user.getAssist());
		map.put("code", user.getOrder_code());
		map.put("order_ticket_id", user.getOrder_ticket_id());
		map.put("check_num", check_num+"");
		map.put("check_port", user.getCheck_port());
		map.put("check_device", user.getCheck_device());
		map.put("bid", user.getBid()+"");
		map.put("user_id", user.getUser_id()+"");
		map.put("access_token", user.getAccess_token());
		map.put("timestamp", user.getTimestamp());
		map.put("sign_type", user.getSign_type());
		map.put("appid", user.getAppid());
		map.put("sign", APISign.createSign3(map, user.getSecretKey()));
		
		return HttpVisitor.sendPost(CHECK_URL, map);
	}
}
