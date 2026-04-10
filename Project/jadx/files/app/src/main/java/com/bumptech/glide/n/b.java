package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final List<ImageHeaderParser> a = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        return this.a;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
    }
}
