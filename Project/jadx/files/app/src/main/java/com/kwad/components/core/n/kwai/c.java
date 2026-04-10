package com.kwad.components.core.n.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.anythink.expressad.exoplayer.k.o;
import com.kwad.sdk.g.kwai.e;
import com.kwad.sdk.g.kwai.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.s;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.b {
    private Long OA;
    private Long OB;
    private Long OC;
    private String OD;
    private String OE;
    private long OG;
    private String OH;
    private String OI;
    private long OJ;
    private String OL;
    private String OM;
    private boolean ON;
    private List<a> OP;
    private f OQ;
    private com.kwad.sdk.g.kwai.d OR;
    private com.kwad.sdk.g.kwai.b OS;
    private List<e> OT;
    private int Ow;
    private String Ox;
    private int Oy;
    private Long Oz;
    private List<bn.a> OF = new ArrayList();
    private int OK = -1;
    private float screenBrightness = -1.0f;
    private int OO = -1;

    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int OU = -1;
        public int OV = -1;
        public int OW = -1;
        public int streamType;

        private a(int i2) {
            this.streamType = i2;
        }

        private static int aC(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            if (i2 == 3) {
                return 3;
            }
            if (i2 != 4) {
                return i2 != 5 ? 0 : 5;
            }
            return 4;
        }

        public static List<a> aq(Context context) {
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.d.D(256L)) {
                return arrayList;
            }
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService(o.b);
                if (audioManager == null) {
                    return arrayList;
                }
                for (int i2 = 0; i2 <= 5; i2++) {
                    a aVar = new a(i2);
                    int iAC = aC(i2);
                    aVar.OW = audioManager.getStreamVolume(iAC);
                    aVar.OU = audioManager.getStreamMaxVolume(iAC);
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.OV = audioManager.getStreamMinVolume(iAC);
                    }
                    arrayList.add(aVar);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    private void ap(@NonNull Context context) {
        if (com.kwad.sdk.core.config.d.D(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            this.ON = intExtra == 2 || intExtra == 5;
            int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.OO = 1;
                return;
            }
            if (intExtra2 == 1) {
                this.OO = 2;
            } else if (intExtra2 == 4) {
                this.OO = 3;
            } else if (intExtra2 == 0) {
                this.OO = 0;
            }
        }
    }

    private static Context getContext() {
        return ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
    }

    @WorkerThread
    public static c pB() {
        c cVar = new c();
        cVar.Ow = bc.EA();
        cVar.Ox = AbiUtil.bF(getContext());
        cVar.Oy = bc.df(getContext());
        cVar.Oz = Long.valueOf(bc.dg(getContext()));
        cVar.OA = Long.valueOf(bc.de(getContext()));
        cVar.OB = Long.valueOf(bc.Ey());
        cVar.OC = Long.valueOf(bc.Ez());
        cVar.OD = at.cG(getContext());
        cVar.OE = at.cH(getContext());
        cVar.OF = at.m(getContext(), 15);
        cVar.OG = bc.EE();
        cVar.OJ = bc.EF();
        cVar.OM = bc.EG();
        cVar.OL = bc.EH();
        cVar.OH = bc.EI();
        cVar.OI = bc.EJ();
        Context context = getContext();
        if (context != null) {
            cVar.OK = bc.dn(context);
            cVar.OP = a.aq(context);
            cVar.ap(context);
        }
        cVar.OR = n.CW();
        cVar.OS = at.Ct();
        cVar.OT = at.Eg();
        cVar.OQ = at.Cu();
        return cVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "cpuCount", this.Ow);
        s.putValue(jSONObject, "cpuAbi", this.Ox);
        s.putValue(jSONObject, "batteryPercent", this.Oy);
        s.putValue(jSONObject, "totalMemorySize", this.Oz.longValue());
        s.putValue(jSONObject, "availableMemorySize", this.OA.longValue());
        s.putValue(jSONObject, "totalDiskSize", this.OB.longValue());
        s.putValue(jSONObject, "availableDiskSize", this.OC.longValue());
        s.putValue(jSONObject, Constants.KEY_IMSI, this.OD);
        s.putValue(jSONObject, am.aa, this.OE);
        s.putValue(jSONObject, "wifiList", this.OF);
        s.putValue(jSONObject, "bootTime", this.OG);
        s.putValue(jSONObject, "romName", this.OH);
        s.putValue(jSONObject, "romVersion", this.OI);
        s.putValue(jSONObject, "romBuildTimestamp", this.OJ);
        s.putValue(jSONObject, "ringerMode", this.OK);
        s.putValue(jSONObject, "audioStreamInfo", this.OP);
        s.putValue(jSONObject, "baseBandVersion", this.OL);
        s.putValue(jSONObject, "fingerPrint", this.OM);
        s.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        s.putValue(jSONObject, "isCharging", this.ON);
        s.putValue(jSONObject, "chargeType", this.OO);
        f fVar = this.OQ;
        if (fVar != null) {
            s.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.g.kwai.d dVar = this.OR;
        if (dVar != null) {
            s.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.g.kwai.b bVar = this.OS;
        if (bVar != null) {
            s.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.OT;
        if (list != null) {
            s.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
