package com.tyss.eletter.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.tyss.eletter.ELetterResponse.ELetterHRResponse;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.service.ELetterService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RequestMapping("tyss")
public class ELetterRestController {
	
	@Autowired
	private ELetterService service;
	
	@PostMapping(path = "/letterinformation",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ELetterGenericResponse register(@Valid @RequestBody LetterInfoBean letterInfoBean) {
		ELetterGenericResponse response = new ELetterGenericResponse();
		if (service.addLetterInformation(letterInfoBean)) {
			response.setStatus(201);
			response.setMessage("Succuss");
			response.setDescription("letter information added succussfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("letter information Couldn't added");
		}
		return response;
		
	}

	
	
	@GetMapping(path = "/information",produces = MediaType.APPLICATION_JSON_VALUE)
	public ELetterHRResponse search(@RequestParam(name="empid",required = true)String empId) {
		
		List<LetterInfoBean> letterInfoBeans = service.search(empId);
		
		ELetterHRResponse response = new ELetterHRResponse();
		
		if (letterInfoBeans!= null && !letterInfoBeans.isEmpty()) {
			response.setStatus(201);
			response.setMessage("Succuss");
			response.setDescription("Data Found");
			response.setLetterInfoBeans(letterInfoBeans);
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Couldn't found the data");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete/{empId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ELetterGenericResponse deleteLetterInformation(@PathVariable String empId) {
		
		ELetterGenericResponse response = new ELetterGenericResponse();
		
		if (service.deleteLetterInformation(empId)) {
			response.setStatus(201);
			response.setMessage("Succuss");
			response.setDescription("deleted SccussFully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Couldn't deleted");
		}
		return response;
	}
	
	@DeleteMapping(path = "/deletebyid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ELetterGenericResponse deleteLetterInformation(@PathVariable int id) {
		
		ELetterGenericResponse response = new ELetterGenericResponse();
		
		if (service.deleteLetterInformation(id)) {
			response.setStatus(201);
			response.setMessage("Succuss");
			response.setDescription("deleted SccussFully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Couldn't deleted");
		}
		return response;
	}
	
}
