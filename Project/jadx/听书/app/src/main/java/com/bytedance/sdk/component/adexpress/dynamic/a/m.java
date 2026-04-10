package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.a.gc;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.utils.wp;
import com.funny.audio.core.utils.FileUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static HashMap<String, String> e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f544a;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.dl dl;
    private JSONObject g;
    private dl gc;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.a m;
    private JSONObject z;

    static {
        HashMap<String, String> map = new HashMap<>();
        e = map;
        map.put(MediaFormat.KEY_SUBTITLE, "description");
        e.put("source", "source|app.app_name");
        e.put("screenshot", "dynamic_creative.screenshot");
    }

    public m(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.z = jSONObject;
        this.g = jSONObject2;
        this.dl = new com.bytedance.sdk.component.adexpress.dynamic.dl.dl(jSONObject2);
        this.f544a = z.z(jSONObject3);
        this.m = com.bytedance.sdk.component.adexpress.dynamic.dl.a.z(jSONObject4);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.dl.gz z(double d, int i, double d2, String str, i iVar) {
        JSONObject jSONObject;
        this.dl.z();
        try {
            jSONObject = new JSONObject(this.m.g);
        } catch (JSONException e2) {
            wp.z(e2);
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVarZ = z(a.z(this.z, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.dl.gz) null);
        z(gzVarZ);
        gc gcVar = new gc(d, i, d2, str, iVar);
        gc.z zVar = new gc.z();
        zVar.z = this.f544a.z;
        zVar.g = this.f544a.g;
        zVar.dl = 0.0f;
        gcVar.z(zVar);
        gcVar.z(gzVarZ, 0.0f, 0.0f);
        gcVar.z();
        if (gcVar.z.f552a == 65536.0f) {
            return null;
        }
        return gcVar.z.m;
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        int iZ;
        if (gzVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null) {
            iZ = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().pf();
        } else {
            iZ = com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext());
        }
        float fMin = this.f544a.dl ? this.f544a.z : Math.min(this.f544a.z, com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), iZ));
        if (this.f544a.g == 0.0f) {
            gzVar.gc(fMin);
            gzVar.uy().gc().uy("auto");
            gzVar.m(0.0f);
        } else {
            gzVar.gc(fMin);
            gzVar.m(this.f544a.dl ? this.f544a.g : Math.min(this.f544a.g, com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), com.bytedance.sdk.component.adexpress.a.gz.dl(com.bytedance.sdk.component.adexpress.a.getContext()))));
            gzVar.uy().gc().uy("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.dl.gz z(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.m != null) {
                dl dlVar = new dl();
                this.gc = dlVar;
                JSONObject jSONObjectZ = dlVar.z(this.m.z, iOptInt, jSONObject);
                if (jSONObjectZ != null) {
                    jSONObject = jSONObjectZ;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVarZ = z(jSONObject);
        gzVarZ.z(gzVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            gzVarZ.z((List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>) null);
            return gzVarZ;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = gzVarZ.uy().gc().nh();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVarZ2 = z(jSONArrayOptJSONArray2.optJSONObject(i2), gzVarZ);
                    if (com.bytedance.sdk.component.adexpress.a.z() && "skip-with-time".equals(gzVarZ.uy().getType()) && !"transparent".equals(gzVarZ.zw()) && !TextUtils.isEmpty(gzVarZ.zw())) {
                        gzVarZ2.dl(gzVarZ.zw());
                    }
                    arrayList.add(gzVarZ2);
                    arrayList3.add(gzVarZ2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            gzVarZ.z(arrayList);
        }
        if (arrayList2.size() > 0) {
            gzVarZ.g(arrayList2);
        }
        return gzVarZ;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.dl.gz z(JSONObject jSONObject) {
        String strZ;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        fo.z(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectZ = fo.z(strOptString, fo.z(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar = new com.bytedance.sdk.component.adexpress.dynamic.dl.gz();
        if (TextUtils.isEmpty(strOptString2)) {
            gzVar.g(String.valueOf(gzVar.hashCode()));
        } else {
            gzVar.g(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            g(gzVar);
            gzVar.dl((float) jSONObjectOptJSONObject.optDouble("x"));
            gzVar.a((float) jSONObjectOptJSONObject.optDouble("y"));
            gzVar.gc((float) jSONObjectOptJSONObject.optDouble(MediaFormat.KEY_WIDTH));
            gzVar.m((float) jSONObjectOptJSONObject.optDouble(MediaFormat.KEY_HEIGHT));
            gzVar.e(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.dl.gc gcVar = new com.bytedance.sdk.component.adexpress.dynamic.dl.gc();
            gcVar.z(strOptString);
            gcVar.g(jSONObjectOptJSONObject.optString("data"));
            gcVar.dl(jSONObjectOptJSONObject.optString("filterData"));
            gcVar.a(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarZ = com.bytedance.sdk.component.adexpress.dynamic.dl.m.z(jSONObjectOptJSONObject);
            gcVar.z(mVarZ);
            com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarZ2 = com.bytedance.sdk.component.adexpress.dynamic.dl.m.z(jSONObjectZ);
            if (mVarZ2 == null) {
                gcVar.g(mVarZ);
            } else {
                gcVar.g(mVarZ2);
            }
            z(mVarZ);
            z(mVarZ2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.g) != null) {
                z(gcVar, jSONObject2.optInt("image_mode"));
            }
            String type = gcVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gcVar.gc();
            if (e.containsKey(type) && !mVarGc.jq()) {
                mVarGc.tb(e.get(type));
            }
            if (mVarGc.jq()) {
                strZ = gcVar.g();
            } else {
                strZ = z(gcVar.g());
            }
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strZ = z("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strZ = z("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && mVarZ.xf()) {
                    strZ = z("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(z()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                gcVar.g(strZ + "adx:" + z());
            } else {
                gcVar.g(strZ);
            }
            gcVar.dl(z(gcVar.dl()));
            gzVar.z(gcVar);
        }
        return gzVar;
    }

    private void g(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        com.bytedance.sdk.component.adexpress.dynamic.dl.dl dlVar;
        Object objZ;
        Object objZ2;
        Object objZ3;
        Object objZ4;
        if (gzVar == null || (dlVar = this.dl) == null || (objZ = dlVar.z("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objZ);
        if (TextUtils.isEmpty(strValueOf) || (objZ2 = this.dl.z("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objZ2);
        if (TextUtils.isEmpty(strValueOf2) || (objZ3 = this.dl.z("description")) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objZ3);
        if (TextUtils.isEmpty(strValueOf3) || (objZ4 = this.dl.z("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objZ4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objZ5 = this.dl.z("app.app_name");
        Object objZ6 = this.dl.z("source");
        if (objZ5 == null && objZ6 == null) {
            return;
        }
        if (objZ5 == null) {
            objZ5 = objZ6;
        }
        String strValueOf5 = String.valueOf(objZ5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        gzVar.z("imageUrl", strValueOf);
        gzVar.z("title", strValueOf2);
        gzVar.z("description", strValueOf3);
        gzVar.z("icon", strValueOf4);
        gzVar.z(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, strValueOf5);
        gzVar.z(true);
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.gc gcVar, int i) {
        int iLastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            gcVar.z("video");
            String strZ = fo.z("video");
            gcVar.gc().tb(strZ);
            String strZ2 = fo.z("video", "clickArea");
            if (!TextUtils.isEmpty(strZ2)) {
                gcVar.gc().pf(strZ2);
                gcVar.e().pf(strZ2);
            }
            gcVar.e().tb(strZ);
            gcVar.g(strZ);
            gcVar.gc().kp();
            return;
        }
        gcVar.z("image");
        String strZ3 = fo.z("image");
        com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gcVar.gc();
        mVarGc.tb(strZ3);
        gcVar.e().tb(strZ3);
        String strZ4 = fo.z("image", "clickArea");
        if (!TextUtils.isEmpty(strZ4)) {
            mVarGc.pf(strZ4);
            gcVar.e().pf(strZ4);
        }
        JSONObject jSONObjectHy = mVarGc.hy();
        if (jSONObjectHy != null) {
            mVarGc.zw(jSONObjectHy.optString("imageLottieTosPath"));
            mVarGc.wp(jSONObjectHy.optBoolean("animationsLoop"));
            mVarGc.sy(jSONObjectHy.optInt("lottieAppNameMaxLength"));
            mVarGc.l(jSONObjectHy.optInt("lottieAdDescMaxLength"));
            mVarGc.hh(jSONObjectHy.optInt("lottieAdTitleMaxLength"));
        }
        gcVar.g(strZ3);
        if (strZ3 != null && (iLastIndexOf = strZ3.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) > 0) {
            String strSubstring = strZ3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MediaFormat.KEY_WIDTH, z(strSubstring + ".width"));
                jSONObject.put(MediaFormat.KEY_HEIGHT, z(strSubstring + ".height"));
            } catch (JSONException e2) {
                wp.z(e2);
            }
            gcVar.a(jSONObject.toString());
        }
        mVarGc.fp();
    }

    private String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.dl.g(str2)) {
                String strValueOf = String.valueOf(this.dl.z(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String z() {
        com.bytedance.sdk.component.adexpress.dynamic.dl.dl dlVar = this.dl;
        return dlVar == null ? "" : String.valueOf(dlVar.z("adx_name"));
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.m mVar) {
        if (mVar == null) {
            return;
        }
        String strH = mVar.h();
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            String strA = com.bytedance.sdk.component.adexpress.a.gz.a(com.bytedance.sdk.component.adexpress.a.getContext());
            if ("zh".equals(strA)) {
                strA = "cn";
            }
            if (!TextUtils.isEmpty(strA) && mVar.m() != null) {
                String strOptString = mVar.m().optString(strA);
                if (!TextUtils.isEmpty(strOptString)) {
                    strH = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strH)) {
            return;
        }
        int iIndexOf = strH.indexOf("{{");
        int iIndexOf2 = strH.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            mVar.wp(strH);
            return;
        }
        String strZ = z(strH.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strH.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strZ)) {
            sb.append(strZ);
        }
        sb.append(strH.substring(iIndexOf2 + 2));
        mVar.wp(sb.toString());
    }

    static class z {
        boolean dl;
        float g;
        float z;

        public static z z(JSONObject jSONObject) {
            z zVar = new z();
            if (jSONObject != null) {
                zVar.z = (float) jSONObject.optDouble(MediaFormat.KEY_WIDTH);
                zVar.g = (float) jSONObject.optDouble(MediaFormat.KEY_HEIGHT);
                zVar.dl = jSONObject.optBoolean("isLandscape");
            }
            return zVar;
        }
    }
}
