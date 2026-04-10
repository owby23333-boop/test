package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseBannerAdView extends BaseAdView {
    public final String TAG;
    protected com.anythink.basead.e.a a;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected CloseImageView f6132t;

    public BaseBannerAdView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    protected void b() {
        a(this.f6114c.f7312m.R() < 0 ? 100 : this.f6114c.f7312m.R(), new Runnable() { // from class: com.anythink.basead.ui.BaseBannerAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseBannerAdView.super.h();
            }
        });
    }

    protected void c() {
        this.f6132t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseBannerAdView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.anythink.basead.e.a aVar = BaseBannerAdView.this.a;
                if (aVar != null) {
                    aVar.onAdClosed();
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        com.anythink.basead.a.b.a(8, this.f6115d, i());
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(int i2) {
        a(this.f6132t, this.f6114c.f7312m.g());
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdClick(i2);
        }
    }

    public BaseBannerAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar);
        this.TAG = getClass().getSimpleName();
        this.a = aVar;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z2) {
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z2);
        }
    }
}
