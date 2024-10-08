package Song;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Song {
    @SerializedName("TrackId")
    private int track_ID;
    @SerializedName("Song")
    private String song;
    @SerializedName("Duration")
    private int duration;
    @SerializedName("Album")
    private String album;
    @SerializedName("Artist")
    private String artist;

    /**
     * Constructor of the sog
     * @param track_ID the id
     * @param song the title
     * @param duration the time
     * @param album the album
     * @param artist the artist
     */
    public Song(int track_ID, String song, int duration, String album, String artist) {
        this.track_ID = track_ID;
        this.song = song;
        this.duration = duration;
        this.album = album;
        this.artist = artist;
    }

    /**
     * ToString methode for the better show
     * @return the song as String
     */
    @Override
    public String toString() {
        return "Song: " +
                "ID: " + track_ID +
                ", titel: " + song +
                ", duration: " + duration +
                ", album: " + album +
                ", artist: " + artist;
    }

    /**
     * Getter for ID
     * @return id
     */
    public int getTrack_ID() {
        return track_ID;
    }

    /**
     * Getter for title
     * @return title
     */
    public String getSong() {
        return song;
    }

    /**
     * Getter for duration
     * @return time
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Getter for album
     * @return album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Getter for artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }
}
