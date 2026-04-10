package com.dangdang.zframework.network.download;

import com.dangdang.zframework.network.download.DownloadConstant;
import com.dangdang.zframework.network.download.DownloadManagerFactory;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes10.dex */
public interface IDownloadManager {

    public static class DownloadInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public IDownload download;
        public File file;
        public DownloadManagerFactory.DownloadModule mModule;
        public Progress progress;
        public DownloadConstant.Status status;
        public Object tag;
        public String url;

        public DownloadInfo(DownloadManagerFactory.DownloadModule downloadModule) {
            this.mModule = downloadModule;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("[url=");
            stringBuffer.append(this.url);
            stringBuffer.append("],");
            stringBuffer.append(this.progress);
            return stringBuffer.toString();
        }
    }

    public interface IDownloadListener {
        void onDownloadFailed(DownloadInfo downloadInfo, DownloadExp downloadExp);

        void onDownloadFinish(DownloadInfo downloadInfo);

        void onDownloading(DownloadInfo downloadInfo);

        void onFileTotalSize(DownloadInfo downloadInfo);

        void onPauseDownload(DownloadInfo downloadInfo);
    }

    public static class Progress implements Serializable {
        private static final long serialVersionUID = 1;
        public long progress;
        public long total;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("[progress=");
            stringBuffer.append(this.progress);
            stringBuffer.append(", total=");
            stringBuffer.append(this.total);
            return stringBuffer.toString();
        }
    }

    void destory();

    Vector<Runnable> getDownloadingTasks();

    void pauseAll();

    IDownload pauseDownload(IDownload iDownload);

    void registerDownloadListener(Class<?> cls, IDownloadListener iDownloadListener);

    void startDownload(IDownload iDownload);

    void unRegisterDownloadListener(Class<?> cls);

    public static class DownloadExp implements Serializable {
        public static final int CODE_NET = 11;
        public static final int CODE_NET_FAILED = 13;
        public static final int CODE_NET_SERVER = 12;
        public static final int CODE_NOSPACE = 20;
        public static final int CODE_OK = 0;
        public static final int CODE_WRITEFILE = 21;
        private static final long serialVersionUID = 1;
        public String errMsg;
        public Map<String, String> headers;
        public int responseCode;
        public int statusCode;

        public DownloadExp() {
            this.statusCode = 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("[statusCode=");
            stringBuffer.append(this.statusCode);
            stringBuffer.append(", responseCode=");
            stringBuffer.append(this.responseCode);
            stringBuffer.append(", errMsg=");
            stringBuffer.append(this.errMsg);
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

        public DownloadExp(int i) {
            this.statusCode = i;
        }

        public DownloadExp(int i, int i2) {
            this.statusCode = i;
            this.responseCode = i2;
        }
    }
}
