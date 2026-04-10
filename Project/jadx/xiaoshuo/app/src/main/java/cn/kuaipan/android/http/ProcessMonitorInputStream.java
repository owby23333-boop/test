package cn.kuaipan.android.http;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ProcessMonitorInputStream extends FilterInputStream {
    private long mCurrent;
    private final IKscTransferListener mListener;
    private long mMarkPos;
    private final KscSpeedMonitor mMonitor;
    private final boolean mSendMode;

    public ProcessMonitorInputStream(InputStream inputStream, KscSpeedMonitor kscSpeedMonitor, IKscTransferListener iKscTransferListener, boolean z) {
        super(inputStream);
        this.mCurrent = 0L;
        this.mMarkPos = 0L;
        this.mMonitor = kscSpeedMonitor;
        this.mListener = iKscTransferListener;
        this.mSendMode = z;
    }

    private void process(long j) {
        if (j >= 0) {
            this.mCurrent += j;
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

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.mMarkPos = this.mCurrent;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i != -1) {
            process(1L);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        long j = this.mMarkPos;
        this.mCurrent = j;
        IKscTransferListener iKscTransferListener = this.mListener;
        if (iKscTransferListener != null) {
            if (this.mSendMode) {
                iKscTransferListener.setSendPos(j);
            } else {
                iKscTransferListener.setReceivePos(j);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            process(jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 > 0) {
            process(i3);
        }
        return i3;
    }
}
