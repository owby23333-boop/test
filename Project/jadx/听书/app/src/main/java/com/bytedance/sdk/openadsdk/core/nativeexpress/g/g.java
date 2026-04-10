package com.bytedance.sdk.openadsdk.core.nativeexpress.g;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static JSONObject z(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediaFormat.KEY_WIDTH, f);
            jSONObject.put(MediaFormat.KEY_HEIGHT, f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public static JSONObject z(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = zw.getContext();
            jSONObject.put(MediaFormat.KEY_WIDTH, oq.a(context, width) * 1.0f);
            jSONObject.put(MediaFormat.KEY_HEIGHT, oq.a(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public static JSONObject z(na naVar) {
        nh nhVarE = vm.e(naVar);
        if (nhVarE == null) {
            return null;
        }
        String strA = nhVarE.a();
        try {
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(strA);
            }
            String strZ = com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.z().z(an.aw, nhVarE.z(), nhVarE.g());
            if (!TextUtils.isEmpty(strZ)) {
                return new JSONObject(strZ);
            }
            wp.a("TemplateUtils", "template is null");
            return null;
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public static JSONObject z(na naVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str) {
        JSONObject jSONObjectKv = naVar.kv();
        try {
            jSONObjectKv.put("xSetting", mc.z(naVar, (AtomicBoolean) null));
            jSONObjectKv.put("xAdInfo", z(naVar, str));
            JSONObject jSONObject3 = new JSONObject();
            mc.dl(jSONObject3);
            jSONObject3.put("platform", "android");
            jSONObjectKv.put("xAppInfo", jSONObject3);
            jSONObjectKv.put("xCreative", g(naVar));
            if (jSONObject2 != null) {
                jSONObjectKv.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObjectKv.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = zw.getContext();
            jSONObject5.put(MediaFormat.KEY_WIDTH, oq.a(context, oq.a(context)));
            jSONObject5.put(MediaFormat.KEY_HEIGHT, oq.a(context, oq.gc(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            jSONObjectKv.put("xEnvInfo", jSONObject4);
            jSONObjectKv.put("gesture_through_enable", z && zw.g().xo());
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObjectKv;
    }

    public static JSONObject z(na naVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strMj = naVar.mj();
            if (!TextUtils.isEmpty(strMj)) {
                jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, strMj);
            }
            String strVk = naVar.vk();
            if (!TextUtils.isEmpty(strVk)) {
                jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, strVk);
            }
            String strLs = eo.ls(naVar);
            if (!TextUtils.isEmpty(strLs)) {
                jSONObject.put("download_url", strLs);
            }
            jSONObject.put("isDirectDownload", naVar.pf());
            jSONObject.put("dynamic_configs", naVar.vj());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (js.kb(naVar)) {
                jSONObject.put("voice_btn_position", js.pf(naVar));
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject;
    }

    public static JSONObject z(float f, float f2, boolean z, na naVar) {
        String strGc;
        String strM;
        com.bytedance.sdk.component.adexpress.z.dl.g gVarZ;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (zw.g().mz()) {
                float f3 = zw.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put(MediaFormat.KEY_WIDTH, oq.g(f4, oq.z(f3, f)));
                jSONObject2.put(MediaFormat.KEY_HEIGHT, oq.g(f4, oq.z(f3, f2)));
            } else {
                jSONObject2.put(MediaFormat.KEY_WIDTH, f);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", g(naVar));
            if (vm.m(naVar) != null) {
                strGc = vm.m(naVar).gc();
                strM = vm.m(naVar).m();
            } else {
                strGc = null;
                strM = null;
            }
            if (TextUtils.isEmpty(strGc)) {
                strGc = (vm.m(naVar) == null || (gVarZ = com.bytedance.sdk.component.adexpress.z.g.g.z(vm.m(naVar).g())) == null) ? null : gVarZ.gc();
            }
            jSONObject.put("template_Plugin", strGc);
            jSONObject.put("diff_template_Plugin", strM);
            jSONObject.put("dynamic_configs", naVar.vj());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("keys");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject g(na naVar) {
        int[] iArrGc;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", naVar.no());
            if (naVar.kp() != null) {
                jSONObject.put("icon", naVar.kp().z());
            }
            JSONArray jSONArray = new JSONArray();
            if (naVar.jz() != null) {
                for (int i = 0; i < naVar.jz().size(); i++) {
                    gk gkVar = naVar.jz().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MediaFormat.KEY_HEIGHT, gkVar.dl());
                    jSONObject2.put(MediaFormat.KEY_WIDTH, gkVar.g());
                    jSONObject2.put("url", gkVar.z());
                    jSONObject2.put("image_key", gkVar.e());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", naVar.ou());
            jSONObject.put("interaction_type", naVar.lt());
            jSONObject.put("is_compliance_template", dl(naVar));
            jSONObject.put("title", naVar.li());
            jSONObject.put("description", naVar.he());
            jSONObject.put("source", naVar.hy());
            if (naVar.c() != null) {
                jSONObject.put("comment_num", naVar.c().m());
                jSONObject.put("score", naVar.c().gc());
                jSONObject.put("app_size", naVar.c().e());
                jSONObject.put("app", naVar.c().gz());
            }
            if (tf.v(naVar) != null) {
                JSONObject jSONObjectJs = tf.i(naVar).js();
                if (naVar.qz() > 0 && tf.m(naVar) > naVar.qz()) {
                    jSONObjectJs.put("video_duration", naVar.qz());
                }
                if (com.bytedance.sdk.openadsdk.gc.z.z(naVar) && (iArrGc = tf.gc(naVar)) != null && iArrGc.length >= 2 && !com.bytedance.sdk.openadsdk.gc.z.e(naVar)) {
                    jSONObjectJs.put("cover_width", iArrGc[0]);
                    jSONObjectJs.put("cover_height", iArrGc[1]);
                }
                jSONObject.put("video", jSONObjectJs);
            }
            if (gb.p(naVar)) {
                jSONObject.put("reward_full_play_time", gb.pf(naVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", gb.sy(naVar));
            if (vm.m(naVar) != null) {
                jSONObject.put("dynamic_creative", vm.m(naVar).e());
            }
            jSONObject.put("live_ad", m(naVar));
            z(naVar, jSONObject);
            if (com.bytedance.sdk.openadsdk.core.live.g.z().g(naVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", naVar.sa());
            jSONObject.put("can_show_interactive", naVar.cl());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject m(na naVar) {
        JSONObject jSONObject = new JSONObject();
        if (naVar != null && com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            try {
                jSONObject.put("live_show_time", com.bytedance.sdk.openadsdk.core.iq.eo.g(naVar));
                jSONObject.put("live_author_nickname", com.bytedance.sdk.openadsdk.core.iq.eo.dl(naVar));
                if (com.bytedance.sdk.openadsdk.core.iq.eo.a(naVar) > 0) {
                    jSONObject.put("live_author_follower_count", com.bytedance.sdk.openadsdk.core.iq.eo.a(naVar));
                }
                if (com.bytedance.sdk.openadsdk.core.iq.eo.gc(naVar) > 0) {
                    jSONObject.put("live_watch_count", com.bytedance.sdk.openadsdk.core.iq.eo.gc(naVar));
                }
                jSONObject.put("live_description", com.bytedance.sdk.openadsdk.core.iq.eo.m(naVar));
                jSONObject.put("live_feed_url", com.bytedance.sdk.openadsdk.core.iq.eo.e(naVar));
                jSONObject.put("live_cover_image_url", com.bytedance.sdk.openadsdk.core.iq.eo.gz(naVar));
                jSONObject.put("live_avatar_url", com.bytedance.sdk.openadsdk.core.iq.eo.fo(naVar));
                jSONObject.put("live_cover_image_width", com.bytedance.sdk.openadsdk.core.iq.eo.wp(naVar));
                jSONObject.put("live_cover_image_height", com.bytedance.sdk.openadsdk.core.iq.eo.i(naVar));
                jSONObject.put("live_avatar_width", com.bytedance.sdk.openadsdk.core.iq.eo.uy(naVar));
                jSONObject.put("live_avatar_height", com.bytedance.sdk.openadsdk.core.iq.eo.kb(naVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static void z(na naVar, JSONObject jSONObject) {
        if (eo.gz(naVar) == 7 && ec.z(naVar)) {
            naVar.ao().z(jSONObject);
        }
    }

    public static boolean dl(na naVar) {
        return naVar != null && tb.wp(naVar) == 2;
    }

    public static String a(na naVar) {
        if (vm.m(naVar) == null) {
            return null;
        }
        return vm.m(naVar).g();
    }

    public static String g(na naVar, String str) {
        List<gk> listJz;
        if (naVar != null && (listJz = naVar.jz()) != null && listJz.size() > 0) {
            for (gk gkVar : listJz) {
                if (gkVar != null && TextUtils.equals(str, gkVar.z())) {
                    return gkVar.e();
                }
            }
        }
        return null;
    }

    public static Map<String, String> gc(na naVar) {
        HashMap map = null;
        if (naVar == null) {
            return null;
        }
        List<gk> listJz = naVar.jz();
        if (listJz != null && listJz.size() > 0) {
            map = new HashMap();
            for (gk gkVar : listJz) {
                if (gkVar != null) {
                    map.put(gkVar.z(), gkVar.e());
                }
            }
        }
        return map;
    }
}
