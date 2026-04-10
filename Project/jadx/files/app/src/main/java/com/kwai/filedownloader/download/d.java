package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.crash.utils.h;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {
    private final com.kwai.filedownloader.c.c aFI;
    private volatile Thread aFe;
    private final a aGq;
    private final int aGr;
    private final int aGs;
    private final int aGt;
    private long aGu;
    private HandlerThread aGv;
    private volatile boolean aGy;
    private Handler handler;
    private volatile boolean aGw = false;
    private volatile long aGc = 0;
    private final AtomicLong aGx = new AtomicLong();
    private boolean aGz = true;
    private final com.kwai.filedownloader.a.a aFD = b.Ht().Hv();

    public static class a {
        private boolean aGA;
        private Exception aGB;
        private int aGC;

        public final int Gi() {
            return this.aGC;
        }

        public final boolean HU() {
            return this.aGA;
        }

        final void bN(boolean z2) {
            this.aGA = z2;
        }

        final void cN(int i2) {
            this.aGC = i2;
        }

        public final Exception getException() {
            return this.aGB;
        }

        final void h(Exception exc) {
            this.aGB = exc;
        }
    }

    d(com.kwai.filedownloader.c.c cVar, int i2, int i3, int i4) {
        this.aFI = cVar;
        this.aGs = i3 >= 5 ? i3 : 5;
        this.aGt = i4;
        this.aGq = new a();
        this.aGr = i2;
    }

    private void HQ() {
        String strHH = this.aFI.HH();
        String targetFilePath = this.aFI.getTargetFilePath();
        File file = new File(strHH);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwai.filedownloader.e.f.j("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwai.filedownloader.e.d.h(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwai.filedownloader.e.f.j("Can't rename the  temp downloaded file(%s) to the target file(%s)", strHH, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", strHH);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", strHH);
            }
            throw th;
        }
    }

    private void HR() {
        HQ();
        this.aFI.e((byte) -3);
        this.aFD.e(this.aFI.getId(), this.aFI.getTotal());
        this.aFD.cF(this.aFI.getId());
        d((byte) -3);
        if (com.kwai.filedownloader.e.e.IP().aIa) {
            com.kwai.filedownloader.services.f.f(this.aFI);
        }
    }

    private boolean HS() {
        if (this.aFI.isChunked()) {
            com.kwai.filedownloader.c.c cVar = this.aFI;
            cVar.aq(cVar.Ip());
        } else if (this.aFI.Ip() != this.aFI.getTotal()) {
            e(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("sofar[%d] not equal total[%d]", Long.valueOf(this.aFI.Ip()), Long.valueOf(this.aFI.getTotal()))));
            return true;
        }
        return false;
    }

    private void HT() {
        this.aFI.e((byte) -2);
        this.aFD.f(this.aFI.getId(), this.aFI.Ip());
        d((byte) -2);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.aFI.getId();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.aFI.ff(sQLiteFullException.toString());
        this.aFI.e((byte) -1);
        this.aFD.cG(id);
        this.aFD.cF(id);
    }

    private void a(Exception exc, int i2) {
        Exception excF = f(exc);
        this.aGq.h(excF);
        this.aGq.cN(this.aGr - i2);
        this.aFI.e((byte) 5);
        this.aFI.ff(excF.toString());
        this.aFD.a(this.aFI.getId(), excF);
        d((byte) 5);
    }

    private boolean al(long j2) {
        if (!this.aGz) {
            return this.aGu != -1 && this.aGx.get() >= this.aGu && j2 - this.aGc >= ((long) this.aGs);
        }
        this.aGz = false;
        return true;
    }

    private void b(long j2, boolean z2) {
        if (this.aFI.Ip() == this.aFI.getTotal()) {
            this.aFD.d(this.aFI.getId(), this.aFI.Ip());
            return;
        }
        if (this.aGy) {
            this.aGy = false;
            this.aFI.e((byte) 3);
        }
        if (z2) {
            this.aGc = j2;
            d((byte) 3);
            this.aGx.set(0L);
        }
    }

    private synchronized void c(Message message) {
        if (!this.aGv.isAlive()) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (this.aGv.isAlive()) {
                throw e2;
            }
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    private void d(byte b) {
        if (b != -2) {
            com.kwai.filedownloader.message.e.Ij().s(com.kwai.filedownloader.message.f.a(b, this.aFI, this.aGq));
        } else if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aFI.getId()));
        }
    }

    private Exception f(Exception exc) {
        long length;
        String strHH = this.aFI.HH();
        if ((!this.aFI.isChunked() && !com.kwai.filedownloader.e.e.IP().aHZ) || !(exc instanceof IOException) || !new File(strHH).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(strHH);
        if (availableBytes > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return exc;
        }
        File file = new File(strHH);
        if (file.exists()) {
            length = file.length();
        } else {
            com.kwai.filedownloader.e.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(availableBytes, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, length, exc) : new FileDownloadOutOfSpaceException(availableBytes, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, length);
    }

    private static long g(long j2, long j3) {
        if (j3 <= 0) {
            return -1L;
        }
        if (j2 == -1) {
            return 1L;
        }
        long j4 = j2 / (j3 + 1);
        if (j4 <= 0) {
            return 1L;
        }
        return j4;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void g(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excF = f(exc);
        if (excF instanceof SQLiteFullException) {
            a((SQLiteFullException) excF);
            sQLiteFullException = excF;
        } else {
            try {
                this.aFI.e((byte) -1);
                this.aFI.ff(exc.toString());
                this.aFD.a(this.aFI.getId(), excF, this.aFI.Ip());
                sQLiteFullException = excF;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException2 = e2;
                a(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.aGq.h(sQLiteFullException);
        d((byte) -1);
    }

    final void HK() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aGv.quit();
            this.aFe = Thread.currentThread();
            while (this.aGw) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.aFe = null;
        }
    }

    public final void HL() {
        this.aFI.e((byte) 1);
        this.aFD.cH(this.aFI.getId());
        d((byte) 1);
    }

    final void HM() {
        this.aFI.e((byte) 6);
        d((byte) 6);
        this.aFD.cC(this.aFI.getId());
    }

    final void HN() {
        this.aGv = new HandlerThread("source-status-callback", 10);
        this.aGv.start();
        this.handler = new Handler(this.aGv.getLooper(), this);
    }

    final void HO() {
        HT();
    }

    final void HP() {
        if (HS()) {
            return;
        }
        HR();
    }

    final void a(Exception exc, int i2, long j2) {
        this.aGx.set(0L);
        this.aFI.ap(-j2);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i2);
        } else {
            c(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    final void a(boolean z2, long j2, String str, String str2) {
        String strIq = this.aFI.Iq();
        if (strIq != null && !strIq.equals(str)) {
            throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strIq));
        }
        this.aGq.bN(z2);
        this.aFI.e((byte) 2);
        this.aFI.aq(j2);
        this.aFI.fe(str);
        this.aFI.fg(str2);
        this.aFD.a(this.aFI.getId(), j2, str, str2);
        d((byte) 2);
        this.aGu = g(j2, this.aGt);
        this.aGy = true;
    }

    final void e(Exception exc) {
        g(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.aGw = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1e
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L2a
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L2a
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L2a
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L1e
        L17:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2a
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L2a
        L1e:
            r4.aGw = r3
            java.lang.Thread r5 = r4.aFe
            if (r5 == 0) goto L29
            java.lang.Thread r5 = r4.aFe
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L29:
            return r0
        L2a:
            r5 = move-exception
            r4.aGw = r3
            java.lang.Thread r0 = r4.aFe
            if (r0 == 0) goto L36
            java.lang.Thread r0 = r4.aFe
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L36:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aGv;
        return handlerThread != null && handlerThread.isAlive();
    }

    final void onProgress(long j2) {
        this.aGx.addAndGet(j2);
        this.aFI.ap(j2);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zAl = al(jElapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(jElapsedRealtime, zAl);
        } else if (zAl) {
            c(handler.obtainMessage(3));
        }
    }
}
