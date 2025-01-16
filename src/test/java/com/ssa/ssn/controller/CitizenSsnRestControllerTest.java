package com.ssa.ssn.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssa.bean.CitizenSsnInputBean;
import com.ssa.bean.CitizenSsnOutputBean;
import com.ssa.common.CommonOutPutBean;
import com.ssa.rest.controller.CitizenSsnRestController;
import com.ssa.service.CitizenSsnService;

@WebMvcTest(CitizenSsnRestController.class)
public class CitizenSsnRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	public CitizenSsnService citizenSsnService;

	private CitizenSsnInputBean citizenSsnInputBean;
	private CitizenSsnOutputBean citizenSsnOutputBean;
	private CommonOutPutBean commonOutPutBean;

	@BeforeEach
	public void setUp() {
		citizenSsnInputBean = new CitizenSsnInputBean();
		// Setup test data
		citizenSsnInputBean.setCitiZenName("Sejal");
		citizenSsnInputBean.setCitiZenDob("26-Sep-1996");
		citizenSsnInputBean.setCitiZenSsn("123-45-6789");

		citizenSsnOutputBean = new CitizenSsnOutputBean();
		citizenSsnOutputBean.setCitiZenSsn(citizenSsnInputBean.getCitiZenSsn());
		citizenSsnOutputBean.setCitiZenState("California");

		commonOutPutBean = new CommonOutPutBean();
		commonOutPutBean.setRefId("SSA-1737051313482");
		commonOutPutBean.setSuccess(true);
		commonOutPutBean.setDisplayMsg(null);
		commonOutPutBean.setData(citizenSsnOutputBean);
	}

	@Test
	public void findStateBySsnNumber() throws Exception {
//		when(citizenSsnService.findStateBySsnNumber(Mockito.any(CitizenSsnInputBean.class)))
//        .thenReturn(commonOutPutBean);
		when(citizenSsnService.findStateBySsnNumber(citizenSsnInputBean))
      .thenReturn(commonOutPutBean);
		


		String writeValueAsString = new ObjectMapper().writeValueAsString(citizenSsnInputBean);
		
				mockMvc.perform(post("/ssa/ssn/findStateBySsnNumber")
						.contentType(MediaType.APPLICATION_JSON)
						.content(writeValueAsString))
				.andExpect(status().isOk())
                .andExpect(jsonPath("$.refId").value("SSA-1737051313482"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.citiZenSsn").value("123-45-6789"))
                .andExpect(jsonPath("$.data.citiZenState").value("California"));
	}

}
