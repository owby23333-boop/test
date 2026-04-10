package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.media3.exoplayer.ExoPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class iq implements SensorEventListener {
    private static zw b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f792a;
    private float dl;
    private volatile long e;
    private float fv;
    private volatile long g;
    private float gc;
    private int io;
    private float j;
    private int js;
    private q kb;
    private Sensor ls;
    private float na;
    private float oq;
    private Sensor p;
    private Sensor pf;
    private boolean qd;
    private float sy;
    private JSONObject un;
    private Sensor v;
    private dl yx;
    private Context zx;
    private final long z = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private boolean m = false;
    private float gz = 13.0f;
    private float fo = 50.0f;
    private int uy = 0;
    private z wp = null;
    private g i = null;
    private final long tb = 500;
    private volatile long q = 0;
    private volatile boolean iq = false;
    private volatile boolean zw = false;
    private final float uf = 1.0E-9f;
    private float[] hh = new float[3];
    private long l = 0;
    private float h = 0.0f;
    private float gk = 4.0f;
    private float x = 0.0f;
    private float[] lq = new float[3];
    private final float mc = 0.0f;
    private boolean ti = false;
    private boolean eo = false;
    private boolean wj = false;
    private boolean xl = false;
    private int gp = 0;
    private int t = 0;
    private int vm = 0;
    private int y = 0;
    private int ec = 0;
    private int bv = 0;
    private boolean gb = false;
    private int jq = 0;
    private int sv = 0;
    private float f = 0.0f;

    public interface dl {
        void z();
    }

    public interface g {
        void z(float f, float f2, float f3);
    }

    public interface z {
        void z(int i);
    }

    private int m(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private float z(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private boolean z(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean z(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean z(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public iq(Context context, int i, boolean z2) {
        this.kb = null;
        this.qd = z2;
        this.io = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.zx = applicationContext;
        if (applicationContext == null) {
            return;
        }
        wp.z("xgc_cus", "cus:" + z2);
        if (z2) {
            this.kb = q.z(this.zx);
        }
    }

    public void z(boolean z2) {
        Context context;
        wp.z("xgcc", "cus:" + z2 + " m:" + this.qd + " equ:" + (this.kb != null));
        if (!z2) {
            q qVar = this.kb;
            if (qVar != null) {
                qVar.z(this);
                this.kb = null;
                return;
            }
            return;
        }
        if (this.qd || this.kb != null || (context = this.zx) == null) {
            return;
        }
        this.kb = q.z(context);
    }

    public void z(z zVar) {
        this.wp = zVar;
    }

    public void z(g gVar) {
        this.i = gVar;
    }

    private boolean g() {
        q qVar = this.kb;
        if (qVar == null) {
            return false;
        }
        try {
            if (this.uy == 4) {
                return dl();
            }
            if (this.v == null) {
                this.v = qVar.z(1);
            }
            boolean z2 = this.kb.z(this, this.v, 3);
            m();
            return z2;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean dl() {
        int i;
        q qVar = this.kb;
        boolean z2 = false;
        if (qVar == null) {
            return false;
        }
        try {
            if (this.js == 0) {
                if (this.pf == null) {
                    this.pf = qVar.z(15);
                }
                this.m = false;
                z2 = this.kb.z(this, this.pf, 1);
            }
            int i2 = this.js;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.ls == null) {
                    this.ls = this.kb.z(4);
                }
                float f = this.gk;
                if (f != 0.0f && ((i = this.js) == 2 || i == 4)) {
                    this.f = (float) Math.pow(f, 2.0d);
                    if (this.p == null) {
                        this.p = this.kb.z(10);
                    }
                    this.kb.z(this, this.p, 1);
                }
                z2 = this.kb.z(this, this.ls, 1);
            }
            e();
        } catch (Throwable unused) {
        }
        return z2;
    }

    public static void z(zw zwVar) {
        b = zwVar;
    }

    public boolean z(int i) {
        zw zwVar;
        if (i > 0 && (zwVar = b) != null && !zwVar.z(i)) {
            b.z(i, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.iq.1
                @Override // java.lang.Runnable
                public void run() {
                    iq.this.a();
                }
            });
            return true;
        }
        return a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (this.kb == null || this.gb) {
            return false;
        }
        int i = this.io;
        if (i == 1) {
            return g();
        }
        if (i == 2) {
            return dl();
        }
        return false;
    }

    public void g(int i) {
        gc();
        zw zwVar = b;
        if (zwVar != null) {
            zwVar.z(i, hashCode());
        }
    }

    private void gc() {
        q qVar = this.kb;
        if (qVar == null) {
            return;
        }
        qVar.z(this);
    }

    public void dl(int i) {
        this.gb = false;
        z(i);
    }

    public void a(int i) {
        this.gb = true;
        g(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        dl dlVar = this.yx;
        if (dlVar != null) {
            dlVar.z();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.wp == null || System.currentTimeMillis() - this.g <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                return;
            }
            int i = this.uy;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                z(dSqrt > ((double) this.gz), dSqrt);
                return;
            } else if (i == 2) {
                g(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.gz), sensorEvent);
                return;
            } else if (i == 3) {
                z(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.gz), sensorEvent);
                return;
            } else {
                double dZ = z(fAbs, fAbs2, fAbs3);
                z(dZ > ((double) this.gz), dZ);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.js;
            if (i2 == 3) {
                g(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    z(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            this.x = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        g gVar = this.i;
        if (gVar != null) {
            gVar.z(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.m) {
            this.m = true;
            this.dl = fAbs4;
            this.f792a = fAbs5;
            this.gc = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.dl) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.f792a) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.gc) * 180.0f;
        if (this.ti) {
            boolean z2 = this.eo && fAbs7 > this.oq;
            boolean z3 = this.wj && fAbs8 > this.na;
            boolean z4 = this.xl && fAbs9 > this.j;
            if ((z2 || z3 || z4) && this.wp != null && System.currentTimeMillis() - this.e > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                this.wp.z(getType());
                this.e = System.currentTimeMillis();
                this.m = false;
                return;
            }
            return;
        }
        float f = this.fo;
        if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.wp != null && System.currentTimeMillis() - this.e > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.wp.z(getType());
            this.e = System.currentTimeMillis();
            this.m = false;
        }
    }

    private void z(SensorEvent sensorEvent) {
        if (this.l != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.l) * 1.0E-9f;
            float f5 = this.h;
            if (f5 != 0.0f) {
                if (!g(f5, f) || !g(this.h, f2) || !g(this.h, f3)) {
                    g(true);
                } else {
                    z(f, f2, f3, f4);
                }
            } else {
                float f6 = this.f;
                if (f6 != 0.0f && this.x >= f6) {
                    g(true);
                } else {
                    z(f, f2, f3, f4);
                }
            }
            if (this.js == 7) {
                e(this.fo);
            } else {
                a(this.fo);
            }
            g gVar = this.i;
            if (gVar != null) {
                float[] fArr = this.lq;
                gVar.z(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.l = sensorEvent.timestamp;
    }

    private void g(SensorEvent sensorEvent) {
        boolean z2;
        if (this.sy != 0.0f) {
            float f = (sensorEvent.timestamp - this.sy) * 1.0E-9f;
            float[] fArr = this.hh;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.hh;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.hh;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.hh[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.hh[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.hh[2]));
            if (this.ti) {
                boolean z3 = this.eo && z(fAbs, this.oq);
                boolean z4 = this.wj && z(fAbs2, this.na);
                boolean z5 = this.xl && z(fAbs3, this.j);
                if (z3 || z4 || z5) {
                    float[] fArr4 = this.hh;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z2 = true;
                }
                z2 = false;
            } else {
                if (z(fAbs, this.fo) || z(fAbs2, this.fo) || z(fAbs3, this.fo)) {
                    float[] fArr5 = this.hh;
                    fArr5[0] = 0.0f;
                    fArr5[1] = 0.0f;
                    fArr5[2] = 0.0f;
                    z2 = true;
                }
                z2 = false;
            }
            if (z2 && System.currentTimeMillis() - this.e > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                z zVar = this.wp;
                if (zVar != null) {
                    zVar.z(getType());
                }
                this.e = System.currentTimeMillis();
            }
            g gVar = this.i;
            if (gVar != null) {
                float[] fArr6 = this.hh;
                gVar.z(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.sy = sensorEvent.timestamp;
    }

    private void a(float f) {
        if (!z(this.js == 4, f) || System.currentTimeMillis() - this.e <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return;
        }
        z zVar = this.wp;
        if (zVar != null) {
            zVar.z(getType());
        }
        this.e = System.currentTimeMillis();
    }

    private boolean z(boolean z2, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.lq[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.lq[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.lq[2]));
        if (this.ti) {
            boolean z3 = this.eo && z(fAbs, this.oq);
            boolean z4 = this.wj && z(fAbs2, this.na);
            boolean z5 = this.xl && z(fAbs3, this.j);
            if (z3 || z4 || z5) {
                return z(z2, z3, z4, z5);
            }
            return false;
        }
        boolean z6 = z(fAbs, f);
        boolean z7 = z(fAbs2, f);
        boolean z8 = z(fAbs3, f);
        if (z6 || z7 || z8) {
            return z(z2, z6, z7, z8);
        }
        return false;
    }

    private void z(float f, float f2, float f3, float f4) {
        float[] fArr = this.lq;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean g(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void g(boolean z2) {
        float[] fArr = this.lq;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void z(float f) {
        this.gz = f;
    }

    public void z(dl dlVar) {
        this.yx = dlVar;
    }

    public void g(float f) {
        this.fo = f;
    }

    public void z(JSONObject jSONObject) {
        if (this.io != 2) {
            return;
        }
        this.un = jSONObject;
        if (jSONObject == null) {
            this.eo = false;
            this.wj = false;
            this.xl = false;
        } else {
            this.eo = jSONObject.has("x_threshold");
            this.oq = z(this.un.optDouble("x_threshold", 50.0d));
            this.wj = this.un.has("y_threshold");
            this.na = z(this.un.optDouble("y_threshold", 50.0d));
            this.xl = this.un.has("z_threshold");
            this.j = z(this.un.optDouble("z_threshold", 50.0d));
        }
        this.ti = this.eo || this.wj || this.xl;
    }

    public void g(JSONObject jSONObject) {
        if (this.io != 2) {
            return;
        }
        if (jSONObject == null) {
            this.sv = 0;
        } else {
            this.sv = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void dl(JSONObject jSONObject) {
        if (this.io != 1) {
            return;
        }
        if (jSONObject == null) {
            this.jq = 0;
            this.sv = 0;
        } else {
            this.jq = jSONObject.optInt("double_direct_conf", 0);
            this.sv = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void gc(int i) {
        this.uy = i;
    }

    private void m() {
        this.q = 0L;
        this.iq = false;
        this.zw = false;
        this.gp = 0;
        this.t = 0;
        this.vm = 0;
        this.y = 0;
        this.ec = 0;
        this.bv = 0;
    }

    private void e() {
        this.gp = 0;
        this.t = 0;
        this.vm = 0;
    }

    private void gc(float f) {
        if (System.currentTimeMillis() - this.q >= 500) {
            this.iq = false;
            uy();
        } else if (f >= this.fv) {
            this.iq = true;
            uy();
        }
    }

    public boolean z() {
        return this.iq;
    }

    private boolean gz() {
        return this.fv > this.gz;
    }

    private void fo() {
        z zVar = this.wp;
        if (zVar != null) {
            zVar.z(getType());
        }
        this.g = System.currentTimeMillis();
    }

    private void uy() {
        z zVar = this.wp;
        if (zVar != null) {
            zVar.z(getType());
        }
        this.g = System.currentTimeMillis();
        this.q = 0L;
        this.zw = false;
    }

    private float z(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void dl(float f) {
        this.fv = f;
    }

    public void m(int i) {
        q qVar = this.kb;
        if (qVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.ls == null && qVar != null) {
                this.ls = qVar.z(4);
            }
            if (this.ls != null) {
                this.js = i;
                return;
            }
        }
        this.js = 0;
    }

    private void z(boolean z2, double d) {
        if (!gz() && z2) {
            fo();
            return;
        }
        if (z2) {
            this.q = System.currentTimeMillis();
            this.zw = true;
            gc((float) d);
        } else {
            if (!this.zw || System.currentTimeMillis() - this.q < 500) {
                return;
            }
            this.iq = false;
            uy();
        }
    }

    private void z(boolean z2, SensorEvent sensorEvent) {
        if (z2) {
            float[] fArr = sensorEvent.values;
            int iZ = z(fArr[0], this.gp);
            int iZ2 = z(fArr[1], this.t);
            int iZ3 = z(fArr[2], this.vm);
            if (g(iZ, iZ2, iZ3, false)) {
                z(iZ, iZ2, iZ3, true);
                fo();
                return;
            }
            this.gp |= iZ;
            if (iZ <= 0) {
                iZ = this.y;
            }
            this.y = iZ;
            this.t |= iZ2;
            if (iZ2 <= 0) {
                iZ2 = this.ec;
            }
            this.ec = iZ2;
            this.vm |= iZ3;
            if (iZ3 <= 0) {
                iZ3 = this.bv;
            }
            this.bv = iZ3;
        }
    }

    private void g(boolean z2, SensorEvent sensorEvent) {
        if (z2) {
            float[] fArr = sensorEvent.values;
            int iZ = z(fArr[0], this.gp);
            int iZ2 = z(fArr[1], this.t);
            int iZ3 = z(fArr[2], this.vm);
            if (g(iZ, iZ2, iZ3, true)) {
                z(iZ, iZ2, iZ3, true);
                fo();
            } else if (this.sv == 1) {
                this.gp = iZ;
                this.t = iZ2;
                this.vm = iZ3;
            } else {
                this.gp = iZ | this.gp;
                this.t |= iZ2;
                this.vm = iZ3 | this.vm;
            }
        }
    }

    private boolean z(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z2) {
            g(false);
            return true;
        }
        int iM = z3 ? m(this.lq[0]) : 0;
        int iM2 = z4 ? m(this.lq[1]) : 0;
        int iM3 = z5 ? m(this.lq[2]) : 0;
        if (this.js != 7) {
            g(false);
        }
        if (z(iM, this.gp) || z(iM2, this.t) || z(iM3, this.vm)) {
            z(iM, iM2, iM3, true);
            return true;
        }
        if (this.sv != 1) {
            z(iM, iM2, iM3, false);
        } else if (z3 || z4 || z5) {
            this.gp = iM;
            this.t = iM2;
            this.vm = iM3;
        }
        return false;
    }

    private void z(int i, int i2, int i3, boolean z2) {
        if (z2) {
            this.gp = 0;
            this.t = 0;
            this.vm = 0;
            this.y = 0;
            this.ec = 0;
            this.bv = 0;
            return;
        }
        if (i == 0) {
            i = this.gp;
        }
        this.gp = i;
        if (i2 == 0) {
            i2 = this.t;
        }
        this.t = i2;
        if (i3 == 0) {
            i3 = this.vm;
        }
        this.vm = i3;
    }

    private int z(float f, int i) {
        if (f != 0.0f) {
            return m(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    private boolean g(int i, int i2, int i3, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4 = this.jq;
        if (i4 == 1) {
            int i5 = this.vm;
            z3 = z2 ? z(i3, i5) : z(i3, i5, this.bv);
        } else if (i4 == 2) {
            int i6 = this.t;
            z3 = z2 ? z(i2, i6) : z(i2, i6, this.ec);
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z2) {
                        z4 = z(i, this.gp);
                        z5 = z(i2, this.t);
                        z6 = z(i3, this.vm);
                    } else {
                        z4 = z(i, this.gp, this.y);
                        z5 = z(i2, this.t, this.ec);
                        z6 = z(i3, this.vm, this.bv);
                    }
                    if (z4 || z5 || z6) {
                        return true;
                    }
                } else if (z2) {
                    if (z(i, this.gp) && z(i2, this.t) && z(i3, this.vm)) {
                        return true;
                    }
                } else if (z(i, this.gp, this.y) && z(i2, this.t, this.ec) && z(i3, this.vm, this.bv)) {
                    return true;
                }
                return false;
            }
            int i7 = this.gp;
            z3 = z2 ? z(i, i7) : z(i, i7, this.y);
        }
        return z3;
    }

    private void e(float f) {
        if (!z(this.js == 7, f) || System.currentTimeMillis() - this.e <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return;
        }
        g(false);
        z zVar = this.wp;
        if (zVar != null) {
            zVar.z(getType());
        }
        this.e = System.currentTimeMillis();
    }

    private int getType() {
        return this.io == 2 ? 2 : 1;
    }
}
