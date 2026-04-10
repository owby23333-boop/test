package com.bytedance.sdk.openadsdk.core.kb.z;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.e;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static void requestPermission(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        boolean z;
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarJs;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (com.kuaishou.weapon.p0.g.j.equalsIgnoreCase(strArr[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z && (aVarJs = com.bytedance.sdk.openadsdk.core.uy.ls().js()) != null && iTTPermissionCallback != null && !aVarJs.gc()) {
                iTTPermissionCallback.onDenied(com.kuaishou.weapon.p0.g.j);
                return;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.gz.z.dl(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        long jHashCode = activity.hashCode();
        for (String str : strArr) {
            jHashCode += (long) str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, com.kuaishou.weapon.p0.g.i) || TextUtils.equals(str2, com.kuaishou.weapon.p0.g.j)) {
                if (iTTPermissionCallback != null) {
                    iTTPermissionCallback.onDenied(str2);
                }
                v.z().z(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.un.e.z(String.valueOf(jHashCode), strArr, new e.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.fo.1
            @Override // com.bytedance.sdk.openadsdk.core.un.e.z
            public void onGranted() {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onGranted();
                }
                v.z().z(true, strArr);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.e.z
            public void onDenied(String str3) {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onDenied(str3);
                }
                v.z().z(false, new String[]{str3});
            }
        });
    }

    public static boolean hasPermission(Context context, String str) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP;
        if (com.kuaishou.weapon.p0.g.j.equalsIgnoreCase(str) && (aVarP = com.bytedance.sdk.openadsdk.core.uy.ls().p()) != null && !aVarP.gc()) {
            return false;
        }
        if (context == null) {
            context = zw.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, str);
    }
}
