package com.kwad.sdk;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    public int downloadType;
    private int mAllowedNetworkTypes;
    protected transient com.kwad.framework.filedownloader.a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;
    private transient List<a> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    private boolean notificationRemoved = false;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.f(this.mTag);
        this.mBaseDownloadTask.bf((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.bl(entry.getKey());
            this.mBaseDownloadTask.u(entry.getKey(), entry.getValue());
        }
    }

    void instantiateDownloadTask() {
        String path;
        r.xI();
        com.kwad.framework.filedownloader.a aVarBq = r.bm(this.mUrl).bd(true).bq(3);
        if (TextUtils.isEmpty(this.mDestinationFileName)) {
            path = this.mDestinationDir;
        } else {
            path = new File(this.mDestinationDir, this.mDestinationFileName).getPath();
        }
        this.mBaseDownloadTask = aVarBq.c(path, TextUtils.isEmpty(this.mDestinationFileName)).a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.sdk.DownloadTask.1
            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z, int i, int i2) {
                DownloadTask.this.onConnected(aVar, str, z, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPending(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onDownloading(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
                DownloadTask.this.onPause(aVar, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void d(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }
        });
    }

    void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    void userPause() {
        this.mUserPause = true;
        pause();
    }

    int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / smallFileTotalBytes) : 0;
        if (smallFileSoFarBytes != 100 || w.P(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return smallFileSoFarBytes;
        }
        return 0;
    }

    void installApk() {
        try {
            c.AA().g(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void resume(DownloadRequest downloadRequest) {
        if (ao.isNetworkConnected(c.AA().getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (!this.mBaseDownloadTask.isRunning()) {
                try {
                    if (com.kwad.framework.filedownloader.d.d.bY(this.mBaseDownloadTask.wJ())) {
                        this.mBaseDownloadTask.wB();
                    }
                    submit();
                    com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
                    onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            com.kwad.framework.filedownloader.a aVar2 = this.mBaseDownloadTask;
            onResume(aVar2, aVar2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
        }
    }

    com.kwad.framework.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    boolean isUserPause() {
        return this.mUserPause;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.wJ() == -2;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.wJ() == -1;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.wJ() == -3;
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.wJ() == 0;
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.wJ();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, i, i2);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLowStorage(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().f(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002d, code lost:
    
        r4 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [long] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onConnected(com.kwad.framework.filedownloader.a r1, java.lang.String r2, boolean r3, int r4, int r5) {
        /*
            r0 = this;
            long r2 = (long) r5
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L28
            java.lang.String r5 = r0.mDestinationDir     // Catch: java.lang.Exception -> L28
            r4.<init>(r5)     // Catch: java.lang.Exception -> L28
            boolean r4 = r4.exists()     // Catch: java.lang.Exception -> L28
            if (r4 == 0) goto L15
            java.lang.String r4 = r0.mDestinationDir     // Catch: java.lang.Exception -> L28
            long r4 = com.kwad.sdk.crash.utils.h.getAvailableBytes(r4)     // Catch: java.lang.Exception -> L28
            goto L2d
        L15:
            boolean r4 = com.kwad.sdk.utils.bc.useStoragePermissionDisable()     // Catch: java.lang.Exception -> L28
            if (r4 != 0) goto L2c
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L28
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Exception -> L28
            long r4 = com.kwad.sdk.crash.utils.h.getAvailableBytes(r4)     // Catch: java.lang.Exception -> L28
            goto L2d
        L28:
            r4 = move-exception
            r4.printStackTrace()
        L2c:
            r4 = r2
        L2d:
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L43
            com.kwad.sdk.c r2 = com.kwad.sdk.c.AA()
            int r3 = r1.getId()
            r2.cancel(r3)
            r0.notifyDownloadCanceled()
            r0.onLowStorage(r1)
            return
        L43:
            java.util.List<com.kwad.sdk.a> r2 = r0.mDownloadListeners     // Catch: java.lang.Exception -> L58
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L58
        L49:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L58
            if (r3 == 0) goto L53
            r2.next()     // Catch: java.lang.Exception -> L58
            goto L49
        L53:
            r2 = 0
            r0.notifyDownloadProgress(r1, r2)     // Catch: java.lang.Exception -> L58
            return
        L58:
            r1 = move-exception
            r1.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.DownloadTask.onConnected(com.kwad.framework.filedownloader.a, java.lang.String, boolean, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwad.framework.filedownloader.a aVar, Throwable th) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, th);
            }
            notifyDownloadError(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCanceled(com.kwad.framework.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.xI().q(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a(null);
        clearListener();
    }

    private void onResume(com.kwad.framework.filedownloader.a aVar, int i, int i2) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadCompleted(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.3
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadProgress(com.kwad.framework.filedownloader.a aVar, final boolean z) {
        if ((aVar.getSmallFileTotalBytes() == 0 && aVar.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(aVar.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(DownloadTask.this, z);
            }
        });
    }

    private void notifyDownloadError(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.g.a<d> aVar) {
        d dVarAC = c.AA().AC();
        if (dVarAC == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            dVarAC.co(downloadTask.getId());
        } else {
            aVar.accept(dVarAC);
        }
    }

    private void notifyDownloadCanceled() {
        d dVarAC = c.AA().AC();
        if (dVarAC == null) {
            return;
        }
        dVarAC.co(getId());
    }

    public void addListener(a aVar) {
        if (aVar == null || this.mDownloadListeners.contains(aVar)) {
            return;
        }
        this.mDownloadListeners.add(aVar);
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.wQ() && isError() && (this.mBaseDownloadTask.wL() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public void setNotificationRemoved(boolean z) {
        this.notificationRemoved = z;
    }

    public void setAllowedNetworkTypes(int i) {
        this.mAllowedNetworkTypes = i;
        this.mBaseDownloadTask.bf((i ^ 2) == 0);
    }

    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;

        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        private String mDestinationDir = c.AA().AB().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo networkInfoDe = ao.de(c.AA().getContext());
            if (networkInfoDe != null && networkInfoDe.getType() == 0) {
                this.mAllowedNetworkTypes = 3;
            } else {
                this.mAllowedNetworkTypes = 2;
            }
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            ax.hh(str);
            if (str.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            if (str2 == null) {
                str2 = "";
            }
            this.mRequestHeaders.put(str, str2);
            return this;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public DownloadRequest setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        public DownloadRequest setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public void setDownloadEnablePause(boolean z) {
            this.downloadEnablePause = z;
        }
    }
}
