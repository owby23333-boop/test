package com.xiaomi.passport.ui.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.renderscript.RenderScript;
import com.google.common.base.Ascii;
import com.xiaomi.account.passportsdk.account_sso.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes8.dex */
public class BitmapFactory extends android.graphics.BitmapFactory {
    public static final int BITMAP_COLOR_MODE_DARK = 0;
    public static final int BITMAP_COLOR_MODE_LIGHT = 2;
    public static final int BITMAP_COLOR_MODE_MEDIUM = 1;
    static RenderScript sRsContext;
    private static final Paint sSrcInPaint;
    static Object sLockForRsContext = new Object();
    private static byte[] PNG_HEAD_FORMAT = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    private static final ThreadLocal<Canvas> sCanvasCache = new ThreadLocal<>();

    public static class CropOption {
        public int borderColor;
        public int borderWidth;
        public int rx;
        public int ry;
        public Rect srcBmpDrawingArea;

        public CropOption() {
        }

        public CropOption(int i, int i2, int i3, int i4) {
            this.rx = i;
            this.ry = i2;
            this.borderWidth = i3;
            this.borderColor = i4;
        }

        public CropOption(CropOption cropOption) {
            this.rx = cropOption.rx;
            this.ry = cropOption.ry;
            this.borderWidth = cropOption.borderWidth;
            this.borderColor = cropOption.borderColor;
            this.srcBmpDrawingArea = cropOption.srcBmpDrawingArea;
        }
    }

    static {
        Paint paint = new Paint(1);
        sSrcInPaint = paint;
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public BitmapFactory() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static int between(int i, int i2, int i3) {
        return Math.min(i2, Math.max(i, i3));
    }

    public static Bitmap composeBitmap(Bitmap bitmap, Bitmap bitmap2, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        return composeBitmap(bitmap, bitmap2, drawable2, drawable3, drawable4, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), bitmap2 != null ? new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()) : new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
    }

    private static Bitmap copyToEmpty(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        return Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
    }

    public static Bitmap createPhoto(Context context, Bitmap bitmap) {
        return createPhoto(context, bitmap, context.getResources().getDimensionPixelSize(R.dimen.passport_contact_photo_width));
    }

    public static Bitmap cropBitmap(Bitmap bitmap, CropOption cropOption) {
        if (bitmap != null) {
            return cropBitmap(bitmap, copyToEmpty(bitmap), cropOption);
        }
        return null;
    }

    public static int getBitmapColorMode(Bitmap bitmap, int i) {
        int height = bitmap.getHeight() / i;
        int width = bitmap.getWidth() / i;
        int i2 = (width * height) / 5;
        Bitmap bitmapScaleBitmap = scaleBitmap(bitmap, width, height);
        int i3 = 2;
        int i4 = 0;
        for (int i5 = 0; i5 < width; i5++) {
            int i6 = 0;
            while (true) {
                if (i6 < height) {
                    int pixel = bitmapScaleBitmap.getPixel(i5, i6);
                    if (((int) ((((double) ((16711680 & pixel) >> 16)) * 0.3d) + (((double) ((65280 & pixel) >> 8)) * 0.59d) + (((double) (pixel & 255)) * 0.11d))) < 180) {
                        i4++;
                        if (i4 > i2) {
                            i3 = 1;
                        }
                        if (i4 > i2 * 2) {
                            i3 = 0;
                            break;
                        }
                    }
                    i6++;
                }
            }
        }
        if (bitmapScaleBitmap != bitmap) {
            bitmapScaleBitmap.recycle();
        }
        return i3;
    }

    private static Canvas getCachedCanvas() {
        ThreadLocal<Canvas> threadLocal = sCanvasCache;
        Canvas canvas = threadLocal.get();
        if (canvas != null) {
            return canvas;
        }
        Canvas canvas2 = new Canvas();
        threadLocal.set(canvas2);
        return canvas2;
    }

    private static Bitmap maskOutBitmap(Bitmap bitmap, Drawable drawable2, Bitmap bitmap2, Rect rect, Rect rect2) {
        int i;
        if (bitmap2 == null && rect2 == null) {
            return null;
        }
        int i2 = 0;
        if (bitmap2 == null) {
            if (rect2.height() <= 0 || rect2.width() <= 0) {
                return null;
            }
            bitmap2 = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        } else if (rect2 == null) {
            rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        }
        Canvas cachedCanvas = getCachedCanvas();
        cachedCanvas.setBitmap(bitmap2);
        cachedCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (drawable2 != null) {
            drawable2.setBounds(rect2);
            drawable2.draw(cachedCanvas);
        }
        if (rect == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int iWidth = rect2.width();
            float fHeight = rect2.height();
            float f = iWidth;
            float f2 = fHeight / f;
            float f3 = width;
            float f4 = f3 / f;
            float f5 = height;
            float f6 = f5 / fHeight;
            if (f4 > f6) {
                int i3 = (int) (f5 / f2);
                i2 = (width - i3) / 2;
                width = i3;
                i = 0;
            } else if (f4 < f6) {
                int i4 = (int) (f2 * f3);
                i = (height - i4) / 2;
                height = i4;
            } else {
                i = 0;
            }
            rect = new Rect(i2, i, width + i2, height + i);
        }
        cachedCanvas.drawBitmap(bitmap, rect, rect2, sSrcInPaint);
        return bitmap2;
    }

    public static File saveAsFile(Context context, InputStream inputStream, String str) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(context.openFileOutput(str, 0));
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = bufferedInputStream.read(bArr);
                if (i != -1) {
                    bufferedOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            } finally {
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException unused2) {
        }
        return context.getFileStreamPath(str);
    }

    public static boolean saveToFile(Bitmap bitmap, String str) throws IOException {
        return saveToFile(bitmap, str, false);
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        scaleBitmap(bitmap, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private static Bitmap transferF16ToARGB(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setFlags(3);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private static boolean saveToFile(Bitmap bitmap, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static Bitmap createPhoto(Context context, Bitmap bitmap, int i) {
        Resources resources = context.getResources();
        return composeBitmap(bitmap, null, resources.getDrawable(R.drawable.ic_contact_photo_mask), resources.getDrawable(R.drawable.ic_contact_photo_fg), resources.getDrawable(R.drawable.ic_contact_photo_bg), i);
    }

    private static Bitmap cropBitmap(Bitmap bitmap, Bitmap bitmap2, CropOption cropOption) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        CropOption cropOption2 = cropOption == null ? new CropOption() : cropOption;
        Rect rect = cropOption2.srcBmpDrawingArea;
        if (rect == null) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int iBetween = between(0, bitmap.getWidth() - 1, rect.left);
        int iBetween2 = between(iBetween, bitmap.getWidth(), rect.right);
        int iBetween3 = between(0, bitmap.getHeight() - 1, rect.top);
        int iBetween4 = between(iBetween3, bitmap.getHeight(), rect.bottom);
        int i = iBetween2 - iBetween;
        int i2 = iBetween4 - iBetween3;
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        cropOption2.borderWidth = between(0, Math.min(width, height) / 2, cropOption2.borderWidth);
        cropOption2.rx = between(0, width / 2, cropOption2.rx);
        cropOption2.ry = between(0, height / 2, cropOption2.ry);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setDither(true);
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawARGB(0, 0, 0, 0);
        int i3 = cropOption2.rx;
        int i4 = cropOption2.borderWidth;
        if (i3 - i4 > 0 && cropOption2.ry - i4 > 0) {
            int i5 = cropOption2.borderWidth;
            RectF rectF = new RectF(i5, i5, width - i5, height - i5);
            int i6 = cropOption2.rx;
            int i7 = cropOption2.borderWidth;
            canvas.drawRoundRect(rectF, i6 - i7, cropOption2.ry - i7, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        int i8 = cropOption2.borderWidth;
        float f = i;
        float f2 = width - (i8 * 2);
        float f3 = i2;
        float f4 = height - (i8 * 2);
        float fMin = Math.min((f * 1.0f) / f2, (1.0f * f3) / f4);
        int i9 = (int) ((f - (f2 * fMin)) / 2.0f);
        int i10 = (int) ((f3 - (f4 * fMin)) / 2.0f);
        Rect rect2 = new Rect(iBetween + i9, iBetween3 + i10, iBetween2 - i9, iBetween4 - i10);
        int i11 = cropOption2.borderWidth;
        canvas.drawBitmap(bitmap, rect2, new Rect(i11, i11, width - i11, height - i11), paint);
        if (cropOption2.borderWidth > 0) {
            int i12 = cropOption2.borderColor;
            if ((i12 >>> 24) != 0) {
                paint.setColor(i12);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), cropOption2.rx, cropOption2.ry, paint);
            }
        }
        return bitmap2;
    }

    public static Bitmap composeBitmap(Bitmap bitmap, Bitmap bitmap2, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i) {
        return composeBitmap(bitmap, bitmap2, drawable2, drawable3, drawable4, null, new Rect(0, 0, i, i));
    }

    public static Bitmap composeBitmap(Bitmap bitmap, Bitmap bitmap2, Drawable drawable2, Drawable drawable3, Drawable drawable4, Rect rect, Rect rect2) {
        if (bitmap2 == null && rect2 == null) {
            return null;
        }
        if (bitmap2 == null) {
            if (rect2.height() <= 0 || rect2.width() <= 0) {
                return null;
            }
            bitmap2 = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        } else if (rect2 == null) {
            rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        }
        Bitmap bitmapMaskOutBitmap = maskOutBitmap(bitmap, drawable2, null, rect, rect2);
        Canvas cachedCanvas = getCachedCanvas();
        cachedCanvas.setBitmap(bitmap2);
        if (drawable4 != null) {
            drawable4.setBounds(rect2);
            drawable4.draw(cachedCanvas);
        }
        cachedCanvas.drawBitmap(bitmapMaskOutBitmap, rect2, rect2, (Paint) null);
        bitmapMaskOutBitmap.recycle();
        if (drawable3 != null) {
            drawable3.setBounds(rect2);
            drawable3.draw(cachedCanvas);
        }
        return bitmap2;
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        if (bitmap.getWidth() == bitmap2.getWidth() && bitmap.getHeight() == bitmap2.getHeight()) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), paint);
        return bitmap2;
    }
}
