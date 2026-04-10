package me.jessyan.art.http.imageloader.glide.transform;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.x.e;
import com.umeng.message.proguard.ad;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";
    private static final int VERSION = 1;
    private CornerType cornerType;
    private int diameter;
    private int margin;
    private int radius;

    /* JADX INFO: renamed from: me.jessyan.art.http.imageloader.glide.transform.RoundedCornersTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType = new int[CornerType.values().length];

        static {
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int i2, int i3) {
        this(i2, i3, CornerType.ALL);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF(this.margin, f3 - this.diameter, r1 + r3, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, i3 + this.diameter, f3 - this.radius), paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f2, f3), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.diameter;
        RectF rectF = new RectF(f2 - i2, f3 - i2, f2, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF(i4, i4, f2 - this.radius, f3), paint);
        int i5 = this.radius;
        canvas.drawRect(new RectF(f2 - i5, this.margin, f2, f3 - i5), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF(this.margin, f3 - this.diameter, f2, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, f2, f3 - this.radius), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        int i3 = this.diameter;
        RectF rectF = new RectF(i2, i2, i2 + i3, i2 + i3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.diameter;
        RectF rectF2 = new RectF(f2 - i5, f3 - i5, f2, f3);
        int i6 = this.radius;
        canvas.drawRoundRect(rectF2, i6, i6, paint);
        canvas.drawRect(new RectF(this.margin, r1 + this.radius, f2 - this.diameter, f3), paint);
        canvas.drawRect(new RectF(this.diameter + r1, this.margin, f2, f3 - this.radius), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.diameter;
        RectF rectF = new RectF(f2 - i2, this.margin, f2, r3 + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        RectF rectF2 = new RectF(this.margin, f3 - this.diameter, r1 + r3, f3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF(i5, i5, f2 - i6, f3 - i6), paint);
        int i7 = this.margin;
        int i8 = this.radius;
        canvas.drawRect(new RectF(i7 + i8, i7 + i8, f2, f3), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        RectF rectF = new RectF(i2, i2, i2 + this.diameter, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f2, f3), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        RectF rectF = new RectF(i2, i2, f2, i2 + this.diameter);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        RectF rectF2 = new RectF(f2 - this.diameter, this.margin, f2, f3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        canvas.drawRect(new RectF(this.margin, r1 + r3, f2 - this.radius, f3), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        RectF rectF = new RectF(i2, i2, f2, i2 + this.diameter);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        RectF rectF2 = new RectF(i4, i4, i4 + this.diameter, f3);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        int i6 = this.margin;
        int i7 = this.radius;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, f2, f3), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF(this.margin, f3 - this.diameter, f2, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(f2 - this.diameter, this.margin, f2, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4, i4, f2 - i5, f3 - i5), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        RectF rectF = new RectF(i2, i2, i2 + this.diameter, f3);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        RectF rectF2 = new RectF(this.margin, f3 - this.diameter, f2, f3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        canvas.drawRect(new RectF(r1 + r2, this.margin, f2, f3 - this.radius), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        RectF rectF = new RectF(f2 - this.diameter, this.margin, f2, f3);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, f2 - this.radius, f3), paint);
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        float f4 = f2 - i2;
        float f5 = f3 - i2;
        switch (AnonymousClass1.$SwitchMap$me$jessyan$art$http$imageloader$glide$transform$RoundedCornersTransformation$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i3 = this.margin;
                RectF rectF = new RectF(i3, i3, f4, f5);
                int i4 = this.radius;
                canvas.drawRoundRect(rectF, i4, i4, paint);
                break;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 3:
                drawTopRightRoundRect(canvas, paint, f4, f5);
                break;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f4, f5);
                break;
            case 6:
                drawTopRoundRect(canvas, paint, f4, f5);
                break;
            case 7:
                drawBottomRoundRect(canvas, paint, f4, f5);
                break;
            case 8:
                drawLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 9:
                drawRightRoundRect(canvas, paint, f4, f5);
                break;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f4, f5);
                break;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f4, f5);
                break;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f4, f5);
                break;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f4, f5);
                break;
            default:
                int i5 = this.margin;
                RectF rectF2 = new RectF(i5, i5, f4, f5);
                int i6 = this.radius;
                canvas.drawRoundRect(rectF2, i6, i6, paint);
                break;
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        int i3 = this.diameter;
        RectF rectF = new RectF(i2, i2, i2 + i3, i2 + i3);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF(i5, i5 + i6, i5 + i6, f3), paint);
        canvas.drawRect(new RectF(this.radius + r1, this.margin, f2, f3), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.diameter;
        RectF rectF = new RectF(f2 - i2, this.margin, f2, r3 + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF(i4, i4, f2 - this.radius, f3), paint);
        canvas.drawRect(new RectF(f2 - this.radius, this.margin + r1, f2, f3), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float f2, float f3) {
        int i2 = this.margin;
        RectF rectF = new RectF(i2, i2, f2, i2 + this.diameter);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        canvas.drawRect(new RectF(this.margin, r1 + this.radius, f2, f3), paint);
    }

    @Override // me.jessyan.art.http.imageloader.glide.transform.BitmapTransformation, com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.radius == this.radius && roundedCornersTransformation.diameter == this.diameter && roundedCornersTransformation.margin == this.margin && roundedCornersTransformation.cornerType == this.cornerType) {
                return true;
            }
        }
        return false;
    }

    @Override // me.jessyan.art.http.imageloader.glide.transform.BitmapTransformation, com.bumptech.glide.load.c
    public int hashCode() {
        return ID.hashCode() + (this.radius * 10000) + (this.diameter * 1000) + (this.margin * 100) + (this.cornerType.ordinal() * 10);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + ad.f20406s;
    }

    @Override // me.jessyan.art.http.imageloader.glide.transform.BitmapTransformation
    protected Bitmap transform(@NonNull Context context, @NonNull e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapA = eVar.a(width, height, Bitmap.Config.ARGB_8888);
        bitmapA.setHasAlpha(true);
        setCanvasBitmapDensity(bitmap, bitmapA);
        Canvas canvas = new Canvas(bitmapA);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, width, height);
        return bitmapA;
    }

    @Override // me.jessyan.art.http.imageloader.glide.transform.BitmapTransformation, com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.diameter + this.margin + this.cornerType).getBytes(c.a));
    }

    public RoundedCornersTransformation(int i2, int i3, CornerType cornerType) {
        this.radius = i2;
        this.diameter = this.radius * 2;
        this.margin = i3;
        this.cornerType = cornerType;
    }
}
