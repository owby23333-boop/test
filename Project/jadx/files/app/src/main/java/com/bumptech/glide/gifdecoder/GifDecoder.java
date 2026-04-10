package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface GifDecoder {

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    public interface a {
        @NonNull
        Bitmap a(int i2, int i3, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        byte[] a(int i2);

        @NonNull
        int[] b(int i2);
    }

    @Nullable
    Bitmap a();

    void a(@NonNull Bitmap.Config config);

    void b();

    int c();

    void clear();

    int d();

    int e();

    void f();

    int g();

    @NonNull
    ByteBuffer getData();

    int h();
}
