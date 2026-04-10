package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.lw;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static volatile boolean z;

    public static void z(Context context, lw lwVar, na naVar, boolean z2, long j) {
        if (context == null || naVar == null || lwVar == null || !zw.g().lw()) {
            return;
        }
        boolean z3 = lwVar.a() == 1;
        boolean z4 = lwVar.gz() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", lwVar.z());
            jSONObject.put("server_load_type", lwVar.g());
            jSONObject.put("tmax_type", lwVar.mc());
            if (z2) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", lwVar.dl());
            jSONObject.put("splash_creative_type", lwVar.a());
            if (lwVar.zw() > 0) {
                if (lwVar.zw() == 22) {
                    jSONObject.put("check_cloud_error_code", lwVar.l());
                }
                jSONObject.put("splash_get_cache_error_code", lwVar.zw());
            }
            if (z3) {
                if (z4) {
                    jSONObject.put("cache_image_duration", lwVar.e());
                } else {
                    jSONObject.put("download_image_duration", lwVar.m());
                    jSONObject.put("download_client_start_time", lwVar.ls());
                    jSONObject.put("download_net_time", lwVar.p());
                    jSONObject.put("download_client_end_time", lwVar.fv());
                    jSONObject.put("img_conttype", lwVar.hh());
                    jSONObject.put("img_net_bframe_time", lwVar.h());
                    jSONObject.put("img_net_aframe_time", lwVar.gk());
                }
                if (!z2) {
                    jSONObject.put("client_start_time", lwVar.wp());
                    jSONObject.put("network_time", lwVar.i());
                    jSONObject.put("sever_time", lwVar.v());
                    jSONObject.put("client_end_time", lwVar.pf());
                }
                jSONObject.put("load_duration", lwVar.gc());
                jSONObject.put("image_resolution", lwVar.uy());
                jSONObject.put("image_cachetype", lwVar.gz());
                jSONObject.put("image_size", lwVar.fo());
            }
            if (lwVar.io() > 0) {
                jSONObject.put("real_user_duration", j - lwVar.io());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", lwVar.uf());
            jSONObject.put("on_call_back_time", lwVar.sy());
            jSONObject.put("load_suc_time", lwVar.x());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.a.z.a());
        } catch (Exception e) {
            wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "splash_ad", "splash_ad_loadtime", j - lwVar.tb(), jSONObject);
    }

    public static void z(lw lwVar) {
        if (lwVar == null) {
            return;
        }
        lwVar.z(System.currentTimeMillis() - lwVar.tb());
    }

    public static void z(lw lwVar, lw lwVar2) {
        if (lwVar == null || lwVar2 == null) {
            return;
        }
        lwVar.wp(System.currentTimeMillis());
        lwVar2.wp(System.currentTimeMillis());
        if (q.dl.get()) {
            lwVar.dl(0);
            lwVar2.dl(0);
            q.dl.set(false);
        } else {
            lwVar.dl(1);
            lwVar2.dl(1);
        }
    }

    public static void z(lw lwVar, long j) {
        if (lwVar == null) {
            return;
        }
        lwVar.g(j);
    }

    public static void g(lw lwVar, long j) {
        if (lwVar == null) {
            return;
        }
        lwVar.dl(j);
    }

    public static void z(lw lwVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
        if (lwVar == null || gzVar == null) {
            return;
        }
        if (gzVar.gc()) {
            lwVar.a(2);
        } else {
            lwVar.a(1);
        }
    }

    public static void z(lw lwVar, boolean z2) {
        if (lwVar == null) {
            return;
        }
        if (z2) {
            lwVar.gc(1);
        } else {
            lwVar.gc(2);
        }
    }

    public static void z(lw lwVar, com.bytedance.sdk.openadsdk.core.io.z.g gVar, Map<String, String> map) {
        if (gVar == null || lwVar == null) {
            return;
        }
        int iG = gVar.g();
        if (lwVar.fo() == 0.0d) {
            lwVar.z(iG / 1024.0f);
        }
        Bitmap bitmapZ = gVar.z();
        if (bitmapZ != null && TextUtils.isEmpty(lwVar.uy())) {
            lwVar.z(bitmapZ.getWidth() + "X" + bitmapZ.getHeight());
        }
        if (map == null || map.size() <= 0 || lwVar.kb() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        lwVar.z(jSONObject);
    }

    public static void z(lw lwVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
        if (lwVar == null || mVar == null) {
            return;
        }
        long jM = mVar.m();
        long jGz = mVar.gz();
        long jE = mVar.e();
        long jFo = mVar.fo();
        lwVar.a(jM);
        lwVar.gc(jE);
        lwVar.m(jGz);
        lwVar.e(jFo);
    }

    public static void z(na naVar, lw lwVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
        if (naVar == null || lwVar == null || gzVar == null || gzVar.gc() || lwVar.gz() == 1 || !zw.g().lw()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", lwVar.fo());
            jSONObject.put("image_resolution", lwVar.uy());
            jSONObject.put("download_client_start_time", lwVar.ls());
            jSONObject.put("download_net_time", lwVar.p());
            jSONObject.put("download_client_end_time", lwVar.fv());
        } catch (Exception e) {
            wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - lwVar.js(), jSONObject);
    }

    public static void dl(lw lwVar, long j) {
        if (lwVar == null) {
            return;
        }
        lwVar.kb(j);
    }

    public static void z(lw lwVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, long j) {
        if (lwVar == null || gzVar == null) {
            return;
        }
        long jE = gzVar.e();
        lwVar.uy(j - jE);
        lwVar.tb(gzVar.gz() - jE);
    }

    public static void z(boolean z2, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
        if (gVar == null || eVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = z(gVar, z2 ? 4 : 3, naVar);
        if (gVarZ == null) {
            return;
        }
        v.z().dl(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.m.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                int iE;
                int iA;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar2 = eVar;
                if (eVar2 != null) {
                    iE = eVar2.e();
                    iA = eVar.a();
                } else {
                    iE = 1;
                    iA = -1;
                }
                try {
                    jSONObject.put("if_have_cache", iE);
                    jSONObject.put("if_have_rt_ads", iA);
                } catch (Throwable unused) {
                }
                return gVarZ.g(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.q.z.g z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i, na naVar) {
        String strMj;
        String strGz;
        String strVk;
        if (naVar != null) {
            strMj = naVar.mj();
            strVk = naVar.vk();
            strGz = eo.i(naVar);
        } else {
            strMj = null;
            strGz = null;
            strVk = null;
        }
        if (TextUtils.isEmpty(strGz)) {
            strGz = eo.gz();
        }
        com.bytedance.sdk.openadsdk.core.q.z.g gVarDl = com.bytedance.sdk.openadsdk.core.q.z.g.g().m(strGz).z(i).dl(gVar.a());
        if (strMj != null) {
            gVarDl.a(strMj);
        }
        if (strVk != null) {
            gVarDl.gz(strVk);
        }
        return gVarDl;
    }

    public static void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final long j) {
        if (gVar == null) {
            return;
        }
        v.z().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.m.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(3).dl(gVar.a()).m(eo.gz()).g(jSONObject.toString());
            }
        });
    }

    public static void z(lw lwVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, long j, na naVar) {
        if (gzVar == null || lwVar == null || naVar == null) {
            return;
        }
        if (!gzVar.gc()) {
            e.z(j, false, true, naVar, 0L, "loadSuccess");
            if (!gzVar.m()) {
                z(lwVar, SystemClock.elapsedRealtime() - j);
                com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "splash_ad", SystemClock.elapsedRealtime() - j);
            } else {
                g(lwVar, SystemClock.elapsedRealtime() - j);
            }
        }
        z(lwVar, gzVar.m());
        z(lwVar, gzVar.a(), gzVar.fo());
        z(lwVar, gzVar, System.currentTimeMillis());
        z(lwVar, gzVar.i());
    }

    public static void z(lw lwVar, String str) {
        if (lwVar == null) {
            return;
        }
        lwVar.g(str);
    }

    public static void z(boolean z2, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final boolean z3, final boolean z4) {
        if (naVar == null || gVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = z(gVar, z2 ? 4 : 3, naVar);
        if (gVarZ == null) {
            return;
        }
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.m.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z4) {
                        jSONObject.put("image_CacheType", z3 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return gVarZ.g(jSONObject.toString());
            }
        });
    }

    public static void z(boolean z2, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (naVar == null || gVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = z(gVar, z2 ? 4 : 3, naVar);
        if (gVarZ == null) {
            return;
        }
        v.z().a(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.m.4
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return gVarZ;
            }
        });
    }

    public static void z(na naVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a aVar) {
        if (aVar == null || naVar == null || !zw.g().lw()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", aVar.z());
            jSONObject.put("render_sequence", aVar.g());
            jSONObject.put("real_render_sequence", aVar.dl());
        } catch (Exception e) {
            wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.g(naVar, "splash_ad", "splash_render_duration", aVar.m(), jSONObject);
    }

    public static void g(na naVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a aVar) {
        if (naVar == null || aVar == null || !zw.g().lw()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", aVar.a());
            jSONObject.put("load_resource_duration", aVar.gc());
            jSONObject.put("render_duration", aVar.m());
            jSONObject.put("ren_seq", aVar.g());
            jSONObject.put("real_ren_seq", aVar.dl());
            jSONObject.put("final_t", aVar.gz() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", aVar.fo());
            jSONObject.put("meta_load_Optimization", naVar.sf());
            jSONObject.put("serial_render", aVar.uy());
        } catch (Exception e) {
            wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.dl(naVar, "splash_ad", "splash_total_duration", aVar.e(), jSONObject);
    }

    public static void z(na naVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a aVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar) {
        if (naVar == null || foVar == null) {
            return;
        }
        if (vm.z(naVar) == 1) {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "自渲染 ");
            aVar.dl(99);
        } else if (!foVar.g()) {
            int iG = vm.g(naVar);
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "模版渲染 ".concat(String.valueOf(iG)));
            aVar.dl(iG);
        } else {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "模版兜底 ");
            aVar.dl(99);
        }
    }

    public static void a(lw lwVar, long j) {
        if (lwVar != null) {
            lwVar.ls(System.currentTimeMillis() - j);
        }
    }

    public static void z(lw lwVar, lw lwVar2, j jVar, int i, int i2) {
        if (lwVar == null || lwVar2 == null) {
            return;
        }
        lwVar.z(i);
        lwVar.g(i2);
        lwVar.pf(jVar.gz);
        lwVar2.z(i);
        lwVar2.g(i2);
        lwVar2.pf(jVar.gz);
    }

    public static void z(lw lwVar, int i) {
        if (lwVar == null || lwVar.mc() >= i) {
            return;
        }
        lwVar.e(i);
    }

    public static void z(int i, na naVar, String str, int i2) {
        if (i == 2) {
            if (z) {
                return;
            } else {
                z = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.bytedance.sdk.openadsdk.core.i.a.dl(naVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}
