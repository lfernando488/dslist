package com.devsuperior.dslist.DTO;

import com.devsuperior.dslist.Entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){
    }

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    //Se nao usar o beanutils pode gerar so os getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
