package com.bytedance.sdk.openadsdk.s;

import android.app.Activity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class zk {
    private static Map<String, Field> e = new HashMap();

    public static void e() {
        com.bytedance.e.e.ga.e.bf.e(new com.bytedance.e.e.tg() { // from class: com.bytedance.sdk.openadsdk.s.zk.1
            @Override // com.bytedance.e.e.tg
            public String e(Activity activity) {
                try {
                    return activity.toString();
                } catch (Throwable unused) {
                    return "";
                }
            }
        });
    }
}
