package com.mipay.imageloadhelper;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes17.dex */
public class ImageTaskManager {
    private static final ImageTaskManager IMAGE_TASK_MAP = new ImageTaskManager();
    private final ConcurrentHashMap<Integer, IResultListener> mListenerMap = new ConcurrentHashMap<>();

    public interface IResultListener {
        void onFailed(int i, String str);

        void onSuccess(int i, Bitmap bitmap);
    }

    private ImageTaskManager() {
    }

    public static ImageTaskManager getInstance() {
        return IMAGE_TASK_MAP;
    }

    public synchronized void notifyDownloadFailed(int i, String str) {
        IResultListener iResultListenerRemove = this.mListenerMap.remove(Integer.valueOf(i));
        if (iResultListenerRemove == null) {
            return;
        }
        iResultListenerRemove.onFailed(i, str);
    }

    public synchronized void notifyDownloadSuccess(int i, Bitmap bitmap) {
        IResultListener iResultListenerRemove = this.mListenerMap.remove(Integer.valueOf(i));
        if (iResultListenerRemove == null) {
            return;
        }
        iResultListenerRemove.onSuccess(i, bitmap);
    }

    public synchronized void registResultListener(int i, IResultListener iResultListener) {
        if (i <= 0) {
            throw new IllegalStateException("processId < 0:" + i);
        }
        if (iResultListener == null) {
            throw new IllegalStateException("listener is null");
        }
        if (this.mListenerMap.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.mListenerMap.put(Integer.valueOf(i), iResultListener);
    }

    public synchronized void unRegistResultListener(int i) {
        if (this.mListenerMap.containsKey(Integer.valueOf(i))) {
            this.mListenerMap.remove(Integer.valueOf(i));
        }
    }
}
