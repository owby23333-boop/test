package com.amgcyo.cuttadon.k.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.bumptech.glide.request.l.d;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: compiled from: SplashView.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends FrameLayout {
    private GradientDrawable A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ImageView f4123s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ImageView f4124t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    TextView f4125u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer f4126v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Activity f4127w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private InterfaceC0109c f4128x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Handler f4129y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Runnable f4130z;

    /* JADX INFO: compiled from: SplashView.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f4126v.intValue() == 0) {
                c.this.a(false);
                return;
            }
            c cVar = c.this;
            Integer numValueOf = Integer.valueOf(cVar.f4126v.intValue() - 1);
            cVar.f4126v = numValueOf;
            cVar.setDuration(numValueOf);
            c.this.f4129y.postDelayed(c.this.f4130z, 1000L);
        }
    }

    /* JADX INFO: compiled from: SplashView.java */
    class b extends com.bumptech.glide.request.k.c<Drawable> {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ int f4132v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ boolean f4133w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Activity f4134x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4135y;

        b(int i2, boolean z2, Activity activity, NewApiAd newApiAd) {
            this.f4132v = i2;
            this.f4133w = z2;
            this.f4134x = activity;
            this.f4135y = newApiAd;
        }

        @Override // com.bumptech.glide.request.k.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, d dVar) {
            a((Drawable) obj, (d<? super Drawable>) dVar);
        }

        @Override // com.bumptech.glide.request.k.j
        public void b(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.k.c, com.bumptech.glide.request.k.j
        public void c(@Nullable Drawable drawable) {
            super.c(drawable);
            if (c.this.f4128x != null) {
                c.this.f4128x.onSplashViewDismiss(true);
            }
        }

        public void a(@NonNull Drawable drawable, d<? super Drawable> dVar) {
            c cVar = c.this;
            if (cVar.f4123s == null || cVar.f4129y == null) {
                return;
            }
            c.this.b();
            c.this.f4129y.post(c.this.f4130z);
            if (drawable instanceof com.bumptech.glide.load.k.g.c) {
                com.bumptech.glide.load.k.g.c cVar2 = (com.bumptech.glide.load.k.g.c) drawable;
                cVar2.a(this.f4132v);
                c.this.f4123s.setImageDrawable(drawable);
                cVar2.start();
            } else {
                c.this.f4123s.setImageDrawable(drawable);
            }
            com.amgcyo.cuttadon.h.h.c.a(this.f4134x, "OWNADSHOW", this.f4135y, !this.f4133w ? "唤醒" : "闪屏", !this.f4133w ? "唤醒ssp" : "闪屏ssp");
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.k.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SplashView.java */
    public interface InterfaceC0109c {
        void onSplashImageClick(NewApiAd newApiAd);

        void onSplashViewDismiss(boolean z2);
    }

    public c(Activity activity) {
        super(activity);
        this.f4126v = 5;
        this.f4127w = null;
        this.f4128x = null;
        this.f4129y = new Handler();
        this.f4130z = new a();
        this.A = new GradientDrawable();
        this.f4127w = activity;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(Integer num) {
        this.f4126v = num;
        this.f4125u.setText(String.format(Locale.CHINA, "跳过\n%d s", num));
    }

    private void setImage(Bitmap bitmap) {
        this.f4123s.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ImageView imageView = this.f4123s;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f4124t.setVisibility(0);
            this.f4125u.setVisibility(0);
        }
    }

    void a() {
        this.f4123s = new ImageView(this.f4127w);
        this.f4123s.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f4123s.setLayoutParams(layoutParams);
        this.f4123s.setVisibility(8);
        addView(this.f4123s, layoutParams);
        this.f4123s.setClickable(true);
        this.f4124t = new ImageView(this.f4127w);
        this.f4124t.setImageResource(R.drawable.ad_logos);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 83;
        this.f4124t.setVisibility(8);
        this.f4124t.setLayoutParams(layoutParams2);
        addView(this.f4124t, layoutParams2);
        this.A.setShape(1);
        this.A.setColor(Color.parseColor("#66333333"));
        this.f4125u = new TextView(this.f4127w);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 44.0f, this.f4127w.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams3.gravity = 53;
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 16.0f, this.f4127w.getResources().getDisplayMetrics());
        layoutParams3.setMargins(0, iApplyDimension2, iApplyDimension2, 0);
        this.f4125u.setGravity(17);
        this.f4125u.setTextColor(this.f4127w.getResources().getColor(android.R.color.white));
        this.f4125u.setBackground(this.A);
        this.f4125u.setTextSize(1, 12.0f);
        this.f4125u.setVisibility(8);
        addView(this.f4125u, layoutParams3);
        this.f4125u.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.k.b.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4119s.a(view);
            }
        });
        setDuration(this.f4126v);
    }

    public /* synthetic */ void a(View view) {
        a(true);
    }

    public void a(@NonNull Activity activity, int i2, @Nullable final NewApiAd newApiAd, @NonNull final InterfaceC0109c interfaceC0109c, boolean z2) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (viewGroup != null && viewGroup.getChildCount() != 0 && newApiAd != null) {
            c cVar = new c(activity);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            cVar.setDuration(Integer.valueOf(i2));
            this.f4128x = interfaceC0109c;
            this.f4123s.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.k.b.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4120s.a(interfaceC0109c, newApiAd, view);
                }
            });
            String image = newApiAd.getImage();
            if (!TextUtils.isEmpty(image)) {
                com.bumptech.glide.c.a(this).mo58load(image).into(new b(i2, z2, activity, newApiAd));
            }
            viewGroup.addView(cVar, layoutParams);
            return;
        }
        throw new IllegalStateException("You should call showSplashView() after setContentView() in Activity instance or data must not null");
    }

    public /* synthetic */ void a(InterfaceC0109c interfaceC0109c, NewApiAd newApiAd, View view) {
        this.f4129y.removeCallbacks(this.f4130z);
        interfaceC0109c.onSplashImageClick(newApiAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        InterfaceC0109c interfaceC0109c = this.f4128x;
        if (interfaceC0109c != null) {
            interfaceC0109c.onSplashViewDismiss(z2);
        }
        this.f4129y.removeCallbacks(this.f4130z);
    }
}
