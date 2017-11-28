package cl.citiaps.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import cl.citiaps.spring.backend.entities.Children;
import cl.citiaps.spring.backend.repository.ChildrenRepository;

@CrossOrigin
@RestController
@RequestMapping("/retop")
public class ChildrenService {
	
	@Autowired
	private ChildrenRepository userretoprepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Children> getAllGames() {
		return userretoprepository.findAll();
	}
}
