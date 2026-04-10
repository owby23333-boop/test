package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes4.dex */
public class bk {
    private static bk baG;
    private SensorManager baH;

    public static bk RC() {
        if (baG == null) {
            synchronized (bk.class) {
                if (baG == null) {
                    baG = new bk();
                }
            }
        }
        return baG;
    }

    private static boolean RD() {
        return !bc.useSensorManagerDisable();
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (RE()) {
            return dM(context);
        }
        return null;
    }

    private boolean RE() {
        boolean zRD = RD();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + zRD);
        if (zRD) {
            return true;
        }
        this.baH = null;
        return false;
    }

    private SensorManager dM(Context context) {
        if (this.baH == null) {
            this.baH = (SensorManager) context.getSystemService(com.umeng.analytics.pro.an.ac);
        }
        return this.baH;
    }

    public final Sensor getDefaultSensor(Context context, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i);
        if (RE()) {
            return dM(context).getDefaultSensor(i);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!RE()) {
            return false;
        }
        try {
            return dM(context).registerListener(sensorEventListener, sensor, i);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (RE() && (sensorManager = this.baH) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
