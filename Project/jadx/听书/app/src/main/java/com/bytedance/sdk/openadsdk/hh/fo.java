package com.bytedance.sdk.openadsdk.hh;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1438a = null;
    public static volatile com.bykv.vk.openvk.component.video.api.z.g dl = null;
    public static volatile com.bykv.vk.openvk.component.video.api.z.g g = null;
    private static String gc = null;
    private static int m = 1;
    public static String z;

    private static com.bykv.vk.openvk.component.video.api.z.g e() {
        if (g == null) {
            synchronized (fo.class) {
                if (g == null) {
                    com.bykv.vk.openvk.component.video.z.z.z.z zVar = new com.bykv.vk.openvk.component.video.z.z.z.z();
                    g = zVar;
                    zVar.z(fo());
                    g.gc();
                }
            }
        }
        return g;
    }

    private static com.bykv.vk.openvk.component.video.api.z.g gz() {
        if (dl == null) {
            synchronized (fo.class) {
                if (dl == null) {
                    com.bytedance.sdk.component.wp.g.z.z zVar = new com.bytedance.sdk.component.wp.g.z.z();
                    dl = zVar;
                    zVar.z(fo());
                    dl.gc();
                }
            }
        }
        return dl;
    }

    private static String fo() {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        int iZd = zw.g().zd();
        m = iZd;
        String strG = g(iZd);
        z = strG;
        return strG;
    }

    private static String g(int i) {
        File fileZ;
        Context context = zw.getContext();
        if (i == 1) {
            wp.z("CacheDirConstants", "使用内部存储");
            fileZ = com.bytedance.sdk.component.utils.m.g(context, com.bytedance.sdk.openadsdk.core.multipro.g.dl(), "tt_ad");
        } else {
            wp.z("CacheDirConstants", "使用外部存储");
            fileZ = com.bytedance.sdk.component.utils.m.z(context, com.bytedance.sdk.openadsdk.core.multipro.g.dl(), "tt_ad");
        }
        if (fileZ.isFile()) {
            fileZ.delete();
        }
        if (!fileZ.exists()) {
            fileZ.mkdirs();
        }
        return fileZ.getAbsolutePath();
    }

    public static com.bykv.vk.openvk.component.video.api.z.g z(int i) {
        if (i == 1) {
            return gz();
        }
        return e();
    }

    public static String z() {
        return fo() + File.separator + "video_brand";
    }

    public static String[] g() {
        String strG = g(1);
        com.bytedance.sdk.component.wp.g.z.z zVar = new com.bytedance.sdk.component.wp.g.z.z();
        zVar.z(strG);
        String strG2 = g(0);
        com.bytedance.sdk.component.wp.g.z.z zVar2 = new com.bytedance.sdk.component.wp.g.z.z();
        zVar2.z(strG2);
        return new String[]{zVar.g(), zVar.dl(), zVar.z(), zVar.a(), zVar2.g(), zVar2.dl(), zVar2.z(), zVar2.a()};
    }

    public static long[] dl() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static int a() {
        return m;
    }

    public static String z(String str) {
        return fo() + File.separator + str;
    }

    public static String gc() {
        if (f1438a == null) {
            f1438a = z("splash_image");
        }
        return f1438a;
    }

    public static String m() {
        if (gc == null) {
            gc = z("image");
        }
        return gc;
    }
}
