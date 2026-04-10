package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* JADX INFO: loaded from: classes3.dex */
public class BlockInjector {
    private static volatile boolean arp;
    private static volatile boolean arq;

    private static String a(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vV().decode((bVar == null || TextUtils.isEmpty(bVar.arJ)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.arJ));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    private static String b(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vV().decode((bVar == null || TextUtils.isEmpty(bVar.arI)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.arI));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arp) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b bVarC = c(aVar);
            RangerInjector.a(b(bVarC), a(bVarC), new RangerInjector.b() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.1
                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void a(String str, long j2, long j3, String str2, String str3) {
                    e.a(str, j2, j3, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void onError(String str) {
                    BlockInjector.onError(str);
                }
            });
            arp = true;
        } catch (Exception e2) {
            onError(Log.getStackTraceString(e2));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.kwai.b c(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        f fVar = (f) ServiceProvider.get(f.class);
        String appId = fVar != null ? fVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.dx(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        e.dw(str);
        com.kwad.sdk.core.d.b.w("perfMonitor.Injector", str);
    }

    @Keep
    public static void tryProxyOtherOutput(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arq) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b bVarC = c(aVar);
            if (bVarC == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "featureConfig:" + bVarC.toJson().toString());
            RangerInjector.tryProxyOtherOutput(bVarC.arK, bVarC.arL, bVarC.arM, bVarC.arN, new RangerInjector.a() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.2
                @Override // com.kwad.sdk.ranger.RangerInjector.a
                public final void dq(String str) {
                    e.d(str, false);
                }
            });
            arq = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Injector", Log.getStackTraceString(th));
        }
    }
}
