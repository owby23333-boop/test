package com.anythink.basead.ui;

import android.content.Context;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* JADX INFO: loaded from: classes2.dex */
public class MraidEndCardView extends BaseEndCardView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f6231g = MraidEndCardView.class.getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    MraidContainerView f6232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    a f6233f;

    public interface a {
        void a();

        void a(String str);

        void b();
    }

    public MraidEndCardView(Context context, i iVar, j jVar) {
        super(context, iVar, jVar);
        setBackgroundColor(-1);
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    protected final void a() {
        MraidContainerView mraidContainerView = this.f6232e;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public void init(boolean z2) {
        this.f6232e = new MraidContainerView(getContext(), this.b, this.f6133c, new MraidContainerView.a() { // from class: com.anythink.basead.ui.MraidEndCardView.1
            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a(String str) {
                a aVar = MraidEndCardView.this.f6233f;
                if (aVar != null) {
                    aVar.a(str);
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void b() {
                a aVar = MraidEndCardView.this.f6233f;
                if (aVar != null) {
                    aVar.b();
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a() {
                a aVar = MraidEndCardView.this.f6233f;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        addView(this.f6232e, new RelativeLayout.LayoutParams(-1, -1));
        this.f6232e.setNeedRegisterVolumeChangeReceiver(true);
        this.f6232e.init();
        if (z2) {
            this.f6232e.loadMraidWebView();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        MraidContainerView mraidContainerView = this.f6232e;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z2);
        }
    }

    public void setEndCardListener(a aVar) {
        this.f6233f = aVar;
    }
}
