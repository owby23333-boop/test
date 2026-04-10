package com.bytedance.msdk.core.admanager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.m.g.g;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.msdk.z.z.a;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f381a;
    private static final ArrayList<String> dl;
    private static final String[] g;
    private static final ArrayList<C0072z> z = new ArrayList<>();

    /* JADX INFO: renamed from: com.bytedance.msdk.core.admanager.z$z, reason: collision with other inner class name */
    private static class C0072z {
        String dl;
        int g;
        String z;

        C0072z(String str, int i, String str2) {
            this.z = str;
            this.g = i;
            this.dl = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.bykv", "com.qq", "com.kwad", "baidu", "mbridge", MediationConstant.ADN_SIGMOB, MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        g = strArr;
        dl = new ArrayList<>(Arrays.asList(strArr));
        f381a = new ArrayList<>();
    }

    public static boolean z(String str, int i, int i2) {
        ArrayList<C0072z> arrayList = z;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        for (C0072z c0072z : arrayList) {
            if (c0072z != null && TextUtils.equals(c0072z.z, str) && i2 == c0072z.g) {
                String str2 = c0072z.dl;
                a aVarZ = g.z().z(str);
                String strG = aVarZ != null ? aVarZ.g() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strG)) {
                    if (str2.startsWith("<=")) {
                        return z(strG, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return g(strG, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean z(String str, String str2) {
        return dl(str, str2) <= 0;
    }

    private static boolean g(String str, String str2) {
        return dl(str, str2) >= 0;
    }

    private static int dl(String str, String str2) {
        String strSubstring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        return str.compareTo(strSubstring);
    }

    public static void z(String str) {
        ArrayList<String> arrayList;
        List listAsList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                dl.clear();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("act_str");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            dl.add(strOptString);
                        }
                    }
                }
                f381a.clear();
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(strOptString2)) {
                            f381a.add(strOptString2);
                        }
                    }
                }
                z.clear();
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("not_support");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            z.add(new C0072z(jSONObjectOptJSONObject.optString("adn"), jSONObjectOptJSONObject.optInt("subtype"), jSONObjectOptJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = dl;
                listAsList = Arrays.asList(g);
            } catch (JSONException e) {
                wp.z(e);
                arrayList = dl;
                listAsList = Arrays.asList(g);
            }
            arrayList.addAll(listAsList);
        } catch (Throwable th) {
            dl.addAll(Arrays.asList(g));
            throw th;
        }
    }

    public static boolean g(String str) {
        dl.g("TTMediationSDK", "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = dl.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return dl(str);
            }
        }
        return false;
    }

    private static boolean dl(String str) {
        ArrayList<String> arrayList = f381a;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
