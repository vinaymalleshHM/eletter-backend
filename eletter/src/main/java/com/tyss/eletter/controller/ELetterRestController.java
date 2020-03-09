package com.tyss.eletter.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.eletter.ELetterResponse.ELetterGenericResponse;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.service.ELetterService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RequestMapping("tyss")
public class ELetterRestController {
	
	@Autowired
	private ELetterService service;
	
	
	@PostMapping(path = "/letterinformation",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register(@RequestBody LetterInfoBean letterInfoBean) {
		ELetterGenericResponse response = new ELetterGenericResponse();
		LetterInfoBean infoBean = service.addLetterInformation(letterInfoBean);
		if (infoBean!=null) {
			response.setError(false);
			response.setData("information added successfully");
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		} else {
			response.setError(true);
			response.setData("failed to add");
			return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping(path = "/information",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> search(@RequestParam(name="empid",required = true)String empId) {
		
		List<LetterInfoBean> letterInfoBeans = service.search(empId);
		
		ELetterGenericResponse response = new ELetterGenericResponse();
		if (letterInfoBeans!= null && !letterInfoBeans.isEmpty()) {
			response.setError(false);
			response.setData(letterInfoBeans);
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		} else {
			response.setError(true);
			response.setData("invalid id");
			return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	@DeleteMapping(path = "/deletebyid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteLetterInformation(@PathVariable int id) {
		
		ELetterGenericResponse response = new ELetterGenericResponse();
		if (service.deleteLetterInformation(id)) {
			response.setError(false);
			response.setData("Deleted Successfully");
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		} else {
			response.setError(true);
			response.setData("Invalid Employee Id");
			return new ResponseEntity<Object>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
