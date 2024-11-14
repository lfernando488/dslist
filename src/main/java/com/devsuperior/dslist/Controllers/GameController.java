package com.devsuperior.dslist.Controllers;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.Entities.Game;
import com.devsuperior.dslist.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = null;
        try {
            result = gameService.findById(id);
        } catch (Exception e) {
            return new GameDTO();
        }
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<Game> result = gameService.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
