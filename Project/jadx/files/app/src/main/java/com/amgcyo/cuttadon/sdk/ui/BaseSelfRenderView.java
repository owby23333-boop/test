package com.amgcyo.cuttadon.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSelfRenderView extends FrameLayout {
    public BaseSelfRenderView(@NonNull Context context) {
        super(context);
    }

    public abstract void a();

    protected void a(ImageView imageView, int i2, Context context) {
        if (imageView == null || context == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = -2;
        imageView.setLayoutParams(layoutParams);
        imageView.setMaxHeight(com.amgcyo.cuttadon.utils.otherutils.n.a(context) / i2);
    }

    public /* synthetic */ void b() {
        int height = getHeight();
        String str = "post控件高度：" + height;
        g0.a().b("kloiejf", height);
    }

    protected void getViewHeight() {
        post(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f4305s.b();
            }
        });
    }

    protected void setAdLogoStatus(SelfAdLogoFrameLayout selfAdLogoFrameLayout) {
        if (selfAdLogoFrameLayout != null) {
            selfAdLogoFrameLayout.a();
        }
    }

    public BaseSelfRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseSelfRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    protected void a(Context context, NewApiAd newApiAd) {
        com.amgcyo.cuttadon.h.h.c.a(context, "OWNADSHOW", newApiAd, newApiAd.getLocation(), newApiAd.getOwnerType());
    }
}
