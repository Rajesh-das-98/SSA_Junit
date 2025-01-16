package com.ssa.service;

import org.springframework.stereotype.Service;

import com.ssa.bean.CitizenSsnInputBean;
import com.ssa.bean.CitizenSsnOutputBean;
import com.ssa.common.CommonOutPutBean;

@Service
public class CitizenSsnService {

	public CommonOutPutBean findStateBySsnNumber(CitizenSsnInputBean inputBean) {

		CitizenSsnOutputBean citizenSsnOutputBean = null;
		String ssn = inputBean.getCitiZenSsn();
		if (ssn != null) {
			citizenSsnOutputBean = new CitizenSsnOutputBean();
			char firstDigit = ssn.charAt(0);
			String state = switch (firstDigit) {
			case '1' -> "California";
			case '2' -> "Rhode Island";
			case '3' -> "Michigan";
			case '4' -> "Georgia";
			case '5' -> "Pennsylvania";
			case '6' -> "Illinois";
			case '7' -> "Florida";
			case '8' -> "New York";
			case '9' -> "Texas";
			default -> null;
			};

			if (state != null) {
				citizenSsnOutputBean.setCitiZenSsn(inputBean.getCitiZenSsn());
				citizenSsnOutputBean.setCitiZenState(state);
			}
		}

		CommonOutPutBean commonOutPutBean = new CommonOutPutBean();
		if (citizenSsnOutputBean != null) {
			commonOutPutBean.setSuccess(true);
			commonOutPutBean.setData(citizenSsnOutputBean);
		} else {
			commonOutPutBean.setSuccess(false);
		}
		return commonOutPutBean;
	}

}
