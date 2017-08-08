
package view.flopComponent;

import model.observer.Observer;

/**
 *
 * @author Mitch
 */
public interface FlopView extends Observer {
    @Override
    public void update();
}
