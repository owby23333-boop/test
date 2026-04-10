package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.china.common.a.a;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.b.nk;
import com.ss.android.socialbase.appdownloader.b.o;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.BaseDownloader;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private static boolean ko = false;
    private static final String mb = "hj";
    private static volatile hj ox = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static boolean f18058u = false;
    private String b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IOpenInstallerListener f18059e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownloadReceiver f18060h;
    private String hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private IInstallAppHandler f18061io;
    private com.ss.android.socialbase.appdownloader.b.ww jb;
    private com.ss.android.socialbase.appdownloader.b.ko je;
    private x lc;
    private com.ss.android.socialbase.appdownloader.b.b lz;
    private nk nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.b.u f18062o;
    private boolean ww = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.b.hj f18063x;

    private hj() {
    }

    private void e() {
        if (ko) {
            return;
        }
        if (this.f18060h == null) {
            this.f18060h = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme(Constants.KEY_PACKAGE);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme(BmobDbOpenHelper.FILE);
            DownloadComponentManager.getAppContext().registerReceiver(this.f18060h, intentFilter);
            DownloadComponentManager.getAppContext().registerReceiver(this.f18060h, intentFilter2);
            DownloadComponentManager.getAppContext().registerReceiver(this.f18060h, intentFilter3);
            ko = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 21) {
            RetryScheduler.setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.hj.1
                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void cancelRetry(int i2) {
                    RetryJobSchedulerService.mb(i2);
                }

                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void scheduleRetry(DownloadInfo downloadInfo, long j2, boolean z2, int i2) {
                    RetryJobSchedulerService.mb(downloadInfo, j2, z2, i2);
                }
            });
        }
    }

    public static hj x() {
        if (ox == null) {
            synchronized (hj.class) {
                if (ox == null) {
                    ox = new hj();
                }
            }
        }
        return ox;
    }

    public com.ss.android.socialbase.appdownloader.b.ww b() {
        return this.jb;
    }

    public com.ss.android.socialbase.appdownloader.b.u h() {
        return this.f18062o;
    }

    public String hj() {
        return this.hj;
    }

    public nk jb() {
        return this.nk;
    }

    public com.ss.android.socialbase.appdownloader.b.ko je() {
        return this.je;
    }

    public x ko() {
        return this.lc;
    }

    public IOpenInstallerListener lc() {
        return this.f18059e;
    }

    public String lz() {
        return this.b;
    }

    public IReserveWifiStatusListener nk() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public IInstallAppHandler o() {
        return this.f18061io;
    }

    public com.ss.android.socialbase.appdownloader.b.hj ox() {
        return this.f18063x;
    }

    public boolean u() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public File ww() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    private void b(Context context) {
        if (context == null || f18058u) {
            return;
        }
        DownloadConstants.setMimeApk(AdBaseConstants.MIME_APK);
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.hj.ox());
        e();
        l();
        f18058u = true;
    }

    public void ox(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    private DownloadInfo ox(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public com.ss.android.socialbase.appdownloader.b.b mb() {
        return this.lz;
    }

    public void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hj = str;
    }

    public void mb(x xVar) {
        this.lc = xVar;
    }

    public List<DownloadInfo> ox(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    @Deprecated
    public void mb(Context context, String str, com.ss.android.socialbase.appdownloader.b.b bVar, com.ss.android.socialbase.appdownloader.b.hj hjVar, com.ss.android.socialbase.appdownloader.b.ww wwVar) {
        if (bVar != null) {
            this.lz = bVar;
        }
        if (hjVar != null) {
            this.f18063x = hjVar;
        }
        if (wwVar != null) {
            this.jb = wwVar;
        }
        b(context);
    }

    public static boolean mb(Context context, int i2) {
        return b.mb(context, i2, true) == 1;
    }

    public void mb(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i2);
                    break;
                case -3:
                    b.mb(context, i2, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i2);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int mb(u uVar) {
        int i2;
        String str;
        int i3;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (uVar == null || uVar.getContext() == null) {
            return 0;
        }
        try {
            List<HttpHeader> listMb = mb(uVar.hj());
            String strMb = uVar.mb();
            if (TextUtils.isEmpty(strMb)) {
                return 0;
            }
            final int iM = uVar.m();
            final boolean z2 = iM == 0;
            String strAl = uVar.al();
            final String strOx = uVar.ox();
            if (TextUtils.isEmpty(strAl)) {
                strAl = b.mb(strMb, strOx, uVar.je(), z2);
            }
            if (strAl.length() > 255) {
                strAl = strAl.substring(strAl.length() - 255);
            }
            if (TextUtils.isEmpty(strOx)) {
                strOx = strAl;
            }
            String strJe = uVar.je();
            if (strAl.endsWith(a.f6395g) && !b.b(uVar.je())) {
                strJe = AdBaseConstants.MIME_APK;
            }
            String strB = uVar.b();
            if (TextUtils.isEmpty(uVar.b())) {
                strB = b.ox();
            }
            String str2 = strB;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strAl)) {
                int downloadId = DownloadComponentManager.getDownloadId(strMb, str2);
                if (DownloadSetting.obtain(uVar.kg()).optBugFix(DownloadSettingKeys.BugFix.FIX_RESUME_TASK_OVERRIDE_SETTINGS) && (downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(downloadId)) != null) {
                    try {
                        uVar.mb(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                DownloadSetting.addTaskDownloadSetting(downloadId, uVar.kg());
                boolean zW = uVar.w();
                boolean z3 = (DownloadSetting.obtain(downloadId).optInt("modify_force", 1) == 1 && !zW && DownloadUtils.isFileExist(str2, strAl) && Downloader.getInstance(uVar.getContext()).getDownloadInfo(downloadId) == null) ? true : zW;
                IDownloadListener iDownloadListenerX = uVar.x();
                if (iDownloadListenerX != null || (!uVar.h() && !uVar.u())) {
                    i2 = downloadId;
                    str = str2;
                } else if (uVar.o() != null) {
                    iDownloadListenerX = new com.ss.android.socialbase.appdownloader.h.ox(uVar.o());
                    i2 = downloadId;
                    str = str2;
                } else {
                    i2 = downloadId;
                    str = str2;
                    iDownloadListenerX = new com.ss.android.socialbase.appdownloader.h.ox(uVar.getContext(), downloadId, strOx, str, strAl, uVar.jb());
                }
                IDownloadDepend iDownloadDependPa = uVar.pa();
                if (iDownloadDependPa == null) {
                    iDownloadDependPa = new IDownloadDepend() { // from class: com.ss.android.socialbase.appdownloader.hj.2
                        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
                        public void monitorLogSend(DownloadInfo downloadInfo2, BaseException baseException, int i4) {
                            if (hj.this.jb != null) {
                                hj.this.jb.mb(downloadInfo2, baseException, i4);
                            }
                        }
                    };
                }
                List<IDownloadCompleteHandler> downloadCompleteHandlers = DownloadComponentManager.getDownloadCompleteHandlers();
                if (!downloadCompleteHandlers.isEmpty()) {
                    Iterator<IDownloadCompleteHandler> it = downloadCompleteHandlers.iterator();
                    while (it.hasNext()) {
                        uVar.mb(it.next());
                    }
                }
                String strJb = uVar.jb();
                try {
                    if (!TextUtils.isEmpty(strJb)) {
                        jSONObject = new JSONObject(strJb);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", uVar.ko());
                    jSONObject.put(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, uVar.u());
                    strJb = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z4 = uVar.h() || uVar.u();
                if (!z4 || DownloadSetting.obtain(i2).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) < 1) {
                    i3 = i2;
                } else {
                    i3 = i2;
                    com.ss.android.socialbase.appdownloader.h.b.mb().mb(i3, uVar.up());
                }
                final DownloadTask autoInstall = BaseDownloader.with(uVar.getContext()).url(strMb).backUpUrls(uVar.nq()).name(strAl).title(strOx).savePath(str).onlyWifi(uVar.ww()).extraHeaders(listMb).depend(iDownloadDependPa).retryCount(uVar.r()).backUpUrlRetryCount(uVar.on()).showNotification(z4).extra(strJb).mimeType(strJe).minProgressTimeMsInterval(uVar.nf()).maxProgressCount(uVar.fu()).mainThreadListener(uVar.lz()).notificationListener(iDownloadListenerX).notificationEventListener(mb(uVar.yr())).force(z3).autoResumed(uVar.e()).showNotificationForAutoResumed(uVar.l()).chunkStategy(uVar.lc()).chunkAdjustCalculator(uVar.io()).needHttpsToHttpRetry(uVar.nk()).packageName(uVar.gm()).md5(uVar.g()).expectFileLength(uVar.df()).needRetryDelay(uVar.jq()).retryDelayTimeArray(uVar.a()).needDefaultHttpServiceBackUp(uVar.ng()).needReuseFirstConnection(uVar.ge()).needReuseChunkRunnable(uVar.ep()).needIndependentProcess(uVar.sw()).enqueueType(uVar.bv()).monitorDepend(uVar.vy()).retryDelayTimeCalculator(uVar.xa()).headConnectionAvailable(uVar.wn()).fileUriProvider(uVar.z()).diskSpaceHandler(uVar.kk()).needChunkDowngradeRetry(uVar.q()).notificationClickCallback(uVar.i()).downloadSetting(uVar.kg()).iconUrl(uVar.up()).needSDKMonitor(uVar.qa()).monitorScene(uVar.tl()).extraMonitorStatus(uVar.n()).executorGroup(uVar.sa()).throttleNetSpeed(uVar.sr()).distinctDirectory(uVar.s()).setAutoInstall(uVar.cd());
                if (autoInstall != null && !uVar.ot().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(uVar.ot());
                }
                if (autoInstall != null) {
                    if (z4 && uVar.fb() && uVar.getActivity() != null && !uVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.h.hj.mb()) {
                        com.ss.android.socialbase.appdownloader.h.hj.mb(uVar.getActivity(), new o() { // from class: com.ss.android.socialbase.appdownloader.hj.3
                            @Override // com.ss.android.socialbase.appdownloader.b.o
                            public void mb() {
                                Logger.d(hj.mb, "notification permission granted, start download :" + strOx);
                                hj.this.mb(autoInstall, iM, z2);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.b.o
                            public void ox() {
                                Logger.d(hj.mb, "notification permission denied, start download :" + strOx);
                                hj.this.mb(autoInstall, iM, z2);
                            }
                        });
                    } else {
                        Logger.d(mb, "notification permission need not request, start download :" + strOx);
                        mb(autoInstall, iM, z2);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i3;
            }
            return 0;
        } catch (Throwable th) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(uVar.vy(), null, new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(th, "addDownloadTask")), 0);
            Logger.e(mb, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(DownloadTask downloadTask, int i2, boolean z2) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z2) {
            return;
        }
        downloadInfo.setSavePathRedirected(z2);
    }

    private List<HttpHeader> mb(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z2 = true;
                    }
                    arrayList.add(new HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z2) {
            arrayList.add(new HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.ox.mb.mb));
        }
        return arrayList;
    }

    public String mb(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(a.f6395g) || b.b(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private IDownloadNotificationEventListener mb(final com.ss.android.socialbase.appdownloader.b.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.hj.4
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return hVar.mb();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z2) {
                return hVar.mb(z2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i2, DownloadInfo downloadInfo, String str, String str2) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 8:
                            hVar.mb(i2, downloadInfo.getPackageName(), str, str2);
                            break;
                        case 9:
                            hVar.mb(DownloadComponentManager.getAppContext(), str);
                            break;
                        case 10:
                            hVar.mb(downloadInfo);
                            break;
                    }
                }
                hVar.mb(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        };
    }

    public DownloadInfo mb(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoMb = mb(context, str, ww());
                if (downloadInfoMb == null) {
                    downloadInfoMb = mb(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoMb == null) {
                    downloadInfoMb = mb(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoMb == null) {
                    downloadInfoMb = mb(context, str, context.getFilesDir());
                }
                return (downloadInfoMb == null && DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) ? ox(context, str) : downloadInfoMb;
            } catch (Throwable th) {
                Logger.d(mb, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo mb(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> mb(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void mb(com.ss.android.socialbase.appdownloader.b.ko koVar) {
        this.je = koVar;
    }

    public void mb(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void mb(IInstallAppHandler iInstallAppHandler) {
        this.f18061io = iInstallAppHandler;
    }

    public void mb(IOpenInstallerListener iOpenInstallerListener) {
        this.f18059e = iOpenInstallerListener;
    }
}
