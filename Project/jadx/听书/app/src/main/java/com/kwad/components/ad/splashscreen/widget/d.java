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
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AnimationDrawable {
    private Bitmap KI;
    private Bitmap KJ;
    private Bitmap KK;
    private Bitmap KL;
    private Bitmap KM;
    private Bitmap KN;
    private int KO;
    private RectF KP;
    private Paint KQ;
    private Paint KR;
    private PorterDuffXfermode KS;
    private final int KT;
    private final int KU;
    private float KV;
    private float KW;
    private RectF KX;
    private Paint KY;
    private int KZ;
    private int La;
    private ValueAnimator Lb;
    private final float Lc = 6.0f;
    private final float Ld = 11.0f;
    private float Le;
    private float Lf;
    private int Lg;
    private Context mContext;

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public d(Context context, int i) {
        this.mContext = context;
        this.KT = com.kwad.sdk.c.a.a.a(context, 51.0f);
        this.KU = com.kwad.sdk.c.a.a.a(context, 61.0f);
        this.Lg = i;
        init();
    }

    private void init() {
        this.KI = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.KJ = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.KK = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.KL = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.KM = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i = this.Lg;
        if (i == 0) {
            this.KN = bitmapDecodeResource;
        } else if (i == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.KN = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
        } else if (i == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.KN = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix2, true);
        }
        this.KO = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
        this.KY = new Paint(1);
        int i2 = this.Lg;
        if (i2 == 0) {
            this.La = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.KZ = dimension;
            this.KV = (-this.KU) * 0.22f;
            this.KW = dimension * 0.08f;
        } else if (i2 == 1) {
            this.La = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.KZ = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.KV = this.La * 0.09f;
            this.KW = (-this.KT) * 0.2f;
        } else if (i2 == 2) {
            this.La = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.KZ = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.KV = this.La * 0.09f;
            this.KW = (-this.KT) * 0.5f;
        }
        this.KX = new RectF(0.0f, 0.0f, this.KZ, this.La);
        this.KQ = new Paint(3);
        Paint paint = new Paint(3);
        this.KR = paint;
        paint.setDither(true);
        this.KP = new RectF(this.KX.right - this.KT, 0.0f, this.KX.right, this.KU);
        this.KS = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.Lb = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1100L);
        this.Lb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.Le = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d dVar = d.this;
                dVar.e(dVar.Le);
                d.this.invalidateSelf();
            }
        });
        this.Lb.setRepeatCount(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f) {
        if (f <= 6.0f) {
            float f2 = f / 6.0f;
            int i = this.Lg;
            if (i == 0) {
                this.KX.top = this.La * (1.0f - f2);
                this.KP.offsetTo(this.KX.left + this.KW, this.KX.top + this.KV);
                this.Lf = (f2 * 30.0f) + 290.0f;
                return;
            }
            if (i == 1) {
                float f3 = 1.0f - f2;
                this.KX.left = this.KZ * f3;
                this.KP.offsetTo(this.KX.left + this.KW, this.KX.top + this.KV);
                this.Lf = f3 * 30.0f;
                return;
            }
            if (i != 2) {
                return;
            }
            this.KX.right = this.KZ * f2;
            this.KP.offsetTo(this.KX.right + this.KW, this.KX.top + this.KV);
            this.Lf = (f2 * 30.0f) + 330.0f;
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.KZ + this.KT;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.La + this.KU + this.KO;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.KX == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.KZ) / 2, (getIntrinsicHeight() - this.La) / 2);
        float f = this.Le;
        if (f <= 6.0f) {
            this.KY.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.KR.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.KY.setAlpha(i);
            this.KR.setAlpha(i);
        }
        int iSave = canvas.save();
        int iSaveLayer = canvas.saveLayer(this.KX, this.KY, 31);
        try {
            canvas.drawBitmap(this.KN, (Rect) null, this.KX, this.KY);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.Lf, this.KP.centerX(), this.KP.centerY());
        this.KQ.setXfermode(this.KS);
        int i2 = this.Lg;
        if (i2 == 0) {
            canvas.drawBitmap(this.KL, (Rect) null, this.KP, this.KQ);
            canvas.drawBitmap(this.KM, (Rect) null, this.KP, this.KQ);
        } else if (i2 == 1) {
            canvas.drawBitmap(this.KJ, (Rect) null, this.KP, this.KQ);
            canvas.drawBitmap(this.KK, (Rect) null, this.KP, this.KQ);
        }
        canvas.drawBitmap(this.KI, (Rect) null, this.KP, this.KQ);
        canvas.restoreToCount(iSaveLayer);
        canvas.rotate(this.Lf, this.KP.centerX(), this.KP.centerY());
        canvas.drawBitmap(this.KI, (Rect) null, this.KP, this.KR);
        canvas.restoreToCount(iSave);
        canvas.restore();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.Lb;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.Lb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.Lb;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }
}
