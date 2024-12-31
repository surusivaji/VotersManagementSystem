package org.siva.crud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.siva.crud.model.Voter;
import org.siva.crud.service.IVoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	public IVoterService voterService;
	
	@RequestMapping("/")
	public String indexPage(HttpSession session) {
		List<Voter> voters = voterService.getAllVoters();
		session.setAttribute("voters", voters);
		return "Dashboard";
	}
	
	@RequestMapping(value="/saveVoterInformation", method=RequestMethod.POST)
	public String saveVoterInformation(HttpSession session, @ModelAttribute Voter voter) {
		Voter save = voterService.addVoter(voter);
		System.out.println(save);
		if (save!=null) {
			session.setAttribute("successMsg", "Voter added successfully");
			return "redirect:/";
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			return "redirect:/";
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/editVoter/{id}")
	public String getVoterInformation(HttpSession session, @PathVariable("id") int id) {
		Voter voter = voterService.getVoterById(id);
		if (voter!=null) {
			List<Voter> voters = (List<Voter>) session.getAttribute("voters");
			session.setAttribute("voters", voters);
			session.setAttribute("voter", voter);
			return "EditVoter";
		}
		else {
			session.setAttribute("failMsg", "Id is not present");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/updateVoterInformation", method=RequestMethod.POST)
	public String updateVoterInformation(HttpSession session, @ModelAttribute Voter voter) {
		Voter addVoter = voterService.addVoter(voter);
		if (addVoter!=null) {
			session.setAttribute("successMsg", "voter updated successfully");
			return "redirect:/";
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			return "redirect:/";
		}
	}
	
	@RequestMapping("removeVoter/{id}")
	public String removeVoter(@PathVariable("id") int id) {
		voterService.removeVoter(id);
		return "redirect:/";
	}

	
	

}
