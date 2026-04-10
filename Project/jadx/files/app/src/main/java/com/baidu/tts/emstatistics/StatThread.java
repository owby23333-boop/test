package com.baidu.tts.emstatistics;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class StatThread extends Thread {
    private String mAppId;
    private Context mContext;

    public StatThread(Context context, String str) {
        this.mContext = context;
        this.mAppId = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StatHelper.uploadStatDatas(this.mContext, this.mAppId);
        this.mContext = null;
    }
}
