package com.kwad.components.offline.tk.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.z;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.c.b;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static long XN;
    private static final AtomicBoolean Xa = new AtomicBoolean(false);
    private static final String XH = z.format("lib%s.so", "tk_runtime_v0_0_38");
    private static final String XI = z.format("lib%s.so", "tk_runtime_lite_v0_0_38");
    private static final String XJ = z.format("lib%s.so", "kwai-v8");
    private static final String XK = z.format("lib%s.so", "kwai-v8-lite");
    private static final String XL = z.format("lib%s.so", "kwad-fb");
    private static final String XM = z.format("lib%s.so", "kwad-yoga");
    private static final String Xb = z.format("lib%s.so", "c++_shared");
    private static Boolean XO = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String strUo;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (Xa.get()) {
            return;
        }
        Xa.set(true);
        HashMap<String, String> map = new HashMap<>();
        boolean zUseTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            strUo = d.up();
            if (TextUtils.isEmpty(strUo)) {
                strUo = zUseTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaLiteSoArm64v8aRelease-3.3.34.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaSoArm64v8aRelease-3.3.34.apk";
            }
            str = zUseTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = zUseTkLite ? "39df505f83794e951720e9c753824d0c" : "2c0fb7069df4a3e6fd55e417229bcb6b";
            if (zUseTkLite) {
                map.put(XI, "a5009e795307441cc05dbd3e8aeaead3");
                str7 = XK;
                str8 = "77545ba1892c1a1d4a039db37b3249eb";
            } else {
                map.put(XH, "e1478b9b4f377d667c7e510e88ae1bcb");
                str7 = XJ;
                str8 = "7316cd8d074b04e6cb21486288d314ce";
            }
            map.put(str7, str8);
            map.put(XL, "31f065607e6da6b741330d1df0b35460");
            map.put(XM, "76308532f64b68fd5a930c42cceec22b");
            str5 = Xb;
            str6 = "6ca7958ee0b0192a7c52c16faffaa8ba";
        } else {
            strUo = d.uo();
            if (TextUtils.isEmpty(strUo)) {
                strUo = zUseTkLite ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaLiteSoArmeabiv7aRelease-3.3.34.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.34/ks_so-tachikomaSoArmeabiv7aRelease-3.3.34.apk";
            }
            str = zUseTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = zUseTkLite ? "a46a370ee3a1a61a0d6041b3c69c0ab7" : "f8d270613187202ab45cfec0dca9deee";
            if (zUseTkLite) {
                map.put(XI, "8ffd76abe9e5fe33f4035b56b9d6e8e3");
                str3 = XK;
                str4 = "2dbd72527a0739740746adaae48ed2e0";
            } else {
                map.put(XH, "55e6b8f6cd2091d8f8412dafcf9f381a");
                str3 = XJ;
                str4 = "519ba633e88efafb8fbd536d800da734";
            }
            map.put(str3, str4);
            map.put(XL, "eff11bebb8a3c872fa30b0484b460d12");
            map.put(XM, "2c6f402c6a565d2e6912b0013fa59380");
            str5 = Xb;
            str6 = "7cb16c2840085bbdf4be628e6604bac1";
        }
        map.put(str5, str6);
        b bVar = new b();
        bVar.aJz = com.kwad.sdk.core.network.idc.a.wy().bR(strUo);
        bVar.It = true;
        bVar.aJy = str;
        bVar.version = zUseTkLite ? "3.3.34-lite" : "3.3.34";
        bVar.aJC = false;
        bVar.aJB = str2;
        bVar.aJE = map;
        final com.kwai.sodler.lib.a.a aVarAs = com.kwai.sodler.kwai.a.as(context, ITkOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.b.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + aVarAs);
        if (aVarAs instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.aJH = ((com.kwai.sodler.lib.kwai.a) aVarAs).Jj();
        }
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.tk.a.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public void a(c cVar) {
                super.a(cVar);
            }

            private void a(PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void c(c cVar) {
                super.c(cVar);
                soLoadListener.onPreUpdate();
                long unused = a.XN = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.Jt()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void b(com.kwai.sodler.lib.b.c r7) {
                /*
                    r6 = this;
                    super.b(r7)
                    int r0 = r7.getState()
                    r1 = 1
                    if (r0 != r1) goto L36
                    com.kwad.components.offline.api.tk.TkLoggerReporter r0 = com.kwad.components.offline.api.tk.TkLoggerReporter.get()
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r2 = new com.kwad.components.offline.api.tk.model.report.TKDownloadMsg
                    r2.<init>()
                    int r7 = r7.Jt()
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r2.setRetryCount(r7)
                    long r2 = android.os.SystemClock.elapsedRealtime()
                    long r4 = com.kwad.components.offline.tk.a.a.sk()
                    long r2 = r2 - r4
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r7.setDownloadTime(r2)
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r7.setDownloadState(r1)
                    org.json.JSONObject r7 = r7.toJson()
                    java.lang.String r1 = "ad_client_apm_log"
                    r0.reportTKSODownload(r1, r7)
                    return
                L36:
                    java.lang.Throwable r0 = r7.Jq()
                    if (r0 == 0) goto L4f
                    java.lang.Throwable r0 = r7.Jq()
                    boolean r1 = r0 instanceof com.kwai.sodler.lib.ext.PluginError
                    if (r1 == 0) goto L4f
                    com.kwai.sodler.lib.ext.PluginError r0 = (com.kwai.sodler.lib.ext.PluginError) r0
                    int r0 = r0.getCode()
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    goto L51
                L4f:
                    java.lang.String r0 = "other"
                L51:
                    com.kwad.components.offline.api.tk.TkLoggerReporter r1 = com.kwad.components.offline.api.tk.TkLoggerReporter.get()
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r2 = new com.kwad.components.offline.api.tk.model.report.TKDownloadMsg
                    r2.<init>()
                    int r7 = r7.Jt()
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r2.setRetryCount(r7)
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r7.setErrorReason(r0)
                    r0 = 2
                    com.kwad.components.offline.api.tk.model.report.TKDownloadMsg r7 = r7.setDownloadState(r0)
                    org.json.JSONObject r7 = r7.toJson()
                    java.lang.String r0 = "ad_client_error_log"
                    r1.reportTKSODownload(r0, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.offline.tk.a.a.AnonymousClass1.b(com.kwai.sodler.lib.b.c):void");
            }

            private void se() {
                soLoadListener.onLoaded();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
                se();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(f fVar, PluginError pluginError) {
                a(pluginError);
            }
        });
    }

    public static boolean useTkLite() {
        if (XO == null) {
            XO = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.abL));
        }
        return XO.booleanValue();
    }
}
