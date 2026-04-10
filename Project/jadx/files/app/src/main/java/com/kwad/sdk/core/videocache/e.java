package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class e extends j {
    private final h amZ;
    private final com.kwad.sdk.core.videocache.kwai.b ana;
    private b anb;

    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
        super(hVar, bVar);
        this.ana = bVar;
        this.amZ = hVar;
    }

    private void a(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, j2, 8192);
            if (iA == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, iA);
                j2 += (long) iA;
            }
        }
    }

    private boolean a(d dVar) {
        long length = this.amZ.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.amY && ((float) dVar.amX) > ((float) this.ana.yH()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String strYQ = this.amZ.yQ();
        boolean z2 = !TextUtils.isEmpty(strYQ);
        long jYH = this.ana.isCompleted() ? this.ana.yH() : this.amZ.length();
        boolean z3 = jYH >= 0;
        long j2 = dVar.amY ? jYH - dVar.amX : jYH;
        boolean z4 = z3 && dVar.amY;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.amY ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z3 ? format("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.amX), Long.valueOf(jYH - 1), Long.valueOf(jYH)) : "");
        sb.append(z2 ? format("Content-Type: %s\n", strYQ) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) {
        h hVar = new h(this.amZ);
        try {
            hVar.U((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = hVar.read(bArr);
                if (i2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, i2);
            }
        } finally {
            hVar.close();
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.anb = bVar;
    }

    public final void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.amX;
        if (a(dVar)) {
            a(bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.j
    protected final void by(int i2) {
        b bVar = this.anb;
        if (bVar != null) {
            bVar.a(this.ana.file, i2);
        }
    }
}
