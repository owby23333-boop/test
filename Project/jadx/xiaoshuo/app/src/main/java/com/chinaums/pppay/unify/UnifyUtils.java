package com.chinaums.pppay.unify;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.util.Xml;
import com.alipay.sdk.m.w.a;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.iflytek.aikit.media.param.MscKeys;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class UnifyUtils {
    private static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    private static final String INTENT_URL_FORMAT = "intent://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=https%3A%2F%2Fqr.alipay.com%2F{urlCode}%3F_s%3Dweb-other&_t=1472443966571#Intent;scheme=alipayqr;package=com.eg.android.AlipayGphone;end";

    public static void buildPayParams(StringBuilder sb, Map map, boolean z) {
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append(MscKeys.KEY_VAL_SEP);
            String strUrlEncode = (String) map.get(str);
            if (z) {
                strUrlEncode = urlEncode(strUrlEncode);
            }
            sb.append(strUrlEncode);
            sb.append(a.p);
        }
        sb.setLength(sb.length() - 1);
    }

    public static String createResultInfo(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultMsg", str);
            jSONObject.put("extraMsg", str2);
            jSONObject.put("rawMsg", str3);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> decodeXml(String str) {
        try {
            HashMap map = new HashMap();
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                String name = xmlPullParserNewPullParser.getName();
                if (eventType == 2 && !"xml".equals(name)) {
                    map.put(name, xmlPullParserNewPullParser.nextText());
                }
            }
            return map;
        } catch (Exception e) {
            Log.e("Simon", InternalFrame.ID + e.toString());
            return null;
        }
    }

    public static boolean hasInstalledAlipayClient(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean startAlipayClient(Context context, String str) {
        return startIntentUrl(context, INTENT_URL_FORMAT.replace("{urlCode}", str));
    }

    public static boolean startIntentUrl(Context context, String str) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addFlags(268435456);
            uri.addCategory("android.intent.category.BROWSABLE");
            context.startActivity(uri);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static String toJson(Object obj, Class<?> cls) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getSimpleName() + "[");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                if (field == declaredFields[declaredFields.length - 1]) {
                    sb = new StringBuilder();
                    sb.append(field.getName());
                    sb.append(":");
                    sb.append(field.get(obj));
                } else {
                    sb = new StringBuilder();
                    sb.append(field.getName());
                    sb.append(":");
                    sb.append(field.get(obj));
                    sb.append(", ");
                }
                sb2.append(sb.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                Log.d("ddebug", UnifyUtils.class.getSimpleName() + "toJson e.printStackTrace()");
            }
        }
        sb2.append("]");
        Log.d("ddebug", UnifyUtils.class.getSimpleName() + "toJson result = " + sb2.toString());
        return sb2.toString();
    }

    public static String toXml(Map map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        sb.append("<xml>");
        for (String str : arrayList) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append("<![CDATA[");
            sb.append((String) map.get(str));
            sb.append("]]>");
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }
}
