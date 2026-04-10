package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpException extends IOException {
    public HttpException(int i2) {
        this("Http request failed", i2);
    }

    public HttpException(String str, int i2) {
        this(str, i2, null);
    }

    public HttpException(String str, int i2, @Nullable Throwable th) {
        super(str + ", status code: " + i2, th);
    }
}
