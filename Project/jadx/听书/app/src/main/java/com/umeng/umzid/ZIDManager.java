package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ZIDManager {
    public static ZIDManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2396a = false;
    public boolean b = false;
    public boolean c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f2397a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f2397a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.f2397a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f2398a;

        public b(Context context) {
            this.f2398a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.f2398a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f2399a;

        public c(Context context) {
            this.f2399a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f2399a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString = null;
        if (!zIDManager.f2396a) {
            zIDManager.f2396a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put(an.aD, id);
                String strB = d.b(context);
                jSONObject.put(an.A, strB);
                String strC = d.c(context);
                jSONObject.put("o", strC);
                zIDManager.a(context, jSONObject);
                String strA = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strB);
                        d.b(context, strC);
                        strOptString = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            d.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            d.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f2396a = false;
        }
        return strOptString;
    }

    public static synchronized ZIDManager getInstance() {
        if (d == null) {
            d = new ZIDManager();
        }
        return d;
    }

    public static String getSDKVersion() {
        return "1.6.3";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strA = d.a(applicationContext);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        boolean zD = d.d(context);
        this.c = zD;
        if (zD) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strA = d.a(applicationContext);
            if (strA == null || TextUtils.isEmpty(strA)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strA);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString("uuid", string).commit();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }
}
