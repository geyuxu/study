package com.geyuxu.immutableObject;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class Location {
//    private double x;
//    private double y;

    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

//    public void setXY(double x, double y){
//        this.x = x;
//        this.y = y;
//    }


}
