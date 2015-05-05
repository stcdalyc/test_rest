package com.example.test_rest;

import java.io.Serializable;

public class ModelList implements Serializable {
	private int aid;
	private int catid;
	private int collectstatus;
	private int collecttype;
	private String dateline;
	private String distance;
	private int gender;
	private int leftduration;
	private String pic;
	private String school;
	private String summary;
	private String thumbpic;
	private String title;
	private int uid;
	private String username;
	private String usertitle;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public int getCollectstatus() {
		return collectstatus;
	}

	public void setCollectstatus(int collectstatus) {
		this.collectstatus = collectstatus;
	}

	public int getCollecttype() {
		return collecttype;
	}

	public void setCollecttype(int collecttype) {
		this.collecttype = collecttype;
	}

	public String getDateline() {
		return dateline;
	}

	public void setDateline(String dateline) {
		this.dateline = dateline;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getLeftduration() {
		return leftduration;
	}

	public void setLeftduration(int leftduration) {
		this.leftduration = leftduration;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbpic() {
		return thumbpic;
	}

	public void setThumbpic(String thumbpic) {
		this.thumbpic = thumbpic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertitle() {
		return usertitle;
	}

	public void setUsertitle(String usertitle) {
		this.usertitle = usertitle;
	}

	@Override
	public String toString() {
		return "Model [aid=" + aid + ", catid=" + catid + ", collectstatus="
				+ collectstatus + ", collecttype=" + collecttype
				+ ", dateline=" + dateline + ", distance=" + distance
				+ ", gender=" + gender + ", leftduration=" + leftduration
				+ ", pic=" + pic + ", school=" + school + ", summary="
				+ summary + ", thumbpic=" + thumbpic + ", title=" + title
				+ ", uid=" + uid + ", username=" + username + ", usertitle="
				+ usertitle + "]";
	}

}
