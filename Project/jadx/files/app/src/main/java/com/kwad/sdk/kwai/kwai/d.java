package com.kwad.sdk.kwai.kwai;

import android.text.TextUtils;
import com.kwad.components.core.r.h;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static String ts() {
        String strVf = com.kwad.sdk.core.config.d.vf();
        return TextUtils.isEmpty(strVf) ? "安装" : strVf;
    }

    public static String tt() {
        String strVg = com.kwad.sdk.core.config.d.vg();
        return TextUtils.isEmpty(strVg) ? "取消" : strVg;
    }

    public static String z(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.ve().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", h.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
