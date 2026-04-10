package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

/* JADX INFO: compiled from: RequestListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g<R> {
    boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<R> jVar, boolean z2);

    boolean a(R r2, Object obj, com.bumptech.glide.request.k.j<R> jVar, DataSource dataSource, boolean z2);
}
