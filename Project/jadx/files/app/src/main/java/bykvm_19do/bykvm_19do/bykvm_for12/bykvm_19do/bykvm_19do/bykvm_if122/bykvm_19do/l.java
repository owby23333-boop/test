package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    static final Logger a = Logger.getLogger(l.class.getName());

    static final class a implements r {
        final /* synthetic */ t a;
        final /* synthetic */ OutputStream b;

        a(t tVar, OutputStream outputStream) {
            this.a = tVar;
            this.b = outputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                u.a(cVar.b, 0L, j2);
                while (j2 > 0) {
                    this.a.e();
                    o oVar = cVar.a;
                    int iMin = (int) Math.min(j2, oVar.f877c - oVar.b);
                    this.b.write(oVar.a, oVar.b, iMin);
                    oVar.b += iMin;
                    long j3 = iMin;
                    j2 -= j3;
                    cVar.b -= j3;
                    if (oVar.b == oVar.f877c) {
                        cVar.a = oVar.b();
                        p.a(oVar);
                    }
                }
            } catch (IOException e2) {
                throw e2;
            } catch (Exception unused) {
                throw new IOException("Okio write error");
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        public String toString() {
            return "sink(" + this.b + ad.f20406s;
        }
    }

    static final class b implements s {
        final /* synthetic */ t a;
        final /* synthetic */ InputStream b;

        b(t tVar, InputStream inputStream) {
            this.a = tVar;
            this.b = inputStream;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            if (j2 == 0) {
                return 0L;
            }
            try {
                this.a.e();
                o oVarB = cVar.b(1);
                int i2 = this.b.read(oVarB.a, oVarB.f877c, (int) Math.min(j2, 8192 - oVarB.f877c));
                if (i2 == -1) {
                    return -1L;
                }
                oVarB.f877c += i2;
                long j3 = i2;
                cVar.b += j3;
                return j3;
            } catch (AssertionError e2) {
                if (l.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        public String toString() {
            return "source(" + this.b + ad.f20406s;
        }
    }

    static final class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Socket f874k;

        c(Socket socket) {
            this.f874k = socket;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected void i() {
            Level level;
            StringBuilder sb;
            Logger logger;
            Throwable th;
            try {
                this.f874k.close();
            } catch (AssertionError e2) {
                if (!l.a(e2)) {
                    throw e2;
                }
                Logger logger2 = l.a;
                level = Level.WARNING;
                sb = new StringBuilder();
                th = e2;
                logger = logger2;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f874k);
                logger.log(level, sb.toString(), th);
            } catch (Exception e3) {
                Logger logger3 = l.a;
                level = Level.WARNING;
                sb = new StringBuilder();
                th = e3;
                logger = logger3;
                sb.append("Failed to close timed out socket ");
                sb.append(this.f874k);
                logger.log(level, sb.toString(), th);
            }
        }
    }

    private l() {
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    private static r a(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new a(tVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVarC = c(socket);
        return aVarC.a(a(socket.getOutputStream(), aVarC));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new b(tVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVarC = c(socket);
        return aVarC.a(a(socket.getInputStream(), aVarC));
    }

    private static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a c(Socket socket) {
        return new c(socket);
    }
}
