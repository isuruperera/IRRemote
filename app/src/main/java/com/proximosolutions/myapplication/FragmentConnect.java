package com.proximosolutions.myapplication;

import android.app.Fragment;
import android.app.LauncherActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.proximosolutions.myapplication.R.id.info;

/**
 * Created by Isuru Tharanga on 7/11/2017.
 */

public class FragmentConnect extends Fragment {
    private ListView listView;
    private ArrayList<String> mDeviceList = new ArrayList<String>();
    private ArrayList<ParcelUuid[]> uuidList = new ArrayList<>();
    ArrayList<BluetoothDevice> btDeviceList;
    private BluetoothAdapter mBluetoothAdapter;
    private View connectView;
    public MessageData msg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        connectView = inflater.inflate(R.layout.connect_fragment,container,false);
        listView = (ListView) connectView.findViewById(R.id.device_list);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        btDeviceList = new ArrayList<>();
        mDeviceList = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                mDeviceList.add(device.getName()+ " | "+device.getAddress());
                uuidList.add(device.getUuids());
                btDeviceList.add(device);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(connectView.getContext(),
                android.R.layout.simple_list_item_multiple_choice,
                mDeviceList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String [] temp = ((mDeviceList.get(i)).split(" | "));
                msg.deviceID = temp[2];
                msg.deviceUuid = uuidList.get(i);
                msg.device = btDeviceList.get(i);
                DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                TextView tw = (TextView) getActivity().findViewById(R.id.bluetooth_id);
                tw.setText(mDeviceList.get(i));
                Toast.makeText(getActivity(), "Connected to: "+msg.deviceID, Toast.LENGTH_SHORT).show();
            }
        });

        return connectView;
    }






}
