package org.lecture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Song.Song;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class FileReader {

    /**
     * Path to the songs.json
     */
    private static final Path path = Paths.get("ExamTempleOffline","src", "main", "resources", "songs.json");

    /**
     * It loads the songs from the file into a List
     * @return is the list with the songs
     * @throws IOException throws when there´s a problem
     */
    public static List<Song> loadSong() throws IOException {
        List<Song> songList = new ArrayList<>();
        Gson gson2 = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try (java.io.FileReader reader = new java.io.FileReader(path.toFile())) {
            Type type = new TypeToken<List<Song>>() {}.getType();
            songList = gson2.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting with an empty list.");
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songList;
    }
}
