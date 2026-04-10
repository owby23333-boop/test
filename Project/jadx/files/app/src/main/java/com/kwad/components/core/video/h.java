package com.kwad.components.core.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean a(@NonNull String str, String str2, a.C0442a c0442a) {
        String strEl = ac.el(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "start cache video key:" + strEl + "--url:" + str);
        boolean zB = com.kwad.sdk.core.diskcache.a.a.vE().b(str, str2, c0442a);
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "finish cache video key:" + strEl + "--cache time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--success:" + zB);
        return zB;
    }

    public static boolean i(@NonNull AdTemplate adTemplate) {
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return fileAN != null && fileAN.exists();
    }
}
