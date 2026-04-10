package com.bytedance.sdk.openadsdk.core.un;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.i.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static com.bytedance.sdk.openadsdk.core.ls g;
    private static final Map<String, z> z = Collections.synchronizedMap(new HashMap());

    public interface z {
        void onDialogBtnNo();

        void onDialogBtnYes();

        void onDialogCancel();
    }

    public static void z(Context context, String str, String str2, String str3, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.z(context, str, str2, str3);
    }

    public static void z(final Context context, final String str, final String str2, final String str3, final z zVar, final com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar, final com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.m.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = com.bytedance.sdk.openadsdk.core.uy.ls().z(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                    if (m.z.containsKey(str)) {
                        return;
                    }
                    if (!eo.a() && !z2) {
                        return;
                    }
                }
                m.z(str, zVar);
                TTDelegateActivity.z(context, str, str2, str3, eVar, naVar);
            }
        });
    }

    public static void z(final Context context, final String str, final String str2, final String str3, final z zVar, final com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.m.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = com.bytedance.sdk.openadsdk.core.uy.ls().z(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                    if (m.z.containsKey(str)) {
                        return;
                    }
                    if (!eo.a() && !z2) {
                        return;
                    }
                }
                m.z(str, zVar);
                TTDelegateActivity.z(context, str, str2, str3, naVar);
            }
        });
    }

    public static void z(String str) {
        Map<String, z> map = z;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void z(Context context, String str, z zVar, String str2, com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.z(context, str, str2, naVar);
    }

    public static void z(final com.bytedance.sdk.openadsdk.core.iq.na naVar, final Context context, final String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        z(context, naVar.mj(), new z() { // from class: com.bytedance.sdk.openadsdk.core.un.m.3
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                m.a(naVar, context, str);
            }
        }, naVar.gy(), naVar);
    }

    public static void z(Context context, String str, z zVar, String str2) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.g(context, str, str2);
    }

    public static void g(final com.bytedance.sdk.openadsdk.core.iq.na naVar, final Context context, final String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        z(context, naVar.mj(), new z() { // from class: com.bytedance.sdk.openadsdk.core.un.m.4
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                m.a(naVar, context, str);
            }
        }, naVar.gy());
    }

    public static void z(Context context, String str, String str2, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.z(context, str, str2);
    }

    public static void dl(final com.bytedance.sdk.openadsdk.core.iq.na naVar, final Context context, final String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        z(context, naVar.mj(), naVar.gy(), new z() { // from class: com.bytedance.sdk.openadsdk.core.un.m.5
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                m.a(naVar, context, str);
            }
        });
    }

    public static void z(final Context context, final com.bytedance.sdk.openadsdk.core.iq.na naVar, final String str) {
        if (naVar == null) {
            return;
        }
        String strMj = naVar.mj();
        if (TextUtils.isEmpty(strMj)) {
            return;
        }
        z(strMj, new z() { // from class: com.bytedance.sdk.openadsdk.core.un.m.6
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                m.a(naVar, context, str);
            }
        });
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
        if (mVarBw == null) {
            return;
        }
        TTDelegateActivity.dl(context, strMj, mVarBw.fo());
    }

    public static void g(Context context, String str, String str2, z zVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        z(str2, zVar);
        TTDelegateActivity.dl(context, str2, str);
    }

    public static void z(Context context, String str) {
        TTDelegateActivity.z(context, str);
        com.bytedance.sdk.openadsdk.core.q.v.z().g(str);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.iq.na naVar, Context context, String str) {
        int iFv = com.bytedance.sdk.openadsdk.core.iq.tb.fv(naVar);
        if (naVar == null || context == null) {
            return;
        }
        if (naVar.lt() == 4 || iFv != 0) {
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z(context, naVar, str, false);
            if (dlVarZ instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVarZ).gz().z(false);
            }
            dlVarZ.z(naVar, false);
        }
    }

    public static void z(Context context, String str, String str2, String str3, String str4, String str5, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z(str, zVar);
        TTDelegateActivity.z(context, str, str2, str3, str4, str5);
    }

    public static void z(Context context, String str, boolean z2, z zVar) {
        if (z2) {
            TTDelegateActivity.z(context, str, z2);
        } else {
            if (TextUtils.isEmpty(str) || zVar == null) {
                return;
            }
            z(str, zVar);
            TTDelegateActivity.z(context, str, z2);
        }
    }

    public static void g(String str) {
        z(str, 1);
    }

    public static void dl(String str) {
        z(str, 2);
    }

    public static void a(String str) {
        z(str, 3);
    }

    public static void z(final String str, final z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.un.m.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        m.dl().z(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.g.z(zVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            z.put(str, zVar);
        }
    }

    public static z gc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.remove(str);
    }

    private static void z(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.un.m.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        m.dl().z(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        z zVarGc = gc(str);
        if (zVarGc == null) {
            return;
        }
        if (i == 1) {
            zVarGc.onDialogBtnYes();
            return;
        }
        if (i == 2) {
            zVarGc.onDialogBtnNo();
        } else if (i == 3) {
            zVarGc.onDialogCancel();
        } else {
            zVarGc.onDialogCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.ls dl() {
        if (g == null) {
            g = com.bytedance.sdk.openadsdk.core.multipro.aidl.z.dl.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(com.bytedance.sdk.openadsdk.core.zw.getContext()).z(2));
        }
        return g;
    }

    public static void z(Context context, String str, com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        TTDelegateActivity.z(context, str, naVar);
    }

    public static void z(Context context, final com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return;
        }
        new z.C0178z().gc(naVar.mj()).z("pangle_logo").g("open_policy").a(naVar.vk()).z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.m.9
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", naVar.nv());
                jSONObject2.put("ad_slot_type", eo.gz(naVar));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
        TTDelegateActivity.g(context, naVar.nv());
    }

    public static boolean z(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null || naVar.fs() || naVar.dt() == null || com.bytedance.sdk.openadsdk.core.iq.tb.i(naVar) == 1 || naVar.lt() != 4 || com.bytedance.sdk.openadsdk.core.iq.tb.wp(naVar) == 0) {
            return false;
        }
        int iFv = naVar.fv();
        return iFv == 4 || iFv == 5;
    }
}
