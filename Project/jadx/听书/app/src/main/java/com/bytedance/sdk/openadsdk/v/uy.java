package com.bytedance.sdk.openadsdk.v;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static SensorManager m;
    public static z z;
    protected static final float[] g = new float[3];
    protected static final float[] dl = new float[3];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final float[] f1491a = new float[9];
    protected static final float[] gc = new float[3];

    private static int z(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void z(z zVar) {
        z = zVar;
    }

    private static SensorManager z(Context context) {
        if (m == null) {
            synchronized (uy.class) {
                if (m == null) {
                    m = (SensorManager) context.getSystemService(an.ac);
                }
            }
        }
        return m;
    }

    private static boolean z() {
        z zVar = z;
        return zVar == null || !zVar.g();
    }

    public static void z(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (z()) {
                return;
            }
            z zVar = z;
            if (zVar == null || !zVar.dl()) {
                SensorManager sensorManagerZ = z(context);
                sensorManagerZ.registerListener(sensorEventListener, sensorManagerZ.getDefaultSensor(1), z(i));
            }
        } catch (Throwable th) {
            e.z("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void g(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (z()) {
                return;
            }
            z zVar = z;
            if (zVar == null || !zVar.dl()) {
                SensorManager sensorManagerZ = z(context);
                sensorManagerZ.registerListener(sensorEventListener, sensorManagerZ.getDefaultSensor(4), z(i));
            }
        } catch (Throwable th) {
            e.z("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void dl(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (z()) {
                return;
            }
            z zVar = z;
            if (zVar == null || !zVar.dl()) {
                SensorManager sensorManagerZ = z(context);
                sensorManagerZ.registerListener(sensorEventListener, sensorManagerZ.getDefaultSensor(10), z(i));
            }
        } catch (Throwable th) {
            e.z("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (z()) {
                return;
            }
            z zVar = z;
            if (zVar == null || !zVar.dl()) {
                SensorManager sensorManagerZ = z(context);
                sensorManagerZ.registerListener(sensorEventListener, sensorManagerZ.getDefaultSensor(1), z(i));
                sensorManagerZ.registerListener(sensorEventListener, sensorManagerZ.getDefaultSensor(2), z(i));
            }
        } catch (Throwable th) {
            e.z("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void z(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            z(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            e.z("SensorHub", "stopListen error", th);
        }
    }

    public static void z(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
