package com.bytedance.sdk.component.dl.z;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class wp {
    static final Logger z = Logger.getLogger(wp.class.getName());

    private wp() {
    }

    public static gc z(js jsVar) {
        return new v(jsVar);
    }

    public static a z(fv fvVar) {
        return new i(fvVar);
    }

    public static fv z(OutputStream outputStream) {
        return z(outputStream, new tb());
    }

    private static fv z(final OutputStream outputStream, final tb tbVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tbVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new fv() { // from class: com.bytedance.sdk.component.dl.z.wp.1
            @Override // com.bytedance.sdk.component.dl.z.fv
            public void a_(dl dlVar, long j) throws IOException {
                try {
                    q.z(dlVar.g, 0L, j);
                    while (j > 0) {
                        tbVar.e();
                        pf pfVar = dlVar.z;
                        int iMin = (int) Math.min(j, pfVar.dl - pfVar.g);
                        outputStream.write(pfVar.z, pfVar.g, iMin);
                        pfVar.g += iMin;
                        long j2 = iMin;
                        j -= j2;
                        dlVar.g -= j2;
                        if (pfVar.g == pfVar.dl) {
                            dlVar.z = pfVar.g();
                            ls.z(pfVar);
                        }
                    }
                } catch (IOException | Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.bytedance.sdk.component.dl.z.fv
            public tb z() {
                return tbVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static fv z(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        z zVarDl = dl(socket);
        return zVarDl.z(z(socket.getOutputStream(), zVarDl));
    }

    public static js z(InputStream inputStream) {
        return z(inputStream, new tb());
    }

    private static js z(final InputStream inputStream, final tb tbVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tbVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new js() { // from class: com.bytedance.sdk.component.dl.z.wp.2
            @Override // com.bytedance.sdk.component.dl.z.js
            public long z(dl dlVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    tbVar.e();
                    pf pfVarGc = dlVar.gc(1);
                    int i = inputStream.read(pfVarGc.z, pfVarGc.dl, (int) Math.min(j, 8192 - pfVarGc.dl));
                    if (i == -1) {
                        return -1L;
                    }
                    pfVarGc.dl += i;
                    long j2 = i;
                    dlVar.g += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (wp.z(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.bytedance.sdk.component.dl.z.js
            public tb z() {
                return tbVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static js z(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return z(new FileInputStream(file));
    }

    public static fv g(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return z(new FileOutputStream(file));
    }

    public static fv dl(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return z(new FileOutputStream(file, true));
    }

    public static fv z() {
        return new fv() { // from class: com.bytedance.sdk.component.dl.z.wp.3
            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.bytedance.sdk.component.dl.z.fv
            public void a_(dl dlVar, long j) throws IOException {
                dlVar.gz(j);
            }

            @Override // com.bytedance.sdk.component.dl.z.fv
            public tb z() {
                return tb.dl;
            }
        };
    }

    public static js g(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        z zVarDl = dl(socket);
        return zVarDl.z(z(socket.getInputStream(), zVarDl));
    }

    private static z dl(final Socket socket) {
        return new z() { // from class: com.bytedance.sdk.component.dl.z.wp.4
            @Override // com.bytedance.sdk.component.dl.z.z
            protected IOException g(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.component.dl.z.z
            protected void m_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (wp.z(e)) {
                        wp.z.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    wp.z.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean z(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
