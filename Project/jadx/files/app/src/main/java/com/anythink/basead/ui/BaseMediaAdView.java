package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMediaAdView extends FrameLayout {
    protected i a;
    protected k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f6136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a f6137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f6138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected FrameLayout f6139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CloseImageView f6142i;

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseMediaAdView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar = BaseMediaAdView.this.f6137d;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
        }
    }

    public interface a {
        void onClickCloseView();
    }

    public BaseMediaAdView(Context context) {
        super(context);
        this.f6140g = 0;
        this.f6141h = 0;
    }

    private void a() {
        CloseImageView closeImageView = this.f6142i;
        if (closeImageView == null) {
            return;
        }
        if (this.f6138e) {
            closeImageView.setVisibility(0);
        } else {
            closeImageView.setVisibility(8);
        }
        a(this.f6142i, this.b.h());
        this.f6142i.setOnClickListener(new AnonymousClass1());
    }

    public void destroy() {
    }

    public List<View> getClickViews() {
        return new ArrayList();
    }

    public int getMediaViewHeight() {
        return this.f6141h;
    }

    public int getMediaViewWidth() {
        return this.f6140g;
    }

    public View getMonitorClickView() {
        return null;
    }

    public void init(int i2, int i3) {
        this.f6140g = i2;
        this.f6141h = i3;
        CloseImageView closeImageView = this.f6142i;
        if (closeImageView != null) {
            if (this.f6138e) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
            a(this.f6142i, this.b.h());
            this.f6142i.setOnClickListener(new AnonymousClass1());
        }
    }

    public void notifyClick() {
        k kVar;
        CloseImageView closeImageView = this.f6142i;
        if (closeImageView == null || (kVar = this.b) == null) {
            return;
        }
        a(closeImageView, kVar.g());
    }

    public BaseMediaAdView(Context context, i iVar, j jVar, boolean z2, a aVar) {
        super(context);
        this.f6140g = 0;
        this.f6141h = 0;
        this.a = iVar;
        this.b = jVar.f7312m;
        this.f6138e = z2;
        this.f6137d = aVar;
        this.f6136c = jVar;
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "base_myoffer_media_ad_view", "layout"), this);
        this.f6139f = (FrameLayout) findViewById(h.a(getContext(), "base_media_view_content", "id"));
        this.f6142i = (CloseImageView) findViewById(h.a(getContext(), "base_media_ad_close", "id"));
    }

    private static void a(com.anythink.basead.ui.a aVar, int i2) {
        if (aVar != null) {
            aVar.setClickAreaScaleFactor(i2 != 2 ? i2 != 3 ? i2 != 4 ? 1.0f : 0.5f : 0.75f : 1.5f);
        }
    }
}
