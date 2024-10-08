package org.lecture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import CheckUserInput.Check;
import Exceptions.NoDeviceFoundException;
import Menu.Menus;
import Observer.Observer;
import Observer.OutputDevice;
import Observer.Subject;
import Song.Song;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Player implements Subject {
    private static List<Song> songList = new ArrayList<>();
    private static final List<Song> playList = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private static Player instance;

    /**
     * Getting instance with Singleton
     *
     * @return a new song player
     * @throws IOException When the file writing or file reading has a problem
     */
    public static Player getInstance() throws IOException {
        if (instance == null) {
            instance = new Player();
        }

        return instance;
    }

    /**
     * Constructor, it runs the run methode
     *
     * @throws IOException When the file writing or file reading has a problem
     */
    private Player() throws IOException {
        run();
    }

    /**
     * It starts the application
     *
     * @throws IOException When the file writing or file reading has a problem
     */
    private void run() throws IOException {
        songList = FileReader.loadSong();
        while (true) {
            System.out.println(Menus.mainMenu());
            int choice = Check.getUserInputNumber();
            switch (choice) {
                case 1:
                    registerOutputDevice();
                    break;
                case 2:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        deregisterOutputDevice();
                    }
                    break;
                case 3:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        listSongList();
                    }
                    break;
                case 4:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        if (!playList.isEmpty()) {
                            playList.forEach(System.out::println);
                        } else {
                            System.err.println("The playlist is empty.");
                        }
                    }
                    break;
                case 5:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        addSongToPlayList();
                    }
                    break;
                case 6:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        playPlayList();
                    }
                    break;
                case 7:
                    if (observers.isEmpty()) {
                        System.err.println("\n" + new NoDeviceFoundException("No device found.\n"));
                    } else {
                        if (playList.isEmpty()) {
                            System.err.println("You cannot save the playlist to a file, because the playlist is empty.");
                        } else {
                            FileWriter.savePlayList(playList);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }

        }
    }

    /**
     * Playing the playlist you can choose between step to the next song,
     * step back to the previous song or
     * restart the player
     *
     * @throws IOException When the file writing or file reading has a problem
     */
    private void playPlayList() throws IOException {
        boolean isRunnig = true;
        int song = 0;
        if (playList.isEmpty()) {
            System.err.println("The playlist is empty.");
        } else {
            notifyObservers(playList.get(song).getSong());
            while (isRunnig) {
                System.out.println(Menus.playMenu());
                int choice = Check.getUserInputNumber();
                try {
                    switch (choice) {
                        case 1:
                            song++;
                            System.out.print("Play the next song...\n");
                            notifyObservers(playList.get(song).getSong());
                            break;
                        case 2:
                            song--;
                            System.out.print("Jump back to the previous song...\n");
                            notifyObservers(playList.get(song).getSong());
                            break;
                        case 3:
                            song = 0;
                            System.out.print("Restarting the playlist...\n");
                            notifyObservers(playList.get(song).getSong());
                            break;
                        case 9:
                            run();
                            isRunnig = false;
                            break;
                        default:
                            System.out.println("Invalid Choice.");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Out of range! There is no such song.");
                    playPlayList();
                }
            }
        }
    }

    /**
     * Deregister the observer which one the user want.
     */
    private void deregisterOutputDevice() {
        if (observers.isEmpty()) {
            System.err.println("There is no Device to remove.");
        } else {
            int i = 1;
            for (Observer o : observers) {
                System.out.println(i + o.getName());
                i++;
            }
            System.out.println("What is the name of the device? This will be removed.");
            String name = Check.getUserInputString();
            boolean deleted = false;
            for (i = 0; i < observers.size(); i++) {
                if (observers.get(i).getName().equalsIgnoreCase(name)) {
                    deregisterObserver(observers.get(i));
                    deleted = true;
                }
            }

            if (!deleted) {
                System.err.println("No such device found: " + name);
            }
        }
    }

    /**
     * Register a new Observer
     */
    private void registerOutputDevice() {
        System.out.println("What is the name of the device?");
        String name = Check.getUserInputString();
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i).getName().equalsIgnoreCase(name)) {
                System.err.println("A Device with this name is exists!");
                return;
            }
        }
        Observer observer = new OutputDevice(name);
        registerObserver(observer);
    }

    /**
     * Overriding the super methode
     *
     * @param observer is the observer which will be registered
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Audio Player " + observer.getName() + " successfully added!");
    }

    /**
     * Overriding the super methode
     *
     * @param name the song´s name
     */
    @Override
    public void notifyObservers(String name) {
        for (Observer observer : observers) {
            observer.update(name);
        }
    }

    /**
     * Overriding the super methode
     *
     * @param observer is the observer which will be deregistered
     */
    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Audio Player " + observer.getName() + " successfully removed!");
    }

    /**
     * Add a new song from the song list to the playlist and play it.
     * It also notifies the Observers.
     */
    public void addSongToPlayList() {
        listSongList();
        System.out.println("Which one do you want to add to the playlist? Type ID");
        int choice = Check.getUserInputNumber();
        boolean found = false;
        for (Song song : songList) {
            if (song.getTrack_ID() == choice) {
                playList.add(song);
                System.out.println("Song successfully added to the Playlist!");
                notifyObservers(song.getSong());
                found = true;
            }
        }
        if (found == false) {
            System.err.println("Wrong song id. Try again.");
            addSongToPlayList();
        }
    }

    /**
     * Outputting the song list.
     */
    private static void listSongList() {
        songList.forEach(System.out::println);
    }
}
