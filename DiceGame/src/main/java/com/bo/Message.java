package com.bo;

public class Message {
	
	public static final int INFO= 0;
	public static final int WARN= 1;
	public static final int ERROR= 2;
	
	private String message;
	private int type;
	
	public Message(String text, int number) {
		this.message= text;
		this.type= number;
	}
	
	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
