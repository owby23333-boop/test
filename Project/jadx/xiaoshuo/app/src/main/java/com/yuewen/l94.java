package com.yuewen;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class l94 {
    public static void a(Uri uri, HashMap<String, String> map) {
        if (uri == null) {
            return;
        }
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, uri.getQueryParameter(str));
        }
    }

    public static HashMap<String, String> b(String str) {
        Uri uri;
        HashMap<String, String> map = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            Uri uri2 = Uri.parse(str);
            if (uri2.getEncodedQuery() != null) {
                a(uri2, map);
            } else {
                String encodedFragment = uri2.getEncodedFragment();
                if (!TextUtils.isEmpty(encodedFragment)) {
                    String[] strArrSplit = encodedFragment.split("\\?");
                    Uri uri3 = Uri.parse("?" + strArrSplit[0]);
                    if (strArrSplit.length > 1) {
                        uri = Uri.parse("?" + strArrSplit[1]);
                    } else {
                        uri = null;
                    }
                    a(uri3, map);
                    a(uri, map);
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static String c(Uri uri, Uri uri2, String str) {
        String queryParameter;
        try {
            queryParameter = uri.getQueryParameter(str);
        } catch (Throwable unused) {
            queryParameter = null;
        }
        if (!TextUtils.isEmpty(queryParameter)) {
            return queryParameter;
        }
        try {
            return uri2.getQueryParameter(str);
        } catch (Throwable unused2) {
            return queryParameter;
        }
    }
}
