package com.dangdang.zframework.plugin;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.dangdang.zframework.network.command.RequestQueueManager;
import com.dangdang.zframework.network.command.SynchronizedRequestQueueManager;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class AppUtil {
    private static AppUtil mUtil;
    protected Context mContext;
    private RequestQueueManager mRequestQueueManager;
    private SynchronizedRequestQueueManager mSynchronizedRequestQueueManager;
    private Typeface mTypeface;

    public AppUtil(Context context) {
        this.mContext = context.getApplicationContext();
        init();
    }

    public static synchronized AppUtil getInstance(Context context) {
        if (mUtil == null) {
            mUtil = new AppUtil(context);
        }
        return mUtil;
    }

    private void release() {
        this.mRequestQueueManager.stop();
        this.mRequestQueueManager = null;
        SynchronizedRequestQueueManager synchronizedRequestQueueManager = this.mSynchronizedRequestQueueManager;
        if (synchronizedRequestQueueManager != null) {
            synchronizedRequestQueueManager.stop();
            this.mSynchronizedRequestQueueManager = null;
        }
        mUtil = null;
    }

    public void exitApp(boolean z) {
        release();
        if (z) {
            System.exit(0);
        }
    }

    public RequestQueueManager getRequestQueueManager() {
        return this.mRequestQueueManager;
    }

    public SynchronizedRequestQueueManager getSynchronizedRequestQueueManager() {
        if (this.mSynchronizedRequestQueueManager == null) {
            this.mSynchronizedRequestQueueManager = new SynchronizedRequestQueueManager(this.mContext);
        }
        return this.mSynchronizedRequestQueueManager;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void init() {
        if (this.mRequestQueueManager == null) {
            this.mRequestQueueManager = new RequestQueueManager(this.mContext);
        }
    }

    public void setTypeface(String str) {
        try {
            this.mTypeface = Typeface.createFromFile(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopService(Class<? extends Object> cls) {
        if (cls == null) {
            return;
        }
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.mContext.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(100);
        for (int i = 0; i < runningServices.size(); i++) {
            if (cls.getName().equals(runningServices.get(i).service.getClassName())) {
                this.mContext.stopService(new Intent(this.mContext, cls));
                return;
            }
        }
    }
}
