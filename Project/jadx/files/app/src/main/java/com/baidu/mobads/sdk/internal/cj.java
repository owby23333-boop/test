package com.baidu.mobads.sdk.internal;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class cj {
    public static final String a = "9.26";
    public static final String b = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13020e = "9.26";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13021f = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Boolean f13018c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Boolean f13019d = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Boolean f13022g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f13023h = "adserv_0";

    public static String a() {
        return f13023h;
    }

    public static double b() {
        try {
            return Double.parseDouble("9.26");
        } catch (Exception unused) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
    }

    public static double c() {
        try {
            return Double.parseDouble("9.26");
        } catch (Exception unused) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
    }

    public static int d() {
        try {
            return Integer.valueOf("9.26".split("\\.")[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
