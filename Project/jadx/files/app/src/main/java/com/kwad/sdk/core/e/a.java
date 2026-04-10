package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.kwad.sdk.core.e.kwai.b;
import com.kwad.sdk.core.e.kwai.c;
import com.kwad.sdk.core.e.kwai.d;
import com.kwad.sdk.core.e.kwai.e;
import com.kwad.sdk.core.e.kwai.g;
import com.kwad.sdk.core.e.kwai.h;
import com.kwad.sdk.core.e.kwai.i;
import com.kwad.sdk.core.e.kwai.j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.av;
import com.umeng.analytics.pro.cb;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static String ahe = "";
    private static boolean ahf = false;
    private static boolean sGetOaidFail = false;

    public static String bd(Context context) {
        if (as.DY() && !TextUtils.isEmpty(as.DZ())) {
            return as.DZ();
        }
        if (!TextUtils.isEmpty(ahe)) {
            return ahe;
        }
        if (as.DY() || ((f) ServiceProvider.get(f.class)).D(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) {
            return ahe;
        }
        initAsync(context);
        return ahe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void be(Context context) {
        String oaid;
        if (!TextUtils.isEmpty(ahe) || context == null || ahf) {
            return;
        }
        ahf = true;
        if (sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            byte b = -1;
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        b = 6;
                    }
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        b = 10;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        b = 1;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        b = 2;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        b = 4;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        b = 12;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        b = 11;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        b = 3;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        b = cb.f19603l;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals("VIVO")) {
                        b = 5;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        b = 8;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        b = 9;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        b = 7;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        b = cb.f19602k;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        b = 0;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    oaid = new b(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 1:
                case 2:
                    oaid = new i(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 3:
                case 4:
                    oaid = new com.kwad.sdk.core.e.kwai.f(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 5:
                    oaid = new h(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 6:
                case 7:
                    oaid = new c(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 8:
                    oaid = new d(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 9:
                    oaid = new e(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 10:
                    oaid = new g(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 11:
                    oaid = new com.kwad.sdk.core.e.kwai.a(applicationContext).getOAID();
                    ahe = oaid;
                    break;
                case 12:
                case 13:
                case 14:
                    oaid = new j(applicationContext).getOAID();
                    ahe = oaid;
                    break;
            }
            com.kwad.sdk.core.d.b.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + ahe);
            if (TextUtils.isEmpty(ahe)) {
                sGetOaidFail = true;
            }
            ahf = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public static void initAsync(final Context context) {
        if (!TextUtils.isEmpty(ahe) || context == null) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                a.be(context);
                if (OADIDSDKHelper.isSupport()) {
                    OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                        public final void cg(String str) {
                            String unused = a.ahe = str;
                            a.mU();
                        }
                    });
                } else if (OADIDSDKHelper25.isSupport()) {
                    OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                        public final void cg(String str) {
                            String unused = a.ahe = str;
                            a.mU();
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void mU() {
    }
}
