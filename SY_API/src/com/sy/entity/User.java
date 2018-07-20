package com.sy.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.sy.api.APISign;

public class User {
	//login param
	private String username;				//�˺�
	private String password;				//����
	private String companyCode;				//��ҵ����
	private String appid;					// api�ṩ���ṩ
	private String sign_type;				//ǩ����ʽ Ĭ��md5
	private String secretKey;				//��Կ
	
	//get param
	private int user_id;					//�û�id
	private int bid;						//������ҵid
	private String access_token;			//ͨ��֤
	private int company_cate;				//company_cate
	private String qrcode;					//��ά��
	private String timestamp;				//ʱ���
	
	//check param
	private String assist;					//������Ʊ��
	private String order_code;					//������
	private String order_ticket_id;			//������Ʊid
	private String check_num;				//��Ʊ����
	private String hardware_code;			//Ӳ������ ��ѡ
	private String check_port;				//��Ʊ�˿ڣ� �����ֳֻ���app�������ֳֻ�
	private String check_device;			//��Ʊ�豸 ����ios 8.0��Android 5.0

	//���� param
	private int ticket_num;					//��Ʊ����
	private int checked_num;				//�Ѽ�����
	private int back_num;					//��������
	private String ticket_name;				//��Ʊ����
	private String voice_code;				//������ ��Ʊ����
	
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

	//���ص�ǰʱ���
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
