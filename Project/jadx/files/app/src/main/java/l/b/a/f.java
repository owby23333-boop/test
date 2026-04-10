package l.b.a;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/* JADX INFO: compiled from: SafeHandler.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends Handler {
    private Handler a;

    f(Handler handler) {
        this.a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.a.handleMessage(message);
        } catch (WindowManager.BadTokenException | IllegalStateException unused) {
        }
    }
}
