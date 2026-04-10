package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.uy;
import com.bytedance.sdk.component.utils.iq;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f612a;
    private iq dl;
    private LottieAnimationView e;
    private boolean fo;
    private TextView g;
    private z gc;
    private uy gz;
    private LinearLayout m;
    public int z;

    public interface z {
        void z();
    }

    public WriggleGuideAnimationView(Context context, View view, uy uyVar, boolean z2, int i) {
        super(context);
        this.gz = uyVar;
        this.fo = z2;
        this.z = i;
        z(context, view);
    }

    private void z(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.m = (LinearLayout) findViewById(2097610722);
        this.g = (TextView) findViewById(2097610719);
        this.f612a = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.e = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.e.setImageAssetsFolder("images/");
        this.e.z(true);
    }

    public void setShakeText(String str) {
        this.f612a.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.m;
    }

    public View getWriggleProgressIv() {
        return this.e;
    }

    public TextView getTopTextView() {
        return this.g;
    }

    public void setOnShakeViewListener(z zVar) {
        this.gc = zVar;
    }

    public void z() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.e.z();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.dl == null) {
                this.dl = new iq(getContext().getApplicationContext(), 2, this.fo);
            }
            this.dl.z(new iq.z() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.iq.z
                public void z(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.gc != null) {
                        WriggleGuideAnimationView.this.gc.z();
                    }
                }
            });
            if (this.gz != null) {
                this.dl.g(r0.dl());
                this.dl.m(this.gz.gc());
                this.dl.z(this.gz.m());
                this.dl.g(this.gz.gz());
            }
            this.dl.z(this.z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iq iqVar = this.dl;
        if (iqVar != null) {
            iqVar.g(this.z);
        }
        try {
            LottieAnimationView lottieAnimationView = this.e;
            if (lottieAnimationView != null) {
                lottieAnimationView.m();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        iq iqVar = this.dl;
        if (iqVar != null) {
            if (z2) {
                iqVar.z(this.z);
            } else {
                iqVar.g(this.z);
            }
        }
    }
}
