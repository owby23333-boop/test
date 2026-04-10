package com.ss.android.socialbase.downloader.db;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.i.a;
import com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDownloadCacheAidlWrapper implements ServiceConnection, ISqlDownloadCache {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;

    @Nullable
    private ISqlDownloadCacheAidl mISqlDownloadCache;
    private DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener mRebindErrorListener;
    private Future<?> mSetInitCallbackFuture;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ISqlCacheLoadCompleteCallbackAidl mPengingCallback = null;
    private Runnable mCheckAliveRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            if (SqlDownloadCacheAidlWrapper.sIsMainProcessAlive || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                return;
            }
            SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
        }
    };
    private CountDownLatch mInitLock = new CountDownLatch(1);

    public interface OnMainProcessRebindErrorListener {
        void onRebindError();
    }

    public SqlDownloadCacheAidlWrapper() {
        SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindMainProcessDelayed() {
        if (Build.VERSION.SDK_INT >= 26 || sIsMainProcessAlive) {
            return false;
        }
        if (sBindMainProcessTimes > 5) {
            Logger.w(TAG, "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - sLastBindMainProcessTimeMills < 15000) {
            Logger.w(TAG, "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = jCurrentTimeMillis;
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.startServiceAndBind(DownloadComponentManager.getAppContext(), SqlDownloadCacheAidlWrapper.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i2, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskCancel(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i2, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskCompleted(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i2, long j2, String str, String str2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskConnected(i2, j2, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i2, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskError(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskIntercept(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i2, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskPause(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskPrepare(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i2, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskProgress(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.OnDownloadTaskRetry(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.addDownloadChunk(downloadChunk);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.addSubDownloadChunk(downloadChunk);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.cacheExist(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.clearData();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.ensureDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getAllDownloadInfo();
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getDownloadChunk(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getDownloadInfo(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getDownloadInfoList(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getFailedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getSuccessedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.getUnCompletedDownloadInfosWithMimeType(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<DownloadChunk>> sparseArray2, final SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z2;
                SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
                Future future;
                SqlDownloadCacheAidlWrapper.this.setInitCallback(new ISqlCacheLoadCompleteCallbackAidl.Stub() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.4.1
                    @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
                    public void callback(Map map, Map map2) {
                        DownloadUtils.sparseArrayPutAll(sparseArray, map);
                        DownloadUtils.sparseArrayPutAll(sparseArray2, map2);
                        sqlCacheLoadCompleteCallback.callback();
                        SqlDownloadCacheAidlWrapper.this.setInitCallback(null);
                    }
                });
                try {
                    z2 = !SqlDownloadCacheAidlWrapper.this.mInitLock.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z2 = false;
                }
                if (z2 && (future = SqlDownloadCacheAidlWrapper.this.mSetInitCallbackFuture) != null) {
                    future.cancel(true);
                }
                SqlDownloadCacheAidlWrapper.this.init();
                if (!z2 || (sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback) == null) {
                    return;
                }
                sqlCacheLoadCompleteCallback2.callback();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.isDownloadCacheSyncSuccess();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.onDownloadTaskStart(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        try {
            this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (SqlDownloadCacheAidlWrapper.this.mPengingCallback != null && SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache != null) {
                                SqlDownloadCacheAidlWrapper.this.mISqlDownloadCache.setInitCallback(SqlDownloadCacheAidlWrapper.this.mPengingCallback);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                    if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                        return;
                                    }
                                    SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, a.f9492f);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                Logger.e(SqlDownloadCacheAidlWrapper.TAG, "onServiceConnected fail", th2);
                                if (SqlDownloadCacheAidlWrapper.this.mRebindErrorListener != null) {
                                    SqlDownloadCacheAidlWrapper.this.mRebindErrorListener.onRebindError();
                                }
                                SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                                iBinder2 = iBinder;
                                deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                        if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                            return;
                                        }
                                        SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, a.f9492f);
                                    }
                                };
                            } finally {
                                SqlDownloadCacheAidlWrapper.this.mInitLock.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper.2.1
                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = SqlDownloadCacheAidlWrapper.sIsMainProcessAlive = false;
                                            if (SqlDownloadCacheAidlWrapper.this.bindMainProcessDelayed() || SqlDownloadCacheAidlWrapper.this.mRebindErrorListener == null) {
                                                return;
                                            }
                                            SqlDownloadCacheAidlWrapper.this.mHandler.postDelayed(SqlDownloadCacheAidlWrapper.this.mCheckAliveRunnable, a.f9492f);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(deathRecipient, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.removeAllDownloadChunk(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.removeDownloadInfo(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i2) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.removeDownloadTaskData(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        synchronized (this) {
            if (this.mISqlDownloadCache != null) {
                try {
                    this.mISqlDownloadCache.setInitCallback(iSqlCacheLoadCompleteCallbackAidl);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.mPengingCallback = iSqlCacheLoadCompleteCallbackAidl;
            }
        }
    }

    public void setOnMainProcessRebindErrorCallback(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        this.mRebindErrorListener = onMainProcessRebindErrorListener;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i2, List<DownloadChunk> list) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.syncDownloadChunks(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.syncDownloadInfo(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.syncDownloadInfoFromOtherCache(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i2, int i3) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.updateChunkCount(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i2, int i3, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.updateDownloadChunk(i2, i3, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        try {
            if (this.mISqlDownloadCache != null) {
                return this.mISqlDownloadCache.updateDownloadInfo(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i2, Map<Long, Segment> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.updateSubDownloadChunk(i2, i3, i4, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.updateSubDownloadChunkIndex(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        try {
            if (this.mISqlDownloadCache != null) {
                this.mISqlDownloadCache.init();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
