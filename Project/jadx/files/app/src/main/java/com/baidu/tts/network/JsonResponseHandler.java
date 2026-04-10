package com.baidu.tts.network;

import com.anythink.expressad.foundation.g.a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JsonResponseHandler extends ResponseHandler {
    private static final String TAG = "GetTtsLicenseWork";
    public static final String UTF8_BOM = "\ufeff";

    private static String getResponseString(byte[] bArr, String str) {
        String str2;
        if (bArr == null) {
            str2 = null;
        } else {
            try {
                str2 = new String(bArr, str);
            } catch (UnsupportedEncodingException e2) {
                LoggerProxy.e(TAG, "Encoding response into string failed" + e2.toString());
                return null;
            }
        }
        return (str2 == null || !str2.startsWith(UTF8_BOM)) ? str2 : str2.substring(1);
    }

    private JSONObject parseResponse(byte[] bArr) throws JSONException {
        String responseString;
        if (bArr == null || (responseString = getResponseString(bArr, a.bN)) == null) {
            return null;
        }
        return new JSONObject(responseString.trim());
    }

    public void onFailure(int i2, Map<String, List<String>> map, String str, Throwable th) {
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        if (bArr != null) {
            try {
                JSONObject response = parseResponse(bArr);
                if (response != null) {
                    onFailure(i2, map, th, response);
                } else {
                    onFailure(i2, map, new JSONException("Unexpected response type " + response.getClass().getName()), (JSONObject) null);
                }
            } catch (JSONException e2) {
                onFailure(i2, map, e2, (JSONObject) null);
            }
        }
    }

    public void onFailure(int i2, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
        try {
            JSONObject response = parseResponse(bArr);
            if (response != null) {
                onSuccess(i2, map, response);
            } else {
                onFailure(i2, map, new JSONException("Unexpected response type " + response.getClass().getName()), (JSONObject) null);
            }
        } catch (JSONException e2) {
            onFailure(i2, map, e2, (JSONObject) null);
            e2.printStackTrace();
        }
    }

    public void onSuccess(int i2, Map<String, List<String>> map, JSONObject jSONObject) {
    }
}
