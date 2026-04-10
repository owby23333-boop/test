package com.anythink.basead.a.b;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static class a {
        public int a;
        public int b;
    }

    public static a a(String str) {
        a aVar;
        try {
        } catch (Exception e2) {
            e = e2;
            aVar = null;
        }
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        aVar = new a();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            mediaMetadataRetriever.release();
            aVar.a = Integer.parseInt(strExtractMetadata);
            aVar.b = Integer.parseInt(strExtractMetadata2);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return aVar;
        e.printStackTrace();
        return aVar;
    }

    private static a a(FileDescriptor fileDescriptor) {
        a aVar;
        if (fileDescriptor == null) {
            return null;
        }
        try {
            aVar = new a();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fileDescriptor);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                aVar.a = Integer.parseInt(strExtractMetadata);
                aVar.b = Integer.parseInt(strExtractMetadata2);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            aVar = null;
        }
        return aVar;
    }

    private static a a(String str, int i2, int i3) {
        a aVarA = a(str);
        if (aVarA == null) {
            return null;
        }
        float f2 = (aVarA.a * 1.0f) / aVarA.b;
        if (f2 < (i2 * 1.0f) / i3) {
            aVarA.b = i3;
            aVarA.a = (int) (aVarA.b * f2);
        } else {
            aVarA.a = i2;
            aVarA.b = (int) (aVarA.a / f2);
        }
        return aVarA;
    }

    private static a a(FileDescriptor fileDescriptor, int i2, int i3) {
        a aVarA = a(fileDescriptor);
        if (aVarA == null) {
            return null;
        }
        if ((aVarA.a * 1.0f) / aVarA.b < (i2 * 1.0f) / i3) {
            aVarA.b = i3;
            aVarA.a = (int) Math.ceil(aVarA.b * r0);
        } else {
            aVarA.a = i2;
            aVarA.b = (int) Math.ceil(aVarA.a / r0);
        }
        return aVarA;
    }
}
