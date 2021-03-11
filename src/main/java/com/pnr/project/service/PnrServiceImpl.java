package com.pnr.project.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pnr.project.entity.Itinerary;
import com.pnr.project.entity.PnrEntity;
import com.pnr.project.globalogger.Global;
import com.pnr.project.repository.ItineraryRepository;
import com.pnr.project.repository.PnrRepository;
import com.pnr.project.vo.AddressVo;
import com.pnr.project.vo.PnrEntityVo;
import com.ssr.project.service.SsrServiceImpl;


@Service
public class PnrServiceImpl  {
	
	private Logger logger = Global.getLogger(PnrServiceImpl.class);
	
	
	private PnrRepository pnrRepository;
	private ItineraryRepository itineraryRepository;
	

	 SsrServiceImpl ssrService =new SsrServiceImpl();

	
	@Autowired
	 public PnrServiceImpl( PnrRepository theRepository, ItineraryRepository theitineraryRepository)
	 {
		 pnrRepository  = theRepository;
		 itineraryRepository = theitineraryRepository;
		 
	}
	
	@Transactional
	 public ResponseEntity<Object> createPnrEntity(PnrEntityVo pnrEntityVo){
		
		SsrServiceImpl ssrService =new SsrServiceImpl();
		
		String methodName="createPnrEntity(PnrEntityVo pnrEntityVo)";
		logger.info(methodName + "called");
		 
		 PnrEntity pnr = new PnrEntity();
		 pnr.setFirstName(pnrEntityVo.getFirstName());
		 pnr.setLastName(pnrEntityVo.getLastName());
		 pnr.setDob(pnrEntityVo.getDob());
		 pnr.setContact(pnrEntityVo.getContact());
		 pnr.setTimelimit(pnrEntityVo.getTimelimit());
		 pnr.setReceivedfrom(pnrEntityVo.getReceivedfrom());
		 
		 // add set id of address_id
		 pnr.setAddress_id(53);                                                                    //updated..
		 pnrEntityVo.getAddress().setAddress_id(53);
		 
		 Itinerary itinerary = new Itinerary();
		 itinerary.setAirlinecode(pnrEntityVo.getItinerary().getAirlinecode());
		 itinerary.setFlightno(pnrEntityVo.getItinerary().getFlightno());
		 itinerary.setClassofbooking(pnrEntityVo.getItinerary().getClassofbooking());
		 itinerary.setDateoftravel(pnrEntityVo.getItinerary().getDateoftravel());
		 itinerary.setOrigin(pnrEntityVo.getItinerary().getOrigin());
		 itinerary.setDestination(pnrEntityVo.getItinerary().getDestination());
		 itinerary.setNumberofseat(pnrEntityVo.getItinerary().getNumberofseat());
		 
		 pnr.setItinerary(itinerary);
		 
		 PnrEntity savedPnr = pnrRepository.save(pnr);
		 
		if (pnrRepository.findById(savedPnr.getId()).isPresent()) {
		
			ssrService.callCreateAddressApi(pnrEntityVo.getAddress());                                                     //updated....
		
			
			
			return ResponseEntity.ok().body("pnr creation successfully");
		}	

		return ResponseEntity.unprocessableEntity().body("Failed to create the pnr specified.");
			
	 }
	 
	
	 @Transactional
	public ResponseEntity<Object> updatePnrEntity(int id, PnrEntity pnr){
		 
		 SsrServiceImpl ssrService =new SsrServiceImpl();
		 
		 String methodName="updatePnrEntity(int id, PnrEntity pnr)";
			logger.info(methodName + "called");
		
		if (pnrRepository.findById(id).isPresent()) {
			
			PnrEntity pnrEntity = pnrRepository.findById(id).get();
			pnrEntity.setFirstName(pnr.getFirstName());
			pnrEntity.setLastName(pnr.getLastName());
			pnrEntity.setDob(pnr.getDob());
			pnrEntity.setContact(pnr.getContact());
			pnrEntity.setTimelimit(pnr.getTimelimit());
			pnrEntity.setReceivedfrom(pnr.getReceivedfrom());
		//	pnrEntity.setAddress_id(pnr.getAddress_id());                  //updated..
			
		
			Itinerary itinerary = itineraryRepository.findById(pnrEntity.getItinerary().getId()).get();
			itinerary.setAirlinecode(pnrEntity.getItinerary().getAirlinecode());
			itinerary.setFlightno(pnrEntity.getItinerary().getFlightno());
			itinerary.setClassofbooking(pnrEntity.getItinerary().getClassofbooking());
			itinerary.setDateoftravel(pnrEntity.getItinerary().getDateoftravel());
			itinerary.setOrigin(pnrEntity.getItinerary().getOrigin());
			itinerary.setDestination(pnrEntity.getItinerary().getDestination());
			itinerary.setNumberofseat(pnrEntity.getItinerary().getNumberofseat());
			
			Itinerary savedItinerary = itineraryRepository.save(itinerary);
			pnrEntity.setItinerary(savedItinerary);
			
/*			Address address = customerRepository.findById(pnrEntity.getAddress().getId()).get();
			address.setSegmentNo(pnrEntity.getAddress().getSegmentNo());
			address.setDestination(pnrEntity.getAddress().getDestination());
			address.setCountryCode(pnrEntity.getAddress().getCountryCode());
			address.setStreetNo(pnrEntity.getAddress().getStreetNo());
			address.setCountry(pnrEntity.getAddress().getCountry());
			address.setZipcode(pnrEntity.getAddress().getZipcode());
			address.setPassengerNo(pnrEntity.getAddress().getPassengerNo());
*/			
			
			ssrService.callUpdateAddressApi();                                                        //updated
			
			PnrEntity savedpnrEntity= pnrRepository.save(pnrEntity);
			
			if(pnrRepository.findById(savedpnrEntity.getId()).isPresent()) {
				ssrService.callUpdateAddressApi();
				return ResponseEntity.ok().body("successfully updated pnr");
			}
			
			 else 
				 return ResponseEntity.unprocessableEntity().body("Failed to update the specified pnr");
			
			
		}
		
		else return ResponseEntity.unprocessableEntity().body("The specified pnr is not found");
	}
	 
	 
/*
	 @Transactional
	 public ResponseEntity<Object> findAll(){
		 SsrServiceImpl ssrService =new SsrServiceImpl();
		 
		if (pnrRepository.findAll().isEmpty()) {
			
			PnrEntity pnrEntity =new PnrEntity();
			pnrEntity.getFirstName();
			pnrEntity.getLastName();
			pnrEntity.getDob();
			pnrEntity.getContact();
			pnrEntity.getTimelimit();
			pnrEntity.getReceivedfrom();
			
			
			
			
		} 
		 
	 }
	*/
	

}











