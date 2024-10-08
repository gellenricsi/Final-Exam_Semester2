package Observer;

import lombok.Setter;

@Setter
public class OutputDevice implements Observer{
    private String name;

    public OutputDevice(String name) {
        this.name = name;
    }

    /**
     * Overriding the super methode
     * @return the observer´s name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Overriding the super methode
     * @param name is the Song´s ame
     */
    @Override
    public void update(String name) {
        System.out.printf("%s: The song called as \"%s\" is played!\n",this.name,name);
    }
}
