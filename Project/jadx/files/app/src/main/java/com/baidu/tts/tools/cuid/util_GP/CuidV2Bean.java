package com.baidu.tts.tools.cuid.util_GP;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
final class CuidV2Bean {
    private static final String AES_KEY = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final int CUID_VERSION = 2;
    private static final String I_EMPTY = "0";
    private static final String I_FIXED = "O";
    private static final int PROTOCAL_MAX_LENGTH = 14;
    private static final String SELF_CUID_FILE_V2 = "libcuid.so";
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static final String sVEncoded = "dmVy";
    private String mDeviceId;
    private String mFlag;
    private int oldValueLength = 0;
    private int mVersion = 2;

    CuidV2Bean() {
    }

    static CuidV2Bean createFromEncryptedContent(String str) {
        return createFromJson(decryptCUIDInfo(str));
    }

    static CuidV2Bean createFromJson(String str) throws Throwable {
        JsonReader jsonReader;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jsonReader = new JsonReader(new StringReader(str));
        } catch (IOException unused) {
            jsonReader = null;
        } catch (Throwable th) {
            th = th;
            jsonReader = null;
        }
        try {
            jsonReader.beginObject();
            String base64DecodeStr = getBase64DecodeStr(sDEncoded);
            String base64DecodeStr2 = getBase64DecodeStr(sVEncoded);
            String strNextString = "";
            String strNextString2 = "0";
            int iNextInt = 2;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (base64DecodeStr.equals(strNextName)) {
                    strNextString = jsonReader.nextString();
                } else if (base64DecodeStr2.equals(strNextName)) {
                    iNextInt = jsonReader.nextInt();
                } else {
                    strNextString2 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            int length = 0;
            if (iNextInt == 2 && !TextUtils.isEmpty(strNextString2)) {
                length = strNextString2.length();
            }
            try {
                jsonReader.close();
            } catch (Exception e2) {
                DeviceIdUtil.handleThrowable(e2);
            }
            if (TextUtils.isEmpty(strNextString)) {
                return null;
            }
            CuidV2Bean cuidV2Bean = new CuidV2Bean();
            cuidV2Bean.setDeviceId(strNextString);
            cuidV2Bean.setOldValueLength(length);
            if (!cuidV2Bean.isNormal()) {
                cuidV2Bean.setFlag(strNextString2);
            }
            return cuidV2Bean;
        } catch (IOException unused2) {
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (Exception e3) {
                    DeviceIdUtil.handleThrowable(e3);
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (Exception e4) {
                    DeviceIdUtil.handleThrowable(e4);
                }
            }
            throw th;
        }
    }

    static CuidV2Bean createFromV2Storage(Context context) {
        return createFromEncryptedContent(DeviceIdUtil.getFileContent(getStorageFile(context)));
    }

    private static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            DeviceIdUtil.handleThrowable(e2);
            return "";
        }
    }

    static boolean deleteIfNeed(Context context) {
        File storageFile = getStorageFile(context);
        if (storageFile.exists()) {
            return storageFile.delete();
        }
        return false;
    }

    private static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    private static File getStorageFile(Context context) {
        return new File(context.getFilesDir(), SELF_CUID_FILE_V2);
    }

    public static boolean isIENormal(int i2) {
        return i2 >= 14;
    }

    boolean fixCuid() {
        if (isNormal()) {
            this.mFlag = "O";
            return true;
        }
        if (!isIENull()) {
            return false;
        }
        this.mFlag = "0";
        return true;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getFlag() {
        return this.mFlag;
    }

    public int getOldValueLength() {
        return this.oldValueLength;
    }

    public boolean isIENull() {
        return isIENull(this.mFlag);
    }

    public boolean isNormal() {
        return isIENormal(this.oldValueLength);
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setFlag(String str) {
        this.mFlag = str;
    }

    public void setOldValueLength(int i2) {
        this.oldValueLength = i2;
    }

    public static boolean isIENull(String str) {
        return TextUtils.isEmpty(str);
    }
}
