package com.king.zxing.r;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.FloatRange;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CodeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static Bitmap a(String str, int i2, Bitmap bitmap, int i3) {
        return a(str, i2, bitmap, 0.2f, i3);
    }

    public static Bitmap a(String str, int i2, Bitmap bitmap, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, int i3) {
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, com.anythink.expressad.foundation.g.a.bN);
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 1);
        return a(str, i2, bitmap, f2, map, i3);
    }

    public static Bitmap a(String str, int i2, Bitmap bitmap, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, Map<EncodeHintType, ?> map, int i3) {
        try {
            com.google.zxing.common.b bVarA = new com.google.zxing.r.b().a(str, BarcodeFormat.QR_CODE, i2, i2, map);
            int[] iArr = new int[i2 * i2];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    if (bVarA.b(i5, i4)) {
                        iArr[(i4 * i2) + i5] = i3;
                    } else {
                        iArr[(i4 * i2) + i5] = -1;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            return bitmap != null ? a(bitmapCreateBitmap, bitmap, f2) : bitmapCreateBitmap;
        } catch (WriterException e2) {
            b.c(e2.getMessage());
            return null;
        }
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f3 = (width * f2) / width2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f3, f3, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            b.c(e2.getMessage());
            return null;
        }
    }
}
