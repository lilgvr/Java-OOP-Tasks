package ru.gavrilenko.time.block5;

public class Time {
    private int h,m,s;
    private boolean isHM;

    public Time(int sec){
        this.s = sec;
    }

    public Time(int h, int m, int s) {
        if(h >=60 || m >= 60 || s >= 60) throw new IllegalArgumentException();

        this.h = h;
        this.m = m;
        this.s = s;
        this.isHM = true;
    }

    private String convert(int s){
        while(s >= 86400) s -= 86400;
        int sec = s % 60, min = (s / 60) % 60, hour = s / 3600;
        String res[] = new String[3];

        res[0] = Integer.toString(hour);
        res[1] = Integer.toString(min);
        res[2] = Integer.toString(sec);

        if(hour < 10) res[0] = "0" + hour;
        if(min < 10) res[1] = "0" + min;
        if(sec < 10) res[2] = "0" + sec;

        return res[0] + ":" + res[1] + ":" + res[2];
    }

    private String convert(int h, int m, int s){
        String res[] = new String[3];

        res[0] = Integer.toString(h);
        res[1] = Integer.toString(m);
        res[2] = Integer.toString(s);

        if(h < 10) res[0] = "0" + h;
        if(m < 10) res[1] = "0" + m;
        if(s < 10) res[2] = "0" + s;

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

    public String toString(){
        return (isHM)? convert(h,m,s) : convert(s);
    }
}
