package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: compiled from: HttpProxyCache.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f14757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.danikula.videocache.q.b f14758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f14759k;

    public e(h hVar, com.danikula.videocache.q.b bVar) {
        super(hVar, bVar);
        this.f14758j = bVar;
        this.f14757i = hVar;
    }

    private String b(d dVar) throws IOException, ProxyCacheException {
        String strA = this.f14757i.a();
        boolean z2 = !TextUtils.isEmpty(strA);
        long jAvailable = this.f14758j.isCompleted() ? this.f14758j.available() : this.f14757i.length();
        boolean z3 = jAvailable >= 0;
        long j2 = dVar.f14756c ? jAvailable - dVar.b : jAvailable;
        boolean z4 = z3 && dVar.f14756c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f14756c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z3 ? a("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.b), Long.valueOf(jAvailable - 1), Long.valueOf(jAvailable)) : "");
        sb.append(z2 ? a("Content-Type: %s\n", strA) : "");
        sb.append("\n");
        return sb.toString();
    }

    public void a(b bVar) {
        this.f14759k = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.b;
        if (a(dVar)) {
            a(bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }

    private boolean a(d dVar) throws ProxyCacheException {
        long length = this.f14757i.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.f14756c && ((float) dVar.b) > ((float) this.f14758j.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j2) throws IOException, ProxyCacheException {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, j2, bArr.length);
            if (iA != -1) {
                outputStream.write(bArr, 0, iA);
                j2 += (long) iA;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private void b(OutputStream outputStream, long j2) throws IOException, ProxyCacheException {
        h hVar = new h(this.f14757i);
        try {
            hVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = hVar.read(bArr);
                if (i2 != -1) {
                    outputStream.write(bArr, 0, i2);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            hVar.close();
        }
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.danikula.videocache.l
    protected void a(int i2) {
        b bVar = this.f14759k;
        if (bVar != null) {
            bVar.a(this.f14758j.b, this.f14757i.b(), i2);
        }
    }
}
