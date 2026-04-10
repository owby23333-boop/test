package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile boolean hasInit;

    static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void cS(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                c.d("perfMonitor.MonitorManager", "configStr:" + str);
                com.kwad.sdk.crash.online.monitor.a.c cVarFF = a.fF(str);
                c.d("perfMonitor.MonitorManager", cVarFF.toJson().toString());
                e.d(cVarFF.aQl);
                a.access$002(true);
            }
        });
    }

    public static com.kwad.sdk.crash.online.monitor.a.c fF(String str) {
        if (TextUtils.isEmpty(str)) {
            return LJ();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            c.w("perfMonitor.MonitorManager", e);
            return LJ();
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.c LJ() {
        com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
        cVar.aQl = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aQl.aQc = 5;
        return cVar;
    }
}
