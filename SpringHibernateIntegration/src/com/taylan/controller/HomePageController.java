package com.taylan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taylan.service.MessageService;
import com.taylan.service.PeopleService;

@Controller
public class HomePageController {
	
	private PeopleService peopleService;
	private MessageService messageService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {

		ModelAndView model = new ModelAndView("index");
		return model;

	}

	@RequestMapping(value = "/viewpage", method = RequestMethod.POST)
	public ModelAndView postViewPeople() {

		ModelAndView model = new ModelAndView("viewpage");
		return model;

	}

	@RequestMapping(value = "/viewpage", method = RequestMethod.GET)
	public ModelAndView getViewPeople() {

		ModelAndView model = new ModelAndView("viewpage");
		return model;

	}

	@RequestMapping(value = "/editpage", method = RequestMethod.POST)
	public ModelAndView postEditPeople() {

		ModelAndView model = new ModelAndView("editpage");
		return model;

	}

	@RequestMapping(value = "/editpage", method = RequestMethod.GET)
	public ModelAndView getEditPeople() {

		ModelAndView model = new ModelAndView("editpage");
		return model;

	}

	public PeopleService getPeopleService() {
		return peopleService;
	}

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
