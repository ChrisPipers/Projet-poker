package view.tableComponent;

import model.observer.Observer;

/**
 *
 * @author Mitch
 */
public interface TableView extends Observer {
    @Override
    public void update();   
}
