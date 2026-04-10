package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.g.z.wp;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f95a = false;
    private static String dl = null;
    private static Context g = null;
    private static wp gc = null;
    private static int m = 1;
    public static boolean z;

    public static Context getContext() {
        return g;
    }

    public static String z() {
        if (TextUtils.isEmpty(dl)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                dl = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        return dl;
    }

    public static void z(Context context, String str) {
        g = context;
        dl = str;
    }

    public static boolean g() {
        return f95a;
    }

    public static void z(boolean z2) {
        f95a = z2;
    }

    public static wp dl() {
        if (gc == null) {
            gc = new wp.z("v_config").z(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).g(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).dl(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).z();
        }
        return gc;
    }

    public static void z(wp wpVar) {
        gc = wpVar;
    }

    public static boolean a() {
        return z;
    }

    public static int gc() {
        return m;
    }
}
