package com.bytedance.embedapplog;

import android.content.Context;
import android.net.Uri;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gk {
    public static JSONObject z(Context context, JSONObject jSONObject, boolean z) {
        byte[] bytes;
        JSONObject jSONObjectZ;
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = jSONObject.toString().getBytes("UTF-8");
            String strClientPackedBase64 = TTEncryptUtils.clientPackedBase64(bytes2, bytes2.length);
            if (js.g()) {
                js.z("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                js.dl("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(strClientPackedBase64)));
            }
            bytes = strClientPackedBase64.getBytes("UTF-8");
        } catch (Exception e) {
            js.a("__kite", "error: " + e.getMessage());
            bytes = bytes2;
        }
        if (bytes == null) {
            js.dl("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObjectZ = z(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter("req_id", UUID.randomUUID().toString()).build().toString(), bytes, z);
        } catch (Exception e2) {
            js.g("__kiteerror " + e2.getMessage());
            jSONObjectZ = null;
        }
        return jSONObjectZ == null ? new JSONObject() : jSONObjectZ;
    }

    public static JSONObject z(Context context, String str, byte[] bArr, boolean z) {
        String strZ;
        try {
            if (o.gc()) {
                try {
                    strZ = r.z(context, str, bArr, null, false, false);
                } catch (RuntimeException e) {
                    js.a("__kite", "error " + e.getMessage());
                    strZ = r.z(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
            } else {
                try {
                    strZ = r.z(context, str, bArr, "application/json; charset=utf-8", false, true);
                } catch (Exception e2) {
                    js.a("__kite", "error " + e2.getMessage());
                    strZ = "";
                }
            }
        } catch (Exception e3) {
            js.a("__kite", "network error " + e3.getMessage());
            strZ = "";
        }
        try {
            return new JSONObject(strZ);
        } catch (Exception e4) {
            js.a("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
    }
}
