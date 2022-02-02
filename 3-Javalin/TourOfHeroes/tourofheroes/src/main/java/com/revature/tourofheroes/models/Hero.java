package com.revature.tourofheroes.models;

public class Hero {
	private int id;
	private String alias;
	private String realName;
	private String power;
	private HeroType type;
	
	public Hero(int id, String alias, String realName, String power, HeroType type) {
		super();
		this.id = id;
		this.alias = alias;
		this.realName = realName;
		this.power = power;
		this.type = type;
	}
	
	public Hero() {
		
	}

	public int getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public HeroType getType() {
		return type;
	}

	public void setType(HeroType type) {
		this.type = type;
	}
	
	
}
