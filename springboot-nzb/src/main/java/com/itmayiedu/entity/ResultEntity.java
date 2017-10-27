package com.itmayiedu.entity;

import java.io.Serializable;
import java.util.List;

public class ResultEntity <T> implements Serializable{
	private String status;
	private String message;
	private List<T> result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultEntity [status=" + status + ", message=" + message + ", result=" + result + "]";
	}
	
	
}
