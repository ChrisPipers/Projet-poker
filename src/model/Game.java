package model;

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
import java.util.Observable;

//import model.Observer;
//import model.Observable;


/**
 * The main class of the poker game.
 *
 * @author esiProfs
 */
public class Game extends Observable implements Facade {

    private final static int NB_MIN = 4;
    private Match match;
    private final List<Player> players;
    private Status status;
    private final List<Observer> listObserver;            

    /**
     * Main class of the poker game. It instanciates the list of players and set
     * the game's statut to INIT
     */
    public Game() {
        players = new ArrayList<>();
        status = INIT;
        listObserver = new ArrayList<>();
        
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
        match = new Match(players);
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void addPlayer(String name, int money, char sexe) {
        Player player = new Player(name, money, sexe);
        players.add(player);
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void smallBlind(int amount) throws GameException {
        match.smallBlind(amount);
        this.getCurrentPlayer().setSumRaise(amount);
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void bigBlind(int amount) throws GameException {
        match.bigBlind(amount);
        this.getCurrentPlayer().setSumRaise(amount);
        updateSatus();
        notifyObserver();  
                notifyOberver();


    }

    @Override
    public void call() throws GameException {
        match.call();
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void allIn() throws GameException {
        match.allIn();
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void fold() throws GameException {
        match.fold();
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public void raise(int amount) throws GameException {
        match.raise(amount);
//        this.getCurrentPlayer().setSumRaise(amount);
        updateSatus();
        notifyObserver();
                notifyOberver();

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

    @Override
    public Status getStatus() {
        return status;
    }

    private void updateSatus() {
        System.out.println(status);
//        notifyObserver();
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
        notifyOberver();
        notifyObserver();
    }
private void notifyOberver() {
        setChanged();
        notifyObserver();
//                notifyOberver();

    }

    @Override
    public void stop() {
        status = END_GAME;
        updateSatus();
        notifyObserver();
                notifyOberver();

    }

    @Override
    public int getSmallBlindValue() {
        return Match.SMALLBLIND;
    }
    
//    @Override
    public void notifyObserver() {
        setChanged();
//        listObserver.stream().forEach((observer) -> {
//            observer.update();
//        });
listObserver.forEach((observer) -> {
    observer.update();
//            notifyOberver();
            
        });
    }

//    @Override
    public void addObserver(Observer observer) {
        listObserver.add(observer);
    }

//    @Override
    public void removeObserver(Observer observer) {
        listObserver.remove(observer);
    }
}
