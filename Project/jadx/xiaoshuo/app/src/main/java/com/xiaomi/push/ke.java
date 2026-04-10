package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes8.dex */
public class ke extends kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f8153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected OutputStream f873a;

    public ke() {
        this.f8153a = null;
        this.f873a = null;
    }

    @Override // com.xiaomi.push.kh
    public int a(byte[] bArr, int i, int i2) throws ki {
        InputStream inputStream = this.f8153a;
        if (inputStream == null) {
            throw new ki(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new ki(4);
        } catch (IOException e) {
            throw new ki(0, e);
        }
    }

    public ke(OutputStream outputStream) {
        this.f8153a = null;
        this.f873a = outputStream;
    }

    @Override // com.xiaomi.push.kh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo690a(byte[] bArr, int i, int i2) throws ki {
        OutputStream outputStream = this.f873a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new ki(0, e);
            }
        }
        throw new ki(1, "Cannot write to null outputStream");
    }
}
