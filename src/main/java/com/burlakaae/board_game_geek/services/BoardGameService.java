package com.burlakaae.board_game_geek.services;

import com.burlakaae.board_game_geek.dao.BoardGameDao;
import com.burlakaae.board_game_geek.models.BoardGame;

public class BoardGameService {

    private BoardGameDao boardGameDao = new BoardGameDao();

    public BoardGameService() {
        }

        public BoardGame getName(int id) {
            return boardGameDao.;
        }

    }
}
