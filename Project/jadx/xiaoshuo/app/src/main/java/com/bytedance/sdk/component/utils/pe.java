package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes.dex */
public class pe implements SensorEventListener {
    private volatile long bf;
    private Sensor bh;
    private int cv;
    private float d;
    private int f;
    private float ga;
    private float l;
    private volatile long p;
    private Sensor s;
    private Sensor t;
    private float tg;
    private Sensor w;
    private SensorManager wu;
    private float za;
    private long e = 2000;
    private boolean vn = false;
    private float v = 13.0f;
    private float zk = 50.0f;
    private int m = 0;
    private e xu = null;
    private final long k = 500;
    private volatile long dt = 0;
    private volatile boolean pe = false;
    private volatile boolean y = false;
    private final float wl = 1.0E-9f;
    private float[] lc = new float[3];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2097a = 0;
    private float uk = 0.0f;
    private float fy = 4.0f;
    private float h = 0.0f;
    private int x = 1;
    private float[] hb = new float[3];
    private final float bx = 0.0f;
    private float bm = 0.0f;

    public interface e {
        void e(int i);
    }

    public pe(Context context, int i) {
        this.wu = null;
        this.wu = (SensorManager) context.getSystemService("sensor");
        this.cv = i;
    }

    private boolean e(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private void ga() {
        try {
            if (this.f == 0) {
                if (this.t == null) {
                    this.t = this.wu.getDefaultSensor(15);
                }
                this.vn = false;
                this.wu.registerListener(this, this.t, 1);
            }
            int i = this.f;
            if (i == 3 || i == 2) {
                if (this.s == null) {
                    this.s = this.wu.getDefaultSensor(4);
                }
                float f = this.fy;
                if (f != 0.0f && this.f == 2) {
                    this.bm = (float) Math.pow(f, 2.0d);
                    if (this.w == null) {
                        this.w = this.wu.getDefaultSensor(10);
                    }
                    this.wu.registerListener(this, this.w, 1);
                }
                this.wu.registerListener(this, this.s, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void m() {
        this.xu.e(1);
        this.bf = System.currentTimeMillis();
        this.dt = 0L;
        this.y = false;
    }

    private void p() {
        this.dt = 0L;
        this.pe = false;
        this.y = false;
    }

    private void tg() {
        try {
            if (this.bh == null) {
                this.bh = this.wu.getDefaultSensor(1);
            }
            this.wu.registerListener(this, this.bh, 3);
            p();
        } catch (Throwable unused) {
        }
    }

    private boolean v() {
        return this.l > this.v;
    }

    private void vn() {
        if (this.x == 1) {
            float[] fArr = this.hb;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
        }
    }

    private void zk() {
        this.xu.e(1);
        this.bf = System.currentTimeMillis();
    }

    public void bf() {
        SensorManager sensorManager = this.wu;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    public boolean d() {
        return this.pe;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[PHI: r0
  0x00f5: PHI (r0v13 double) = (r0v8 double), (r0v14 double) binds: [B:50:0x0113, B:46:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7 A[PHI: r0
  0x00f7: PHI (r0v9 double) = (r0v8 double), (r0v14 double) binds: [B:50:0x0113, B:46:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r13) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.pe.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void d(float f) {
        this.l = f;
    }

    public void e(e eVar) {
        this.xu = eVar;
    }

    private void bf(SensorEvent sensorEvent) {
        float f = this.za;
        if (f != 0.0f) {
            float f2 = (sensorEvent.timestamp - f) * 1.0E-9f;
            float[] fArr = this.lc;
            boolean z = false;
            float f3 = fArr[0];
            float[] fArr2 = sensorEvent.values;
            float f4 = f3 + (fArr2[0] * f2);
            fArr[0] = f4;
            fArr[1] = fArr[1] + (fArr2[1] * f2);
            fArr[2] = fArr[2] + (fArr2[2] * f2);
            float fAbs = Math.abs((float) Math.toDegrees(f4));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.lc[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.lc[2]));
            if (e(fAbs, this.zk) || e(fAbs2, this.zk) || e(fAbs3, this.zk)) {
                float[] fArr3 = this.lc;
                fArr3[0] = 0.0f;
                fArr3[1] = 0.0f;
                fArr3[2] = 0.0f;
                z = true;
            }
            if (z && System.currentTimeMillis() - this.p > this.e) {
                this.xu.e(2);
                this.p = System.currentTimeMillis();
            }
        }
        this.za = sensorEvent.timestamp;
    }

    public void e() {
        if (this.wu == null) {
            return;
        }
        int i = this.cv;
        if (i == 1) {
            tg();
        } else if (i == 2) {
            ga();
        }
    }

    private void tg(float f) {
        boolean z = false;
        float fAbs = (float) Math.abs(Math.toDegrees(this.hb[0]));
        float fAbs2 = (float) Math.abs(Math.toDegrees(this.hb[1]));
        float fAbs3 = (float) Math.abs(Math.toDegrees(this.hb[2]));
        if (e(fAbs, f) || e(fAbs2, f) || e(fAbs3, f)) {
            float[] fArr = this.hb;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            z = true;
        }
        if (!z || System.currentTimeMillis() - this.p <= this.e) {
            return;
        }
        this.xu.e(2);
        this.p = System.currentTimeMillis();
    }

    private void e(SensorEvent sensorEvent) {
        if (this.f2097a != 0) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = (sensorEvent.timestamp - r0) * 1.0E-9f;
            float f5 = this.uk;
            if (f5 != 0.0f) {
                if (bf(f5, f) && bf(this.uk, f2) && bf(this.uk, f3)) {
                    e(f, f2, f3, f4);
                } else {
                    vn();
                }
            } else {
                float f6 = this.bm;
                if (f6 == 0.0f || this.h < f6) {
                    e(f, f2, f3, f4);
                } else {
                    vn();
                }
            }
            tg(this.zk);
        }
        this.f2097a = sensorEvent.timestamp;
    }

    private void ga(float f) {
        if (System.currentTimeMillis() - this.dt >= 500) {
            this.pe = false;
            m();
        } else if (f >= this.l) {
            this.pe = true;
            m();
        }
    }

    private boolean bf(float f, float f2) {
        return Math.abs(f2) < f;
    }

    public static boolean bf(Context context) {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        try {
            defaultSensor = sensorManager.getDefaultSensor(15);
        } catch (Throwable unused) {
            defaultSensor = null;
        }
        return defaultSensor != null;
    }

    public void bf(float f) {
        this.zk = f;
    }

    public void bf(int i) {
        SensorManager sensorManager;
        if (i != 3 && i != 2) {
            this.f = 0;
            return;
        }
        if (this.s == null && (sensorManager = this.wu) != null) {
            this.s = sensorManager.getDefaultSensor(4);
        }
        if (this.s == null) {
            this.f = 0;
        } else {
            this.f = i;
        }
    }

    private void e(float f, float f2, float f3, float f4) {
        float[] fArr = this.hb;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    public static boolean e(Context context) {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        try {
            defaultSensor = sensorManager.getDefaultSensor(1);
        } catch (Throwable unused) {
            defaultSensor = null;
        }
        return defaultSensor != null;
    }

    public void e(float f) {
        this.v = f;
    }

    public void e(int i) {
        this.m = i;
    }

    private float e(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }
}
