package com.bytedance.sdk.openadsdk.m.g;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.component.utils.gz;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Handler.Callback {
    private Handler z;

    private static class z {
        public static final dl z = new dl();
    }

    public static dl z() {
        return z.z;
    }

    private dl() {
        this.z = new Handler(gz.z().getLooper(), this);
    }

    public void z(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.z.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void z(Runnable runnable, long j) {
        this.z.postDelayed(runnable, j);
    }
}
