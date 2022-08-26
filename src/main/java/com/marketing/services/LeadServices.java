package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadServices {
	public void saveLead(Lead lead);
	public List<Lead> listLeads();
	public void deleteLead(long id);
	public Lead getOneLead(long id);
}
