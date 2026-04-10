package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: classes4.dex */
public class ch extends cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f2213a;
    protected OutputStream b;

    @Override // com.umeng.analytics.pro.cj
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b() throws ck {
    }

    protected ch() {
        this.f2213a = null;
        this.b = null;
    }

    public ch(InputStream inputStream) {
        this.b = null;
        this.f2213a = inputStream;
    }

    public ch(OutputStream outputStream) {
        this.f2213a = null;
        this.b = outputStream;
    }

    public ch(InputStream inputStream, OutputStream outputStream) {
        this.f2213a = inputStream;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.cj
    public void c() {
        InputStream inputStream = this.f2213a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f2213a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public int a(byte[] bArr, int i, int i2) throws ck {
        InputStream inputStream = this.f2213a;
        if (inputStream == null) {
            throw new ck(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new ck(4);
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void b(byte[] bArr, int i, int i2) throws ck {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new ck(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.cj
    public void d() throws ck {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new ck(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e) {
            throw new ck(0, e);
        }
    }
}
