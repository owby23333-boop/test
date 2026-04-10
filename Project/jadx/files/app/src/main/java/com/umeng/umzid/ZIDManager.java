package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.api.ErrorCode;
import com.umeng.analytics.pro.am;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ZIDManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ZIDManager f20602d;
    public boolean a = false;
    public boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20603c;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(ErrorCode.serverError, "获取zid失败");
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
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put(am.aD, id);
                String strB = d.b(context);
                jSONObject.put("mc", strB);
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
            zIDManager.a = false;
        }
        return strOptString;
    }

    public static synchronized ZIDManager getInstance() {
        if (f20602d == null) {
            f20602d = new ZIDManager();
        }
        return f20602d;
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
        this.f20603c = d.d(context);
        if (this.f20603c) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(ErrorCode.networkError, "传入参数Context为null");
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r9, org.json.JSONObject r10) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }
}
