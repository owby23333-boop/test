package com.ss.android.z.z.m;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.appdownloader.m.gc;
import com.umeng.analytics.pro.an;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    public static boolean z(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (wp.fo().optInt("market_url_opt", 1) == 0) {
            return "market".equals(scheme);
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme) || "prizeappcenter".equals(scheme);
    }

    public static String g(Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (wp.fo().optInt("market_scheme_opt") == 1 && gc.e() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return g.z(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter(an.o), uri.getQueryParameter("appId"));
    }

    public static Uri z(Context context, String str) {
        String string = Settings.System.getString(context.getContentResolver(), "persit.sys.tid");
        Uri.Builder builder = new Uri.Builder();
        if (gc.p() && wp.fo().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority("details").appendQueryParameter("id", str).build();
        }
        if (!TextUtils.isEmpty(string) && wp.fo().optInt("enable_persit_market_scheme_opt", 1) == 1) {
            return builder.scheme("prizeappcenter").authority("details").appendQueryParameter("pkg", str).build();
        }
        return Uri.parse("market://details?id=".concat(String.valueOf(str)));
    }
}
