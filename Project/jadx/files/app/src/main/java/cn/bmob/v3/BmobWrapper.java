package cn.bmob.v3;

import android.content.Context;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.Utils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class BmobWrapper {
    private static volatile BmobWrapper INSTANCE;
    private static byte[] LOCK = new byte[0];
    private final Context applicationContext;
    private final String applicationId;
    private File cacheDir;
    private final long connectTimeout;
    private final long fileExpiration;
    private File filesDir;
    private final int uploadBlockSize;

    private BmobWrapper(BmobConfig bmobConfig) {
        this.applicationContext = bmobConfig.context.getApplicationContext();
        this.applicationId = bmobConfig.applicationId;
        this.connectTimeout = bmobConfig.connectTimeout;
        this.uploadBlockSize = bmobConfig.uploadBlockSize;
        this.fileExpiration = bmobConfig.fileExpiration;
        BmobNative.init(this.applicationContext, this.applicationId);
        BmobContentProvider.initProvider(this.applicationContext);
        Utils.checkBmobContentProvider(this.applicationContext);
        BLog.init();
    }

    private static BmobWrapper create(BmobConfig bmobConfig) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new BmobWrapper(bmobConfig);
                }
            }
        }
        return INSTANCE;
    }

    private static File createFileDir(File file) {
        if (file.exists() || !file.mkdirs()) {
        }
        return file;
    }

    public static BmobWrapper getInstance() {
        BmobWrapper bmobWrapper;
        synchronized (LOCK) {
            bmobWrapper = INSTANCE;
        }
        return bmobWrapper;
    }

    static void initialize(BmobConfig bmobConfig) {
        create(bmobConfig);
        Bmob.getServerTime(new QueryListener<Long>() { // from class: cn.bmob.v3.BmobWrapper.1
            @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
            public void done(Long l2, BmobException bmobException) {
                if (bmobException == null) {
                    String.valueOf(l2);
                } else {
                    bmobException.toString();
                }
            }
        });
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public File getCacheDir() {
        File fileCreateFileDir;
        synchronized (LOCK) {
            if (this.cacheDir == null) {
                this.cacheDir = new File(this.applicationContext.getCacheDir(), "cn.bmob");
            }
            fileCreateFileDir = createFileDir(this.cacheDir);
        }
        return fileCreateFileDir;
    }

    public long getConnectTimeout() {
        long j2 = this.connectTimeout;
        return j2 == 0 ? BmobConstants.CONNECT_TIMEOUT : j2;
    }

    public long getFileExpiration() {
        long j2 = this.fileExpiration;
        return j2 == 0 ? BmobConstants.EXPIRATION : j2;
    }

    public File getFilesDir() {
        File fileCreateFileDir;
        synchronized (LOCK) {
            if (this.filesDir == null) {
                this.filesDir = new File(this.applicationContext.getFilesDir(), "cn.bmob");
            }
            fileCreateFileDir = createFileDir(this.filesDir);
        }
        return fileCreateFileDir;
    }

    public int getUploadBlockSize() {
        int i2 = this.uploadBlockSize;
        return i2 == 0 ? BmobConstants.BLOCK_SIZE : i2;
    }

    private BmobWrapper() {
        this.applicationId = null;
        this.applicationContext = null;
        this.connectTimeout = 0L;
        this.uploadBlockSize = 0;
        this.fileExpiration = 0L;
    }
}
