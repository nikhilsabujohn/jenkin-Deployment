package com.ty.Springboot.RestAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controller {
	
	@Autowired
	private Services services;
	
	@GetMapping("/nik")
	public String nik()
	{
		return "u got it maga";
	}

	@GetMapping("/smartphones")
	public ResponseEntity<List<SmartPhones>> getAllPhones()
	{
		List<SmartPhones>l1=this.services.getAllPhones();
		if(l1.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(l1));
	}
	
	@GetMapping("/smartphones/{id}")
	public ResponseEntity<SmartPhones> getPhonesById(@PathVariable("id") int id)
	{
		SmartPhones phones=this.services.getPhonesByID(id);
		if(phones!=null)
		{
			return ResponseEntity.of(Optional.of(phones));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PostMapping("/smartphones")
	public SmartPhones addPhone(@RequestBody SmartPhones phone) {
		services.addPhone(phone);
		return phone;
	}
	
	@DeleteMapping("/smartphones/{id}")
	public ResponseEntity<String> deletePhone(@PathVariable("id") int id)
	{
		boolean flag=services.deletePhone(id);
		if(flag!=true)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("data deleted");
	}
	
	@PutMapping("/smartphones/{id}")
	public ResponseEntity<String> putMethodName(@PathVariable("id") int id, @RequestBody SmartPhones phones) 
	{
		SmartPhones phones2=services.updatePhone(phones, id);
		if(phones2!=null)
		{
			return ResponseEntity.ok("Data Updated");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data not found");
	}
	
	
	
	

}
