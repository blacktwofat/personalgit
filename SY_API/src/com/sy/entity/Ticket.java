package com.sy.entity;

public class Ticket {
	private int id;				//��Ʊid
	private String name;		//��Ʊ����
	private String tt_type;		//��Ʊ����				1.����Ʊ��2.��ͯƱ��3.�ؼ�Ʊ��5.��Ʊ��
	private int num;			//��Ʊ����
	private int checked_num;	//��������
	private int back_num;		//��������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTt_type() {
		return tt_type;
	}

	public void setTt_type(String tt_type) {
		this.tt_type = tt_type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
}
