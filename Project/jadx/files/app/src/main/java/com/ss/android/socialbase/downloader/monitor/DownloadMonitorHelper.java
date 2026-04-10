package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    private static JSONObject getMonitorJson(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        JSONObject jSONObject;
        String deviceId;
        String devicePostfix;
        String appId;
        int updateVersion;
        String lastPathSegment;
        String host;
        String path;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        try {
            IMonitorConfig monitorConfig = DownloadComponentManager.getMonitorConfig();
            if (monitorConfig != null) {
                deviceId = monitorConfig.getDeviceId();
                devicePostfix = parseDevicePostfix(deviceId);
                appId = monitorConfig.getAppId();
                updateVersion = monitorConfig.getUpdateVersion();
            } else {
                deviceId = "";
                devicePostfix = deviceId;
                appId = devicePostfix;
                updateVersion = 0;
            }
            String requestLog = (baseException == null || !(baseException instanceof DownloadTTNetException)) ? "" : ((DownloadTTNetException) baseException).getRequestLog();
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, str);
            jSONObject.put("app_id", appId);
            jSONObject.put("device_id", deviceId);
            jSONObject.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, devicePostfix);
            jSONObject.put(MonitorConstants.EXTRA_UPDATE_VERSION, updateVersion);
            jSONObject.put("download_status", i2);
            if (downloadInfo != null) {
                jSONObject.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(downloadInfo.getId()).optString(DownloadSettingKeys.SETTING_TAG));
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put("save_path", downloadInfo.getSavePath());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                int i3 = 1;
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, downloadInfo.isForce() ? 1 : 0);
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_REUSE_FIRST_CONNECTION, downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_DELAY_STATUS, downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                if (!downloadInfo.isAddListenerToSameTask()) {
                    i3 = 0;
                }
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, i3);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                try {
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        lastPathSegment = "";
                        host = lastPathSegment;
                        path = host;
                    } else {
                        Uri uri = Uri.parse(url);
                        host = uri.getHost();
                        path = uri.getPath();
                        lastPathSegment = uri.getLastPathSegment();
                        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                            try {
                                path = path.substring(0, path.length() - lastPathSegment.length());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    jSONObject.put(MonitorConstants.URL_HOST, host);
                    jSONObject.put(MonitorConstants.URL_PATH, path);
                    jSONObject.put(MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
            jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject.put(MonitorConstants.REQUEST_LOG, requestLog);
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean isMonitorStatus(int[] iArr, int i2) {
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[PHI: r7
  0x003c: PHI (r7v9 int) = (r7v0 int), (r7v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e A[PHI: r7
  0x007e: PHI (r7v8 int) = (r7v4 int), (r7v4 int), (r7v6 int), (r7v4 int) binds: [B:32:0x0056, B:36:0x0065, B:35:0x0062, B:25:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void monitorDownloadConnect(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void monitorDownloadIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, boolean z2, boolean z3, BaseException baseException, long j2, long j3, boolean z4, long j4, long j5, long j6, JSONObject jSONObject) {
        monitorIO(MonitorConstants.DOWNLOAD_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), downloadSetting, downloadInfo, str, null, null, iDownloadHttpConnection, z2, z3, baseException, j2, j3, z4, j4, j5, j6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0134 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018f A[Catch: all -> 0x01a9, TryCatch #1 {all -> 0x01a9, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:48:0x00c4, B:50:0x00d7, B:52:0x0111, B:53:0x0122, B:55:0x0134, B:59:0x0149, B:61:0x0158, B:63:0x0167, B:64:0x016a, B:76:0x019d, B:69:0x0189, B:71:0x018f, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0196  */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.ss.android.socialbase.downloader.monitor.InnerEventListener] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v17, types: [com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void monitorIO(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.setting.DownloadSetting r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorIO(java.lang.String, int, com.ss.android.socialbase.downloader.setting.DownloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void monitorSegmentIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z2, IDownloadHttpConnection iDownloadHttpConnection, BaseException baseException, long j2, long j3) {
        monitorIO(MonitorConstants.SEGMENT_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), downloadSetting, downloadInfo, str, str2, str3, iDownloadHttpConnection, z2, false, baseException, j2, j3, false, -1L, -1L, -1L, null);
    }

    public static void monitorSegmentsError(DownloadInfo downloadInfo, List<Segment> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            InnerEventListener eventListener = DownloadComponentManager.getEventListener();
            if (eventListener != null) {
                eventListener.onEvent(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSend(DownloadTask downloadTask, BaseException baseException, int i2) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i2);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = isMonitorStatus(downloadInfo.getExtraMonitorStatus(), i2)) && monitorDepend != null && (monitorDepend instanceof AbsDownloadMonitorDepend)) {
                zIsMonitorStatus = isMonitorStatus(((AbsDownloadMonitorDepend) monitorDepend).getAdditionalMonitorStatus(), i2);
            }
            if (zIsMonitorStatus) {
                try {
                    IDownloadDepend depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.monitorLogSend(downloadInfo, baseException, i2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i2);
                monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, baseException, i2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorSendWithGlobalSdkMonitor(IDownloadMonitorListener iDownloadMonitorListener, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (iDownloadMonitorListener == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject monitorJson = getMonitorJson(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (monitorJson == null) {
                monitorJson = new JSONObject();
            }
            if (i2 == -1) {
                monitorJson.put("status", baseException.getErrorCode());
                iDownloadMonitorListener.monitorEvent(EventConstants.Label.DOWNLOAD_FAILED, monitorJson, null, null);
            } else {
                putMonitorJsonStatus(i2, monitorJson, downloadInfo);
                iDownloadMonitorListener.monitorEvent("download_common", monitorJson, null, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (iDownloadMonitorDepend == null) {
            return;
        }
        try {
            String eventPage = iDownloadMonitorDepend.getEventPage();
            if (TextUtils.isEmpty(eventPage)) {
                eventPage = "default";
            }
            JSONObject monitorJson = getMonitorJson(eventPage, downloadInfo, baseException, i2);
            if (monitorJson == null) {
                monitorJson = new JSONObject();
            }
            iDownloadMonitorDepend.monitorLogSend(monitorJson);
        } catch (Throwable unused) {
        }
    }

    public static String parseDevicePostfix(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static void putMonitorJsonStatus(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i2 == -5) {
            str = "download_uncomplete";
        } else if (i2 == -4) {
            str = EventConstants.Label.DOWNLOAD_CANCEL;
        } else if (i2 != -3) {
            str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }
}
