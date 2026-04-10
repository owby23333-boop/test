package com.dangdang.zframework.network.download;

import com.dangdang.zframework.log.LogM;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class DownloadManagerFactory {
    private static final LogM logger = LogM.getLog(DownloadManagerFactory.class);
    private static DownloadManagerFactory mFactory;
    private Map<DownloadModule, IDownloadManager> mCache = new Hashtable();
    private Object mLock = new Object();

    public static class DownloadModule implements Serializable {
        private String mModule;
        private int mTaskingSize = 1;

        public DownloadModule(String str) {
            this.mModule = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            String str = this.mModule;
            String str2 = ((DownloadModule) obj).mModule;
            return str == null ? str2 == null : str.equals(str2);
        }

        public String getModule() {
            return this.mModule;
        }

        public int getTaskingSize() {
            return this.mTaskingSize;
        }

        public int hashCode() {
            String str = this.mModule;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public void setTaskingSize(int i) {
            this.mTaskingSize = i;
        }

        public String toString() {
            return "[" + getClass().getSimpleName() + "(" + getModule() + ")-(" + getTaskingSize() + "]";
        }
    }

    public enum Operation {
        DESTORY,
        PAUSE_ALL
    }

    private DownloadManagerFactory() {
    }

    private IDownloadManager createDownloadManager(DownloadModule downloadModule) {
        DownloadManager downloadManagerNewDownloadManager = newDownloadManager(downloadModule);
        this.mCache.put(downloadModule, downloadManagerNewDownloadManager);
        return downloadManagerNewDownloadManager;
    }

    public static synchronized DownloadManagerFactory getFactory() {
        if (mFactory == null) {
            mFactory = new DownloadManagerFactory();
        }
        logger.i(true, " getFactory()=" + mFactory);
        return mFactory;
    }

    private void loopDownloadManager(Operation operation) {
        Set<Map.Entry<DownloadModule, IDownloadManager>> setEntrySet = this.mCache.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<DownloadModule, IDownloadManager>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            operationDManager(it.next().getValue(), operation);
        }
    }

    private void operationDManager(IDownloadManager iDownloadManager, Operation operation) {
        if (iDownloadManager != null) {
            if (operation == Operation.DESTORY) {
                iDownloadManager.destory();
            } else if (operation == Operation.PAUSE_ALL) {
                iDownloadManager.pauseAll();
            }
        }
    }

    private void printLog(String str) {
        logger.d(true, str);
    }

    private void printLogE(String str) {
        logger.e(false, str);
    }

    public IDownloadManager create(DownloadModule downloadModule) {
        IDownloadManager iDownloadManagerCreateDownloadManager;
        if (downloadModule == null) {
            throw new NullPointerException(" module is null ");
        }
        synchronized (this.mLock) {
            if (!this.mCache.containsKey(downloadModule) || (iDownloadManagerCreateDownloadManager = this.mCache.get(downloadModule)) == null) {
                iDownloadManagerCreateDownloadManager = createDownloadManager(downloadModule);
            }
            printLog("[create() module=" + downloadModule + ", current=" + iDownloadManagerCreateDownloadManager + "]");
        }
        return iDownloadManagerCreateDownloadManager;
    }

    public void destory() {
        try {
            loopDownloadManager(Operation.DESTORY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<DownloadModule, IDownloadManager> map = this.mCache;
        if (map != null) {
            map.clear();
        }
        mFactory = null;
    }

    public void destroyModule(DownloadModule downloadModule) {
        synchronized (this.mLock) {
            try {
                if (!this.mCache.containsKey(downloadModule)) {
                    return;
                }
                this.mCache.get(downloadModule).destory();
                this.mCache.remove(downloadModule);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public IDownloadManager getDownloadManager(DownloadModule downloadModule) {
        IDownloadManager iDownloadManager;
        if (downloadModule == null) {
            throw new NullPointerException(" module is null ");
        }
        synchronized (this.mLock) {
            iDownloadManager = this.mCache.get(downloadModule);
            if (iDownloadManager == null) {
                printLogE(" getDownloadManager dm == null " + downloadModule);
            }
        }
        return iDownloadManager;
    }

    public DownloadManager newDownloadManager(DownloadModule downloadModule) {
        return new DownloadManager(downloadModule);
    }

    public void pauseAll() {
        try {
            loopDownloadManager(Operation.PAUSE_ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DownloadManagerFactory(int i) {
    }
}
