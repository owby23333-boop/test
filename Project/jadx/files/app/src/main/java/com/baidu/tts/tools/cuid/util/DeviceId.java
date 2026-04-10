package com.baidu.tts.tools.cuid.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import com.baidu.tts.tools.cuid.security.AESUtil;
import com.baidu.tts.tools.cuid.security.Base64;
import com.baidu.tts.tools.cuid.security.MD5Util;
import com.baidu.tts.tools.cuid.security.SHA1Util;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final boolean CONFIG_WRITE_V1_STORAGE = false;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_FLAG = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final int S_IRGRP = 32;
    private static final int S_IROTH = 4;
    private static final int S_IRUSR = 256;
    private static final int S_IRWXG = 56;
    private static final int S_IRWXO = 7;
    private static final int S_IRWXU = 448;
    private static final int S_IWGRP = 16;
    private static final int S_IWOTH = 2;
    private static final int S_IWUSR = 128;
    private static final int S_IXGRP = 8;
    private static final int S_IXOTH = 1;
    private static final int S_IXUSR = 64;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo = null;
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static boolean sDataCuidInfoShable = true;
    private static final String sIEncoded = "aW1laQ==";
    private static final String sVEncoded = "dmVy";
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    private static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }

    private static class CUIDInfo {
        public static final String I_EMPTY = "0";
        public static final String I_FIXED = "O";
        public static final int PROTOCAL_MAX_LENGTH = 14;
        private static final int VERSION_DEF = 2;
        public String deviceId;
        public String flag;
        public int oldValueLength;
        public int version;

        private CUIDInfo() {
            this.version = 2;
            this.oldValueLength = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CUIDInfo createCuidInfoFromV1Cache(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            CUIDInfo cUIDInfo = new CUIDInfo();
            cUIDInfo.deviceId = str;
            cUIDInfo.oldValueLength = TextUtils.isEmpty(str2) ? 0 : str2.length();
            if (cUIDInfo.oldValueLength < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                cUIDInfo.flag = str2;
            }
            return cUIDInfo;
        }

        public static CUIDInfo createFromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                String str2 = "0";
                String strOptString = "0";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!DeviceId.getBase64DecodeStr(DeviceId.sDEncoded).equals(next) && !DeviceId.getBase64DecodeStr(DeviceId.sVEncoded).equals(next)) {
                        strOptString = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded));
                int i2 = jSONObject.getInt(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded));
                int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
                if (!TextUtils.isEmpty(string)) {
                    CUIDInfo cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = string;
                    cUIDInfo.version = i2;
                    cUIDInfo.oldValueLength = length;
                    if (cUIDInfo.oldValueLength < 14) {
                        if (!TextUtils.isEmpty(strOptString)) {
                            str2 = strOptString;
                        }
                        cUIDInfo.flag = str2;
                    }
                    return cUIDInfo;
                }
            } catch (JSONException e2) {
                DeviceId.handleThrowable(e2);
            }
            return null;
        }

        public static boolean isIENormal(int i2) {
            return i2 >= 14;
        }

        public String getFinalCUID() {
            String str = this.flag;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.deviceId + a.bQ + str;
        }

        public boolean isIENormal() {
            return isIENormal(this.oldValueLength);
        }

        public boolean isIENull() {
            return isIENull(this.flag);
        }

        public String toPersitString() {
            try {
                return new JSONObject().put(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded), this.deviceId).put(DeviceId.getBase64DecodeStr(DeviceId.sIEncoded), this.flag).put(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded), this.version).toString();
            } catch (JSONException e2) {
                DeviceId.handleThrowable(e2);
                return null;
            }
        }

        public static boolean isIENull(String str) {
            return TextUtils.isEmpty(str);
        }
    }

    static class TargetApiSupport {
        TargetApiSupport() {
        }

        static boolean doChmodSafely(String str, int i2) {
            try {
                Os.chmod(str, i2);
                return true;
            } catch (ErrnoException e2) {
                DeviceId.handleThrowable(e2);
                return false;
            } catch (Exception e3) {
                DeviceId.handleThrowable(e3);
                return false;
            }
        }
    }

    private DeviceId(Context context) throws Throwable {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private List<CUIDBuddyInfo> collectBuddyInfos(Intent intent, boolean z2) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString(META_KEY_GLAXY_DATA);
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrDecode = Base64.decode(string.getBytes(a.bN));
                                JSONObject jSONObject = new JSONObject(new String(bArrDecode));
                                CUIDBuddyInfo cUIDBuddyInfo = new CUIDBuddyInfo();
                                cUIDBuddyInfo.priority = jSONObject.getInt("priority");
                                cUIDBuddyInfo.appInfo = resolveInfo.activityInfo.applicationInfo;
                                if (this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cUIDBuddyInfo.isSelf = true;
                                }
                                if (z2) {
                                    String string2 = bundle.getString(META_KEY_GALAXY_SF);
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i2 = 0; i2 < strArr.length; i2++) {
                                            strArr[i2] = jSONArray.getString(i2);
                                        }
                                        if (isSigsEqual(strArr, formatAndroidSigArray(packageInfo.signatures))) {
                                            byte[] bArrDecryptByPublicKey = decryptByPublicKey(Base64.decode(string2.getBytes()), this.mPublicKey);
                                            if (bArrDecryptByPublicKey != null && Arrays.equals(bArrDecryptByPublicKey, SHA1Util.sha1(bArrDecode))) {
                                                cUIDBuddyInfo.sigMatched = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cUIDBuddyInfo);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<CUIDBuddyInfo>() { // from class: com.baidu.tts.tools.cuid.util.DeviceId.1
            @Override // java.util.Comparator
            public int compare(CUIDBuddyInfo cUIDBuddyInfo2, CUIDBuddyInfo cUIDBuddyInfo3) {
                int i3 = cUIDBuddyInfo3.priority - cUIDBuddyInfo2.priority;
                if (i3 == 0) {
                    if (cUIDBuddyInfo2.isSelf && cUIDBuddyInfo3.isSelf) {
                        return 0;
                    }
                    if (cUIDBuddyInfo2.isSelf) {
                        return -1;
                    }
                    if (cUIDBuddyInfo3.isSelf) {
                        return 1;
                    }
                }
                return i3;
            }
        });
        return arrayList;
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            handleThrowable(e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, str.getBytes()), a.bN);
        } catch (UnsupportedEncodingException e2) {
            handleThrowable(e2);
            return "";
        } catch (Exception e3) {
            handleThrowable(e3);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fixCUIDInfoByIE(CUIDInfo cUIDInfo) {
        if (cUIDInfo.isIENormal()) {
            cUIDInfo.flag = CUIDInfo.I_FIXED;
            return true;
        }
        if (!cUIDInfo.isIENull()) {
            return false;
        }
        cUIDInfo.flag = "0";
        return true;
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = byte2hex(SHA1Util.sha1(signatureArr[i2].toByteArray()));
        }
        return strArr;
    }

    private static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private CUIDInfo getCUIDInfo() throws Throwable {
        boolean z2;
        String defaultFlag;
        List<CUIDBuddyInfo> listCollectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        boolean z3 = false;
        if (listCollectBuddyInfos == null || listCollectBuddyInfos.size() == 0) {
            for (int i2 = 0; i2 < 3; i2++) {
            }
            z2 = false;
        } else {
            z2 = listCollectBuddyInfos.get(0).sigMatched;
            if (!z2) {
                for (int i3 = 0; i3 < 3; i3++) {
                }
            }
        }
        File file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        CUIDInfo cUIDInfoCreateFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 16;
            List<CUIDBuddyInfo> listCollectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z2);
            if (listCollectBuddyInfos2 != null) {
                String name = "files";
                File filesDir = this.mContext.getFilesDir();
                if (!"files".equals(filesDir.getName())) {
                    String str = "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath();
                    name = filesDir.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo : listCollectBuddyInfos2) {
                    if (!cUIDBuddyInfo.isSelf) {
                        File file2 = new File(new File(cUIDBuddyInfo.appInfo.dataDir, name), SELF_CUID_FILE);
                        if (file2.exists() && (cUIDInfoCreateFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (cUIDInfoCreateFromJson == null) {
            cUIDInfoCreateFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        boolean zCheckSelfPermission = checkSelfPermission(g.f16729i);
        if (cUIDInfoCreateFromJson == null && zCheckSelfPermission) {
            this.mSaveMask |= 2;
            cUIDInfoCreateFromJson = getCuidInfoFromExternalV2();
        }
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 8;
            cUIDInfoCreateFromJson = getCUidInfoFromSystemSettingV1();
        }
        if (cUIDInfoCreateFromJson == null && zCheckSelfPermission) {
            this.mSaveMask |= 1;
            defaultFlag = getDefaultFlag("");
            cUIDInfoCreateFromJson = getExternalV1DeviceId(defaultFlag);
            z3 = true;
        } else {
            defaultFlag = null;
        }
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 4;
            if (!z3) {
                defaultFlag = getDefaultFlag("");
            }
            cUIDInfoCreateFromJson = new CUIDInfo();
            String androidId = getAndroidId(this.mContext);
            cUIDInfoCreateFromJson.deviceId = MD5Util.toMd5((Build.VERSION.SDK_INT < 23 ? defaultFlag + androidId + UUID.randomUUID().toString() : "com.baidu" + androidId).getBytes(), true);
            cUIDInfoCreateFromJson.flag = defaultFlag;
        }
        fixCUIDInfoByIE(cUIDInfoCreateFromJson);
        writeJobThread(cUIDInfoCreateFromJson);
        return cUIDInfoCreateFromJson;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        return CUIDInfo.createCuidInfoFromV1Cache(getSystemSettingValue(KEY_DEVICE_ID), getSystemSettingValue(KEY_FLAG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getCuidInfoFromExternalV2() throws Throwable {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (!file.exists()) {
            return null;
        }
        String fileContent = getFileContent(file);
        if (TextUtils.isEmpty(fileContent)) {
            return null;
        }
        try {
            return CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(fileContent.getBytes()))));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDefaultFlag(String str) {
        return "0";
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getExternalV1DeviceId(String str) {
        String str2;
        BufferedReader bufferedReader;
        StringBuilder sb;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            sb = new StringBuilder();
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append("\r\n");
            str2 = "";
            return CUIDInfo.createCuidInfoFromV1Cache(str3, str2);
        }
        bufferedReader.close();
        String[] strArrSplit = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(sb.toString().getBytes()))).split("=");
        if (strArrSplit == null || strArrSplit.length != 2) {
            str2 = "";
        } else {
            str2 = strArrSplit[0];
            try {
                str3 = strArrSplit[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
        }
        return CUIDInfo.createCuidInfoFromV1Cache(str3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFileContent(File file) throws Throwable {
        FileReader fileReader;
        char[] cArr;
        CharArrayWriter charArrayWriter;
        try {
            fileReader = new FileReader(file);
        } catch (Exception e2) {
            e = e2;
            fileReader = null;
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            try {
                cArr = new char[8192];
                charArrayWriter = new CharArrayWriter();
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                int i2 = fileReader.read(cArr);
                if (i2 <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, i2);
                th = th2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                        handleThrowable(e3);
                    }
                }
                throw th;
            }
            String string = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Exception e4) {
                handleThrowable(e4);
            }
            return string;
        } catch (Exception e5) {
            e = e5;
            handleThrowable(e);
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e6) {
                    handleThrowable(e6);
                }
            }
            return null;
        }
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CUIDInfo.class) {
                if (sCachedCuidInfo == null) {
                    SystemClock.uptimeMillis();
                    sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return sCachedCuidInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSystemSettingValue(String str) {
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), str);
        } catch (Exception e2) {
            handleThrowable(e2);
            return null;
        }
    }

    private Runnable getWriteRunnable(final CUIDInfo cUIDInfo) {
        return new Runnable() { // from class: com.baidu.tts.tools.cuid.util.DeviceId.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                CUIDInfo cUIDInfo2 = new CUIDInfo();
                CUIDInfo cUIDInfo3 = cUIDInfo;
                cUIDInfo2.flag = cUIDInfo3.flag;
                cUIDInfo2.deviceId = cUIDInfo3.deviceId;
                File file = new File(DeviceId.this.mContext.getFilesDir(), DeviceId.SELF_CUID_FILE);
                String strEncryptCUIDInfo = DeviceId.encryptCUIDInfo(cUIDInfo2.toPersitString());
                if (file.exists()) {
                    CUIDInfo cUIDInfoCreateFromJson = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(DeviceId.getFileContent(file)));
                    if (cUIDInfoCreateFromJson != null) {
                        if (DeviceId.this.fixCUIDInfoByIE(cUIDInfoCreateFromJson)) {
                            DeviceId.this.writeToCuidFile(DeviceId.encryptCUIDInfo(cUIDInfoCreateFromJson.toPersitString()));
                        }
                    } else if (cUIDInfoCreateFromJson == null) {
                        DeviceId.this.writeToCuidFile(strEncryptCUIDInfo);
                    }
                } else {
                    DeviceId.this.writeToCuidFile(strEncryptCUIDInfo);
                }
                boolean zHasWriteSettingsPermission = DeviceId.this.hasWriteSettingsPermission();
                if (zHasWriteSettingsPermission) {
                    String systemSettingValue = DeviceId.this.getSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2);
                    if (TextUtils.isEmpty(systemSettingValue)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, strEncryptCUIDInfo);
                    } else {
                        CUIDInfo cUIDInfoCreateFromJson2 = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(systemSettingValue));
                        if (cUIDInfoCreateFromJson2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cUIDInfoCreateFromJson2)) {
                                DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, DeviceId.encryptCUIDInfo(cUIDInfoCreateFromJson2.toPersitString()));
                            }
                        } else if (cUIDInfoCreateFromJson2 == null) {
                            DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, strEncryptCUIDInfo);
                        }
                    }
                }
                boolean zCheckSelfPermission = DeviceId.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                if (zCheckSelfPermission) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        CUIDInfo cuidInfoFromExternalV2 = DeviceId.this.getCuidInfoFromExternalV2();
                        if (cuidInfoFromExternalV2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cuidInfoFromExternalV2)) {
                                DeviceId.setExternalV2DeviceId(DeviceId.encryptCUIDInfo(cuidInfoFromExternalV2.toPersitString()));
                            }
                        } else if (cuidInfoFromExternalV2 == null) {
                            DeviceId.setExternalV2DeviceId(strEncryptCUIDInfo);
                        }
                    } else {
                        DeviceId.setExternalV2DeviceId(strEncryptCUIDInfo);
                    }
                }
                if (zHasWriteSettingsPermission) {
                    String systemSettingValue2 = DeviceId.this.getSystemSettingValue(DeviceId.KEY_FLAG);
                    if (CUIDInfo.isIENormal(TextUtils.isEmpty(systemSettingValue2) ? 0 : systemSettingValue2.length())) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, CUIDInfo.I_FIXED);
                    } else if (CUIDInfo.isIENull(systemSettingValue2)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, "0");
                    }
                }
                if (zCheckSelfPermission && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
                    CUIDInfo externalV1DeviceId = DeviceId.this.getExternalV1DeviceId(DeviceId.this.getDefaultFlag(""));
                    if (externalV1DeviceId == null || !DeviceId.this.fixCUIDInfoByIE(externalV1DeviceId)) {
                        return;
                    }
                    DeviceId.setExternalDeviceId(externalV1DeviceId.flag, externalV1DeviceId.deviceId);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleThrowable(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    private void initPublicKey() throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(CuidCertStore.getCertBytes());
            } catch (Exception unused) {
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                byteArrayInputStream = null;
                th = th2;
            }
            try {
                this.mPublicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                byteArrayInputStream.close();
            } catch (Exception unused2) {
                if (byteArrayInputStream == null) {
                } else {
                    byteArrayInputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                        handleThrowable(e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            handleThrowable(e3);
        }
    }

    private boolean isSigsEqual(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static void setCuidDataShable(Context context, boolean z2) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        Context applicationContext = context.getApplicationContext();
        if (file.exists() && (sCachedCuidInfo == null || sDataCuidInfoShable != z2)) {
            tryToModifyChmodForSelfFile(applicationContext, z2);
        }
        sDataCuidInfoShable = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalDeviceId(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, (str + "=" + str2).getBytes()), a.bN));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalV2DeviceId(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE_V2);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return Settings.System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Exception e2) {
            handleThrowable(e2);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean tryToModifyChmodForSelfFile(Context context, boolean z2) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        if (!file.exists()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return TargetApiSupport.doChmodSafely(file.getAbsolutePath(), z2 ? 436 : 432);
        }
        try {
            if (z2) {
                return file.setReadable(true, false);
            }
            return file.setReadable(false, false) && file.setReadable(true, true);
        } catch (Exception e2) {
            handleThrowable(e2);
            return false;
        }
    }

    private synchronized void writeJobThread(CUIDInfo cUIDInfo) {
        new Thread(getWriteRunnable(cUIDInfo)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean writeToCuidFile(String str) {
        int i2 = (!sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.mContext.openFileOutput(SELF_CUID_FILE, i2);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
                fileOutputStreamOpenFileOutput.flush();
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e2) {
                        handleThrowable(e2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    if (i2 == 0 && sDataCuidInfoShable) {
                        return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 436);
                    }
                    if (!sDataCuidInfoShable) {
                        return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 432);
                    }
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e3) {
                        handleThrowable(e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            handleThrowable(e4);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e5) {
                    handleThrowable(e5);
                }
            }
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0030 -> B:36:0x0033). Please report as a decompilation issue!!! */
    private static void writeToFile(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e2) {
            handleThrowable(e2);
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (SecurityException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            handleThrowable(e5);
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (SecurityException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
