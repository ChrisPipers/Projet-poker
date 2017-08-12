package view.choiceBoxPlayer;

import model.observer.Observer;

/**
 * this is the interface of the choiceboxview
 *
 * @author g39864
 */
public interface ChoiceBoxView extends Observer {

    /**
     * this is the method to update the statut of the game change
     */
    @Override
    public void update();
}
