package com.sy.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.sy.api.APISign;

public class User {
	//login param
	private String username;				//账号
	private String password;				//密码
	private String companyCode;				//企业编码
	private String appid;					// api提供方提供
	private String sign_type;				//签名方式 默认md5
	private String secretKey;				//秘钥
	
	//get param
	private int user_id;					//用户id
	private int bid;						//景区企业id
	private String access_token;			//通行证
	private int company_cate;				//company_cate
	private String qrcode;					//二维码
	private String timestamp;				//时间戳
	
	//check param
	private String assist;					//辅助检票码
	private String order_code;					//订单号
	private String order_ticket_id;			//订单门票id
	private String check_num;				//检票数量
	private String hardware_code;			//硬件编码 可选
	private String check_port;				//检票端口？ 比如手持机、app、海坤手持机
	private String check_device;			//检票设备 比如ios 8.0、Android 5.0

	//其他 param
	private int ticket_num;					//门票数量
	private int checked_num;				//已检数量
	private int back_num;					//已退数量
	private String ticket_name;				//门票名称
	private String voice_code;				//语音段 门票类型
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return APISign.EncryptionStr(password, "md5");
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getCompany_cate() {
		return company_cate;
	}

	public void setCompany_cate(int company_cate) {
		this.company_cate = company_cate;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	//返回当前时间戳
	public String getTimestamp(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		timestamp = sfd.format(c.getTime());
		return timestamp;
	}

	public String getAssist() {
		return assist;
	}

	public void setAssist(String assist) {
		this.assist = assist;
	}

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}

	public String getOrder_ticket_id() {
		return order_ticket_id;
	}

	public void setOrder_ticket_id(String order_ticket_id) {
		this.order_ticket_id = order_ticket_id;
	}

	public String getCheck_num() {
		return check_num;
	}

	public void setCheck_num(String check_num) {
		this.check_num = check_num;
	}

	public String getHardware_code() {
		return hardware_code;
	}

	public void setHardware_code(String hardware_code) {
		this.hardware_code = hardware_code;
	}

	public String getCheck_port() {
		return check_port;
	}

	public void setCheck_port(String check_port) {
		this.check_port = check_port;
	}

	public String getCheck_device() {
		return check_device;
	}

	public void setCheck_device(String check_device) {
		this.check_device = check_device;
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}

	public int getChecked_num() {
		return checked_num;
	}

	public void setChecked_num(int checked_num) {
		this.checked_num = checked_num;
	}

	public int getBack_num() {
		return back_num;
	}

	public void setBack_num(int back_num) {
		this.back_num = back_num;
	}

	public String getTicket_name() {
		return ticket_name;
	}

	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	public String getVoice_code() {
		return voice_code;
	}

	public void setVoice_code(String voice_code) {
		this.voice_code = voice_code;
	}
}
