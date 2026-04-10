package com.bytedance.sdk.openadsdk.s;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class v {
    public static Bitmap e(String str, Map<String, String> map) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap frameAtTime = null;
        try {
            mediaMetadataRetriever.setDataSource(str, map);
            long j = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
            if (j > 0) {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 3);
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (RuntimeException unused3) {
        }
        return frameAtTime;
    }

    public static Bitmap e(String str) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap frameAtTime = null;
        try {
            mediaMetadataRetriever.setDataSource(str);
            long j = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
            if (j > 0) {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 3);
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (RuntimeException unused3) {
        }
        return frameAtTime;
    }
}
