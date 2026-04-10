package com.anythink.expressad.exoplayer;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final String a = "ExoPlayer";
    public static final String b = "2.8.4";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9925c = "ExoPlayerLib/2.8.4";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9926d = 2008004;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f9927e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f9928f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashSet<String> f9929g = new HashSet<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9930h = "goog.exo.core";

    private l() {
    }

    public static synchronized String a() {
        return f9930h;
    }

    private static synchronized void a(String str) {
        if (f9929g.add(str)) {
            f9930h += ", " + str;
        }
    }
}
