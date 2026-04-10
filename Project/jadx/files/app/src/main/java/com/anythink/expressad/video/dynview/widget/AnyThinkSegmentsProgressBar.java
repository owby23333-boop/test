package com.anythink.expressad.video.dynview.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkSegmentsProgressBar extends LinearLayout {
    private final String a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<ProgressBar> f11769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f11770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11772l;

    public AnyThinkSegmentsProgressBar(Context context) {
        super(context);
        this.a = "AnyThinkSegmentsProgressBar";
        this.f11763c = 1;
        this.f11764d = 20;
        this.f11765e = 10;
        this.f11766f = 1;
        this.f11767g = -1711276033;
        this.f11768h = -1;
        this.f11769i = new ArrayList();
        this.f11772l = false;
    }

    private void a() {
        Drawable drawable;
        try {
            this.f11772l = getContext().getResources().getConfiguration().locale.getLanguage().contains(com.anythink.expressad.video.dynview.a.a.V);
        } catch (Throwable th) {
            o.d("AnyThinkSegmentsProgressBar", th.getMessage());
        }
        try {
            if (this.f11763c == 1) {
                setOrientation(1);
                if (TextUtils.isEmpty(this.f11771k)) {
                    this.f11771k = this.f11772l ? "正在播放第%s个，共%s个视频" : "The %s is playing, %s videos.";
                }
            }
            if (this.f11763c == 2) {
                setOrientation(0);
                if (TextUtils.isEmpty(this.f11771k)) {
                    this.f11771k = this.f11772l ? "广告 %s/%s" : "ADS %s/%s";
                }
            }
            this.f11769i.clear();
            removeAllViews();
            setBackgroundDrawable(c());
            this.f11770j = new TextView(getContext());
            this.f11770j.setTextColor(-1);
            this.f11770j.setTextSize(12.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f11770j.setLayoutParams(layoutParams);
            if (this.f11763c == 1) {
                layoutParams.gravity = 5;
                this.f11770j.setPadding(this.f11764d / 2, 15, this.f11764d / 2, 5);
            }
            if (this.f11763c == 2) {
                this.f11770j.setGravity(16);
                this.f11770j.setPadding(this.f11764d / 2, 0, this.f11764d / 2, 0);
            }
            try {
                int iA = i.a(getContext(), "anythink_reward_video_icon", i.f10645c);
                if (iA != 0 && (drawable = getContext().getResources().getDrawable(iA)) != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f11770j.setCompoundDrawables(drawable, null, null, null);
                    this.f11770j.setCompoundDrawablePadding(5);
                }
            } catch (Throwable th2) {
                o.d("AnyThinkSegmentsProgressBar", th2.getMessage());
            }
            this.f11770j.setText(a(this.f11766f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 25);
            linearLayout.setLayoutParams(layoutParams2);
            for (int i2 = 0; i2 < this.b; i2++) {
                ProgressBar progressBar = new ProgressBar(getContext(), null, R.attr.progressBarStyleHorizontal);
                progressBar.setMax(100);
                progressBar.setProgress(0);
                progressBar.setProgressDrawable(b());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 20, 1.0f);
                layoutParams3.leftMargin = this.f11764d / 2;
                layoutParams3.rightMargin = this.f11764d / 2;
                progressBar.setLayoutParams(layoutParams3);
                linearLayout.addView(progressBar);
                this.f11769i.add(progressBar);
            }
            if (this.f11763c == 1) {
                setPadding(15, 10, 15, 25);
                addView(this.f11770j);
                addView(linearLayout);
            }
            if (this.f11763c == 2) {
                setPadding(15, 0, 15, 25);
                layoutParams2.gravity = 16;
                layoutParams2.weight = 1.0f;
                addView(linearLayout);
                addView(this.f11770j);
            }
        } catch (Throwable th3) {
            o.d("AnyThinkSegmentsProgressBar", th3.getMessage());
        }
    }

    private LayerDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.f11765e);
        gradientDrawable.setColor(this.f11767g);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(this.f11765e);
        gradientDrawable2.setColor(this.f11768h);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ScaleDrawable(gradientDrawable2, 3, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    private static GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setDither(true);
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                gradientDrawable.setColors(new int[]{0, 1291845632});
            }
        } catch (Throwable unused) {
        }
        return gradientDrawable;
    }

    public void dismiss() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkSegmentsProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                AnyThinkSegmentsProgressBar.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(alphaAnimation);
    }

    public void init(int i2, int i3) {
        this.b = i2;
        this.f11763c = i3;
        a();
    }

    public void setIndicatorText(String str) {
        this.f11771k = str;
    }

    public void setProgress(int i2, int i3) {
        try {
            if (this.f11769i.size() == 0) {
                return;
            }
            if (i3 < this.f11769i.size()) {
                this.f11769i.get(i3).setProgress(i2);
            }
            int i4 = i3 + 1;
            if (i4 > this.f11766f) {
                this.f11766f = i4;
                if (this.f11770j != null) {
                    this.f11770j.setText(a(this.f11766f));
                }
            }
        } catch (Throwable th) {
            o.d("AnyThinkSegmentsProgressBar", th.getMessage());
        }
    }

    public void init(int i2, int i3, int i4, int i5) {
        this.b = i2;
        this.f11763c = i3;
        this.f11768h = i4;
        this.f11767g = i5;
        a();
    }

    public void init(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.b = i2;
        this.f11763c = i3;
        this.f11768h = i4;
        this.f11767g = i5;
        this.f11764d = i6;
        this.f11765e = i7;
        a();
    }

    public AnyThinkSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "AnyThinkSegmentsProgressBar";
        this.f11763c = 1;
        this.f11764d = 20;
        this.f11765e = 10;
        this.f11766f = 1;
        this.f11767g = -1711276033;
        this.f11768h = -1;
        this.f11769i = new ArrayList();
        this.f11772l = false;
    }

    public AnyThinkSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "AnyThinkSegmentsProgressBar";
        this.f11763c = 1;
        this.f11764d = 20;
        this.f11765e = 10;
        this.f11766f = 1;
        this.f11767g = -1711276033;
        this.f11768h = -1;
        this.f11769i = new ArrayList();
        this.f11772l = false;
    }

    @RequiresApi(api = 21)
    public AnyThinkSegmentsProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = "AnyThinkSegmentsProgressBar";
        this.f11763c = 1;
        this.f11764d = 20;
        this.f11765e = 10;
        this.f11766f = 1;
        this.f11767g = -1711276033;
        this.f11768h = -1;
        this.f11769i = new ArrayList();
        this.f11772l = false;
    }

    private StringBuilder a(int i2) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format(this.f11771k, Integer.valueOf(i2), Integer.valueOf(this.b)));
        } catch (Throwable th) {
            sb.append(this.b);
            sb.append("videos, the");
            sb.append(i2);
            sb.append(" is playing.");
            o.d("AnyThinkSegmentsProgressBar", th.getMessage());
        }
        return sb;
    }
}
