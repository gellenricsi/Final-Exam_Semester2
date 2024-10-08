package Menu;

public class Menus {
    /**
     * Main menu
     * @return main menu
     */
    public static String mainMenu(){
        return """
                Welcome to the Application!
                For the first, you must to add an Output Device. If you don't add, you will get an error.
                
                1 - Register Output Device
                2 - Deregister Output Device
                3 - Display the song list
                4 - Display the playlist
                5 - Add a new song from the list to the playlist
                6 - Play the playlist
                7 - Save the playlist to a file
                
                9 - Exit
                """;
    }

    /**
     * Menu for play the playlist
     * @return the play menu
     */
    public static String playMenu(){

        return """
                1 - Play the next song
                2 - Jump back to the previous song
                3 - Restart the playlist
                9 - Back to the main menu
                """;
    }
}
