package com.reptile.boss.model;

public class Company {
	private String id;
	private String name;	
	private String link;	
	private String type;//公司性质
	private String stage;//公司融资阶段
	private String scale;//规模
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	public Company(String id, String name,String link, String type, String stage, String scale) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.type = type;
		this.stage = stage;
		this.scale = scale;
	}
	public Company() {
		super();
	}
	
}
