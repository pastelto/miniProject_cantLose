package com.kh.project.reservation.model.vo;

import java.io.Serializable;

public class Memo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7901263221819877929L;
	
	private int memoNo;
	private String title; // 메모 제목
	private String memo; // 메모 내용
	private String time; // 작성시간

	public Memo() {}

	public Memo(int memoNo, String title, String memo, String time) {
		super();
		this.memoNo = memoNo;
		this.title = title;
		this.memo = memo;
		this.time = time;
	}

	public int getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		
		return memoNo + ". 제목 : " + title + ", 내용 : " + memo + ", 작성시간 : " + time;
	}
	
	
}
