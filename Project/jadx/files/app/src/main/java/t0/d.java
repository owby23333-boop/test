package t0;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kuaishou.weapon.p0.g;
import com.sntech.stat.Cdo;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExtSystemInfos.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f21704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static WeakReference<ArrayList<NetworkInterface>> f21705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static WeakReference<JSONArray> f21706g;
    public Context a;
    public AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f21707c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f21708d = new e();

    /* JADX INFO: compiled from: ExtSystemInfos.java */
    public static class a {
        public static String a;

        public static String a(String str) {
            try {
                for (NetworkInterface networkInterface : d.c()) {
                    if (TextUtils.equals(str, networkInterface.getName())) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                return null;
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    public static List<NetworkInterface> c() throws SocketException {
        WeakReference<ArrayList<NetworkInterface>> weakReference = f21705f;
        if (weakReference != null && weakReference.get() != null) {
            return f21705f.get();
        }
        WeakReference<ArrayList<NetworkInterface>> weakReference2 = new WeakReference<>(Collections.list(NetworkInterface.getNetworkInterfaces()));
        f21705f = weakReference2;
        return weakReference2.get();
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SystemInfo", c(this.a));
        } catch (Throwable unused) {
            boolean z2 = Cdo.f125do;
        }
        try {
            jSONObject.put("TelephonyManager", b(this.a));
        } catch (Throwable unused2) {
            boolean z3 = Cdo.f125do;
        }
        try {
            jSONObject.put("AllMacAddr", b());
        } catch (Throwable unused3) {
            boolean z4 = Cdo.f125do;
        }
        try {
            jSONObject.put("MsaInfo", this.f21707c.a());
        } catch (Throwable unused4) {
            boolean z5 = Cdo.f125do;
        }
        try {
            jSONObject.put("MsaInfoNew", this.f21708d.a());
        } catch (Throwable unused5) {
            boolean z6 = Cdo.f125do;
        }
        try {
            Context context = this.a;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("gaid", b.a(context).a);
            } catch (Throwable unused6) {
                boolean z7 = Cdo.f125do;
            }
            try {
                jSONObject2.put("gsfid", a(context));
            } catch (Throwable unused7) {
                boolean z8 = Cdo.f125do;
            }
            jSONObject.put("IDs", jSONObject2);
        } catch (Throwable unused8) {
            boolean z9 = Cdo.f125do;
        }
        return jSONObject;
    }

    @SuppressLint({"MissingPermission"})
    public final JSONObject b(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return jSONObject;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 29) {
                if (i2 >= 26) {
                    jSONObject.put("Meid", telephonyManager.getMeid());
                    jSONObject.put("Meid_0", telephonyManager.getMeid(0));
                    jSONObject.put("Meid_1", telephonyManager.getMeid(1));
                }
                jSONObject.put("SimSerialNumber", telephonyManager.getSimSerialNumber());
                jSONObject.put("SubscriberId", telephonyManager.getSubscriberId());
            }
            jSONObject.put("NetworkCountryIso", telephonyManager.getNetworkCountryIso());
            jSONObject.put("NetworkOperator", telephonyManager.getNetworkOperator());
            jSONObject.put("NetworkOperatorName", telephonyManager.getNetworkOperatorName());
            jSONObject.put("NetworkType", telephonyManager.getNetworkType());
            if (i2 >= 26) {
                jSONObject.put("NetworkSpecifier", telephonyManager.getNetworkSpecifier());
            }
            if (i2 >= 24) {
                jSONObject.put("DataNetworkType", telephonyManager.getDataNetworkType());
            }
            if (i2 >= 28) {
                jSONObject.put("SimCarrierId", telephonyManager.getSimCarrierId());
                jSONObject.put("SimCarrierIdName", telephonyManager.getSimCarrierIdName());
            }
            jSONObject.put("SimCountryIso", telephonyManager.getSimCountryIso());
            jSONObject.put("SimOperator", telephonyManager.getSimOperator());
            jSONObject.put("SimOperatorName", telephonyManager.getSimOperatorName());
            jSONObject.put("SimState", telephonyManager.getSimState());
            if (i2 >= 23) {
                jSONObject.put("PhoneCount", telephonyManager.getPhoneCount());
            }
            jSONObject.put("PhoneType", telephonyManager.getPhoneType());
            try {
                a(telephonyManager, jSONObject);
            } catch (Throwable th) {
                jSONObject.put("Error", "getCellInfo Error: " + th);
            }
        } else {
            jSONObject.put("Error", "NoPermission");
        }
        return jSONObject;
    }

    public final JSONObject c(Context context) throws JSONException {
        double dDoubleValue;
        int i2;
        String strA;
        boolean z2;
        boolean z3;
        Bundle extras;
        Object obj;
        Object objInvoke;
        JSONObject jSONObject = new JSONObject();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            jSONObject.put("Build.VERSION.BASE_OS", Build.VERSION.BASE_OS);
        }
        jSONObject.put("Build.VERSION.CODENAME", Build.VERSION.CODENAME);
        jSONObject.put("Build.VERSION.INCREMENTAL", Build.VERSION.INCREMENTAL);
        jSONObject.put("Build.VERSION.RELEASE", Build.VERSION.RELEASE);
        jSONObject.put("Build.VERSION.SDK_INT", i3);
        if (i3 >= 23) {
            jSONObject.put("Build.VERSION.SECURITY_PATCH", Build.VERSION.SECURITY_PATCH);
        }
        jSONObject.put("Build.radioVersion", Build.getRadioVersion());
        boolean z4 = true;
        if (i3 >= 26 && i3 < 29) {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                jSONObject.put("Build.serial", Build.getSerial());
            }
        }
        jSONObject.put("Build.SERIAL", Build.SERIAL);
        jSONObject.put("Build.BOARD", Build.BOARD);
        jSONObject.put("Build.BOOTLOADER", Build.BOOTLOADER);
        jSONObject.put("Build.BRAND", Build.BRAND);
        jSONObject.put("Build.DEVICE", Build.DEVICE);
        jSONObject.put("Build.DISPLAY", Build.DISPLAY);
        jSONObject.put("Build.FINGERPRINT", Build.FINGERPRINT);
        jSONObject.put("Build.HARDWARE", Build.HARDWARE);
        jSONObject.put("Build.HOST", Build.HOST);
        jSONObject.put("Build.ID", Build.ID);
        jSONObject.put("Build.MANUFACTURER", Build.MANUFACTURER);
        jSONObject.put("Build.MODEL", Build.MODEL);
        jSONObject.put("Build.PRODUCT", Build.PRODUCT);
        if (i3 >= 21) {
            jSONObject.put("Build.SUPPORTED_32_BIT_ABIS", Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
            jSONObject.put("Build.SUPPORTED_64_BIT_ABIS", Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
            jSONObject.put("Build.SUPPORTED_ABIS", Arrays.toString(Build.SUPPORTED_ABIS));
        }
        jSONObject.put("Build.TAGS", Build.TAGS);
        jSONObject.put("Build.TIME", Build.TIME);
        jSONObject.put("Build.TYPE", Build.TYPE);
        jSONObject.put("Build.USER", Build.USER);
        jSONObject.put("Build.CPU_ABI", Build.CPU_ABI);
        jSONObject.put("Build.CPU_ABI2", Build.CPU_ABI2);
        jSONObject.put("Build.RADIO", Build.RADIO);
        if (i3 >= 17) {
            jSONObject.put("Settings.Global.ADB_ENABLED", Settings.Global.getString(context.getContentResolver(), "adb_enabled"));
            jSONObject.put("Settings.Global.HTTP_PROXY", Settings.Global.getString(context.getContentResolver(), "http_proxy"));
            if (q.b.f21663c == null) {
                q.b.f21663c = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            if (q.b.f21663c == null) {
                q.b.f21663c = "";
            }
            jSONObject.put("Settings.Secure.ANDROID_ID", q.b.f21663c);
        }
        if (i3 >= 25) {
            jSONObject.put("Settings.Global.DEVICE_NAME", Settings.Global.getString(context.getContentResolver(), am.J));
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Field declaredField = defaultAdapter.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            obj = declaredField.get(defaultAdapter);
        } catch (Throwable unused) {
            boolean z5 = Cdo.f125do;
        }
        String str = (obj == null || (objInvoke = obj.getClass().getMethod("getAddress", new Class[0]).invoke(obj, new Object[0])) == null || !(objInvoke instanceof String)) ? null : (String) objInvoke;
        jSONObject.put("BluetoothAddr", str);
        try {
        } catch (Throwable unused2) {
            boolean z6 = Cdo.f125do;
        }
        String address = context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0 ? BluetoothAdapter.getDefaultAdapter().getAddress() : null;
        jSONObject.put("BluetoothAddr2", address);
        try {
            Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
            declaredMethod.setAccessible(true);
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, "battery.capacity")).doubleValue();
        } catch (Throwable unused3) {
            dDoubleValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        jSONObject.put("Battery", (int) dDoubleValue);
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        if (intentRegisterReceiver == null || (extras = intentRegisterReceiver.getExtras()) == null) {
            i2 = -1;
        } else {
            i2 = !extras.getBoolean("connected") ? 0 : 1;
        }
        jSONObject.put("Usb", i2);
        synchronized (a.class) {
            strA = a.a;
            if (strA == null) {
                strA = a.a("wlan0");
                if (TextUtils.isEmpty(strA)) {
                    strA = a.a("eth0");
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = "DU:MM:YA:DD:RE:SS";
                }
                a.a = strA;
            }
        }
        jSONObject.put("csj_mac", strA);
        jSONObject.put("HTTP.AGENT", System.getProperty("http.agent"));
        jSONObject.put("HTTP.proxyHost", System.getProperty("http.proxyHost"));
        jSONObject.put("HTTP.proxyPort", System.getProperty("http.proxyPort"));
        if (Build.VERSION.SDK_INT >= 17) {
            jSONObject.put("WEB_VIEW.DEFAULT_AGENT", WebSettings.getDefaultUserAgent(this.a));
        }
        if (!q.f.b()) {
            try {
                String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
                for (int i4 = 0; i4 < 8; i4++) {
                    if (new File(strArr[i4]).exists()) {
                        z2 = true;
                        break;
                    }
                }
            } catch (Exception unused4) {
            }
            z2 = false;
            if (!z2) {
                boolean z7 = new File("/system/app/Superuser.apk").exists();
                if (!z7 && !q.f.a()) {
                    synchronized (q.f.class) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream("/data/su_test");
                            fileOutputStream.write("test_ok".getBytes());
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            try {
                                e2.printStackTrace();
                            } catch (Exception unused5) {
                            }
                        }
                        if ("test_ok".equals(q.a.a("/data/su_test"))) {
                            if (!TextUtils.isEmpty("/data/su_test")) {
                                new File("/data/su_test").deleteOnExit();
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                    if (!z3) {
                        z4 = false;
                    }
                }
            }
        }
        jSONObject.put("Root", z4);
        jSONObject.put("MultiApk", q.c.a(context));
        try {
            if (new File("/sys/devices/soc0/serial_number").exists()) {
                jSONObject.put("Soc.Serial_number", q.a.a("/sys/devices/soc0/serial_number"));
            }
        } catch (IOException unused6) {
        }
        try {
            if (new File("/proc/sys/kernel/random/boot_id").exists()) {
                jSONObject.put("Boot_id", q.a.a("/proc/sys/kernel/random/boot_id"));
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public final void a(TelephonyManager telephonyManager, JSONObject jSONObject) throws JSONException {
        if (q.e.a(this.a, g.f16728h)) {
            if (telephonyManager.getCellLocation() instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                jSONObject.put("CellLocBaseStationId", cdmaCellLocation.getBaseStationId());
                jSONObject.put("CellLocBaseStationLatitude", cdmaCellLocation.getBaseStationLatitude());
                jSONObject.put("CellLocBaseStationLongitude", cdmaCellLocation.getBaseStationLongitude());
                jSONObject.put("CellLocNetworkId", cdmaCellLocation.getNetworkId());
                jSONObject.put("CellLocSystemId", cdmaCellLocation.getSystemId());
            } else if (telephonyManager.getCellLocation() instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                jSONObject.put("CellLocCid", gsmCellLocation.getCid());
                jSONObject.put("CellLocLac", gsmCellLocation.getLac());
                jSONObject.put("CellLocPsc", gsmCellLocation.getPsc());
            }
            if (Build.VERSION.SDK_INT >= 17) {
                JSONArray jSONArray = new JSONArray();
                Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CellInfo next = it.next();
                    if (next.isRegistered()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("Registered", next.isRegistered());
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 30) {
                            jSONObject2.put("Identity", next.getCellIdentity());
                            jSONObject2.put("SignalStrengthLevel", next.getCellSignalStrength().getLevel());
                            jSONObject2.put("TimestampMillis", next.getTimestampMillis());
                        }
                        if (i2 >= 28) {
                            jSONObject2.put("CellConnectionStatus", next.getCellConnectionStatus());
                        }
                        jSONObject2.put("TimeStamp", next.getTimeStamp());
                        jSONArray.put(jSONObject2);
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("AllCellInfo", jSONArray);
                }
            }
        }
    }

    public final synchronized JSONArray b() {
        WeakReference<JSONArray> weakReference = f21706g;
        if (weakReference != null && weakReference.get() != null) {
            return f21706g.get();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (NetworkInterface networkInterface : c()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("DisplayName", networkInterface.getDisplayName());
                    jSONObject.put("Name", networkInterface.getName());
                    jSONObject.put("MTU", networkInterface.getMTU());
                    jSONObject.put("UP", networkInterface.isUp());
                    if (Build.VERSION.SDK_INT >= 19) {
                        jSONObject.put("Index", networkInterface.getIndex());
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    JSONArray jSONArray2 = new JSONArray();
                    if (inetAddresses != null) {
                        while (inetAddresses.hasMoreElements()) {
                            try {
                                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                                if (inetAddressNextElement != null) {
                                    jSONArray2.put(inetAddressNextElement.getHostAddress());
                                }
                            } catch (Exception unused) {
                                boolean z2 = Cdo.f125do;
                            }
                        }
                    }
                    jSONObject.put("InetAddresses", jSONArray2);
                    List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
                    JSONArray jSONArray3 = new JSONArray();
                    for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("Address", interfaceAddress.getAddress() != null ? interfaceAddress.getAddress().getHostAddress() : "");
                        jSONObject2.put("Broadcast", interfaceAddress.getBroadcast() != null ? interfaceAddress.getBroadcast().getHostAddress() : "");
                        jSONObject2.put("NetworkPrefixLength", (int) interfaceAddress.getNetworkPrefixLength());
                        jSONArray3.put(jSONObject2);
                    }
                    jSONObject.put("InterfaceAddresses", jSONArray3);
                    if ("wlan0".equals(networkInterface.getName()) || "eth0".equals(networkInterface.getName())) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        StringBuilder sb = new StringBuilder(18);
                        if (hardwareAddress != null) {
                            for (byte b : hardwareAddress) {
                                if (sb.length() > 0) {
                                    sb.append(':');
                                }
                                sb.append(String.format("%02x", Byte.valueOf(b)));
                            }
                        } else {
                            sb.append("");
                        }
                        jSONObject.put("HardwareAddress", sb.toString());
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception unused2) {
                    boolean z3 = Cdo.f125do;
                }
            }
        } catch (Exception unused3) {
            boolean z4 = Cdo.f125do;
        }
        f21706g = new WeakReference<>(jSONArray);
        return jSONArray;
    }

    public final String a(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
        if (cursorQuery != null && (!cursorQuery.moveToFirst() || cursorQuery.getColumnCount() < 2)) {
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
        if (cursorQuery != null) {
            try {
                String hexString = Long.toHexString(Long.parseLong(cursorQuery.getString(1)));
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                return hexString;
            } catch (NumberFormatException unused) {
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }
}
