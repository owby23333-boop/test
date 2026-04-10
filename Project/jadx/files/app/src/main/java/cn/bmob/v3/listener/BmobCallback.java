package cn.bmob.v3.listener;

import android.os.Handler;
import android.os.Looper;
import cn.bmob.v3.util.Utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BmobCallback {
    public void internalStart() {
        if (Utils.isMainThread()) {
            onStart();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.bmob.v3.listener.BmobCallback.1
                @Override // java.lang.Runnable
                public final void run() {
                    BmobCallback.this.onStart();
                }
            });
        }
    }

    public void onFinish() {
    }

    public void onStart() {
    }
}
