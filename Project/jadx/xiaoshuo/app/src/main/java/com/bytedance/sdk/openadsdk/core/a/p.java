package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class p {
    private static com.bytedance.sdk.openadsdk.core.f bf;
    private static final Map<String, e> e = Collections.synchronizedMap(new HashMap());

    public interface e {
        void e();

        void e(String str);
    }

    private static e bf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e.remove(str);
    }

    public static void e(String str, String[] strArr, e eVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        e(str, eVar);
        TTDelegateActivity.e(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.f bf() {
        if (bf == null) {
            bf = f.e.e(com.bytedance.sdk.openadsdk.core.multipro.aidl.e.e(com.bytedance.sdk.openadsdk.core.lc.getContext()).e(4));
        }
        return bf;
    }

    public static void e(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.bf.d()) {
            com.bytedance.sdk.component.zk.ga.d().execute(new com.bytedance.sdk.component.zk.p("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.a.p.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.wu.bf("MultiProcess", "handleYes-1，key=" + str);
                        p.bf().bf(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        e eVarBf = bf(str);
        if (eVarBf == null) {
            return;
        }
        eVarBf.e();
    }

    public static void e(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.bf.d()) {
            com.bytedance.sdk.component.zk.ga.d().execute(new com.bytedance.sdk.component.zk.p("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.a.p.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.wu.bf("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                        p.bf().bf(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        e eVarBf = bf(str);
        if (eVarBf == null) {
            return;
        }
        eVarBf.e(str2);
    }

    private static void e(final String str, final e eVar) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.bf.d()) {
            com.bytedance.sdk.component.zk.ga.bf(new com.bytedance.sdk.component.zk.p("addListener") { // from class: com.bytedance.sdk.openadsdk.core.a.p.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.wu.vn("MultiProcess", "getListenerManager().registerPermissionListener...");
                        p.bf().e(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.bf(eVar));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        com.bytedance.sdk.component.utils.wu.vn("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            e.put(str, eVar);
        }
    }
}
