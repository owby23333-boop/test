package com.anythink.expressad.exoplayer.f;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class e {
    private e() {
    }

    private static void a(MediaFormat mediaFormat, String str, String str2) {
        mediaFormat.setString(str, str2);
    }

    public static void a(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i2)), ByteBuffer.wrap(list.get(i2)));
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    private static void a(MediaFormat mediaFormat, @Nullable com.anythink.expressad.exoplayer.l.b bVar) {
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.f9934c);
            a(mediaFormat, "color-standard", bVar.a);
            a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.f9935d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
    }
}
