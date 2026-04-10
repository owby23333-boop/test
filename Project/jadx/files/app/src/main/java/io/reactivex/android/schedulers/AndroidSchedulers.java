package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable<Scheduler>() { // from class: io.reactivex.android.schedulers.AndroidSchedulers.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return MainHolder.DEFAULT;
        }
    });

    private static final class MainHolder {
        static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper looper) {
        return from(looper, false);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler from(Looper looper, boolean z2) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            z2 = false;
        } else if (z2 && i2 < 22) {
            Message messageObtain = Message.obtain();
            try {
                messageObtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z2 = false;
            }
            messageObtain.recycle();
        }
        return new HandlerScheduler(new Handler(looper), z2);
    }
}
