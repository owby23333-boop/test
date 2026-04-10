package com.kwad.sdk.utils;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class bh {
    private static Context bap;
    private static Map<String, l> baq = new HashMap();

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (Rw()) {
            if (baq.containsKey("baseStationEnable")) {
                boolean zBx = hVar.Bx();
                l lVarHk = hk("baseStationEnable");
                if (lVarHk != null) {
                    lVarHk.ca(zBx);
                }
            }
            if (baq.containsKey("simCardInfoEnable")) {
                boolean zBv = hVar.Bv();
                l lVarHk2 = hk("simCardInfoEnable");
                if (lVarHk2 != null) {
                    lVarHk2.ca(zBv);
                    return;
                }
                return;
            }
            return;
        }
        bap = context.getApplicationContext();
        baq.put("baseStationEnable", new a(hVar.Bx()));
        baq.put("simCardInfoEnable", new b(hVar.Bv()));
    }

    private static <T> l<T> hk(String str) {
        try {
            return baq.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static com.kwad.sdk.l.a.b OO() {
        if (Rw()) {
            return (com.kwad.sdk.l.a.b) hl("baseStationEnable");
        }
        return null;
    }

    public static com.kwad.sdk.l.a.f OP() {
        if (Rw()) {
            return (com.kwad.sdk.l.a.f) hl("simCardInfoEnable");
        }
        return null;
    }

    private static <T> T hl(String str) {
        l lVarHk = hk(str);
        if (lVarHk != null) {
            return (T) lVarHk.cC(bap);
        }
        return null;
    }

    private static boolean Rw() {
        return bap != null;
    }

    static class a extends l<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b bar;

        public a(boolean z) {
            super(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.l
        /* JADX INFO: renamed from: dK, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.l.a.b cD(Context context) {
            int lac;
            int cid;
            if (bc.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
                return bar;
            }
            com.kwad.sdk.l.a.b bVar = bar;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || bc.readLocationDisable()) {
                return null;
            }
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1) {
                return null;
            }
            if (br.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
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
                bar = new com.kwad.sdk.l.a.b(cid, lac, cellInfo != null ? a(cellInfo) : -1);
            }
            return bar;
        }

        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) z.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }
    }

    static class b extends l<com.kwad.sdk.l.a.f> {
        @Override // com.kwad.sdk.utils.l
        protected final /* synthetic */ com.kwad.sdk.l.a.f cD(Context context) {
            return dL(context);
        }

        public b(boolean z) {
            super(z);
        }

        private static com.kwad.sdk.l.a.f dL(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.aWR = bd.dx(context);
            fVar.aWQ = bd.dv(context);
            return fVar;
        }
    }
}
