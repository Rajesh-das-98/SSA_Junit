package com.ssa.bean;

import java.util.Objects;

public class CitizenSsnInputBean {
	
	private String citiZenName;
	private String citiZenDob;
	private String citiZenSsn;
	public String getCitiZenName() {
		return citiZenName;
	}
	public void setCitiZenName(String citiZenName) {
		this.citiZenName = citiZenName;
	}
	public String getCitiZenDob() {
		return citiZenDob;
	}
	public void setCitiZenDob(String citiZenDob) {
		this.citiZenDob = citiZenDob;
	}
	public String getCitiZenSsn() {
		return citiZenSsn;
	}
	public void setCitiZenSsn(String citiZenSsn) {
		this.citiZenSsn = citiZenSsn;
	}
	@Override
	public String toString() {
		return "CitizenSsnInputBean [citiZenName=" + citiZenName + ", citiZenDob=" + citiZenDob + ", citiZenSsn="
				+ citiZenSsn + "]";
	}
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        CitizenSsnInputBean that = (CitizenSsnInputBean) o;
	        return Objects.equals(citiZenName, that.citiZenName) &&
	               Objects.equals(citiZenDob, that.citiZenDob) &&
	               Objects.equals(citiZenSsn, that.citiZenSsn);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(citiZenName, citiZenDob, citiZenSsn);
	    }
	

}
