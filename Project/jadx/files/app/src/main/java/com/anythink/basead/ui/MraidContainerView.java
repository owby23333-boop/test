package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.d;
import com.anythink.basead.ui.ClickToReLoadView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MraidContainerView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f6220h = MraidContainerView.class.getSimpleName();
    protected i a;
    protected k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f6221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f6222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ClickToReLoadView f6223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected MraidWebView f6224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected a f6225g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6229l;

    public interface a {
        void a();

        void a(String str);

        void b();
    }

    public MraidContainerView(@NonNull Context context) {
        super(context);
    }

    private void e() {
        b bVar = this.f6222d;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        b bVar = this.f6222d;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void g() {
        if (this.b.V()) {
            return;
        }
        loadMraidWebView();
    }

    public void fireAudioVolumeChange(boolean z2) {
        try {
            if (!this.f6229l || this.f6224f == null) {
                return;
            }
            if (z2) {
                CallMraidJS.getInstance().fireAudioVolumeChange(this.f6224f, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            } else {
                CallMraidJS.getInstance().fireAudioVolumeChange(this.f6224f, 1.0d);
            }
        } catch (Exception unused) {
        }
    }

    public void fireMraidIsViewable(boolean z2) {
        try {
            if (!this.f6229l || this.f6224f == null) {
                return;
            }
            if (z2) {
                com.anythink.expressad.mbbanner.a.a.a.a(this.f6224f, true);
            } else {
                com.anythink.expressad.mbbanner.a.a.a.a(this.f6224f, false);
            }
        } catch (Throwable unused) {
        }
    }

    public void init() {
        if (this.b.V()) {
            b();
        } else {
            this.f6222d = new b(this);
            this.f6222d.a();
        }
    }

    public void loadMraidWebView() {
        if (this.f6228k || this.f6229l) {
            return;
        }
        this.f6228k = true;
        ClickToReLoadView clickToReLoadView = this.f6223e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
        b bVar = this.f6222d;
        if (bVar != null) {
            bVar.b();
        }
        final String strA = com.anythink.basead.mraid.d.a(this.f6221c, this.a);
        if (!TextUtils.isEmpty(strA)) {
            final String strA2 = com.anythink.basead.a.b.c.a(this.f6221c, this.a);
            n.a().a(new Runnable() { // from class: com.anythink.basead.ui.MraidContainerView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MraidContainerView.this.f6224f = new MraidWebView(n.a().g());
                    com.anythink.basead.mraid.d.a(strA2, strA, MraidContainerView.this.f6224f, new d.a() { // from class: com.anythink.basead.ui.MraidContainerView.2.1
                        @Override // com.anythink.basead.mraid.d.a
                        public final void a() {
                            String unused = MraidContainerView.f6220h;
                            MraidContainerView.a(MraidContainerView.this);
                            MraidContainerView.this.b();
                            MraidContainerView.this.f();
                        }

                        @Override // com.anythink.basead.mraid.d.a
                        public final void a(com.anythink.basead.c.e eVar) {
                            MraidContainerView.a(MraidContainerView.this);
                            String unused = MraidContainerView.f6220h;
                            new StringBuilder("onFailed: ").append(eVar.c());
                            MraidContainerView.this.c();
                            MraidContainerView.this.f();
                        }
                    });
                }
            });
        } else {
            this.f6228k = false;
            c();
            f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6226i = true;
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6226i = false;
    }

    public void release() {
        try {
            if (this.f6229l && this.f6224f != null) {
                u.a(this.f6224f);
                this.f6224f.release();
                com.anythink.core.common.res.d.a(n.a().g()).a(this.f6221c, this.a);
            }
            u.a(this);
        } catch (Throwable unused) {
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z2) {
        this.f6227j = z2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (this.f6226i) {
            g();
        }
    }

    public MraidContainerView(@NonNull Context context, i iVar, j jVar, a aVar) {
        super(context);
        this.a = iVar;
        this.b = jVar.f7312m;
        this.f6221c = jVar;
        this.f6225g = aVar;
        setBackgroundColor(getResources().getColor(h.a(context, "color_99000000", com.anythink.expressad.foundation.h.i.f10646d)));
    }

    static /* synthetic */ boolean a(MraidContainerView mraidContainerView) {
        mraidContainerView.f6228k = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f6224f = com.anythink.basead.a.b.c.b(com.anythink.basead.a.b.c.a(this.f6221c, this.a));
        MraidWebView mraidWebView = this.f6224f;
        if (mraidWebView != null) {
            this.f6229l = true;
            if (this.f6227j) {
                mraidWebView.setNeedRegisterVolumeChangeReceiver(true);
            }
            this.f6224f.prepare(getContext(), new com.anythink.basead.mraid.b() { // from class: com.anythink.basead.ui.MraidContainerView.1
                @Override // com.anythink.basead.mraid.b
                public final void a() {
                    a aVar = MraidContainerView.this.f6225g;
                    if (aVar != null) {
                        aVar.b();
                    }
                }

                @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
                public final void close() {
                }

                @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
                public final void open(String str) {
                    a aVar = MraidContainerView.this.f6225g;
                    if (aVar != null) {
                        aVar.a(str);
                    }
                }
            });
            addView(this.f6224f, new FrameLayout.LayoutParams(-1, -1));
            a aVar = this.f6225g;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f6223e == null) {
            this.f6223e = new ClickToReLoadView(getContext());
            this.f6223e.setListener(new ClickToReLoadView.a() { // from class: com.anythink.basead.ui.MraidContainerView.3
                @Override // com.anythink.basead.ui.ClickToReLoadView.a
                public final void a() {
                    MraidContainerView.this.loadMraidWebView();
                }
            });
        }
        addView(this.f6223e, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        ClickToReLoadView clickToReLoadView = this.f6223e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
    }
}
