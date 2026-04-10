package com.ss.android.socialbase.appdownloader.u;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.ko;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    public static String b = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f18087h = null;
    private static String hj = "";
    private static String ko = null;
    public static String mb = null;
    public static String ox = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f18088u;

    public static boolean b() {
        return mb("VIVO");
    }

    public static boolean h() {
        return mb("FLYME");
    }

    public static boolean hj() {
        lc();
        return mb(mb);
    }

    private static void io() {
        if (ko == null) {
            try {
                ko = hj("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = ko;
            if (str == null) {
                str = "";
            }
            ko = str;
        }
    }

    @NonNull
    public static String jb() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean je() {
        io();
        return "V10".equals(ko);
    }

    public static String ko() {
        if (f18087h == null) {
            mb("");
        }
        return f18087h;
    }

    private static void lc() {
        if (TextUtils.isEmpty(mb)) {
            DownloadComponentManager.ensureOPPO();
            mb = DownloadConstants.UPPER_OPPO;
            hj = "ro.build.version." + DownloadConstants.LOWER_OPPO + "rom";
            ox = "com." + DownloadConstants.LOWER_OPPO + ".market";
        }
    }

    public static String lz() {
        if (b == null) {
            mb("");
        }
        return b;
    }

    public static boolean mb() {
        return mb("EMUI");
    }

    public static boolean nk() {
        io();
        return "V11".equals(ko);
    }

    public static boolean o() {
        io();
        return "V12".equals(ko);
    }

    public static boolean ox() {
        return mb("MIUI");
    }

    public static boolean u() {
        return mb("SAMSUNG");
    }

    public static String ww() {
        if (f18088u == null) {
            mb("");
        }
        return f18088u;
    }

    @NonNull
    public static String x() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String b(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
    }

    public static boolean mb(String str) {
        lc();
        String str2 = f18087h;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strHj = hj("ro.miui.ui.version.name");
        f18088u = strHj;
        if (TextUtils.isEmpty(strHj)) {
            String strHj2 = hj("ro.build.version.emui");
            f18088u = strHj2;
            if (TextUtils.isEmpty(strHj2)) {
                String strHj3 = hj(hj);
                f18088u = strHj3;
                if (TextUtils.isEmpty(strHj3)) {
                    String strHj4 = hj("ro.vivo.os.version");
                    f18088u = strHj4;
                    if (TextUtils.isEmpty(strHj4)) {
                        String strHj5 = hj("ro.smartisan.version");
                        f18088u = strHj5;
                        if (TextUtils.isEmpty(strHj5)) {
                            String strHj6 = hj("ro.gn.sv.version");
                            f18088u = strHj6;
                            if (TextUtils.isEmpty(strHj6)) {
                                String strHj7 = hj("ro.lenovo.lvp.version");
                                f18088u = strHj7;
                                if (!TextUtils.isEmpty(strHj7)) {
                                    f18087h = "LENOVO";
                                    b = "com.lenovo.leos.appstore";
                                } else if (x().toUpperCase().contains("SAMSUNG")) {
                                    f18087h = "SAMSUNG";
                                    b = "com.sec.android.app.samsungapps";
                                } else if (x().toUpperCase().contains("ZTE")) {
                                    f18087h = "ZTE";
                                    b = "zte.com.market";
                                } else if (x().toUpperCase().contains("NUBIA")) {
                                    f18087h = "NUBIA";
                                    b = "cn.nubia.neostore";
                                } else if (jb().toUpperCase().contains("FLYME")) {
                                    f18087h = "FLYME";
                                    b = "com.meizu.mstore";
                                    f18088u = jb();
                                } else if (x().toUpperCase().contains("ONEPLUS")) {
                                    f18087h = "ONEPLUS";
                                    f18088u = hj("ro.rom.version");
                                    if (ko.mb(ox) > -1) {
                                        b = ox;
                                    } else {
                                        b = "com.heytap.market";
                                    }
                                } else {
                                    f18087h = x().toUpperCase();
                                    b = "";
                                    f18088u = "";
                                }
                            } else {
                                f18087h = "QIONEE";
                                b = "com.gionee.aora.market";
                            }
                        } else {
                            f18087h = "SMARTISAN";
                            b = "com.smartisanos.appstore";
                        }
                    } else {
                        f18087h = "VIVO";
                        b = "com.bbk.appstore";
                    }
                } else {
                    f18087h = mb;
                    if (ko.mb(ox) > -1) {
                        b = ox;
                    } else {
                        b = "com.heytap.market";
                    }
                }
            } else {
                f18087h = "EMUI";
                b = "com.huawei.appmarket";
            }
        } else {
            f18087h = "MIUI";
            b = "com.xiaomi.market";
            ko = f18088u;
        }
        return f18087h.equals(str);
    }

    public static String ox(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                DownloadUtils.safeClose(bufferedReader);
                return line;
            } catch (Throwable unused) {
                DownloadUtils.safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String hj(String str) {
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.ENABLE_REFLECT_SYSTEM_PROPERTIES, true)) {
            try {
                return b(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return ox(str);
            }
        }
        return ox(str);
    }
}
