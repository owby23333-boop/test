package com.amgcyo.cuttadon.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.read.page.l;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class AdFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Context f4324s;

    public AdFrameLayout(@NonNull Context context) {
        super(context);
        this.f4324s = context;
    }

    public /* synthetic */ void a(NormalAdParams normalAdParams) {
        com.amgcyo.cuttadon.h.h.b.a().a(this.f4324s, normalAdParams, this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void b(final NormalAdParams normalAdParams) {
        if (normalAdParams == null) {
            b();
            return;
        }
        if (this.f4324s == null) {
            b();
            return;
        }
        String adPosition = normalAdParams.getAdPosition();
        if (TextUtils.isEmpty(adPosition)) {
            b();
            return;
        }
        BaseAd baseAd = normalAdParams.getBaseAd();
        if (baseAd == null) {
            b();
            String str = adPosition + " 没有配置广告";
            return;
        }
        String platform = baseAd.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            b();
            String str2 = adPosition + " 配置广告的广告平台是空的";
            return;
        }
        if (com.amgcyo.cuttadon.h.a.d.a(baseAd)) {
            com.amgcyo.cuttadon.h.a.h.a(this.f4324s, adPosition, baseAd);
            return;
        }
        byte b = -1;
        switch (platform.hashCode()) {
            case -103418728:
                if (platform.equals("gdt_new")) {
                    b = 1;
                }
                break;
            case 3302:
                if (platform.equals("gm")) {
                    b = 3;
                }
                break;
            case 3432:
                if (platform.equals("ks")) {
                    b = 2;
                }
                break;
            case 3526476:
                if (platform.equals("self")) {
                    b = 5;
                }
                break;
            case 570658005:
                if (platform.equals("topon_new")) {
                    b = 4;
                }
                break;
            case 1061735899:
                if (platform.equals("csj_new")) {
                    b = 0;
                }
                break;
        }
        if (b == 0) {
            com.amgcyo.cuttadon.h.b.a.c().a(this.f4324s, normalAdParams, this);
            return;
        }
        if (b == 1) {
            com.amgcyo.cuttadon.h.c.b.c().a(this.f4324s, normalAdParams, this);
            return;
        }
        if (b == 2) {
            com.amgcyo.cuttadon.h.e.c.c().a(this.f4324s, normalAdParams, this);
            return;
        }
        if (b == 3) {
            com.amgcyo.cuttadon.h.d.b.a((Activity) this.f4324s, baseAd, normalAdParams, this);
            return;
        }
        if (b == 4) {
            com.amgcyo.cuttadon.h.i.b.a((Activity) this.f4324s, baseAd, normalAdParams, this);
        } else {
            if (b != 5) {
                return;
            }
            Context context = this.f4324s;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f4325s.a(normalAdParams);
                    }
                });
            }
        }
    }

    public void setDislikeImagview(final String str) {
        Context context = this.f4324s;
        if (context == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        int iA = n.a(12.0f);
        int iA2 = n.a(3.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.topMargin = iA2;
        layoutParams.rightMargin = iA2 * 2;
        layoutParams.gravity = 8388661;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.utils.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4327s.a(str, view);
            }
        });
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.dislike_icon);
        l.a(imageView);
        addView(imageView);
    }

    public /* synthetic */ void a() {
        setVisibility(8);
    }

    public AdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4324s = context;
    }

    public void a(String str, int i2) {
        Context context = this.f4324s;
        if (context != null && (context instanceof MkNovelBaseReaderActivity)) {
            removeAllViews();
            TextView textView = new TextView(this.f4324s);
            textView.setTextSize(10.0f);
            textView.setGravity(19);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            textView.setText("\u3000\u3000");
            textView.setTextColor(-7829368);
            textView.setBackgroundColor(0);
            l.a(textView);
            addView(textView);
        }
    }

    public AdFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4324s = context;
    }

    public /* synthetic */ void a(String str, View view) {
        com.amgcyo.cuttadon.h.a.c.a(str, 0L);
        removeAllViews();
    }

    private void b() {
        Context context = this.f4324s;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4329s.a();
                }
            });
        }
    }
}
