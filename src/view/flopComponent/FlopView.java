package view.flopComponent;

import model.observer.Observer;

/**
 * this is a interface who extends Observer
 *
 * @author g39864
 */
public interface FlopView extends Observer {

    /**
     * this method allows to update the statut of this
     */
    @Override
    public void update();
}
