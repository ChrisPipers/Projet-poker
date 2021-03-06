package model;

import model.observer.Observer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static model.Status.BLIND;
import static model.Status.END_GAME;
import static model.Status.END_MATCH;
import static model.Status.FLOP;
import static model.Status.INIT;
import static model.Status.PREFLOP;
import static model.Status.RIVER;
import static model.Status.TURN;
import model.cards.Card;
import model.observer.Observable;

/**
 * The main class of the poker game.
 *
 * @author esiProfs
 */
public class Game implements Observable, Facade {
    
    private final int valorBounty;
    private int bountyInGame;
    private final List<Observer> listObserver;
    private final static int NB_MIN = 4;
    private Match match;
    private final List<Player> players;
    private Status status;

    /**
     * Main class of the poker game. It instanciates the list of players and set
     * the game's statut to INIT
     */
    public Game() {
        players = new ArrayList<>();
        status = INIT;
        listObserver = new ArrayList<>();
        this.valorBounty = 5;
        this.bountyInGame = 0;
    }
    
    @Override
    public void start() throws GameException {
        if (players.size() < NB_MIN) {
            throw new IllegalArgumentException("Il manque des joueurs");
        }
        startMatch();
    }
    
    @Override
    public void startMatch() throws GameException {
        
        if (match != null && !match.isOver()) {
            throw new GameException("Vous devez terminer le match en cours");
        }
        int indexNextButton = 0;
        Player player;
        for (int index = 0; index < players.size(); index++) {
            player = players.get(index);
            player.initializeMatch();
            if (player.hasButton()) {
                indexNextButton = (indexNextButton + 1) % players.size();
            }
        }
        
        players.get(indexNextButton).giveButtton();
        this.match = new Match(players);
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void addPlayer(String name, int money, double bounty) {
        Player player = new Player(name, money, bounty);
        players.add(player);
        notifyChange();
    }
    
    @Override
    public void smallBlind(int amount) throws GameException {
        match.smallBlind(amount);
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void bigBlind(int amount) throws GameException {
        match.bigBlind(amount);
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void check() throws GameException {
        match.check();
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void call() throws GameException {
        match.call();
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void allIn() throws GameException {
        this.bountyInGame += 1;
//        match.setBounty();
        match.allIn();
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void fold() throws GameException {
        match.fold();
        updateSatus();
        notifyChange();
    }
    
    @Override
    public void raise(int amount) throws GameException {
        match.raise(amount);
        updateSatus();
        notifyChange();
    }
    
    @Override
    public List<Card> getBoard() {
        return match.getBoard();
    }
    
    @Override
    public List<Card> getCards() {
        return match.getCards();
    }
    
    @Override
    public Player getCurrentPlayer() {
        return match.getCurrentPlayer();
    }
    
    @Override
    public List<Bet> getAvailable() {
        return match.getAvailable();
    }
    
    @Override
    public int getBounty() {
        return match.getBounty();
    }
    
    @Override
    public int getPot() {
        return match.getPot();
    }
    
    @Override
    public int getMinimium() {
        return match.getMinimum();
    }
    
    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    /**
     *
     * @return
     */
    public Match getMatch() {
        return this.match;
    }
    
    private void notifyChange() {
        notifyObserver();
    }
    
    @Override
    public Status getStatus() {
        return status;
    }
    
    public boolean getIsOver() {
        return this.match.isOver();
    }
    
    private void updateSatus() {
        if (status != END_GAME) {
            if (match == null) {
                status = INIT;
            } else if (match.isOver()) {
                status = END_MATCH;
                
            } else {
                State state = match.getState();
                if (state instanceof Blind) {
                    status = BLIND;
                } else if (state instanceof Preflop) {
                    status = PREFLOP;
                } else if (state instanceof Flop) {
                    status = FLOP;
                } else if (state instanceof Turn) {
                    status = TURN;
                } else if (state instanceof River) {
                    status = RIVER;
                }
            }
        }
    }
    
    public void setNbPlayer(List<Player> listPlayer) {
        int nbBounty = 0;
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isFold()) {
                if (players.get(i).getMoney() == 0) {
                    nbBounty += 1;
                }
            }
            for (int j = 0; j < listPlayer.size(); j++) {
                listPlayer.get(i).setBounty(nbBounty / listPlayer.size());
            }
        }
    }
    
    @Override
    public void stop() {
        status = END_GAME;
        notifyChange();
    }
    
    @Override
    public int getSmallBlindValue() {
        return Match.SMALLBLIND;
    }
    
    @Override
    public void addObserver(Observer observer) {
        listObserver.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        listObserver.remove(observer);
    }

//    @Override
    @Override
    public void notifyObserver() {
        for (int i = 0; i < listObserver.size(); i++) {
            
            listObserver.get(i).update();
        }
        
    }
}
