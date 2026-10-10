import java.util.Arrays;

/**
 * Category C — Assignment Problems
 * Problem 2: The Playlist
 * 
 * Scenario:
 * A music app lets you build a playlist of songs.
 * 
 * Problem Statement:
 * Design a Playlist class that stores songs internally but returns a safe copy of the list,
 * so nobody can sneak in changes from outside.
 * 
 * Key Requirements:
 * - Store song titles in a private array (fixed maximum size).
 * - Method to add a song, and one that returns all the songs added so far — as a copy, not the original array.
 * - Changing the array returned by that method must not affect the playlist's real contents (Defensive Copying).
 * - Provide a read-only count of how many songs are in the playlist (getSongCount()).
 */
public class Playlist {
    private final String[] songs;
    private int songCount;

    /**
     * Constructs a Playlist with a maximum capacity.
     *
     * @param capacity maximum number of songs the playlist can store
     */
    public Playlist(int capacity) {
        if (capacity <= 0) {
            capacity = 10; // default fallback capacity
        }
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    /**
     * Adds a song to the playlist if capacity allows and song is not null.
     *
     * @param song title of the song to add
     * @return true if added successfully, false if the playlist is full or song is null
     */
    public boolean addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            return false;
        }
        if (songCount < songs.length) {
            songs[songCount++] = song;
            return true;
        }
        return false; // playlist is full
    }

    /**
     * Returns a safe, defensive copy of all songs added so far.
     * Changes to the returned array do not affect internal playlist contents.
     *
     * @return a new array containing songs added so far
     */
    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.songCount);
    }

    /**
     * Returns the count of songs added to the playlist.
     * Read-only property.
     *
     * @return number of songs currently in the playlist
     */
    public int getSongCount() {
        return this.songCount;
    }

    /**
     * Returns the maximum capacity of the playlist.
     *
     * @return capacity
     */
    public int getCapacity() {
        return this.songs.length;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Playlist ===");

        // Sample Input/Output from Assignment
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Song count: " + p.getSongCount()); // Expected: 2
        System.out.println("Playlist contents: " + Arrays.toString(p.getSongs()));

        // Defensive copy test
        String[] copy = p.getSongs();
        System.out.println("Obtained copy: " + Arrays.toString(copy));

        System.out.println("Attempting tamper: copy[0] = \"Hacked\"");
        copy[0] = "Hacked";

        System.out.println("Modified copy: " + Arrays.toString(copy));
        System.out.println("Actual playlist contents (p.getSongs()): " + Arrays.toString(p.getSongs()));
        System.out.println("Tamper prevented? " + ("Song A".equals(p.getSongs()[0]) ? "YES (Defensive copy succeeded!)" : "NO"));

        // Add another song
        p.addSong("Song C");
        System.out.println("After adding 'Song C': " + Arrays.toString(p.getSongs()) + " (Count: " + p.getSongCount() + ")");
    }
}
