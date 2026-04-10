package com.kwad.framework.filedownloader.a;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.datasource.cache.CacheDataSink;
import com.kwad.framework.filedownloader.f.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int V(long j) {
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return 1;
        }
        if (j < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
