package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private static final AtomicBoolean aOT = new AtomicBoolean(false);

    public interface a {
        void Lk();

        void Ll();
    }

    public static void a(c cVar, a aVar) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = aOT;
        if (atomicBoolean.get()) {
            aVar.Lk();
            return;
        }
        if (cVar.sdkVersion.compareTo(cVar.aOv) < 0) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*supportAppVersion:" + cVar.aOv);
            aVar.Ll();
            return;
        }
        if (!TextUtils.isEmpty(cVar.aOw) && cVar.sdkVersion.compareTo(cVar.aOw) >= 0) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*maxVersionExclude:" + cVar.aOw);
            aVar.Ll();
            return;
        }
        Context context = cVar.context;
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aOz;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202406211433/ks_so-exceptionArm64v8aRelease-3.3.67-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aOB;
            str3 = "exception-v8a";
        } else {
            str = cVar.aOA;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202406211433/ks_so-exceptionArmeabiv7aRelease-3.3.67-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aOC;
            str3 = "exception-v7a";
        }
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "url:" + str + " pluginName:" + str3 + " md5:" + str2);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.ary = com.kwad.sdk.core.network.idc.a.HF().ef(str);
        bVar.enable = true;
        bVar.arx = str3;
        bVar.version = cVar.aOu;
        bVar.arA = str2;
        bVar.arB = false;
        a(context, bVar, aVar);
    }

    private static void a(Context context, com.kwad.library.solder.lib.c.b bVar, final a aVar) {
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                ws();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void ws() {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostLoad");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.Lk();
                }
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName() + "\n" + pluginError);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.Ll();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0383b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }
        });
    }
}
