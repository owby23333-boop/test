package com.bytedance.sdk.component.panglearmor.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.panglearmor.m;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements SensorEventListener {
    private static volatile a z;
    private volatile z js;
    private Sensor pf;
    private Sensor v;
    private volatile boolean g = false;
    private final List<Float> dl = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Float> f782a = new ArrayList(1);
    private final List<Float> gc = new ArrayList(1);
    private final List<Float> m = new ArrayList(1);
    private final List<Float> e = new ArrayList(1);
    private final List<Float> gz = new ArrayList(1);
    private final int fo = 0;
    private final int uy = 1;
    private final int kb = 2;
    private final int wp = 16;
    private final int i = 32;
    private long ls = 0;
    private volatile boolean p = false;
    private volatile AtomicInteger fv = new AtomicInteger(0);
    private volatile int tb = 0;

    public interface z {
        void z(JSONObject jSONObject);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private a() {
        this.v = null;
        this.pf = null;
        SensorManager sensorManager = (SensorManager) m.a().getApplicationContext().getSystemService(an.ac);
        if (sensorManager != null) {
            try {
                this.v = sensorManager.getDefaultSensor(1);
                this.pf = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public void z(z zVar) {
        this.js = zVar;
    }

    public synchronized boolean g() {
        int i;
        int i2;
        this.tb = 0;
        if (this.p) {
            return false;
        }
        if (this.v != null && this.pf != null) {
            this.p = false;
            SensorManager sensorManager = (SensorManager) m.a().getApplicationContext().getSystemService(an.ac);
            i = 1;
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.v, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.pf, 1);
                    if (!zRegisterListener || !zRegisterListener2) {
                        this.tb |= 32;
                        gc();
                        e();
                    } else {
                        this.p = true;
                        this.g = false;
                    }
                } catch (Exception unused) {
                    i2 = this.tb;
                    i = 32;
                    this.tb = i2 | i;
                }
                return this.p;
            }
            i2 = this.tb;
        } else {
            this.tb |= this.v == null ? 2 : 0;
            int i3 = this.tb;
            i = this.pf == null ? 16 : 0;
            i2 = i3;
        }
        this.tb = i2 | i;
        return this.p;
    }

    private void gc() {
        this.fv = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) m.a().getApplicationContext().getSystemService(an.ac);
        if (sensorManager != null) {
            Sensor sensor = this.v;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.pf;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.fv.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.dl.size() <= 0) {
                this.dl.add(Float.valueOf(sensorEvent.values[0]));
                this.f782a.add(Float.valueOf(sensorEvent.values[1]));
                this.gc.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            m();
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.m.size() <= 0) {
            this.m.add(Float.valueOf(sensorEvent.values[0]));
            this.e.add(Float.valueOf(sensorEvent.values[1]));
            this.gz.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float[] fArr) {
        this.ls = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.aI, a());
            jSONObject.put("val", new JSONArray(fArr));
            g.z().z(jSONObject, "sp_angle");
            g.z().z(v.dl(m.a()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void m() {
        if (!this.g && this.dl.size() > 0 && this.m.size() > 0) {
            this.g = true;
            gc();
            e.g(new fo("har") { // from class: com.bytedance.sdk.component.panglearmor.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrZ = dl.z(a.this.dl, a.this.f782a, a.this.gc, a.this.m, a.this.e, a.this.gz);
                        a.this.z(fArrZ);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jM = gc.z().m();
                        long jE = gc.z().e();
                        int iDl = (int) (((gc.z().dl() / 1000) / 60) / 60);
                        if (iDl <= 0) {
                            iDl = 1;
                        }
                        jSONObject.put("azimuth_unit", jM);
                        jSONObject.put("angle_unit", jE);
                        LinkedList<JSONObject> linkedListZ = g.z().z(0L);
                        jSONObject.put("active", Arrays.toString(dl.z(linkedListZ, iDl)));
                        com.bytedance.sdk.component.panglearmor.g.z.z().z(iDl);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.g.z.z().dl()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.g.z.z().g()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.g.z.z().a());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.g.z.z().gc());
                        int[][] iArrZ = dl.z(linkedListZ, jM, jE);
                        jSONObject.put("ax", Arrays.toString(iArrZ[0]));
                        jSONObject.put("ay", Arrays.toString(iArrZ[1]));
                        jSONObject.put("az", Arrays.toString(iArrZ[2]));
                        int[][] iArrZ2 = dl.z(g.z().z(10800000L), jM, jE);
                        jSONObject.put("ax3", Arrays.toString(iArrZ2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrZ2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrZ2[2]));
                        int[][] iArrZ3 = dl.z(g.z().z(21600000L), jM, jE);
                        jSONObject.put("ax6", Arrays.toString(iArrZ3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrZ3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrZ3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrZ));
                        jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (a.this.js != null) {
                        a.this.js.z(jSONObject);
                    }
                    a.this.e();
                    a.this.p = false;
                }
            });
        } else {
            if (this.fv.get() > 3) {
                gc();
                e();
                this.p = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.dl.clear();
        this.f782a.clear();
        this.gc.clear();
        this.m.clear();
        this.e.clear();
        this.gz.clear();
    }

    public boolean dl() {
        return this.p;
    }

    public long a() {
        return this.ls;
    }
}
