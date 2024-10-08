package Observer;

public interface Subject {
    /**
     * Methode for register an Observer
     * @param observer is the observer which will be registered
     */
    void registerObserver(Observer observer);

    /**
     * Methode for deregister an Observer
     * @param observer is the observer which will be deregistered
     */
    void deregisterObserver(Observer observer);

    /**
     * Notify all the observers with the song´s name
     * @param name the song´s name
     */
    void notifyObservers(String name);
}
