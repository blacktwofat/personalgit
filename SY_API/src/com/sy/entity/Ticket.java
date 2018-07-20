package com.sy.entity;

public class Ticket {
	private int id;				//门票id
	private String name;		//门票名称
	private String tt_type;		//门票类型				1.成人票。2.儿童票。3.特价票。5.联票。
	private int num;			//门票数量
	private int checked_num;	//已验数量
	private int back_num;		//已退数量

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
