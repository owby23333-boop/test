package cn.kuaipan.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ProcessMonitorOutputStream extends FilterOutputStream {
    private final IKscTransferListener mListener;
    private final KscSpeedMonitor mMonitor;
    private final boolean mSendMode;

    public ProcessMonitorOutputStream(OutputStream outputStream, KscSpeedMonitor kscSpeedMonitor, IKscTransferListener iKscTransferListener, boolean z) {
        super(outputStream);
        this.mMonitor = kscSpeedMonitor;
        this.mListener = iKscTransferListener;
        this.mSendMode = z;
    }

    private void process(long j) {
        if (j >= 0) {
            KscSpeedMonitor kscSpeedMonitor = this.mMonitor;
            if (kscSpeedMonitor != null) {
                kscSpeedMonitor.recode(j);
            }
            IKscTransferListener iKscTransferListener = this.mListener;
            if (iKscTransferListener != null) {
                if (this.mSendMode) {
                    iKscTransferListener.sended(j);
                } else {
                    iKscTransferListener.received(j);
                }
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        process(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        super.write(i);
        process(1L);
    }
}
