package com.ssa.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.bean.CitizenSsnInputBean;
import com.ssa.common.CommonOutPutBean;
import com.ssa.service.CitizenSsnService;

@RestController
@RequestMapping("/ssn")
public class CitizenSsnRestController {
	
	@Autowired
	private CitizenSsnService citizenSsnService;
	
	@PostMapping(value = "/findStateBySsnNumber", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<CommonOutPutBean> findStateBySsnNumber(@RequestBody CitizenSsnInputBean citizenSsnInputBean) {
		 System.out.println("Request from service: " + citizenSsnInputBean);
		CommonOutPutBean findStateBySsnNumber = citizenSsnService.findStateBySsnNumber(citizenSsnInputBean);
	    System.out.println("Response from service: " + findStateBySsnNumber);
	    return new ResponseEntity<>(findStateBySsnNumber, HttpStatus.OK);
	}


}
