import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        this.songs = new String[maxSongs];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Before hack: copy[0] = " + copy[0] + ", actual[0] = " + p.getSongs()[0]);
        copy[0] = "Hacked";
        System.out.println("After hack: copy[0] = " + copy[0] + ", actual[0] = " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
