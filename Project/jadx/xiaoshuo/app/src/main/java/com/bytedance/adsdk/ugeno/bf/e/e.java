package com.bytedance.adsdk.ugeno.bf.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes.dex */
public class e implements SensorEventListener {
    private volatile long bf;
    private float d;
    private float ga;
    private boolean m;
    private volatile long p;
    private Sensor s;
    private Sensor t;
    private float tg;
    private float w;
    private SensorManager xu;
    private long e = 2000;
    private boolean vn = false;
    private float v = 13.0f;
    private float zk = 50.0f;
    private int wu = 0;
    private InterfaceC0065e bh = null;
    private final long l = 500;
    private volatile long f = 0;
    private volatile boolean k = false;
    private volatile boolean dt = false;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.bf.e.e$e, reason: collision with other inner class name */
    public interface InterfaceC0065e {
        void e(int i);
    }

    public e(Context context) {
        this.xu = null;
        this.xu = (SensorManager) context.getSystemService("sensor");
    }

    private void d() {
        this.f = 0L;
        this.k = false;
        this.dt = false;
    }

    private void ga() {
        this.bh.e(1);
        this.bf = System.currentTimeMillis();
    }

    private boolean tg() {
        return this.w > this.v;
    }

    private void vn() {
        this.bh.e(1);
        this.bf = System.currentTimeMillis();
        this.f = 0L;
        this.dt = false;
    }

    public void bf() {
        SensorManager sensorManager = this.xu;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.m = false;
    }

    public void e(InterfaceC0065e interfaceC0065e) {
        this.bh = interfaceC0065e;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[PHI: r4
  0x00bb: PHI (r4v11 double) = (r4v6 double), (r4v12 double) binds: [B:40:0x00db, B:36:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd A[PHI: r4
  0x00bd: PHI (r4v7 double) = (r4v6 double), (r4v12 double) binds: [B:40:0x00db, B:36:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r12) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.bf.e.e.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void e() {
        SensorManager sensorManager = this.xu;
        if (sensorManager == null || this.m) {
            return;
        }
        try {
            if (this.t == null) {
                this.t = sensorManager.getDefaultSensor(1);
            }
            if (this.s == null) {
                this.s = this.xu.getDefaultSensor(15);
            }
        } catch (Throwable unused) {
        }
        try {
            this.vn = false;
            this.xu.registerListener(this, this.t, 3);
            this.xu.registerListener(this, this.s, 1);
            this.m = true;
            d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bf(float f) {
        if (System.currentTimeMillis() - this.f >= 500) {
            this.k = false;
            vn();
        } else if (f >= this.w) {
            this.k = true;
            vn();
        }
    }

    public void e(float f) {
        this.v = f;
    }

    private float e(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }
}
