package com.yuewen;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class he0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12005a = "com.duokan.reader.actions.SHOW_BOOKSHELF";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12006b = "com.duokan.reader.actions.SHOW_BOOKSHELF";
    public static final String h = "duokan-reader";
    public static final String i = "duokan-reader";
    public static final String n = "show_menu";
    public static final String o = "duokan-reader://store/";
    public static final String p = "duokan-reader://store-free/";
    public static final String c = "com.duokan.reader.actions.SHOW_RUNNING_DOWNLOAD_TASKS";
    public static final String d = "com.duokan.reader.actions.SHOW_STORE";
    public static final String e = "com.duokan.reader.actions.SHOW_PROMPT";
    public static final String f = "com.duokan.reader.actions.SHOW_PRIVACY_FREE_PROMPT";
    public static final String g = "com.duokan.reader.actions.OPEN_REPLY_MESSAGES";
    public static final String j = "com.duokan.reader.actions.SHOW_FEEDBACK";
    public static final String k = "com.duokan.reader.actions.OPEN_BOOK";
    public static final String l = "com.duokan.reader.actions.READ_HISTORY";
    public static final String m = "com.duokan.reader.actions.CLOUD_DISK";
    public static final HashSet<String> q = new HashSet<>(Arrays.asList("com.duokan.reader.actions.SHOW_BOOKSHELF", "com.duokan.reader.actions.SHOW_BOOKSHELF", c, d, e, f, g, j, k, l, m));

    public static String a(String str) {
        return p + str;
    }

    public static String b(String str) {
        return o + str;
    }

    public static String c(String str, String str2) {
        return "duokan-reader://reading/" + str + "?" + n + "=1&click_track=" + str2;
    }
}
