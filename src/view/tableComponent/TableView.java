package view.tableComponent;

import observer.Observer;

/**
 *
 * @author Mitch
 */
public interface TableView extends Observer {
    @Override
    public void update();   
}
