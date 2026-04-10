package com.tencent.smtt.sdk.a;

import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static String a = "EmergencyManager";
    private final File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FileOutputStream f19004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FileLock f19005d;

    private f(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.b = file;
        this.f19004c = fileOutputStream;
        this.f19005d = fileLock;
    }

    public static f a(File file) {
        FileOutputStream fileOutputStream;
        String str;
        StringBuilder sb;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null) {
                TbsLog.i(a, "Created lock file: " + file.getAbsolutePath());
                f fVar = new f(file, fileOutputStream, fileLockTryLock);
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    TbsLog.e(a, "Failed to close: " + e2.getMessage());
                }
                return fVar;
            }
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e = e3;
                str = a;
                sb = new StringBuilder();
                sb.append("Failed to close: ");
                sb.append(e.getMessage());
                TbsLog.e(str, sb.toString());
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                TbsLog.e(a, "Failed to try to acquire lock: " + file.getAbsolutePath() + " error: " + th.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        str = a;
                        sb = new StringBuilder();
                        sb.append("Failed to close: ");
                        sb.append(e.getMessage());
                        TbsLog.e(str, sb.toString());
                    }
                }
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        TbsLog.e(a, "Failed to close: " + e5.getMessage());
                    }
                }
                throw th3;
            }
        }
        return null;
    }

    public void a() throws IOException {
        TbsLog.i(a, "Deleting lock file: " + this.b.getAbsolutePath());
        this.f19005d.release();
        this.f19004c.close();
        if (this.b.delete()) {
            return;
        }
        throw new IOException("Failed to delete lock file: " + this.b.getAbsolutePath());
    }

    public void b() {
        try {
            a();
        } catch (IOException unused) {
        }
    }
}
