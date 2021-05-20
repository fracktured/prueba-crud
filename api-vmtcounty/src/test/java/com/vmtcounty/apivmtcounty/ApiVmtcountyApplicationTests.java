package com.vmtcounty.apivmtcounty;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmtcounty.apivmtcounty.model.VmtCounty;
import com.vmtcounty.apivmtcounty.request.DeleteRequestBody;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ApiVmtcountyApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApiVmtcountyApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
    public void testAll() throws Exception {
		this.mvc
		.perform( get("/all") )
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
    public void testFindById() throws Exception {
		this.mvc
		.perform( get("/findById/{id}", 2) )
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
    public void testFindByIdNotFound() throws Exception {
		this.mvc
		.perform( get("/findById/{id}", 999) )
		.andDo(print())
		.andExpect(status().isNotFound())
		.andReturn();
    }
	
	@Test
    public void testAdd() throws Exception {
		VmtCounty body = new VmtCounty();
		body.setId(0);
		body.setCountyFips(1000);
		body.setCountyName("prueba");
		body.setStateName("prueba");
		body.setDate(new Date());
		body.setCountyVmt(123123);
		body.setBaselineJanVmt(123);
		body.setPercentChangeFromJan(BigDecimal.valueOf(1.6));
		body.setMean7CountyVmt(BigDecimal.valueOf(123123.12));
		body.setMean7PercentChangeFromJan(BigDecimal.valueOf(20.2));
		body.setDateAtLow(new Date());
		body.setMean7CountyVmtAtLow(BigDecimal.valueOf(123000.01));
		body.setPercentChangeFromLow(BigDecimal.valueOf(17.40));
		
		this.mvc
		.perform( 
				post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(body)))
		.andExpect(status().isCreated())
		.andReturn();
    }
	
	@Test
    public void testModify() throws Exception {
		VmtCounty body = new VmtCounty();
		body.setId(5);
		body.setCountyFips(1000);
		body.setCountyName("prueba");
		body.setStateName("prueba");
		body.setDate(new Date());
		body.setCountyVmt(123123);
		body.setBaselineJanVmt(123);
		body.setPercentChangeFromJan(BigDecimal.valueOf(1.6));
		body.setMean7CountyVmt(BigDecimal.valueOf(123123.12));
		body.setMean7PercentChangeFromJan(BigDecimal.valueOf(20.2));
		body.setDateAtLow(new Date());
		body.setMean7CountyVmtAtLow(BigDecimal.valueOf(123000.01));
		body.setPercentChangeFromLow(BigDecimal.valueOf(17.40));
		
		this.mvc
		.perform(
				post("/modify")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(body)))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
    public void testDelete() throws Exception {
		DeleteRequestBody body = new DeleteRequestBody();
		body.setId(7);
		
		this.mvc
		.perform(
				post("/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(body)))
		.andExpect(status().isOk())
		.andReturn();
    }

}
