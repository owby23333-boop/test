package com.king.zxing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.king.zxing.camera.FrontLightMode;
import com.umeng.analytics.pro.am;

/* JADX INFO: compiled from: AmbientLightManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements SensorEventListener {
    private float a = 45.0f;
    private float b = 100.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f16492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.king.zxing.camera.d f16493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Sensor f16494e;

    f(Context context) {
        this.f16492c = context;
    }

    void a(com.king.zxing.camera.d dVar) {
        this.f16493d = dVar;
        if (FrontLightMode.a(PreferenceManager.getDefaultSharedPreferences(this.f16492c)) == FrontLightMode.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f16492c.getSystemService(am.ac);
            this.f16494e = sensorManager.getDefaultSensor(5);
            Sensor sensor = this.f16494e;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3);
            }
        }
    }

    public void b(float f2) {
        this.a = f2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        com.king.zxing.camera.d dVar = this.f16493d;
        if (dVar != null) {
            if (f2 <= this.a) {
                dVar.a(true, f2);
            } else if (f2 >= this.b) {
                dVar.a(false, f2);
            }
        }
    }

    void a() {
        if (this.f16494e != null) {
            ((SensorManager) this.f16492c.getSystemService(am.ac)).unregisterListener(this);
            this.f16493d = null;
            this.f16494e = null;
        }
    }

    public void a(float f2) {
        this.b = f2;
    }
}
