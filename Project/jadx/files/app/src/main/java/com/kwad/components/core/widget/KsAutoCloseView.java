package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String AY = "%s秒后自动关闭";
    private TextView WE;
    private ImageView WF;
    private a WG;
    private boolean WH;
    private boolean WI;
    private int countDown;

    public interface a {
        void dO();

        void dP();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.WH = true;
        this.WI = false;
        N(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.WH = true;
        this.WI = false;
        N(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.countDown = 10;
        this.WH = true;
        this.WI = false;
        N(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.countDown = 10;
        this.WH = true;
        this.WI = false;
        N(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i2) {
        this.WE.setText(String.format(AY, Integer.valueOf(i2)));
    }

    private void N(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_auto_close, this);
        this.WE = (TextView) findViewById(R.id.ksad_auto_close_text);
        this.WF = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.WF.setOnClickListener(this);
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i2 = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i2 - 1;
        return i2;
    }

    public final void Y(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.countDown = i2;
        post(new Runnable() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (KsAutoCloseView.this.WH) {
                    if (!KsAutoCloseView.this.WI) {
                        if (KsAutoCloseView.this.countDown == 0) {
                            if (KsAutoCloseView.this.WG != null) {
                                KsAutoCloseView.this.WG.dO();
                                return;
                            }
                            return;
                        } else {
                            KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                            ksAutoCloseView.A(ksAutoCloseView.countDown);
                            KsAutoCloseView.e(KsAutoCloseView.this);
                        }
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public final void aP(boolean z2) {
        this.WH = z2;
        int i2 = this.WH ? 0 : 8;
        TextView textView = this.WE;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.WG != null && view.equals(this.WF)) {
            this.WG.dP();
        }
    }

    public void setCountDownPaused(boolean z2) {
        this.WI = z2;
    }

    public void setViewListener(a aVar) {
        this.WG = aVar;
    }
}
