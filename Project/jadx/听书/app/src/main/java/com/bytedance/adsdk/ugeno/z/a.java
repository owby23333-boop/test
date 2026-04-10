package com.bytedance.adsdk.ugeno.z;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.adsdk.ugeno.z.dl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int z(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return i - 1;
    }

    public static List<dl> z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(z(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static dl z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        dl dlVar = new dl();
        dlVar.g(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("delay"), jSONObject2), 0L));
        dlVar.dl(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("name"), jSONObject2));
        dlVar.g(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("playState"), jSONObject2), 1));
        dlVar.z(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("duration"), jSONObject2), 0L));
        dlVar.z(com.bytedance.adsdk.ugeno.m.dl.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("playCount"), jSONObject2), 1));
        dlVar.z(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("playDirection"), jSONObject2));
        dlVar.z(a(jSONObject.optString("transformOrigin")));
        dlVar.g(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        dlVar.z(jSONObject.optJSONObject("effect"));
        dlVar.z(z(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return dlVar;
    }

    public static Map<String, TreeMap<Float, String>> z(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble(TypedValues.Cycle.S_WAVE_OFFSET);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, TypedValues.Cycle.S_WAVE_OFFSET)) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.a.g.z(jSONObjectOptJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.a.g.z(jSONObjectOptJSONObject.optString(next), jSONObject));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int z(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1408024454(0xffffffffac13407a, float:-2.0925748E-12)
            r2 = 1
            if (r0 == r1) goto L1a
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r0 == r1) goto L10
            goto L24
        L10:
            java.lang.String r0 = "normal"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L24
            r3 = r2
            goto L25
        L1a:
            java.lang.String r0 = "alternate"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L24
            r3 = 0
            goto L25
        L24:
            r3 = -1
        L25:
            if (r3 == 0) goto L28
            return r2
        L28:
            r3 = 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.z.a.z(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.animation.Interpolator g(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case -1965072618: goto L28;
                case -1102672091: goto L1e;
                case -787702915: goto L14;
                case 1065009829: goto La;
                default: goto L9;
            }
        L9:
            goto L32
        La:
            java.lang.String r0 = "ease_in_out"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = r2
            goto L33
        L14:
            java.lang.String r0 = "ease_out"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = r1
            goto L33
        L1e:
            java.lang.String r0 = "linear"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 3
            goto L33
        L28:
            java.lang.String r0 = "ease_in"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 0
            goto L33
        L32:
            r3 = -1
        L33:
            if (r3 == 0) goto L4b
            if (r3 == r2) goto L45
            if (r3 == r1) goto L3f
            android.view.animation.LinearInterpolator r3 = new android.view.animation.LinearInterpolator
            r3.<init>()
            return r3
        L3f:
            android.view.animation.DecelerateInterpolator r3 = new android.view.animation.DecelerateInterpolator
            r3.<init>()
            return r3
        L45:
            android.view.animation.AccelerateDecelerateInterpolator r3 = new android.view.animation.AccelerateDecelerateInterpolator
            r3.<init>()
            return r3
        L4b:
            android.view.animation.AccelerateInterpolator r3 = new android.view.animation.AccelerateInterpolator
            r3.<init>()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.z.a.g(java.lang.String):android.view.animation.Interpolator");
    }

    public static float[] dl(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayZ = com.bytedance.adsdk.ugeno.m.g.z(str, (JSONArray) null);
        if (jSONArrayZ != null && jSONArrayZ.length() == 2) {
            fArr[0] = (float) jSONArrayZ.optDouble(0);
            fArr[1] = (float) jSONArrayZ.optDouble(1);
        }
        return fArr;
    }

    public static dl.z a(String str) {
        JSONArray jSONArrayZ;
        if (TextUtils.isEmpty(str) || (jSONArrayZ = com.bytedance.adsdk.ugeno.m.g.z(str, (JSONArray) null)) == null || jSONArrayZ.length() != 2) {
            return null;
        }
        dl.z zVar = new dl.z();
        zVar.z = jSONArrayZ.optString(0);
        zVar.g = jSONArrayZ.optString(1);
        return zVar;
    }

    public static int z(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}
