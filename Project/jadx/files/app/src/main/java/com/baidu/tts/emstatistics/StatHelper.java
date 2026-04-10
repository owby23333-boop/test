package com.baidu.tts.emstatistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.network.ResponseHandler;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.SharedPreferencesUtils;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StatHelper {
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_APP_PACKAGE_NAME = "app";
    private static final String KEY_CUID = "cuid";
    private static final String KEY_ENGINE_INFO = "perinfo";
    private static final String KEY_ENGINE_VERSION = "engine_version";
    private static final String KEY_FLOW = "flow";
    private static final String KEY_OS = "os";
    private static final String KEY_PLATFORM = "platform";
    private static final String KEY_RESPONSE_ERROR_CODE = "err_no";
    private static final String KEY_RESPONSE_EXPIRES = "expires";
    private static final String KEY_RESPONSE_TIME = "time";
    private static final String KEY_SDK_NAME = "sdk_name";
    private static final String KEY_SDK_VERSION = "sdkversion";
    private static final String KEY_SELFDLF = "selfDef";
    private static final String KEY_SHARE_STA_EXPIRES = "statistics_expires";
    private static final String KEY_SHARE_STA_TIME = "statistics_time";
    private static final String KEY_SIGN = "sign";
    private static final String TAG = "StatHelper";
    private static long period = 86400000;

    private static boolean doUploadStatData(Context context, String str) {
        boolean zUpdateDataByHttp;
        try {
            long j2 = SharedPreferencesUtils.getLong(context, "Success_Count", 0L);
            String str2 = j2 + "." + SharedPreferencesUtils.getLong(context, "Fail_Count", 0L);
            LoggerProxy.d(TAG, " postContent:" + str2);
            if (j2 < 1) {
                return false;
            }
            try {
                zUpdateDataByHttp = updateDataByHttp(context, str, str2);
            } catch (Error e2) {
                e2.toString();
                zUpdateDataByHttp = false;
            }
            Utility.setLastUploadStatTime(context, System.currentTimeMillis());
            LoggerProxy.d(TAG, "update ret: " + zUpdateDataByHttp);
            if (!zUpdateDataByHttp) {
                return false;
            }
            SharedPreferencesUtils.putLong(context, "Success_Count", 0L);
            SharedPreferencesUtils.putLong(context, "Fail_Count", 0L);
            return true;
        } catch (Exception e3) {
            LoggerProxy.d(TAG, "exception:" + e3.toString());
            return false;
        }
    }

    private static String getPostData(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        String strStringToMd5 = Utility.stringToMd5(str);
        String[] strArrSplit = EmbeddedSynthesizerEngine.bdTTSGetAESKEY().split(":");
        String strDecryptBASE64 = Utility.decryptBASE64(strArrSplit[0]);
        String strDecryptBASE642 = Utility.decryptBASE64(strArrSplit[1]);
        try {
            String string = SharedPreferencesUtils.getString(context, "offline_speechDatInfo", "");
            int engineVersion = SynthesizerTool.getEngineVersion();
            jSONObject.put(KEY_FLOW, str2);
            jSONObject.put(KEY_CUID, PersistentPool.getInstance().getDeviceId());
            jSONObject.put("sign", strStringToMd5);
            jSONObject.put(KEY_APP_PACKAGE_NAME, Utility.getPackageName(context));
            jSONObject.put("app_name", Utility.getAppName(context));
            jSONObject.put(KEY_SELFDLF, "android.etts");
            jSONObject.put(KEY_SDK_VERSION, Utility.getSdkVersion());
            jSONObject.put("platform", Utility.getPlatform(context));
            jSONObject.put(KEY_ENGINE_INFO, string);
            jSONObject.put("os", Utility.getOS());
            jSONObject.put(KEY_SDK_NAME, Utility.getSdkName());
            jSONObject.put(KEY_ENGINE_VERSION, engineVersion);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return CommonUtility.AES_cbc_encrypt(jSONObject.toString(), strDecryptBASE64, strDecryptBASE642);
    }

    private static boolean updateDataByHttp(final Context context, String str, String str2) {
        final boolean[] zArr = {false};
        String url = UrlEnum.STATISTICS_SERVER.getUrl();
        LoggerProxy.d(TAG, "statHelper url:" + url);
        new HttpClientUtil().post(url, getPostData(context, str, str2), new ResponseHandler() { // from class: com.baidu.tts.emstatistics.StatHelper.1
            @Override // com.baidu.tts.network.ResponseHandler
            public void onFailure(int i2, Map<String, List<String>> map, String str3, byte[] bArr, Throwable th) {
                LoggerProxy.d(StatHelper.TAG, " statusCode: " + i2 + " responseBody: " + bArr);
            }

            @Override // com.baidu.tts.network.ResponseHandler
            public void onSuccess(int i2, Map<String, List<String>> map, String str3, byte[] bArr) {
                String str4 = new String(bArr);
                LoggerProxy.d(StatHelper.TAG, " statusCode: " + i2 + " response=" + new String(bArr));
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    if ("0".equals(jSONObject.optString(StatHelper.KEY_RESPONSE_ERROR_CODE))) {
                        long jOptLong = jSONObject.optLong(StatHelper.KEY_RESPONSE_EXPIRES);
                        long jOptLong2 = jSONObject.optLong("time");
                        SharedPreferencesUtils.putLong(context, StatHelper.KEY_SHARE_STA_EXPIRES, jOptLong);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long j2 = jCurrentTimeMillis - jOptLong2;
                        if (j2 >= 60000 || j2 <= 0) {
                            SharedPreferencesUtils.putLong(context, StatHelper.KEY_SHARE_STA_TIME, jCurrentTimeMillis);
                        } else {
                            SharedPreferencesUtils.putLong(context, StatHelper.KEY_SHARE_STA_TIME, jOptLong2);
                        }
                        zArr[0] = true;
                        LoggerProxy.d(StatHelper.TAG, "ret=" + zArr[0]);
                    }
                } catch (JSONException e2) {
                    LoggerProxy.d(StatHelper.TAG, "parse:" + e2.toString());
                } catch (Exception e3) {
                    LoggerProxy.d(StatHelper.TAG, "parse:" + e3.toString());
                }
            }
        });
        return zArr[0];
    }

    public static synchronized void uploadStatDatas(Context context, String str) {
        if (Utility.isNetworkConnected(context)) {
            long lastUploadStatTime = Utility.getLastUploadStatTime(context);
            long j2 = SharedPreferencesUtils.getLong(context, KEY_SHARE_STA_TIME, 0L);
            long j3 = SharedPreferencesUtils.getLong(context, KEY_SHARE_STA_EXPIRES, 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - lastUploadStatTime < period) {
                Date date = new Date(lastUploadStatTime);
                Date date2 = new Date(jCurrentTimeMillis);
                LoggerProxy.d(TAG, "lastTime " + lastUploadStatTime + ", curTime " + System.currentTimeMillis());
                LoggerProxy.d(TAG, "lastDate " + date + "\ncurDate " + date2 + " staExpires: " + j3);
                return;
            }
            if (jCurrentTimeMillis - j2 > j3) {
                LoggerProxy.d(TAG, "updated " + doUploadStatData(context, str));
            }
        }
    }
}
