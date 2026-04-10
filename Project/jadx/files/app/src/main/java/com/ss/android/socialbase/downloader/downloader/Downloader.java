package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Downloader extends BaseDownloader {
    private static volatile Downloader instance;

    static {
        DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
        instance = null;
    }

    private Downloader() {
    }

    Downloader(DownloaderBuilder downloaderBuilder) {
        DownloadComponentManager.initComponent(downloaderBuilder);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Downloader1672829046035dc(java.lang.String r4) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L0;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L55;
                case 95: goto L10;
                case 96: goto L3f;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L55;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L55
        L10:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L17;
                case 61: goto L25;
                case 62: goto L34;
                default: goto L16;
            }
        L16:
            goto L3f
        L17:
            int r3 = 0 - r1
            int r3 = r3 * 0
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L0
        L25:
            int r2 = 18 - r1
            int r2 = r2 * 18
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L55
        L34:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L0
        L3f:
            char[] r4 = r4.toCharArray()
        L43:
            int r0 = r4.length
            if (r2 >= r0) goto L4f
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L43
        L4f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L55:
            r0 = 73
            r1 = 96
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.Downloader.Downloader1672829046035dc(java.lang.String):java.lang.String");
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    DownloadComponentManager.setAppContext(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        initOrCover(downloaderBuilder, false);
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z2) {
        if (downloaderBuilder == null) {
            return;
        }
        if (instance == null) {
            instance = downloaderBuilder.build();
        } else if (!DownloadComponentManager.isInit()) {
            DownloadComponentManager.initComponent(downloaderBuilder);
        } else if (z2) {
            DownloadComponentManager.coverComponent(downloaderBuilder);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int i2) {
        return super.canResume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int i2) {
        super.cancel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int i2, boolean z2) {
        super.cancel(i2, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int i2) {
        super.clearDownloadData(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int i2, boolean z2) {
        super.clearDownloadData(i2, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i2) {
        super.forceDownloadIngoreRecommendSize(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int i2) {
        return super.getCurBytes(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        return super.getDownloadFileUriProvider(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i2) {
        return super.getDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadNotificationEventListener getDownloadNotificationEventListener(int i2) {
        return super.getDownloadNotificationEventListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IReserveWifiStatusListener getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int i2) {
        return super.getStatus(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i2) {
        return super.isDownloadServiceForeground(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int i2) {
        return super.isDownloading(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int i2) {
        super.pause(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        super.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        super.registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i2) {
        super.removeTaskMainListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i2) {
        super.removeTaskNotificationListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i2) {
        super.removeTaskSubListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int i2) {
        super.restart(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int i2) {
        super.resume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        super.setDownloadNotificationEventListener(i2, iDownloadNotificationEventListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int i2) {
        super.setLogLevel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z2) {
        super.setMainThreadListener(i2, iDownloadListener, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        super.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i2, long j2) {
        super.setThrottleNetSpeed(i2, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        super.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        super.unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }
}
