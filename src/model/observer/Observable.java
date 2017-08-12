package model.observer;

/**
 * this interface allows to use Observable for the MVC
 *
 * @author g39864
 */
public interface Observable {

    /**
     * this method allows to add a observer at the list of observer
     *
     * @param observer is the observer to add at the list
     */
    public void addObserver(Observer observer);

    /**
     * this method allows to remove a observer at the list of observer
     *
     * @param observer is the observer to remove at the list
     */
    public void removeObserver(Observer observer);

    /**
     * this method allows to notify all of observer of the list of observer
     */
    public void notifyObserver();
}
