package view.tableComponent;

import model.observer.Observer;

/**
 * this is the interface of the table
 * @author Mitch
 */
public interface TableView extends Observer {
    /**
     * this is the method of the table must be implemented
     */
    @Override
    public void update();   
}
