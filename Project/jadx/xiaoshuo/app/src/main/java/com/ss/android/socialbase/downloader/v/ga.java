package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ga implements Handler.Callback {
    private volatile Handler e = new Handler(e.e, this);

    public interface bf {
        long e();
    }

    public static class e {
        private static final Looper e;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            e = handlerThread.getLooper();
        }
    }

    public static Looper e() {
        return e.e;
    }

    public void bf() {
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        this.e = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            bf bfVar = (bf) message.obj;
            long jE = bfVar.e();
            if (jE <= 0) {
                return true;
            }
            e(bfVar, jE);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void e(bf bfVar, long j) {
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = bfVar;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
