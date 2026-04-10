package com.bytedance.sdk.component.panglearmor.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.panglearmor.m;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f785a = -1;
    private ConnectivityManager dl;
    private volatile int g;
    private TelephonyManager gc;

    public z() {
        this.dl = null;
        this.gc = null;
        Context contextA = m.a();
        if (contextA != null) {
            this.dl = (ConnectivityManager) contextA.getSystemService("connectivity");
            this.gc = (TelephonyManager) contextA.getSystemService("phone");
        }
        z((int) (((gc.z().dl() / 1000) / 60) / 60));
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private static boolean z(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void z(int i) {
        if (i <= 0) {
            this.g = 1;
        } else if (i > 168) {
            this.g = 168;
        } else {
            this.g = i;
        }
    }

    public int[] g() {
        int[] iArr = new int[this.g];
        LinkedList<JSONObject> linkedListZ = g.z().z("sp_net");
        if (linkedListZ != null && linkedListZ.size() > 0) {
            int iOptLong = (int) (((linkedListZ.getLast().optLong(an.aI, 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListZ) {
                long jOptLong = jSONObject.optLong(an.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.g) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int[] dl() {
        int[] iArr = new int[this.g];
        LinkedList<JSONObject> linkedListZ = g.z().z("sp_screen");
        if (linkedListZ != null && linkedListZ.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListZ) {
                long jOptLong = jSONObject.optLong(an.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.g) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int a() {
        this.f785a = m();
        return this.f785a;
    }

    private int m() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.dl;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.dl.getActiveNetwork()) == null || (networkCapabilities = this.dl.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(0);
            boolean zHasTransport2 = networkCapabilities.hasTransport(1);
            if (z(this.dl) && zHasTransport2) {
                return 3;
            }
            if (zHasTransport2) {
                return 1;
            }
            return zHasTransport ? 2 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int gc() {
        TelephonyManager telephonyManager = this.gc;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }
}
