package com.bytedance.hume.readapk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HumeSDK {
    public static final String TAG = "HumeSDK";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f2076a = 1903654776;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f2077b = -1721342362;
    private static final int c = 1903654775;
    private static String[] d = new String[3];
    private static volatile boolean e = false;

    private static String a(Context context) throws Throwable {
        if (!e) {
            c(context);
            e = true;
        }
        return !TextUtils.isEmpty(d[0]) ? d[0] : !TextUtils.isEmpty(d[1]) ? d[1] : "";
    }

    private static Map<String, String> b(Context context) throws Throwable {
        if (!e) {
            c(context);
            e = true;
        }
        Map<String, String> mapA = a(d[2]);
        return mapA == null ? new HashMap() : mapA;
    }

    private static void c(Context context) throws Throwable {
        int[] iArr = {f2077b, c, f2076a};
        String strD = d(context);
        if (TextUtils.isEmpty(strD)) {
            d = new String[]{"", "", ""};
        }
        File file = new File(strD);
        String[] strArrA = d.a(file, iArr);
        if (strArrA == null) {
            strArrA = d;
        }
        d = strArrA;
        if (strArrA.length >= 2 && TextUtils.isEmpty(strArrA[0]) && TextUtils.isEmpty(d[1])) {
            String strA = com.bytedance.hume.readapk.a.a.a(file);
            String[] strArr = d;
            if (strA == null) {
                strA = "";
            }
            strArr[0] = strA;
        }
        String[] strArr2 = d;
        if (strArr2.length < 3 || TextUtils.isEmpty(strArr2[2])) {
            return;
        }
        int length = d[2].length();
        if (length <= 4) {
            d[2] = "";
        } else {
            String[] strArr3 = d;
            strArr3[2] = strArr3[2].substring(2, length - 2);
        }
    }

    private static String d(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getChannel(Context context) throws Throwable {
        if (!e) {
            c(context);
            e = true;
        }
        Map<String, String> mapA = a(a(context));
        return (mapA == null || mapA.size() <= 0) ? "" : mapA.get("hume_channel_id");
    }

    public static String getVersion() {
        return "1.0.0";
    }

    private static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                map.put(string, jSONObject.getString(string));
            }
            return map;
        } catch (JSONException | Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
