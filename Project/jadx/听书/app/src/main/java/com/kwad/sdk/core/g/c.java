package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private com.kwad.sdk.core.g.a aJd;
    private a aJe;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aIY = true;
    private long aIZ = 0;
    private double aJa = 9.999999717180685E-10d;
    private double[] aJb = {0.0d, 0.0d, 0.0d};
    private double[] aJc = {0.0d, 0.0d, 0.0d};
    private final bi.b aJf = new bi.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (c.this.aJd != null) {
                c.this.aJd.ce();
            }
        }
    };

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void bG(Context context) {
        if (context == null) {
            return;
        }
        Ja();
        this.aIY = true;
        if (this.aJe == null) {
            this.aJe = new a(this, (byte) 0);
        }
        bi.Rx().a(2, 2, this.aJe, this.aJf);
    }

    public final void b(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(com.kwad.sdk.core.g.a aVar) {
        this.aJd = aVar;
    }

    public final synchronized void bH(Context context) {
        if (context != null) {
            if (this.aJe != null) {
                bi.Rx().a(this.aJe);
                this.aJe = null;
            }
        }
    }

    private void Ja() {
        Arrays.fill(this.aJb, 0.0d);
        Arrays.fill(this.aJc, 0.0d);
        this.aIZ = 0L;
    }

    public final synchronized void Jb() {
        Ja();
        this.aIY = true;
    }

    class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            if (c.this.aIZ != 0) {
                double d = (sensorEvent.timestamp - c.this.aIZ) * c.this.aJa;
                double[] dArr = c.this.aJc;
                dArr[0] = dArr[0] + Math.toDegrees(((double) f) * d);
                double[] dArr2 = c.this.aJc;
                dArr2[1] = dArr2[1] + Math.toDegrees(((double) f2) * d);
                double[] dArr3 = c.this.aJc;
                dArr3[2] = dArr3[2] + Math.toDegrees(((double) f3) * d);
                c.this.Jc();
                c.this.Jd();
            }
            c.this.aIZ = sensorEvent.timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        if (this.aIY) {
            if (Math.abs(this.aJc[0]) > Math.abs(this.aJb[0])) {
                this.aJb[0] = this.aJc[0];
            }
            if (Math.abs(this.aJc[1]) > Math.abs(this.aJb[1])) {
                this.aJb[1] = this.aJc[1];
            }
            if (Math.abs(this.aJc[2]) > Math.abs(this.aJb[2])) {
                this.aJb[2] = this.aJc[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jd() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.aIY || (rotateInfo = this.rotateInfo) == null || this.aJd == null) {
            return;
        }
        if (a(0, rotateInfo.x.rotateDegree, this.rotateInfo.x.direction) || a(1, this.rotateInfo.y.rotateDegree, this.rotateInfo.y.direction) || a(2, this.rotateInfo.z.rotateDegree, this.rotateInfo.z.direction)) {
            this.aIY = false;
            this.aJd.r(Je());
        }
    }

    private String Je() {
        return "{\"x\": " + this.aJb[0] + ",\"y\":" + this.aJb[1] + ",\"z\":" + this.aJb[2] + "}";
    }

    private boolean a(int i, double d, int i2) {
        if (d <= 0.0d || Math.abs(this.aJc[i]) < d) {
            return false;
        }
        double d2 = this.aJc[i];
        return (d2 <= 0.0d || i2 != 1) && (d2 >= 0.0d || i2 != 2);
    }
}
