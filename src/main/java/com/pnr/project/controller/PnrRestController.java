package com.pnr.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnr.project.entity.PnrEntity;
import com.pnr.project.globalogger.Global;
import com.pnr.project.repository.PnrRepository;
import com.pnr.project.service.PnrServiceImpl;
import com.pnr.project.vo.PnrEntityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/pnr")
@Api(value="PNR Creation", description="PNR Creation")
public class PnrRestController {
	
	private  Logger logger = Global.getLogger(PnrRestController.class);
	
	
	private PnrServiceImpl pnrService;
	private PnrRepository pnrRepository;
	
	public PnrRestController(PnrServiceImpl thepnrService , PnrRepository thepnrRepository) {
		
		pnrService = thepnrService;
		pnrRepository = thepnrRepository;
	}
	
	
	@ApiOperation(value = "Create PNR in the System ")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@PostMapping("/create")
	public ResponseEntity<Object> createPnrEntity(@RequestBody PnrEntityVo pnrEntityVo){
		
		String methodName="createPnrEntity(@Valid @RequestBody PnrEntityVo pnrEntityVo))";
		logger.info(methodName + "called");
		
		return pnrService.createPnrEntity(pnrEntityVo);
			
	}
	
	@ApiOperation(value = "View a list of PNR",response = Iterable.class)
	@GetMapping("/get")
	public List<PnrEntity> getPnrEntity(){
		String methodName="getPnrEntity()";
		logger.info(methodName + "called");
		
		return pnrRepository.findAll();
	}

	@ApiOperation(value = "Search a PNR with an ID",response = PnrEntity.class)
	@GetMapping("/get/{id}")
	public PnrEntity getPnrEntity(@PathVariable int id) {
		
		String methodName="getPnrEntity(@PathVariable int id)";
		logger.info(methodName + "called");
		
		if(pnrRepository.findById(id).isPresent())
			return pnrRepository.findById(id).get();
		else 
			return null;
	}
	
	
	 @ApiOperation(value = "Update a PNR")
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePnrEntity(@PathVariable int id, @RequestBody PnrEntity pnr){
		
		String methodName="updatePnrEntity(@PathVariable int id, @RequestBody PnrEntityVo pnrVo)";
		logger.info(methodName + "called");
		
		 return pnrService.updatePnrEntity(id, pnr);
	}
	
	
	 @ApiOperation(value = "Delete a PNR")
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Object> deletePnrEntity(@PathVariable int id){
		 
		 String methodName="deletePnrEntity(@PathVariable int id)";
			logger.info(methodName + "called");
		 
		 if(pnrRepository.findById(id).isPresent()) {
			 pnrRepository.deleteById(id);
			 if (pnrRepository.findById(id).isPresent())
				 return ResponseEntity.unprocessableEntity().body("Failed to delete the specified PNR");
			 else return ResponseEntity.ok("Successfully deleted the specified PNR");
		 }
		 
		 else return ResponseEntity.unprocessableEntity().body("Specified PNR not present");
	 }
}





