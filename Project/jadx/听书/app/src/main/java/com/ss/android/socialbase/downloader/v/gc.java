package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public final class gc implements Handler.Callback {
    private volatile Handler z = new Handler(z.z, this);

    public interface g {
        long z();
    }

    private static class z {
        private static final Looper z;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            z = handlerThread.getLooper();
        }
    }

    public static Looper z() {
        return z.z;
    }

    public void z(g gVar, long j) {
        Handler handler = this.z;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = gVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void g() {
        Handler handler = this.z;
        if (handler == null) {
            return;
        }
        this.z = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            g gVar = (g) message.obj;
            long jZ = gVar.z();
            if (jZ <= 0) {
                return true;
            }
            z(gVar, jZ);
            return true;
        } catch (Throwable th) {
            wp.z(th);
            return true;
        }
    }
}
