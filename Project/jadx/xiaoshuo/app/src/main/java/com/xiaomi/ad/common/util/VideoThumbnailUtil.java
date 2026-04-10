package com.xiaomi.ad.common.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class VideoThumbnailUtil {
    public static Bitmap getFirstFrameThumbnail(String str) {
        return getFrameAtTime(0L, str);
    }

    public static Bitmap getFrameAtTime(long j, String str) throws IOException {
        Bitmap frameAtTime = null;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(j, 3);
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
        }
        return frameAtTime;
    }

    public static boolean isAudioInVideoFile(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                new MediaMetadataRetriever().setDataSource(str);
                return !TextUtils.isEmpty(r0.extractMetadata(16));
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
