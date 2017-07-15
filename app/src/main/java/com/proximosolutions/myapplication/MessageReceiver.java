package com.proximosolutions.myapplication;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Isuru Tharanga on 7/13/2017.
 */

public class MessageReceiver extends  Thread {
    public MessageData msg;
    public InputStream inStream;
    public ProgressDialog progressDialog;
    Remote remote;
    public FragmentRemote fragmentRemote;

    @Override
    public void run() {





        final int BUFFER_SIZE = 1024000;
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytes = 0;
        MessageHandler handler = new MessageHandler();


        if(remote==null){
            remote = new Remote();
        }
        while (true) {
            if(remote!=null){
                /*System.out.println("TEST 11111111"+remote.getOne().getP1());
                System.out.println("TEST 22222222"+remote.getOne().getP2());
                System.out.println("TEST 33333333"+remote.getOne().getP3());
                System.out.println("TEST 44444444"+remote.getOne().getP4());
                System.out.println("TEST 44444444"+remote.getOne().getP5());*/
            }else {
                remote = new Remote();
            }
            //System.out.println("Running...Outer");
            try {
                //System.out.println("Running...Inner 1");
                if(inStream!=null){
                    //System.out.println(inStream.available());
                    //System.out.println(inStream.read());
                    if(inStream.available()!=0){
                        bytes = inStream.read(buffer);
                        //bytes = inStream.read(buffer);
                        String readMessage = new String(buffer,0,bytes);
                        //System.out.println(readMessage);
                        handler.receiveMessage(readMessage);
                        String receivedCmd = handler.getCommand();
                        System.out.println(receivedCmd);
                        Command cmd = handler.decryptCommand(receivedCmd);
                        if(cmd!=null){
                            System.out.println(cmd.getP2()+cmd.getP3()+cmd.getP4()+cmd.getP1());
                            if(cmd.getP1().contains("LEARN")){
                                String btn = cmd.getP2();

                                switch (btn){
                                    case "1":
                                        remote.setOne(cmd);
                                        System.out.println(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("1");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "2":
                                        remote.setTwo(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("2");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "3":
                                        remote.setThree(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("3");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "4":
                                        remote.setFour(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("4");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "5":
                                        remote.setFive(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("5");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "6":
                                        remote.setSix(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("6");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "7":
                                        remote.setSeven(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("7");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "8":
                                        remote.setEight(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("8");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "9":
                                        remote.setNine(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("9");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "0":
                                        remote.setZero(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("0");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "UP":
                                        remote.setUp(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("UP");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "DOWN":
                                        remote.setDown(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("DOWN");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "LEFT":
                                        remote.setLeft(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("LEFT");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "RIGHT":
                                        remote.setRight(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("RIGHT");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "VOL UP":
                                        remote.setVolUp(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("VOL UP");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "VOL DOWN":
                                        remote.setVolDown(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("VOL DOWN");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "CHANNEL UP":
                                        remote.setChannelUp(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("CHANNEL UP");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "CHANNEL DOWN":
                                        remote.setChanelDown(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("CHANNEL DOWN");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "MUTE":
                                        remote.setMute(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("MUTE");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "AV":
                                        remote.setAv(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("AV");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                    case "POWER":
                                        remote.setOnoff(cmd);
                                        if(progressDialog!=null){
                                            progressDialog.dismiss();
                                        }
                                        if(fragmentRemote.getMainText()!=null){
                                            fragmentRemote.getMainText().setText("POWER");
                                            fragmentRemote.getMainText().invalidate();
                                        }
                                        break;
                                }
                                fragmentRemote.getMainText().invalidate();

                            }else if(cmd.getP1().contains("ERR") | cmd.getP3().contains("ERR")){
                                progressDialog.dismiss();
                                System.out.println("ERR RECEIVED");
                                if(fragmentRemote.getMainText()!=null){

                                    fragmentRemote.getMainText().setText("ERROR VALUE TRY AGAIN");
                                    fragmentRemote.getMainText().invalidate();


                                }
                            }
                            //fragmentRemote.notifyAll();
                            fragmentRemote.getMainText().invalidate();


                        }


                    }

                    }else{

                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
