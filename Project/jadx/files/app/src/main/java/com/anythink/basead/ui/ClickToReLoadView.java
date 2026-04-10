package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class ClickToReLoadView extends LinearLayout {
    private ImageView a;
    private TextView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6164d;

    /* JADX INFO: renamed from: com.anythink.basead.ui.ClickToReLoadView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        long a;

        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.a > 1000) {
                this.a = jCurrentTimeMillis;
                if (ClickToReLoadView.this.f6163c != null) {
                    ClickToReLoadView.this.f6163c.a();
                }
            }
        }
    }

    public interface a {
        void a();
    }

    public ClickToReLoadView(Context context) {
        super(context);
        setOrientation(1);
        setGravity(17);
        this.f6164d = h.a(context, 10.0f);
        this.a = new ImageView(context);
        this.a.setImageResource(h.a(context, "myoffer_webview_reload_icon", i.f10645c));
        int iA = h.a(context, 30.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.f6164d;
        this.b = new TextView(context);
        this.b.setText(getResources().getText(h.a(context, "myoffer_webview_reload", i.f10649g)));
        this.b.setTextColor(getResources().getColor(h.a(context, "color_reload_button", i.f10646d)));
        this.b.setBackgroundResource(h.a(context, "myoffer_webview_bg_reload_button", i.f10645c));
        int iA2 = h.a(context, 9.0f);
        int iA3 = h.a(context, 5.0f);
        this.b.setPadding(iA2, iA3, iA2, iA3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.f6164d;
        addView(this.a, layoutParams);
        addView(this.b, layoutParams2);
        this.b.setOnClickListener(new AnonymousClass1());
    }

    private void b() {
        try {
            this.a.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
                this.b.setLayoutParams(layoutParams);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (getHeight() < h.a(getContext(), 100.0f)) {
            try {
                this.a.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                    this.b.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void setListener(a aVar) {
        this.f6163c = aVar;
    }

    private void a(Context context) {
        setOrientation(1);
        setGravity(17);
        this.f6164d = h.a(context, 10.0f);
        this.a = new ImageView(context);
        this.a.setImageResource(h.a(context, "myoffer_webview_reload_icon", i.f10645c));
        int iA = h.a(context, 30.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.f6164d;
        this.b = new TextView(context);
        this.b.setText(getResources().getText(h.a(context, "myoffer_webview_reload", i.f10649g)));
        this.b.setTextColor(getResources().getColor(h.a(context, "color_reload_button", i.f10646d)));
        this.b.setBackgroundResource(h.a(context, "myoffer_webview_bg_reload_button", i.f10645c));
        int iA2 = h.a(context, 9.0f);
        int iA3 = h.a(context, 5.0f);
        this.b.setPadding(iA2, iA3, iA2, iA3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.f6164d;
        addView(this.a, layoutParams);
        addView(this.b, layoutParams2);
    }

    private void a() {
        this.b.setOnClickListener(new AnonymousClass1());
    }
}
