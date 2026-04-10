package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    public static boolean z() {
        try {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().vm()) {
                return true;
            }
            Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
            if (context.getApplicationInfo() != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar) {
        try {
            if (!zVar.gz() || com.bytedance.sdk.component.utils.wp.z()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.wp.g();
                com.bykv.vk.openvk.component.video.api.m.dl.z();
                com.bytedance.sdk.component.fo.z.z();
                com.bytedance.sdk.openadsdk.tools.g.g();
                com.bytedance.sdk.component.wp.g.z.z(true);
            }
        } catch (Exception unused) {
        }
    }
}
