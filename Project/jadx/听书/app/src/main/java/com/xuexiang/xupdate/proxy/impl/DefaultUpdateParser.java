package com.xuexiang.xupdate.proxy.impl;

import android.text.TextUtils;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.utils.UpdateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultUpdateParser extends AbstractUpdateParser {

    public interface APIConstant {
        public static final int HAVE_NEW_VERSION = 1;
        public static final int HAVE_NEW_VERSION_FORCED_UPDATE = 2;
        public static final int HAVE_NEW_VERSION_IGNORE_UPDATE = 3;
        public static final int NO_NEW_VERSION = 0;
        public static final int REQUEST_SUCCESS = 0;
    }

    public interface APIKeyLower {
        public static final String APK_MD5 = "apkMd5";
        public static final String APK_SIZE = "apkSize";
        public static final String CODE = "code";
        public static final String DOWNLOAD_URL = "downloadUrl";
        public static final String MODIFY_CONTENT = "modifyContent";
        public static final String UPDATE_STATUS = "updateStatus";
        public static final String VERSION_CODE = "versionCode";
        public static final String VERSION_NAME = "versionName";
    }

    public interface APIKeyUpper {
        public static final String APK_MD5 = "ApkMd5";
        public static final String APK_SIZE = "ApkSize";
        public static final String CODE = "Code";
        public static final String DOWNLOAD_URL = "DownloadUrl";
        public static final String MODIFY_CONTENT = "ModifyContent";
        public static final String UPDATE_STATUS = "UpdateStatus";
        public static final String VERSION_CODE = "VersionCode";
        public static final String VERSION_NAME = "VersionName";
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateParser
    public UpdateEntity parseJson(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(APIKeyUpper.CODE)) {
            return parseDefaultUpperFormatJson(jSONObject);
        }
        return parseDefaultLowerFormatJson(jSONObject);
    }

    private UpdateEntity parseDefaultUpperFormatJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt(APIKeyUpper.CODE) != 0) {
            return null;
        }
        int i = jSONObject.getInt(APIKeyUpper.VERSION_CODE);
        String strOptString = jSONObject.optString(APIKeyUpper.VERSION_NAME);
        int iCheckUpdateStatus = checkUpdateStatus(jSONObject.getInt(APIKeyUpper.UPDATE_STATUS), i, strOptString);
        UpdateEntity updateEntity = new UpdateEntity();
        if (iCheckUpdateStatus == 0) {
            updateEntity.setHasUpdate(false);
        } else {
            if (iCheckUpdateStatus == 2) {
                updateEntity.setForce(true);
            } else if (iCheckUpdateStatus == 3) {
                updateEntity.setIsIgnorable(true);
            }
            updateEntity.setHasUpdate(true).setUpdateContent(jSONObject.getString(APIKeyUpper.MODIFY_CONTENT)).setVersionCode(i).setVersionName(strOptString).setDownloadUrl(jSONObject.getString(APIKeyUpper.DOWNLOAD_URL)).setSize(jSONObject.optLong(APIKeyUpper.APK_SIZE)).setMd5(jSONObject.optString(APIKeyUpper.APK_MD5));
        }
        return updateEntity;
    }

    private UpdateEntity parseDefaultLowerFormatJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt("code") != 0) {
            return null;
        }
        int i = jSONObject.getInt(APIKeyLower.VERSION_CODE);
        String strOptString = jSONObject.optString(APIKeyLower.VERSION_NAME);
        int iCheckUpdateStatus = checkUpdateStatus(jSONObject.getInt(APIKeyLower.UPDATE_STATUS), i, strOptString);
        UpdateEntity updateEntity = new UpdateEntity();
        if (iCheckUpdateStatus == 0) {
            updateEntity.setHasUpdate(false);
        } else {
            if (iCheckUpdateStatus == 2) {
                updateEntity.setForce(true);
            } else if (iCheckUpdateStatus == 3) {
                updateEntity.setIsIgnorable(true);
            }
            updateEntity.setHasUpdate(true).setUpdateContent(jSONObject.getString(APIKeyLower.MODIFY_CONTENT)).setVersionCode(i).setVersionName(strOptString).setDownloadUrl(jSONObject.getString(APIKeyLower.DOWNLOAD_URL)).setSize(jSONObject.optLong(APIKeyLower.APK_SIZE)).setMd5(jSONObject.optString(APIKeyLower.APK_MD5));
        }
        return updateEntity;
    }

    protected int checkUpdateStatus(int i, int i2, String str) {
        int versionCode;
        if (i == 0 || i2 > (versionCode = UpdateUtils.getVersionCode(XUpdate.getContext()))) {
            return i;
        }
        UpdateLog.i("云端获取的最新版本小于等于应用当前的版本，不需要更新！当前版本:" + versionCode + ", 云端版本:" + i2);
        return 0;
    }
}
