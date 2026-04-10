package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
final class a {

    interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    public static String hR(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                @Override // com.kwai.library.ipneigh.a.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }

                private static String a(BufferedReader bufferedReader) throws IOException {
                    String line = bufferedReader.readLine();
                    while (bufferedReader.readLine() != null) {
                    }
                    return line;
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }

    private static <T> T a(String str, b<T> bVar) throws Throwable {
        BufferedReader bufferedReader;
        Process processExec;
        C0432a c0432a;
        Process process = null;
        try {
            processExec = Runtime.getRuntime().exec(str);
            try {
                c0432a = new C0432a(processExec.getErrorStream());
                c0432a.start();
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            T tB = bVar.b(bufferedReader);
            c0432a.join();
            processExec.waitFor();
            if (processExec != null) {
                processExec.destroy();
            }
            closeQuietly(bufferedReader);
            return tB;
        } catch (Throwable th3) {
            th = th3;
            process = processExec;
            if (process != null) {
                process.destroy();
            }
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.kwai.library.ipneigh.a$a, reason: collision with other inner class name */
    static class C0432a extends Thread {
        private final InputStream bfk;

        public C0432a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.bfk = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws Throwable {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.bfk));
                do {
                    try {
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        a.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader.readLine() != null);
                a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
    }
}
