package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends AnimationDrawable {
    private Paint FA;
    private PorterDuffXfermode FB;
    private final int FC;
    private final int FD;
    private float FE;
    private float FF;
    private RectF FG;
    private Paint FH;
    private int FI;
    private int FJ;
    private ValueAnimator FK;
    private final float FL = 6.0f;
    private final float FM = 11.0f;
    private float FN;
    private float FO;
    private int FP;
    private Bitmap Fr;
    private Bitmap Fs;
    private Bitmap Ft;
    private Bitmap Fu;
    private Bitmap Fv;
    private Bitmap Fw;
    private int Fx;
    private RectF Fy;
    private Paint Fz;
    private Context mContext;

    public c(Context context, int i2) {
        this.mContext = context;
        this.FC = com.kwad.sdk.b.kwai.a.a(context, 51.0f);
        this.FD = com.kwad.sdk.b.kwai.a.a(context, 61.0f);
        this.FP = i2;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2) {
        if (f2 <= 6.0f) {
            float f3 = f2 / 6.0f;
            int i2 = this.FP;
            if (i2 == 0) {
                RectF rectF = this.FG;
                rectF.top = this.FJ * (1.0f - f3);
                this.Fy.offsetTo(rectF.left + this.FF, rectF.top + this.FE);
                this.FO = (f3 * 30.0f) + 290.0f;
                return;
            }
            if (i2 == 1) {
                RectF rectF2 = this.FG;
                float f4 = 1.0f - f3;
                rectF2.left = this.FI * f4;
                this.Fy.offsetTo(rectF2.left + this.FF, rectF2.top + this.FE);
                this.FO = f4 * 30.0f;
                return;
            }
            if (i2 != 2) {
                return;
            }
            RectF rectF3 = this.FG;
            rectF3.right = this.FI * f3;
            this.Fy.offsetTo(rectF3.right + this.FF, rectF3.top + this.FE);
            this.FO = (f3 * 30.0f) + 330.0f;
        }
    }

    private void init() {
        float f2;
        float f3;
        Matrix matrix;
        float f4;
        this.Fr = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.Fs = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.Ft = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.Fu = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.Fv = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i2 = this.FP;
        if (i2 != 0) {
            if (i2 == 1) {
                matrix = new Matrix();
                f4 = 270.0f;
            } else if (i2 == 2) {
                matrix = new Matrix();
                f4 = 90.0f;
            }
            matrix.postRotate(f4);
            this.Fw = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
        } else {
            this.Fw = bitmapDecodeResource;
        }
        this.Fx = com.kwad.sdk.b.kwai.a.a(this.mContext, 10.0f);
        this.FH = new Paint(1);
        int i3 = this.FP;
        if (i3 == 0) {
            this.FJ = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.FI = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.FE = (-this.FD) * 0.22f;
            f2 = this.FI;
            f3 = 0.08f;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.FJ = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
                    this.FI = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
                    this.FE = this.FJ * 0.09f;
                    f2 = -this.FC;
                    f3 = 0.5f;
                }
                this.FG = new RectF(0.0f, 0.0f, this.FI, this.FJ);
                this.Fz = new Paint(3);
                this.FA = new Paint(3);
                this.FA.setDither(true);
                float f5 = this.FG.right;
                this.Fy = new RectF(f5 - this.FC, 0.0f, f5, this.FD);
                this.FB = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
                this.FK = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
                this.FK.setDuration(1100L);
                this.FK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c.this.FN = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        c cVar = c.this;
                        cVar.c(cVar.FN);
                        c.this.invalidateSelf();
                    }
                });
                this.FK.setRepeatCount(-1);
            }
            this.FJ = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.FI = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.FE = this.FJ * 0.09f;
            f2 = -this.FC;
            f3 = 0.2f;
        }
        this.FF = f2 * f3;
        this.FG = new RectF(0.0f, 0.0f, this.FI, this.FJ);
        this.Fz = new Paint(3);
        this.FA = new Paint(3);
        this.FA.setDither(true);
        float f52 = this.FG.right;
        this.Fy = new RectF(f52 - this.FC, 0.0f, f52, this.FD);
        this.FB = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.FK = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.FK.setDuration(1100L);
        this.FK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.FN = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.c(cVar.FN);
                c.this.invalidateSelf();
            }
        });
        this.FK.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.FG == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.FI) / 2, (getIntrinsicHeight() - this.FJ) / 2);
        float f2 = this.FN;
        if (f2 <= 6.0f) {
            this.FH.setAlpha((int) ((f2 * 255.0f) / 6.0f));
            this.FA.setAlpha(255);
        } else {
            int i2 = (int) ((1.0f - ((f2 - 6.0f) / 5.0f)) * 255.0f);
            this.FH.setAlpha(i2);
            this.FA.setAlpha(i2);
        }
        int iSave = canvas.save();
        int iSaveLayer = canvas.saveLayer(this.FG, this.FH, 31);
        canvas.drawBitmap(this.Fw, (Rect) null, this.FG, this.FH);
        canvas.rotate(this.FO, this.Fy.centerX(), this.Fy.centerY());
        this.Fz.setXfermode(this.FB);
        int i3 = this.FP;
        if (i3 != 0) {
            if (i3 == 1) {
                canvas.drawBitmap(this.Fs, (Rect) null, this.Fy, this.Fz);
                bitmap = this.Ft;
            }
            canvas.drawBitmap(this.Fr, (Rect) null, this.Fy, this.Fz);
            canvas.restoreToCount(iSaveLayer);
            canvas.rotate(this.FO, this.Fy.centerX(), this.Fy.centerY());
            canvas.drawBitmap(this.Fr, (Rect) null, this.Fy, this.FA);
            canvas.restoreToCount(iSave);
            canvas.restore();
        }
        canvas.drawBitmap(this.Fu, (Rect) null, this.Fy, this.Fz);
        bitmap = this.Fv;
        canvas.drawBitmap(bitmap, (Rect) null, this.Fy, this.Fz);
        canvas.drawBitmap(this.Fr, (Rect) null, this.Fy, this.Fz);
        canvas.restoreToCount(iSaveLayer);
        canvas.rotate(this.FO, this.Fy.centerX(), this.Fy.centerY());
        canvas.drawBitmap(this.Fr, (Rect) null, this.Fy, this.FA);
        canvas.restoreToCount(iSave);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.FJ + this.FD + this.Fx;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.FI + this.FC;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.FK;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.FK;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.FK;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
