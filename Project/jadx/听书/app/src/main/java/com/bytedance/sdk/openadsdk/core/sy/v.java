package com.bytedance.sdk.openadsdk.core.sy;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1323a;
    private JSONObject dl;
    private static final ConcurrentHashMap<String, JSONObject> z = new ConcurrentHashMap<>();
    private static AtomicInteger g = new AtomicInteger();

    private static String z(int i, String str) {
        return i + "-" + tb.dl() + "-" + g.incrementAndGet() + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.get(str);
    }

    public static void z(int i, long j, na naVar, com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw;
        if (naVar == null || aVar == null || (gVarLw = naVar.lw()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectZ = z(gVarLw.a());
            if (jSONObjectZ != null) {
                String strP = aVar.p();
                String strOptString = jSONObjectZ.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(strP)) {
                    jSONObjectZ.put("play_type", i);
                    jSONObjectZ.put("cache_size", j);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static void z(long j, na naVar, com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw;
        if (naVar == null || aVar == null || (gVarLw = naVar.lw()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectZ = z(gVarLw.a());
            if (jSONObjectZ != null) {
                String strOptString = jSONObjectZ.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(aVar.p())) {
                    jSONObjectZ.put("play_duration", j);
                    jSONObjectZ.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private JSONObject g(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            na naVarZ = com.bytedance.sdk.openadsdk.core.video.a.g.z(aVar);
            if (naVarZ != null) {
                String strZ = eo.z(naVarZ, "");
                int i = !TextUtils.isEmpty(strZ) ? Integer.parseInt(strZ) : 0;
                int iGz = eo.gz(naVarZ);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.m.g.g.z());
                JSONObject jSONObjectZ = z();
                jSONObject.put("device", jSONObjectZ);
                JSONObject jSONObjectZ2 = z(aVar, i, iGz);
                jSONObject.put("current_video", jSONObjectZ2);
                jSONObject.put("predict_use", z(String.valueOf(i)));
                jSONObject.put("csj_plugin", g());
                jSONObject.put("package", g("video_cache"));
                jSONObject.put("hour", jSONObjectZ.optInt("hour"));
                jSONObject.put("video_size", aVar.wp());
                jSONObject.put("rit", i);
                jSONObject.put("preload_size", aVar.m());
                jSONObject.put(an.Q, jSONObjectZ.optString(an.Q));
                jSONObject.put("sdk_fg_time", jSONObjectZ.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", jSONObjectZ2.optInt("ad_slot_type"));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return jSONObject;
    }

    private JSONObject g(final String str) {
        dl dlVar = (dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya");
        if (dlVar != null) {
            dlVar.queryPackage(str, new gz() { // from class: com.bytedance.sdk.openadsdk.core.sy.v.1
                @Override // com.bytedance.sdk.openadsdk.core.sy.gz
                protected PluginValueSet g(int i, SparseArray<Object> sparseArray) {
                    if (sparseArray == null) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.ls.z zVar = new com.bytedance.sdk.openadsdk.ls.z(sparseArray);
                    PluginValueSet pluginValueSetA = zVar.a();
                    boolean z2 = zVar.z();
                    if (pluginValueSetA != null) {
                        if (TextUtils.equals(str, pluginValueSetA.stringValue(5))) {
                            if (z2) {
                                v.this.dl = (JSONObject) pluginValueSetA.objectValue(3, JSONObject.class);
                                new Object[]{v.this.dl};
                            } else {
                                v.this.f1323a = (JSONObject) pluginValueSetA.objectValue(4, JSONObject.class);
                            }
                        }
                    }
                    return super.g(i, sparseArray);
                }
            });
        } else {
            this.dl = new JSONObject();
        }
        return this.dl;
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(an.Q, com.bytedance.sdk.component.utils.v.e(zw.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.un.z.g;
            if (jCurrentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", jCurrentTimeMillis);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    private JSONObject z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_size", aVar.wp());
            jSONObject.put("preload_size", aVar.m());
            jSONObject.put("video_duration", aVar.uf().m());
            jSONObject.put("ad_slot_type", i2);
            jSONObject.put("rit", i);
            jSONObject.put("video_url", aVar.ls());
            jSONObject.put("preload_all", aVar.i());
            jSONObject.put("trace_id", z(i, aVar.p()));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public static void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, JSONObject jSONObject, int i, int i2) {
        int iOptInt;
        if (aVar == null || jSONObject == null || (iOptInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        z.put(String.valueOf(iOptInt), jSONObject);
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", gk.dl);
            jSONObject.put("core_plugin_code", 7105);
            jSONObject.put("ext_api_code", gk.gc);
            jSONObject.put("ext_plugin_code", un.g());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public JSONObject z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        return g(aVar);
    }
}
