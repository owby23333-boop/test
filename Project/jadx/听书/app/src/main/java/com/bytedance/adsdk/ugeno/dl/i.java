package com.bytedance.adsdk.ugeno.dl;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.ugeno.dl.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f226a;
    private AnimatorSet dl = new AnimatorSet();
    private String e;
    private z g;
    private int gc;
    private int m;
    Paint z;

    public i(View view, z zVar) {
        this.f226a = view;
        this.g = zVar;
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
    }

    public void z() {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        List<z.C0044z> listDl = this.g.dl();
        if (listDl == null || listDl.size() <= 0) {
            return;
        }
        for (z.C0044z c0044z : listDl) {
            if (c0044z != null) {
                objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0044z.z());
                if (TextUtils.equals(c0044z.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0044z.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0044z.getType());
                }
                objectAnimator.setStartDelay(c0044z.a());
                objectAnimator.setTarget(this.f226a);
                if (TextUtils.equals(c0044z.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setIntValues((int) c0044z.gc(), (int) c0044z.m());
                } else {
                    objectAnimator.setFloatValues(c0044z.gc(), c0044z.m());
                }
                int iG = (int) this.g.g();
                if (iG != 0) {
                    objectAnimator.setRepeatCount(iG);
                } else {
                    objectAnimator.setRepeatCount((int) c0044z.g());
                }
                if (TextUtils.equals(c0044z.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strM = this.g.m();
                if (TextUtils.isEmpty(strM)) {
                    strM = c0044z.dl();
                }
                if (TextUtils.equals(strM, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0044z.e() != null && c0044z.e().length > 0) {
                    objectAnimator.setFloatValues(c0044z.e());
                }
                if (TextUtils.equals(c0044z.getType(), "rotationX")) {
                    this.f226a.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.dl.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.f226a.setPivotX(i.this.f226a.getWidth() / 2.0f);
                            i.this.f226a.setPivotY(i.this.f226a.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0044z.getType(), "ripple")) {
                    this.e = c0044z.fo();
                }
                String strGz = c0044z.gz();
                strGz.hashCode();
                switch (strGz) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.g.a() != 0) {
            this.dl.setDuration(this.g.a());
        }
        this.dl.setStartDelay(this.g.gc());
        if (TextUtils.equals(this.g.z(), "sequentially")) {
            this.dl.playSequentially(arrayList);
        } else {
            this.dl.playTogether(arrayList);
        }
        this.dl.start();
    }

    public void g() {
        AnimatorSet animatorSet = this.dl;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void z(Canvas canvas, gc gcVar) {
        try {
            if (gcVar.getRipple() == 0.0f || TextUtils.isEmpty(this.e)) {
                return;
            }
            this.z.setColor(com.bytedance.adsdk.ugeno.m.z.z(this.e));
            this.z.setAlpha(90);
            ((ViewGroup) this.f226a.getParent()).setClipChildren(true);
            canvas.drawCircle(this.gc, this.m, Math.min(r0, r2) * 2 * gcVar.getRipple(), this.z);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void z(int i, int i2) {
        this.gc = i / 2;
        this.m = i2 / 2;
    }
}
