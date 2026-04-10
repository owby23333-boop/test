package com.bytedance.sdk.component.adexpress.a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.wp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final byte[] z = z("VP8X");

    private static byte[] z(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void dl(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (z(bArr)) {
            final com.bytedance.adsdk.z.z.z zVarZ = com.bytedance.adsdk.z.z.z.z(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.a.m.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(zVarZ);
                }
            });
        } else {
            a(imageView, bArr, i, i2);
        }
    }

    public static boolean z(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return z.z(bArr);
    }

    private static void a(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapZ = new com.bytedance.sdk.component.m.dl.g.z(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).z(bArr);
        if (bitmapZ != null) {
            com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.a.m.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapZ);
                }
            });
        }
    }

    public static void z(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.a.m.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable = drawableDecodeDrawable;
                        if (drawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
                return;
            } catch (IOException e) {
                wp.z(e);
                return;
            }
        }
        a(imageView, bArr, i, i2);
    }

    public static void g(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).z(bArr, false);
                return;
            }
            if (TextUtils.equals("png", com.bytedance.sdk.component.utils.fo.z(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.fo.z())))) {
                dl(imageView, bArr, i, i2);
            } else if (z(bArr, 0)) {
                z(imageView, bArr, i, i2);
            } else {
                a(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean z(byte[] bArr, int i) {
        try {
            boolean z2 = z(bArr, i + 12, z);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return z2 && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            wp.z(th);
            return false;
        }
    }

    private static boolean z(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
