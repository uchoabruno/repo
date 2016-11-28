package com.bctc.kalah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bctc.kalah.model.House;
import com.bctc.kalah.model.impl.Board;
import com.bctc.kalah.service.BoardService;

@Controller
public class KalahBoardController {
	
	private Board board;
	@Autowired
	private BoardService boardService;

	public void setUp() {
		board = new Board(6);
	}

    @RequestMapping("/kalahBoard")
    public ModelAndView kalahBoard() {
    	setUp();
    	ModelAndView mav = new ModelAndView("kalahBoard");
    	House[] houses = board.getHouses();
    	
    	mav.addObject("kalahBoard", board);
    	mav.addObject("houses", houses);
    	mav.addObject("currentPlayer", board.getCurrentPlayer());

    	mav.addObject("totalStones", boardService.getTotalBoardStones(board));

    	return mav;
    }

    @RequestMapping("/moveStones/{index}")
    public ModelAndView moveStones(@PathVariable int index) {
    	ModelAndView mav = new ModelAndView("kalahBoard");
    	House[] houses = board.getHouses();
    	
    	mav.addObject("errorMessage", null);
    	if (boardService.pitHasStonesAvailable(houses[index])) {
    		if (boardService.playerCanMoveStonesFromPit(houses[index], board.getCurrentPlayer())) {
    			boardService.moveStonesFromSelectedPitAndReturnNextPlayer(board, index);
    		} else {
    			mav.addObject("errorMessage", "This pit doesn't belong to you. Choose one of yours.");
    		}
    	} else {
    		mav.addObject("errorMessage", "This pit doesn't have available stones to move. Please choose another.");
    	}

    	mav.addObject("currentPlayer", board.getCurrentPlayer());
    	mav.addObject("kalahBoard", board);
    	mav.addObject("houses", houses);
    	mav.addObject("availableMessage", boardService.getAvailabilityMessage(board));
    	mav.addObject("totalStones", boardService.getTotalBoardStones(board));
        return mav;
    }

    @RequestMapping("/verifyWinner")
    public ModelAndView verifyWinner() {
    	ModelAndView mav = new ModelAndView("kalahBoard");
    	House[] houses = board.getHouses();

    	mav.addObject("gameOverMessage", boardService.getWinnerMessage(board));

    	mav.addObject("currentPlayer", board.getCurrentPlayer());
    	mav.addObject("kalahBoard", board);
    	mav.addObject("houses", houses);
    	mav.addObject("availableMessage", boardService.getAvailabilityMessage(board));
    	mav.addObject("totalStones", boardService.getTotalBoardStones(board));
    	return mav;
    }
}