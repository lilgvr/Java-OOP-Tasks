package ru.gavrilenko.media.block6;

import ru.gavrilenko.media.block3.Album;

import java.util.ArrayList;

public class Track {
    private Album album;
    private String title, artist;

    public Track(String title, String artist, Album album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    private String setQuotes(String s){
        return "\"" + s + "\"";
    }

    public String toString(){
        if(album != null){
            if(artist == null) return setQuotes(title) + ". Исполнитель: "  + album.getArtist()+
                    ". Альбом: " + setQuotes(album.getTitle());
            if(artist == album.getArtist())
                return setQuotes(title) + ". Исполнитель: " + artist + ". Альбом: " + setQuotes(album.getTitle());
            else
                return setQuotes(title) + ". Исполнители: " + artist + ", " + album.getArtist()+
                        ". Альбом: " + setQuotes(album.getTitle());
        }else{
            return setQuotes(title) + ". Исполнитель: " + artist + " - Single";
        }
    }

    public ArrayList<ru.gavrilenko.media.block3.Track> getAlbumTracks() {
        ArrayList<ru.gavrilenko.media.block3.Track> res = new ArrayList<>();
        for(ru.gavrilenko.media.block3.Track i: album.getTracks()){
            res.add(i);
        }

        return res;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
