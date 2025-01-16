package com.ssa.common;

public class CommonOutPutBean {
	
	private String refId="SSA-"+System.currentTimeMillis();
	private boolean isSuccess;
	private String displayMsg;
	private Object data;
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getDisplayMsg() {
		return displayMsg;
	}
	public void setDisplayMsg(String displayMsg) {
		this.displayMsg = displayMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "CommonOutPutBean [refId=" + refId + ", isSuccess=" + isSuccess + ", displayMsg=" + displayMsg
				+ ", data=" + data + "]";
	}
	
	

}
