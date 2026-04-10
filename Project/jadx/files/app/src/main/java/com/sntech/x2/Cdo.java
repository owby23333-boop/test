package com.sntech.x2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.meituan.android.walle.WalleChannelReader;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.AnalyticsConfig;
import for0.e;
import h0.g;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import r.c;
import r.d;
import r.f;

/* JADX INFO: renamed from: com.sntech.x2.do, reason: invalid class name */
/* JADX INFO: compiled from: MediationTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static Cdo f133for;

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static ScheduledExecutorService f134new = Executors.newScheduledThreadPool(2);

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public Context f135do;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public JSONObject f136if;

    public Cdo(Context context) {
        this.f135do = context;
        m153new();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m148do() {
        if (com.sntech.x2.topon.reload.Cdo.f143if == null) {
            synchronized (com.sntech.x2.topon.reload.Cdo.class) {
                if (com.sntech.x2.topon.reload.Cdo.f143if == null) {
                    com.sntech.x2.topon.reload.Cdo.f143if = new com.sntech.x2.topon.reload.Cdo();
                }
            }
        }
        com.sntech.x2.topon.reload.Cdo.f143if.m171do();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public void m149if() {
        try {
            String strA = f.a.a(z.a.a, null);
            if (strA != null) {
                JSONObject jSONObject = new JSONObject(strA);
                if (jSONObject.keys().hasNext()) {
                    this.f136if = jSONObject;
                    c.b("mediation", jSONObject.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void m152for() {
        new Thread(new Runnable() { // from class: com.sntech.x2.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f17917s.m149if();
            }
        }).start();
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public final void m153new() {
        String strA = c.a("mediation", null);
        if (strA != null) {
            try {
                this.f136if = new JSONObject(strA);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Cdo m147do(Context context) {
        if (f133for == null) {
            synchronized (Cdo.class) {
                if (f133for == null) {
                    f133for = new Cdo(context);
                }
            }
        }
        return f133for;
    }

    @RequiresApi(api = 19)
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void m151do(String str, String str2) {
        m152for();
        com.sntech.x2.topon.arpu.Cdo.m161do().m167if();
        f134new.scheduleAtFixedRate(new Runnable() { // from class: com.sntech.x2.a
            @Override // java.lang.Runnable
            public final void run() {
                Cdo.m148do();
            }
        }, 0L, 3L, TimeUnit.MINUTES);
        HashMap<String, Object> map = new HashMap<>();
        Context context = this.f135do;
        JSONObject jSONObject = new JSONObject();
        try {
            String channel = null;
            jSONObject.put("channel", context.getSharedPreferences("prefs_sn_android", 0).getString("app_channel", null));
            String strA = d.a(context, "UMENG_CHANNEL");
            if (TextUtils.isEmpty(strA)) {
                try {
                    Class.forName("com.umeng.analytics.AnalyticsConfig");
                    strA = AnalyticsConfig.getChannel(context);
                } catch (ClassNotFoundException unused) {
                }
            }
            jSONObject.put(BaseConstants.CATEGORY_UMENG, strA);
            jSONObject.put("talkingData", d.a(context, "TD_CHANNEL_ID"));
            try {
                Class.forName("com.meituan.android.walle.WalleChannelReader");
                channel = WalleChannelReader.getChannel(context, "");
            } catch (ClassNotFoundException unused2) {
            }
            jSONObject.put("walle", channel);
        } catch (JSONException unused3) {
        }
        map.put("channels", jSONObject);
        map.put("sdk_version", str);
        map.put("origin_sdk_version", str2);
        try {
            map.put("platform_versions", f.a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        g.a().a(map);
        if (e.f20798e == null) {
            synchronized (e.class) {
                if (e.f20798e == null) {
                    e.f20798e = new e();
                }
            }
        }
        e eVar = e.f20798e;
        eVar.a();
        eVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        r15 = r0.getJSONObject(r1).getString(com.anythink.core.common.c.l.a.f7055c);
     */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m150do(java.lang.String r13, int r14, java.lang.String r15) {
        /*
            r12 = this;
            org.json.JSONObject r0 = r12.f136if
            if (r0 == 0) goto L7e
            boolean r0 = r0.has(r13)
            if (r0 != 0) goto Lc
            goto L7e
        Lc:
            org.json.JSONObject r0 = r12.f136if     // Catch: org.json.JSONException -> L7a
            org.json.JSONArray r0 = r0.getJSONArray(r13)     // Catch: org.json.JSONException -> L7a
            r1 = 0
            r2 = 0
            r5 = r2
            r4 = 0
        L17:
            int r7 = r0.length()     // Catch: org.json.JSONException -> L7a
            java.lang.String r8 = "scene_id"
            java.lang.String r9 = "weight"
            if (r4 >= r7) goto L37
            org.json.JSONObject r7 = r0.getJSONObject(r4)     // Catch: org.json.JSONException -> L7a
            int r7 = r7.optInt(r8)     // Catch: org.json.JSONException -> L7a
            if (r14 != r7) goto L34
            org.json.JSONObject r7 = r0.getJSONObject(r4)     // Catch: org.json.JSONException -> L7a
            double r7 = r7.getDouble(r9)     // Catch: org.json.JSONException -> L7a
            double r5 = r5 + r7
        L34:
            int r4 = r4 + 1
            goto L17
        L37:
            java.util.Random r4 = new java.util.Random     // Catch: org.json.JSONException -> L7a
            r4.<init>()     // Catch: org.json.JSONException -> L7a
            double r10 = r4.nextDouble()     // Catch: org.json.JSONException -> L7a
            double r5 = r5 * r10
        L42:
            int r4 = r0.length()     // Catch: org.json.JSONException -> L7a
            if (r1 >= r4) goto L7e
            org.json.JSONObject r4 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L7a
            int r4 = r4.optInt(r8)     // Catch: org.json.JSONException -> L7a
            if (r14 != r4) goto L77
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 < 0) goto L6e
            org.json.JSONObject r4 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L7a
            double r10 = r4.getDouble(r9)     // Catch: org.json.JSONException -> L7a
            double r10 = r10 + r2
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 >= 0) goto L6e
            org.json.JSONObject r14 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L7a
            java.lang.String r0 = "placement_id"
            java.lang.String r15 = r14.getString(r0)     // Catch: org.json.JSONException -> L7a
            goto L7e
        L6e:
            org.json.JSONObject r4 = r0.getJSONObject(r1)     // Catch: org.json.JSONException -> L7a
            double r10 = r4.getDouble(r9)     // Catch: org.json.JSONException -> L7a
            double r2 = r2 + r10
        L77:
            int r1 = r1 + 1
            goto L42
        L7a:
            r14 = move-exception
            r14.printStackTrace()
        L7e:
            com.sntech.x2.topon.arpu.do r14 = com.sntech.x2.topon.arpu.Cdo.m161do()
            r14.m164do(r13, r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sntech.x2.Cdo.m150do(java.lang.String, int, java.lang.String):java.lang.String");
    }
}
