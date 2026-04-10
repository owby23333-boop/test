package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
class w {
    private static w a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static FileLock f19162e;
    private x b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19164d;

    private w() {
    }

    public static w a() {
        if (a == null) {
            synchronized (w.class) {
                if (a == null) {
                    a = new w();
                }
            }
        }
        return a;
    }

    public x a(boolean z2) {
        return z2 ? this.b : c();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00db A[Catch: all -> 0x0253, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x002c, B:8:0x0030, B:17:0x0078, B:19:0x0092, B:22:0x00a9, B:24:0x00db, B:40:0x0154, B:42:0x0160, B:43:0x019a, B:52:0x024f, B:44:0x019f, B:39:0x014b, B:45:0x01da, B:47:0x01e0, B:48:0x021c, B:49:0x0230, B:51:0x024c, B:14:0x0055, B:15:0x0070, B:20:0x009a, B:9:0x0042, B:11:0x004e, B:28:0x00ec, B:30:0x00f2, B:31:0x00fe, B:33:0x0102, B:34:0x0131, B:36:0x0135), top: B:60:0x0001, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0230 A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x002c, B:8:0x0030, B:17:0x0078, B:19:0x0092, B:22:0x00a9, B:24:0x00db, B:40:0x0154, B:42:0x0160, B:43:0x019a, B:52:0x024f, B:44:0x019f, B:39:0x014b, B:45:0x01da, B:47:0x01e0, B:48:0x021c, B:49:0x0230, B:51:0x024c, B:14:0x0055, B:15:0x0070, B:20:0x009a, B:9:0x0042, B:11:0x004e, B:28:0x00ec, B:30:0x00f2, B:31:0x00fe, B:33:0x0102, B:34:0x0131, B:36:0x0135), top: B:60:0x0001, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(android.content.Context r12) {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.w.a(android.content.Context):void");
    }

    public FileLock b(Context context) {
        String str;
        String str2;
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = f19162e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (w.class) {
            if (f19162e == null) {
                f19162e = FileUtil.d(context);
                if (f19162e == null) {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock failed!";
                } else {
                    str = "X5CoreEngine";
                    str2 = "init -- sTbsCoreLoadFileLock succeeded: " + f19162e;
                }
                TbsLog.i(str, str2);
            }
        }
        return f19162e;
    }

    public boolean b() {
        if (QbSdk.a) {
            return false;
        }
        return this.f19163c;
    }

    public x c() {
        if (QbSdk.a) {
            return null;
        }
        return this.b;
    }

    boolean d() {
        return this.f19164d;
    }
}
