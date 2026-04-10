package com.kwad.sdk.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    static /* synthetic */ void Ig() {
    }

    public static String getAppOAID(Context context) {
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            return bc.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (bc.useOaidDisable() || !s.PU()) {
            String strIe = Ie();
            sOAID = strIe;
            return strIe;
        }
        initAsync(context);
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String unused = a.sOAID = a.Ie();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eu(str);
                                a.Ig();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Ie() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String strH = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = strH;
        return strH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eu(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ag.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getOAIDNormal(android.content.Context r4) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.e.a.getOAIDNormal(android.content.Context):void");
    }
}
