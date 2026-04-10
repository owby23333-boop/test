package com.bytedance.sdk.openadsdk.gz;

import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.v;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.un.ti;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static v z(String str) {
        return z(z().from(str));
    }

    public static v z(gk gkVar) {
        return z(z().from(gkVar.z()).width(gkVar.g()).height(gkVar.dl()).key(gkVar.e()));
    }

    public static InputStream z(String str, String str2) {
        return z().getCacheStream(str, str2);
    }

    public static iq z() {
        return (iq) com.bytedance.sdk.openadsdk.ats.dl.z("img_service");
    }

    private static v z(v vVar) {
        return ti.z() ? vVar.track(new dl()) : vVar;
    }
}
