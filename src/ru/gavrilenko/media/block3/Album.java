package ru.gavrilenko.media.block3;

import java.util.ArrayList;

public class Album {
    private String title, artist;
    public ArrayList<Track> tracks = new ArrayList<>();

    public Album(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String toString(){
        String s = "Альбом: " + title + ", исполнитель: " + artist + "Список песен: \n";
        String t = "";
        int x = 1;

        for(Track i : tracks){
            if(i.getArtist() == artist){
                t += x+ i.getTitle() + "\n";
            }else{
                t += x + i.getTitle() + " (feat. " + i.getArtist() + ")" + "\n";
            }
            x++;
        }

        return s + t;
    }
}
