package com.proximosolutions.myapplication;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;

/**
 * Created by Isuru Tharanga on 7/13/2017.
 */

public class MessageData {
    public String deviceID;
    public ParcelUuid deviceUuid[];
    public BluetoothDevice device;
}
