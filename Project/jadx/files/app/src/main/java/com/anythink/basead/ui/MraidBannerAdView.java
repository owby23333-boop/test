package com.anythink.basead.ui;

import android.content.Context;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* JADX INFO: loaded from: classes2.dex */
public class MraidBannerAdView extends BaseBannerAdView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    MraidContainerView f6219u;

    public MraidBannerAdView(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void o() {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.MraidBannerAdView.o():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    @Override // com.anythink.basead.ui.BaseAdView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a() {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.MraidBannerAdView.a():void");
    }

    @Override // com.anythink.basead.ui.BaseBannerAdView
    protected final void b() {
        if (this.f6219u == null) {
            return;
        }
        super.b();
    }

    @Override // com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.f6219u;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidBannerAdView$1, reason: invalid class name */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidBannerAdView.this.f6115d.v(str);
            MraidBannerAdView.this.b(1);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                MraidBannerAdView.this.b();
            } catch (Throwable unused) {
            }
        }
    }

    public MraidBannerAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        c();
    }
}
