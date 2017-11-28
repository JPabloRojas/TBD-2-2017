package cl.citiaps.spring.backend.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Children;
import cl.citiaps.spring.backend.entities.UserTop;
import cl.citiaps.spring.backend.repository.UserTopRepository;

@CrossOrigin
@RestController
@RequestMapping("/top")
public class UserTopService {
	
	@Autowired
	private UserTopRepository usertoprepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<UserTop> getAllGames() {
		Iterable<UserTop> ut = usertoprepository.findAllByrankAsc();
		Random randomgenerator = new Random();
		for(UserTop u: ut){
			List<Children> urt = new ArrayList<>();
			List<Children> urtMain = u.getChildren();
			for(int i = 0; i < 10;i++){
				int randomInt = randomgenerator.nextInt(urtMain.size());
				urt.add(urtMain.get(randomInt));
			}
			u.setChildren(urt);
		}
		
				
		//return usertoprepository.findAllByrankAsc();
		return ut;
	}
}
