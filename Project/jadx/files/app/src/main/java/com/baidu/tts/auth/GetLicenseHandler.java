package com.baidu.tts.auth;

import android.content.Context;
import com.anythink.expressad.foundation.g.a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.network.JsonResponseHandler;
import com.baidu.tts.tools.SharedPreferencesUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetLicenseHandler extends JsonResponseHandler {
    private static final String TAG = "GetLicenseHandler";
    private String mAuthSN;
    private String mLicenseFile;
    private int statusCode = -2;
    private String suffix = "_new";
    private Context mContext = PersistentPool.getInstance().getContext();

    public GetLicenseHandler(String str, String str2) {
        this.mLicenseFile = str;
        this.mAuthSN = str2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, Throwable th) {
        super.onFailure(i2, map, str, th);
        LoggerProxy.d(TAG, " statusCode: " + i2 + " responseString: " + str);
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, JSONObject jSONObject) throws Throwable {
        super.onSuccess(i2, map, jSONObject);
        LoggerProxy.d(TAG, "getLicense resopse=" + jSONObject.toString());
        int iOptInt = jSONObject.optInt(KeyEnum.ERROR_NUMBER.getShortName());
        this.statusCode = iOptInt;
        LoggerProxy.d(TAG, " onSuccess statusCode: " + i2 + " errNo: " + iOptInt);
        String strOptString = jSONObject.optString(KeyEnum.ERROR_MESSAGE.getShortName());
        long jOptLong = jSONObject.optLong("expires");
        long jOptLong2 = jSONObject.optLong("time");
        SharedPreferencesUtils.putLong(this.mContext, "getLicense_expires", jOptLong);
        SharedPreferencesUtils.putInt(this.mContext, "getLicense_err_no", iOptInt);
        SharedPreferencesUtils.putString(this.mContext, "SN", this.mAuthSN);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - jOptLong2;
        if (j2 >= 60000 || j2 <= 0) {
            SharedPreferencesUtils.putLong(this.mContext, "getLicense_time", jCurrentTimeMillis);
        } else {
            SharedPreferencesUtils.putLong(this.mContext, "getLicense_time", jOptLong2);
        }
        String strReplaceAll = jSONObject.optString("license").replaceAll("license_begin|license_end", "");
        if (iOptInt == 0 && !strReplaceAll.isEmpty()) {
            SharedPreferencesUtils.putBoolean(this.mContext, "isRegister", true);
            File file = new File(this.mLicenseFile);
            if (file.exists()) {
                File file2 = new File(this.mLicenseFile + this.suffix);
                LoggerProxy.d(TAG, "isSave=" + writeStringToFile(this.mLicenseFile + this.suffix, strReplaceAll));
                LoggerProxy.d(TAG, "isDelete=" + file.delete());
                LoggerProxy.d(TAG, "isRename=" + file2.renameTo(file));
            } else {
                LoggerProxy.d(TAG, "isSave=" + writeStringToFile(this.mLicenseFile, strReplaceAll));
            }
        }
        LoggerProxy.d(TAG, "getLicense statusCode: " + i2 + " err_msg: " + strOptString + " err_no: " + iOptInt);
    }

    public boolean writeStringToFile(String str, String str2) throws Throwable {
        if (str2 == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str2.getBytes(a.bN));
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } catch (Exception e3) {
                    fileOutputStream = fileOutputStream2;
                    e = e3;
                    LoggerProxy.d(TAG, "download license success, write file failed");
                    this.statusCode = -1010;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    @Override // com.baidu.tts.network.JsonResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        super.onFailure(i2, map, th, jSONObject);
        LoggerProxy.d(TAG, "getLicense statusCode: " + i2);
    }
}
