package com.sntech.okhttpconnection.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.entity.ConnType;
import com.sntech.okhttpconnection.log.Ccatch;
import com.sntech.okhttpconnection.log.Cif;
import com.umeng.analytics.AnalyticsConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.catch, reason: invalid class name */
/* JADX INFO: compiled from: WhiteListManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ccatch {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final /* synthetic */ int f97do = 0;

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.catch$do, reason: invalid class name */
    /* JADX INFO: compiled from: WhiteListManager.java */
    public interface Cdo {
        /* JADX INFO: renamed from: do */
        void mo108do(Cif cif);
    }

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.catch$if, reason: invalid class name */
    /* JADX INFO: compiled from: WhiteListManager.java */
    public static class Cif {

        /* JADX INFO: renamed from: case, reason: not valid java name */
        public Map<String, String> f98case;

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public boolean f99do;

        /* JADX INFO: renamed from: for, reason: not valid java name */
        public Set<String> f100for;

        /* JADX INFO: renamed from: if, reason: not valid java name */
        public boolean f101if;

        /* JADX INFO: renamed from: new, reason: not valid java name */
        public Set<String> f102new;

        /* JADX INFO: renamed from: try, reason: not valid java name */
        public String f103try;

        public Cif(boolean z2, boolean z3, Set<String> set, Set<String> set2, String str) {
            this.f99do = z2;
            this.f101if = z3;
            this.f100for = set;
            this.f102new = set2;
            this.f103try = str;
            this.f98case = m114do(str);
        }

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public final Map<String, String> m114do(String str) {
            HashMap map = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return map;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    map.put(jSONArray.getJSONObject(i2).getString("method"), jSONArray.getJSONObject(i2).optString("regex"));
                }
            } catch (JSONException e2) {
                if (com.sntech.okhttpconnection.log.Cdo.m119do()) {
                    String str2 = "WebViewInterceptListener Error: " + e2;
                }
            }
            return map;
        }

        public String toString() {
            StringBuilder sbA = y.b.a("WhiteListConfig{open=");
            sbA.append(this.f99do);
            sbA.append(", grey=");
            sbA.append(this.f101if);
            sbA.append(", whiteListOfHost=");
            sbA.append(this.f100for);
            sbA.append(", blackListOfHost=");
            sbA.append(this.f102new);
            sbA.append(", webViewSupportListStr='");
            sbA.append(this.f103try);
            sbA.append('\'');
            sbA.append(", webViewSupportList=");
            sbA.append(this.f98case);
            sbA.append('}');
            return sbA.toString();
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m112do(final Context context, final Cdo cdo) {
        Cdo cdo2 = new Cdo() { // from class: com.sntech.okhttpconnection.log.c
            @Override // com.sntech.okhttpconnection.log.Ccatch.Cdo
            /* JADX INFO: renamed from: do */
            public final void mo108do(Ccatch.Cif cif) {
                Ccatch.m113do(context, cdo, cif);
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient okHttpClientBuild = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
        String strM134do = Cif.Cfor.m134do(UUID.randomUUID().toString().getBytes());
        JSONObject jSONObject = new JSONObject();
        try {
            String strM115do = TextUtils.isEmpty(com.sntech.okhttpconnection.log.Cdo.m115do(context)) ? "" : com.sntech.okhttpconnection.log.Cdo.m115do(context);
            byte[] bytes = com.sntech.okhttpconnection.log.Cif.m131do(Cfor.m127if(context), strM115do, strM134do).toString().getBytes();
            byte[] bArrM135do = Cif.Cfor.m135do(UUID.randomUUID().toString() + System.currentTimeMillis());
            String strEncodeToString = Base64.encodeToString(Cif.Cdo.m133if(Cif.C0507if.m136do(bytes), bArrM135do, com.sntech.okhttpconnection.log.Cif.f121do), 2);
            String strEncodeToString2 = Base64.encodeToString(Cif.Cnew.m137do(bArrM135do), 2);
            jSONObject.put("d", strEncodeToString);
            jSONObject.put("k", strEncodeToString2);
            jSONObject.put("d_v", 3);
            jSONObject.put("s_v", com.sntech.okhttpconnection.log.Cdo.f108for);
            jSONObject.put(com.anythink.expressad.foundation.g.a.I, 6080);
            jSONObject.put("v", "6.0.80");
            jSONObject.put("p", context.getPackageName());
            jSONObject.put("o", "Android");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject.put("p_v", packageInfo.versionCode);
            jSONObject.put("p_vn", packageInfo.versionName);
            jSONObject.put("did", strM115do);
            jSONObject.put("r", strM134do);
            String str = com.sntech.okhttpconnection.log.Cdo.f113try.f116if;
            if (str == null) {
                str = "";
            }
            jSONObject.put("c", str);
            String strA = c0.a.a(context, "UMENG_CHANNEL");
            if (TextUtils.isEmpty(strA)) {
                try {
                    Class.forName("com.umeng.analytics.AnalyticsConfig");
                    strA = AnalyticsConfig.getChannel(context);
                } catch (ClassNotFoundException unused) {
                }
            }
            jSONObject.put("um_c", strA);
            if (com.sntech.okhttpconnection.log.Cdo.f104break == null) {
                com.sntech.okhttpconnection.log.Cdo.f104break = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            if (com.sntech.okhttpconnection.log.Cdo.f104break == null) {
                com.sntech.okhttpconnection.log.Cdo.f104break = "";
            }
            jSONObject.put("a", com.sntech.okhttpconnection.log.Cdo.f104break);
        } catch (Exception unused2) {
            com.sntech.okhttpconnection.log.Cdo.m119do();
        }
        byte[] bArrM136do = null;
        try {
            bArrM136do = Cif.C0507if.m136do(jSONObject.toString().getBytes());
        } catch (IOException unused3) {
            com.sntech.okhttpconnection.log.Cdo.m119do();
        }
        if (bArrM136do == null) {
            return;
        }
        okHttpClientBuild.newCall(new Request.Builder().addHeader("Content-Encoding", "gzip").url(HttpUrl.parse(com.sntech.okhttpconnection.log.Cdo.f113try.m121if()).newBuilder().addQueryParameter("r", strM134do).build()).post(RequestBody.create(com.sntech.okhttpconnection.log.Cdo.f106do, bArrM136do)).build()).enqueue(new Cbreak(cdo2, strM134do, context));
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m113do(Context context, Cdo cdo, Cif cif) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("cloude_log_config", 0).edit();
        editorEdit.putBoolean(ConnType.PK_OPEN, cif.f99do);
        editorEdit.putBoolean("grey", cif.f101if);
        editorEdit.putStringSet("whiteListOfHost", cif.f100for);
        editorEdit.putStringSet("blackListOfHost", cif.f102new);
        editorEdit.putString("webViewSupportList", cif.f103try);
        editorEdit.putBoolean("configPL", com.sntech.okhttpconnection.log.Cdo.f107else);
        editorEdit.apply();
        if (com.sntech.okhttpconnection.log.Cdo.m119do()) {
            StringBuilder sbA = y.b.a("get remote: ");
            sbA.append(cif.f99do);
            sbA.toString();
            String str = "whiteList: " + cif.f100for;
            String str2 = "blackList: " + cif.f102new;
            String str3 = "webViewSupportList: " + cif.f103try;
        }
        cdo.mo108do(cif);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Set m111do(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        }
        return hashSet;
    }
}
