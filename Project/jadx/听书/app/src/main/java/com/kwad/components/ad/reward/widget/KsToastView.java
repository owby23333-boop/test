package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class KsToastView extends LinearLayout {
    TextView Ec;
    private String Ed;
    private Runnable Ee;
    private int countDown;

    static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    public KsToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    public KsToastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.Ed = "%ss后自动进入";
        this.Ee = null;
        init(context);
    }

    private void init(Context context) {
        m.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.Ec = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public final void ai(int i) {
        if (this.Ee == null) {
            this.Ee = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.G(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.Ee);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i) {
        this.Ec.setText(String.format(this.Ed, Integer.valueOf(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Ee);
    }
}
