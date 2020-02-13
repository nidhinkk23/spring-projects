package com.tyss.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springrest.dto.EmployeeInfoBean;
import com.tyss.springrest.dto.EmployeeResponse;
import com.tyss.springrest.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse search(@RequestParam(name="name",required = false)String name) {
		List<EmployeeInfoBean> beans = service.search(name);
		EmployeeResponse response = new EmployeeResponse();
		if(beans!=null && !beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Found in DB foe the requested name");
			response.setBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not Found in DB foe the requested name");
//			response.setBeans(null);
		}
		return response;
	}
	
	@PostMapping(path = "/register",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse register(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data inserted in to DB ");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data is not inserted in to DB ");
		}
		return response;
	}
	
	
	
	
	@PostMapping(path = "/auth",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE
			)
	public EmployeeResponse auth(@RequestBody EmployeeInfoBean bean) {
		
		EmployeeInfoBean infoBean = service.auth(bean.getEmail(), bean.getPassword());
		EmployeeResponse response = new EmployeeResponse();
		if(infoBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Valid Credential ");
			response.setBeans(Arrays.asList(infoBean));//create a list and return it
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("InValid Credential");
		}
		return response;
	}
	
	
	
	@PostMapping(path = "/change-password",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE
			)
	public EmployeeResponse changePassword(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.changePassword(bean.getId(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("password is changed and updated in to DB ");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("password is not changed");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id")int id) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.deleteEmployee(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Deleted successfully from DB ");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("not Deleted");
		}
		return response;
		
	}
	
	
	
}
