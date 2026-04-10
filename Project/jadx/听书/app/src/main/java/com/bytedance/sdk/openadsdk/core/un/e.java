package com.bytedance.sdk.openadsdk.core.un;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static com.bytedance.sdk.openadsdk.core.ls g;
    private static final Map<String, z> z = Collections.synchronizedMap(new HashMap());

    public interface z {
        void onDenied(String str);

        void onGranted();
    }

    public static void z(String str, String[] strArr, z zVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.z(str, strArr);
    }

    public static void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.dl().execute(new com.bytedance.sdk.component.uy.fo("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.un.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.g().g(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        z zVarG = g(str);
        if (zVarG == null) {
            return;
        }
        zVarG.onGranted();
    }

    public static void z(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.dl().execute(new com.bytedance.sdk.component.uy.fo("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.un.e.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.g().g(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        z zVarG = g(str);
        if (zVarG == null) {
            return;
        }
        zVarG.onDenied(str2);
    }

    private static void z(final String str, final z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("addListener") { // from class: com.bytedance.sdk.openadsdk.core.un.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.wp.a("MultiProcess", "getListenerManager().registerPermissionListener...");
                        e.g().z(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.g.g(zVar));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                        com.bytedance.sdk.component.utils.wp.a("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            z.put(str, zVar);
        }
    }

    private static z g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.ls g() {
        if (g == null) {
            g = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.a.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(com.bytedance.sdk.openadsdk.core.zw.getContext()).z(4));
        }
        return g;
    }
}
