package test;

import java.sql.Date;

public class Reading {

	String rType;
	String rId;
	String rValue;
	Date rDate;

	public Reading(String type, String id, String value, Date date) {
		setRType(type);
		setRId(id);
		setRValue(value);
		setRDate(date);
	}

	/*
	 * accepts date as a String of the millisecond time value instead of an already
	 * instantiated Date Object.
	 */
	public Reading(String type, String id, String value, String date) {
		setRType(type);
		setRId(id);
		setRValue(value);
		setRDate(date);
	}

	// =================================setters===================

	public void setRType(String type) {
		rType = type;
	}

	public void setRId(String id) {
		rId = id;
	}

	public void setRValue(String value) {
		rValue = value;
	}

	public void setRDate(Date date) {
		rDate = date;
	}

	/*
	 * overloads the setRDate method to accept a String of the millisecond time
	 * value.
	 */
	public void setRDate(String date) {
		Long L = new Long(date);
		rDate = new Date(L);
	}

	// =================================setters===================

	public String getRtype() {
		return rType;
	}

	public String getRId() {
		return rId;
	}

	public String getRValue() {
		return rValue;
	}

	public Date getRDate() {
		return rDate;
	}

	// =============================================================

	public String toString() {
		return "";
	}
}
