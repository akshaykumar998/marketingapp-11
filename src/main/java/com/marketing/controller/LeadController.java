package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dtoo.Leaddata;
import com.marketing.entities.Lead;
import com.marketing.services.LeadServices;

@Controller
public class LeadController {
	
	@Autowired
	private LeadServices ls;
	
	@RequestMapping("/createLead") //Acts like WebServlet
	public String viewCreateLeadPage() {
		return "create_lead"; // Acts like RequestDispatcher
	}
	
	@RequestMapping("/saveLead")
	public String saveoneLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
		ls.saveLead(lead);
		model.addAttribute("msg", "Record saved");
		return "create_lead";
	}
	
	@RequestMapping("/listall")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = ls.listLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, ModelMap model) {
		ls.deleteLead(id);
		List<Lead> leads = ls.listLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
		Lead oneLead = ls.getOneLead(id);
		model.addAttribute("leads", oneLead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateSLead(Leaddata data, ModelMap model) {
		Lead lead = new Lead();
		lead.setId(data.getId());
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		
		ls.saveLead(lead);
		
		List<Lead> leads = ls.listLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
}
