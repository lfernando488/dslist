package com.devsuperior.dslist.Services;
import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.Entities.Game;
import com.devsuperior.dslist.Projections.GameMinProjection;
import com.devsuperior.dslist.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //Indica que nao será feita uma operação de escrita, nao irá prender a base
    public GameDTO findById(Long id) throws Exception {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<Game> findAll(){
        List<Game>result = gameRepository.findAll();
        return  result;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map( x-> new GameMinDTO(x)).toList();
    }

}
