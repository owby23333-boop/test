package com.ss.android.download.api.d;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.wu;
import com.ss.android.socialbase.appdownloader.vn.ga;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    public static String bf(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        return (wu.zk().optInt("market_scheme_opt") == 1 && ga.p() && BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) && pathSegments != null && pathSegments.size() == 1) ? pathSegments.get(0) : bf.e(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    public static boolean e(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return wu.zk().optInt("market_url_opt", 1) == 0 ? "market".equals(scheme) : "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme);
    }
}
