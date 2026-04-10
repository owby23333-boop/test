package com.bytedance.z.g.gc;

import com.bytedance.sdk.component.utils.wp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:9:0x0059 A[DONT_GENERATE, PHI: r4
  0x0059: PHI (r4v5 java.lang.Process) = (r4v4 java.lang.Process), (r4v6 java.lang.Process) binds: [B:8:0x0057, B:4:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> z(int r4, int r5) {
        /*
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r1 = 4
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            java.lang.String r3 = "logcat"
            r1[r2] = r3
            r2 = 1
            java.lang.String r3 = "-t"
            r1[r2] = r3
            r2 = 2
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1[r2] = r4
            r4 = 3
            java.lang.String r5 = z(r5)
            r1[r4] = r5
            r4 = 0
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L53
            java.lang.Process r4 = r5.exec(r1)     // Catch: java.lang.Throwable -> L53
            com.bytedance.z.g.gc.a$z r5 = new com.bytedance.z.g.gc.a$z     // Catch: java.lang.Throwable -> L53
            java.io.InputStream r1 = r4.getInputStream()     // Catch: java.lang.Throwable -> L53
            r5.<init>(r1, r0)     // Catch: java.lang.Throwable -> L53
            r5.start()     // Catch: java.lang.Throwable -> L53
            com.bytedance.z.g.gc.a$z r5 = new com.bytedance.z.g.gc.a$z     // Catch: java.lang.Throwable -> L53
            java.io.InputStream r1 = r4.getErrorStream()     // Catch: java.lang.Throwable -> L53
            r5.<init>(r1, r0)     // Catch: java.lang.Throwable -> L53
            r5.start()     // Catch: java.lang.Throwable -> L53
            com.bytedance.z.g.gc.a$g r5 = new com.bytedance.z.g.gc.a$g     // Catch: java.lang.Throwable -> L53
            r1 = 3000(0xbb8, double:1.482E-320)
            r5.<init>(r4, r1)     // Catch: java.lang.Throwable -> L53
            r5.start()     // Catch: java.lang.Throwable -> L53
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L53
            r4.waitFor(r1, r5)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L5c
            goto L59
        L53:
            r5 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r5)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L5c
        L59:
            r4.destroy()
        L5c:
            return r0
        L5d:
            r5 = move-exception
            if (r4 == 0) goto L63
            r4.destroy()
        L63:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.z.g.gc.a.z(int, int):java.util.List");
    }

    private static class z extends com.bytedance.sdk.component.uy.a.dl {
        private List<String> g;
        private InputStream z;

        z(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.z = inputStream;
            this.g = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.z));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("---------")) {
                            length -= line.getBytes("UTF-8").length;
                            if (length < 0) {
                                break;
                            } else {
                                this.g.add(line);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    return;
                } finally {
                    com.bytedance.z.g.gz.m.z(bufferedReader);
                }
            }
        }
    }

    private static class g extends com.bytedance.sdk.component.uy.a.dl {
        private long g;
        private Process z;

        public g(Process process, long j) {
            super("LogcatDump$TimerThread");
            this.z = process;
            this.g = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.g);
            } catch (InterruptedException e) {
                wp.z(e);
            }
            Process process = this.z;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String z(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
