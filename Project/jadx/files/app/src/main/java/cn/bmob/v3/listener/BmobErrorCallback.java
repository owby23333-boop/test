package cn.bmob.v3.listener;

import android.os.Handler;
import android.os.Looper;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.util.Utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BmobErrorCallback<T> extends BmobCallback {
    protected abstract void done(T t2, BmobException bmobException);

    public void doneError(final int i2, final String str) {
        if (Utils.isMainThread()) {
            done(null, new BmobException(i2, str));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.bmob.v3.listener.BmobErrorCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    BmobErrorCallback.this.done(null, new BmobException(i2, str));
                }
            });
        }
    }
}
