package com.bytedance.adsdk.ugeno.bf;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mibi.sdk.component.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private float bf;
    private List<C0064e> d;
    private String e;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.bf.e$e, reason: collision with other inner class name */
    public static class C0064e {
        private float bf;
        private String d;
        private long e;
        private String ga;
        private float p;
        private long tg;
        private float[] v;
        private float vn;
        private String zk;

        public float bf() {
            return this.bf;
        }

        public String d() {
            return this.d;
        }

        public long e() {
            return this.e;
        }

        public float ga() {
            return this.vn;
        }

        public String getType() {
            return this.ga;
        }

        public float[] p() {
            return this.v;
        }

        public long tg() {
            return this.tg;
        }

        public float vn() {
            return this.p;
        }

        public void bf(long j) {
            this.tg = j;
        }

        public void d(float f) {
            this.p = f;
        }

        public void e(long j) {
            this.e = j;
        }

        public void bf(String str) {
            this.ga = str;
        }

        public void d(String str) {
            this.zk = str;
        }

        public void e(float f) {
            this.bf = f;
        }

        public void bf(float f) {
            this.vn = f;
        }

        public void e(String str) {
            this.d = str;
        }

        public void e(float[] fArr) {
            this.v = fArr;
        }

        public static C0064e e(JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.bf bfVar) {
            if (jSONObject == null) {
                return null;
            }
            C0064e c0064e = new C0064e();
            c0064e.e(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0064e.e(-1.0f);
            } else {
                try {
                    c0064e.e(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0064e.e(1.0f);
                }
            }
            c0064e.e(jSONObject.optString("loopMode"));
            c0064e.bf(jSONObject.optString("type"));
            if (TextUtils.equals(c0064e.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                String strE = com.bytedance.adsdk.ugeno.d.e.e(jSONObject.optString("valueTo"), bfVar.v());
                int iE = com.bytedance.adsdk.ugeno.tg.e.e(jSONObject.optString("valueFrom"));
                int iE2 = com.bytedance.adsdk.ugeno.tg.e.e(strE);
                c0064e.bf(iE);
                c0064e.d(iE2);
            } else {
                c0064e.bf((float) jSONObject.optDouble("valueFrom"));
                c0064e.d((float) jSONObject.optDouble("valueTo"));
            }
            c0064e.d(jSONObject.optString("interpolator"));
            String strE2 = com.bytedance.adsdk.ugeno.d.e.e(jSONObject.optString("startDelay"), bfVar.v());
            Log.d("TAG", "createAnimationModel: ");
            c0064e.bf(com.bytedance.adsdk.ugeno.tg.bf.e(strE2, 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Constants.KEY_RECHARGE_VALUES);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    fArr[i] = (float) jSONArrayOptJSONArray.optDouble(i);
                }
                c0064e.e(fArr);
            }
            return c0064e;
        }
    }

    public List<C0064e> bf() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(float f) {
        this.bf = f;
    }

    public void e(List<C0064e> list) {
        this.d = list;
    }

    public static e e(String str, com.bytedance.adsdk.ugeno.component.bf bfVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return e(new JSONObject(str), bfVar);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static e e(JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.bf bfVar) {
        return e(jSONObject, null, bfVar);
    }

    public static e e(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.component.bf bfVar) {
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        eVar.e(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            eVar.e(-1.0f);
        } else {
            eVar.e(com.bytedance.adsdk.ugeno.tg.bf.e(strOptString, -1.0f));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.tg.p.e(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0064e.e(jSONObjectOptJSONObject, bfVar));
            }
            eVar.e(arrayList);
        }
        return eVar;
    }
}
