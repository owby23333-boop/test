package com.funny.audio.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes3.dex */
public class NetWorkUtils {
    public static final String NETWORK_TYPE_2G = "2g";
    public static final String NETWORK_TYPE_3G = "eg";
    public static final String NETWORK_TYPE_DISCONNECT = "disconnect";
    public static final int NETWORK_TYPE_NO_CONNECTION = -1231545315;
    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_WAP = "wap";
    public static final String NETWORK_TYPE_WIFI = "wifi";

    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static String getNetworkTypeName(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return NETWORK_TYPE_DISCONNECT;
        }
        String typeName = activeNetworkInfo.getTypeName();
        if ("WIFI".equalsIgnoreCase(typeName)) {
            return "wifi";
        }
        if (!"MOBILE".equalsIgnoreCase(typeName)) {
            return "unknown";
        }
        if (android.text.TextUtils.isEmpty(Proxy.getDefaultHost())) {
            str = isFastMobileNetwork(context) ? NETWORK_TYPE_3G : "2g";
        } else {
            str = NETWORK_TYPE_WAP;
        }
        return str;
    }

    public static String getNetworkTypeDesc(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return "UnKnown";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        if (ActivityCompat.checkSelfPermission(context, g.c) != 0) {
            return "mobile";
        }
        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        if (networkType == 20) {
            return "5G";
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : subtypeName;
        }
    }

    private static boolean isFastMobileNetwork(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        try {
            switch (telephonyManager.getNetworkType()) {
            }
        }
        return false;
    }

    public static NetworkInfo.State getCurrentNetworkState(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getState();
        }
        return null;
    }

    public static int getCurrentNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : NETWORK_TYPE_NO_CONNECTION;
    }

    public static int getCurrentNetworkSubtype(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getSubtype() : NETWORK_TYPE_NO_CONNECTION;
    }

    public static boolean isConnectedByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTED;
    }

    public static boolean isConnectingByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTING;
    }

    public static boolean isDisconnectedByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.DISCONNECTED;
    }

    public static boolean isDisconnectingByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.DISCONNECTING;
    }

    public static boolean isSuspendedByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.SUSPENDED;
    }

    public static boolean isUnknownByState(Context context) {
        return getCurrentNetworkState(context) == NetworkInfo.State.UNKNOWN;
    }

    public static boolean isBluetoothByType(Context context) {
        return getCurrentNetworkType(context) == 7;
    }

    public static boolean isDummyByType(Context context) {
        return getCurrentNetworkType(context) == 8;
    }

    public static boolean isEthernetByType(Context context) {
        return getCurrentNetworkType(context) == 9;
    }

    public static boolean isMobileByType(Context context) {
        return getCurrentNetworkType(context) == 0;
    }

    public static boolean isMobileDunByType(Context context) {
        return getCurrentNetworkType(context) == 4;
    }

    public static boolean isMobileHipriByType(Context context) {
        return getCurrentNetworkType(context) == 5;
    }

    public static boolean isMobileMmsByType(Context context) {
        return getCurrentNetworkType(context) == 2;
    }

    public static boolean isMobileSuplByType(Context context) {
        return getCurrentNetworkType(context) == 3;
    }

    public static boolean isWifiByType(Context context) {
        return getCurrentNetworkType(context) == 1;
    }

    public static boolean isWimaxByType(Context context) {
        return getCurrentNetworkType(context) == 6;
    }

    public static boolean is1XRTTBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 7;
    }

    public static boolean isCDMABySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 4;
    }

    public static boolean isEDGEBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 2;
    }

    public static boolean isEHRPDBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 14;
    }

    public static boolean isEVDO_0BySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 5;
    }

    public static boolean isEVDO_ABySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 6;
    }

    public static boolean isEVDO_BBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 12;
    }

    public static boolean isGPRSBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 1;
    }

    public static boolean isHSDPABySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 8;
    }

    public static boolean isHSPABySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 10;
    }

    public static boolean isHSPAPBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 15;
    }

    public static boolean isHSUPABySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 9;
    }

    public static boolean isIDENBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 11;
    }

    public static boolean isLTEBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 13;
    }

    public static boolean isUMTSBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 3;
    }

    public static boolean isUNKNOWNBySubtype(Context context) {
        return getCurrentNetworkSubtype(context) == 0;
    }

    public static boolean isChinaMobile2G(Context context) {
        return isEDGEBySubtype(context);
    }

    public static boolean isChinaUnicom2G(Context context) {
        return isGPRSBySubtype(context);
    }

    public static boolean isChinaUnicom3G(Context context) {
        return isHSDPABySubtype(context) || isUMTSBySubtype(context);
    }

    public static boolean isChinaTelecom2G(Context context) {
        return isCDMABySubtype(context);
    }

    public static boolean isChinaTelecom3G(Context context) {
        return isEVDO_0BySubtype(context) || isEVDO_ABySubtype(context) || isEVDO_BBySubtype(context);
    }

    public static int getWifiState(Context context) throws Exception {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        throw new Exception("wifi device not found!");
    }

    public static boolean isWifiOpen(Context context) throws Exception {
        int wifiState = getWifiState(context);
        return wifiState == 3 || wifiState == 2;
    }

    public static boolean setWifi(Context context, boolean enable) throws Exception {
        if (isWifiOpen(context) == enable) {
            return true;
        }
        ((WifiManager) context.getSystemService("wifi")).setWifiEnabled(enable);
        return true;
    }

    public static boolean isMobileNetworkOpen(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0).isConnected();
    }

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getIpAddressDesc(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        if (activeNetworkInfo.getType() == 0) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                            return inetAddressNextElement.getHostAddress();
                        }
                    }
                }
                return null;
            } catch (SocketException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (activeNetworkInfo.getType() == 1) {
            return intIP2StringIP(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        }
        if (activeNetworkInfo.getType() == 9) {
            return getLocalIp();
        }
        return null;
    }

    private static String intIP2StringIP(int ip) {
        return (ip & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + ((ip >> 8) & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + ((ip >> 16) & 255) + FileUtils.FILE_EXTENSION_SEPARATOR + ((ip >> 24) & 255);
    }

    private static String getLocalIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (SocketException unused) {
            return "0.0.0.0";
        }
    }
}
