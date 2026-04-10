package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.b {
    private a JD;
    private Runnable JP;
    private final b Ls;
    private View Lt;
    private TextView Lu;
    private TextView Lv;
    private int Lw;
    private boolean qy;
    private boolean vX;

    public interface a {
        void am(int i);

        void me();

        void mf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i) {
        a aVar = this.JD;
        if (aVar != null) {
            aVar.am(i);
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.Ls = new b((byte) 0);
        this.Lw = -1;
        this.qy = false;
        this.vX = true;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.qy) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Ls);
                SkipView skipView2 = SkipView.this;
                skipView2.al(skipView2.Ls.LA - SkipView.this.Ls.JK);
                if (SkipView.this.Ls.nC()) {
                    if (SkipView.this.JD != null) {
                        SkipView.this.JD.mf();
                    }
                } else {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.Ls);
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
        m.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.Lu = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.Lv = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.Lt = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.JD != null) {
                    SkipView.this.JD.me();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.Lu != null) {
            if (bVar.Ly != null) {
                this.Lu.setText(bVar.Ly);
            }
            this.Lu.setVisibility(this.Ls.LB ? 0 : 8);
        }
        String strNB = bVar.nB();
        TextView textView = this.Lv;
        if (textView != null) {
            if (strNB != null) {
                textView.setText(strNB);
            }
            this.Lv.setVisibility(this.Ls.LC ? 0 : 8);
        }
        if (this.Lt != null) {
            boolean zND = this.Ls.nD();
            this.Lt.setVisibility(zND ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!zND) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.Lw;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        fP();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        if (this.vX) {
            nA();
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        fQ();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ao(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(a aVar) {
        this.JD = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.vX = com.kwad.sdk.core.response.b.a.cD(adInfo);
        setTimerPrefixText(e.a(com.kwad.components.ad.splashscreen.b.a.FN));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            au();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.cs(adInfo));
        setVisibility(8);
        C(adInfo);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cq() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cE(adInfo));
    }

    public void setSkipBtnVisible(boolean z) {
        this.Ls.LB = z;
        a(this.Ls);
    }

    public void setTimerBtnVisible(boolean z) {
        this.Ls.LC = z;
        a(this.Ls);
    }

    public void setTimerPrefixText(String str) {
        this.Ls.Lz = str;
        a(this.Ls);
    }

    public void setTimerSecond(int i) {
        this.Ls.ar(i);
        a(this.Ls);
    }

    public void setSkipText(String str) {
        this.Ls.Ly = str;
        a(this.Ls);
    }

    public final void ac(String str) {
        if (str == null) {
            return;
        }
        this.Ls.ac(str);
        a(this.Ls);
    }

    private void au() {
        a(this.Ls);
        post(this.JP);
    }

    private void nA() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    private void fP() {
        this.qy = true;
    }

    private void fQ() {
        this.qy = false;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Lw = layoutParams.width;
    }

    static class b {
        private int JK;
        private int LA;
        private boolean LB;
        private boolean LC;
        private String Ly;
        private String Lz;

        private b() {
            this.Ly = "跳过";
            this.Lz = "";
            this.LA = 5;
            this.JK = 5;
            this.LB = true;
            this.LC = true;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        static /* synthetic */ int d(b bVar) {
            int i = bVar.JK;
            bVar.JK = i - 1;
            return i;
        }

        public final String nB() {
            int i = this.JK;
            if (i < 0) {
                return this.Lz;
            }
            if (i == 0) {
                return this.Lz + 1;
            }
            return this.Lz + this.JK;
        }

        public final boolean nC() {
            return this.JK <= 0;
        }

        public final void ar(int i) {
            this.LA = i;
            this.JK = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean nD() {
            return this.LB && this.LC;
        }

        public final void ac(String str) {
            this.JK = -1;
            this.Lz = str;
        }
    }
}
