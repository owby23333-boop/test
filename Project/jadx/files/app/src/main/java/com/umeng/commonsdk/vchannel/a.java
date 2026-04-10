package com.umeng.commonsdk.vchannel;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a = "https://pslog.umeng.com";
    public static String b = "https://pslog.umeng.com/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f20239c = "explog";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20240d = "analytics";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f20241e = "ekv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f20242f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f20243g = "ts";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f20244h = "ds";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f20245i = "pn";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f20246j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f20246j = sb.toString();
    }
}
