package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.q;

/* JADX INFO: loaded from: classes3.dex */
public class gc extends e {
    private float fo;
    private float gz;
    private LottieAnimationView kb;
    private VideoFrame uy;
    private fo.z.C0038z wp;

    public gc(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, Context context, fo.z.C0038z c0038z) {
        super(gzVar, gzVar2);
        this.gz = -1.0f;
        this.fo = -1.0f;
        this.wp = c0038z;
        if (this.e == null || gzVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewG = gzVar.g();
        this.kb = lottieAnimationViewG;
        if (lottieAnimationViewG == null) {
            return;
        }
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        this.gz = (int) (this.e.z() * fZ);
        this.fo = (int) (this.e.g() * fZ);
        q qVarZ = gzVar.z();
        View viewZ = qVarZ != null ? qVarZ.z("videoview:", null) : null;
        if (viewZ instanceof TextureView) {
            this.uy = new VideoFrame(context, (TextureView) viewZ, c0038z);
        }
        this.kb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.gc.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (gc.this.kb == view) {
                    gc.this.v();
                }
            }
        });
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        VideoFrame videoFrame = this.uy;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.uy);
            }
            ViewParent parent2 = this.kb.getParent();
            if (parent2 instanceof ViewGroup) {
                this.uy.setTranslationX(2.1474836E9f);
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
        this.uy.draw(canvas);
        canvas.restore();
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
