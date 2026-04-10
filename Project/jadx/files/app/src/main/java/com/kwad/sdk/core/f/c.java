package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.umeng.analytics.pro.am;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @Nullable
    private a alA;
    private volatile boolean alu = true;
    private long alv = 0;
    private double alw = 9.999999717180685E-10d;
    private double[] alx = {PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE};
    private double[] aly = {PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE};

    @Nullable
    private com.kwad.sdk.core.f.a alz;
    private AdMatrixInfo.RotateInfo rotateInfo;

    class a implements SensorEventListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if (c.this.alv != 0) {
                double d2 = sensorEvent.timestamp - c.this.alv;
                double d3 = c.this.alw;
                Double.isNaN(d2);
                double d4 = d2 * d3;
                double[] dArr = c.this.aly;
                double d5 = dArr[0];
                double d6 = f2;
                Double.isNaN(d6);
                dArr[0] = d5 + Math.toDegrees(d6 * d4);
                double[] dArr2 = c.this.aly;
                double d7 = dArr2[1];
                double d8 = f3;
                Double.isNaN(d8);
                dArr2[1] = d7 + Math.toDegrees(d8 * d4);
                double[] dArr3 = c.this.aly;
                double d9 = dArr3[2];
                double d10 = f4;
                Double.isNaN(d10);
                dArr3[2] = d9 + Math.toDegrees(d10 * d4);
                c.this.xQ();
                c.this.xR();
            }
            c.this.alv = sensorEvent.timestamp;
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private boolean a(int i2, double d2, int i3) {
        if (d2 <= PangleAdapterUtils.CPM_DEFLAUT_VALUE || Math.abs(this.aly[i2]) < d2) {
            return false;
        }
        return (this.aly[i2] <= PangleAdapterUtils.CPM_DEFLAUT_VALUE || i3 != 1) && (this.aly[i2] >= PangleAdapterUtils.CPM_DEFLAUT_VALUE || i3 != 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ() {
        if (this.alu) {
            if (Math.abs(this.aly[0]) > Math.abs(this.alx[0])) {
                this.alx[0] = this.aly[0];
            }
            if (Math.abs(this.aly[1]) > Math.abs(this.alx[1])) {
                this.alx[1] = this.aly[1];
            }
            if (Math.abs(this.aly[2]) > Math.abs(this.alx[2])) {
                this.alx[2] = this.aly[2];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (!this.alu || (rotateInfo = this.rotateInfo) == null || this.alz == null) {
            return;
        }
        if (!a(0, r0.rotateDegree, rotateInfo.f16961x.direction)) {
            if (!a(1, r1.rotateDegree, this.rotateInfo.f16962y.direction)) {
                if (!a(2, r1.rotateDegree, this.rotateInfo.f16963z.direction)) {
                    return;
                }
            }
        }
        this.alu = false;
        this.alz.ab(xS());
        this.aly = new double[]{PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE};
        this.alx = new double[]{PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE, PangleAdapterUtils.CPM_DEFLAUT_VALUE};
    }

    private String xS() {
        return "{\"x\": " + this.alx[0] + ",\"y\":" + this.alx[1] + ",\"z\":" + this.alx[2] + "}";
    }

    public final void a(@Nullable com.kwad.sdk.core.f.a aVar) {
        this.alz = aVar;
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void bi(Context context) {
        if (context == null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            if (this.alA == null) {
                this.alA = new a(this, (byte) 0);
            }
            sensorManager.registerListener(this.alA, defaultSensor, 2);
        } else {
            com.kwad.sdk.core.f.a aVar = this.alz;
            if (aVar != null) {
                aVar.lv();
            }
        }
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.alA != null) {
                ((SensorManager) context.getSystemService(am.ac)).unregisterListener(this.alA);
                this.alA = null;
            }
        }
    }

    public final synchronized void xP() {
        this.alu = true;
    }
}
