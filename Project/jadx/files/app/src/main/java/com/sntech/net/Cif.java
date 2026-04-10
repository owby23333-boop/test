package com.sntech.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.c.e;
import com.sntech.net.constant.Cdo;
import com.sntech.net.utils.Cif;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.net.if, reason: invalid class name */
/* JADX INFO: compiled from: NetClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cif {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static OkHttpClient f89do;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static ScheduledExecutorService f90for;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static ExecutorService f91if;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static JSONObject m100do(JSONObject jSONObject) throws Exception {
        Context context = Cdo.f84do;
        String str = Cdo.f85for;
        String strM106do = Cif.C0506if.m106do(UUID.randomUUID().toString().getBytes());
        byte[] bArr = com.sntech.net.utils.Cif.f92do;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", str);
        jSONObject2.put("r", strM106do);
        jSONObject2.put("p", Cdo.f84do.getPackageName());
        jSONObject2.put("s_v", Cdo.f86if);
        jSONObject2.put("p_s", com.sntech.net.utils.Cdo.m104do(Cdo.f84do));
        byte[] bytes = jSONObject2.toString().getBytes();
        JSONObject jSONObject3 = new JSONObject();
        byte[] bArrM107do = Cif.C0506if.m107do(UUID.randomUUID().toString() + System.currentTimeMillis());
        byte[] bArrM105do = Cif.Cdo.m105do(bytes);
        byte[] bArr2 = com.sntech.net.utils.Cif.f92do;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrM107do, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bArrM105do), 2);
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB".replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\n", ""), 0)));
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, rSAPublicKey);
        String strEncodeToString2 = Base64.encodeToString(cipher2.doFinal(bArrM107do), 2);
        jSONObject3.put("d", strEncodeToString);
        jSONObject3.put("k", strEncodeToString2);
        jSONObject3.put("d_v", 3);
        jSONObject3.put(e.a, 10);
        jSONObject3.put("c", Cdo.f87new);
        jSONObject3.put("o", "Android");
        jSONObject3.put("s_v", Cdo.f86if);
        jSONObject3.put("v", "2.2");
        jSONObject3.put("r", strM106do);
        jSONObject3.put("did", str);
        jSONObject3.put("t", System.currentTimeMillis());
        jSONObject3.put(com.anythink.expressad.d.a.b.aB, Process.myPid());
        jSONObject3.put("uid", Process.myUid());
        String strM97do = Cdo.m97do();
        if (TextUtils.isEmpty(strM97do)) {
            strM97do = "";
        }
        jSONObject3.put("a", strM97do);
        try {
            jSONObject3.put("p", context.getPackageName());
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject3.put("p_v", packageInfo.versionCode);
            jSONObject3.put("p_vn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            Context context2 = Cdo.f84do;
        }
        return jSONObject3;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static void m103if(final String str, final JSONObject jSONObject, final boolean z2, final Cdo cdo) {
        f91if.execute(new Runnable() { // from class: com.sntech.net.b
            @Override // java.lang.Runnable
            public final void run() {
                Cif.m102do(str, jSONObject, z2, cdo);
            }
        });
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static synchronized void m101do(Context context, String str, String str2, String str3) {
        if (f89do != null) {
            return;
        }
        Cdo.f84do = context;
        Cdo.f86if = str;
        Cdo.f85for = str2;
        Cdo.f87new = str3;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f89do = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
        f91if = Executors.newCachedThreadPool();
        f90for = Executors.newScheduledThreadPool(3);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static /* synthetic */ void m102do(String str, JSONObject jSONObject, boolean z2, Cdo cdo) {
        try {
            cdo.mo75do(m99do(str, jSONObject, z2));
        } catch (Exception e2) {
            cdo.mo74do(e2);
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m99do(String str, JSONObject jSONObject, boolean z2) throws Exception {
        try {
            JSONObject jSONObjectM100do = m100do(jSONObject);
            byte[] bArrM105do = Cif.Cdo.m105do(jSONObjectM100do.toString().getBytes());
            String string = jSONObjectM100do.getString("r");
            Response responseExecute = f89do.newCall(new Request.Builder().url(HttpUrl.parse(str).newBuilder().addQueryParameter("r", string).build()).addHeader("Content-Encoding", "gzip").post(RequestBody.create(Cdo.f83case, bArrM105do)).build()).execute();
            if (responseExecute.isSuccessful()) {
                String strM98do = m98do(responseExecute.body().string());
                if (z2 && !string.equals(new JSONObject(strM98do).optString("r"))) {
                    throw new Exception("ReqId changed!");
                }
                return strM98do;
            }
            Context context = Cdo.f84do;
            throw new IOException("Unexpected code " + responseExecute);
        } catch (Exception e2) {
            Context context2 = Cdo.f84do;
            throw e2;
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m98do(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            byte[] bytes = "x04VOtkJji86dsmn".getBytes();
            byte[] bytes2 = "x04VOtkJji86dsmn".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bytes2));
            str = new String(cipher.doFinal(bArrDecode));
        } catch (Exception unused) {
            Context context = Cdo.f84do;
        }
        Context context2 = Cdo.f84do;
        return str;
    }
}
