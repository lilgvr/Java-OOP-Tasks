package ru.gavrilenko.media.block6;

public class Time {
    private int h,m,s;
    private int t;
    private boolean isHM;

    public Time(int sec){
        if(sec < 0) throw new IllegalArgumentException();

        while(sec >= 86400) sec -= 86400;

        this.s = sec;
    }

    public Time(int h, int m, int s) {
        if(h >=24 || m >= 60 || s >= 60 || h*m*s < 0) throw new IllegalArgumentException();

        this.h = h;
        this.m = m;
        this.s = s;
        this.isHM = true;
    }

    private String convert(int time){

        int sec = time % 60, min = (time / 60) % 60, hour = time / 3600;
        String[] res = new String[3];

        res[0] = Integer.toString(hour);
        res[1] = Integer.toString(min);
        res[2] = Integer.toString(sec);

        if(hour < 10) res[0] = "0" + hour;
        if(min < 10) res[1] = "0" + min;
        if(sec < 10) res[2] = "0" + sec;

        return res[0] + ":" + res[1] + ":" + res[2];
    }

    public int getHour(){
        return (isHM)? h : s / 3600;
    }

    public int getMin(){
        return (isHM)? m : (s/60) % 60;
    }

    public int getSec(){
        return (isHM)? s : s % 60;
    }

    public String toString() {
        return convert(t);
    }
}
