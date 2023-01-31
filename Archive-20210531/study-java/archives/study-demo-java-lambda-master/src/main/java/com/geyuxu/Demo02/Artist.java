package com.geyuxu.Demo02;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class Artist {
    private String name;
    private String loc;

    public Artist(String name, String loc) {
        this.name = name;
        this.loc = loc;
    }

    public boolean isFrom(String from){
        return from.equals(loc)?true:false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
