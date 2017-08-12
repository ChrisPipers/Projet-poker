package view.playerComponent;

import model.observer.Observer;

/**
 * this is the interface of PlayerComponent
 *
 * @author g39864
 */
public interface PlayerComponentView extends Observer {

    /**
     * this is the method of the PlayerComponent must be implemented
     *
     */
    public void upDate();

}
