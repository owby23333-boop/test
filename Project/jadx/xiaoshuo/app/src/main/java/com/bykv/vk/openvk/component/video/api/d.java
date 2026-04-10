package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.bf.e.wu;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static Context bf = null;
    private static String d = null;
    public static boolean e = false;
    private static wu ga = null;
    private static boolean tg = false;

    public static boolean bf() {
        return tg;
    }

    public static wu d() {
        if (ga == null) {
            wu.e eVar = new wu.e("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ga = eVar.e(10000L, timeUnit).bf(10000L, timeUnit).d(10000L, timeUnit).e();
        }
        return ga;
    }

    public static String e() {
        if (TextUtils.isEmpty(d)) {
            try {
                File file = new File(getContext().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                d = file.getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return d;
    }

    public static Context getContext() {
        return bf;
    }

    public static boolean tg() {
        return e;
    }

    public static void e(Context context, String str) {
        bf = context;
        d = str;
    }

    public static void e(boolean z) {
        tg = z;
    }

    public static void e(wu wuVar) {
        ga = wuVar;
    }
}
