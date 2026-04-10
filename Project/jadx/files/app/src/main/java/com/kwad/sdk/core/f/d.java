package com.kwad.sdk.core.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.umeng.analytics.pro.am;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private float alC;

    @Nullable
    private b alD;

    @Nullable
    private a alE;
    private volatile boolean alu = true;

    class a implements SensorEventListener {
        private Random agR;
        private boolean alG;
        private final float[] alF = {0.0f, 0.0f, 9.8f};
        private final float[] alH = {0.0f, 0.0f, 0.0f};

        public a() {
            this.alG = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.alG = false;
            }
        }

        private void a(float[] fArr) {
            b(fArr);
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            double dSqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
            if (!d.this.alu || dSqrt < d.this.alC || d.this.alD == null) {
                return;
            }
            d.a(d.this, false);
            d.this.alD.a(dSqrt);
        }

        private void b(float[] fArr) {
            float f2 = fArr[0] * 0.6f;
            float[] fArr2 = this.alH;
            fArr[0] = f2 + (fArr2[0] * 0.39999998f);
            fArr[1] = (fArr[1] * 0.6f) + (fArr2[1] * 0.39999998f);
            fArr[2] = (fArr[2] * 0.6f) + (fArr2[2] * 0.39999998f);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        private void xT() {
            if (this.agR == null) {
                this.agR = new Random();
            }
            if (this.agR.nextInt(100) == 1) {
                a(this.alF);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.alG) {
                xT();
            }
        }
    }

    public d(float f2) {
        if (f2 <= 0.0f) {
            this.alC = 5.0f;
        } else {
            this.alC = f2;
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z2) {
        dVar.alu = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.alD = bVar;
    }

    public final void bi(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect context is null");
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        if (defaultSensor != null) {
            if (this.alE == null) {
                this.alE = new a();
            }
            sensorManager.registerListener(this.alE, defaultSensor, 2);
        } else {
            b bVar = this.alD;
            if (bVar != null) {
                bVar.bd();
            }
            com.kwad.sdk.core.d.b.d("ShakeDetector", "startDetect default linear acceleration is null");
        }
    }

    public final synchronized void bj(Context context) {
        if (context != null) {
            if (this.alE != null) {
                ((SensorManager) context.getSystemService(am.ac)).unregisterListener(this.alE);
                this.alE = null;
            }
        }
    }

    public final void e(float f2) {
        this.alC = f2;
    }

    public final synchronized void xP() {
        this.alu = true;
    }
}
