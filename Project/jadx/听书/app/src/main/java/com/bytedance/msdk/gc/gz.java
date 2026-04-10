package com.bytedance.msdk.gc;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static volatile gz z;
    private Cipher dl;
    private Key g;

    private gz() {
        try {
            this.g = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.g.g().vm(), 0)));
            this.dl = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public static gz z() {
        if (z == null) {
            synchronized (gz.class) {
                if (z == null) {
                    z = new gz();
                }
            }
        }
        return z;
    }

    public String z(byte[] bArr) throws Exception {
        byte[] bArrDoFinal;
        if (bArr == null) {
            return null;
        }
        if (this.dl == null) {
            this.g = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.g.g().vm(), 0)));
            this.dl = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.dl.init(1, this.g);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArrDoFinal = this.dl.doFinal(bArr, i, 117);
                } else {
                    bArrDoFinal = this.dl.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String z(com.bytedance.msdk.g.dl dlVar) {
        if (dlVar == null || MediationConstant.ADN_PANGLE.equals(dlVar.zx())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(dlVar.lt())) {
                jSONObject.putOpt(an.aI, dlVar.lt());
            }
            if (!TextUtils.isEmpty(dlVar.kp())) {
                jSONObject.putOpt("d", dlVar.kp());
            }
            jSONObject.putOpt("e", String.valueOf(dlVar.u()));
            if (!TextUtils.isEmpty(dlVar.sd())) {
                jSONObject.putOpt("an", dlVar.sd());
            }
            if (!TextUtils.isEmpty(dlVar.tf())) {
                jSONObject.putOpt("aun", dlVar.tf());
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return z(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            wp.z(e2);
            return null;
        }
    }
}
