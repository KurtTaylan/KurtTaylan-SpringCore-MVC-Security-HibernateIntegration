package com.taylan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taylan.model.People;
import com.taylan.service.MessageService;
import com.taylan.service.PeopleService;


/*
 * 
 *  	Author Taylan Kurt  taylankurt@gmail.com
 */

@Controller
public class HomePageController {

	private PeopleService peopleService;
	private MessageService messageService;

	
//	@RequestMapping(value = "/editpage", method = RequestMethod.GET)
//	public String listtPersons(@ModelAttribute("person"),Model model) {
//		
//		
//		model.addAttribute("people", new People());
//		model.addAttribute("listPeople", this.peopleService.listPeople());
//		return "editpage";
//	}
	
	@RequestMapping(value = "/editpage", method = RequestMethod.POST)
	public String listPersons(Model model) {
		model.addAttribute("people", new People());
		model.addAttribute("listPeople", this.peopleService.listPeople());
		return "editpage";
	}

	// For add and update person both
	@RequestMapping(value = "/editpage/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("people") People people) {

		if (people.getId() == 0) {
			// new person, add it
			this.peopleService.savePeople(people);
		} else {
			// existing person, call update
			this.peopleService.updatePeople(people);
		}

		return "redirect:/editpage";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.peopleService.deletePeople(this.peopleService.getPeopleById(id));
		return "redirect:/editpage";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("people", this.peopleService.getPeopleById(id));
		model.addAttribute("listPeople", this.peopleService.listPeople());
		
		return "redirect:/editpage";
	}

	public PeopleService getPeopleService() {
		return peopleService;
	}

	@Autowired(required = true)
	@Qualifier(value = "peopleService")
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	@Autowired(required = true)
	@Qualifier(value = "messageService")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
