package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.an;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class q implements SensorEventListener {
    private static volatile q z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Sensor f793a;
    private volatile Sensor dl;
    private final SensorManager g;
    private volatile Sensor gc;
    private volatile Sensor m;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean gz = new AtomicBoolean(false);
    private final AtomicBoolean fo = new AtomicBoolean(false);
    private final AtomicBoolean uy = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> kb = new ConcurrentHashMap();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private q(Context context) {
        this.g = (SensorManager) context.getSystemService(an.ac);
    }

    public static q z(Context context) {
        if (z == null) {
            synchronized (q.class) {
                if (z == null) {
                    z = new q(context);
                }
            }
        }
        return z;
    }

    private Sensor g() {
        if (this.dl == null) {
            synchronized (q.class) {
                if (this.dl == null) {
                    this.dl = this.g.getDefaultSensor(1);
                }
            }
        }
        return this.dl;
    }

    private Sensor dl() {
        if (this.f793a == null) {
            synchronized (q.class) {
                if (this.f793a == null) {
                    this.f793a = this.g.getDefaultSensor(15);
                }
            }
        }
        return this.f793a;
    }

    private Sensor a() {
        if (this.gc == null) {
            synchronized (q.class) {
                if (this.gc == null) {
                    this.gc = this.g.getDefaultSensor(4);
                }
            }
        }
        return this.gc;
    }

    private Sensor gc() {
        if (this.m == null) {
            synchronized (q.class) {
                if (this.m == null) {
                    this.m = this.g.getDefaultSensor(10);
                }
            }
        }
        return this.m;
    }

    public Sensor z(int i) {
        if (i == 1) {
            return g();
        }
        if (i == 4) {
            return a();
        }
        if (i == 10) {
            return gc();
        }
        if (i != 15) {
            return null;
        }
        return dl();
    }

    public boolean z(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        this.kb.put(sensorEventListener, 0);
        if (sensor == this.dl) {
            if (!this.e.getAndSet(true)) {
                return this.g.registerListener(this, sensor, i);
            }
        } else if (sensor == this.f793a) {
            if (!this.gz.getAndSet(true)) {
                return this.g.registerListener(this, sensor, i);
            }
        } else if (sensor == this.gc) {
            if (!this.fo.getAndSet(true)) {
                return this.g.registerListener(this, sensor, i);
            }
        } else if (sensor == this.m && !this.uy.getAndSet(true)) {
            return this.g.registerListener(this, sensor, i);
        }
        return true;
    }

    public void z(SensorEventListener sensorEventListener) {
        this.kb.remove(sensorEventListener);
        wp.z("TMe", "--==---- unreg shake size: " + this.kb.size());
        if (this.kb.isEmpty()) {
            try {
                this.g.unregisterListener(this);
            } catch (Throwable th) {
                wp.z(th);
            }
            this.e.set(false);
            this.gz.set(false);
            this.fo.set(false);
            this.uy.set(false);
        }
    }

    public int z() {
        return this.kb.size();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.kb.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }
}
