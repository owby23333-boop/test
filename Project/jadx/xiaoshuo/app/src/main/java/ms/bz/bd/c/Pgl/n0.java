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

/* JADX INFO: loaded from: classes9.dex */
public final class n0 implements SensorEventListener {
    private static volatile n0 e;
    private SensorManager bf;
    private int d;
    private int tg = 0;
    private float[] ga = new float[3];
    private List<JSONArray> vn = new ArrayList();

    static {
        new DecimalFormat((String) pblk.a(16777217, 0, 0L, "a38c7f", new byte[]{32, 127, Ascii.ESC}));
        e = null;
    }

    private n0(Context context) {
        this.bf = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.bf = (SensorManager) applicationContext.getSystemService((String) pblk.a(16777217, 0, 0L, "6426b9", new byte[]{52, 51, 79, 81, 82, 60}));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void d() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            android.hardware.SensorManager r1 = r8.bf     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            if (r1 == 0) goto L3c
            int r2 = r8.d     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            int r2 = r2 - r0
            r8.d = r2     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            if (r2 != 0) goto L3c
            r1.unregisterListener(r8)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L13
            goto L3c
        L11:
            r0 = move-exception
            goto L3e
        L13:
            r1 = 5
            byte[] r7 = new byte[r1]     // Catch: java.lang.Throwable -> L11
            r1 = 0
            r2 = 53
            r7[r1] = r2     // Catch: java.lang.Throwable -> L11
            r1 = 119(0x77, float:1.67E-43)
            r7[r0] = r1     // Catch: java.lang.Throwable -> L11
            r0 = 2
            r1 = 73
            r7[r0] = r1     // Catch: java.lang.Throwable -> L11
            r0 = 3
            r1 = 127(0x7f, float:1.78E-43)
            r7[r0] = r1     // Catch: java.lang.Throwable -> L11
            r0 = 4
            r1 = 78
            r7[r0] = r1     // Catch: java.lang.Throwable -> L11
            r2 = 16777217(0x1000001, float:2.350989E-38)
            r3 = 0
            r4 = 0
            java.lang.String r6 = "7f94df"
            java.lang.Object r0 = ms.bz.bd.c.Pgl.pblk.a(r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L11
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L11
        L3c:
            monitor-exit(r8)
            return
        L3e:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.n0.d():void");
    }

    public static n0 e(Context context) {
        if (e == null) {
            synchronized (n0.class) {
                if (e == null) {
                    e = new n0(context);
                }
            }
        }
        return e;
    }

    public synchronized String bf() {
        StringBuilder sb = new StringBuilder();
        int size = this.vn.size();
        if (size <= 0) {
            return null;
        }
        try {
            List<JSONArray> list = this.vn;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = list.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "268c2e", new byte[]{111}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "738abe", new byte[]{106}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "f673f5", new byte[]{107}));
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

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.ga = sensorEvent.values;
        this.tg = 1;
    }

    public synchronized void e() {
        byte b2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            b2 = pbly.e() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b2 = -1;
        }
        if (b2 != 1) {
            jSONArray2 = null;
        } else {
            synchronized (this) {
                try {
                    SensorManager sensorManager = this.bf;
                    if (sensorManager != null && (this.d != 0 || this.bf.registerListener(this, sensorManager.getDefaultSensor(1), 3))) {
                        this.d++;
                    }
                } catch (Exception unused2) {
                }
                try {
                    try {
                        synchronized (this) {
                            int i = 0;
                            while (this.tg == 0 && i < 10) {
                                i++;
                                wait(1000L);
                            }
                        }
                    } catch (Throwable th) {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(new BigDecimal(this.ga[0]).setScale(2, 4));
                        jSONArray3.put(new BigDecimal(this.ga[1]).setScale(2, 4));
                        jSONArray3.put(new BigDecimal(this.ga[2]).setScale(2, 4));
                        d();
                        this.tg = 0;
                        throw th;
                    }
                } catch (Exception unused3) {
                    jSONArray = new JSONArray();
                    jSONArray.put(new BigDecimal(this.ga[0]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.ga[1]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.ga[2]).setScale(2, 4));
                    d();
                }
            }
            jSONArray = new JSONArray();
            jSONArray.put(new BigDecimal(this.ga[0]).setScale(2, 4));
            jSONArray.put(new BigDecimal(this.ga[1]).setScale(2, 4));
            jSONArray.put(new BigDecimal(this.ga[2]).setScale(2, 4));
            d();
            this.tg = 0;
            jSONArray2 = jSONArray;
        }
        if (jSONArray2 == null) {
            return;
        }
        this.vn.add(jSONArray2);
        try {
            int size = this.vn.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.vn.subList(size - 50, size));
                this.vn.clear();
                this.vn = arrayList;
            }
        } catch (Throwable unused4) {
        }
    }
}
