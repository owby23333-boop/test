package com.baidu.tts.tools.cuid.util_GP;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class CuidV3Bean {
    private static final String CUID_K1 = decodeKs(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, 101, 49, 107, 61});
    private static final String CUID_K2 = decodeKs(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final int CUID_VERSION = 3;
    private static final String I_EMPTY = "0";
    private static final String SELF_CUID_FILE_V3 = "libcuid_v3.so";
    private static final String UUID_KEY = "XL5g0WZAHpIaKspIHIHYg5k";
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static final String sFEncoded = "ZmxhZw==";
    private static final String sSEncoded = "c2Rr";
    private static final String sVEncoded = "dmVy";
    private String mDeviceId;
    private String mFlag;
    private int mSdkInt;
    private int mVersion = 3;

    CuidV3Bean() {
    }

    private static CuidV3Bean createCuidBean(Context context, String str) {
        String str2;
        CuidV3Bean cuidV3Bean = new CuidV3Bean();
        boolean z2 = Build.VERSION.SDK_INT < 23;
        String androidId = DeviceIdUtil.getAndroidId(context);
        if (z2) {
            String uUIDFromSetting = getUUIDFromSetting(context);
            if (TextUtils.isEmpty(uUIDFromSetting)) {
                uUIDFromSetting = UUID.randomUUID().toString();
                saveUUID(context, uUIDFromSetting);
            }
            str2 = androidId + uUIDFromSetting;
        } else {
            str2 = "com.baidu" + androidId;
        }
        cuidV3Bean.setDeviceId(MD5Util.toMd5(str2.getBytes(), true));
        cuidV3Bean.setFlag(str);
        cuidV3Bean.setSdkInt(Build.VERSION.SDK_INT);
        return cuidV3Bean;
    }

    static CuidV3Bean createFromEncryptedContent(String str) {
        return createFromJson(decryptCUIDInfo(str));
    }

    static CuidV3Bean createFromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(getBase64DecodeStr(sFEncoded), "0");
            String string = jSONObject.getString(getBase64DecodeStr(sDEncoded));
            int iOptInt = jSONObject.optInt(getBase64DecodeStr(sSEncoded), 0);
            if (!TextUtils.isEmpty(string)) {
                CuidV3Bean cuidV3Bean = new CuidV3Bean();
                cuidV3Bean.setDeviceId(string);
                cuidV3Bean.setFlag(strOptString);
                cuidV3Bean.setSdkInt(iOptInt);
                return cuidV3Bean;
            }
        } catch (JSONException e2) {
            DeviceIdUtil.handleThrowable(e2);
        }
        return null;
    }

    static CuidV3Bean createFromV2Bean(CuidV2Bean cuidV2Bean) {
        if (cuidV2Bean == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        CuidV3Bean cuidV3Bean = new CuidV3Bean();
        cuidV3Bean.setDeviceId(cuidV2Bean.getDeviceId());
        cuidV3Bean.setFlag(cuidV2Bean.getFlag());
        return cuidV3Bean;
    }

    static CuidV3Bean createFromV3Storage(Context context) {
        File storageFile = getStorageFile(context);
        if (storageFile.exists()) {
            return createFromEncryptedContent(DeviceIdUtil.getFileContent(storageFile));
        }
        return null;
    }

    private static String decodeKs(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(Base64.decode(bArr2)));
        }
        return sb.toString();
    }

    static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(CUID_K1, CUID_K2, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            DeviceIdUtil.handleThrowable(e2);
            return "";
        }
    }

    static String decryptUUID(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(CUID_K2, CUID_K1, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            DeviceIdUtil.handleThrowable(e2);
            return "";
        }
    }

    static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(CUID_K1, CUID_K2, str.getBytes()), a.bN);
        } catch (UnsupportedEncodingException e2) {
            DeviceIdUtil.handleThrowable(e2);
            return "";
        } catch (Exception e3) {
            DeviceIdUtil.handleThrowable(e3);
            return "";
        }
    }

    static String encryptUUID(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(CUID_K2, CUID_K1, str.getBytes()), a.bN);
        } catch (UnsupportedEncodingException e2) {
            DeviceIdUtil.handleThrowable(e2);
            return "";
        } catch (Exception e3) {
            DeviceIdUtil.handleThrowable(e3);
            return "";
        }
    }

    static CuidV3Bean generate(Context context, String str) {
        return createCuidBean(context, str);
    }

    static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    private static File getStorageFile(Context context) {
        return new File(context.getFilesDir(), SELF_CUID_FILE_V3);
    }

    private static String getUUIDFromSetting(Context context) {
        return decryptUUID(DeviceIdUtil.getSystemSettingValue(context, UUID_KEY));
    }

    private static void saveUUID(Context context, String str) {
        if (TextUtils.isEmpty(DeviceIdUtil.getSystemSettingValue(context, UUID_KEY)) && DeviceIdUtil.hasWriteSettingsPermission(context)) {
            DeviceIdUtil.tryPutSystemSettingValue(context, UUID_KEY, encryptUUID(str));
        }
    }

    private String toPersistString() {
        try {
            return new JSONObject().put(getBase64DecodeStr(sDEncoded), this.mDeviceId).put(getBase64DecodeStr(sFEncoded), this.mFlag == null ? "0" : this.mFlag).put(getBase64DecodeStr(sVEncoded), this.mVersion).put(getBase64DecodeStr(sSEncoded), this.mSdkInt).toString();
        } catch (JSONException e2) {
            DeviceIdUtil.handleThrowable(e2);
            return null;
        }
    }

    private boolean writeToCuidV3File(Context context) {
        String strEncryptCUIDInfo = encryptCUIDInfo(toPersistString());
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = context.openFileOutput(SELF_CUID_FILE_V3, 0);
                fileOutputStreamOpenFileOutput.write(strEncryptCUIDInfo.getBytes());
                fileOutputStreamOpenFileOutput.flush();
                if (fileOutputStreamOpenFileOutput == null) {
                    return true;
                }
                try {
                    fileOutputStreamOpenFileOutput.close();
                    return true;
                } catch (Exception e2) {
                    DeviceIdUtil.handleThrowable(e2);
                    return true;
                }
            } catch (Exception e3) {
                DeviceIdUtil.handleThrowable(e3);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e4) {
                        DeviceIdUtil.handleThrowable(e4);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e5) {
                    DeviceIdUtil.handleThrowable(e5);
                }
            }
            throw th;
        }
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getFinalCUID() {
        if (TextUtils.isEmpty(this.mFlag)) {
            this.mFlag = "0";
        }
        return this.mDeviceId + a.bQ + this.mFlag;
    }

    public String getFlag() {
        return this.mFlag;
    }

    public int getSdkInt() {
        return this.mSdkInt;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setFlag(String str) {
        this.mFlag = str;
    }

    public void setSdkInt(int i2) {
        this.mSdkInt = i2;
    }

    public void setVersion(int i2) {
        this.mVersion = i2;
    }

    boolean store(Context context) {
        return writeToCuidV3File(context);
    }
}
