package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadServices;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadServices ls;
	
	@GetMapping
	public List<Lead> getallLead(){
		List<Lead> leads = ls.listLeads();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		ls.saveLead(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id")long id) {
		ls.deleteLead(id);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		ls.saveLead(lead);
	}
	
	@GetMapping("/leadinfo/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Lead lead = ls.getOneLead(id);
		return lead;
	}
}
