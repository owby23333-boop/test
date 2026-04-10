package com.mipay.imageloadhelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.mipay.imageloadhelper.cache.CacheManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes17.dex */
class DownloadManager {
    private static final int DEFAULT_THREADS = 4;
    private static final DownloadManager DOWNLOAD_MANAGER = new DownloadManager();
    static final int ERROR_ERROR = 1;
    static final int ERROR_OK = 0;
    static final String KEY_BITMAP = "key_bitmap";
    static final String KEY_DESC = "desc";
    static final String KEY_PROCESS_ID = "process_id";
    private static final String TAG = "ImageDownloadManager";
    private DownStreamHandler mDownStreamHandler;
    private ExecutorService mExecutor;

    public static class DownStreamHandler extends Handler {
        private DownStreamHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d(DownloadManager.TAG, "download handle message:" + message.what);
            int i = message.getData().getInt(DownloadManager.KEY_PROCESS_ID);
            int i2 = message.what;
            if (i2 == 0) {
                ImageTaskManager.getInstance().notifyDownloadSuccess(i, (Bitmap) message.getData().getParcelable(DownloadManager.KEY_BITMAP));
            } else if (i2 == 1) {
                ImageTaskManager.getInstance().notifyDownloadFailed(i, message.getData().getString("desc"));
            } else {
                throw new IllegalStateException("unknown error code:" + message.what);
            }
        }
    }

    public static class DownloadTask implements Runnable {
        private Context mContext;
        private boolean mNeedCache;
        private int mProcessId;
        private IDownloadErrorStrategy mStrategy;
        private URL mUrl;

        public static class Builder {
            private DownloadTask mTask;

            public Builder(Context context, String str, int i) throws MalformedURLException {
                this.mTask = new DownloadTask(context, str, i);
            }

            public DownloadTask build() {
                return this.mTask;
            }

            public Builder setDownloadErrorStragegy(IDownloadErrorStrategy iDownloadErrorStrategy) {
                this.mTask.setDownloadErrorStrategy(iDownloadErrorStrategy);
                return this;
            }

            public Builder setNeedCache(boolean z) {
                this.mTask.mNeedCache = z;
                return this;
            }
        }

        private Bitmap download() throws DownLoadException {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.mUrl.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(10000);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 0) {
                    throw new DownLoadException(1, "may timeout");
                }
                if (responseCode == 200) {
                    new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.ARGB_4444;
                    return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                }
                throw new DownLoadException(2, "serverCode:" + responseCode);
            } catch (IOException unused) {
                throw new DownLoadException(3, "io exception");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDownloadErrorStrategy(IDownloadErrorStrategy iDownloadErrorStrategy) {
            this.mStrategy = iDownloadErrorStrategy;
            iDownloadErrorStrategy.setDownloadTask(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap fromCache;
            DownStreamHandler downStreamHandler = DownloadManager.getInstance().mDownStreamHandler;
            if (downStreamHandler != null) {
                try {
                    if (this.mNeedCache && (fromCache = CacheManager.getFromCache(this.mContext, this.mUrl.toString())) != null) {
                        Message messageObtainMessage = downStreamHandler.obtainMessage(0);
                        messageObtainMessage.setData(Utils.createSuccessTaskArguments(this.mProcessId, fromCache));
                        downStreamHandler.sendMessage(messageObtainMessage);
                        return;
                    }
                    Bitmap bitmapDownload = download();
                    if (bitmapDownload != null) {
                        Message messageObtainMessage2 = downStreamHandler.obtainMessage(0);
                        messageObtainMessage2.setData(Utils.createSuccessTaskArguments(this.mProcessId, bitmapDownload));
                        downStreamHandler.sendMessage(messageObtainMessage2);
                    } else {
                        Message messageObtainMessage3 = downStreamHandler.obtainMessage(1);
                        messageObtainMessage3.setData(Utils.createErrorTaskArguments(this.mProcessId, "bitmap is null"));
                        downStreamHandler.sendMessage(messageObtainMessage3);
                    }
                } catch (DownLoadException e) {
                    Log.d(DownloadManager.TAG, "download error code:" + e.getErrorCode() + ",download error reason:" + e.getDescription() + ",thread:" + Thread.currentThread().getName());
                    IDownloadErrorStrategy iDownloadErrorStrategy = this.mStrategy;
                    if (iDownloadErrorStrategy == null || !iDownloadErrorStrategy.handleDownloadError(e.getErrorCode(), e.getDescription())) {
                        Message messageObtainMessage4 = downStreamHandler.obtainMessage(1);
                        messageObtainMessage4.setData(Utils.createErrorTaskArguments(this.mProcessId, e.getDescription()));
                        downStreamHandler.sendMessage(messageObtainMessage4);
                    }
                }
            }
        }

        private DownloadTask(Context context, String str, int i) throws MalformedURLException {
            this.mUrl = new URL(str);
            this.mProcessId = i;
            this.mContext = context.getApplicationContext();
        }
    }

    private DownloadManager() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.mExecutor = Executors.newFixedThreadPool(iAvailableProcessors <= 0 ? 4 : iAvailableProcessors);
    }

    public static DownloadManager getInstance() {
        return DOWNLOAD_MANAGER;
    }

    public void commit(DownloadTask downloadTask) {
        if (!Utils.isUIThread()) {
            throw new IllegalStateException("commit should in ui thread");
        }
        if (this.mDownStreamHandler == null) {
            this.mDownStreamHandler = new DownStreamHandler();
        }
        this.mExecutor.submit(downloadTask);
    }
}
