package com.bytedance.sdk.component.dl.g.z.z;

import com.bytedance.sdk.component.dl.z.e;
import com.bytedance.sdk.component.dl.z.fv;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class gc extends e {
    private boolean z;

    protected void z(IOException iOException) {
    }

    gc(fv fvVar) {
        super(fvVar);
    }

    @Override // com.bytedance.sdk.component.dl.z.e, com.bytedance.sdk.component.dl.z.fv
    public void a_(com.bytedance.sdk.component.dl.z.dl dlVar, long j) throws IOException {
        if (this.z) {
            dlVar.gz(j);
            return;
        }
        try {
            super.a_(dlVar, j);
        } catch (IOException e) {
            this.z = true;
            z(e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.e, com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
    public void flush() throws IOException {
        if (this.z) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.z = true;
            z(e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.e, com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.z) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.z = true;
            z(e);
        }
    }
}
