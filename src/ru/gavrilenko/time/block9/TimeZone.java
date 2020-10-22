package ru.gavrilenko.time.block9;

import ru.gavrilenko.time.block6.Time;

public class TimeZone extends Time {
    private int tzh;
    private boolean hh;
    private Time t;


    public TimeZone(int time, double timezone) {
        super(time);
        this.t = new Time(time);
        if(timezone < -12 || timezone > 14) throw new IllegalArgumentException();
        this.tzh = (int) timezone;
        if(timezone % 1 != 0) hh = true;
    }

    public TimeZone(int h, int m, double timezone){
        super(h,m,0);
        this.t = new Time(h,m,0);

        if(timezone < -12 || timezone > 14) throw new IllegalArgumentException();
        this.tzh = (int) timezone;
        if(timezone % 1 != 0) hh = true;
    }

    public String getTimezone(){
        String s = "+";
        if(tzh < 0) s = "-";

        return (hh)? s + Math.abs(tzh) + ":30" : s + Math.abs(tzh);
    }

    public String toString(){
        /*String s = "+";
        if(tzh < 0) s = "-";*/

        String hour = "" + t.getHour(), min = "" + t.getMin();
        if(t.getHour() < 10) hour = "0" + hour;
        if(t.getMin() < 10) min = "0" + min;

        return hour + ":" + min + " UTC " + getTimezone();
    }


}
