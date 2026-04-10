package com.kwad.sdk.core.kwai;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", bK(s(str, str2)));
    }

    private static String bJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] strArrSplit = str.split(DispatchConstants.SIGN_SPLIT_SYMBOL);
        Arrays.sort(strArrSplit);
        return TextUtils.join(DispatchConstants.SIGN_SPLIT_SYMBOL, strArrSplit);
    }

    private static String bK(String str) {
        String strDoSign;
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        return (context == null || (strDoSign = KWEGIDDFP.doSign(context, str)) == null) ? "" : strDoSign;
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String s(String str, String str2) {
        Uri uri = Uri.parse(str);
        return uri.getPath() + DispatchConstants.SIGN_SPLIT_SYMBOL + bJ(uri.getQuery()) + DispatchConstants.SIGN_SPLIT_SYMBOL + str2;
    }
}
