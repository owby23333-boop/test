package com.msa.sdk.tool;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThrowableCaughtRunnable implements Runnable {
    private String mMessage;
    private String mTag;
    boolean mTrackException;

    public ThrowableCaughtRunnable(String str, String str2) {
        this(str, str2, false);
    }

    public abstract void execute() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            execute();
        } catch (Throwable th) {
            Log.e(MLog.addAdPrefix(this.mTag), String.format("AD-ThrowableCaughtRunnable message: %s", this.mMessage), th);
        }
    }

    public ThrowableCaughtRunnable(String str, String str2, boolean z) {
        this.mTag = str == null ? "" : str;
        this.mMessage = str2 == null ? "" : str2;
        this.mTrackException = z;
    }
}
