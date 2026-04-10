package cn.bmob.v3.listener;

import android.os.Handler;
import android.os.Looper;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.util.Utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class DownloadFileListener extends BmobErrorCallback<String> implements ProgressCallback {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cn.bmob.v3.listener.BmobErrorCallback
    public abstract void done(String str, BmobException bmobException);

    @Override // cn.bmob.v3.listener.BmobErrorCallback
    public void doneError(final int i2, final String str) {
        if (Utils.isMainThread()) {
            done((String) null, new BmobException(i2, str));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.bmob.v3.listener.DownloadFileListener.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadFileListener.this.done((String) null, new BmobException(i2, str));
                }
            });
        }
    }
}
