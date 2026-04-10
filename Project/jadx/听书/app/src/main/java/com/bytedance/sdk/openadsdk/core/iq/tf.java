package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tf {
    private com.bykv.vk.openvk.component.video.api.dl.z dl;
    private com.bykv.vk.openvk.component.video.api.dl.dl g;
    private com.bykv.vk.openvk.component.video.api.dl.dl z;

    public tf() {
    }

    public tf(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        tf tfVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.dl.dl dlVar = new com.bykv.vk.openvk.component.video.api.dl.dl();
            dlVar.g(jSONObjectOptJSONObject.optInt("cover_height"));
            dlVar.dl(jSONObjectOptJSONObject.optInt("cover_width"));
            dlVar.z(jSONObjectOptJSONObject.optString(an.z));
            str2 = an.z;
            str3 = "cover_width";
            dlVar.z(jSONObjectOptJSONObject.optLong("size"));
            dlVar.z(jSONObjectOptJSONObject.optDouble("video_duration"));
            dlVar.g(jSONObjectOptJSONObject.optString("cover_url"));
            dlVar.dl(jSONObjectOptJSONObject.optString("video_url"));
            dlVar.a(jSONObjectOptJSONObject.optString("endcard"));
            dlVar.gc(jSONObjectOptJSONObject.optString("file_hash"));
            str = "file_hash";
            dlVar.z((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            dlVar.z(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            dlVar.a(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            dlVar.gc(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            dlVar.m(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            dlVar.g(jSONObjectOptJSONObject.optDouble(TtmlNode.START, -1.0d));
            tfVar = this;
            str4 = "size";
            tfVar.z = dlVar;
        } else {
            str = "file_hash";
            str2 = an.z;
            str3 = "cover_width";
            str4 = "size";
            tfVar = this;
        }
        String str5 = str;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.dl.dl dlVar2 = new com.bykv.vk.openvk.component.video.api.dl.dl();
            dlVar2.g(jSONObjectOptJSONObject2.optInt("cover_height"));
            dlVar2.dl(jSONObjectOptJSONObject2.optInt(str3));
            dlVar2.z(jSONObjectOptJSONObject2.optString(str2));
            dlVar2.z(jSONObjectOptJSONObject2.optLong(str4));
            dlVar2.z(jSONObjectOptJSONObject2.optDouble("video_duration"));
            dlVar2.g(jSONObjectOptJSONObject2.optString("cover_url"));
            dlVar2.dl(jSONObjectOptJSONObject2.optString("video_url"));
            dlVar2.a(jSONObjectOptJSONObject2.optString("endcard"));
            dlVar2.gc(jSONObjectOptJSONObject2.optString(str5));
            dlVar2.z((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            dlVar2.z(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            dlVar2.a(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            dlVar2.gc(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            dlVar2.m(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            dlVar2.g(jSONObjectOptJSONObject2.optDouble(TtmlNode.START, -1.0d));
            tfVar.g = dlVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("audio");
        if (jSONObjectOptJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.dl.z zVar = new com.bykv.vk.openvk.component.video.api.dl.z();
            zVar.g(jSONObjectOptJSONObject3.optString("audio_url"));
            zVar.z(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            zVar.g(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            zVar.z(jSONObjectOptJSONObject3.optLong(str4, -2147483648L));
            zVar.z(jSONObjectOptJSONObject3.optString(str5));
            zVar.g(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            zVar.z(jSONObjectOptJSONObject3.optDouble(TtmlNode.START, -1.0d));
            zVar.g(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            tfVar.dl = zVar;
        }
    }

    public void z(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.dl.dl dlVar = this.z;
            if (dlVar != null) {
                jSONObject.put("video", dlVar.js());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            com.bykv.vk.openvk.component.video.api.dl.dl dlVar2 = this.g;
            if (dlVar2 != null) {
                jSONObject.put("h265_video", dlVar2.js());
            }
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        try {
            com.bykv.vk.openvk.component.video.api.dl.z zVar = this.dl;
            if (zVar != null) {
                jSONObject.put("audio", zVar.z());
            }
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
        }
    }

    public void z(com.bykv.vk.openvk.component.video.api.dl.dl dlVar) {
        this.z = dlVar;
    }

    public static String z(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            return eo.e(naVar);
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            return ls(naVar).gc();
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = tfVarFv.z;
        return dlVar == null ? "" : dlVar.wp();
    }

    public static String g(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            return eo.gz(naVar);
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = tfVarFv.z;
        return dlVar == null ? "" : dlVar.kb();
    }

    public static int dl(na naVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar;
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null || (dlVar = tfVarFv.z) == null) {
            return 0;
        }
        return dlVar.g();
    }

    public static int a(na naVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar;
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null || (dlVar = tfVarFv.z) == null) {
            return 0;
        }
        return dlVar.dl();
    }

    public static int[] gc(na naVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarPf;
        if (naVar == null) {
            return null;
        }
        if (naVar.ou() == 166 && eo.z(naVar)) {
            return new int[]{eo.wp(naVar), eo.i(naVar)};
        }
        if (naVar.su() == 1 && naVar.te() == 1 && (dlVarPf = pf(naVar)) != null) {
            return dlVarPf.uy();
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = v(naVar);
        if (dlVarV != null) {
            return dlVarV.uy();
        }
        return null;
    }

    public static double m(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            int iG = eo.g(naVar);
            com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = naVar.lw();
            if (gVarLw != null && gVarLw.tb() == 9) {
                iG *= 2;
            }
            return iG;
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            return ((int) ls(naVar).m()) * (ls(naVar).e() + 1);
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = tfVarFv.z;
        if (dlVar == null) {
            return 0.0d;
        }
        return dlVar.m();
    }

    public static String e(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            return com.bykv.vk.openvk.component.video.api.m.g.z(eo.e(naVar));
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            return ls(naVar).g();
        }
        return tfVarFv.z.pf();
    }

    public static String gz(na naVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar;
        tf tfVarFv = fv(naVar);
        return (tfVarFv == null || (dlVar = tfVarFv.z) == null) ? "" : dlVar.i();
    }

    public static int fo(na naVar) {
        if (fv(naVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(z(naVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(g(naVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static boolean uy(na naVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar;
        tf tfVarFv = fv(naVar);
        return (tfVarFv == null || (dlVar = tfVarFv.z) == null || dlVar.z() != 1) ? false : true;
    }

    public static boolean kb(na naVar) {
        tf tfVarFv = fv(naVar);
        return (tfVarFv == null || tfVarFv.dl == null) ? false : true;
    }

    public static boolean wp(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return false;
        }
        return tfVarFv.z.iq();
    }

    public static com.bykv.vk.openvk.component.video.api.dl.dl z(na naVar, int i) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = new com.bykv.vk.openvk.component.video.api.dl.dl();
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar2 = tfVarFv.z;
        if (dlVar2 != null) {
            dlVar.g(dlVar2.g());
            dlVar.dl(tfVarFv.z.dl());
            dlVar.z(tfVarFv.z.fo());
            dlVar.z(tfVarFv.z.gc());
            dlVar.z(tfVarFv.z.m());
            dlVar.g(tfVarFv.z.kb());
            dlVar.dl(tfVarFv.z.wp());
            dlVar.a(tfVarFv.z.i());
            dlVar.gc(tfVarFv.z.pf());
            dlVar.z(tfVarFv.z.z());
            dlVar.a(tfVarFv.z.ls());
            dlVar.gc(tfVarFv.z.p());
            dlVar.m(tfVarFv.z.fv());
            dlVar.z(tfVarFv.z.gz());
            dlVar.g(tfVarFv.z.e());
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            dlVar.g(eo.gz(naVar));
            dlVar.dl(eo.e(naVar));
            dlVar.gc(com.bykv.vk.openvk.component.video.api.m.g.z(eo.e(naVar)));
            dlVar.z(-1L);
            dlVar.z(eo.g(naVar));
            dlVar.a(0);
            dlVar.gc(1);
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            dlVar.dl(tfVarFv.dl.gc());
            dlVar.gc(0);
            dlVar.a(0);
            dlVar.gc(tfVarFv.dl.g());
            dlVar.z(tfVarFv.dl.dl());
            dlVar.g(tfVarFv.dl.a());
            dlVar.z(tfVarFv.dl.m() * ((double) (tfVarFv.dl.e() + 1)));
        }
        return dlVar;
    }

    public static com.bykv.vk.openvk.component.video.api.dl.dl i(na naVar) {
        return z(naVar, 0);
    }

    public static com.bykv.vk.openvk.component.video.api.dl.dl v(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = tfVarFv.z;
        if (dlVar != null) {
            return dlVar;
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar) && vm.g(naVar) == 3) {
            return dlVar;
        }
        if (!com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            return tfVarFv.z;
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar2 = new com.bykv.vk.openvk.component.video.api.dl.dl();
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            dlVar2.dl(tfVarFv.dl.gc());
            dlVar2.gc(0);
            dlVar2.a(0);
            dlVar2.gc(tfVarFv.dl.g());
            dlVar2.z(tfVarFv.dl.dl());
            dlVar2.z(tfVarFv.dl.m() * ((double) (tfVarFv.dl.e() + 1)));
        }
        tfVarFv.z = dlVar2;
        return dlVar2;
    }

    public static com.bykv.vk.openvk.component.video.api.dl.dl pf(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return null;
        }
        return tfVarFv.g;
    }

    public static com.bykv.vk.openvk.component.video.api.dl.z ls(na naVar) {
        tf tfVarFv = fv(naVar);
        if (tfVarFv == null) {
            return null;
        }
        return tfVarFv.dl;
    }

    public static com.bykv.vk.openvk.component.video.api.dl.a z(int i, na naVar, int i2) {
        String strZ;
        if (naVar.su() == 1 && !com.bytedance.sdk.openadsdk.core.gk.a()) {
            naVar.ec(0);
        }
        if (com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
            naVar.ec(0);
        }
        if (i == 1) {
            strZ = com.bytedance.sdk.openadsdk.hh.fo.z(naVar.su()).z();
        } else if (i == 2) {
            strZ = com.bytedance.sdk.openadsdk.hh.fo.z(naVar.su()).g();
        } else if (i == 3) {
            strZ = com.bytedance.sdk.openadsdk.hh.fo.z(naVar.su()).dl();
        } else {
            strZ = i != 4 ? "" : com.bytedance.sdk.openadsdk.hh.fo.z(naVar.su()).a();
        }
        com.bykv.vk.openvk.component.video.api.dl.a aVar = new com.bykv.vk.openvk.component.video.api.dl.a(strZ, z(naVar, i2), pf(naVar), naVar.su(), naVar.te());
        aVar.z(naVar.d());
        return aVar;
    }

    public static com.bykv.vk.openvk.component.video.api.dl.a z(int i, na naVar) {
        return z(i, naVar, 0);
    }

    public static com.bykv.vk.openvk.component.video.api.dl.a p(na naVar) {
        tf tfVarZd;
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = z(4, naVar);
        aVarZ.z(true);
        if (naVar != null && (tfVarZd = naVar.zd()) != null) {
            com.bykv.vk.openvk.component.video.api.dl.dl dlVarUf = aVarZ.uf();
            com.bykv.vk.openvk.component.video.api.dl.z zVar = tfVarZd.dl;
            if (zVar != null && dlVarUf != null) {
                dlVarUf.dl(zVar.gc());
                dlVarUf.gc(0);
                dlVarUf.a(0);
                dlVarUf.gc(tfVarZd.dl.g());
                dlVarUf.z(tfVarZd.dl.dl());
                dlVarUf.g(tfVarZd.dl.a());
                dlVarUf.z(tfVarZd.dl.m() * ((double) (tfVarZd.dl.e() + 1)));
            }
        }
        return aVarZ;
    }

    private static tf fv(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.zd();
    }
}
