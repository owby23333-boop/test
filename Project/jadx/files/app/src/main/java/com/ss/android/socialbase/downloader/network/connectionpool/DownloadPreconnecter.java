package com.ss.android.socialbase.downloader.network.connectionpool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadPreconnecter {
    private static final long DEFAULT_CONNECTION_OUTDATE_TIME = 300000;
    private static final long DEFAULT_HEAD_INFO_OUTDATE_TIME = 300000;
    private static Runnable sCancelRunnable;
    static long sConnectionOutdatedTime;
    private static final Handler sHandler;
    static long sHeadInfoOutdatedTime;
    private static final HandlerThread sPreconnectThread = new HandlerThread("Downloader-preconnecter");

    private static class CancelRunnable implements Runnable {
        private final String mUrl;

        public CancelRunnable(String str) {
            this.mUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadConnectionPool.getInstance().releaseDownloadConnection(this.mUrl);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        init();
        sPreconnectThread.start();
        sHandler = new Handler(sPreconnectThread.getLooper());
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void asyncFetchHttpHeadInfo(final String str, final IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (TextUtils.isEmpty(str)) {
                    IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = iFetchHttpHeadInfoListener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<HttpHeader> extraHeaders = DownloadPreconnecter.getExtraHeaders(0L, null, null);
                        cachedHeadConnection = DownloadConnectionPool.getInstance().isHeadConnectionExist(str) ? DownloadConnectionPool.getInstance().getCachedHeadConnection(str, extraHeaders) : null;
                        if (cachedHeadConnection == null) {
                            FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, extraHeaders, 0L);
                            try {
                                fakeDownloadHeadHttpConnection.execute();
                                if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                                    DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
                                }
                                cachedHeadConnection = fakeDownloadHeadHttpConnection;
                            } catch (Exception e2) {
                                e = e2;
                                cachedHeadConnection = fakeDownloadHeadHttpConnection;
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th = th;
                                cachedHeadConnection = fakeDownloadHeadHttpConnection;
                                try {
                                    cachedHeadConnection.cancel();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> responseHeaders = cachedHeadConnection.getResponseHeaders();
                        if (iFetchHttpHeadInfoListener != null) {
                            iFetchHttpHeadInfoListener.onFetchFinished(responseHeaders);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        cachedHeadConnection.cancel();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    private static void asyncPreconnect(final int i2, final String str, final List<HttpHeader> list, final long j2, final boolean z2, final boolean z3) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z3) {
                        DownloadPreconnecter.fetchHeadInfo(str, list, j2);
                    }
                    if (z2) {
                        DownloadPreconnecter.createConnection(i2, str, list, j2);
                        Runnable unused = DownloadPreconnecter.sCancelRunnable = new CancelRunnable(str);
                        DownloadPreconnecter.sHandler.postDelayed(DownloadPreconnecter.sCancelRunnable, DownloadPreconnecter.sConnectionOutdatedTime);
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createConnection(int i2, String str, List<HttpHeader> list, long j2) {
        if (DownloadConnectionPool.getInstance().isDownloadConnectionExist(str)) {
            return;
        }
        FakeDownloadHttpConnection fakeDownloadHttpConnection = new FakeDownloadHttpConnection(i2, str, list, j2);
        DownloadConnectionPool.getInstance().putCachedDownloadConnections(str, fakeDownloadHttpConnection);
        try {
            fakeDownloadHttpConnection.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchHeadInfo(String str, List<HttpHeader> list, long j2) {
        if (DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
            return;
        }
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, list, j2);
        DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
        try {
            try {
                fakeDownloadHeadHttpConnection.execute();
            } catch (Throwable th) {
                try {
                    fakeDownloadHeadHttpConnection.cancel();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            fakeDownloadHeadHttpConnection.cancel();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<HttpHeader> getExtraHeaders(long j2, DownloadInfo downloadInfo, List<HttpHeader> list) {
        return DownloadUtils.addRangeHeader(list, downloadInfo == null ? null : downloadInfo.geteTag(), j2, 0L);
    }

    public static Looper getLooper() {
        return sPreconnectThread.getLooper();
    }

    private static void init() {
        sConnectionOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME, 300000L);
        sHeadInfoOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME, 300000L);
        DownloadConnectionPool.getInstance().setMaxCachedDownloadConnectionSize(DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE, 3));
    }

    public static void preconnect(String str, String str2, boolean z2) {
        preconnect(-1, str, str2, null, z2, true);
    }

    public static void preconnect(int i2, String str, String str2, List<HttpHeader> list, boolean z2, boolean z3) {
        long firstOffset;
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(str, str2);
        if (downloadInfo == null) {
            firstOffset = 0;
        } else if (downloadInfo.isDownloadingStatus() || downloadInfo.isDownloaded() || downloadInfo.getChunkCount() > 1) {
            return;
        } else {
            firstOffset = DownloadUtils.getFirstOffset(downloadInfo);
        }
        long j2 = firstOffset;
        asyncPreconnect(i2, str, getExtraHeaders(j2, downloadInfo, list), j2, z2, z3);
    }
}
