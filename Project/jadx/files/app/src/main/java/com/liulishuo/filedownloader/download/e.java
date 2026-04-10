package com.liulishuo.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: DownloadStatusCallback.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Handler.Callback {
    private HandlerThread A;
    private volatile Thread C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final FileDownloadModel f17148s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final a f17150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f17151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f17152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f17153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f17154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Handler f17155z;
    private volatile boolean B = false;
    private volatile long D = 0;
    private final AtomicLong E = new AtomicLong();
    private final AtomicBoolean F = new AtomicBoolean(false);
    private final AtomicBoolean G = new AtomicBoolean(false);
    private final AtomicBoolean H = new AtomicBoolean(true);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.liulishuo.filedownloader.e0.a f17149t = c.i().a();

    /* JADX INFO: compiled from: DownloadStatusCallback.java */
    public static class a {
        private boolean a;
        private Exception b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f17156c;

        void a(boolean z2) {
            this.a = z2;
        }

        public int b() {
            return this.f17156c;
        }

        public boolean c() {
            return this.a;
        }

        void a(Exception exc) {
            this.b = exc;
        }

        void a(int i2) {
            this.f17156c = i2;
        }

        public Exception a() {
            return this.b;
        }
    }

    e(FileDownloadModel fileDownloadModel, int i2, int i3, int i4) {
        this.f17148s = fileDownloadModel;
        this.f17152w = i3 >= 5 ? i3 : 5;
        this.f17153x = i4;
        this.f17150u = new a();
        this.f17151v = i2;
    }

    private void h() throws Throwable {
        l();
        this.f17148s.a((byte) -3);
        this.f17149t.a(this.f17148s.e(), this.f17148s.o());
        this.f17149t.e(this.f17148s.e());
        a((byte) -3);
        if (com.liulishuo.filedownloader.h0.e.a().f17211g) {
            com.liulishuo.filedownloader.services.f.a(this.f17148s);
        }
    }

    private void i() {
        this.f17148s.a((byte) -2);
        this.f17149t.c(this.f17148s.e(), this.f17148s.g());
        a((byte) -2);
    }

    private void j() {
        if (this.f17148s.g() == this.f17148s.o()) {
            this.f17149t.b(this.f17148s.e(), this.f17148s.g());
            return;
        }
        if (this.G.compareAndSet(true, false)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.c(this, "handleProgress update model's status with progress", new Object[0]);
            }
            this.f17148s.a((byte) 3);
        }
        if (this.F.compareAndSet(true, false)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.c(this, "handleProgress notify user progress status", new Object[0]);
            }
            a((byte) 3);
        }
    }

    private boolean k() {
        if (this.f17148s.q()) {
            FileDownloadModel fileDownloadModel = this.f17148s;
            fileDownloadModel.c(fileDownloadModel.g());
        } else if (this.f17148s.g() != this.f17148s.o()) {
            a(new FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.h0.f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.f17148s.g()), Long.valueOf(this.f17148s.o()))));
            return true;
        }
        return false;
    }

    private void l() throws Throwable {
        boolean z2;
        String strN = this.f17148s.n();
        String strI = this.f17148s.i();
        File file = new File(strN);
        try {
            File file2 = new File(strI);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.liulishuo.filedownloader.h0.f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", strI, Long.valueOf(length)));
                }
                com.liulishuo.filedownloader.h0.d.e(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", strI, Long.valueOf(length), Long.valueOf(file.length()));
            }
            z2 = !file.renameTo(file2);
            if (!z2) {
                if (z2 && file.exists() && !file.delete()) {
                    com.liulishuo.filedownloader.h0.d.e(this, "delete the temp file(%s) failed, on completed downloading.", strN);
                    return;
                }
                return;
            }
            try {
                throw new IOException(com.liulishuo.filedownloader.h0.f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", strN, strI));
            } catch (Throwable th) {
                th = th;
                if (z2 && file.exists() && !file.delete()) {
                    com.liulishuo.filedownloader.h0.d.e(this, "delete the temp file(%s) failed, on completed downloading.", strN);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
        }
    }

    void a() {
        Handler handler = this.f17155z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.A.quit();
            this.C = Thread.currentThread();
            while (this.B) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.C = null;
        }
    }

    public boolean b() {
        HandlerThread handlerThread = this.A;
        return handlerThread != null && handlerThread.isAlive();
    }

    void c() throws Throwable {
        if (k()) {
            return;
        }
        h();
    }

    void d() {
        this.A = new HandlerThread("source-status-callback");
        this.A.start();
        this.f17155z = new Handler(this.A.getLooper(), this);
    }

    void e() {
        i();
    }

    public void f() {
        this.f17148s.a((byte) 1);
        this.f17149t.a(this.f17148s.e());
        a((byte) 1);
    }

    void g() {
        this.f17148s.a((byte) 6);
        a((byte) 6);
        this.f17149t.b(this.f17148s.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.B = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1a
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L26
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L26
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L26
            r4.b(r1, r5)     // Catch: java.lang.Throwable -> L26
            goto L1a
        L17:
            r4.j()     // Catch: java.lang.Throwable -> L26
        L1a:
            r4.B = r3
            java.lang.Thread r5 = r4.C
            if (r5 == 0) goto L25
            java.lang.Thread r5 = r4.C
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L25:
            return r0
        L26:
            r5 = move-exception
            r4.B = r3
            java.lang.Thread r0 = r4.C
            if (r0 == 0) goto L32
            java.lang.Thread r0 = r4.C
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L32:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.e.handleMessage(android.os.Message):boolean");
    }

    private Exception b(Exception exc) {
        long length;
        String strN = this.f17148s.n();
        if ((!this.f17148s.q() && !com.liulishuo.filedownloader.h0.e.a().f17210f) || !(exc instanceof IOException) || !new File(strN).exists()) {
            return exc;
        }
        long jI = com.liulishuo.filedownloader.h0.f.i(strN);
        if (jI > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return exc;
        }
        File file = new File(strN);
        if (file.exists()) {
            length = file.length();
        } else {
            com.liulishuo.filedownloader.h0.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(jI, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, length, exc) : new FileDownloadOutOfSpaceException(jI, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, length);
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
    private void c(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excB = b(exc);
        if (excB instanceof SQLiteFullException) {
            a((SQLiteFullException) excB);
            sQLiteFullException = excB;
        } else {
            try {
                this.f17148s.a((byte) -1);
                this.f17148s.b(exc.toString());
                this.f17149t.a(this.f17148s.e(), excB, this.f17148s.g());
                sQLiteFullException = excB;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException2 = e2;
                a(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.f17150u.a(sQLiteFullException);
        a((byte) -1);
    }

    void a(boolean z2, long j2, String str, String str2) throws IllegalArgumentException {
        String strB = this.f17148s.b();
        if (strB != null && !strB.equals(str)) {
            throw new IllegalArgumentException(com.liulishuo.filedownloader.h0.f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strB));
        }
        this.f17150u.a(z2);
        this.f17148s.a((byte) 2);
        this.f17148s.c(j2);
        this.f17148s.a(str);
        this.f17148s.c(str2);
        this.f17149t.a(this.f17148s.e(), j2, str, str2);
        a((byte) 2);
        this.f17154y = a(j2, this.f17153x);
        this.G.compareAndSet(false, true);
    }

    private void b(Exception exc, int i2) {
        Exception excB = b(exc);
        this.f17150u.a(excB);
        this.f17150u.a(this.f17151v - i2);
        this.f17148s.a((byte) 5);
        this.f17148s.b(excB.toString());
        this.f17149t.a(this.f17148s.e(), excB);
        a((byte) 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r10) {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.H
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r2, r1)
            if (r0 == 0) goto Lc
        La:
            r0 = 1
            goto L2d
        Lc:
            long r3 = r9.D
            long r3 = r10 - r3
            long r5 = r9.f17154y
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L2c
            java.util.concurrent.atomic.AtomicLong r0 = r9.E
            long r5 = r0.get()
            long r7 = r9.f17154y
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L2c
            int r0 = r9.f17152w
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L2c
            goto La
        L2c:
            r0 = 0
        L2d:
            if (r0 == 0) goto L4b
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.F
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L4b
            boolean r0 = com.liulishuo.filedownloader.h0.d.a
            if (r0 == 0) goto L42
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "inspectNeedCallbackToUser need callback to user"
            com.liulishuo.filedownloader.h0.d.c(r9, r1, r0)
        L42:
            r9.D = r10
            java.util.concurrent.atomic.AtomicLong r10 = r9.E
            r0 = 0
            r10.set(r0)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.e.b(long):void");
    }

    void a(long j2) {
        this.E.addAndGet(j2);
        this.f17148s.a(j2);
        b(SystemClock.elapsedRealtime());
        if (this.f17155z == null) {
            j();
        } else if (this.F.get()) {
            a(this.f17155z.obtainMessage(3));
        }
    }

    void a(Exception exc, int i2) {
        this.E.set(0L);
        Handler handler = this.f17155z;
        if (handler == null) {
            b(exc, i2);
        } else {
            a(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    void a(Exception exc) {
        c(exc);
    }

    private synchronized void a(Message message) {
        if (!this.A.isAlive()) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.f17155z.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (!this.A.isAlive()) {
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
            } else {
                throw e2;
            }
        }
    }

    private static long a(long j2, long j3) {
        if (j3 <= 0) {
            return -1L;
        }
        if (j2 == -1) {
            return 1L;
        }
        long j4 = j2 / j3;
        if (j4 <= 0) {
            return 1L;
        }
        return j4;
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int iE = this.f17148s.e();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(iE), sQLiteFullException.toString());
        }
        this.f17148s.b(sQLiteFullException.toString());
        this.f17148s.a((byte) -1);
        this.f17149t.remove(iE);
        this.f17149t.e(iE);
    }

    private void a(byte b) {
        if (b == -2) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f17148s.e()));
                return;
            }
            return;
        }
        com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(b, this.f17148s, this.f17150u));
    }
}
