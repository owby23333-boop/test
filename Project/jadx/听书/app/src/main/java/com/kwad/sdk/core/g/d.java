package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bi;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static float aJi = 9.81f;
    private static double aJj = 0.01d;
    private volatile boolean aIY = true;
    private final bi.b aJf = new bi.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (d.this.aJk != null) {
                d.this.aJk.cd();
            }
        }
    };
    private float aJh;
    private b aJk;
    private a aJl;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aIY = false;
        return false;
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.aJh = 5.0f;
        } else {
            this.aJh = f;
        }
    }

    public final void bG(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aIY = true;
        if (this.aJl == null) {
            this.aJl = new a();
        }
        bi.Rx().a(1, 2, this.aJl, this.aJf);
    }

    public final void g(float f) {
        this.aJh = f;
    }

    public final synchronized void Jb() {
        this.aIY = true;
    }

    public final void a(b bVar) {
        this.aJk = bVar;
    }

    public final synchronized void bH(Context context) {
        if (context != null) {
            if (this.aJl != null) {
                bi.Rx().a(this.aJl);
                this.aJl = null;
            }
        }
    }

    class a implements SensorEventListener {
        private Random aFu;
        private boolean aJo;
        private final float[] aJn = {0.0f, 0.0f, 9.8f};
        private final float[] aJp = {0.0f, 0.0f, 0.0f};

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a() {
            this.aJo = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
                this.aJo = false;
            }
        }

        private void Jh() {
            if (this.aFu == null) {
                this.aFu = new Random();
            }
            if (this.aFu.nextInt(100) == 1) {
                a(this.aJn);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aJo) {
                Jh();
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double dAbs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                dAbs = Math.abs(dAbs - ((double) d.aJi));
            }
            if (!d.this.aIY || dAbs < d.this.aJh || d.this.aJk == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aJk.a(dAbs);
        }

        private static boolean b(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)))) - ((double) d.aJi)) <= d.aJj;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aJp;
            float f = fArr2[0];
            float f2 = (f == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f3 = 1.0f - f2;
            fArr[0] = (fArr[0] * f2) + (f * f3);
            fArr[1] = (fArr[1] * f2) + (fArr2[1] * f3);
            fArr[2] = (f2 * fArr[2]) + (f3 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }
    }
}
