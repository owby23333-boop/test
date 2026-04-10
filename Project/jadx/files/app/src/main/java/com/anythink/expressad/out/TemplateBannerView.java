package com.anythink.expressad.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TemplateBannerView extends RelativeLayout implements com.anythink.core.common.a.g {
    private com.anythink.expressad.mbbanner.b.a a;
    private h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10889e;

    public TemplateBannerView(Context context) {
        this(context, null);
    }

    public String getRequestId() {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        return aVar != null ? aVar.a() : "";
    }

    public void init(i iVar, String str, String str2) {
        this.a = new com.anythink.expressad.mbbanner.b.a(this, iVar, str, str2);
        this.a.c(this.f10888d);
        this.a.b(this.f10887c);
    }

    @Override // com.anythink.core.common.a.g
    public boolean isReady() {
        return true;
    }

    public void load(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.b(this.f10887c);
            this.a.a(dVar);
        } else {
            h hVar = this.b;
            if (hVar != null) {
                hVar.a(com.anythink.expressad.mbbanner.a.a.a);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    public void onPause() {
        if (this.a == null || !TextUtils.isEmpty(this.f10889e)) {
            return;
        }
        this.a.c();
    }

    public void onResume() {
        if (this.a == null || !TextUtils.isEmpty(this.f10889e) || com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        this.a.d();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.f10888d = i2 == 0;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            if (i2 == 0) {
                a();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f10888d = i2 == 0;
        if (this.a != null) {
            if (i2 == 0) {
                a();
            } else {
                if (com.anythink.expressad.foundation.f.b.f10401c) {
                    return;
                }
                this.a.c(false);
            }
        }
    }

    public void release() {
        if (this.b != null) {
            this.b = null;
        }
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a((h) null);
            this.a.b();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z2) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public void setBannerAdListener(h hVar) {
        this.b = hVar;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void updateBannerSize(i iVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }

    public TemplateBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(boolean z2) {
        this.f10887c = z2;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.b(this.f10887c);
        }
    }

    public TemplateBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10887c = false;
        this.f10888d = false;
        com.anythink.expressad.foundation.b.a.b().b(context);
    }

    private void a() {
        postDelayed(new Runnable() { // from class: com.anythink.expressad.out.TemplateBannerView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (TemplateBannerView.this.a == null || com.anythink.expressad.foundation.f.b.f10401c) {
                    return;
                }
                TemplateBannerView.this.a.c(true);
            }
        }, 200L);
    }
}
