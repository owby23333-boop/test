package com.bytedance.msdk.gz;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static boolean z() {
        Map<String, Object> mapSy = com.bytedance.msdk.core.z.kb().sy();
        Map<String, Object> mapUf = com.bytedance.msdk.core.z.kb().uf();
        if (mapSy != null) {
            try {
                if (mapSy.get("eefo") instanceof Boolean) {
                    return ((Boolean) mapSy.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (mapUf == null || !(mapUf.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) mapUf.get("eefo")).booleanValue();
    }

    public static String z(com.bytedance.msdk.api.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, dlVar.fo());
            jSONObject.put("custom_adn_name", dlVar.uy());
            jSONObject.put("slot_id", dlVar.kb());
            jSONObject.put("level_tag", dlVar.v());
            jSONObject.put(MediationConstant.KEY_ECPM, dlVar.i());
            jSONObject.put("bidding_type", dlVar.pf());
            jSONObject.put("error_msg", dlVar.ls());
            jSONObject.put("request_id", dlVar.p());
            jSONObject.put("ad_rit_type", dlVar.g());
            jSONObject.put("ad_sub_rit_type", dlVar.dl());
            jSONObject.put("segment_id", dlVar.a());
            jSONObject.put("abtest_id", dlVar.e());
            jSONObject.put("channel", dlVar.gc());
            jSONObject.put("sub_channel", dlVar.m());
            jSONObject.put("scenario_id", dlVar.gz());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String strZ = z(16);
            String strG = g(string, strZ);
            String strZ2 = z(strZ, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(strZ2.length())) + strZ2 + strG;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String z(String str, String str2) {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String g(String str, String str2) {
        try {
            return z.z(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String z(int i) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = secureRandom.nextInt(3);
            if (iNextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (iNextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (iNextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
