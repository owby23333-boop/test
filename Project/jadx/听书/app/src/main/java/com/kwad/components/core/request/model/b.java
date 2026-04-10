package com.kwad.components.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.cd;
import com.kwad.sdk.utils.r;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.b {
    private String LP;
    private int Qh;
    private List<a> XA;
    private f XB;
    private d XC;
    private com.kwad.sdk.l.a.b XD;
    private List<e> XE;
    private int Xk;
    private String Xl;
    private Long Xm;
    private Long Xn;
    private Long Xo;
    private Long Xp;
    private String Xq;
    private String Xr;
    private long Xt;
    private String Xu;
    private long Xv;
    private String Xx;
    private String Xy;
    private boolean Xz;
    private List<cd.a> Xs = new CopyOnWriteArrayList();
    private int Xw = -1;
    private float screenBrightness = -1.0f;
    private int Qk = -1;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    private static Context getContext() {
        return ServiceProvider.Pp();
    }

    public static b sx() {
        b bVar = new b();
        bVar.Xk = br.RS();
        bVar.Xl = AbiUtil.cp(getContext());
        bVar.Qh = br.dR(getContext());
        bVar.Xm = Long.valueOf(br.dS(getContext()));
        bVar.Xn = Long.valueOf(br.dO(getContext()));
        bVar.Xo = Long.valueOf(br.RP());
        bVar.Xp = Long.valueOf(br.RQ());
        bVar.Xq = bd.dt(getContext());
        bVar.Xr = bd.du(getContext());
        bVar.Xs.addAll(bd.o(getContext(), 15));
        bVar.Xt = br.RX();
        bVar.Xv = br.RY();
        bVar.Xy = br.RZ();
        bVar.Xx = br.Sa();
        bVar.LP = br.Sb();
        bVar.Xu = br.Sc();
        Context context = getContext();
        if (context != null) {
            bVar.Xw = br.dZ(context);
            bVar.XA = new CopyOnWriteArrayList(a.aB(context));
            bVar.aA(context);
        }
        bVar.XC = r.PQ();
        bVar.XD = bd.OO();
        bVar.XE = bj.Ry().Rz();
        bVar.XB = bd.OP();
        return bVar;
    }

    private void aA(Context context) {
        if (com.kwad.sdk.core.config.e.ai(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                this.Xz = intExtra == 2 || intExtra == 5;
                int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
                if (intExtra2 == 2) {
                    this.Qk = 1;
                    return;
                }
                if (intExtra2 == 1) {
                    this.Qk = 2;
                } else if (intExtra2 == 4) {
                    this.Qk = 3;
                } else if (intExtra2 == 0) {
                    this.Qk = 0;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "cpuCount", this.Xk);
        aa.putValue(jSONObject, "cpuAbi", this.Xl);
        aa.putValue(jSONObject, "batteryPercent", this.Qh);
        aa.putValue(jSONObject, "totalMemorySize", this.Xm.longValue());
        aa.putValue(jSONObject, "availableMemorySize", this.Xn.longValue());
        aa.putValue(jSONObject, "totalDiskSize", this.Xo.longValue());
        aa.putValue(jSONObject, "availableDiskSize", this.Xp.longValue());
        aa.putValue(jSONObject, "imsi", this.Xq);
        aa.putValue(jSONObject, an.aa, this.Xr);
        aa.putValue(jSONObject, "wifiList", this.Xs);
        aa.putValue(jSONObject, "bootTime", this.Xt);
        aa.putValue(jSONObject, "romName", this.LP);
        aa.putValue(jSONObject, "romVersion", this.Xu);
        aa.putValue(jSONObject, "romBuildTimestamp", this.Xv);
        aa.putValue(jSONObject, "ringerMode", this.Xw);
        aa.putValue(jSONObject, "audioStreamInfo", this.XA);
        aa.putValue(jSONObject, "baseBandVersion", this.Xx);
        aa.putValue(jSONObject, "fingerPrint", this.Xy);
        aa.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        aa.putValue(jSONObject, "isCharging", this.Xz);
        aa.putValue(jSONObject, "chargeType", this.Qk);
        f fVar = this.XB;
        if (fVar != null) {
            aa.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.XC;
        if (dVar != null) {
            aa.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.XD;
        if (bVar != null) {
            aa.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.XE;
        if (list != null) {
            aa.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }

    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int XF = -1;
        public int XG = -1;
        public int XH = -1;
        public int streamType;

        private static int aV(int i) {
            if (i == 0) {
                return 0;
            }
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        i2 = 4;
                        if (i != 4) {
                            i2 = 5;
                            if (i != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return i2;
        }

        private a(int i) {
            this.streamType = i;
        }

        public static List<a> aB(Context context) {
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.e.ai(256L)) {
                return arrayList;
            }
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    return arrayList;
                }
                for (int i = 0; i <= 5; i++) {
                    a aVar = new a(i);
                    int iAV = aV(i);
                    aVar.XH = audioManager.getStreamVolume(iAV);
                    aVar.XF = audioManager.getStreamMaxVolume(iAV);
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.XG = audioManager.getStreamMinVolume(iAV);
                    }
                    arrayList.add(aVar);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }
}
