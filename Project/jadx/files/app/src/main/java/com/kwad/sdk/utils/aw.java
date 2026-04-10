package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class aw {
    private static Context ayj;
    private static Map<String, j> azj = new HashMap();

    static class a extends j<com.kwad.sdk.g.kwai.b> {
        private static com.kwad.sdk.g.kwai.b azk;

        public a(boolean z2) {
            super(z2);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) r.a((Object) cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* JADX INFO: renamed from: cW, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.g.kwai.b bR(Context context) {
            int lac;
            int cid;
            if (as.DQ() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(64L)) {
                return azk;
            }
            com.kwad.sdk.g.kwai.b bVar = azk;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || as.DQ()) {
                return null;
            }
            int iA = -1;
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) == -1) {
                return null;
            }
            if (bc.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    cid = cdmaCellLocation.getBaseStationId();
                    lac = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    cid = gsmCellLocation.getCid();
                    lac = gsmCellLocation.getLac();
                } else {
                    lac = -1;
                    cid = -1;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellInfo next = it.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    if (cellInfo != null) {
                        iA = a(cellInfo);
                    }
                }
                azk = new com.kwad.sdk.g.kwai.b(cid, lac, iA);
            }
            return azk;
        }
    }

    static class b extends j<List<com.kwad.sdk.g.kwai.e>> implements SensorEventListener {
        private d azl;
        private d azm;
        private d azn;
        private boolean azo;

        public b(Context context, boolean z2) {
            super(z2);
            this.azo = false;
            if (!z2 || this.azo) {
                return;
            }
            try {
                cX(context);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }

        private List<com.kwad.sdk.g.kwai.e> Em() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.azl;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar.En(), this.azl.getTimestamp()));
            }
            d dVar2 = this.azm;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar2.En(), this.azm.getTimestamp()));
            }
            d dVar3 = this.azn;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar3.En(), this.azn.getTimestamp()));
            }
            return arrayList;
        }

        private static boolean a(SensorManager sensorManager, int i2, SensorEventListener sensorEventListener) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i2);
            if (defaultSensor == null) {
                return false;
            }
            return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
        }

        private void cX(Context context) {
            SensorManager sensorManager;
            try {
                sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac);
            } catch (Exception unused) {
                sensorManager = null;
            }
            if (sensorManager == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a(sensorManager, 1, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a(sensorManager, 4, this));
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "gravitySensorAvailable : " + a(sensorManager, 9, this));
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.g.kwai.e> cY(Context context) {
            final ArrayList arrayList;
            arrayList = new ArrayList();
            final SensorManager sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac);
            final CountDownLatch countDownLatch = new CountDownLatch(3);
            if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.utils.aw.b.1
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 4, new c() { // from class: com.kwad.sdk.utils.aw.b.2
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 9, new c() { // from class: com.kwad.sdk.utils.aw.b.3
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        @Nullable
        @WorkerThread
        /* JADX INFO: renamed from: cZ, reason: merged with bridge method [inline-methods] */
        public List<com.kwad.sdk.g.kwai.e> bR(Context context) {
            if (context == null) {
                return null;
            }
            System.currentTimeMillis();
            return this.azo ? cY(context) : Em();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.azl = new d(sensorEvent);
            } else if (type == 4) {
                this.azm = new d(sensorEvent);
            } else {
                if (type != 9) {
                    return;
                }
                this.azn = new d(sensorEvent);
            }
        }
    }

    static abstract class c implements SensorEventListener {
        c() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    static class d {
        private SensorEvent azs;
        private long timestamp = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.azs = sensorEvent;
        }

        public final SensorEvent En() {
            return this.azs;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    static class e extends j<com.kwad.sdk.g.kwai.f> {
        public e(boolean z2) {
            super(z2);
        }

        @Nullable
        private static com.kwad.sdk.g.kwai.f da(Context context) {
            com.kwad.sdk.g.kwai.f fVar = new com.kwad.sdk.g.kwai.f();
            fVar.axf = at.cK(context);
            fVar.axe = at.cI(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        @Nullable
        protected final /* synthetic */ com.kwad.sdk.g.kwai.f bR(Context context) {
            return da(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.g.kwai.b Ct() {
        if (El()) {
            return (com.kwad.sdk.g.kwai.b) ev("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.g.kwai.f Cu() {
        if (El()) {
            return (com.kwad.sdk.g.kwai.f) ev("simCardInfoEnable");
        }
        return null;
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.g.kwai.e> Eg() {
        if (El()) {
            return (List) ev("sensorEventEnable");
        }
        return null;
    }

    private static boolean El() {
        return ayj != null;
    }

    @Nullable
    private static <T> j<T> eu(String str) {
        try {
            return azj.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T ev(String str) {
        j jVarEu = eu(str);
        if (jVarEu != null) {
            return (T) jVarEu.bQ(ayj);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        com.kwad.sdk.core.d.b.d("SensitiveInfoCollectors", "sensorEnable2: " + fVar.sN());
        if (!El()) {
            ayj = context.getApplicationContext();
            azj.put("baseStationEnable", new a(fVar.sO()));
            azj.put("sensorEventEnable", new b(ayj, fVar.sN()));
            azj.put("simCardInfoEnable", new e(fVar.sM()));
            n.bW(context);
            return;
        }
        if (azj.containsKey("baseStationEnable")) {
            boolean zSO = fVar.sO();
            j jVarEu = eu("baseStationEnable");
            if (jVarEu != null) {
                jVarEu.aM(zSO);
            }
        }
        if (azj.containsKey("sensorEventEnable")) {
            boolean zSN = fVar.sN();
            j jVarEu2 = eu("sensorEventEnable");
            if (jVarEu2 != null) {
                jVarEu2.aM(zSN);
            }
        }
        if (azj.containsKey("simCardInfoEnable")) {
            boolean zSM = fVar.sM();
            j jVarEu3 = eu("simCardInfoEnable");
            if (jVarEu3 != null) {
                jVarEu3.aM(zSM);
            }
        }
    }
}
