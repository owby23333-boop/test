package z0;

import a0.e;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sntech.cc.Cdo;
import com.sntech.cc.data.ActionInfo;
import com.sntech.net.DomainProvider;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetClient.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static String a;
    public static JSONObject b;

    public static JSONObject a(JSONObject jSONObject) throws Exception {
        Context context = Cdo.f77do;
        String str = Cdo.f78for;
        String strA = e.b.a(UUID.randomUUID().toString().getBytes());
        byte[] bArr = a0.e.a;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", str);
        jSONObject2.put("r", strA);
        jSONObject2.put("p", Cdo.f77do.getPackageName());
        jSONObject2.put("s_v", Cdo.f79if);
        jSONObject2.put("p_s", a0.b.a(Cdo.f77do));
        byte[] bytes = jSONObject2.toString().getBytes();
        JSONObject jSONObject3 = new JSONObject();
        byte[] bArrA = e.b.a(UUID.randomUUID().toString() + System.currentTimeMillis());
        byte[] bArrA2 = e.c.a(bytes);
        byte[] bArr2 = a0.e.a;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrA, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bArrA2), 2);
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB".replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\n", ""), 0)));
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, rSAPublicKey);
        String strEncodeToString2 = Base64.encodeToString(cipher2.doFinal(bArrA), 2);
        jSONObject3.put("d", strEncodeToString);
        jSONObject3.put("k", strEncodeToString2);
        jSONObject3.put("d_v", 3);
        jSONObject3.put(com.anythink.core.c.e.a, 10);
        jSONObject3.put("c", Cdo.f80new);
        jSONObject3.put("o", "Android");
        jSONObject3.put("s_v", Cdo.f79if);
        jSONObject3.put("v", "2.8.80");
        jSONObject3.put("r", strA);
        jSONObject3.put("did", str);
        jSONObject3.put("t", System.currentTimeMillis());
        jSONObject3.put(com.anythink.expressad.d.a.b.aB, Process.myPid());
        jSONObject3.put("uid", Process.myUid());
        if (a == null) {
            a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        if (a == null) {
            a = "";
        }
        jSONObject3.put("a", a);
        try {
            jSONObject3.put("p", context.getPackageName());
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject3.put("p_v", packageInfo.versionCode);
            jSONObject3.put("p_vn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return jSONObject3;
    }

    public static ActionInfo a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        Object objFromJson;
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/ga");
        String string = sb.toString();
        try {
            String.valueOf(System.currentTimeMillis());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pos_id", str2);
            jSONObject.put("pos_type", str3);
            jSONObject.put("platform", str);
            jSONObject.put("event", str4);
            jSONObject.put("source", str5);
            jSONObject.put("api_version", 3);
            if (b == null) {
                try {
                    b = a0.c.c();
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("platform_versions", b);
            if (map.size() > 0) {
                for (String str6 : map.keySet()) {
                    jSONObject.put(str6, map.get(str6));
                }
            }
            JSONObject jSONObjectA = a(jSONObject);
            Response responseExecute = a0.g.a().newCall(new Request.Builder().url(string).addHeader("Content-Encoding", "gzip").post(RequestBody.create(a0.g.a, e.c.a(jSONObjectA.toString().getBytes()))).build()).execute();
            String string2 = jSONObjectA.getString("r");
            if (responseExecute.isSuccessful()) {
                String str7 = new String(e.a.a(Base64.decode(responseExecute.body().string(), 0), "x04VOtkJji86dsmn".getBytes(), "x04VOtkJji86dsmn".getBytes()));
                Gson gson = a0.f.a;
                if (TextUtils.isEmpty(str7)) {
                    objFromJson = null;
                } else {
                    try {
                        objFromJson = a0.f.a.fromJson(str7, (Class<Object>) ActionInfo.class);
                    } catch (JsonSyntaxException unused2) {
                        objFromJson = null;
                    }
                }
                ActionInfo actionInfo = (ActionInfo) objFromJson;
                if (string2.equals(actionInfo.getR())) {
                    return actionInfo;
                }
                return null;
            }
        } catch (Exception unused3) {
        }
        return null;
    }

    public static void a(String str, int i2) {
        if (i2 >= 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/ru");
        String string = sb.toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_id", str);
            Response responseExecute = a0.g.a().newCall(new Request.Builder().url(string).addHeader("Content-Encoding", "gzip").post(RequestBody.create(a0.g.a, e.c.a(a(jSONObject).toString().getBytes()))).build()).execute();
            if (responseExecute.isSuccessful()) {
                responseExecute.body().string();
            }
        } catch (Exception unused) {
            a(str, i2 + 1);
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/er");
        String string = sb.toString();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            jSONObject2.put("event_extra", jSONObject);
            Response responseExecute = a0.g.a().newCall(new Request.Builder().url(string).addHeader("Content-Encoding", "gzip").post(RequestBody.create(a0.g.a, e.c.a(a(jSONObject2).toString().getBytes()))).build()).execute();
            if (responseExecute.isSuccessful()) {
                responseExecute.body().string();
            }
        } catch (Exception unused) {
        }
    }
}
