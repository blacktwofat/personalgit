package com.sy.api;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sy.entity.User;

public class HttpVisitor {
	
	/*
	 * post����url
	 * @param url
	 * @param map
	 * @return ��Ӧ���
	 */
	public static String sendPost(String url, Map<String, String> paramMap){
		PrintWriter out = null;
		BufferedReader in = null;
		
		StringBuffer result = new StringBuffer("");
		
		try{
			URL aimUrl = new URL(url);
			URLConnection conn = aimUrl.openConnection();
			//����ͨ�õ���������
			//conn.setRequestProperty("accept", "*/*");
			//conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

			//post�������������������
			conn.setDoInput(true);
			conn.setDoOutput(true);

			//��ȡURLConnection�����Ӧ�������
			OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "GBK");
			out = new PrintWriter(outWriter);
			
			//�����������
			out.print(paramStr(paramMap));
			//flush������Ļ���
			out.flush();
			//��ȡ������
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result.append(line);
			}
		}catch(Exception e){
			System.err.println("����postʱ�쳣:" + e);
			e.printStackTrace();
		}finally{
			try{
				if(out != null){
					out.close();
				}
				
				if(in != null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		return result.toString();
	}
	
	private static String paramStr(Map<String, String> paramMap){
		StringBuilder sb = new StringBuilder();
		if(paramMap != null && paramMap.size() > 0){
			for(String s : paramMap.keySet()){
				sb.append("&" + s + "=" + paramMap.get((String)s));
			}
		}
		
		System.out.println("����=" + sb.toString());
		return sb.toString().substring(1, sb.toString().length());
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException{	
		User user = new User();
		user.setSecretKey("sddsadasdsadfwqewe142151241dsad");
		user.setAppid("2");
		user.setUsername("dqh");		//lmhqc dqh
		user.setPassword("111111");
		user.setCompanyCode("dqh");		//lmhqc dqh
		user.setSign_type("md5");
		System.out.println(user.getTimestamp());

		JSONObject json = null;				//login json
		JSONObject data = null;				//login data
		JSONObject json1 = null;			//get json
		JSONObject data1 = null;			//get data
		JSONArray jsonA1 = null;			//get l json����
		JSONObject data2 = null;			//get l data
		JSONObject json2 = null;			//check json
		
		try {
			json = new JSONObject(APIFactory.login(user));
			data = new JSONObject(json.get("data").toString());
			user.setUser_id(Integer.parseInt(data.getString("user_id")));	//��ȡ�����û�id
			user.setCompany_cate(Integer.parseInt(data.getString("company_cate")));
			user.setAccess_token(data.getString("access_token"));			//��ȡ����ͨ��֤
			user.setBid(Integer.parseInt(data.getString("bid")));			//��ȡ������ҵid
			
			System.out.println(json.get("data"));
			System.out.println(data.get("access_token"));
			System.out.println("��ȡ����access_token=" + user.getAccess_token());
			user.setQrcode("NBR4I5DBz1g7");									//������������
			//user.setQrcode("ei9rWmhjTEVMRDRzUk1RRUhiTGFqSU9zOXQyZUw2eEIwWDRQajVjT3NRZFl5YVc4K0REaTdyczFtQ29CeTlqdA==");
			json1 = new JSONObject(APIFactory.getTicket(user));				//���û�ȡƱ��ӿ�
			data1 = new JSONObject(json1.getString("data"));
			jsonA1 = new JSONArray(data1.getString("l"));
			System.out.println("Ʊ������:" + jsonA1.length());
			data2 = new JSONObject(jsonA1.get(0).toString());
			System.out.println(data2.toString());
			System.out.println(json1.toString());	
			//��ȡ��Ʊ������
			user.setAssist(data1.getString("c"));						//��ȡ���ü�Ʊ������
			user.setOrder_code(data1.getString("o"));						//��������
			user.setTicket_name(data2.getString("tn"));						//��Ʊ����
			user.setOrder_ticket_id(data2.getString("t"));					//������Ʊid
			user.setVoice_code(data2.getString("tt"));						//��Ʊ����|������
			user.setTicket_num(Integer.parseInt(data2.getString("n")));		//��Ʊ����
			user.setChecked_num(null == data2.get("cn") ? 0 : Integer.parseInt(data2.getString("cn")));	//�Ѽ�����
			user.setBack_num(null == data2.get("bn") ? 0 :Integer.parseInt(data2.getString("bn")));		//��������
			user.setCheck_port("�����ֳֻ�");
			user.setCheck_device("Android 5.0");
			//json2 = new JSONObject(APIFactory.checkTicket(user, 0));			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("��ȡlogin--" + json.toString());
		//System.out.println("��ȡcheck--" + json2.toString());
		
		/*
		 * {"status":1,"request":"/api/ticket/gettickets.json","data":{"c":"16696461","q":"NBR4I5DBz1g7","o":"B20180710151117057699","l":[{"tn":"����Ʊ","d":"1531152000","t":"7140","b":"73","s":"31","tt":"1","n":"100","sd":"1531152000","wd":"1111111","z":"15","ct":"1531206676","ed":"1588176000"}]}}
			����=&order_ticket_id=7140&sign_type=md5&assist=16696461&appid=2&code=B20180710151117057699&check_port=hkshouchiji&check_device=Android 5.0&timestamp=2018-07-13 16:05:06&sign=dc6a0b8a96ead4a0c6a43ef7f0ed7eb4&user_id=96&check_num=1&bid=73&access_token=256ab98c9154bed5e75ae794afcce00d154a3700
			��ȡlogin--{"status":1,"request":"/api/public/sniclogin.json","data":{"expires":2592000,"user_id":"96","company_cate":"1","refresh_token":"af41ebe7448df19ced181e950a3c9623ba48957e","bid":"73","access_token":"256ab98c9154bed5e75ae794afcce00d154a3700"}}
			��ȡcheck--{"status":1,"request":"/api/ticket/checkticket.json"}

		 */

	}
}
