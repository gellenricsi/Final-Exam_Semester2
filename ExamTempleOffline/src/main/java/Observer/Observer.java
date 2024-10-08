package Observer;

public interface Observer {
    /**
     * Observer name getting
     * @return the observer´s name
     */
    String getName();

    /**
     * Update methode for observers
     * @param name is the Song´s ame
     */
    void update(String name);
}
