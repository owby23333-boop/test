package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Thread.UncaughtExceptionHandler {
    private volatile boolean aqQ = false;
    private Thread.UncaughtExceptionHandler aqR = Thread.getDefaultUncaughtExceptionHandler();
    private Context context;

    public d(Context context) {
        this.context = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.aqQ) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.aqR;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
                return;
            }
            this.aqQ = true;
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (th != null && com.kwad.sdk.crash.a.a.g(th)) {
                JavaExceptionMessage javaExceptionMessage = new JavaExceptionMessage();
                javaExceptionMessage.mCrashSource = 1;
                c.zZ().a(th, javaExceptionMessage, this.context);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.aqR;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        } catch (Throwable unused) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.aqR;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }
}
