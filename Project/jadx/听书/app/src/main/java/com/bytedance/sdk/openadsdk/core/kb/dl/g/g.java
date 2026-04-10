package com.bytedance.sdk.openadsdk.core.kb.dl.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl;
import com.bytedance.sdk.openadsdk.core.kb.fo;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.a;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z(String str, String str2, na naVar, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        if (naVar == null) {
            z(true, functionOq, str2, naVar, jSONObject, str, "", null, i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            z(true, functionOq, str2, naVar, jSONObject, str, "", null, i);
            return;
        }
        String strRy = naVar.ry();
        if (TextUtils.isEmpty(strRy) && naVar.bw() != null) {
            strRy = naVar.bw().i();
        }
        z(false, functionOq, str2, naVar, jSONObject, str, "", strRy, i);
    }

    public static void z(String str, na naVar, JSONObject jSONObject, int i) {
        String str2;
        String str3;
        String strA;
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        if (naVar == null) {
            z(true, functionOq, str, naVar, jSONObject, null, null, null, i);
            return;
        }
        gc gcVarC = naVar.c();
        if (gcVarC != null) {
            String strG = gcVarC.g();
            String strDl = gcVarC.dl();
            strA = gcVarC.a();
            str2 = strG;
            str3 = strDl;
        } else {
            str2 = "";
            str3 = str2;
            strA = str3;
        }
        z(false, functionOq, str, naVar, jSONObject, str2, str3, strA, i);
    }

    private static void z(boolean z, Function<SparseArray<Object>, Object> function, String str, na naVar, JSONObject jSONObject, String str2, String str3, String str4, int i) {
        String str5;
        String strFp;
        String strLi;
        if (function == null) {
            return;
        }
        if (z) {
            function.apply(a.z().z(23).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(i)).z("mateIsEmpty", Boolean.valueOf(z))).g());
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            try {
                jSONObject2.put(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY, z.z().z(str).g(jSONObject).z(naVar).g());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        long jLongValue = Double.valueOf(naVar.mj()).longValue();
        String strZ = naVar.kp() == null ? null : naVar.kp().z();
        boolean zH = uy.ls().h();
        boolean z2 = !uy.ls().h();
        String strVk = naVar.vk();
        JSONObject jSONObjectG = fo.g();
        JSONObject jSONObject3 = new JSONObject();
        try {
            int iOptInt = jSONObjectG.optInt("notification_opt_2", 0);
            if (iOptInt != 1) {
                iOptInt = 0;
            }
            int iJs = tb.js(naVar);
            if (!gk.e()) {
                jSONObject3.put("cancel_pause_optimise_switch", iJs);
                jSONObject3.put("cancel_pause_optimise_wifi_retain_switch", iJs);
                jSONObject3.put("cancel_pause_optimise_apk_retain_switch", iJs);
                jSONObject3.put("cancel_pause_optimise_download_percent_retain_switch", iJs);
            }
            jSONObject3.put("show_pause_continue_toast", iJs);
            str5 = "hashCode";
            try {
                if (iJs == 1) {
                    z(true, i);
                    jSONObject3.put("download_start_toast_text", jSONObjectG.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
                } else if (zw.g().s()) {
                    z(true, i);
                    jSONObject3.put("enable_notification_ui", 1);
                    jSONObject3.put("download_start_toast_text", "下载中，可在通知栏暂停或取消");
                }
                jSONObject3.put("notification_opt_2", iOptInt);
                jSONObject3.put("is_use_obm_convert", tb.g(naVar));
            } catch (JSONException unused3) {
            }
        } catch (JSONException unused4) {
            str5 = "hashCode";
        }
        String strFp2 = "";
        if (naVar.vy() != null) {
            String strG = naVar.vy().g();
            strLi = naVar.li();
            if (naVar.vy().gc() != 2 || na.g(naVar)) {
                if (naVar.vy().gc() == 1) {
                    strFp2 = naVar.vy().a();
                } else {
                    strFp2 = naVar.fp();
                }
            }
            String str6 = strFp2;
            strFp2 = strG;
            strFp = str6;
        } else {
            strFp = naVar.fp();
            strLi = "";
        }
        function.apply(a.z().z(23).z(Void.class).z(0, new lq().z("mateIsEmpty", Boolean.FALSE).z("id", Long.valueOf(jLongValue)).z("appIcon", strZ).z("isShowNotification", Boolean.valueOf(zH)).z("isAutoInstallWithoutNotification", Boolean.valueOf(z2)).z("logExtra", strVk).z("extraJson", jSONObject2).z("downloadSettings", jSONObject3).z("filePath", uy.ls().g()).z("appName", str3).z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, str2).z("packageName", str4).z("isNeedIndependentProcess", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.multipro.g.dl())).z("openUrl", strFp2).z("webTitle", strLi).z(str5, Integer.valueOf(i)).z("webUrl", strFp)).g());
    }

    public static void z(na naVar, int i, boolean z) {
        boolean zG;
        boolean z2;
        boolean z3;
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        int iA = tb.a(naVar);
        int iGc = tb.gc(naVar);
        if (naVar != null && (!TextUtils.isEmpty(naVar.po()) || z)) {
            iGc = 2;
        }
        if (naVar == null || naVar.gw() == null) {
            zG = false;
            z2 = false;
            z3 = false;
        } else {
            z2 = naVar.gw().z();
            zG = naVar.gw().g();
            z3 = true;
        }
        functionOq.apply(a.z().z(25).z(Void.class).z(0, new lq().z("autoOpen", Integer.valueOf(iA)).z("downloadMode", Integer.valueOf(iGc)).z("isHaveDownloadSdkConfig", Boolean.valueOf(z3)).z("hashCode", Integer.valueOf(i)).z("isEnableAH", Boolean.valueOf(z2)).z("isEnableAM", Boolean.valueOf(zG))).g());
    }

    public static void z(int i, int i2) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(26).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(i2)).z("downloadMode", Integer.valueOf(i))).g());
    }

    public static void z(boolean z, int i) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(31).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(i)).z("isShowToast", Boolean.valueOf(z))).g());
    }

    public static int z(Function<SparseArray<Object>, Object> function, int i) {
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(a.z().z(27).z(Integer.class).z(0, new lq().z("hashCode", Integer.valueOf(i))).g());
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static void z(boolean z, com.bytedance.sdk.openadsdk.core.kb.z.a aVar, int i) {
        try {
            Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
            if (functionOq == null) {
                return;
            }
            functionOq.apply(a.z().z(28).z(Void.class).z(0, new lq().z("isEnableOppoAutoDownload", Boolean.valueOf(z)).z("hashCode", Integer.valueOf(i)).z("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.ls.dl.a.z(aVar))).g());
        } catch (Throwable th) {
            wp.dl("xgc_dof", "throwable", th);
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.core.kb.z.a aVar, int i) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(i)).z("downloadMarketInterceptor", com.bytedance.sdk.openadsdk.ls.dl.a.z(aVar))).g());
    }

    public static void z(String str, String str2, String str3, String str4, int i, int i2, Bitmap bitmap, String str5, String str6, String str7) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(160).z(Void.class).z(0, new lq().z("install_app_name", str).z("install_icon_bitmap", bitmap).z("install_action_type", str4).z("install_click_type", Integer.valueOf(i2)).z("install_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && zw.g().qz() > 0)).z("install_package_name", str5).z("install_tag", str6).z("install_value", str7).z("install_log_extra", str3).z("install_download_id", Integer.valueOf(i))).g());
    }

    public static com.bytedance.sdk.openadsdk.core.kb.z.a z(na naVar, final boolean z) {
        if (naVar == null) {
            return null;
        }
        String strDc = naVar.dc();
        if (!TextUtils.isEmpty(strDc) && gk.dl >= 6400) {
            final String strAq = naVar.aq();
            final String strMk = naVar.mk();
            final com.bytedance.sdk.openadsdk.ls.dl.z.g gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) io.z(strDc, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
            if (gVar != null && !TextUtils.isEmpty(naVar.po()) && naVar.dt().a() == 1) {
                return new com.bytedance.sdk.openadsdk.core.kb.z.a() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.g.g.1
                    @Override // com.ss.android.z.z.g.gz
                    public Map<String, Object> z(Map<String, Object> map) {
                        if (map != null) {
                            if (!z) {
                                map.put("is_button", Boolean.FALSE);
                            }
                            Object obj = map.get("is_button");
                            gVar.z(100, map);
                            g.z(map, obj, strAq, strMk);
                        } else {
                            v vVarZ = v.z();
                            Boolean bool = Boolean.FALSE;
                            vVarZ.z(bool, bool, "param is null", strAq, strMk);
                        }
                        return map;
                    }
                };
            }
            wp.z("dof", "bridge something invalid");
        }
        return null;
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("market") || str.startsWith("mimarket")) {
            return sy.ls();
        }
        return false;
    }

    public static boolean z(Uri uri, na naVar, Context context, String str, int i) {
        if (uy.ls().oq() == null || naVar == null) {
            return false;
        }
        z(str, naVar, (JSONObject) null, i);
        z(naVar, i, false);
        z(str, i);
        lq<String, Object> lqVarZ = new lq().z("hashCode", Integer.valueOf(i)).z(ContentProviderManager.PROVIDER_URI, uri);
        dl dlVar = new dl(context, naVar);
        dlVar.z(new com.bytedance.sdk.openadsdk.core.kb.dl.dl.gc());
        if (z(naVar, str, lqVarZ, dlVar)) {
            return true;
        }
        g(lqVarZ, naVar);
        return true;
    }

    private static boolean z(final na naVar, String str, final Map<String, Object> map, dl dlVar) {
        if (!dlVar.a(false)) {
            return false;
        }
        dlVar.z(str, new com.bytedance.sdk.openadsdk.core.kb.dl.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.g.g.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.g
            public void z() {
                g.g((Map<String, Object>) map, naVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Map<String, Object> map, na naVar) {
        fo.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.g.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (uy.ls().oq() != null) {
                    uy.ls().oq().apply(a.z().z(12).z(Boolean.class).z(0, map).g());
                }
            }
        }, naVar);
    }

    public static void z(Map<String, Object> map, Object obj, String str, String str2) {
        Object obj2 = map.get("convert_result");
        if (obj2 != null) {
            v.z().z(obj, obj2, "success", str, str2);
            return;
        }
        v vVarZ = v.z();
        Boolean bool = Boolean.FALSE;
        vVarZ.z(bool, bool, "no intercept result", str, str2);
    }

    public static void z(String str, int i) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(29).z(Void.class).z(0, new lq().z("clickButtonTag", str).z("clickItemTag", str).z("hashCode", Integer.valueOf(i)).z("clickStartLabel", "click_start").z("clickContinueLabel", "click_continue").z("clickPauseLabel", "click_pause").z("storageDenyLabel", "download_failed").z("clickInstallLabel", "click_install").z("isEnableClickEvent", Boolean.TRUE).z("isEnableV3Event", Boolean.FALSE)).g());
    }

    public static void z(String str, String str2, JSONObject jSONObject, int i) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null || jSONObject == null) {
            return;
        }
        functionOq.apply(a.z().z(29).z(Void.class).z(0, new lq().z("clickButtonTag", str).z("clickItemTag", str2).z("clickStartLabel", "click_start").z("clickContinueLabel", "click_continue").z("clickPauseLabel", "click_pause").z("storageDenyLabel", "download_failed").z("clickInstallLabel", "click_install").z("isEnableClickEvent", Boolean.TRUE).z("hashCode", Integer.valueOf(i)).z("isEnableV3Event", Boolean.FALSE).z("extraEventObject", jSONObject)).g());
    }

    public static void g(int i, int i2) {
        Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
        if (functionOq == null) {
            return;
        }
        functionOq.apply(a.z().z(30).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(i2)).z("downloadScene", Integer.valueOf(i))).g());
    }

    public static void z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.kb.z.g gVar) {
        if (gk.dl < 4400 || map == null || gVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(gVar));
    }
}
