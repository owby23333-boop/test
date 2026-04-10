package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    private a EI;
    private Runnable ET;
    private final b Ga;
    private View Gb;
    private TextView Gc;
    private TextView Gd;
    private int Ge;
    private boolean nV;
    private boolean sP;

    public interface a {
        void ac(int i2);

        void le();

        void lf();
    }

    static class b {
        private int EP;
        private String Gg;
        private String Gh;
        private int Gi;
        private boolean Gj;
        private boolean Gk;

        private b() {
            this.Gg = "跳过";
            this.Gh = "";
            this.Gi = 5;
            this.EP = this.Gi;
            this.Gj = true;
            this.Gk = true;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        static /* synthetic */ int d(b bVar) {
            int i2 = bVar.EP;
            bVar.EP = i2 - 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean lV() {
            return this.Gj && this.Gk;
        }

        public final void ad(String str) {
            this.EP = -1;
            this.Gh = str;
        }

        public final void ai(int i2) {
            this.Gi = i2;
            this.EP = i2;
        }

        public final String lT() {
            StringBuilder sb;
            int i2;
            int i3 = this.EP;
            if (i3 < 0) {
                return this.Gh;
            }
            if (i3 == 0) {
                sb = new StringBuilder();
                sb.append(this.Gh);
                i2 = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.Gh);
                i2 = this.EP;
            }
            sb.append(i2);
            return sb.toString();
        }

        public final boolean lU() {
            return this.EP <= 0;
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(Wrapper.wrapContextIfNeed(context), attributeSet, i2);
        this.Ga = new b((byte) 0);
        this.Ge = -1;
        this.nV = false;
        this.sP = true;
        this.ET = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.nV) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Ga);
                SkipView skipView2 = SkipView.this;
                skipView2.ab(skipView2.Ga.Gi - SkipView.this.Ga.EP);
                if (!SkipView.this.Ga.lU()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.Ga);
                } else if (SkipView.this.EI != null) {
                    SkipView.this.EI.lf();
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.Gc != null) {
            if (bVar.Gg != null) {
                this.Gc.setText(bVar.Gg);
            }
            this.Gc.setVisibility(this.Ga.Gj ? 0 : 8);
        }
        String strLT = bVar.lT();
        TextView textView = this.Gd;
        if (textView != null) {
            if (strLT != null) {
                textView.setText(strLT);
            }
            this.Gd.setVisibility(this.Ga.Gk ? 0 : 8);
        }
        if (this.Gb != null) {
            boolean zLV = this.Ga.lV();
            this.Gb.setVisibility(zLV ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!zLV) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i2 = this.Ge;
                if (i2 > 0) {
                    layoutParams.width = i2;
                    invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i2) {
        a aVar = this.EI;
        if (aVar != null) {
            aVar.ac(i2);
        }
    }

    private void fc() {
        a(this.Ga);
        post(this.ET);
    }

    private void fd() {
        this.nV = true;
    }

    private void fe() {
        this.nV = false;
    }

    private void init() {
        setOrientation(0);
        com.kwad.sdk.i.a.dv(getContext()).inflate(R.layout.ksad_skip_view, this);
        this.Gc = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.Gd = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.Gb = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.EI != null) {
                    SkipView.this.EI.le();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void lS() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    private void w(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.a.a.cd(adInfo));
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sP = com.kwad.sdk.core.response.a.a.cc(adInfo);
        setTimerPrefixText(com.kwad.components.ad.splashscreen.a.b.kV());
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            fc();
        }
        setSkipText(com.kwad.sdk.core.response.a.a.bN(adInfo));
        setVisibility(8);
        w(adInfo);
    }

    public final void ad(String str) {
        if (str == null) {
            return;
        }
        this.Ga.ad(str);
        a(this.Ga);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int af(int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bn() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Ge = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        this.EI = aVar;
    }

    public void setSkipBtnVisible(boolean z2) {
        this.Ga.Gj = z2;
        a(this.Ga);
    }

    public void setSkipText(String str) {
        this.Ga.Gg = str;
        a(this.Ga);
    }

    public void setTimerBtnVisible(boolean z2) {
        this.Ga.Gk = z2;
        a(this.Ga);
    }

    public void setTimerPrefixText(String str) {
        this.Ga.Gh = str;
        a(this.Ga);
    }

    public void setTimerSecond(int i2) {
        this.Ga.ai(i2);
        a(this.Ga);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void u(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            return;
        }
        fd();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void v(AdInfo adInfo) {
        if (this.sP) {
            lS();
        }
        if (com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            return;
        }
        fe();
    }
}
