package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TbsPVConfig extends TbsBaseConfig {
    private static TbsPVConfig b;
    public SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final String KEY_CFG_REQUEST_INTERVAL = "tbs_cfg_request_interval";
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_DISABLE_LOAD_PROTECTION = "disable_load_protection";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
        public static final String KEY_REPORT_COOKIE_SWITCH_STAT = "tbs_report_cookie_stat";
        public static final String KEY_REPORT_CORE_LOAD_PERFORMANCE = "tbs_report_core_load_performance";
        public static final String KEY_REPORT_DOWNLOAD_STAT = "tbs_report_download_stat";
        public static final String KEY_REPORT_INSTALL_STAT = "tbs_report_install_stat";
        public static final String KEY_REPORT_LOAD_STAT = "tbs_report_load_stat";
        public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    private TbsPVConfig() {
    }

    private boolean a(String str) {
        if (this.a.containsKey(str)) {
            return ITagManager.STATUS_TRUE.equals(this.a.get(str));
        }
        return false;
    }

    public static synchronized TbsPVConfig getInstance(Context context) {
        if (b == null) {
            b = new TbsPVConfig();
            b.init(context);
        }
        return b;
    }

    public static synchronized void releaseInstance() {
        b = null;
    }

    public synchronized int getCfgRequestMinInterval() {
        int i2;
        i2 = -1;
        try {
            String str = this.a.get(TbsPVConfigKey.KEY_CFG_REQUEST_INTERVAL);
            if (str != null && !TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
            if (i2 >= 0) {
                TbsLog.i(TbsBaseConfig.TAG, "getCfgRequestInterval: " + i2);
            }
        } catch (Exception e2) {
            TbsLog.i(TbsBaseConfig.TAG, "getCfgRequestIntervalException: " + e2);
        }
        return i2;
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    public synchronized int getDisabledCoreVersion() {
        int i2;
        i2 = 0;
        try {
            String str = this.a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            TbsLog.i(TbsBaseConfig.TAG, "getDisabledCoreVersion tmp is " + str);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (Exception e2) {
            TbsLog.i(TbsBaseConfig.TAG, "getDisabledCoreVersion stack is " + Log.getStackTraceString(e2));
        }
        return i2;
    }

    public synchronized int getEmergentCoreVersion() {
        int i2;
        i2 = 0;
        try {
            String str = this.a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int i2;
        i2 = 0;
        try {
            String str = this.a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    public synchronized Map<TbsLogReport.EventType, Boolean> getLogReportSwitchMap() {
        HashMap map;
        map = new HashMap();
        map.put(TbsLogReport.EventType.TYPE_DOWNLOAD, Boolean.valueOf(a(TbsPVConfigKey.KEY_REPORT_DOWNLOAD_STAT)));
        map.put(TbsLogReport.EventType.TYPE_INSTALL, Boolean.valueOf(a(TbsPVConfigKey.KEY_REPORT_INSTALL_STAT)));
        map.put(TbsLogReport.EventType.TYPE_LOAD, Boolean.valueOf(a(TbsPVConfigKey.KEY_REPORT_LOAD_STAT)));
        map.put(TbsLogReport.EventType.TYPE_CDN_DOWNLOAD_STAT, true);
        map.put(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, Boolean.valueOf(a(TbsPVConfigKey.KEY_REPORT_COOKIE_SWITCH_STAT)));
        map.put(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, true);
        map.put(TbsLogReport.EventType.TYPE_CORE_LOAD_PERFORMANCE, Boolean.valueOf(a(TbsPVConfigKey.KEY_REPORT_CORE_LOAD_PERFORMANCE)));
        map.put(TbsLogReport.EventType.TYPE_CORE_PROTECT_RESET, true);
        return map;
    }

    public synchronized int getReadApk() {
        int i2;
        i2 = 0;
        try {
            String str = this.a.get(TbsPVConfigKey.KEY_READ_APK);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    public synchronized String getSyncMapValue(String str) {
        return this.a.get(str);
    }

    public synchronized boolean getTbsCoreSandboxModeEnable() {
        boolean z2;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z2 = ITagManager.STATUS_TRUE.equals(this.a.get(TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE));
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDisableHostBackupCore() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r1 = "disable_host_backup"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 != 0) goto L22
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r0 == 0) goto L22
            r0 = 1
        L1a:
            monitor-exit(r2)
            return r0
        L1c:
            r0 = move-exception
            goto L24
        L1e:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1c
        L22:
            r0 = 0
            goto L1a
        L24:
            monitor-exit(r2)
            goto L27
        L26:
            throw r0
        L27:
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsPVConfig.isDisableHostBackupCore():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isEnableNoCoreGray() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.a     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r1 = "enable_no_share_gray"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 != 0) goto L22
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r0 == 0) goto L22
            r0 = 1
        L1a:
            monitor-exit(r2)
            return r0
        L1c:
            r0 = move-exception
            goto L24
        L1e:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1c
        L22:
            r0 = 0
            goto L1a
        L24:
            monitor-exit(r2)
            goto L27
        L26:
            throw r0
        L27:
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsPVConfig.isEnableNoCoreGray():boolean");
    }

    public synchronized boolean isEnableProtection() {
        boolean z2;
        try {
        } catch (Exception unused) {
            TbsLog.i(TbsBaseConfig.TAG, "enable load protection");
        }
        z2 = !ITagManager.STATUS_FALSE.equals(this.a.get(TbsPVConfigKey.KEY_DISABLE_LOAD_PROTECTION));
        return z2;
    }

    public synchronized void putData(String str, String str2) {
        this.a.put(str, str2);
    }
}
