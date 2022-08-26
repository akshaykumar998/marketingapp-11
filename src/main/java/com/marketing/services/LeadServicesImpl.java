package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepo;

@Service
public class LeadServicesImpl implements LeadServices {

	@Autowired
	private LeadRepo leadrpo;
	
	@Override
	public void saveLead(Lead lead) {
		leadrpo.save(lead);
	}

	@Override
	public List<Lead> listLeads() {
		List<Lead> leads = leadrpo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
		leadrpo.deleteById(id);
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> fbi = leadrpo.findById(id);
		Lead lead = fbi.get();
		return lead;
	}

}
