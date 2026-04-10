package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlService extends IInterface {

    public static class Default implements IDownloadAidlService {
        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadChunk(DownloadChunk downloadChunk) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener1(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2, boolean z3) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean canResume(int i2) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void cancel(int i2, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearData() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearDownloadData(int i2, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void dispatchProcessCallback(int i2, int i3) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void forceDownloadIngoreRecommendSize(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public long getCurBytes(int i2) throws RemoteException {
            return 0L;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadChunk> getDownloadChunk(int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadAidlFileProvider getDownloadFileUriProvider(int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadId(String str, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfo(int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadWithIndependentProcessStatus(int i2) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public INotificationClickAidlCallback getNotificationClickCallback(int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getStatus(int i2) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloading(int i2) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isHttpServiceInit() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isServiceForeground() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pause(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pauseAll() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeAllDownloadChunk(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadInfo(int i2) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadTaskData(int i2) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resetDownloadData(int i2, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restart(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resume(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean retryDelayStart(int i2) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadWithIndependentProcessStatus(int i2, boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setLogLevel(int i2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setThrottleNetSpeed(int i2, long j2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void startForeground(int i2, Notification notification) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void stopForeground(boolean z2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadChunks(int i2, List<DownloadChunk> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateDownloadChunk(int i2, int i3, long j2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlService {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadChunk = 38;
        static final int TRANSACTION_addDownloadListener = 26;
        static final int TRANSACTION_addDownloadListener1 = 27;
        static final int TRANSACTION_addProcessCallback = 49;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 46;
        static final int TRANSACTION_clearDownloadData = 22;
        static final int TRANSACTION_dispatchProcessCallback = 50;
        static final int TRANSACTION_forceDownloadIngoreRecommendSize = 24;
        static final int TRANSACTION_getAllDownloadInfo = 19;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadChunk = 13;
        static final int TRANSACTION_getDownloadFileUriProvider = 54;
        static final int TRANSACTION_getDownloadId = 14;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 15;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadNotificationEventListener = 51;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 37;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 18;
        static final int TRANSACTION_getFailedDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 52;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 17;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 32;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 35;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 28;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 31;
        static final int TRANSACTION_isServiceForeground = 55;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeAllDownloadChunk = 41;
        static final int TRANSACTION_removeDownloadInfo = 40;
        static final int TRANSACTION_removeDownloadListener = 25;
        static final int TRANSACTION_removeDownloadTaskData = 45;
        static final int TRANSACTION_resetDownloadData = 23;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 20;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 21;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_retryDelayStart = 33;
        static final int TRANSACTION_setDownloadNotificationEventListener = 53;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 36;
        static final int TRANSACTION_setLogLevel = 34;
        static final int TRANSACTION_setThrottleNetSpeed = 56;
        static final int TRANSACTION_startForeground = 29;
        static final int TRANSACTION_stopForeground = 30;
        static final int TRANSACTION_syncDownloadChunks = 48;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 47;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadChunk = 42;
        static final int TRANSACTION_updateDownloadInfo = 39;
        static final int TRANSACTION_updateSubDownloadChunk = 43;
        static final int TRANSACTION_updateSubDownloadChunkIndex = 44;

        private static class Proxy implements IDownloadAidlService {
            public static IDownloadAidlService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadChunk(DownloadChunk downloadChunk) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadChunk != null) {
                        parcelObtain.writeInt(1);
                        downloadChunk.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(38, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addDownloadChunk(downloadChunk);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(26, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addDownloadListener(i2, i3, iDownloadAidlListener, i4, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2, boolean z3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    int i5 = 1;
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!z3) {
                        i5 = 0;
                    }
                    parcelObtain.writeInt(i5);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(27, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        Stub.getDefaultImpl().addDownloadListener1(i2, i3, iDownloadAidlListener, i4, z2, z3);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(processAidlCallback != null ? processAidlCallback.asBinder() : null);
                    if (this.mRemote.transact(49, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addProcessCallback(processAidlCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().canResume(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int i2, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancel(i2, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(46, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().clearData();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int i2, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(22, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().clearDownloadData(i2, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.mRemote.transact(50, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().dispatchProcessCallback(i2, i3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void forceDownloadIngoreRecommendSize(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(24, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().forceDownloadIngoreRecommendSize(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllDownloadInfo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurBytes(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadChunk> getDownloadChunk(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadChunk(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadChunk.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadAidlFileProvider getDownloadFileUriProvider(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(54, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadFileUriProvider(i2);
                    }
                    parcelObtain2.readException();
                    return IDownloadAidlFileProvider.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadId(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfo(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfo(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadInfoList(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(51, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadNotificationEventListener(i2);
                    }
                    parcelObtain2.readException();
                    return IDownloadNotificationEventAidlListener.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(37, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFailedDownloadInfosWithMimeType(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public INotificationClickAidlCallback getNotificationClickCallback(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(52, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNotificationClickCallback(i2);
                    }
                    parcelObtain2.readException();
                    return INotificationClickAidlCallback.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStatus(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(32, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(35, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloadCacheSyncSuccess();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(28, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDownloading(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(31, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isHttpServiceInit();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isServiceForeground() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(55, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isServiceForeground();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pause(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseAll();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeAllDownloadChunk(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(41, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeAllDownloadChunk(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(40, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadInfo(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(iDownloadAidlListener != null ? iDownloadAidlListener.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(25, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeDownloadListener(i2, i3, iDownloadAidlListener, i4, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(45, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeDownloadTaskData(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int i2, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(23, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resetDownloadData(i2, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().restart(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(20, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().restartAllFailedDownloadTasks(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(21, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resume(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean retryDelayStart(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(33, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().retryDelayStart(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iDownloadNotificationEventAidlListener != null ? iDownloadNotificationEventAidlListener.asBinder() : null);
                    if (this.mRemote.transact(53, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setDownloadNotificationEventListener(i2, iDownloadNotificationEventAidlListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int i2, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(36, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(i2, z2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (this.mRemote.transact(34, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setLogLevel(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int i2, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    if (this.mRemote.transact(56, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setThrottleNetSpeed(i2, j2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void startForeground(int i2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(29, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().startForeground(i2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void stopForeground(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(30, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().stopForeground(z2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadChunks(int i2, List<DownloadChunk> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(48, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().syncDownloadChunks(i2, list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(47, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(i2, list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(downloadAidlTask != null ? downloadAidlTask.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().tryDownload(downloadAidlTask);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateDownloadChunk(int i2, int i3, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j2);
                    if (this.mRemote.transact(42, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateDownloadChunk(i2, i3, j2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(39, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateDownloadInfo(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateSubDownloadChunk(int i2, int i3, int i4, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeLong(j2);
                    if (this.mRemote.transact(43, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateSubDownloadChunk(i2, i3, i4, j2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    if (this.mRemote.transact(44, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateSubDownloadChunkIndex(i2, i3, i4, i5);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadAidlService)) ? new Proxy(iBinder) : (IDownloadAidlService) iInterfaceQueryLocalInterface;
        }

        public static IDownloadAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadAidlService iDownloadAidlService) {
            if (Proxy.sDefaultImpl != null || iDownloadAidlService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadAidlService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    tryDownload(DownloadAidlTask.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCanResume = canResume(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCanResume ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    resume(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    restart(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseAll();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    long curBytes = getCurBytes(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(curBytes);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int status = getStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(status);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsDownloading = isDownloading(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDownloading ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo downloadInfo = getDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfo != null) {
                        parcel2.writeInt(1);
                        downloadInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadInfoList = getDownloadInfoList(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadInfoList);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadChunk> downloadChunk = getDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadChunk);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadId = getDownloadId(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadId);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    DownloadInfo downloadInfoByUrlAndPath = getDownloadInfoByUrlAndPath(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoByUrlAndPath != null) {
                        parcel2.writeInt(1);
                        downloadInfoByUrlAndPath.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> failedDownloadInfosWithMimeType = getFailedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(failedDownloadInfosWithMimeType);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> successedDownloadInfosWithMimeType = getSuccessedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(successedDownloadInfosWithMimeType);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> downloadingDownloadInfosWithMimeType = getDownloadingDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(downloadingDownloadInfosWithMimeType);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> allDownloadInfo = getAllDownloadInfo();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDownloadInfo);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllFailedDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartAllPauseReserveOnWifiDownloadTasks(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearDownloadData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetDownloadData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    forceDownloadIngoreRecommendSize(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeDownloadListener(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadListener1(parcel.readInt(), parcel.readInt(), IDownloadAidlListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsDownloadSuccessAndFileNotExist = isDownloadSuccessAndFileNotExist(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDownloadSuccessAndFileNotExist ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsHttpServiceInit = isHttpServiceInit();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsHttpServiceInit ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<DownloadInfo> unCompletedDownloadInfosWithMimeType = getUnCompletedDownloadInfosWithMimeType(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unCompletedDownloadInfosWithMimeType);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRetryDelayStart = retryDelayStart(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRetryDelayStart ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLogLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsDownloadCacheSyncSuccess = isDownloadCacheSyncSuccess();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDownloadCacheSyncSuccess ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadWithIndependentProcessStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadWithIndependentProcessStatus = getDownloadWithIndependentProcessStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadWithIndependentProcessStatus);
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    addDownloadChunk(parcel.readInt() != 0 ? DownloadChunk.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateDownloadInfo = updateDownloadInfo(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateDownloadInfo ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRemoveDownloadInfo = removeDownloadInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRemoveDownloadInfo ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeAllDownloadChunk(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunk(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateSubDownloadChunkIndex(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRemoveDownloadTaskData = removeDownloadTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRemoveDownloadTaskData ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearData();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadInfoFromOtherCache(parcel.readInt(), parcel.createTypedArrayList(DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncDownloadChunks(parcel.readInt(), parcel.createTypedArrayList(DownloadChunk.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    addProcessCallback(ProcessAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    dispatchProcessCallback(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadNotificationEventListener != null ? downloadNotificationEventListener.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface(DESCRIPTOR);
                    INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(notificationClickCallback != null ? notificationClickCallback.asBinder() : null);
                    return true;
                case 53:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDownloadNotificationEventListener(parcel.readInt(), IDownloadNotificationEventAidlListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlFileProvider downloadFileUriProvider = getDownloadFileUriProvider(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(downloadFileUriProvider != null ? downloadFileUriProvider.asBinder() : null);
                    return true;
                case 55:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsServiceForeground = isServiceForeground();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsServiceForeground ? 1 : 0);
                    return true;
                case 56:
                    parcel.enforceInterface(DESCRIPTOR);
                    setThrottleNetSpeed(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void addDownloadChunk(DownloadChunk downloadChunk) throws RemoteException;

    void addDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException;

    void addDownloadListener1(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2, boolean z3) throws RemoteException;

    void addProcessCallback(ProcessAidlCallback processAidlCallback) throws RemoteException;

    boolean canResume(int i2) throws RemoteException;

    void cancel(int i2, boolean z2) throws RemoteException;

    void clearData() throws RemoteException;

    void clearDownloadData(int i2, boolean z2) throws RemoteException;

    void dispatchProcessCallback(int i2, int i3) throws RemoteException;

    void forceDownloadIngoreRecommendSize(int i2) throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    long getCurBytes(int i2) throws RemoteException;

    List<DownloadChunk> getDownloadChunk(int i2) throws RemoteException;

    IDownloadAidlFileProvider getDownloadFileUriProvider(int i2) throws RemoteException;

    int getDownloadId(String str, String str2) throws RemoteException;

    DownloadInfo getDownloadInfo(int i2) throws RemoteException;

    DownloadInfo getDownloadInfoByUrlAndPath(String str, String str2) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String str) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int i2) throws RemoteException;

    int getDownloadWithIndependentProcessStatus(int i2) throws RemoteException;

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) throws RemoteException;

    List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback(int i2) throws RemoteException;

    int getStatus(int i2) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) throws RemoteException;

    boolean isDownloading(int i2) throws RemoteException;

    boolean isHttpServiceInit() throws RemoteException;

    boolean isServiceForeground() throws RemoteException;

    void pause(int i2) throws RemoteException;

    void pauseAll() throws RemoteException;

    void removeAllDownloadChunk(int i2) throws RemoteException;

    boolean removeDownloadInfo(int i2) throws RemoteException;

    void removeDownloadListener(int i2, int i3, IDownloadAidlListener iDownloadAidlListener, int i4, boolean z2) throws RemoteException;

    boolean removeDownloadTaskData(int i2) throws RemoteException;

    void resetDownloadData(int i2, boolean z2) throws RemoteException;

    void restart(int i2) throws RemoteException;

    void restartAllFailedDownloadTasks(List<String> list) throws RemoteException;

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) throws RemoteException;

    void resume(int i2) throws RemoteException;

    boolean retryDelayStart(int i2) throws RemoteException;

    void setDownloadNotificationEventListener(int i2, IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) throws RemoteException;

    void setDownloadWithIndependentProcessStatus(int i2, boolean z2) throws RemoteException;

    void setLogLevel(int i2) throws RemoteException;

    void setThrottleNetSpeed(int i2, long j2) throws RemoteException;

    void startForeground(int i2, Notification notification) throws RemoteException;

    void stopForeground(boolean z2) throws RemoteException;

    void syncDownloadChunks(int i2, List<DownloadChunk> list) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int i2, List<DownloadChunk> list) throws RemoteException;

    void tryDownload(DownloadAidlTask downloadAidlTask) throws RemoteException;

    void updateDownloadChunk(int i2, int i3, long j2) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo downloadInfo) throws RemoteException;

    void updateSubDownloadChunk(int i2, int i3, int i4, long j2) throws RemoteException;

    void updateSubDownloadChunkIndex(int i2, int i3, int i4, int i5) throws RemoteException;
}
