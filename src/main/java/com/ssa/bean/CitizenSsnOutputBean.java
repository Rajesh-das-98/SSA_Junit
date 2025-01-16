package com.ssa.bean;

public class CitizenSsnOutputBean {
	private String citiZenSsn;
	private String citiZenState;

	public String getCitiZenSsn() {
		return citiZenSsn;
	}

	public void setCitiZenSsn(String citiZenSsn) {
		this.citiZenSsn = citiZenSsn;
	}

	public String getCitiZenState() {
		return citiZenState;
	}

	public void setCitiZenState(String citiZenState) {
		this.citiZenState = citiZenState;
	}

	@Override
	public String toString() {
		return "CitizenSsnOutputBean [citiZenSsn=" + citiZenSsn + ", citiZenState=" + citiZenState + "]";
	}

}
