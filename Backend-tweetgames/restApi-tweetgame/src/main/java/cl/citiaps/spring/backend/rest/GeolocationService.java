package cl.citiaps.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Geolocation;
import cl.citiaps.spring.backend.repository.GeolocationRepository;

@CrossOrigin
@RestController
@RequestMapping("/locations")
public class GeolocationService {

	@Autowired
	private GeolocationRepository geolocationrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Geolocation> getAlllocations(){
		return geolocationrepository.findAll();
	}
	
	
	
}
