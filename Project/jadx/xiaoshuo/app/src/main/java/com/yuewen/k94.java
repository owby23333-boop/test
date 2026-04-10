package com.yuewen;

import android.net.Uri;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class k94 {
    public static Uri a(Uri uri, String str, String str2) {
        if (uri == null) {
            return null;
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
        for (String str3 : queryParameterNames) {
            builderClearQuery.appendQueryParameter(str3, str3.equals(str) ? str2 : uri.getQueryParameter(str3));
        }
        return builderClearQuery.build();
    }
}
