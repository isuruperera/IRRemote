package com.proximosolutions.myapplication;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/**
 * Created by Isuru Tharanga on 7/12/2017.
 */

public class FragmentRemote extends Fragment{
    private View remoteView;
    public MessageData msg;
    private static OutputStream outputStream;
    private static InputStream inStream;
    public Remote remote;
    public boolean learnMode;
    public ProgressDialog progressDialog;
    MessageReceiver r;
    private TextView mainText;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
         r = new MessageReceiver();
        r.fragmentRemote = this;

        r.remote = remote;
        r.inStream = this.inStream;
        remoteView = inflater.inflate(R.layout.remote_control,container,false);
        Button btn_1 = (Button) remoteView.findViewById(R.id.btn_1);
        Button btn_2 = (Button) remoteView.findViewById(R.id.btn_2);
        Button btn_3 = (Button) remoteView.findViewById(R.id.btn_3);
        Button btn_4 = (Button) remoteView.findViewById(R.id.btn_4);
        Button btn_5 = (Button) remoteView.findViewById(R.id.btn_5);
        Button btn_6 = (Button) remoteView.findViewById(R.id.btn_6);
        Button btn_7 = (Button) remoteView.findViewById(R.id.btn_7);
        Button btn_8 = (Button) remoteView.findViewById(R.id.btn_8);
        Button btn_9 = (Button) remoteView.findViewById(R.id.btn_9);
        Button btn_0 = (Button) remoteView.findViewById(R.id.btn_0);
        Button btn_up = (Button) remoteView.findViewById(R.id.btn_up);
        Button btn_down = (Button) remoteView.findViewById(R.id.btn_down);
        Button btn_left = (Button) remoteView.findViewById(R.id.btn_left);
        Button btn_right = (Button) remoteView.findViewById(R.id.btn_right);
        Button btn_vol_up = (Button) remoteView.findViewById(R.id.btn_vol_up);
        Button btn_vol_down = (Button) remoteView.findViewById(R.id.btn_vol_down);
        Button btn_ch_up = (Button) remoteView.findViewById(R.id.btn_channel_up);
        Button btn_ch_down = (Button) remoteView.findViewById(R.id.btn_channel_down);
        Button btn_mute = (Button) remoteView.findViewById(R.id.btn_mute);
        Button btn_ok = (Button) remoteView.findViewById(R.id.btn_ok);
        Button btn_av = (Button) remoteView.findViewById(R.id.btn_av);
        Button btn_power = (Button) remoteView.findViewById(R.id.btn_on_off);

        if(remote==null){
            remote = new Remote();
        }


        setMainText((TextView) remoteView.findViewById(R.id.main_text_view));
        if(learnMode){
            getMainText().setText("LEARN MODE");
        }else{
            getMainText().setText("REMOTE MODE");
        }

        r.start();

        final Spinner sp = (Spinner) remoteView.findViewById(R.id.BrandsList);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;1;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getOne()!=null){
                        if(remote.getOne()==null || remote.getOne().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getOne()));
                            getMainText().setText("1");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;2;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getTwo()!=null){
                        if(remote.getTwo()==null || remote.getTwo().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getTwo()));
                            getMainText().setText("2");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;3;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getThree()!=null){
                        if(remote.getThree()==null || remote.getThree().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getThree()));
                            getMainText().setText("3");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;4;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getFour()!=null){
                        if(remote.getFour()==null || remote.getFour().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getFour()));
                            getMainText().setText("4");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;5;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getFive()!=null){
                        if(remote.getFive()==null || remote.getFive().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getFive()));
                            getMainText().setText("5");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;6;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getSix()!=null){
                        if(remote.getSix()==null || remote.getSix().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getSix()));
                            getMainText().setText("6");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;7;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getSeven()!=null){
                        if(remote.getSeven()==null || remote.getSeven().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getSeven()));
                            getMainText().setText("7");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;8;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getEight()!=null){
                        if(remote.getEight()==null || remote.getEight().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getEight()));
                            getMainText().setText("8");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;9;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getNine()!=null){
                        if(remote.getNine()==null || remote.getNine().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getNine()));
                            getMainText().setText("9");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;0;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getZero()!=null){
                        if(remote.getZero()==null || remote.getZero().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getZero()));
                            getMainText().setText("0");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;UP;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getUp()!=null){
                        if(remote.getUp()==null || remote.getUp().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getUp()));
                            getMainText().setText("UP");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;DOWN;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getDown()!=null){
                        if(remote.getDown()==null || remote.getDown().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getDown()));
                            getMainText().setText("DOWN");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;LEFT;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getLeft()!=null){
                        if(remote.getLeft()==null || remote.getLeft().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getLeft()));
                            getMainText().setText("LEFT");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;RIGHT;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getRight()!=null){
                        if(remote.getRight()==null || remote.getRight().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getRight()));
                            getMainText().setText("RIGHT");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_vol_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;VOL UP;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getVolUp()!=null){
                        if(remote.getVolUp()==null || remote.getVolUp().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getVolUp()));
                            getMainText().setText("VOL UP");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_vol_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;VOL DOWN;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getVolDown()!=null){
                        if(remote.getVolDown()==null || remote.getVolDown().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getVolDown()));
                            getMainText().setText("VOL DOWN");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_ch_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;CHANNEL UP;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getChannelUp()!=null){
                        if(remote.getChannelUp()==null || remote.getChannelUp().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getChannelUp()));
                            getMainText().setText("CHANNEL UP");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_ch_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;CHANNEL DOWN;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getChanelDown()!=null){
                        if(remote.getChanelDown()==null || remote.getChanelDown().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getChanelDown()));
                            getMainText().setText("CHANNEL DOWN");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;MUTE;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getMute()!=null){
                        if(remote.getMute()==null || remote.getMute().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getMute()));
                            getMainText().setText("MUTE");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;POWER;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", true, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getOnoff()!=null){
                        if(remote.getOnoff()==null || remote.getOnoff().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getOnoff()));
                            getMainText().setText("POWER");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_av.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;AV;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getAv()!=null){
                        if(remote.getAv()==null || remote.getAv().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getAv()));
                            getMainText().setText("AV");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(learnMode){
                        System.out.println("Learn");
                        String brand = sp.getSelectedItem().toString();
                        write("LEARN;OK;"+brand+";100");
                        progressDialog = progressDialog.show(getActivity(), "Waiting for response", "Aim the remote controller towards the device and press appropriate button", false, true);
                        r.progressDialog = progressDialog;
                    }else if(remote.getOk()!=null){
                        if(remote.getOk()==null || remote.getOk().equals("")){
                            getMainText().setText("KEY NOT PROGRAMMED");
                        }else{
                            write(makeCommand(remote.getOk()));
                            getMainText().setText("OK");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return remoteView;

    }
    private void init() throws IOException {
        BluetoothAdapter blueAdapter = BluetoothAdapter.getDefaultAdapter();
        if (blueAdapter != null) {
            if (blueAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = blueAdapter.getBondedDevices();

                if(bondedDevices.size() > 0) {
                    Object[] devices = (Object []) bondedDevices.toArray();
                    BluetoothDevice btDevice = msg.device;
                    BluetoothSocket socket = btDevice.createRfcommSocketToServiceRecord(btDevice.getUuids()[0].getUuid());
                    try{
                        if(inStream==null && outputStream ==null){
                            socket.connect();
                        }


                        outputStream = socket.getOutputStream();
                        inStream = socket.getInputStream();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast t = new Toast(getActivity());
                        t.makeText(getActivity(), "The BT Device Not in Range!",
                                Toast.LENGTH_LONG).show();
                    }

                }
            } else {
                throw new IOException();
            }
        }
    }

    public void write(String s) throws IOException {
        if(outputStream!=null){

            outputStream.write(s.getBytes());

        }
    }

    public String makeCommand(Command command){
        if(command==null){
            return "INVALID";
        }else{ //learn;btnid;hex;bits;brand
            if(command.getP1()!=null && command.getP2()!=null && command.getP3()!=null && command.getP4()!=null){
                if(command.getP1().contains("LEARN")){
                    return "TRANS;"+command.getP3()+";"+(command.getP5())+";"+(command.getP4());
                } else{
                    return "INVALID";
                }
            }else {
                return "INVALID";
            }

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if(learnMode){
            getMainText().setText("LEARN MODE");
        }else{
            getMainText().setText("REMOTE MODE");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if(learnMode){
            getMainText().setText("LEARN MODE");
        }else{
            getMainText().setText("REMOTE MODE");
        }
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        if(learnMode){
            getMainText().setText("LEARN MODE");
        }else{
            getMainText().setText("REMOTE MODE");
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(learnMode){
            getMainText().setText("LEARN MODE");
        }else{
            getMainText().setText("REMOTE MODE");
        }
    }

    public TextView getMainText() {
        return mainText;
    }

    public void setMainText(TextView mainText) {
        this.mainText = mainText;
    }


}
