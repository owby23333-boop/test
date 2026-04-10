package com.yuewen;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.rf4;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class ig4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12478a = "com.yuewen.ig4";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<Integer, String> f12479b;

    static {
        HashMap map = new HashMap();
        f12479b = map;
        map.put(0, "OK");
        f12479b.put(1, "Client parameter error");
        f12479b.put(2, "Common error");
    }

    public static String a(String str, String str2, int i, Object obj) {
        return b(str, str2, i, obj, f12479b.get(Integer.valueOf(i)));
    }

    public static String b(String str, String str2, int i, Object obj, String str3) {
        Log.d(f12478a, "buildCallbackResult");
        StringBuilder sb = new StringBuilder();
        sb.append("window['com.duokan.fiction.handleMessage']");
        sb.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            if (TextUtils.isEmpty(str3)) {
                str3 = f12479b.get(Integer.valueOf(i));
            }
            jSONObject.put("message", str3);
            jSONObject.put("data", obj);
            jSONObject.put("type", str2);
            jSONObject.put("msgid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sb.append(jSONObject.toString());
        sb.append(")");
        return sb.toString();
    }

    public static String c(String str, String str2, int i, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("window['com.duokan.fiction.handleMessage']");
        sb.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", f12479b.get(Integer.valueOf(i)));
            jSONObject.put(rf4.a.d, str3);
            jSONObject.put("type", str2);
            jSONObject.put("msgid", str);
        } catch (Throwable unused) {
        }
        sb.append(jSONObject.toString());
        sb.append(")");
        return sb.toString();
    }

    public static String d(String str, int i, Object obj) {
        Log.d(f12478a, "buildProviderCallbackResult");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", f12479b.get(Integer.valueOf(i)));
            jSONObject.put("data", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sb.append(jSONObject.toString());
        sb.append(")");
        return sb.toString();
    }

    public static Pair<String, String> e(Uri uri) {
        if (uri == null) {
            return null;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        String str = pathSegments.get(pathSegments.size() - 2);
        String strDecode = URLDecoder.decode(pathSegments.get(pathSegments.size() - 1));
        Log.d(f12478a, "The method name and parameters are " + str + " " + strDecode);
        return new Pair<>(str, strDecode);
    }

    public static byte[] f(Context context, Uri uri) {
        Pair<String, String> pairE = e(uri);
        if (pairE == null) {
            return null;
        }
        return null;
    }

    public static HashMap<String, String> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Log.d(f12478a, "The encoded parameter is " + str);
        String[] strArrSplit = str.split(com.alipay.sdk.m.w.a.p);
        HashMap<String, String> map = new HashMap<>();
        if (strArrSplit != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(MscKeys.KEY_VAL_SEP);
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
        return map;
    }
}
