package com.baidu.tts.auth;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.emstatistics.Utility;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.tools.SharedPreferencesUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetTtsLicenseWork implements Callable<Integer> {
    private static final String TAG = "GetTtsLicenseWork";
    private String appCode;
    private String authSN;
    private String licenseFilePath;
    private Context mContext;

    public GetTtsLicenseWork(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.appCode = str;
        this.licenseFilePath = str2;
        this.authSN = str3;
    }

    private String getEntity() throws UnsupportedEncodingException {
        EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
        try {
            new HashMap();
            PersistentPool persistentPool = PersistentPool.getInstance();
            String deviceId = persistentPool.getDeviceId();
            Context context = persistentPool.getContext();
            String strStringToMd5 = Utility.stringToMd5(this.appCode + deviceId);
            int i2 = SharedPreferencesUtils.getInt(context, "getLicense_err_no");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KeyEnum.SERIAL_NUMBER.getShortName(), this.authSN);
            jSONObject.put(KeyEnum.CUID.getShortName(), deviceId);
            jSONObject.put(KeyEnum.SIGN.getShortName(), strStringToMd5);
            jSONObject.put(KeyEnum.ID.getShortName(), this.appCode);
            jSONObject.put(KeyEnum.APPNAME.getShortName(), Utility.getPackageName(context));
            jSONObject.put(KeyEnum.SELFDEF.getShortName(), "android.etts");
            jSONObject.put(KeyEnum.STA.getShortName(), Utility.getPlatform(context));
            jSONObject.put(KeyEnum.GETLICENSE_ERRNO.getShortName(), "" + i2);
            jSONObject.put(KeyEnum.VERSION.getAlias(), SpeechSynthesizer.VERSION_NAME);
            String string = jSONObject.toString();
            LoggerProxy.d(TAG, "getLicense params: " + string);
            return string;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        String str;
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String url = UrlEnum.GETLICENSE_SERVER.getUrl();
        boolean z2 = SharedPreferencesUtils.getBoolean(this.mContext, "isRegister", false);
        String string = SharedPreferencesUtils.getString(this.mContext, "SN", "");
        if (z2 && string.equals(this.authSN)) {
            str = url + "check?logid=" + System.currentTimeMillis();
        } else {
            str = url + "register?logid=" + System.currentTimeMillis();
        }
        LoggerProxy.d(TAG, " isRegister:" + z2 + "  getlicense url:" + str);
        GetLicenseHandler getLicenseHandler = new GetLicenseHandler(this.licenseFilePath, this.authSN);
        httpClientUtil.post(str, getEntity(), getLicenseHandler);
        return Integer.valueOf(getLicenseHandler.getStatusCode());
    }
}
