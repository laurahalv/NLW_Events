package br.com.nwl.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nwl.events.model.Event;
import br.com.nwl.events.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	@PostMapping("/events")
	public Event addNewEvent(@RequestBody Event newEvent) {
		return service.addNewEvent(newEvent);
	}
	@GetMapping("/events")
	public List<Event> getAllEvents(){
		return service.getAllEvents();
	}
	
	@GetMapping("/events/{prettyName}")
	public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName) {
		Event evt =service.getByPrettyName(prettyName); 
		if (evt != null) {
			return ResponseEntity.ok().body(evt);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}	
