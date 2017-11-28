package cl.citiaps.spring.backend.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Keywords;
import cl.citiaps.spring.backend.repository.KeywordsRepository;

@CrossOrigin
@RestController
@RequestMapping("/keywords")
public class KeywordsService {
	
	@Autowired
	private KeywordsRepository keywordsrepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Keywords> getAllKeywords(){
		return keywordsrepository.findAll();
	}
	
	
	/*@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void addKeywords(@RequestBody Map<String, Object> word){
		for(Map.Entry<String, Object> entry : word.entrySet()){
			Keywords keyword = new Keywords();
			keyword.setKeyword(entry.getValue().toString());
			keywordsrepository.save(keyword);
		}
	}*/
	
	@RequestMapping(value="/add/{keyword}", method = RequestMethod.POST)
	@ResponseBody
	public void addKeyword(@PathVariable("keyword") String keyword){
		Keywords keywordC = new Keywords();
		keywordC.setKeyword(keyword);
		keywordsrepository.save(keywordC);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Keywords create(@RequestBody Keywords resource) {
	     return keywordsrepository.save(resource);
	}
}
