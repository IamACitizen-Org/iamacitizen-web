package com.iamacitezen.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamacitezen.model.impl.Announcement;
import com.iamacitezen.service.api.IAnnouncementService;

@Controller
@RequestMapping("/announcements")
public class AnnouncementsController {

	@Autowired
	private IAnnouncementService announcementService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Announcement>> getAnnouncements() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<List<Announcement>>(
				announcementService.findAll(), responseHeaders,
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/announcement", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Announcement addAnnouncement(@RequestBody Announcement announcement) {
		return announcementService.insert(announcement);
	}
}
