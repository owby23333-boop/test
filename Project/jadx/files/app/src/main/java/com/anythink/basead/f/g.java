package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.ui.AsseblemSplashAdView;
import com.anythink.basead.ui.BaseSdkSplashAdView;
import com.anythink.basead.ui.BaseSplashAdView;
import com.anythink.basead.ui.SinglePictureSplashAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends c {
    com.anythink.basead.e.a a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    BaseSplashAdView f6048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f6049l;

    public g(Context context, j jVar, String str) {
        super(context, jVar, str, false);
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final void a(final ViewGroup viewGroup) {
        n.a().a(new Runnable() { // from class: com.anythink.basead.f.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.this;
                if (BaseSdkSplashAdView.isSinglePicture(gVar.f6037g, gVar.f6034d.f7312m)) {
                    g gVar2 = g.this;
                    Context context = viewGroup.getContext();
                    g gVar3 = g.this;
                    gVar2.f6048k = new SinglePictureSplashAdView(context, gVar3.f6034d, gVar3.f6037g, gVar3.a);
                } else {
                    g gVar4 = g.this;
                    Context context2 = viewGroup.getContext();
                    g gVar5 = g.this;
                    gVar4.f6048k = new AsseblemSplashAdView(context2, gVar5.f6034d, gVar5.f6037g, gVar5.a);
                }
                g gVar6 = g.this;
                gVar6.f6048k.setDontCountDown(gVar6.f6049l);
                viewGroup.addView(g.this.f6048k);
            }
        });
    }

    public final void b() {
        this.f6049l = true;
    }

    public final void f() {
        this.a = null;
        BaseSplashAdView baseSplashAdView = this.f6048k;
        if (baseSplashAdView != null) {
            baseSplashAdView.destroy();
            this.f6048k = null;
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.f.c, com.anythink.basead.f.a
    public final boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6037g, this.f6034d, this.f6036f);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
