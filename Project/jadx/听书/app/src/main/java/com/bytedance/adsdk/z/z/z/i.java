package com.bytedance.adsdk.z.z.z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class i extends gz<com.bytedance.adsdk.z.z.g.z, com.bytedance.adsdk.z.z.g.g> {
    static final /* synthetic */ boolean z = true;

    public i(com.bytedance.adsdk.z.z.g.z zVar) {
        super(zVar);
    }

    @Override // com.bytedance.adsdk.z.z.z.gz
    public Bitmap z(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.z.z.g.g gVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.z.z.g.z) this.e).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.z.z.g.z) this.e).gc(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.z.z.g.z) this.e).gc(), null, options2);
            }
            try {
                if (!z && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = bitmapDecodeStream;
                com.bytedance.sdk.component.utils.wp.z(e);
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.wp.z(e);
            return bitmap2;
        }
    }
}
