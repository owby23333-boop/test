package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class KevaBuilder {
    private static KevaBuilder mInstance = new KevaBuilder();
    Context mContext;
    Executor mExecutor;
    KevaMonitor mMonitor;
    String mPortedRepoName;
    File mWorkDir;

    public static void clearInstance() {
        mInstance = null;
    }

    public static KevaBuilder getInstance() {
        KevaBuilder kevaBuilder = mInstance;
        if (kevaBuilder != null) {
            return kevaBuilder;
        }
        Log.w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    public KevaBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public KevaBuilder setExecutor(Executor executor) {
        this.mExecutor = executor;
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor kevaMonitor) {
        this.mMonitor = kevaMonitor;
        return this;
    }

    public KevaBuilder setPortedRepoName(String str) {
        this.mPortedRepoName = str;
        return this;
    }

    public KevaBuilder setWorkDir(File file) {
        if (!file.exists()) {
            Log.i(KevaConstants.TAG, "work dir does not exist! try to create " + file.getPath());
            if (!file.mkdirs()) {
                Log.w(KevaConstants.TAG, "work dir fail to create!");
                return this;
            }
        }
        this.mWorkDir = file;
        return this;
    }
}
