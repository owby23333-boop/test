package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.anythink.expressad.exoplayer.i.a;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwai.sodler.lib.ext.PluginError;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.model.hj;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.ox;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements com.ss.android.downloadad.api.mb, ox.b, AppStatusManager.AppStatusChangeListener, IOpenInstallerListener {
    private static volatile mb hj = null;
    private static String mb = "mb";
    private ox b;
    private long ox;

    private class b implements Runnable {
        private final com.ss.android.downloadad.api.mb.ox ox;

        public b(com.ss.android.downloadad.api.mb.ox oxVar) {
            this.ox = oxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.ox.x(true);
                    mb.this.b(this.ox);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.ox.x(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.mb$mb, reason: collision with other inner class name */
    @WorkerThread
    private class RunnableC0512mb implements Runnable {
        private final int ox;

        public RunnableC0512mb(int i2) {
            this.ox = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.model.u.mb().ox();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> concurrentHashMapB = com.ss.android.downloadlib.addownload.model.u.mb().b();
                if (concurrentHashMapB == null || concurrentHashMapB.isEmpty()) {
                    return;
                }
                mb.this.mb(concurrentHashMapB, this.ox);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class ox implements Runnable {
        private long b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f18031h;
        private int hj;
        private long mb;
        private int ox;

        /* JADX INFO: Access modifiers changed from: private */
        public void ox() {
            this.f18031h = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (mb()) {
                    mb.mb().mb(this.mb, this.ox);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private ox(long j2, int i2, long j3, int i3) {
            this.mb = j2;
            this.ox = i2;
            this.b = j3;
            this.hj = i3;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(21:12|(1:19)(20:16|(0)|21|57|22|23|55|24|(1:26)|27|(1:29)(1:30)|31|(3:35|36|37)|38|(1:40)(1:41)|42|(1:44)|45|52|53)|20|21|57|22|23|55|24|(0)|27|(0)(0)|31|(4:33|35|36|37)|38|(0)(0)|42|(0)|45|52|53) */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ff, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0101, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0102, code lost:
        
            r3 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0104, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b5 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:24:0x0094, B:26:0x00b5, B:31:0x00c8, B:37:0x00e1, B:42:0x00eb, B:45:0x00fb), top: B:55:0x0094 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean mb() {
            /*
                Method dump skipped, instruction units count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.mb.ox.mb():boolean");
        }

        private int mb(boolean z2, com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, boolean z3, JSONObject jSONObject) {
            DownloadSetting downloadSettingObtain = DownloadSetting.obtain(downloadInfo.getId());
            int i2 = 1;
            if (downloadSettingObtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put(EventConstants.ExtraJson.TTMD5_STATUS, iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!DownloadUtils.isMd5Valid(iCheckMd5Status)) {
                    return PluginError.ERROR_UPD_CAPACITY;
                }
            }
            int i3 = this.hj;
            if (i3 != 2000) {
                return i3;
            }
            if (downloadSettingObtain.optInt("install_failed_check_signature", 1) == 1 && jb.hj(x.getContext(), oxVar.h())) {
                if (!jb.mb(jb.ww(x.getContext(), downloadInfo.getTargetFilePath()), jb.ko(x.getContext(), oxVar.h()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (!z2) {
                return 2002;
            }
            long j2 = this.f18031h;
            long j3 = this.b;
            if (j2 <= j3) {
                return 2000;
            }
            try {
                jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_TIME, j2 - j3);
                if (oxVar.xa() <= this.b) {
                    i2 = 0;
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_AGAIN, i2);
            } catch (Throwable unused2) {
            }
            if (z3) {
                return PluginError.ERROR_UPD_EXTRACT;
            }
            return 2003;
        }
    }

    private mb() {
        com.ss.android.socialbase.appdownloader.ox.mb(this);
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private int hj(com.ss.android.downloadad.api.mb.ox oxVar) {
        int realStatus;
        double dOptDouble = DownloadSetting.obtain(oxVar.m()).optDouble("download_failed_finally_hours", 48.0d);
        if (dOptDouble <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            return -1;
        }
        if (System.currentTimeMillis() - oxVar.wn() < dOptDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (oxVar.hj.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && oxVar.hj.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                mb(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(oxVar.fu()));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, oxVar.ep());
                jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVar.on());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVar.qa() ? 1 : 2);
                AdEventHandler.mb().mb(oxVar.x(), EventConstants.Label.DOWNLOAD_FAILED_FINALLY, jSONObject, oxVar);
                com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    public static JSONObject ox(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jMb = jb.mb(0L);
            double d2 = jMb;
            Double.isNaN(d2);
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            Double.isNaN(d3);
            jSONObject.put(EventConstants.ExtraJson.APK_SIZE, d3 / 1048576.0d);
            if (jMb > 0 && totalBytes > 0) {
                Double.isNaN(d2);
                Double.isNaN(d3);
                jSONObject.put(EventConstants.ExtraJson.KEY_AVAILABLE_SPACE_RATIO, d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        Logger.d(mb, "onAppBackground()");
        mb(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        Logger.d(mb, "onAppForeground()");
        ox();
        mb(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("info is null");
        } else if ((DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.ox.h.mb().ox(new com.ss.android.downloadlib.ox.hj() { // from class: com.ss.android.downloadlib.mb.4
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z2) {
                    if (!z2) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.b.mb(x.getContext(), intent);
                            jb.mb(jSONObject, "backup", (Object) 1);
                        } else {
                            jb.mb(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                    if (oxVarMb != null) {
                        AdEventHandler.mb().mb(z2 ? EventConstants.UnityLabel.INSTALLER_DELAY_SUCCESS : EventConstants.UnityLabel.INSTALLER_DELAY_FAILED, jSONObject, oxVarMb);
                    } else {
                        com.ss.android.downloadlib.exception.b.mb().ox("ah nativeModel=null");
                    }
                    if (z2) {
                        x.gm().mb(x.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void b(com.ss.android.downloadad.api.mb.ox oxVar) {
        SystemClock.sleep(20000L);
        int i2 = 15;
        while (i2 > 0) {
            if (jb.ox(oxVar)) {
                mb(oxVar.h());
                return;
            }
            i2--;
            if (i2 == 0) {
                return;
            } else {
                SystemClock.sleep(20000L);
            }
        }
    }

    public static mb mb() {
        if (hj == null) {
            synchronized (mb.class) {
                if (hj == null) {
                    hj = new mb();
                }
            }
        }
        return hj;
    }

    public static String b(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = x.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.b.mb());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, str);
                jSONObject.put(EventConstants.ExtraJson.INPUT_PACKAGE_NAME, downloadInfo.getPackageName());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.PACKAGE_NAME_ERROR, jSONObject, oxVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @WorkerThread
    public static synchronized void mb(DownloadInfo downloadInfo, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("onDownloadFinish info null");
            return;
        }
        if (oxVar == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("onDownloadFinish nativeModel null");
            return;
        }
        if (oxVar.sw() != 1) {
            return;
        }
        com.ss.android.downloadlib.b.ww.mb().hj(oxVar);
        String strB = b(downloadInfo, oxVar);
        com.ss.android.downloadlib.addownload.model.u.mb().ox(downloadInfo.getUrl(), strB);
        Map<Long, com.ss.android.downloadad.api.mb.ox> mapMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo.getUrl(), strB);
        oxVar.u(System.currentTimeMillis());
        oxVar.h(2);
        oxVar.ox(strB);
        mapMb.put(Long.valueOf(oxVar.ox()), oxVar);
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(mapMb.values());
        ox(oxVar);
        ko.mb().mb(downloadInfo, strB);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            mb().mb(oxVar);
            mb().ox(downloadInfo, oxVar);
            if (oxVar.al()) {
                com.ss.android.downloadlib.addownload.mb.mb.mb().mb(downloadInfo.getId(), oxVar.ox(), oxVar.je(), strB, downloadInfo.getTitle(), oxVar.hj(), downloadInfo.getTargetFilePath());
            }
            com.ss.android.downloadlib.addownload.hj.mb.mb(downloadInfo, oxVar.ox(), oxVar.hj(), strB);
        }
    }

    public void ox(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.mb.ox oxVar) {
        if (downloadInfo == null || oxVar == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        hj.mb().ox(new Runnable() { // from class: com.ss.android.downloadlib.mb.3
            @Override // java.lang.Runnable
            public void run() {
                String strMb = com.ss.android.downloadlib.utils.mb.mb(targetFilePath);
                if (TextUtils.isEmpty(strMb)) {
                    return;
                }
                x.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(oxVar.ox()), strMb).apply();
            }
        });
    }

    private static void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        String strZ = TextUtils.isEmpty(oxVar.z()) ? "" : oxVar.z();
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
        oxVar.je("");
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        JSONObject jSONObjectMb = mb(new JSONObject(), downloadInfo);
        int i2 = 1;
        try {
            jSONObjectMb.putOpt(EventConstants.ExtraJson.DOWNLOAD_FINISH_REASON, strZ);
            jSONObjectMb.putOpt(EventConstants.ExtraJson.FINISH_FROM_RESERVE_WIFI, Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        com.ss.android.downloadlib.utils.h.mb(jSONObjectMb, downloadInfo.getId());
        try {
            jSONObjectMb.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVarMb.on());
            jSONObjectMb.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectMb.put(EventConstants.ExtraJson.KEY_FILE_LENGTH_GAP, downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectMb.put(EventConstants.ExtraJson.TTMD5_STATUS, downloadInfo.getTTMd5CheckStatus());
            jSONObjectMb.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, oxVarMb.hj.get() ? 1 : 2);
            if (!oxVarMb.qa()) {
                i2 = 2;
            }
            jSONObjectMb.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, i2);
            com.ss.android.downloadlib.utils.h.mb(oxVarMb, jSONObjectMb);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.DOWNLOAD_FINISH, jSONObjectMb, oxVar);
    }

    synchronized void ox() {
        ox oxVar = this.b;
        if (oxVar != null) {
            oxVar.ox();
            this.b = null;
        }
    }

    @WorkerThread
    public synchronized void mb(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!jb.mb()) {
            final com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(str);
            if (oxVarMb == null) {
                com.ss.android.downloadlib.addownload.model.hj.mb().mb(str);
                return;
            }
            com.ss.android.downloadlib.addownload.h hVarMb = ko.mb().mb(oxVarMb.mb());
            if (hVarMb != null) {
                hVarMb.u();
            }
            if (oxVarMb.b.get()) {
                return;
            }
            if (DownloadSetting.obtain(oxVarMb.m()).optInt("notification_opt_2") == 1) {
                DownloadNotificationManager.getInstance().cancelNotification(oxVarMb.m());
            }
            new com.ss.android.downloadlib.ox.ox().mb(oxVarMb, new com.ss.android.downloadlib.ox.ko() { // from class: com.ss.android.downloadlib.mb.1
                @Override // com.ss.android.downloadlib.ox.ko
                public void mb(boolean z2) {
                    Logger.d(mb.mb, "appBackForeground->" + z2);
                    if (!z2) {
                        if (com.ss.android.downloadlib.ox.mb.mb(str, oxVarMb) || oxVarMb.w() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.mb.mb.mb().mb(oxVarMb);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.ox.u.b(oxVarMb) ? com.ss.android.downloadlib.ox.mb.mb(str, oxVarMb) : false) && com.ss.android.downloadlib.ox.u.hj(oxVarMb) && oxVarMb.w() == 4) {
                        com.ss.android.downloadlib.addownload.mb.mb.mb().mb(oxVarMb);
                    }
                }
            }, com.ss.android.downloadlib.utils.hj.mb(oxVarMb).optInt("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.b.ww.mb().u(oxVarMb);
            mb(str, oxVarMb);
            com.ss.android.downloadlib.addownload.mb.mb.mb().ox(str);
            DownloadInfo downloadInfoMb = mb((List<DownloadInfo>) Downloader.getInstance(x.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (downloadInfoMb != null) {
                if (DownloadSetting.obtain(downloadInfoMb.getId()).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
                    DownloadNotificationManager.getInstance().hideNotification(downloadInfoMb.getId());
                }
                ko.mb().ox(downloadInfoMb, str);
                com.ss.android.downloadlib.addownload.ox.hj.mb(downloadInfoMb);
            } else {
                ko.mb().ox(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject ox(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        mbVar.mb(jSONObject);
        try {
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.utils.h.mb(jSONObject, downloadInfo.getId());
        AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, oxVarMb);
        return jSONObject;
    }

    void mb(DownloadInfo downloadInfo, com.ss.android.downloadad.api.mb.ox oxVar, int i2) {
        long jMax;
        if (downloadInfo == null || oxVar == null) {
            return;
        }
        ox();
        long jCurrentTimeMillis = System.currentTimeMillis();
        oxVar.ox(jCurrentTimeMillis);
        oxVar.ko(jb.mb(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            jMax = a.f9492f;
        } else {
            long jOptLong = DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", 120000L);
            if (jOptLong < 0) {
                return;
            } else {
                jMax = Math.max(jOptLong, 30000L);
            }
        }
        long j2 = jMax;
        ox oxVar2 = new ox(oxVar.ox(), downloadInfo.getId(), jCurrentTimeMillis, i2);
        hj.mb().mb(oxVar2, j2);
        this.b = oxVar2;
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
    }

    public void mb(final long j2, int i2) {
        long jOptLong = DownloadSetting.obtain(i2).optLong("check_install_finish_hijack_delay_time", 900000L);
        if (jOptLong < 0) {
            return;
        }
        hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.mb.2
            @Override // java.lang.Runnable
            public void run() {
                mb.mb().mb(j2);
            }
        }, Math.max(jOptLong, 300000L));
    }

    public void mb(long j2) {
        hj.mb mbVarMb;
        int iIntValue;
        try {
            com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j2);
            if (oxVarHj != null && !jb.ox(oxVarHj) && !oxVarHj.b.get()) {
                Pair<hj.mb, Integer> pairOx = com.ss.android.downloadlib.addownload.model.hj.mb().ox(oxVarHj);
                if (pairOx != null) {
                    mbVarMb = (hj.mb) pairOx.first;
                    iIntValue = ((Integer) pairOx.second).intValue();
                } else {
                    mbVarMb = com.ss.android.downloadlib.addownload.model.hj.mb().mb(oxVarHj);
                    iIntValue = -1;
                }
                if (mbVarMb == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.model.hj.mb().ox(mbVarMb.mb);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_APP_NAME, mbVarMb.hj);
                jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_PKG_NAME, mbVarMb.mb);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.utils.h.mb(jSONObject, oxVarHj.m());
                    AdEventHandler.mb().ox(EventConstants.Label.INSTALL_FINISH_HIJACK, jSONObject, oxVarHj);
                    return;
                }
                AdEventHandler.mb().ox(EventConstants.Label.INSTALL_FINISH_MAY_HIJACK, jSONObject, oxVarHj);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.exception.b.mb().mb(th, "trySendInstallFinishHijack");
        }
    }

    public void mb(String str, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar != null && jb.ox(oxVar) && oxVar.b.compareAndSet(false, true)) {
            AdEventHandler.mb().mb(oxVar.x(), EventConstants.Label.INSTALL_FINISH, mb(oxVar, str, oxVar.w() != 4 ? 3 : 4), oxVar);
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        }
    }

    private static DownloadInfo mb(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (jb.mb(x.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject mb(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i2 = 1;
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put(MonitorConstants.EXTRA_CUR_NETWORK_QUALITY, NetTrafficManager.getInstance().getCurrentNetworkQuality().name());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_TOTAL_RETRY_COUNT, downloadInfo.getTotalRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put(MonitorConstants.EXTRA_REAL_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime());
                jSONObject.put(EventConstants.ExtraJson.KEY_FIRST_SPEED_TIME, downloadInfo.getFirstSpeedTime());
                jSONObject.put(EventConstants.ExtraJson.KEY_ALL_CONNECT_TIME, downloadInfo.getAllConnectTime());
                jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_PREPARE_TIME, downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put(MonitorConstants.EXTRA_CHUNK_DOWNGRADE_UESD, downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put(MonitorConstants.EXTRA_PRECONNECT_LEVEL, downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put(EventConstants.ExtraJson.EXPECT_FILE_LENGTH, downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes();
                Double.isNaN(curBytes);
                double d2 = curBytes / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime();
                Double.isNaN(realDownloadTime);
                double d3 = realDownloadTime / 1000.0d;
                if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE && d3 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    double d4 = d2 / d3;
                    try {
                        jSONObject.put("download_speed", d4);
                    } catch (Exception unused) {
                    }
                    Logger.d(mb, "download speed : " + d4 + "MB/s");
                }
                try {
                    jSONObject.put(EventConstants.ExtraJson.KEY_IS_DOWNLOAD_SERVICE_FOREGROUND, Downloader.getInstance(x.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_CLEAR_SPACE_RESTART_TIMES, com.ss.android.downloadlib.addownload.ox.hj.mb().ox(downloadInfo.getUrl()));
                jSONObject.put(EventConstants.ExtraJson.MIME_TYPE, downloadInfo.getMimeType());
                if (!DownloadUtils.isNetworkConnected(x.getContext())) {
                    i2 = 2;
                }
                jSONObject.put(EventConstants.ExtraJson.NETWORK_AVAILABLE, i2);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                ox(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int mb(com.ss.android.downloadad.api.mb.ox oxVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iOx = com.ss.android.socialbase.appdownloader.b.ox(x.getContext(), downloadInfo);
        int iOx2 = jb.ox(x.getContext(), str);
        if (iOx > 0 && iOx2 > 0 && iOx != iOx2) {
            return iOx2 > iOx ? 3011 : 3010;
        }
        if (DownloadSetting.obtain(oxVar.m()).optInt("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = x.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(oxVar.ox()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.utils.mb.mb(downloadInfo.getTargetFilePath());
        }
        int iMb = com.ss.android.downloadlib.utils.mb.mb(string, com.ss.android.downloadlib.utils.mb.ox(str));
        try {
            jSONObject.put(EventConstants.ExtraJson.TTMD5_STATUS, iMb);
        } catch (Throwable unused) {
        }
        if (iMb == 0) {
            return 3000;
        }
        return iMb == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.mb
    public void mb(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.ox < 120000) {
            return;
        }
        hj.mb().mb(new RunnableC0512mb(i2), this.ox > 0 ? a.f9492f : 8000L);
        this.ox = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void mb(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> concurrentHashMap, int i2) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.mb.ox oxVar : concurrentHashMap.values()) {
            if (oxVar.b.get()) {
                if (jCurrentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                }
            } else if (oxVar.sw() == 1) {
                if (hj(oxVar) <= 0 && jCurrentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(oxVar.ox()));
                }
            } else if (oxVar.sw() == 2) {
                if (!oxVar.s()) {
                    if (jb.ox(oxVar)) {
                        if (oxVar.w() == 4) {
                            i2 = oxVar.w();
                        }
                        AdEventHandler.mb().mb(mb(oxVar, oxVar.h(), i2), oxVar);
                        arrayList.add(Long.valueOf(oxVar.ox()));
                        com.ss.android.downloadlib.addownload.ox.hj.mb(oxVar);
                    } else if (jCurrentTimeMillis - oxVar.wn() >= DownloadSetting.obtain(oxVar.m()).optInt("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(oxVar.ox()));
                    } else if (TextUtils.isEmpty(oxVar.h())) {
                        arrayList.add(Long.valueOf(oxVar.ox()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(oxVar.ox()));
            }
        }
        com.ss.android.downloadlib.addownload.model.u.mb().mb(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.ox.b
    public void mb(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar) {
        JSONObject jSONObjectOx;
        if (downloadInfo == null || mbVar == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (mbVar.ox != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayOptJSONArray == null || (jSONObjectOx = ox(downloadInfo, mbVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectOx);
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        hj.mb().mb(new b(oxVar));
    }

    private JSONObject mb(com.ss.android.downloadad.api.mb.ox oxVar, String str, int i2) {
        com.ss.android.socialbase.appdownloader.mb mbVarMb;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m());
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            com.ss.android.downloadlib.utils.h.mb(jSONObject, oxVar.m());
            com.ss.android.downloadlib.utils.h.mb(oxVar, jSONObject);
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVar.qa() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_AFTER_BACK_APP, oxVar.nq() ? 1 : 2);
            jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SPACE_INSTALL_PARAMS, oxVar.ot() ? "1" : "2");
            if (downloadInfo != null) {
                mb(jSONObject, downloadInfo);
                try {
                    jSONObject.put(EventConstants.ExtraJson.KEY_UNINSTALL_RESUME_COUNT, downloadInfo.getUninstallResumeCount());
                    if (oxVar.xa() > 0) {
                        jSONObject.put(EventConstants.ExtraJson.KEY_INSTALL_TIME, System.currentTimeMillis() - oxVar.xa());
                    }
                } catch (Throwable unused) {
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(string) && (mbVarMb = com.ss.android.socialbase.appdownloader.mb.mb(string)) != null) {
                    mbVarMb.mb(jSONObject);
                }
            }
            int iMb = mb(oxVar, downloadInfo, str, jSONObject);
            jSONObject.put(EventConstants.ExtraJson.FAIL_STATUS, iMb);
            if (iMb == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iMb == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void mb(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, long j6, boolean z2) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            double d2 = j2;
            Double.isNaN(d2);
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_SPACE_BEFORE, Double.valueOf(d2 / 1048576.0d));
            double d3 = j3 - j2;
            Double.isNaN(d3);
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_SPACE_CLEANED, Double.valueOf(d3 / 1048576.0d));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_CLEAN_UP_TIME_COST, Long.valueOf(j5));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_IS_DOWNLOAD_RESTARTED, Integer.valueOf(z2 ? 1 : 0));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_BYTE_REQUIRED, Long.valueOf(j4));
            double d4 = j4 - j3;
            Double.isNaN(d4);
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_BYTE_REQUIRED_AFTER, Double.valueOf(d4 / 1048576.0d));
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_CLEAR_SLEEP_TIME, Long.valueOf(j6));
            com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
            AdEventHandler.mb().mb(EventConstants.UnityLabel.OPTIMIZATION_CLEAN, jSONObject, oxVarMb);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
