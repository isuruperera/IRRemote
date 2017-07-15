package com.proximosolutions.myapplication;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * Created by Isuru Tharanga on 7/15/2017.
 */

public class Remote implements Serializable {
    private Command volUp;
    private Command volDown;
    private Command channelUp;
    private Command chanelDown;
    private Command up;
    private Command down;
    private Command left;
    private Command right;
    private Command mute;
    private Command onoff;
    private Command ok;
    private Command one;
    private Command two;
    private Command three;
    private Command four;
    private Command five;
    private Command six;
    private Command seven;
    private Command eight;
    private Command nine;
    private Command zero;
    private Command av;


    public Remote(){
        this.one = new Command();
        this.two = new Command();
        this.three = new Command();
        this.four = new Command();
        this.five = new Command();
        this.six = new Command();
        this.seven = new Command();
        this.eight = new Command();
        this.nine = new Command();
        this.zero = new Command();
        this.up = new Command();
        this.down = new Command();
        this.left = new Command();
        this.right = new Command();
        this.ok = new Command();
        this.volUp = new Command();
        this.volDown = new Command();
        this.channelUp = new Command();
        this.chanelDown = new Command();
        this.onoff = new Command();
        this.mute = new Command();
        this.av = new Command();
    }

    public Command getVolUp() {
        return volUp;
    }

    public void setVolUp(Command volUp) {
        this.volUp = volUp;
    }

    public Command getVolDown() {
        return volDown;
    }

    public void setVolDown(Command volDown) {
        this.volDown = volDown;
    }

    public Command getChannelUp() {
        return channelUp;
    }

    public void setChannelUp(Command channelUp) {
        this.channelUp = channelUp;
    }

    public Command getChanelDown() {
        return chanelDown;
    }

    public void setChanelDown(Command chanelDown) {
        this.chanelDown = chanelDown;
    }

    public Command getUp() {
        return up;
    }

    public void setUp(Command up) {
        this.up = up;
    }

    public Command getDown() {
        return down;
    }

    public void setDown(Command down) {
        this.down = down;
    }

    public Command getLeft() {
        return left;
    }

    public void setLeft(Command left) {
        this.left = left;
    }

    public Command getRight() {
        return right;
    }

    public void setRight(Command right) {
        this.right = right;
    }

    public Command getMute() {
        return mute;
    }

    public void setMute(Command mute) {
        this.mute = mute;
    }

    public Command getOnoff() {
        return onoff;
    }

    public void setOnoff(Command onoff) {
        this.onoff = onoff;
    }

    public Command getOk() {
        return ok;
    }

    public void setOk(Command ok) {
        this.ok = ok;
    }

    public Command getOne() {
        return one;
    }

    public void setOne(Command one) {
        this.one = one;
    }

    public Command getTwo() {
        return two;
    }

    public void setTwo(Command two) {
        this.two = two;
    }

    public Command getThree() {
        return three;
    }

    public void setThree(Command three) {
        this.three = three;
    }

    public Command getFour() {
        return four;
    }

    public void setFour(Command four) {
        this.four = four;
    }

    public Command getFive() {
        return five;
    }

    public void setFive(Command five) {
        this.five = five;
    }

    public Command getSix() {
        return six;
    }

    public void setSix(Command six) {
        this.six = six;
    }

    public Command getSeven() {
        return seven;
    }

    public void setSeven(Command seven) {
        this.seven = seven;
    }

    public Command getEight() {
        return eight;
    }

    public void setEight(Command eight) {
        this.eight = eight;
    }

    public Command getNine() {
        return nine;
    }

    public void setNine(Command nine) {
        this.nine = nine;
    }

    public Command getZero() {
        return zero;
    }

    public void setZero(Command zero) {
        this.zero = zero;
    }

    public Command getAv() {
        return av;
    }

    public void setAv(Command av) {
        this.av = av;
    }

    public void save(Remote remote){
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File("db")));
            out.writeObject(remote);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Remote retrieve(){
        ObjectInputStream input = null;
        String filename = "testFilemost.srl";
        Remote r = null;

        try {
            File f = new File("db");
            if(!f.exists()){
                f.createNewFile();
            }
            input = new ObjectInputStream(new FileInputStream(f));
             r = (Remote) input.readObject();
            input.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(input!=null){
            return new Remote();
        }else{
            return r;
        }

    }


}
