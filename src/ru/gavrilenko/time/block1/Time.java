package ru.gavrilenko.time.block1;

public class Time {
    public int time;

    private String convert(int time){
        while(time >= 86400) time -= 86400;
        int sec = time % 60, min = (time / 60) % 60, hour = time / 3600;
        String res[] = new String[3];

        res[0] = Integer.toString(hour);
        res[1] = Integer.toString(min);
        res[2] = Integer.toString(sec);

        if(hour < 10) res[0] = "0" + hour;
        if(min < 10) res[1] = "0" + min;
        if(sec < 10) res[2] = "0" + sec;

        return res[0] + ":" + res[1] + ":" + res[2];
    }

    public String toString(){
        return convert(time);
    }
}
