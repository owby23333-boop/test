package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    private j0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void a() {
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j0.a(java.lang.Thread, java.lang.Throwable):void");
    }

    private void b() {
        File externalFilesDir;
        Context contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (contextD == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = contextD.getExternalFilesDir("TTCache")) != null) {
                externalFilesDir.mkdirs();
                this.b = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.b)) {
                File file = new File(contextD.getFilesDir(), "TTCache");
                file.mkdirs();
                this.b = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public static j0 c() {
        return new j0();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String string;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        } catch (Throwable unused) {
        }
        if (string != null ? string.contains("com.bytedance.msdk") : false) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
