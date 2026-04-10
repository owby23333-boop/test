package com.anythink.expressad.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.anythink.core.common.b.n;
import com.umeng.analytics.pro.am;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f11211c;
    Sensor a;
    private SensorManager b;

    private a() {
        Context contextG = n.a().g();
        if (contextG != null) {
            try {
                if (this.b == null) {
                    this.b = (SensorManager) contextG.getSystemService(am.ac);
                }
                if (this.a == null) {
                    this.a = this.b.getDefaultSensor(1);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static a a() {
        if (f11211c == null) {
            synchronized (a.class) {
                if (f11211c == null) {
                    f11211c = new a();
                }
            }
        }
        return f11211c;
    }

    public final boolean b() {
        return this.a != null;
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(SensorEventListener sensorEventListener) {
        try {
            this.b.registerListener(sensorEventListener, this.a, 2);
        } catch (Throwable unused) {
        }
    }
}
