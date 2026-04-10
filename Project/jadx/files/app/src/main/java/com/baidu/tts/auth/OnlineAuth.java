package com.baidu.tts.auth;

import android.text.TextUtils;
import com.anythink.expressad.exoplayer.b;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.memorizer.IMResult;
import com.baidu.tts.memorizer.IMemorizable;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.network.ResponseHandler;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.StringTool;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineAuth implements IMemorizable<OnlineAuth, OnlineResult> {
    private static final String NAME_ACCESS_TOKEN = "access_token";
    private static final String NAME_EXPIRES_IN = "expires_in";
    private static final String OPENAPI_GET_TOKEN_URL = "://openapi.baidu.com/oauth/2.0/token";
    private static final String TAG = "OnlineAuth";
    private String mApiKey;
    private String mProductId;
    private String mRequestProtocol = "https";
    private String mSecretKey;

    public static class OnlineResult implements IMResult {
        private String mAccessToken;
        private TtsError mError;
        private String mProductId;
        private long mTokenExpireTime;

        public String getAccessToken() {
            return this.mAccessToken;
        }

        public TtsError getError() {
            return this.mError;
        }

        public String getProductId() {
            return this.mProductId;
        }

        public long getTokenExpireTime() {
            return this.mTokenExpireTime;
        }

        @Override // com.baidu.tts.memorizer.IMResult
        public boolean isValid() {
            return !StringTool.isEmpty(this.mProductId) || (this.mAccessToken != null && System.currentTimeMillis() < this.mTokenExpireTime);
        }

        public void setAccessToken(String str) {
            this.mAccessToken = str;
        }

        public void setError(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.d(OnlineAuth.TAG, "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.mError = ttsError;
        }

        public void setProductId(String str) {
            this.mProductId = str;
        }

        public void setTokenExpireTime(long j2) {
            this.mTokenExpireTime = j2;
        }
    }

    private String buildGetTokenUrl(String str, String str2, String str3) {
        String strUrlEncoded;
        HashMap map = new HashMap();
        map.put("grant_type", "client_credentials");
        map.put("client_id", str);
        map.put("client_secret", str2);
        try {
            strUrlEncoded = CommonUtility.urlEncoded(map);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            strUrlEncoded = null;
        }
        return (str3 + OPENAPI_GET_TOKEN_URL + "?") + strUrlEncoded;
    }

    private boolean isValidKey(String str, String str2) {
        return (StringTool.isEmpty(str) || StringTool.isEmpty(str2)) ? false : true;
    }

    public String getApiKey() {
        return this.mApiKey;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getRequestProtocol() {
        return this.mRequestProtocol;
    }

    public String getSecretKey() {
        return this.mSecretKey;
    }

    public void setApiKey(String str) {
        this.mApiKey = str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setRequestProtocol(String str) {
        this.mRequestProtocol = str;
    }

    public void setSecretKey(String str) {
        this.mSecretKey = str;
    }

    @Override // java.util.concurrent.Callable
    public OnlineResult call() throws Exception {
        LoggerProxy.d(TAG, "enter online auth");
        final OnlineResult onlineResult = new OnlineResult();
        if (StringTool.isEmpty(this.mProductId)) {
            try {
                if (isValidKey(this.mApiKey, this.mSecretKey)) {
                    String strBuildGetTokenUrl = buildGetTokenUrl(this.mApiKey, this.mSecretKey, this.mRequestProtocol);
                    LoggerProxy.d(TAG, "url=" + strBuildGetTokenUrl);
                    new HttpClientUtil().post(strBuildGetTokenUrl, "", new ResponseHandler() { // from class: com.baidu.tts.auth.OnlineAuth.1
                        @Override // com.baidu.tts.network.ResponseHandler
                        public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
                            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_AUTH_FAILURE));
                        }

                        @Override // com.baidu.tts.network.ResponseHandler
                        public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
                            String str2 = new String(bArr);
                            LoggerProxy.d(OnlineAuth.TAG, "body=" + str2 + "--code=" + i2);
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.has(OnlineAuth.NAME_ACCESS_TOKEN)) {
                                    onlineResult.setAccessToken(jSONObject.getString(OnlineAuth.NAME_ACCESS_TOKEN));
                                } else {
                                    onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_AUTH_FAILURE));
                                }
                                if (jSONObject.has(OnlineAuth.NAME_EXPIRES_IN)) {
                                    onlineResult.setTokenExpireTime(System.nanoTime() + (Math.min(jSONObject.getInt(OnlineAuth.NAME_EXPIRES_IN), 86400L) * b.f8486h));
                                }
                            } catch (JSONException e2) {
                                LoggerProxy.d(OnlineAuth.TAG, "parse:" + e2.toString());
                            } catch (Exception e3) {
                                LoggerProxy.d(OnlineAuth.TAG, "parse:" + e3.toString());
                            }
                        }
                    });
                } else {
                    onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.TTS_PARAMETER_INVALID));
                }
            } catch (Exception e2) {
                onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_AUTH_FAILURE, e2));
            }
        } else {
            onlineResult.setProductId(this.mProductId);
        }
        LoggerProxy.d(TAG, "end online auth");
        return onlineResult;
    }

    @Override // java.lang.Comparable
    public int compareTo(OnlineAuth onlineAuth) {
        String productId = onlineAuth.getProductId();
        if (!StringTool.isEmpty(this.mProductId)) {
            LoggerProxy.d(TAG, "mProductId=" + this.mProductId + "--productId2=" + productId);
            if (productId == null) {
                return 1;
            }
            return this.mProductId.compareTo(productId);
        }
        String apiKey = onlineAuth.getApiKey();
        String secretKey = onlineAuth.getSecretKey();
        LoggerProxy.d(TAG, "mAK=" + this.mApiKey + "--mSK=" + this.mSecretKey + "--ak2=" + apiKey + "--sk2=" + secretKey);
        return (StringTool.isEqual(this.mApiKey, apiKey) && StringTool.isEqual(this.mSecretKey, secretKey)) ? 0 : 1;
    }
}
