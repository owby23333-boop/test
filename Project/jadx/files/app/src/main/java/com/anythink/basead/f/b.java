package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.MraidBannerAdView;
import com.anythink.basead.ui.SdkBannerAdView;
import com.anythink.core.common.e.j;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    com.anythink.basead.e.a a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f6029k;

    public b(Context context, j jVar, String str, boolean z2) {
        super(context, jVar, str, z2);
        this.f6029k = b.class.getSimpleName();
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    public final View b() {
        if (a()) {
            return this.f6037g.g() ? new MraidBannerAdView(this.f6033c, this.f6034d, this.f6037g, this.a) : new SdkBannerAdView(this.f6033c, this.f6034d, this.f6037g, this.a);
        }
        return null;
    }

    @Override // com.anythink.basead.f.c
    public final void c() {
        this.a = null;
    }
}
