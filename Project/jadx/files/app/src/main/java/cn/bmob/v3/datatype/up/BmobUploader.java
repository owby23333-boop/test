package cn.bmob.v3.datatype.up;

import android.annotation.SuppressLint;
import android.os.Build;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.listener.UploadFileListener;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public abstract class BmobUploader {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE;
    private static ThreadPoolExecutor executor;
    protected final BmobFile bmobFile;
    private volatile boolean cancelled = false;
    private volatile Future future;
    protected UploadFileListener listener;

    static {
        int i2 = CPU_COUNT;
        CORE_POOL_SIZE = i2 + 1;
        MAX_POOL_SIZE = (i2 * 2) + 1;
        executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            executor.allowCoreThreadTimeOut(true);
        }
    }

    protected BmobUploader(BmobFile bmobFile, UploadFileListener uploadFileListener) {
        this.bmobFile = bmobFile;
        this.listener = uploadFileListener;
    }

    public boolean cancel(boolean z2) {
        if (this.cancelled) {
            return false;
        }
        this.cancelled = true;
        if (z2) {
            interruptImmediately();
        } else if (this.future != null) {
            this.future.cancel(false);
        }
        onCancelled();
        return true;
    }

    abstract void doUpload();

    public void execute() {
        this.future = executor.submit(new Runnable() { // from class: cn.bmob.v3.datatype.up.BmobUploader.1
            @Override // java.lang.Runnable
            public void run() {
                BmobUploader.this.doUpload();
            }
        });
    }

    public void interruptImmediately() {
        if (this.future != null) {
            this.future.cancel(true);
        }
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    protected void onCancelled() {
        UploadFileListener uploadFileListener = this.listener;
        if (uploadFileListener != null) {
            uploadFileListener.done(new BmobException(ErrorCode.E9015, "your uploading task is canceled."));
        }
    }
}
