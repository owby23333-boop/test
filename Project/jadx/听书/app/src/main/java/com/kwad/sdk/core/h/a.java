package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static C0404a aJV;
    private static boolean aJW;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean aJX = true;

    /* JADX INFO: renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    public static class C0404a extends com.kwad.sdk.core.response.a.a {
        public List<String> aJY;
        public int aJZ;
        public List<String> aKa;
        public List<String> aKb;
    }

    public static void JL() {
        h.execute(new bg() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C0404a unused = a.aJV = new C0404a();
                    boolean unused2 = a.aJW = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BU();
                    String strBV = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BV();
                    if (a.aJW && !TextUtils.isEmpty(strBV)) {
                        a.aJV.parseJson(new JSONObject(strBV));
                        a.JM();
                        return;
                    }
                    boolean unused3 = a.aJX = a.aJW;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JM() {
        aJX = true;
        if (aJV == null) {
            return;
        }
        dI(JN());
        ag.l("ksadsdk_tk_switch", "tk_config", aJX);
    }

    private static void dI(int i) {
        for (int i2 = 0; i2 < Integer.toBinaryString(i).length(); i2++) {
            if (((1 << i2) & i) != 0) {
                aJX = false;
                dJ(i2);
                if (aJX) {
                    return;
                }
            }
        }
    }

    private static void dJ(int i) {
        if (i == 0) {
            if (aJV.aKa.contains(br.RW())) {
                return;
            }
            aJX = true;
        } else if (i == 1) {
            if (aJV.aJZ < br.Sg()) {
                aJX = true;
            }
        } else if (i == 2) {
            if (aJV.aJY.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aJX = true;
        } else if (i == 3 && !aJV.aKb.contains(br.RV())) {
            aJX = true;
        }
    }

    private static int JN() {
        int i = !aJV.aKa.isEmpty() ? 1 : 0;
        int i2 = aJV.aJZ != 0 ? 2 : 0;
        return ((i ^ i2) ^ (!aJV.aJY.isEmpty() ? 4 : 0)) ^ (aJV.aKb.isEmpty() ? 0 : 8);
    }

    public static boolean JO() {
        if (mHasInit.get()) {
            return aJX;
        }
        return ag.m("ksadsdk_tk_switch", "tk_config", true);
    }
}
