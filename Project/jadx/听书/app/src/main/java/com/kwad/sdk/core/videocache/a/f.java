package com.kwad.sdk.core.videocache.a;

import android.net.Uri;
import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.sdk.utils.al;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements c {
    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String strER = eR(str);
        String extension = getExtension(strER);
        String strMd5 = al.md5(strER);
        return TextUtils.isEmpty(extension) ? strMd5 : strMd5 + FileUtils.FILE_EXTENSION_SEPARATOR + extension;
    }

    private static String getExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    private static String eR(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (uri.getHost() == null || !uri.getHost().endsWith(".yximgs.com")) {
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
}
