package model;

import java.util.ArrayList;

/**
 * The third bet's round, the flop allow to all players to call, fold, raise or
 * allIn. All players owns two cards and the board shows three cards.
 *
 * @author esiProfs
 */
public class Flop extends AbstrState {

    /**
     * The third state of a poker match is the Flop.
     *
     * @param match ongoing match
     */
    public Flop(Match match) {
        this.match = match;
        availableBet = new ArrayList<>();
        availableBet.add(Bet.CHECK);
        availableBet.add(Bet.CALL);
        availableBet.add(Bet.FOLD);
        availableBet.add(Bet.RAISE);

    }

    @Override
    public void nextState() throws GameException {
        if (match.onlyOne()) {
            match.splitPot();
            match.end();
        } else if (match.allAllIn()) {
match.setState(match.getTurn());
            match.dealBoard(1);
            match.setState(match.getRiver());
            match.dealBoard(1);
            match.showDown();
            match.splitPot();
            
            match.end();
        } else if (match.hasNext()) {
            match.nextPlayer();

        } else {
            this.addPot();
            match.setState(match.getTurn());
            match.setBetIterator();
            match.showBoard();
            match.dealBoard(1);
            match.nextPlayer();
            match.setMinimum(0);
        }
    }



}
