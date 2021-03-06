package model;

import java.util.ArrayList;

/**
 * The fourth bet's round, the turn allow to all players to call, fold, raise or
 * allIn. All players owns two cards and the board shows four cards.
 *
 * @author esiProfs
 */
class Turn extends AbstrState {

    /**
     * The fourth state of a poker match is the preflop.
     *
     * @param match ongoing match
     */
    Turn(Match match) {
       
        this.match = match;
        availableBet = new ArrayList<>();
        availableBet.add(Bet.CALL);
        availableBet.add(Bet.FOLD);
        availableBet.add(Bet.RAISE);
        availableBet.add(Bet.CHECK);
    }

    @Override
    public void nextState() throws GameException {
        if (match.onlyOne()) {
            match.splitPot();
            
            match.end();
        }else if (match.allAllIn()){
            match.showBoard();
            match.setState(match.getRiver());
            match.dealBoard(1);
        } else if (match.hasNext()) {
            match.nextPlayer();
        } else {
//            
            match.setBetIterator();
            match.showBoard();
            match.setState(match.getRiver());
            match.dealBoard(1);
            match.nextPlayer();
            match.setMinimum(0);

        }
    }

    @Override
    public void smallBlind(Player currentPlayer, int minimum, int amount, Pots pot) throws GameException {
        throw new GameException("smallBlind Impossible");
    }

    @Override
    public void bigBlind(Player currentPlayer, int minimum, int amount, Pots pot) throws GameException {
        throw new GameException("bigBlind Impossible");
    }

    
}
