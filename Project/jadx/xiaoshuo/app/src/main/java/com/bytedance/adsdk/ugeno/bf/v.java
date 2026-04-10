package com.bytedance.adsdk.ugeno.bf;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.adsdk.ugeno.bf.e;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private AnimatorSet bf = new AnimatorSet();
    private View d;
    private e e;

    public v(View view, e eVar) {
        this.d = view;
        this.e = eVar;
    }

    public void bf() {
        AnimatorSet animatorSet = this.bf;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void e() {
        ArrayList arrayList = new ArrayList();
        List<e.C0064e> listBf = this.e.bf();
        if (listBf == null || listBf.size() <= 0) {
            return;
        }
        for (e.C0064e c0064e : listBf) {
            if (c0064e != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0064e.e());
                objectAnimator.setPropertyName(c0064e.getType());
                objectAnimator.setStartDelay(c0064e.tg());
                objectAnimator.setTarget(this.d);
                if (TextUtils.equals(c0064e.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setIntValues((int) c0064e.ga(), (int) c0064e.vn());
                    Log.d("UGenAnimation", "playAnimation: from = " + c0064e.ga() + "; to=" + c0064e.vn());
                } else {
                    objectAnimator.setFloatValues(c0064e.ga(), c0064e.vn());
                }
                objectAnimator.setRepeatCount((int) c0064e.bf());
                if (TextUtils.equals(c0064e.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                if (TextUtils.equals(c0064e.d(), "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0064e.p() != null && c0064e.p().length > 0) {
                    objectAnimator.setFloatValues(c0064e.p());
                }
                if (TextUtils.equals(c0064e.getType(), "rotationX")) {
                    this.d.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.bf.v.1
                        @Override // java.lang.Runnable
                        public void run() {
                            v.this.d.setPivotX(v.this.d.getWidth() / 2.0f);
                            v.this.d.setPivotY(v.this.d.getHeight());
                        }
                    });
                }
                arrayList.add(objectAnimator);
            }
        }
        if (TextUtils.equals(this.e.e(), "together")) {
            this.bf.playTogether(arrayList);
        } else if (TextUtils.equals(this.e.e(), "sequentially")) {
            this.bf.playSequentially(arrayList);
        }
        this.bf.start();
    }
}
