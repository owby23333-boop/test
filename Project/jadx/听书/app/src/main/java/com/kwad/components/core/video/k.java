package com.kwad.components.core.video;

import android.content.Context;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    private static Map<String, Integer> abh = new ConcurrentHashMap();

    public static boolean a(String str, String str2, a.C0405a c0405a) {
        String strMd5 = al.md5(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + strMd5 + "--url:" + str);
        boolean zB = com.kwad.sdk.core.diskcache.b.a.GP().b(str, str2, c0405a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + strMd5 + "--cache time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--success:" + zB);
        return zB;
    }

    public static boolean aL(AdTemplate adTemplate) {
        File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        return fileCf != null && fileCf.exists();
    }

    public static String g(Context context, AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.eB(adTemplate), com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    public static String h(Context context, String str) {
        return a(context, aM(str), str);
    }

    private static String a(Context context, int i, String str) {
        if (i >= 0) {
            return i > 0 ? com.kwad.sdk.core.videocache.c.a.bR(context).eJ(str) : str;
        }
        File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
        return (fileCf == null || !fileCf.exists()) ? str : fileCf.getAbsolutePath();
    }

    public static void m(String str, int i) {
        abh.put(str, Integer.valueOf(i));
    }

    private static int aM(String str) {
        Integer num = abh.get(str);
        if (num != null) {
            return num.intValue();
        }
        return com.kwad.sdk.core.config.e.BQ();
    }
}
