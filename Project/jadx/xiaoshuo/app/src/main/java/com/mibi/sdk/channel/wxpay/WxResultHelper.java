package com.mibi.sdk.channel.wxpay;

import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes13.dex */
public class WxResultHelper {
    private static IWxResultInterceptor sInterceptor;
    private static String sWxAppId;

    private WxResultHelper() {
    }

    public static IWxResultInterceptor getInterceptor() {
        return sInterceptor;
    }

    public static String getWxAppId() {
        return sWxAppId;
    }

    public static boolean intercept(BaseResp baseResp) {
        IWxResultInterceptor iWxResultInterceptor = sInterceptor;
        if (iWxResultInterceptor != null) {
            return iWxResultInterceptor.intercept(baseResp);
        }
        return false;
    }

    public static void removeInterceptor() {
        sInterceptor = null;
    }

    public static void setInterceptor(IWxResultInterceptor iWxResultInterceptor) {
        sInterceptor = iWxResultInterceptor;
    }

    public static void setWxAppId(String str) {
        sWxAppId = str;
    }
}
