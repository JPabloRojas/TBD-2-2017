package cl.citiaps.spring.backend.rest;

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


import cl.citiaps.spring.backend.entities.Game;
import cl.citiaps.spring.backend.entities.GameResume;
import cl.citiaps.spring.backend.repository.GameRepository;

@CrossOrigin
@RestController
@RequestMapping("/games")
public class GameService {
	
	@Autowired
	private GameRepository gamerepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Game> getAllGames() {
		return gamerepository.findAll();
	}
	
	@RequestMapping(value = "/new/{nombre}/{desarrollador}/{fecha}/{genero}", method = RequestMethod.POST)
	@ResponseBody
	public void createGame(@PathVariable("nombre") String nombre, @PathVariable("desarrollador") String desarrollador, @PathVariable String fecha, @PathVariable String genero){
		Game game = new Game();
		game.setGame_name(nombre);
		game.setDesarrollador(desarrollador);
		String time = fecha +" 00:00:00";
		java.sql.Timestamp ts = java.sql.Timestamp.valueOf(time);
		game.setFecha_lanzamiento(ts);
		game.setGenero(genero);
		gamerepository.save(game);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Game create(@RequestBody Game resource) {
	     return gamerepository.save(resource);
	}
}
