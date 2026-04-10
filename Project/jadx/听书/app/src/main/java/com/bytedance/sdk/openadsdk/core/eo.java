package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class eo {
    private static boolean z;

    public static boolean z(na naVar, String str) {
        if (naVar == null) {
            return false;
        }
        String strFp = naVar.fp();
        if (TextUtils.isEmpty(strFp)) {
            return false;
        }
        return z(strFp, naVar, str);
    }

    public static boolean z(String str, na naVar, String str2) {
        return z(zw.getContext(), str, naVar, com.bytedance.sdk.openadsdk.core.un.eo.g(str2), str2);
    }

    public static boolean z(Context context, String str, na naVar, String str2) {
        return z(context, str, naVar, com.bytedance.sdk.openadsdk.core.un.eo.g(str2), str2);
    }

    public static boolean z(Context context, String str, na naVar, int i, String str2) {
        try {
            return com.bytedance.sdk.component.utils.g.z(context, z(context, str, naVar, i, null, str2, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean z(Object obj) {
        if (obj == null || !(obj instanceof z.InterfaceC0190z)) {
            return false;
        }
        try {
            return ((z.InterfaceC0190z) obj).h();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent z(Context context, String str, na naVar, int i, Object obj, String str2, boolean z2) {
        Class cls;
        boolean z3 = false;
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.m(naVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.bytedance.sdk.openadsdk.ls.dl.g.fo) && na.g(naVar) && !z && !z(obj) && com.bytedance.sdk.openadsdk.core.un.eo.gc(naVar) && (naVar == null || !naVar.e())) {
            cls = TTVideoWebPageActivity.class;
            z3 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z3) {
            z(context, naVar, obj, z2, intent);
        }
        z(context, str, naVar, i, str2, intent);
        return intent;
    }

    private static void z(Context context, na naVar, Object obj, boolean z2, Intent intent) {
        int i;
        if (obj != null) {
            zVarKb = obj instanceof z.InterfaceC0190z ? ((z.InterfaceC0190z) obj).x() : null;
            if (zVarKb != null) {
                intent.putExtra("multi_process_data", zVarKb.z().toString());
            }
        }
        if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.g) && (zVarKb = ((com.bytedance.sdk.openadsdk.core.nativeexpress.g) obj).kb()) != null) {
            intent.putExtra("multi_process_data", zVarKb.z().toString());
        }
        if (zVarKb != null) {
            intent.putExtra("video_is_auto_play", zVarKb.f1272a);
            com.bytedance.sdk.component.utils.wp.z("videoDataModel", "videoDataModel=" + zVarKb.z().toString());
        }
        if (zVarKb != null || z2) {
            try {
                if (zVarKb != null) {
                    i = (int) ((zVarKb.e / zVarKb.gc) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
                    zVar.e = 100L;
                    zVar.z = true;
                    zVar.f1272a = com.bytedance.sdk.openadsdk.core.un.eo.q(naVar);
                    intent.putExtra("multi_process_data", zVar.z().toString());
                    i = 100;
                }
                if (naVar.vt() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (naVar.vt() <= 0 || i <= naVar.vt() || !com.bytedance.sdk.openadsdk.core.un.eo.q(naVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void z(Context context, String str, na naVar, int i, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl(context, naVar).a(false)) {
            naVar.dl(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", naVar.pd());
        intent.putExtra("title", naVar.li());
        intent.putExtra("sdk_version", gk.dl);
        intent.putExtra(MediationConstant.EXTRA_ADID, naVar.mj());
        intent.putExtra(MediationConstant.EXTRA_LOG_EXTRA, naVar.vk());
        intent.putExtra("icon_url", naVar.kp() == null ? null : naVar.kp().z());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", naVar.dl());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.bytedance.sdk.openadsdk.core.un.eo.z(intent, naVar);
    }

    public static boolean z(Context context, na naVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            z(context, null, naVar, i, str, intent);
            if (na.g(naVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.g.z(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
