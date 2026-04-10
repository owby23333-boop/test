package cn.kuaipan.kss.implement;

import cn.kuaipan.kss.KssDef;
import cn.kuaipan.kss.KssDownload;

/* JADX INFO: loaded from: classes.dex */
class _DownloadProgress {
    private KssDef.OnUpDownload m_onDownload = null;
    private boolean m_isCanceled = false;
    private int m_transSize = 0;
    private int m_totalSize = 0;
    private int m_lastSize = 0;
    private int m_notifySize = 0;

    public void TransBytes(int i) {
        if (this.m_onDownload == null || i < 1) {
            return;
        }
        int i2 = this.m_transSize + i;
        this.m_transSize = i2;
        if (i2 >= this.m_totalSize || i2 - this.m_lastSize >= this.m_notifySize) {
            this.m_isCanceled = !r0.OnTransData(i2);
            this.m_lastSize = this.m_transSize;
        }
    }

    public boolean getIsCanceled() {
        return this.m_isCanceled;
    }

    public void init(KssDownload.RequestDownloadInfo requestDownloadInfo, KssDef.OnUpDownload onUpDownload) {
        if (requestDownloadInfo == null) {
            return;
        }
        this.m_onDownload = onUpDownload;
        this.m_isCanceled = false;
        this.m_transSize = 0;
        int fileSize = requestDownloadInfo.getFileSize();
        this.m_totalSize = fileSize;
        this.m_lastSize = 0;
        this.m_notifySize = fileSize / 50;
    }

    public void setIsCanceled(boolean z) {
        this.m_isCanceled = z;
    }

    public void startTrans(KssDownload.DownloadTransControl downloadTransControl) {
        this.m_isCanceled = false;
        int startPos = downloadTransControl.getStartPos();
        this.m_transSize = startPos;
        this.m_lastSize = startPos;
    }
}
