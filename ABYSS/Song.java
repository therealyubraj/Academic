package ABYSS;

/**
 *
 * @author ABYSS
 * This class stores the details for a particular song.
 * Attributes:  name: name of the song
 *              artist: artist of the song
 *              genre: genre of the song
 *              album: album of the song
 *              cost: cost of the song
 */
public class Song {

    String name, artist, album, genre;
    float cost;

    public Song(String name, String artist, String album, String genre, float cost) {
        //sets all the attributes based on the parameters
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.cost = cost;
    }
}
