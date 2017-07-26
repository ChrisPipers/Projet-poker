package view.tableComponent;

import model.Observer;

/**
 *
 * @author Mitch
 */
public interface TableView extends Observer {
 
    public void update();
    
    public void updateFlop() ;
    
    public void updatePlayers();
    
    public void choiceBox();
    
}
