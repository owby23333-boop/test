package com.dangdang.zframework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.dangdang.zframework.FrameWorkBridgeHelper;
import com.dangdang.zframework.log.LogM;
import com.xiaomi.verificationsdk.internal.Constants;
import com.yuewen.eq2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigManager {
    private static final String DANG_READER_PREF = "dang_reader_config";
    private static String DEVICE_ID_FILE_NAME = ".ddeb.id";
    public static final String KEY_HTTPS_SWITCH = "key_https_switch";
    public static final String KEY_INIT_PERMANENTID = "init_permanentId";
    public static int https_switch = 1;
    private static ConfigManager instance;
    public final String SPF_KEY_HTTP_FILTER_BLOC = "http_report_filter_bloc";
    private Context context;
    private SharedPreferences pref;

    public ConfigManager(Context context) {
        this.pref = null;
        this.context = context.getApplicationContext();
        this.pref = context.getSharedPreferences("dang_reader_config", 0);
    }

    private static String bytes2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String getCPUSerial() {
        String str = "0000000000000000";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("system/proc/cpuinfo").getInputStream()));
            for (int i = 1; i < 500; i++) {
                String line = lineNumberReader.readLine();
                if (line == null) {
                    break;
                }
                str = str + line.substring(line.indexOf(":") + 1, line.length()).trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static ConfigManager getInstance(Context context) {
        if (instance == null) {
            instance = new ConfigManager(context.getApplicationContext());
        }
        return instance;
    }

    private String readDeviceIDFromFile() {
        File file = new File(FileUtil.getSdCardPath(), DEVICE_ID_FILE_NAME);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                int i = bufferedReader.read();
                if (i <= -1) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeAndroidIdToSP(String str) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString("android_id", str);
        editor.commit();
    }

    private void writeDeviceIdToSP(String str) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(Constants.DEVICE_ID, str);
        editor.commit();
    }

    public boolean IsNewVersion() {
        return "4.0.0".equals(getVersionName());
    }

    public String getActivityId() {
        try {
            return String.valueOf(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getInt("ACTIVITY_ID"));
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return "";
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return "";
        }
    }

    public String getAppName() {
        String string = "";
        try {
            string = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).applicationInfo.toString();
            LogM.d("appName=" + string);
            return string;
        } catch (Exception e) {
            LogM.d("Failed to get versionName: " + e.getMessage());
            return string;
        }
    }

    public String getBaiduPushAppKey() {
        String string = "";
        try {
            string = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("BAIDU_PUSH_APP_KEY");
            LogM.d("appkey=" + string);
            return string;
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return string;
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return string;
        }
    }

    public String getChannelId() {
        return getPreferences().getString("spf_key_umeng_channel", DangdangConfig.CHANNEL_ID);
    }

    public int getChannelIdFromManifest() {
        try {
            int i = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getInt("UMENG_CHANNEL");
            LogM.d("channelId=" + i);
            return i;
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return -1;
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return -1;
        }
    }

    public String getDeviceAndroidId() {
        String strSubstring = "";
        String string = this.pref.getString("android_id", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int iAbs = (Math.abs(new Random().nextInt()) % 90000000) + 10000000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(jCurrentTimeMillis);
            sb.append(iAbs);
            strSubstring = bytes2HexStr(messageDigest.digest(sb.toString().getBytes())).substring(8, 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeAndroidIdToSP(strSubstring);
        return strSubstring;
    }

    public String getDeviceMacAddress() {
        return "";
    }

    public SharedPreferences.Editor getEditor() {
        return this.pref.edit();
    }

    public String getHttpFilter() {
        return getPreferences().getString("http_report_filter_bloc", "");
    }

    public int getHttpsSwitch() {
        int i = this.pref.getInt(KEY_HTTPS_SWITCH, 1);
        https_switch = i;
        return i;
    }

    public String getId() {
        String string = this.pref.getString(Constants.DEVICE_ID, null);
        LogM.d("read device_id from sp " + string);
        boolean zHasPermitPrivacy = FrameWorkBridgeHelper.getInstance().hasPermitPrivacy();
        if (TextUtils.isEmpty(string)) {
            string = readDeviceIDFromFile();
            writeDeviceIdToSP(string);
            LogM.d("read device_id from file " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iAbs = (Math.abs(new Random().nextInt()) % 90000000) + 10000000;
        String deviceMacAddress = zHasPermitPrivacy ? getDeviceMacAddress() : "";
        String deviceAndroidId = zHasPermitPrivacy ? getDeviceAndroidId() : "";
        String str = "" + deviceMacAddress + deviceAndroidId + jCurrentTimeMillis + iAbs;
        if (TextUtils.isEmpty("") && TextUtils.isEmpty(deviceMacAddress) && TextUtils.isEmpty(deviceAndroidId)) {
            str = "dandangreader" + UUID.randomUUID().toString();
        }
        if (TextUtils.isEmpty(str) || eq2.g.equalsIgnoreCase(str)) {
            str = "dandangreader" + UUID.randomUUID().toString();
        }
        String mD5Str = MD5Util.getMD5Str(str);
        writeDeviceIdToSP(mD5Str);
        LogM.d("create device_id " + mD5Str);
        return mD5Str;
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getPhoneModel() {
        return Build.MODEL;
    }

    public SharedPreferences getPreferences() {
        return this.pref;
    }

    public String getServerVesion() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("SERVER_VERSION");
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return "";
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return "";
        }
    }

    public int getVersionCode() {
        int i = 0;
        try {
            i = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
            LogM.d("versionCode=" + i);
            return i;
        } catch (Exception e) {
            LogM.d("Failed to get versionCode: " + e.getMessage());
            return i;
        }
    }

    public String getVersionName() {
        String str = "";
        try {
            str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            LogM.d("versionName=" + str);
            return str;
        } catch (Exception e) {
            LogM.d("Failed to get versionName: " + e.getMessage());
            return str;
        }
    }

    public void setChannelId(String str) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        editorEdit.putString("spf_key_umeng_channel", str);
        editorEdit.commit();
    }

    public void setHttpFilter(String str) {
        SharedPreferences.Editor editorEdit = getPreferences().edit();
        editorEdit.putString("http_report_filter_bloc", str);
        editorEdit.commit();
    }

    public void setHttpsSwitch(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt(KEY_HTTPS_SWITCH, i);
        https_switch = i;
        editorEdit.commit();
    }

    public void writeDeviceIDToFile() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(FileUtil.getSdCardPath(), DEVICE_ID_FILE_NAME)), "utf-8");
            String id = getId();
            outputStreamWriter.write(id);
            outputStreamWriter.close();
            LogM.d("write device_id to file " + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences("dang_reader_config", 0);
    }
}
