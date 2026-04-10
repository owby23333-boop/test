package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.common.base.Ascii;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class m1 implements SensorEventListener {
    private static volatile m1 z;
    private int dl;
    private SensorManager g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2538a = 0;
    private float[] gc = new float[3];
    private ArrayList m = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28ecfe", new byte[]{115, 116, 70}));
        z = null;
    }

    private m1(Context context) {
        this.g = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.g = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "79826e", new byte[]{53, 62, 69, 85, 6, 96}));
        }
    }

    private synchronized void a() {
        try {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                if (this.dl == 0) {
                    if (!this.g.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.dl++;
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void gc() {
        try {
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                int i = this.dl - 1;
                this.dl = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ba200", new byte[]{48, 115, 17, 121, Ascii.SUB});
        }
    }

    public static m1 z(Context context) {
        if (z == null) {
            synchronized (m1.class) {
                if (z == null) {
                    z = new m1(context);
                }
            }
        }
        return z;
    }

    public final synchronized String dl() {
        StringBuilder sb = new StringBuilder();
        int size = this.m.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.m;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28f2c7", new byte[]{111}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f414bd", new byte[]{59}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98efac", new byte[]{52}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final synchronized void g() {
        JSONArray jSONArrayZ = z();
        if (jSONArrayZ == null) {
            return;
        }
        this.m.add(jSONArrayZ);
        try {
            int size = this.m.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.m.subList(size - 50, size));
                this.m.clear();
                this.m = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.gc = sensorEvent.values;
        this.f2538a = 1;
    }

    public final JSONArray z() {
        byte b;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            b = pble.z() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            return null;
        }
        a();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.f2538a == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.gc[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.gc[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.gc[2]);
            } catch (Throwable th) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(new BigDecimal(this.gc[0]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.gc[1]).setScale(2, 4));
                jSONArray2.put(new BigDecimal(this.gc[2]).setScale(2, 4));
                gc();
                this.f2538a = 0;
                throw th;
            }
        } catch (Exception unused2) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d1d471", new byte[]{102, 32, Ascii.DC4, 127, 15});
            jSONArray = new JSONArray();
            jSONArray.put(new BigDecimal(this.gc[0]).setScale(2, 4));
            jSONArray.put(new BigDecimal(this.gc[1]).setScale(2, 4));
            bigDecimal = new BigDecimal(this.gc[2]);
        }
        jSONArray.put(bigDecimal.setScale(2, 4));
        gc();
        this.f2538a = 0;
        return jSONArray;
    }
}
