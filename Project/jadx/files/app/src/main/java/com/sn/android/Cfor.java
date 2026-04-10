package com.sn.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.sntech.ads.BuildConfig;
import com.sntech.ads.ISNADS;
import com.sntech.ads.SNADSImpl;
import com.sntech.net.constant.Cdo;
import com.sntech.okhttpconnection.log.Cif;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import z0.o;

/* JADX INFO: renamed from: com.sn.android.for, reason: invalid class name */
/* JADX INFO: compiled from: DexUpdater.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cfor {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean f65do = false;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static boolean f66if = false;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static JSONObject m77do(Context context, ISNADS isnads, String str, String str2, JSONObject jSONObject) throws Exception {
        String strDid = isnads.did();
        List<String> list = e0.e.a;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", strDid);
        jSONObject2.put("r", str2);
        jSONObject2.put("p", context.getPackageName());
        jSONObject2.put("s_v", BuildConfig.VERSION_NAME);
        jSONObject2.put("p_s", e0.e.a(context));
        byte[] bytes = jSONObject2.toString().getBytes();
        JSONObject jSONObject3 = new JSONObject();
        byte[] bArrM135do = Cif.Cfor.m135do(UUID.randomUUID().toString() + System.currentTimeMillis());
        String strEncodeToString = Base64.encodeToString(Cif.Cdo.m133if(Cif.C0507if.m136do(bytes), bArrM135do, Cif.f121do), 2);
        String strEncodeToString2 = Base64.encodeToString(Cif.Cnew.m137do(bArrM135do), 2);
        jSONObject3.put("d", strEncodeToString);
        jSONObject3.put("k", strEncodeToString2);
        jSONObject3.put("s_v", BuildConfig.VERSION_NAME);
        jSONObject3.put(com.anythink.expressad.foundation.g.a.I, BuildConfig.VERSION_CODE);
        jSONObject3.put("v", BuildConfig.VERSION_NAME);
        jSONObject3.put("d_v", 3);
        jSONObject3.put(com.anythink.core.c.e.a, 10);
        jSONObject3.put("c", str);
        jSONObject3.put("o", "Android");
        jSONObject3.put("r", str2);
        jSONObject3.put("did", strDid);
        jSONObject3.put("t", System.currentTimeMillis());
        jSONObject3.put(com.anythink.expressad.d.a.b.aB, Process.myPid());
        jSONObject3.put("uid", Process.myUid());
        jSONObject3.put("a", Cdo.m97do());
        try {
            jSONObject3.put("p", context.getPackageName());
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject3.put("p_v", packageInfo.versionCode);
            jSONObject3.put("p_vn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return jSONObject3;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static void m82if(final ISNADS isnads, final String str, final String str2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sn.android.b
            @Override // java.lang.Runnable
            public final void run() {
                Cfor.m79do(isnads, str, str2);
            }
        });
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static void m81if(final ISNADS isnads, final int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sn.android.c
            @Override // java.lang.Runnable
            public final void run() {
                Cfor.m78do(isnads, i2);
            }
        });
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static void m83if(JSONObject jSONObject) {
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        o.a().a("CHECK_UPDATE_LOCAL", jSONObject);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static /* synthetic */ void m79do(ISNADS isnads, String str, String str2) {
        if (isnads instanceof SNADSImpl) {
            ((SNADSImpl) isnads).reload(str, str2);
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static /* synthetic */ void m78do(ISNADS isnads, int i2) {
        if (isnads instanceof SNADSImpl) {
            ((SNADSImpl) isnads).update(i2);
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m80do(JSONObject jSONObject) {
        try {
            jSONObject.put("timestamp", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        o.a().a("CHECK_UPDATE", jSONObject);
    }
}
