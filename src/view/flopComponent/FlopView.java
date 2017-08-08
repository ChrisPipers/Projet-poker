
package view.flopComponent;

import observer.Observer;

/**
 *
 * @author Mitch
 */
public interface FlopView extends Observer {
    @Override
    public void update();
}
