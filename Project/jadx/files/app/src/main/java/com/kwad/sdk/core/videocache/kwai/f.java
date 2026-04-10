package com.kwad.sdk.core.videocache.kwai;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.ac;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements c {
    private static String cH(String str) {
        Uri uri = Uri.parse(str);
        if (uri.getHost() == null || !uri.getHost().contains("yximgs.com")) {
            return str;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        HashMap map = new HashMap();
        if (uri.isHierarchical()) {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                map.put(str2, uri.getQueryParameter(str2));
            }
            builderBuildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!"tag".equals(str3) && !"di".equals(str3) && str3 != null) {
                    builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
                }
            }
        }
        return builderBuildUpon.toString();
    }

    private static String getExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.kwai.c
    public final String generate(String str) {
        String strCH = cH(str);
        String extension = getExtension(strCH);
        String strEl = ac.el(strCH);
        if (TextUtils.isEmpty(extension)) {
            return strEl;
        }
        return strEl + "." + extension;
    }
}
