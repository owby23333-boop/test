package com.duokan.free.tts.datasource;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public class TTSExecutionException extends IOException {
    private final int mErrorCode;

    @Nullable
    private final String mErrorMsg;

    public TTSExecutionException(int i, @Nullable String str) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Nullable
    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public TTSExecutionException(Throwable th) {
        super(th);
        this.mErrorCode = -1;
        this.mErrorMsg = th.getMessage();
    }

    public TTSExecutionException(@Nullable String str) {
        super(str);
        this.mErrorCode = -1;
        this.mErrorMsg = str;
    }
}
