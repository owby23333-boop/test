package com.kwad.sdk.core.webview.a.b;

import com.anythink.expressad.exoplayer.k.o;
import com.baidu.tts.network.HttpClientUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final List<String> apy;

    static {
        ArrayList arrayList = new ArrayList();
        apy = arrayList;
        arrayList.add("application/x-javascript");
        apy.add("image/jpeg");
        apy.add("image/tiff");
        apy.add("text/css");
        apy.add("text/html");
        apy.add("image/gif");
        apy.add("image/png");
        apy.add("application/javascript");
        apy.add(o.f9860e);
        apy.add(o.f9875t);
        apy.add("application/json");
        apy.add("image/webp");
        apy.add("image/apng");
        apy.add("image/svg+xml");
        apy.add(HttpClientUtil.APPLICATION_OCTET_STREAM);
    }

    public static boolean cW(String str) {
        return apy.contains(str);
    }
}
