package com.bytedance.sdk.component.gz.g.gc;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.gz.g.dl.dl;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.gz.z.gz;
import com.bytedance.sdk.component.gz.z.z.m;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.gz.z.z.z<com.bytedance.sdk.component.gz.z.g> {
    private static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gc f743a;
    private final String dl = "x-pglcypher";
    private final boolean z = g();

    private String g(int i) {
        return i >= 4 ? "application/octet-stream" : "application/octet-stream;tt-data=a";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gc z() {
        if (this.f743a == null) {
            this.f743a = com.bytedance.sdk.component.gz.g.z.dl("csj").dl();
        }
        return this.f743a;
    }

    public static byte[] g(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private static boolean g() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.z
    public com.bytedance.sdk.component.gz.g.g.dl.g z(List<com.bytedance.sdk.component.gz.z.g> list) {
        gz gzVarWp;
        com.bytedance.sdk.component.gz.g.g.dl.g gVarZ;
        String strM;
        a aVarA = z().a();
        Object[] objArr = null;
        byte b = 0;
        byte b2 = 0;
        if (aVarA != null) {
            try {
                if (aVarA.a() && (gzVarWp = aVarA.wp()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str = "1streqid";
                    String strM2 = "2ndreqid";
                    String str2 = "";
                    int i = 0;
                    for (com.bytedance.sdk.component.gz.z.g gVar : list) {
                        try {
                            if (TextUtils.equals("show", com.bytedance.sdk.component.gz.g.dl.z.z(gVar, z()))) {
                                String strZ = com.bytedance.sdk.component.gz.g.dl.z.z(gVar.e(), this.f743a);
                                if (i == 0) {
                                    strM = com.bytedance.sdk.component.gz.g.dl.z.m(gVar, this.f743a);
                                } else {
                                    strM2 = com.bytedance.sdk.component.gz.g.dl.z.m(gVar, this.f743a);
                                    strM = strM2;
                                }
                                str2 = strZ;
                                str = strM;
                                i = 1;
                            }
                            arrayList.add(gVar);
                        } catch (Throwable th) {
                            th = th;
                            i = i;
                            try {
                                dl.dl("NetApiImpl", "uploadEvent error" + th.getMessage(), z());
                                return new com.bytedance.sdk.component.gz.g.g.dl.g(false, 509, th.getMessage(), false, "error");
                            } finally {
                                if (i != 0 && 0 != 0) {
                                    int length = objArr.length;
                                }
                            }
                        }
                    }
                    int iUy = gzVarWp.uy();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectZ = gzVarWp.z(g(arrayList), this.z);
                    byte[] bArrZ = gzVarWp.z(jSONObjectZ, iUy);
                    if (bArrZ == null) {
                        JSONObject jSONObjectZ2 = gzVarWp.z(jSONObjectZ);
                        bArrZ = g(jSONObjectZ2);
                        gVarZ = z(bArrZ, a(jSONObjectZ2), "application/json; charset=utf-8");
                    } else {
                        gVarZ = z(bArrZ, z(iUy), g(iUy));
                    }
                    if (i != 0) {
                        int length2 = bArrZ != null ? bArrZ.length : 0;
                        if (gVarZ != null) {
                            com.bytedance.sdk.component.gz.g.dl.z.z(gVarZ.z, gVarZ.g, gVarZ.dl, str + "|" + strM2, length2, str2);
                        }
                    }
                    return gVarZ;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public List<com.bytedance.sdk.component.gz.z.g> g(List<com.bytedance.sdk.component.gz.z.g> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.gz.z.g gVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectE = gVar.e();
                String strOptString = jSONObjectE.optString("label");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectE.optString(NotificationCompat.CATEGORY_EVENT);
                }
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, strOptString);
                long jOptLong = jSONObjectE.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", g.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObjectE.has("params") && jSONObjectE.has(NotificationCompat.CATEGORY_EVENT)) {
                    jSONObject2 = jSONObjectE.optJSONObject("params");
                } else {
                    Iterator<String> itKeys = jSONObjectE.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, jSONObjectE.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.gz.g.a.z.z zVar = new com.bytedance.sdk.component.gz.g.a.z.z(gVar.dl(), jSONObject);
                zVar.z(gVar.a());
                zVar.g(gVar.gc());
                arrayList.add(zVar);
            } catch (Exception e) {
                dl.dl(e.getMessage(), z());
            }
        }
        return arrayList;
    }

    private Map<String, String> z(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put(HttpHeaders.CONTENT_TYPE, g(i));
        return map;
    }

    private Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        if (m(jSONObject)) {
            map.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return map;
    }

    private com.bytedance.sdk.component.gz.g.g.dl.g z(byte[] bArr, Map<String, String> map, String str) {
        int iGc;
        boolean zDl;
        boolean z;
        String str2;
        try {
            a aVarA = z().a();
            gz gzVarWp = aVarA.wp();
            m mVarGc = gzVarWp.gc();
            mVarGc.z(gzVarWp.m());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    mVarGc.z(entry.getKey(), entry.getValue());
                }
            }
            mVarGc.z(str, bArr);
            mVarGc.z("User-Agent", aVarA.gc());
            com.bytedance.sdk.component.gz.z.z.gc gcVarZ = mVarGc.z();
            if (gcVarZ == null) {
                return new com.bytedance.sdk.component.gz.g.g.dl.g(false, 510, "RSP IS NULL", false, "error");
            }
            boolean z2 = false;
            if (gcVarZ == null || !gcVarZ.z() || TextUtils.isEmpty(gcVarZ.g())) {
                iGc = 0;
                zDl = false;
            } else {
                JSONObject jSONObject = new JSONObject(gcVarZ.g());
                zDl = dl(jSONObject);
                iGc = gc(jSONObject);
            }
            int iDl = gcVarZ.dl();
            String str3 = gcVarZ.gc() != null ? gcVarZ.gc().get("x-tt-logid") : "error";
            boolean z3 = !zDl && iDl == 200;
            String strA = gcVarZ.a();
            if (strA == null || TextUtils.isEmpty(strA)) {
                strA = "DEFAULT OK";
            }
            if (iGc != 0) {
                str2 = "RSP FAIL";
                z = true;
            } else {
                z2 = zDl;
                iGc = iDl;
                z = z3;
                str2 = strA;
            }
            g(bArr, map, str);
            return new com.bytedance.sdk.component.gz.g.g.dl.g(z2, iGc, str2, z, str3);
        } catch (Throwable th) {
            dl.dl("NetApiImpl", "uploadEvent error" + th.getMessage(), z());
            return new com.bytedance.sdk.component.gz.g.g.dl.g(false, 511, th.getMessage(), false, "error");
        }
    }

    private void g(byte[] bArr, Map<String, String> map, String str) {
        gc gcVarZ;
        a aVarA;
        gz gzVarWp;
        if (bArr == null || bArr.length == 0 || (gcVarZ = z()) == null || (aVarA = gcVarZ.a()) == null || (gzVarWp = aVarA.wp()) == null || !gzVarWp.z()) {
            return;
        }
        m mVarGc = gzVarWp.gc();
        mVarGc.z(gzVarWp.g());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mVarGc.z(entry.getKey(), entry.getValue());
            }
        }
        mVarGc.z(str, bArr);
        mVarGc.z("User-Agent", aVarA.gc());
        mVarGc.z(new com.bytedance.sdk.component.gz.z.z.dl() { // from class: com.bytedance.sdk.component.gz.g.gc.z.1
            @Override // com.bytedance.sdk.component.gz.z.z.dl
            public void z(com.bytedance.sdk.component.gz.z.z.a aVar, com.bytedance.sdk.component.gz.z.z.gc gcVar) {
                if (gcVar == null || !gcVar.z()) {
                    z.this.z();
                } else {
                    gcVar.g();
                    z.this.z();
                }
            }

            @Override // com.bytedance.sdk.component.gz.z.z.dl
            public void z(com.bytedance.sdk.component.gz.z.z.a aVar, IOException iOException) {
                iOException.getMessage();
                z.this.z();
            }
        });
    }

    public boolean dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PublicKey dl() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    private boolean z(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(dl().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    private int gc(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf("_")) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            String strSubstring2 = strOptString.substring(iIndexOf + 1);
            JSONObject jSONObjectFo = z().a().wp().fo();
            if (z((jSONObjectFo != null ? jSONObjectFo.optString("device_id") : "") + "_" + strSubstring, strSubstring2)) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.gz.z.z.z
    public com.bytedance.sdk.component.gz.g.g.dl.g z(JSONObject jSONObject) {
        gz gzVarWp;
        int i;
        boolean z;
        String str;
        boolean z2;
        int i2;
        com.bytedance.sdk.component.gz.z.z.gc gcVarZ;
        int i3;
        a aVarA = z().a();
        if (aVarA == null || !aVarA.a() || jSONObject == null || jSONObject.length() <= 0 || (gzVarWp = aVarA.wp()) == null) {
            return null;
        }
        m mVarGc = gzVarWp.gc();
        mVarGc.z(gzVarWp.e());
        int iUy = gzVarWp.uy();
        byte[] bArrG = gzVarWp.g(jSONObject, iUy);
        if (bArrG == null) {
            mVarGc.g(gzVarWp.z(jSONObject).toString());
        } else {
            mVarGc.z(g(iUy), bArrG);
            mVarGc.z("x-pglcypher", String.valueOf(iUy));
        }
        mVarGc.z("User-Agent", aVarA.gc());
        String strA = "error unknown";
        int iDl = 0;
        try {
            gcVarZ = mVarGc.z();
        } catch (Throwable unused) {
            i = 0;
            z = false;
        }
        if (gcVarZ == null) {
            return new com.bytedance.sdk.component.gz.g.g.dl.g(false, 0, "error unknown", false, "ignore");
        }
        if (!gcVarZ.z() || TextUtils.isEmpty(gcVarZ.g())) {
            i3 = 0;
            z = false;
        } else {
            JSONObject jSONObject2 = new JSONObject(gcVarZ.g());
            int iOptInt = jSONObject2.optInt("code", -1);
            strA = jSONObject2.optString("data", "");
            z = true;
            i3 = iOptInt == 20000 ? 1 : 0;
            if (iOptInt != 60005) {
                z = false;
            }
        }
        try {
            iDl = gcVarZ.dl();
            if (!gcVarZ.z()) {
                strA = gcVarZ.a();
            }
            str = strA;
            i2 = iDl;
            z2 = i3;
        } catch (Throwable unused2) {
            i = iDl;
            iDl = i3;
            str = strA;
            z2 = iDl;
            i2 = i;
        }
        return new com.bytedance.sdk.component.gz.g.g.dl.g(z2, i2, str, z, "ignore");
    }

    private boolean m(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }
}
