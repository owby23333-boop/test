package cn.kuaipan.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* JADX INFO: loaded from: classes.dex */
public class ProcessMonitorEntity extends HttpEntityWrapper {
    private final IKscTransferListener mListener;
    private final KscSpeedMonitor mMonitor;
    private boolean mMonitorUsed;
    private final boolean mSendMode;

    public ProcessMonitorEntity(HttpEntity httpEntity, KscSpeedMonitor kscSpeedMonitor, IKscTransferListener iKscTransferListener, boolean z) {
        super(httpEntity);
        this.mMonitor = kscSpeedMonitor;
        this.mListener = iKscTransferListener;
        this.mSendMode = z;
        this.mMonitorUsed = false;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        InputStream content = super.getContent();
        if (this.mMonitorUsed) {
            return content;
        }
        IKscTransferListener iKscTransferListener = this.mListener;
        if (iKscTransferListener != null) {
            if (this.mSendMode) {
                iKscTransferListener.setSendTotal(getContentLength());
            } else {
                iKscTransferListener.setReceiveTotal(getContentLength());
            }
        }
        ProcessMonitorInputStream processMonitorInputStream = new ProcessMonitorInputStream(content, this.mMonitor, this.mListener, this.mSendMode);
        this.mMonitorUsed = true;
        return processMonitorInputStream;
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.mMonitorUsed) {
            ProcessMonitorOutputStream processMonitorOutputStream = new ProcessMonitorOutputStream(outputStream, this.mMonitor, this.mListener, this.mSendMode);
            this.mMonitorUsed = true;
            outputStream = processMonitorOutputStream;
        }
        super.writeTo(outputStream);
    }
}
