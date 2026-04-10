package com.kingsoft.iciba.sdk2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.alipay.sdk.m.w.a;
import com.kingsoft.iciba.sdk2.interfaces.IKSCibaQueryResult;
import com.market.sdk.Constants;
import com.xiaomi.ad.y;
import com.xiaomi.phonenum.data.AccountCertification;
import com.yuewen.et;
import com.yuewen.gm;
import com.yuewen.ld0;
import com.yuewen.so2;
import com.yuewen.x22;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Pattern;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class d {
    private static d s;
    private Context h;
    private long i;
    private boolean t = true;
    private Vector u = new Vector();
    private h v;

    private d(Context context) {
        this.h = context;
        h hVar = new h(this);
        this.v = hVar;
        hVar.start();
    }

    public static d a(Context context, long j) {
        if (s == null) {
            s = new d(context);
        }
        d dVar = s;
        dVar.h = context;
        dVar.i = j;
        return dVar;
    }

    public static boolean b(d dVar) {
        return dVar.t;
    }

    public static String c(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return null;
        }
    }

    private static void copyStream(InputStream inputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr = new byte[4096];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } finally {
            }
            while (true) {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                    bufferedOutputStream.write(bArr, 0, i);
                    bufferedOutputStream.close();
                } finally {
                }
            }
        } catch (IOException unused) {
        } catch (Exception e) {
            Log.e("Utils", "Copy data failed", e);
        }
    }

    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private HttpPost e(String str) {
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://dict-mobile.iciba.com/interface/index.php");
            stringBuffer.append("?c=word");
            stringBuffer.append("&list=");
            stringBuffer.append("1");
            stringBuffer.append("&client=");
            stringBuffer.append(1);
            String strValueOf = String.valueOf(System.currentTimeMillis() / 1000);
            stringBuffer.append("&timestamp=");
            stringBuffer.append(strValueOf);
            stringBuffer.append("&sign=");
            stringBuffer.append(h("word#ICIBA!(*&R$@#LOVE#1" + strValueOf).substring(5, 21));
            stringBuffer.append("&uuid=");
            stringBuffer.append(b(this.h));
            stringBuffer.append("&sv=");
            stringBuffer.append("android" + Build.VERSION.RELEASE);
            stringBuffer.append("&v=");
            stringBuffer.append(x22.i);
            stringBuffer.append("&uid=");
            stringBuffer.append("&tc=");
            stringBuffer.append(s.i);
            HttpPost httpPost = new HttpPost(stringBuffer.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", strEncode));
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return httpPost;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #3 {all -> 0x0055, blocks: (B:12:0x0044, B:15:0x004c), top: B:69:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095 A[Catch: Exception -> 0x00e2, TRY_ENTER, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void f(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingsoft.iciba.sdk2.d.f(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #3 {all -> 0x0055, blocks: (B:12:0x0044, B:15:0x004c), top: B:69:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095 A[Catch: Exception -> 0x00e2, TRY_ENTER, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[Catch: Exception -> 0x00e2, TryCatch #10 {Exception -> 0x00e2, blocks: (B:3:0x0021, B:5:0x0027, B:35:0x007a, B:37:0x0080, B:39:0x008c, B:42:0x0095, B:44:0x00b1, B:58:0x00dc, B:43:0x00a9, B:38:0x0087, B:30:0x0067, B:33:0x006f, B:34:0x0075, B:45:0x00bb, B:47:0x00cb, B:56:0x00da, B:55:0x00d7, B:50:0x00d0, B:52:0x00d2, B:46:0x00c5), top: B:82:0x0021, inners: #2, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingsoft.iciba.sdk2.d.g(java.lang.String):void");
    }

    public static String h(String str) {
        byte[] bArrDigest;
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e("Utils", "Calculate md5 failed", e);
            bArrDigest = null;
        } catch (NoSuchAlgorithmException e2) {
            Log.e("Utils", "Calculate md5 failed", e2);
            bArrDigest = null;
        }
        if (bArrDigest == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArrDigest.length << 1);
        for (byte b2 : bArrDigest) {
            int i = b2 & 255;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    private static String i(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class).invoke(cls, str);
            return objInvoke == null ? "" : objInvoke.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String j(String str) {
        if (!str.matches("[a-z&]+")) {
            return str;
        }
        int length = Ca.d.length;
        if (str.length() == 1) {
            for (int i = 0; i < length; i++) {
                if (str.equals(Ca.d[i])) {
                    return Ca.c[i];
                }
            }
            return str;
        }
        if (str.length() < 3 || !str.contains(a.p)) {
            return str;
        }
        String str2 = "";
        for (String str3 : str.split(a.p)) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (str3.equals(Ca.d[i2])) {
                    if (str2.length() != 0) {
                        str2 = str2 + a.p;
                    }
                    str2 = str2 + Ca.c[i2];
                } else {
                    i2++;
                }
            }
        }
        return str2;
    }

    public final void stopCurrentWordSearch() {
        h hVar = this.v;
        if (hVar != null) {
            hVar.stopCurrentWordSearch();
        }
    }

    public static String b(Context context, JSONObject jSONObject, long j) {
        return a(context, jSONObject, j);
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a(context, Constants.EXTRA_UUID, ""))) {
            String strReplaceAll = UUID.randomUUID().toString().trim().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(ld0.f13887b, 0).edit();
                editorEdit.putString(Constants.EXTRA_UUID, strReplaceAll);
                editorEdit.apply();
                return strReplaceAll;
            } catch (Exception e) {
                e.printStackTrace();
                return strReplaceAll;
            }
        }
        return a(context, Constants.EXTRA_UUID, "");
    }

    public final void a(String str, IKSCibaQueryResult iKSCibaQueryResult) {
        new Thread(new e(this, str, e(str), iKSCibaQueryResult)).start();
    }

    public final void a(String str, ArrayList arrayList, IKSCibaQueryResult iKSCibaQueryResult) {
        new Thread(new f(this, str, e(str), arrayList, iKSCibaQueryResult)).start();
    }

    private String a(JSONObject jSONObject, g gVar) {
        try {
            if (jSONObject.optJSONObject("message") == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectOptJSONObject = ((JSONObject) jSONObject.get("message")).optJSONObject("baesInfo");
            if (jSONObjectOptJSONObject == null && gVar.F == null) {
                jSONObject2.put("status", 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject2.put("message", jSONObject3);
                jSONObject3.put("word_name", gVar.B);
                jSONObject3.put("result_info", "获取释义失败");
            } else {
                jSONObject2.put("status", 1);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject2.put("message", jSONObject4);
                jSONObject4.put("word_name", gVar.B);
                jSONObject4.put("result_info", "获取释义成功");
                if (jSONObjectOptJSONObject != null) {
                    jSONObject4.put("baseInfo", a(jSONObjectOptJSONObject));
                }
                ArrayList<AbstractMap.SimpleEntry> arrayList = gVar.F;
                if (arrayList != null) {
                    for (AbstractMap.SimpleEntry simpleEntry : arrayList) {
                        jSONObject4.put((String) simpleEntry.getKey(), new JSONObject((String) simpleEntry.getValue()));
                    }
                }
            }
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer b(byte[] bArr, int i, int i2) {
        int i3 = i + 2;
        if (bArr.length < i3) {
            return -1;
        }
        Integer numValueOf = 0;
        for (int i4 = 0; i4 < 2; i4++) {
            numValueOf = Integer.valueOf(Integer.valueOf(numValueOf.intValue() << 8).intValue() | (bArr[(i3 - 1) - i4] & 255));
        }
        return numValueOf;
    }

    public static HttpClient e() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 1000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private static String a(g gVar) {
        if (gVar.F == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("message", jSONObject2);
                jSONObject2.put("result_info", "获取释义失败");
                jSONObject2.put("word_name", gVar.B);
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e("NetSearchManage", "Create Json failed", e);
            }
        } else {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", 1);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject3.put("message", jSONObject4);
                jSONObject4.put("result_info", "获取释义成功");
                jSONObject4.put("word_name", gVar.B);
                for (AbstractMap.SimpleEntry simpleEntry : gVar.F) {
                    jSONObject4.put((String) simpleEntry.getKey(), new JSONObject((String) simpleEntry.getValue()));
                }
                return jSONObject3.toString();
            } catch (Exception e2) {
                Log.e("NetSearchManage", "Create Json failed", e2);
            }
        }
        return null;
    }

    private static JSONObject a(JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!jSONObject.isNull("translate_type")) {
                i = jSONObject.getInt("translate_type");
                jSONObject2.put("translate_type", i);
            } else {
                jSONObject2.put("translate_type", 1);
                i = 1;
            }
            if (i == 1) {
                if (!jSONObject.isNull("exchange")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("exchange");
                    JSONObject jSONObject4 = new JSONObject();
                    for (String str : Ca.e) {
                        if (!jSONObject3.isNull(str) && jSONObject3.getJSONArray(str).length() > 0) {
                            jSONObject4.put(str, jSONObject3.getJSONArray(str));
                        }
                    }
                    if (jSONObject4.length() > 0) {
                        jSONObject2.put("exchange", jSONObject4);
                    }
                }
                if (!jSONObject.isNull("symbols")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("symbols");
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = jSONArray.getJSONObject(i2);
                        if (!jSONObject6.isNull("word_symbol")) {
                            jSONObject5.put("word_symbol", jSONObject6.getString("word_symbol"));
                        } else {
                            if (!jSONObject6.isNull("ph_en") && !TextUtils.isEmpty(jSONObject6.getString("ph_en"))) {
                                jSONObject5.put("ph_en", jSONObject6.getString("ph_en"));
                            }
                            if (!jSONObject6.isNull("ph_am") && !TextUtils.isEmpty(jSONObject6.getString("ph_am"))) {
                                jSONObject5.put("ph_am", jSONObject6.getString("ph_am"));
                            }
                            if (!jSONObject6.isNull("ph_other") && !TextUtils.isEmpty(jSONObject6.getString("ph_other"))) {
                                jSONObject5.put("ph_other", jSONObject6.getString("ph_other"));
                            }
                        }
                        if (!jSONObject6.isNull("parts") && jSONObject6.getJSONArray("parts").length() > 0) {
                            jSONObject5.put("parts", jSONObject6.getJSONArray("parts"));
                        }
                        if (jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        jSONObject2.put("symbols", jSONArray2);
                    }
                }
            } else if (i == 2) {
                if (!jSONObject.isNull("translate_result")) {
                    jSONObject2.put("translate_result", jSONObject.getString("translate_result"));
                }
                if (!jSONObject.isNull("translate_msg")) {
                    jSONObject2.put("translate_msg", jSONObject.getString("translate_msg"));
                }
            } else if (i == 3 && !jSONObject.isNull(so2.Ab)) {
                jSONObject2.put(so2.Ab, jSONObject.getJSONArray(so2.Ab));
            }
        } catch (Exception e) {
            Log.e("NetSearchManage", "Transform Json failed", e);
        }
        return jSONObject2;
    }

    public static Vector a(d dVar) {
        return dVar.u;
    }

    public static void a(d dVar, String str, g gVar) {
        String strA;
        try {
            if (str != null) {
                strA = dVar.a(new JSONObject(str), gVar);
            } else {
                strA = a(gVar);
            }
        } catch (Exception e) {
            Log.e("NetSearchManage", "Create search result json failed", e);
            strA = null;
        }
        gVar.G.searchResult(strA);
    }

    public static void a(Context context, String str, long j) {
        File file = new File(str + File.separator + "iciba_statistics");
        if (file.exists() && file.length() > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            file.delete();
        } else if (a(context)) {
            new Thread(new i(file, context, j)).start();
        }
    }

    private static String a(Context context, JSONObject jSONObject, long j) {
        JSONObject jSONObject2 = new JSONObject();
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        try {
            jSONObject2.put("protocol", 2);
            jSONObject2.put("cid", 7);
            jSONObject2.put(et.j, lValueOf);
            jSONObject2.put(Constants.EXTRA_UUID, b(context));
            jSONObject2.put("p", Long.toString(j));
            jSONObject2.put("package_name", c(context));
            jSONObject2.put("sign", h(b(context) + 7 + lValueOf + "icibaclient_#&$%"));
            StringBuilder sb = new StringBuilder();
            sb.append(context instanceof Activity ? ((Activity) context).getWindowManager().getDefaultDisplay().getWidth() : 0);
            sb.append(ProxyConfig.MATCH_ALL_SCHEMES);
            sb.append(context instanceof Activity ? ((Activity) context).getWindowManager().getDefaultDisplay().getHeight() : 0);
            jSONObject2.put("g", sb.toString());
            jSONObject2.put("n", "other");
            String strI = Build.MODEL;
            if (Boolean.valueOf(Pattern.compile("(\\d.*?)").matcher(strI).matches()).booleanValue()) {
                strI = i("persist.sys.device_name");
            }
            jSONObject2.put(y.k, strI);
            jSONObject2.put("s", Build.VERSION.RELEASE);
            jSONObject2.put("ver", x22.i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2.put("events", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (a(context, "com.youdao.dict")) {
                jSONArray2.put(1);
            }
            if (a(context, "com.kingsoft")) {
                jSONArray2.put(2);
            }
            jSONObject2.put(gm.a.f11596b, jSONArray2);
            jSONObject2.put("error", new JSONArray());
            jSONObject2.put("history", new JSONArray());
        } catch (Exception e) {
            Log.e("KStatistics", "Create data failed", e);
        }
        return jSONObject2.toString();
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals(AccountCertification.Source.SOURCE_TYPE_OPERATOR_MOBILE)) {
                activeNetworkInfo.getExtraInfo();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (str == null || context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception e) {
            Log.e("Utils", "Get app installed state failed", e);
            return false;
        }
    }

    private static String a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(ld0.f13887b, 0).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String a(InputStream inputStream) {
        String string = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
            try {
                copyStream(inputStream, byteArrayOutputStream);
                string = byteArrayOutputStream.toString("UTF-8");
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (Exception e) {
            Log.e("Utils", "Load string from stream failed", e);
        }
        return string;
    }

    public static String a(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i4 < i && (bArr[i4] != 0 || bArr[i4 + 1] != 0)) {
            i4 += 2;
        }
        int i5 = i4 / 2;
        char[] cArr = new char[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 << 1) + 0;
            char c = (char) ((bArr[i7] & 255) | cArr[i6]);
            cArr[i6] = c;
            cArr[i6] = (char) (((bArr[i7 + 1] & 255) << 8) | c);
        }
        return new String(cArr);
    }

    public static int a(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        if (bArr.length < i3) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 = (i4 << 8) | (bArr[(i3 - 1) - i5] & 255);
        }
        return i4;
    }
}
