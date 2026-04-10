package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes4.dex */
public class bi {
    private static volatile bi bas;
    private final Map<String, a> bat = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> bau = new ConcurrentHashMap();
    private boolean bav = false;

    public interface b {
        void onFailed();
    }

    private static int eW(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    static /* synthetic */ Sensor a(bi biVar, int i) {
        return eV(i);
    }

    static /* synthetic */ int b(bi biVar, int i) {
        return eW(i);
    }

    private bi() {
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bi.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager sensorManagerCheckAndObtainSensorManager = bk.RC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bat.keySet()) {
                    a aVar = (a) bi.this.bat.get(str);
                    if (aVar != null) {
                        sensorManagerCheckAndObtainSensorManager.registerListener(aVar, bi.a(bi.this, Integer.parseInt(str.split("_")[0])), bi.b(bi.this, Integer.parseInt(str.split("_")[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager sensorManagerCheckAndObtainSensorManager = bk.RC().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bat.keySet()) {
                    try {
                        sensorManagerCheckAndObtainSensorManager.unregisterListener((a) bi.this.bat.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public static bi Rx() {
        if (bas == null) {
            synchronized (bi.class) {
                if (bas == null) {
                    bas = new bi();
                }
            }
        }
        return bas;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor sensorEV = eV(i);
        if (sensorEV == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String strC = C(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bau.get(strC);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.bau.put(strC, copyOnWriteArraySet);
            a(strC, i2, sensorEV);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.bau.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            Iterator<SensorEventListener> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SensorEventListener next = it.next();
                if (next.equals(sensorEventListener)) {
                    value.remove(next);
                    break;
                }
            }
            if (value.size() == 0) {
                hm(entry.getKey());
            }
        }
    }

    private void hm(String str) {
        a aVar = this.bat.get(str);
        if (aVar != null) {
            this.bat.remove(str);
            try {
                bk.RC().unregisterListener(aVar);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private void a(String str, int i, Sensor sensor) {
        boolean zUseSensorManagerDisable = bc.useSensorManagerDisable();
        this.bav = zUseSensorManagerDisable;
        if (zUseSensorManagerDisable) {
            return;
        }
        bk.RC().registerListener(ServiceProvider.getContext(), hn(str), sensor, eW(i));
    }

    private static Sensor eV(int i) {
        bk bkVarRC = bk.RC();
        Context context = ServiceProvider.getContext();
        if (i == 1) {
            return bkVarRC.getDefaultSensor(context, 10);
        }
        if (i == 2) {
            return bkVarRC.getDefaultSensor(context, 4);
        }
        if (i == 3) {
            return bkVarRC.getDefaultSensor(context, 1);
        }
        if (i != 4) {
            return null;
        }
        return bkVarRC.getDefaultSensor(context, 9);
    }

    private a hn(String str) {
        a aVar = this.bat.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.bat.put(str, aVar2);
        return aVar2;
    }

    private static String C(int i, int i2) {
        return i + "_" + i2;
    }

    public static class a implements SensorEventListener {
        private final WeakReference<bi> aek;
        private final String key;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a(String str, bi biVar) {
            this.key = str;
            this.aek = new WeakReference<>(biVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bi biVar = this.aek.get();
            if (biVar != null) {
                biVar.a(this.key, sensorEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bau.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
