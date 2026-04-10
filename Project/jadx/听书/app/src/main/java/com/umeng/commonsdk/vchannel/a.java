package com.umeng.commonsdk.vchannel;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2372a = "https://pslog.umeng.com";
    public static String b = "https://pslog.umeng.com/";
    public static String c = "explog";
    public static final String d = "analytics";
    public static final String e = "ekv";
    public static final String f = "id";
    public static final String g = "ts";
    public static final String h = "ds";
    public static final String i = "pn";
    public static String j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        j = str + String.format("%0" + (32 - str.length()) + "d", 0);
    }
}
