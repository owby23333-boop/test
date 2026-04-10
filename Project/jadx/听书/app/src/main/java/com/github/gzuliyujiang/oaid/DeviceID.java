package com.github.gzuliyujiang.oaid;

import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.github.gzuliyujiang.oaid.impl.OAIDFactory;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceID implements IGetter {
    private Application application;
    private String clientId;
    private String oaid;

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = application;
        String uniqueID = getUniqueID(application);
        if (!TextUtils.isEmpty(uniqueID)) {
            deviceID.clientId = uniqueID;
            OAIDLog.print("Client id is IMEI/MEID: " + deviceID.clientId);
        } else {
            getOAID(application, deviceID);
        }
    }

    public static String getClientId() {
        String str = Holder.INSTANCE.clientId;
        return str == null ? "" : str;
    }

    public static String getClientIdMD5() {
        return calculateHash(getClientId(), "MD5");
    }

    public static String getClientIdSHA1() {
        return calculateHash(getClientId(), "SHA-1");
    }

    public static String getOAID() {
        String str = Holder.INSTANCE.oaid;
        return str == null ? "" : str;
    }

    public static void getOAID(Context context, IGetter getter) {
        OAIDFactory.create(context).doGet(getter);
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    public static String getUniqueID(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            OAIDLog.print("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (context.checkSelfPermission(g.c) != 0) {
            OAIDLog.print("android.permission.READ_PHONE_STATE not granted");
            return "";
        }
        return getIMEI(context);
    }

    private static String getIMEI(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String imei = telephonyManager.getImei();
            return TextUtils.isEmpty(imei) ? telephonyManager.getMeid() : imei;
        } catch (Error e) {
            OAIDLog.print(e);
            return "";
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return "";
        }
    }

    public static String getAndroidID(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String getWidevineID() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Error e) {
            OAIDLog.print(e);
            return "";
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return "";
        }
    }

    public static String getPseudoID() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BOARD.length() % 10);
        sb.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.DISPLAY.length() % 10);
        sb.append(Build.HOST.length() % 10);
        sb.append(Build.ID.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        sb.append(Build.BOOTLOADER.length() % 10);
        sb.append(Build.HARDWARE.length() % 10);
        sb.append(Build.TAGS.length() % 10);
        sb.append(Build.TYPE.length() % 10);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    public static String getGUID(Context context) {
        String uuidFromSystemSettings = getUuidFromSystemSettings(context);
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromExternalStorage(context);
        }
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromSharedPreferences(context);
        }
        if (!TextUtils.isEmpty(uuidFromSystemSettings)) {
            return uuidFromSystemSettings;
        }
        String string = UUID.randomUUID().toString();
        OAIDLog.print("Generate uuid by random: " + string);
        saveUuidToSharedPreferences(context, string);
        saveUuidToSystemSettings(context, string);
        saveUuidToExternalStorage(context, string);
        return string;
    }

    private static String getUuidFromSystemSettings(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        OAIDLog.print("Get uuid from system settings: " + string);
        return string;
    }

    private static void saveUuidToSystemSettings(Context context, String uuid) {
        if (context == null) {
            return;
        }
        if (Settings.System.canWrite(context)) {
            try {
                Settings.System.putString(context.getContentResolver(), "GUID_uuid", uuid);
                OAIDLog.print("Save uuid to system settings: " + uuid);
                return;
            } catch (Exception e) {
                OAIDLog.print(e);
                return;
            }
        }
        OAIDLog.print("android.permission.WRITE_SETTINGS not granted");
    }

    private static String getUuidFromExternalStorage(Context context) {
        String line = "";
        if (context == null) {
            return "";
        }
        File guidFile = getGuidFile(context);
        if (guidFile != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(guidFile));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                OAIDLog.print(e);
            }
        }
        OAIDLog.print("Get uuid from external storage: " + line);
        return line;
    }

    private static void saveUuidToExternalStorage(Context context, String uuid) {
        if (context == null) {
            return;
        }
        File guidFile = getGuidFile(context);
        if (guidFile == null) {
            OAIDLog.print("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guidFile));
            try {
                if (!guidFile.exists()) {
                    guidFile.createNewFile();
                }
                bufferedWriter.write(uuid);
                bufferedWriter.flush();
                OAIDLog.print("Save uuid to external storage: " + uuid);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    private static File getGuidFile(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 30 && context != null && context.checkSelfPermission(g.j) == 0) {
            z = true;
        }
        if (z && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    private static void saveUuidToSharedPreferences(Context context, String uuid) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", uuid).apply();
        OAIDLog.print("Save uuid to shared preferences: " + uuid);
    }

    private static String getUuidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        OAIDLog.print("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String calculateHash(String str, String algorithm) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            OAIDLog.print(e);
            return "";
        }
    }

    private static class Holder {
        static final DeviceID INSTANCE = new DeviceID();

        private Holder() {
        }
    }

    private DeviceID() {
    }

    @Override // com.github.gzuliyujiang.oaid.IGetter
    public void onOAIDGetComplete(String result) {
        if (TextUtils.isEmpty(result)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
            return;
        }
        this.clientId = result;
        this.oaid = result;
        OAIDLog.print("Client id is OAID/AAID: " + this.clientId);
    }

    @Override // com.github.gzuliyujiang.oaid.IGetter
    public void onOAIDGetError(Exception error) {
        String widevineID = getWidevineID();
        if (!TextUtils.isEmpty(widevineID)) {
            this.clientId = widevineID;
            OAIDLog.print("Client id is WidevineID: " + this.clientId);
            return;
        }
        String androidID = getAndroidID(this.application);
        if (!TextUtils.isEmpty(androidID)) {
            this.clientId = androidID;
            OAIDLog.print("Client id is AndroidID: " + this.clientId);
        } else {
            this.clientId = getGUID(this.application);
            OAIDLog.print("Client id is GUID: " + this.clientId);
        }
    }
}
