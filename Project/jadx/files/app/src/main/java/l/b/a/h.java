package l.b.a;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: ToastHelper.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends Handler {
    private final Toast a;
    private final k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21037d;

    h(Toast toast, Application application) {
        super(Looper.getMainLooper());
        this.a = toast;
        this.f21036c = application.getPackageName();
        this.b = k.a(this, application);
    }

    void a(boolean z2) {
        this.f21037d = z2;
    }

    boolean b() {
        return this.f21037d;
    }

    void c() {
        WindowManager windowManager;
        if (b()) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation.Toast;
        layoutParams.flags = TbsListener.ErrorCode.NEEDDOWNLOAD_TMPCORE_PREPARING;
        layoutParams.packageName = this.f21036c;
        layoutParams.gravity = this.a.getGravity();
        layoutParams.x = this.a.getXOffset();
        layoutParams.y = this.a.getYOffset();
        layoutParams.verticalMargin = this.a.getVerticalMargin();
        layoutParams.horizontalMargin = this.a.getHorizontalMargin();
        try {
            Activity activityA = this.b.a();
            if (activityA != null && !activityA.isFinishing() && (windowManager = (WindowManager) activityA.getSystemService("window")) != null) {
                windowManager.addView(this.a.getView(), layoutParams);
            }
            sendEmptyMessageDelayed(hashCode(), this.a.getDuration() == 1 ? 3500L : com.anythink.expressad.exoplayer.i.a.f9492f);
            a(true);
        } catch (WindowManager.BadTokenException | IllegalStateException unused) {
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a();
    }

    void a() {
        WindowManager windowManager;
        removeMessages(hashCode());
        if (b()) {
            try {
                Activity activityA = this.b.a();
                if (activityA != null && (windowManager = (WindowManager) activityA.getSystemService("window")) != null) {
                    windowManager.removeViewImmediate(this.a.getView());
                }
            } catch (IllegalArgumentException unused) {
            }
            a(false);
        }
    }
}
