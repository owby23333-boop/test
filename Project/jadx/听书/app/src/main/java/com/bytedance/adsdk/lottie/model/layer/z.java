package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.gc.g;
import com.bytedance.adsdk.lottie.tb;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class z extends e {
    private float fo;
    private float gz;
    private final Handler i;
    private Drawable kb;
    private ImageView uy;
    private final Runnable v;
    private LottieAnimationView wp;

    public z(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, Context context) {
        super(gzVar, gzVar2);
        this.gz = -1.0f;
        this.fo = -1.0f;
        this.i = new Handler(Looper.getMainLooper());
        this.v = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.z.5
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.wp != null && z.this.wp.gc()) {
                    z.this.wp.invalidate();
                }
                z.this.i.postDelayed(z.this.v, 40L);
            }
        };
        if (this.e == null || gzVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewG = gzVar.g();
        this.wp = lottieAnimationViewG;
        if (lottieAnimationViewG == null) {
            return;
        }
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        this.gz = (int) (this.e.z() * fZ);
        this.fo = (int) (this.e.g() * fZ);
        tb tbVarUf = gzVar.uf();
        String strZ = tbVarUf != null ? tbVarUf.z(this.e.wp()) : null;
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.uy = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.uy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.z.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (z.this.uy == view) {
                    z.this.ls();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (z.this.uy == view) {
                    z.this.v();
                    if (Build.VERSION.SDK_INT < 28 || !(z.this.kb instanceof AnimatedImageDrawable)) {
                        return;
                    }
                    ((AnimatedImageDrawable) z.this.kb).stop();
                }
            }
        });
        this.wp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.z.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (z.this.wp == view) {
                    if (z.this.g()) {
                        z.this.wp.removeOnAttachStateChangeListener(this);
                    } else {
                        z.this.z(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.z.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                z.this.p();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (z.this.wp == view) {
                    z.this.z(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.z.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = z.this.uy.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(z.this.uy);
                            }
                        }
                    });
                }
            }
        });
        z(strZ, context);
    }

    private void z(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.gc.g.z(context), com.bytedance.sdk.component.utils.gc.g(str));
        if (file.exists()) {
            z(file);
        } else {
            com.bytedance.adsdk.lottie.gc.g.z(str, context, new g.z<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.z.3
                @Override // com.bytedance.adsdk.lottie.gc.g.z
                public void z(File file2) {
                    z.this.z(file2);
                }

                @Override // com.bytedance.adsdk.lottie.gc.g.z
                public void z(int i, String str2) {
                    com.bytedance.sdk.component.utils.wp.z("TMe", "--==--- webp: " + i + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.kb;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.kb = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.i.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.z.4
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.p();
                    }
                });
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.i.removeCallbacksAndMessages(null);
    }

    private void pf() {
        v();
        if (this.wp != null) {
            this.i.postDelayed(this.v, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.kb;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.kb).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.kb).start();
            pf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.kb != null) {
            ViewParent parent = this.uy.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.uy);
            }
            ViewParent parent2 = this.wp.getParent();
            if (parent2 instanceof ViewGroup) {
                this.uy.setTranslationX(2.1474836E9f);
                this.uy.setImageDrawable(this.kb);
                ((ViewGroup) parent2).addView(this.uy);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.e, com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.gz <= 0.0f || this.uy == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        z(i);
        float fGz = gz();
        z(this.uy, (int) this.gz, (int) this.fo);
        this.uy.setAlpha(fGz);
        canvas.clipRect(0.0f, 0.0f, this.gz, this.fo);
        this.uy.draw(canvas);
        canvas.restore();
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
