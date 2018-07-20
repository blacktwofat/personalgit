package com.sy.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class APISign {
	/*
	 * ���ü����㷨�����ַ�������
	 * @pram str  ��Ҫ���ܵ�����
	 * @param algorithm ���õ��㷨��
	 * @return �����ֽ�����
	 */
	public static byte[] EncryptionStrBytes(String str, String algorithm){
		byte[] bytes = null;
		
		try{
			//��ȡ�㷨ʵ�����õ���Ӧ�㷨����ϢժҪ
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			bytes = md.digest();
		}catch(NoSuchAlgorithmException e){
			System.out.println("�޼����㷨:" + algorithm);
		}
		
		return null == bytes ? null : bytes;
	}
	
	/*
	 * ���ֽ�����ת�����ַ�������
	 * @param bytes
	 * @return
	 */
	public static String BytesConvertToHexString(byte[] bytes){
		StringBuffer sb = new StringBuffer();
		for(byte aByte : bytes){
			String s = Integer.toHexString(0xff & aByte);
			if(s.length() == 1){
				sb.append("0" + s);
			}else
				sb.append(s);
		}
		
		return sb.toString();
	}
	
	/*
	 * ���ü����㷨�����ַ�������
	 * @param str ��Ҫ���ܵ�����
	 * @param algorithm ���õļ����㷨
	 * @return �ֽ�����
	 */
	public static String EncryptionStr(String str, String algorithm){
		//����֮�����õ����ֽ�����
		byte[] bytes = EncryptionStrBytes(str, algorithm);
		return BytesConvertToHexString(bytes);
	}
	
	//get�ӿڵ�ǩ��
	public String createSign(String account_id, String company_code, String gate_ip
			, String qrcode, String timestamp, String secretKey){

		//first api = http://pwpt.gotoningbo.com/Api/Msc/get_ticket_info.json
		StringBuffer sb = new StringBuffer();
		sb.append("account_id=" + account_id + "&company_code=" + company_code + "&gate_ip=" + gate_ip);
		sb.append("&qrcode=" + qrcode + "&timestamp=" + timestamp + secretKey);
		
		return EncryptionStr(sb.toString(), "MD5");

	}
	
	//check�ӿڵ�ǩ��
	public String createSign2(String account_id, String company_code, String gate_ip
			, String num, String order_ticket_id, String qrcode
			, String timestamp, String secretKey){
		
		//first api = http://pwpt.gotoningbo.com/Api/Msc/get_ticket_info.json
		StringBuffer sb = new StringBuffer();
		sb.append("account_id=" + account_id + "&company_code=" + company_code + "&gate_ip=" + gate_ip);
		sb.append("&num=" + num + "&order_ticket_id=" + order_ticket_id + "&qrcode=" + qrcode + "&timestamp=" + timestamp + secretKey);
		
		return EncryptionStr(sb.toString(), "MD5");
	}
	
	
	//����ǩ��
	public static String createSign3(Map<String, String> m, String secretKey){
		StringBuffer sb = new StringBuffer();
		
		Object[] a = m.keySet().toArray();	//key����
		
		Object temp = null;
		for(int i = 0; a != null && i < a.length - 1; i++){	//ð������
			for(int j = i + 1; j < a.length; j++){
				if(((String)a[i]).compareTo((String)a[j]) > 0){
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		
		for(Object s : a){				//��ֵ��ƴ��
			sb.append("&" + s + "=" + m.get(s));
		}
		
		sb.append(secretKey);
		
		//���ش�д��ǩ��
		return EncryptionStr(sb.toString().substring(1, sb.toString().length()), m.get("sign_type"));
	}
	
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("dz", "6");
		map.put("a", "1");
		map.put("c", "3");
		map.put("da", "5");
		map.put("d", "4");
		
		System.out.println(APISign.createSign3(map, "1"));
	}
	
}
