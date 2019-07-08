package com.reptile.proup.model;

import java.util.List;

public class Company {
	private String sortid;
	private String name;	
	private String link;	
//	private String type;//公司性质
//	private String stage;//公司融资阶段
//	private String scale;//规模
	private List<String> otherInfo;
	
	
	public List<String> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getSortid() {
		return sortid;
	}
	public void setSortid(String sortid) {
		this.sortid = sortid;
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
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getStage() {
//		return stage;
//	}
//	public void setStage(String stage) {
//		this.stage = stage;
//	}
//	public String getScale() {
//		return scale;
//	}
//	public void setScale(String scale) {
//		this.scale = scale;
//	}
	
	public Company(String sortid, String name,String link, List<String> otherInfo) {
		super();
		this.sortid = sortid;
		this.name = name;
		this.link = link;
		this.otherInfo = otherInfo;
	}
	public Company() {
		super();
	}
	
}
