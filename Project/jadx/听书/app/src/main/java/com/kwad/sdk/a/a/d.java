package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.FX().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.t.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String Da() {
        String strFY = com.kwad.sdk.core.config.e.FY();
        return TextUtils.isEmpty(strFY) ? "安装" : strFY;
    }

    public static String Db() {
        String strFZ = com.kwad.sdk.core.config.e.FZ();
        return TextUtils.isEmpty(strFZ) ? "取消" : strFZ;
    }
}
