package com.pnr.project.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnr.project.entity.PnrEntity;
import com.pnr.project.repository.ItineraryRepository;
import com.pnr.project.repository.PnrRepository;
import com.pnr.project.service.PnrServiceImpl;


//@WebMvcTest(PnrRestController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PnrRestControllerTest {
	
	@Mock
	private PnrServiceImpl pnrservice;
	
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	String strDate = dateFormat.format(date);  
	
	
	
	
	
	@Autowired
	private WebApplicationContext web;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private  ObjectMapper objectMapper;
	
	List<PnrEntity> pnr ;
	
	@MockBean
	private PnrRepository pnrRepository;
	
	
	
	@MockBean
	private ItineraryRepository itineraryRepository;
	
/*	@BeforeEach
	public void setUp() throws Exception {
//	 mockMvc = MockMvcBuilders.webAppContextSetup(web).build();	
		pnrRepository.deleteAll();
		pnr = new ArrayList<>();
		this.pnr.add(new PnrEntity(1,"soumya", "nayak",1997-04-03, "8123456376","TAW/30APR", "Soumya"))
	}
*/
	@Test
	void testCreatePnrEntity() throws Exception {
		
		PnrEntity pnr = new PnrEntity();
		pnr.setFirstName("abcde");
		
		assertEquals(pnrRepository.save(pnr), null);
	}
		

	
	
	@Test
	public void testGetPnrEntity() throws Exception { 
		
		PnrEntity pnr = new PnrEntity();
		pnr.setFirstName("abcd");
		pnr.setLastName("nayak");
		assertEquals("abcd",pnr.getFirstName(),"retireve first name ");
	 	assertEquals("nayak",pnr.getLastName(),"retireve first name ");


	
	 	/*	
				List<PnrEntity> listPnrEntities = new ArrayList<>();
		listPnrEntities.add(new PnrEntity(1,"soumya", "nayak",date , "8123456376","TAW/30APR", "Soumya"));
		
		
		
		Mockito.when(pnrRepository.findAll()).thenReturn(listPnrEntities);
	   
	    String url = "/pnr/get";
	    MvcResult mvcResult =   mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
	    String actualJsonResponse = mvcResult.getResponse().getContentAsString();
	    System.out.println(actualJsonResponse);
	    String expectedJsonResponse = objectMapper.writeValueAsString(listPnrEntities);
	    
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	 */  
		
	}


	@Test
	public void testUpdatePnrEntity() throws Exception {
/*		
	PnrEntity pnr = new PnrEntity();
		pnr.setId(1);
		pnr.setFirstName("soumya");
		pnr.setLastName("nayak");
//		pnr.setDob(date);
		pnr.setContact("8123456376");
		pnr.setTimelimit("taw/30apr");
		pnr.setReceivedfrom("soumya");
		
		Mockito.when(pnrservice.updatePnrEntity(1, pnr));
		String json = objectMapper.writeValueAsString(pnr);
	      mockMvc.perform(put("/pnr/update/1")).andExpect(status().isOk());
		
		assertEquals(200,status());
*/
		PnrEntity pnr = new PnrEntity();
		pnr.setId(1);
		pnr.setFirstName("soumya");
		pnr.setLastName("nayak");
//		pnr.setDob(date);
		pnr.setContact("8123456376");
		pnr.setTimelimit("taw/30apr");
		pnr.setReceivedfrom("soumya");
		
		
		
		int id = 1;
		 MockHttpServletRequestBuilder builder =
				 MockMvcRequestBuilders.put("/pnr/update/"+id)
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 .accept(MediaType.APPLICATION_JSON)
				 .characterEncoding("UTF-8").content(getArticleInJson(1));
		 
		 this.mockMvc.perform(builder)
		 .andExpect(MockMvcResultMatchers.status().isOk())
		 .andExpect(MockMvcResultMatchers.content().string("pnrService.updatePnrEntity(1, pnr)")).andDo(MockMvcResultHandlers.print());
		 
				 
	}
	
	
	private String getArticleInJson(int id) {
	      return "{\"id\":\"" + id + "\", \"FirstName\":\"test data\" }";
	  }
		
	
		
	
	
		
	
	

		@Test
	    public void testDeletePnrEntity() throws Exception {
			
			/*	String uri = "/pnr/delete/26";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "pnr is deleted");
		
		*/
			
		//	PnrEntity existingPnr = new PnrEntity(1,"soumya","nayak",date,"8123456376","TAW/30APR", "Soumya");
	//		pnrRepository.delete(existingPnr);
	//		verify(pnrRepository,times(1)).delete(existingPnr);
			
			
	}


		/*	@Test
	public void testPnrNameMustnotbeNull() throws Exception{
		
		Date date = new Date(1997-03-04);
		
		PnrEntity pnrEntity = new PnrEntity(1,"", "nayak",date , "8123456376","TAW/30APR", "Soumya");
		
		String url = "/pnr/create";
		
		mockMvc.perform(post(url).contentType("application/json")
				.content(objectMapper.writeValueAsString(pnrEntity))).andExpect(status().isBadRequest());
		
		Mockito.verify(pnrRepository,times(0)).save(pnrEntity);
		
	}
*/	
	
	
	
	
}
