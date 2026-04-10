package com.bytedance.sdk.openadsdk.bh;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes10.dex */
public class m {
    public static e e;
    private static SensorManager vn;
    protected static final float[] bf = new float[3];
    protected static final float[] d = new float[3];
    protected static final float[] tg = new float[9];
    protected static final float[] ga = new float[3];

    public static void bf(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            e eVar = e;
            if (eVar == null || !eVar.zk()) {
                SensorManager sensorManagerE = e(context);
                sensorManagerE.registerListener(sensorEventListener, sensorManagerE.getDefaultSensor(4), e(i));
            } else {
                e.e(context, sensorEventListener, 4, e(i));
            }
        } catch (Throwable th) {
            p.e("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void d(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            e eVar = e;
            if (eVar == null || !eVar.zk()) {
                SensorManager sensorManagerE = e(context);
                sensorManagerE.registerListener(sensorEventListener, sensorManagerE.getDefaultSensor(10), e(i));
            } else {
                e.e(context, sensorEventListener, 10, e(i));
            }
        } catch (Throwable th) {
            p.e("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    private static int e(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void tg(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            e eVar = e;
            if (eVar == null || !eVar.zk()) {
                SensorManager sensorManagerE = e(context);
                sensorManagerE.registerListener(sensorEventListener, sensorManagerE.getDefaultSensor(1), e(i));
                sensorManagerE.registerListener(sensorEventListener, sensorManagerE.getDefaultSensor(2), e(i));
            } else {
                e.e(context, sensorEventListener, 1, e(i));
                e.e(context, sensorEventListener, 2, e(i));
            }
        } catch (Throwable th) {
            p.e("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void e(e eVar) {
        e = eVar;
    }

    private static SensorManager e(Context context) {
        if (vn == null) {
            synchronized (m.class) {
                if (vn == null) {
                    vn = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return vn;
    }

    public static void e(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            e eVar = e;
            if (eVar != null && eVar.zk()) {
                e.e(context, sensorEventListener, 1, e(i));
            } else {
                SensorManager sensorManagerE = e(context);
                sensorManagerE.registerListener(sensorEventListener, sensorManagerE.getDefaultSensor(1), e(i));
            }
        } catch (Throwable th) {
            p.e("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void e(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            e(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            p.e("SensorHub", "stopListen error", th);
        }
    }

    public static void e(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
