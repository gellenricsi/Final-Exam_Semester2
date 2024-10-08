package org.lecture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import Song.Song;

public class FileWriter {
    /**
     * Path to the file playlist.json
     */
    private static final Path path = Paths.get("ExamTempleOffline","src", "main", "resources", "playlist.json");

    /**
     * It writes the playlist into the file
     */
    public static void savePlayList(List<Song> playList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try (Writer writer = new java.io.FileWriter(path.toString(), false)) {
            gson.toJson(playList, writer);
            System.out.println("Playlist saved successfully to " + path);
        } catch (IOException e) {
            System.err.println("Error saving messages to file: " + e.getMessage());
        }
    }
}
