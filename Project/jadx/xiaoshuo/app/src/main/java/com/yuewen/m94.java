package com.yuewen;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class m94 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f14332a = {mj.e, "list.html", ".html"};

    public static Uri a(Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return uri;
        }
        String encodedFragment = uri.getEncodedFragment();
        if (TextUtils.isEmpty(encodedFragment)) {
            return uri.buildUpon().encodedFragment(str).build();
        }
        return uri.buildUpon().encodedFragment(encodedFragment + com.alipay.sdk.m.w.a.p + str).build();
    }

    public static String b(String str) {
        String strE = e(str, "backPage");
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        try {
            Uri uri = Uri.parse(c(str, strE));
            String strReplaceAll = str.replaceAll("backPage", "dkBackPage");
            if (TextUtils.isEmpty(uri.getEncodedFragment())) {
                return uri.buildUpon().appendQueryParameter("redirect", Uri.encode(strReplaceAll)).build().toString();
            }
            return uri.toString() + "&redirect=" + Uri.encode(strReplaceAll);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String c(String str, String str2) {
        Uri uriR;
        if (!TextUtils.isEmpty(Uri.parse(str2).getHost()) || (uriR = r(str)) == null || TextUtils.isEmpty(uriR.getHost())) {
            return str2;
        }
        return uriR.getScheme() + "://" + uriR.getHost() + uriR.getPath() + Uri.decode(str2);
    }

    public static String d(Uri uri, Uri uri2, String str) {
        String queryParameter;
        try {
            queryParameter = uri.getQueryParameter(str);
        } catch (Throwable unused) {
            queryParameter = null;
        }
        if (TextUtils.isEmpty(queryParameter)) {
            try {
                queryParameter = uri2.getQueryParameter(str);
            } catch (Throwable unused2) {
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = f(uri, str);
        }
        return TextUtils.isEmpty(queryParameter) ? f(uri2, str) : queryParameter;
    }

    public static String e(String str, String str2) {
        HashMap map = new HashMap();
        map.put(str2, "");
        j(map, str);
        return (String) map.get(str2);
    }

    public static String f(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                for (String str2 : uri.toString().split(com.alipay.sdk.m.w.a.p)) {
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = str + MscKeys.KEY_VAL_SEP;
                        int iIndexOf = str2.indexOf(str3);
                        if (iIndexOf >= 0) {
                            return str2.substring(iIndexOf + str3.length());
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static boolean g(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        return TextUtils.equals(t(str), str2);
    }

    public static boolean h(String str, String str2, String... strArr) {
        String strQ = q(str);
        if (strQ.equalsIgnoreCase(str2)) {
            return true;
        }
        for (String str3 : strArr) {
            if (strQ.equalsIgnoreCase(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(String str, String str2) {
        LinkedList linkedList = new LinkedList(o(str));
        LinkedList linkedList2 = new LinkedList(o(str2));
        String[] strArr = f14332a;
        linkedList.removeAll(Arrays.asList(strArr));
        linkedList2.removeAll(Arrays.asList(strArr));
        return linkedList.equals(linkedList2);
    }

    public static HashMap<String, String> j(@NonNull HashMap<String, String> map, @NonNull String str) {
        try {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri uri2 = null;
            Uri uri3 = TextUtils.isEmpty(encodedQuery) ? null : Uri.parse("?" + encodedQuery);
            String encodedFragment = uri.getEncodedFragment();
            if (!TextUtils.isEmpty(encodedFragment)) {
                String[] strArrSplit = encodedFragment.split("\\?");
                uri2 = Uri.parse("?" + strArrSplit[0]);
                if (strArrSplit.length > 1) {
                    uri3 = Uri.parse("?" + strArrSplit[1]);
                }
            }
            for (String str2 : map.keySet()) {
                String strD = d(uri3, uri2, str2);
                if (!TextUtils.isEmpty(strD)) {
                    map.put(str2, strD);
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static String k(String str, String str2) {
        String strQ = q(str);
        return TextUtils.isEmpty(strQ) ? str : str.replaceFirst(strQ, str2);
    }

    public static String l(Uri uri) {
        if (uri == null) {
            return "";
        }
        String host = uri.getHost();
        return TextUtils.isEmpty(host) ? "" : host;
    }

    public static String m(String str) {
        return l(r(str));
    }

    public static List<String> n(Uri uri) {
        List<String> pathSegments;
        return (uri == null || (pathSegments = uri.getPathSegments()) == null) ? Collections.emptyList() : pathSegments;
    }

    public static List<String> o(String str) {
        return n(r(str));
    }

    public static String p(Uri uri) {
        if (uri == null) {
            return "";
        }
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme;
    }

    public static String q(String str) {
        return p(r(str));
    }

    public static Uri r(String str) {
        try {
            return Uri.parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean s(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static String t(String str) {
        return str.startsWith("https") ? str.replaceFirst("https", "http") : str.startsWith("http:") ? str.replaceFirst("http:", "https:") : str;
    }
}
