package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.a.g;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.uy;
import com.bytedance.sdk.component.m.v;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageFlipSlide extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f600a;
    private Bitmap dl;
    private final Rect e;
    private float g;
    private Path gc;
    private final boolean gz;
    private final Rect m;
    Paint z;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.g = 0.1f;
        this.m = new Rect();
        this.e = new Rect();
        this.gz = z;
    }

    public void z(String str, String str2, List<String> list) {
        final v vVarKey = com.bytedance.sdk.component.adexpress.z.z.z.z().gc().from(str).key(str2);
        this.f600a = list;
        vVarKey.config(Bitmap.Config.ARGB_4444).type(2);
        if (getBlurPx() != 0) {
            vVarKey.converter(new uy() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.m.uy
                public Bitmap coverterTo(Bitmap bitmap) {
                    try {
                        return g.z(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                vVarKey.to(new io<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.m.io
                    public void onFailed(int i, String str3, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.io
                    public void onSuccess(ls<Bitmap> lsVar) {
                        try {
                            ImageFlipSlide.this.dl = ImageFlipSlide.this.z(lsVar.getResult(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        this.z.setDither(true);
        if (this.gz) {
            this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.f600a;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.f600a.size(); i++) {
            z(colorMatrix, this.f600a.get(i));
        }
        this.z.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void z(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else if (str.startsWith("grayscale") || str.startsWith("contrast")) {
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            } else if (str.startsWith("invert")) {
                float f = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, -1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            } else if (str.startsWith("sepia")) {
                float f2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f2, f2, 1.0f, 1.0f);
            } else if (str.startsWith("brightness")) {
                float f3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f3, f3, f3, 1.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.f600a == null) {
            return 0;
        }
        for (int i = 0; i < this.f600a.size(); i++) {
            if (this.f600a.get(i).contains("blur")) {
                return Integer.parseInt(this.f600a.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public void z(float f) {
        this.g = f;
        invalidate();
    }

    public void z(Path path) {
        this.gc = path;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dl == null) {
            return;
        }
        if (this.gz) {
            this.m.left = (int) (r0.getWidth() * (1.0f - this.g));
            this.m.right = this.dl.getWidth();
            this.m.top = 0;
            this.m.bottom = this.dl.getHeight();
            this.e.left = (int) (getWidth() * (1.0f - this.g));
            this.e.right = getWidth();
            this.e.top = 0;
            this.e.bottom = getHeight();
            canvas.drawBitmap(this.dl, this.m, this.e, this.z);
            return;
        }
        canvas.clipPath(this.gc);
        canvas.drawBitmap(this.dl, 0.0f, 0.0f, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap z(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        int i6 = 0;
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i4 = i7;
            i3 = width;
            i5 = (height / 2) - (i7 / 2);
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = height;
            i5 = 0;
            i6 = (width / 2) - (i8 / 2);
        }
        return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
    }
}
