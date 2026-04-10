package com.yuewen;

import android.net.Uri;
import android.text.TextUtils;
import miui.webkit.UrlResolverHelper;

/* JADX INFO: loaded from: classes12.dex */
public class rf4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17025a = ".duokan.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17026b = "https://www.duokan.com";
    public static final String c = "com.duokan.fiction";
    public static final String d = "callback";
    public static final String e = "msgid";
    public static final String f = "source";
    public static final String g = "from";
    public static final String h = "params";
    public static final String i = "method";
    public static final int j = 30000;
    public static final boolean k = false;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f17027a = "code";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f17028b = "message";
        public static final String c = "data";
        public static final String d = "parcelId";
        public static final String e = "type";
        public static final String f = "msgid";
        public static final String g = "callback";
        public static final String h = "event";
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f17029a = "backPressed";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f17030b = "wakeUp";
        public static final String c = "disappear";
        public static final String d = "scrollEnd";
        public static final String e = "mirrorUpdated";
        public static final String f = "pageClosed";
        public static final String g = "feedCommit";
        public static final String h = "commentCommit";
        public static final String i = "button";
        public static final String j = "screenChanged";
        public static final String k = "search";
        public static final String l = "dropdownButton";
        public static final String m = "menuButton";
        public static final String n = "input";
        public static final String o = "checkinAdClick";
        public static final String p = "adAward";
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f17031a = "content://";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f17032b = "content://com.duokan.fiction/web/static";
        public static final String c = "content://com.duokan.fiction/web/service";
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f17033a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17034b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 11;
        public static final int g = 12;
        public static final int h = 2000;
        public static final int i = 2001;
        public static final int j = 2002;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".duokan.com");
    }

    public static boolean b(Uri uri) {
        return ((TextUtils.equals("http", uri.getScheme()) || TextUtils.equals("https", uri.getScheme())) && (UrlResolverHelper.isMiHost(uri.getHost()) || a(uri.getHost()))) || TextUtils.equals(uri.getScheme(), "duokan-reader");
    }

    public static boolean c(Uri uri) {
        return TextUtils.equals("http", uri.getScheme());
    }

    public static boolean d(Uri uri) {
        return TextUtils.equals("https", uri.getScheme());
    }

    public static String e(String str) {
        Uri uriR = m94.r(str);
        return (((uriR == null || uriR.getScheme() == null) ? "" : uriR.getScheme()).equalsIgnoreCase("http") && a(uriR.getHost())) ? str.replace("http://", "https://") : str;
    }
}
