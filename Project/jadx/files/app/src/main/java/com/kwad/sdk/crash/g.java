package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    public interface a {
        void zE();
    }

    private static void a(Context context, com.kwai.sodler.lib.c.b bVar, @Nullable final a aVar) {
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a(cVar);
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(com.kwai.sodler.lib.b.c cVar) {
                super.b(cVar);
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void se() {
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostLoad thread=" + Thread.currentThread().getName());
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.zE();
                }
            }

            private void zS() {
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
            }

            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar2) {
                se();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
                zS();
            }
        });
    }

    public static void a(@NonNull c cVar, @Nullable a aVar) {
        String str;
        String str2;
        if (ISLOADED.get()) {
            aVar.zE();
            return;
        }
        Context context = cVar.context;
        ISLOADED.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aqn;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArm64v8aRelease-3.3.23.apk";
            }
            str2 = "exception-v8a";
        } else {
            str = cVar.aqo;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArmeabiv7aRelease-3.3.23.apk";
            }
            str2 = "exception-v7a";
        }
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aJz = com.kwad.sdk.core.network.idc.a.wy().bR(str);
        bVar.It = true;
        bVar.aJy = str2;
        bVar.version = "3.1";
        bVar.aJC = false;
        a(context, bVar, aVar);
    }
}
