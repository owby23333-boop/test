package com.kwad.components.offline.adLive.kwai;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
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
    private static final AtomicBoolean Xa = new AtomicBoolean(false);
    private static final String Xb = z.format("lib%s.so", "c++_shared");
    private static final String Xc = z.format("lib%s.so", "kwaiplayer");
    private static final String Xd = z.format("lib%s.so", "kste");
    private static final String Xe = z.format("lib%s.so", "hodor");
    private static final String Xf = z.format("lib%s.so", "aegon");
    private static final AtomicBoolean Xg = new AtomicBoolean(false);

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        if (Xa.get()) {
            return;
        }
        Xa.set(true);
        HashMap<String, String> map = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            map.put(Xb, "dcd68cd059cb06a9596ba6839c2e8858");
            map.put(Xc, "f5d9ed20ecd348d291dc742508036c00");
            map.put(Xd, "ebb56fa9c5701350497e281c2446660f");
            map.put(Xe, "d2c9607f3ddbbefe6914f1e94e8c53ff");
            map.put(Xf, "e43929c76e20f091def8fe0579d16adc");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/adLive/3.3.26.1/ks_so-adLiveArm64v8aRelease-3.3.26.1.apk";
            str2 = "adLive-v8a";
            str3 = "310fad205107df839a5026968c232766";
        } else {
            map.put(Xb, "e3fdbf82716c2cb9b666a3880ab94003");
            map.put(Xc, "ec3e4937f3c114dd36ed0cbd10585d22");
            map.put(Xd, "71a9baa45905a6f0e527e5a2e06e8808");
            map.put(Xe, "644a9dacce49b4c3226f5129267c0dad");
            map.put(Xf, "69828b232bd1c06552a81870a5d5e465");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/adLive/3.3.26.1/ks_so-adLiveArmeabiv7aRelease-3.3.26.1.apk";
            str2 = "adLive-v7a";
            str3 = "e0f9628529f23e1928c8d3f61634c8f2";
        }
        b bVar = new b();
        com.kwai.sodler.lib.a.a aVarAs = com.kwai.sodler.kwai.a.as(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.b.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + aVarAs);
        if (aVarAs instanceof com.kwai.sodler.lib.kwai.a) {
            bVar.aJH = ((com.kwai.sodler.lib.kwai.a) aVarAs).Jj();
        }
        bVar.aJz = com.kwad.sdk.core.network.idc.a.wy().bR(str);
        bVar.It = true;
        bVar.aJy = str2;
        bVar.version = "3.6";
        bVar.aJE = map;
        bVar.aJB = str3;
        bVar.aJC = true;
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.adLive.kwai.a.1
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
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void b(com.kwai.sodler.lib.b.c r4) {
                /*
                    r3 = this;
                    super.b(r4)
                    int r0 = r4.getState()
                    r1 = 1
                    if (r0 != r1) goto L12
                    java.lang.String r4 = "AdLiveSoLoadHelper"
                    java.lang.String r0 = "onPostUpdate UPD_SUCCESS"
                    com.kwad.sdk.core.d.b.d(r4, r0)
                    return
                L12:
                    java.lang.Throwable r0 = r4.Jq()
                    if (r0 == 0) goto L2b
                    java.lang.Throwable r0 = r4.Jq()
                    boolean r1 = r0 instanceof com.kwai.sodler.lib.ext.PluginError
                    if (r1 == 0) goto L2b
                    com.kwai.sodler.lib.ext.PluginError r0 = (com.kwai.sodler.lib.ext.PluginError) r0
                    int r0 = r0.getCode()
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    goto L2d
                L2b:
                    java.lang.String r0 = "other"
                L2d:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "onPostUpdate error: "
                    r1.<init>(r2)
                    r1.append(r0)
                    r1.toString()
                    r4.Jq()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.offline.adLive.kwai.a.AnonymousClass1.b(com.kwai.sodler.lib.b.c):void");
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
}
