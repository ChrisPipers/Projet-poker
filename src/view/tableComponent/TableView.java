package view.tableComponent;

import model.observer.Observer;

/**
 * this is the interface of the table
 *
 * @author g39864
 */
public interface TableView extends Observer {

    /**
     * this is the method of the table must be implemented
     */

    @Override
    public void update();
}
