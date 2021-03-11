package com.ssr.project.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pnr.project.vo.AddressVo;
import com.pnr.project.vo.PnrEntityVo;


public class SsrServiceImpl   {
	
	
	RestTemplate restTemplate = new RestTemplate() ;
	
	private static final String GET_ALL_ADDRESS_API1 = "http://localhost:8081/ssr/doca";
	private static final String GET_ADDRESS_BY_ID = "http://localhost:8081/ssr/doca/{docaId}";
	private static final String CREATE_ADDRESS_API = "http://localhost:8081/ssr/doca";
	private static final String UPDATE_ADDRESS = "http://localhost:8081/ssr/doca";
	private static final String DELETE_ADDRESS = "http://localhost:8081/ssr/doca/{docaId}";
	
	
	public void callGetAllusersApi() {
		RestTemplate restTemplate = new RestTemplate() ;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
		ResponseEntity<String> result  = restTemplate.exchange(GET_ALL_ADDRESS_API1,HttpMethod.GET, entity, String.class);
		System.out.println(result);
		
	}
	
	
   public void callGetAddressById() {
	   RestTemplate restTemplate = new RestTemplate() ;
	   
		Map<String, Integer> param = new HashMap<>();
		param.put("docaId",42);
		
		AddressVo address = restTemplate.getForObject(GET_ADDRESS_BY_ID,AddressVo.class,param);
		System.out.println(address.getId());
		System.out.println(address.getSegmentNo());
		System.out.println(address.getDestination());
		System.out.println(address.getCountryCode());
		System.out.println(address.getCountryCode());
		System.out.println(address.getStreetNo());
		System.out.println(address.getZipcode());
		System.out.println(address.getPassengerNo());
		
	}
	
	public void callCreateAddressApi(AddressVo  addressVo) {
		
		RestTemplate restTemplate = new RestTemplate() ;
		
		
		AddressVo address = new AddressVo(addressVo.getId(),addressVo.getSegmentNo(),addressVo.getDestination(),addressVo.getCountryCode()
				,addressVo.getStreetNo(),addressVo.getCountry(),addressVo.getZipcode(),addressVo.getPassengerNo()
				,addressVo.getAddress_id());
		
		ResponseEntity<AddressVo> address2 =restTemplate.postForEntity(CREATE_ADDRESS_API, address, AddressVo.class);
		System.out.println(address2.getBody());
		System.out.println("Address created ...");
		
	}
	
	public  void callUpdateAddressApi() {
		
		RestTemplate restTemplate = new RestTemplate() ;
		
		Map<String, Integer> param = new HashMap<>();
		param.put("docaId",42);
		AddressVo updateaddress = new AddressVo(1,3,"F","BG","11upstreet","india","h81832","1.1",0);
		restTemplate.put(UPDATE_ADDRESS, updateaddress, param);
		System.out.println("Address updated ....");
		
	}
	
	public void callDeleteAddressApi() {
		
		RestTemplate restTemplate = new RestTemplate() ;
		
		Map<String, Integer> param = new HashMap<>();
		param.put("docaId", 42);
		restTemplate.delete(DELETE_ADDRESS,param);
		System.out.println("Address deleted ...");
		
	}
	
	
	


}
