package ru.gavrilenko.media.block3;

import java.util.ArrayList;

public class Track{
    public String title, artist;
    public Album album;

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

    public ArrayList<Track> getAlbumTracks() {
        ArrayList<Track> res = new ArrayList<>();

        for(Track i : album.getTracks()){
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
