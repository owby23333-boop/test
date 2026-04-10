package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;

/* JADX INFO: loaded from: classes4.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Ed = "%s秒后自动关闭";
    private TextView aiZ;
    private ImageView aja;
    private a ajb;
    private boolean ajc;
    private boolean ajd;
    private int countDown;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void eg();

        void eh();
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    public void setViewListener(a aVar) {
        this.ajb = aVar;
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.ajc = true;
        this.ajd = false;
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_auto_close, this);
        this.aiZ = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.aja = imageView;
        imageView.setOnClickListener(this);
    }

    public final void ai(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new bg() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (KsAutoCloseView.this.ajc) {
                    if (!KsAutoCloseView.this.ajd) {
                        if (KsAutoCloseView.this.countDown == 0) {
                            if (KsAutoCloseView.this.ajb != null) {
                                KsAutoCloseView.this.ajb.eg();
                                return;
                            }
                            return;
                        } else {
                            KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                            ksAutoCloseView.G(ksAutoCloseView.countDown);
                            KsAutoCloseView.e(KsAutoCloseView.this);
                            KsAutoCloseView.this.postDelayed(this, 1000L);
                            return;
                        }
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i) {
        this.aiZ.setText(String.format(Ed, Integer.valueOf(i)));
    }

    public void setCountDownPaused(boolean z) {
        this.ajd = z;
    }

    public final void bb(boolean z) {
        this.ajc = z;
        int i = z ? 0 : 8;
        TextView textView = this.aiZ;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajb != null && view.equals(this.aja)) {
            this.ajb.eh();
        }
    }
}
