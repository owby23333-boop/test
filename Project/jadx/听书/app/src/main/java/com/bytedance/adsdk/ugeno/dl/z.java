package com.bytedance.adsdk.ugeno.dl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f232a;
    private List<C0044z> dl;
    private float g;
    private long gc;
    private String m;
    private String z;

    public String z() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public void z(float f) {
        this.g = f;
    }

    public float g() {
        return this.g;
    }

    public List<C0044z> dl() {
        return this.dl;
    }

    public void z(List<C0044z> list) {
        this.dl = list;
    }

    public long a() {
        return this.f232a;
    }

    public void z(long j) {
        this.f232a = j;
    }

    public long gc() {
        return this.gc;
    }

    public void g(long j) {
        this.gc = j;
    }

    public String m() {
        return this.m;
    }

    public void g(String str) {
        this.m = str;
    }

    public static z z(String str, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z(new JSONObject(str), dlVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static z z(JSONObject jSONObject, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        return z(jSONObject, null, dlVar);
    }

    public static z z(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.z(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            zVar.z(-1.0f);
        } else {
            try {
                zVar.z(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                zVar.z(0.0f);
            }
        }
        zVar.z(jSONObject.optLong("duration", 0L));
        zVar.g(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("startDelay"), dlVar.uy()), 0L));
        zVar.g(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.m.g.z(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0044z.z(jSONObjectOptJSONObject, dlVar));
            }
            zVar.z(arrayList);
        }
        return zVar;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.dl.z$z, reason: collision with other inner class name */
    public static class C0044z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f233a;
        private String dl;
        private float e;
        private String fo;
        private float g;
        private String gc;
        private float[] gz;
        private float m;
        private String uy;
        private long z;

        public long z() {
            return this.z;
        }

        public void z(long j) {
            this.z = j;
        }

        public float g() {
            return this.g;
        }

        public void z(float f) {
            this.g = f;
        }

        public String dl() {
            return this.dl;
        }

        public void z(String str) {
            this.dl = str;
        }

        public long a() {
            return this.f233a;
        }

        public void g(long j) {
            this.f233a = j;
        }

        public String getType() {
            return this.gc;
        }

        public void g(String str) {
            this.gc = str;
        }

        public float gc() {
            return this.m;
        }

        public void g(float f) {
            this.m = f;
        }

        public float m() {
            return this.e;
        }

        public void dl(float f) {
            this.e = f;
        }

        public float[] e() {
            return this.gz;
        }

        public void z(float[] fArr) {
            this.gz = fArr;
        }

        public String gz() {
            return this.fo;
        }

        public String fo() {
            return this.uy;
        }

        public void dl(String str) {
            this.uy = str;
        }

        public void a(String str) {
            this.fo = str;
        }

        public static C0044z z(JSONObject jSONObject, com.bytedance.adsdk.ugeno.g.dl dlVar) {
            if (jSONObject == null) {
                return null;
            }
            C0044z c0044z = new C0044z();
            c0044z.z(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0044z.z(-1.0f);
            } else {
                try {
                    c0044z.z(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0044z.z(0.0f);
                }
            }
            c0044z.z(jSONObject.optString("loopMode"));
            c0044z.g(jSONObject.optString("type"));
            if (TextUtils.equals(c0044z.getType(), "ripple")) {
                c0044z.dl(jSONObject.optString("rippleColor"));
            }
            View viewFo = dlVar.fo();
            Context context = viewFo != null ? viewFo.getContext() : null;
            if (TextUtils.equals(c0044z.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("valueTo"), dlVar.uy());
                int iZ = com.bytedance.adsdk.ugeno.m.z.z(jSONObject.optString("valueFrom"));
                int iZ2 = com.bytedance.adsdk.ugeno.m.z.z(strZ);
                c0044z.g(iZ);
                c0044z.dl(iZ2);
            } else if ((TextUtils.equals(c0044z.getType(), "translateX") || TextUtils.equals(c0044z.getType(), "translateY")) && context != null) {
                try {
                    float fZ = com.bytedance.adsdk.ugeno.m.gz.z(context, (float) jSONObject.optDouble("valueFrom"));
                    float fZ2 = com.bytedance.adsdk.ugeno.m.gz.z(context, (float) jSONObject.optDouble("valueTo"));
                    c0044z.g(fZ);
                    c0044z.dl(fZ2);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.wp.a("animation", "animation ");
                }
            } else {
                c0044z.g((float) jSONObject.optDouble("valueFrom"));
                c0044z.dl((float) jSONObject.optDouble("valueTo"));
            }
            c0044z.a(jSONObject.optString("interpolator"));
            c0044z.g(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("startDelay"), dlVar.uy()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0044z.getType(), "translateX") || TextUtils.equals(c0044z.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.m.gz.z(context, (float) z.z(jSONArrayOptJSONArray.optString(i), dlVar.uy()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) z.z(jSONArrayOptJSONArray.optString(i), dlVar.uy());
                        i++;
                    }
                }
                c0044z.z(fArr);
            }
            return c0044z;
        }
    }

    public static double z(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
