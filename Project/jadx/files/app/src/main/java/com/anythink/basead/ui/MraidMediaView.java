package com.anythink.basead.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* JADX INFO: loaded from: classes2.dex */
public class MraidMediaView extends BaseMediaAdView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MraidContainerView f6234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f6235h;

    public interface a {
        void a();

        void a(String str);
    }

    public MraidMediaView(Context context) {
        this(context, null, null, false, null);
    }

    private static void a(String str) {
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.f6234g;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public void fireAudioVolumeChange(boolean z2) {
        MraidContainerView mraidContainerView = this.f6234g;
        if (mraidContainerView != null) {
            mraidContainerView.fireAudioVolumeChange(z2);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void init(int i2, int i3) {
        super.init(i2, i3);
        this.f6234g = new MraidContainerView(getContext(), this.a, this.f6136c, new AnonymousClass1());
        this.f6234g.init();
        FrameLayout frameLayout = this.f6139f;
        if (frameLayout == null || this.f6234g == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.f6139f.addView(this.f6234g, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        MraidContainerView mraidContainerView = this.f6234g;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z2);
        }
    }

    public void setMraidWebViewListener(a aVar) {
        this.f6235h = aVar;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidMediaView$1, reason: invalid class name */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            if (MraidMediaView.this.f6235h != null) {
                MraidMediaView.this.f6235h.a(str);
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            if (MraidMediaView.this.f6235h != null) {
                MraidMediaView.this.f6235h.a();
            }
        }
    }

    public MraidMediaView(Context context, i iVar, j jVar, boolean z2, BaseMediaAdView.a aVar) {
        super(context, iVar, jVar, z2, aVar);
    }

    private void a() {
        this.f6234g = new MraidContainerView(getContext(), this.a, this.f6136c, new AnonymousClass1());
        this.f6234g.init();
        FrameLayout frameLayout = this.f6139f;
        if (frameLayout == null || this.f6234g == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.f6139f.addView(this.f6234g, new ViewGroup.LayoutParams(-1, -1));
    }
}
