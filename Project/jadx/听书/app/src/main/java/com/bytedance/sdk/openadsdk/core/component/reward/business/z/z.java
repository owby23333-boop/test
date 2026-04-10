package com.bytedance.sdk.openadsdk.core.component.reward.business.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.g.g;
import com.bytedance.sdk.openadsdk.hh.e;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f938a;
    private ImageView dl;
    private TextView e;
    private ObjectAnimator fo;
    private final na g;
    private View gc;
    private ObjectAnimator gz;
    private LinearLayout m;
    private final g uy;
    private final TTBaseVideoActivity z;

    public z(TTBaseVideoActivity tTBaseVideoActivity, na naVar, g gVar) {
        this.z = tTBaseVideoActivity;
        this.g = naVar;
        this.uy = gVar;
    }

    public void z(ViewGroup viewGroup, View view) {
        this.f938a = viewGroup;
        this.gc = view;
        this.dl = new ImageView(this.z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, oq.dl(this.z, 76.0f));
        layoutParams.gravity = 80;
        this.dl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f938a.addView(this.dl, layoutParams);
    }

    public void z() {
        int iFv;
        LinearLayout linearLayout = new LinearLayout(this.z);
        this.m = linearLayout;
        linearLayout.setGravity(1);
        this.m.setPadding(0, oq.dl(this.z, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, oq.dl(this.z, 76.0f));
        TextView textView = new TextView(this.z);
        this.e = textView;
        textView.setTextSize(12.0f);
        this.e.setTextColor(-1);
        this.e.setSingleLine();
        this.e.setEllipsize(TextUtils.TruncateAt.START);
        this.e.setGravity(5);
        this.e.setMaxWidth(oq.dl(this.z, 260.0f));
        this.m.addView(this.e);
        TextView textView2 = new TextView(this.z);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("取消");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.z.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.a();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = oq.dl(this.z, 10.0f);
        this.m.addView(textView2, layoutParams2);
        z(25, tf.g(this.g));
        int iDl = oq.dl(this.z, 76.0f);
        this.f938a.addView(this.m, layoutParams);
        try {
            int iG = gz.g(this.z);
            if (oq.a((Activity) this.z)) {
                iFv = (gz.dl(this.z) - iG) - g();
            } else {
                iFv = oq.fv(this.z);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m, "translationY", iG, (iG - iDl) + iFv);
            this.gz = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.gz.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.gc, "translationY", 0.0f, -iDl);
            this.fo = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.fo.start();
        } catch (Throwable th) {
            wp.a(TtmlNode.TAG_LAYOUT, th.getMessage());
        }
    }

    public int g() {
        int identifier = this.z.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.z.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void z(final int i, String str) {
        com.bytedance.sdk.openadsdk.gz.g.z(str).type(2).config(Bitmap.Config.ARGB_8888).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.z.z.2
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                try {
                    Bitmap result = lsVar.getResult();
                    if (result == null) {
                        return;
                    }
                    if (result.getConfig() == Bitmap.Config.RGB_565) {
                        result = result.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(z.this.z, result, i);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(z.this.z.getResources(), bitmapZ);
                    e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.z.z.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z.this.m != null) {
                                z.this.m.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (z.this.dl != null) {
                                z.this.dl.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    wp.a(TtmlNode.TAG_LAYOUT, th.getMessage());
                }
            }
        }, 4);
    }

    public void dl() {
        a();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.gc, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.z.z.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                z.this.gc.setAlpha(1.0f);
                z.this.uy.fo();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        uy uyVar = new uy();
        uyVar.g(true);
        if (gVar != null) {
            gVar.z(uyVar);
            gVar.z(null, uyVar);
        }
    }

    public void a() {
        ObjectAnimator objectAnimator = this.gz;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.gz.cancel();
            this.gz = null;
        }
        ObjectAnimator objectAnimator2 = this.fo;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.fo.cancel();
            this.fo = null;
        }
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.gc;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.dl;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.uy.gz();
    }

    public void z(long j) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
