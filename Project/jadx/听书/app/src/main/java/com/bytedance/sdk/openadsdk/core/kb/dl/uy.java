package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static int z(na naVar) {
        if (naVar == null || naVar.zb() != 1) {
            return 0;
        }
        if (naVar.dh() == 0) {
            return 1;
        }
        return naVar.dh() == 1 ? dl(naVar) ? 0 : 1 : naVar.dh() == 2 ? 2 : 1;
    }

    public static String g(na naVar) {
        if (naVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = naVar.c();
        if (gcVarC != null && !TextUtils.isEmpty(gcVarC.dl())) {
            return gcVarC.dl();
        }
        if (!TextUtils.isEmpty(naVar.hy())) {
            return naVar.hy();
        }
        if (TextUtils.isEmpty(naVar.he())) {
            return !TextUtils.isEmpty(naVar.ry()) ? naVar.ry() : "";
        }
        return naVar.he();
    }

    public static boolean dl(na naVar) {
        if (naVar == null) {
            return false;
        }
        return a(naVar);
    }

    public static boolean a(na naVar) {
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
        return (mVarBw == null || TextUtils.isEmpty(mVarBw.v()) || TextUtils.isEmpty(mVarBw.gc()) || TextUtils.isEmpty(mVarBw.e()) || mVarBw.z() == null || mVarBw.z().size() <= 0 || TextUtils.isEmpty(mVarBw.gz()) || TextUtils.isEmpty(mVarBw.fo())) ? false : true;
    }

    public static void z(final Context context) {
        if (context == null) {
            context = zw.getContext();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            hh.z(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            q.m().post(new com.bytedance.sdk.component.uy.fo("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.uy.1
                @Override // java.lang.Runnable
                public void run() {
                    hh.z(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }
}
