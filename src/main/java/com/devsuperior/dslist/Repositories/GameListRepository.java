package com.devsuperior.dslist.Repositories;

import com.devsuperior.dslist.Entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
