package com.anythink.core.common.j;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f7598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f7599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicInteger f7600j;
    private final String a = "Agent";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7593c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7594d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7595e = 1800000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7596f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7597g = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7601k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f7602l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f7603m = new i() { // from class: com.anythink.core.common.j.b.1
        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i2) {
            b.this.f7601k = false;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i2, String str, AdError adError) {
            b.this.f7601k = false;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i2, Object obj) {
            b.this.a(((Integer) obj).intValue());
            b.this.f7601k = false;
            p.a(b.this.f7598h, g.f6799o, "LOG_SEND_TIME", System.currentTimeMillis());
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i2) {
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c.a f7604n = new c.a() { // from class: com.anythink.core.common.j.b.2
        @Override // com.anythink.core.common.g.a.c.a
        public final void a(Object obj) {
            if (obj instanceof com.anythink.core.common.g.a.a) {
                b.this.a(((com.anythink.core.common.g.a.a) obj).b());
                b.this.f7601k = false;
                p.a(b.this.f7598h, g.f6799o, "LOG_SEND_TIME", System.currentTimeMillis());
            }
        }

        @Override // com.anythink.core.common.g.a.c.a
        public final void a(Throwable th) {
            b.this.f7601k = false;
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Object f7605o = new Object();

    private b() {
    }

    public final void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.b.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:51:0x0123 A[PHI: r0
  0x0123: PHI (r0v23 ??) = (r0v56 ??), (r0v57 ??), (r0v58 ??) binds: [B:56:0x0137, B:50:0x0121, B:54:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23, types: [java.io.BufferedReader] */
            /* JADX WARN: Type inference failed for: r0v24 */
            /* JADX WARN: Type inference failed for: r0v25 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v28 */
            /* JADX WARN: Type inference failed for: r0v29 */
            /* JADX WARN: Type inference failed for: r0v45 */
            /* JADX WARN: Type inference failed for: r0v46 */
            /* JADX WARN: Type inference failed for: r0v47 */
            /* JADX WARN: Type inference failed for: r0v51 */
            /* JADX WARN: Type inference failed for: r0v52 */
            /* JADX WARN: Type inference failed for: r0v53 */
            /* JADX WARN: Type inference failed for: r0v54 */
            /* JADX WARN: Type inference failed for: r0v55 */
            /* JADX WARN: Type inference failed for: r0v56 */
            /* JADX WARN: Type inference failed for: r0v57 */
            /* JADX WARN: Type inference failed for: r0v58 */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v3, types: [java.io.BufferedReader] */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.io.BufferedReader] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 327
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.AnonymousClass3.run():void");
            }
        });
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd A[Catch: all -> 0x0147, Error -> 0x0149, OutOfMemoryError | StackOverflowError -> 0x0153, OutOfMemoryError | StackOverflowError -> 0x0153, Exception -> 0x016c, TryCatch #1 {OutOfMemoryError | StackOverflowError -> 0x0153, blocks: (B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:25:0x00e2, B:37:0x00f9, B:37:0x00f9, B:39:0x00fd, B:39:0x00fd, B:40:0x0104, B:40:0x0104, B:42:0x0116, B:42:0x0116, B:44:0x011d, B:44:0x011d, B:46:0x012f, B:46:0x012f, B:48:0x0136, B:48:0x0136, B:47:0x0134, B:47:0x0134, B:43:0x011b, B:43:0x011b, B:33:0x00f0, B:33:0x00f0, B:34:0x00f3, B:34:0x00f3, B:36:0x00f6, B:36:0x00f6), top: B:85:0x001c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0116 A[Catch: all -> 0x0147, Error -> 0x0149, OutOfMemoryError | StackOverflowError -> 0x0153, OutOfMemoryError | StackOverflowError -> 0x0153, Exception -> 0x016c, TryCatch #1 {OutOfMemoryError | StackOverflowError -> 0x0153, blocks: (B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:25:0x00e2, B:37:0x00f9, B:37:0x00f9, B:39:0x00fd, B:39:0x00fd, B:40:0x0104, B:40:0x0104, B:42:0x0116, B:42:0x0116, B:44:0x011d, B:44:0x011d, B:46:0x012f, B:46:0x012f, B:48:0x0136, B:48:0x0136, B:47:0x0134, B:47:0x0134, B:43:0x011b, B:43:0x011b, B:33:0x00f0, B:33:0x00f0, B:34:0x00f3, B:34:0x00f3, B:36:0x00f6, B:36:0x00f6), top: B:85:0x001c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b A[Catch: all -> 0x0147, Error -> 0x0149, OutOfMemoryError | StackOverflowError -> 0x0153, OutOfMemoryError | StackOverflowError -> 0x0153, Exception -> 0x016c, TryCatch #1 {OutOfMemoryError | StackOverflowError -> 0x0153, blocks: (B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:25:0x00e2, B:37:0x00f9, B:37:0x00f9, B:39:0x00fd, B:39:0x00fd, B:40:0x0104, B:40:0x0104, B:42:0x0116, B:42:0x0116, B:44:0x011d, B:44:0x011d, B:46:0x012f, B:46:0x012f, B:48:0x0136, B:48:0x0136, B:47:0x0134, B:47:0x0134, B:43:0x011b, B:43:0x011b, B:33:0x00f0, B:33:0x00f0, B:34:0x00f3, B:34:0x00f3, B:36:0x00f6, B:36:0x00f6), top: B:85:0x001c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f A[Catch: all -> 0x0147, Error -> 0x0149, OutOfMemoryError | StackOverflowError -> 0x0153, OutOfMemoryError | StackOverflowError -> 0x0153, Exception -> 0x016c, TryCatch #1 {OutOfMemoryError | StackOverflowError -> 0x0153, blocks: (B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:25:0x00e2, B:37:0x00f9, B:37:0x00f9, B:39:0x00fd, B:39:0x00fd, B:40:0x0104, B:40:0x0104, B:42:0x0116, B:42:0x0116, B:44:0x011d, B:44:0x011d, B:46:0x012f, B:46:0x012f, B:48:0x0136, B:48:0x0136, B:47:0x0134, B:47:0x0134, B:43:0x011b, B:43:0x011b, B:33:0x00f0, B:33:0x00f0, B:34:0x00f3, B:34:0x00f3, B:36:0x00f6, B:36:0x00f6), top: B:85:0x001c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0134 A[Catch: all -> 0x0147, Error -> 0x0149, OutOfMemoryError | StackOverflowError -> 0x0153, OutOfMemoryError | StackOverflowError -> 0x0153, Exception -> 0x016c, TryCatch #1 {OutOfMemoryError | StackOverflowError -> 0x0153, blocks: (B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:25:0x00e2, B:37:0x00f9, B:37:0x00f9, B:39:0x00fd, B:39:0x00fd, B:40:0x0104, B:40:0x0104, B:42:0x0116, B:42:0x0116, B:44:0x011d, B:44:0x011d, B:46:0x012f, B:46:0x012f, B:48:0x0136, B:48:0x0136, B:47:0x0134, B:47:0x0134, B:43:0x011b, B:43:0x011b, B:33:0x00f0, B:33:0x00f0, B:34:0x00f3, B:34:0x00f3, B:36:0x00f6, B:36:0x00f6), top: B:85:0x001c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013f A[Catch: all -> 0x017a, TryCatch #9 {, blocks: (B:4:0x0003, B:8:0x000b, B:49:0x013b, B:51:0x013f, B:52:0x0144, B:70:0x0176, B:63:0x0160, B:65:0x0164, B:66:0x016b, B:55:0x0149, B:57:0x014d, B:60:0x0156, B:62:0x015a, B:67:0x016c, B:69:0x0170, B:72:0x0178, B:10:0x001c, B:12:0x0080, B:14:0x0095, B:15:0x009e, B:17:0x00a6, B:25:0x00e2, B:37:0x00f9, B:39:0x00fd, B:40:0x0104, B:42:0x0116, B:44:0x011d, B:46:0x012f, B:48:0x0136, B:47:0x0134, B:43:0x011b, B:33:0x00f0, B:34:0x00f3, B:36:0x00f6, B:59:0x0153), top: B:89:0x0003, inners: #5, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.a(android.content.Context):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r0 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void a(com.anythink.core.common.e.h r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.File r0 = r4.f7599i     // Catch: java.lang.Throwable -> L88
            if (r0 == 0) goto L9
            java.util.concurrent.atomic.AtomicInteger r0 = r4.f7600j     // Catch: java.lang.Throwable -> L88
            if (r0 != 0) goto L14
        L9:
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L88
            android.content.Context r0 = r0.g()     // Catch: java.lang.Throwable -> L88
            r4.a(r0)     // Catch: java.lang.Throwable -> L88
        L14:
            android.content.Context r0 = r4.f7598h     // Catch: java.lang.Throwable -> L88
            com.anythink.core.c.b r0 = com.anythink.core.c.b.a(r0)     // Catch: java.lang.Throwable -> L88
            java.lang.String r1 = r4.f7602l     // Catch: java.lang.Throwable -> L88
            com.anythink.core.c.a r0 = r0.b(r1)     // Catch: java.lang.Throwable -> L88
            int r1 = r0.ad()     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L2b
            int r1 = r0.ad()     // Catch: java.lang.Throwable -> L88
            goto L2d
        L2b:
            int r1 = r4.f7593c     // Catch: java.lang.Throwable -> L88
        L2d:
            r4.f7593c = r1     // Catch: java.lang.Throwable -> L88
            int r1 = r4.f7593c     // Catch: java.lang.Throwable -> L88
            int r1 = r1 * 2
            r4.f7594d = r1     // Catch: java.lang.Throwable -> L88
            long r0 = r0.af()     // Catch: java.lang.Throwable -> L88
            r4.f7595e = r0     // Catch: java.lang.Throwable -> L88
            r0 = 0
            org.json.JSONObject r5 = r5.a()     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L74 java.lang.Exception -> L80
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L74 java.lang.Exception -> L80
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L74 java.lang.Exception -> L80
            java.io.File r2 = r4.f7599i     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L74 java.lang.Exception -> L80
            r3 = 1
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6b java.lang.Error -> L6e java.lang.Throwable -> L74 java.lang.Exception -> L80
            r1.append(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.flush()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.close()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.util.concurrent.atomic.AtomicInteger r5 = r4.f7600j     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L63 java.lang.Error -> L65 java.lang.Throwable -> L67 java.lang.Exception -> L69
            r1.close()     // Catch: java.io.IOException -> L83 java.lang.Throwable -> L88
            goto L83
        L63:
            r5 = move-exception
            goto L7a
        L65:
            r0 = r1
            goto L6e
        L67:
            r0 = r1
            goto L74
        L69:
            r0 = r1
            goto L80
        L6b:
            r5 = move-exception
            r1 = r0
            goto L7a
        L6e:
            if (r0 == 0) goto L83
        L70:
            r0.close()     // Catch: java.io.IOException -> L83 java.lang.Throwable -> L88
            goto L83
        L74:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L6b
            if (r0 == 0) goto L83
            goto L70
        L7a:
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> L88
        L7f:
            throw r5     // Catch: java.lang.Throwable -> L88
        L80:
            if (r0 == 0) goto L83
            goto L70
        L83:
            r4.a(r6)     // Catch: java.lang.Throwable -> L88
            monitor-exit(r4)
            return
        L88:
            r5 = move-exception
            monitor-exit(r4)
            goto L8c
        L8b:
            throw r5
        L8c:
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.a(com.anythink.core.common.e.h, boolean):void");
    }

    private synchronized void a(boolean z2) {
        BufferedReader bufferedReader;
        String line;
        if (this.f7598h == null) {
            return;
        }
        if (this.f7601k || (!z2 && (this.f7600j == null || this.f7600j.get() < this.f7593c))) {
            return;
        }
        this.f7601k = true;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(this.f7599i));
            } catch (Exception unused) {
            } catch (OutOfMemoryError | StackOverflowError unused2) {
            } catch (Throwable unused3) {
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f7594d && (line = bufferedReader.readLine()) != null; i2++) {
                    arrayList.add(line);
                }
                com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (aVarB != null) {
                    if (aVarB.u() != 1) {
                        new com.anythink.core.common.g.b(this.f7598h, aVarB.u(), arrayList).a(0, this.f7603m);
                    } else {
                        com.anythink.core.common.g.a.a aVar = new com.anythink.core.common.g.a.a(arrayList);
                        aVar.a(1, aVarB.t());
                        aVar.a(this.f7604n);
                    }
                } else {
                    new com.anythink.core.common.g.b(this.f7598h, 0, arrayList).a(0, this.f7603m);
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            } catch (Exception unused5) {
                bufferedReader2 = bufferedReader;
                this.f7601k = false;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused6) {
                    }
                }
            } catch (OutOfMemoryError | StackOverflowError unused7) {
                bufferedReader2 = bufferedReader;
                this.f7601k = false;
                System.gc();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused8) {
                    }
                }
            } catch (Throwable unused9) {
                bufferedReader2 = bufferedReader;
                this.f7601k = false;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused10) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused11) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i2) {
        File file;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            file = new File(this.f7597g);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(this.f7599i));
        } catch (Exception unused) {
        } catch (OutOfMemoryError | StackOverflowError unused2) {
        } catch (Error unused3) {
        } catch (Throwable unused4) {
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                i4++;
                if (i4 > i2) {
                    fileWriter.append((CharSequence) line);
                    fileWriter.append((CharSequence) "\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
            bufferedReader.close();
            AtomicInteger atomicInteger = this.f7600j;
            if (this.f7600j.get() - i2 >= 0) {
                i3 = this.f7600j.get() - i2;
            }
            atomicInteger.set(i3);
            this.f7599i.delete();
            file.renameTo(this.f7599i);
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
        } catch (Error unused6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused7) {
                }
            }
        } catch (Exception unused8) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused9) {
                }
            }
        } catch (OutOfMemoryError | StackOverflowError unused10) {
            bufferedReader2 = bufferedReader;
            try {
                System.gc();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused11) {
                    }
                }
            } catch (Throwable th) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused12) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused13) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused14) {
                }
            }
        }
    }
}
