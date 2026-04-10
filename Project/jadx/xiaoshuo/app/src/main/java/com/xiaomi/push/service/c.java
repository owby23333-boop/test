package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f8272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1010a;
    private volatile String e;
    private volatile String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f1011a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f8273b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f1012a = "mipush_region";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f1013b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";

    public c(Context context) {
        this.f1010a = context;
    }

    public static c a(Context context) {
        if (f8272a == null) {
            synchronized (c.class) {
                if (f8272a == null) {
                    f8272a = new c(context);
                }
            }
        }
        return f8272a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f1010a, "mipush_country_code", "mipush_country_code.lock", this.f8273b);
        }
        return this.f;
    }

    public void b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f)) {
            this.f = str;
        }
        if (z) {
            a(this.f1010a, str, "mipush_country_code", "mipush_region.lock", this.f1011a);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f1010a, "mipush_region", "mipush_region.lock", this.f1011a);
        }
        return this.e;
    }

    public void a(String str, boolean z) {
        if (!TextUtils.equals(str, this.e)) {
            this.e = str;
        }
        if (z) {
            a(this.f1010a, str, "mipush_region", "mipush_region.lock", this.f1011a);
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLockLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    com.xiaomi.push.x.m819a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLockLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.x.a(new File(context.getFilesDir(), str2), str);
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            fileLockLock.release();
                        }
                        com.xiaomi.push.x.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                }
                com.xiaomi.push.x.a(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m106a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.x.m819a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                } catch (Exception e) {
                    e = e;
                    fileLockLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = null;
                fileLockLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String strA = com.xiaomi.push.x.a(file);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile);
                    return strA;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = fileLockLock;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    com.xiaomi.push.x.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e6) {
                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                    }
                }
                com.xiaomi.push.x.a(randomAccessFile);
                return null;
            }
        }
    }
}
