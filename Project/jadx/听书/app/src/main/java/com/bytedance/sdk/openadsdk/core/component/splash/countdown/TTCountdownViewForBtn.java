package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class TTCountdownViewForBtn extends LinearLayout implements l.z, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f995a;
    private TextView dl;
    private int e;
    private boolean fo;
    private Context g;
    private z gc;
    private int gz;
    private AtomicBoolean m;
    protected final l z;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public View getView() {
        return this;
    }

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.m = new AtomicBoolean(true);
        this.z = new l(Looper.getMainLooper(), this);
        this.e = 5;
        this.gz = 1;
        this.fo = false;
        this.g = context;
        a();
    }

    private void a() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iDl = oq.dl(this.g, 14.0f);
        gradientDrawable.setCornerRadius(iDl);
        int i = iDl * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.dl = new TextView(this.g);
        int iDl2 = oq.dl(this.g, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.dl.setTextColor(-1);
        this.dl.setTextSize(2, 14.0f);
        addView(this.dl, layoutParams);
        View view = new View(this.g);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = oq.dl(this.g, 1.0f);
        layoutParams2.height = oq.dl(this.g, 12.0f);
        layoutParams2.leftMargin = iDl2;
        layoutParams2.rightMargin = iDl2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.f995a = new TextView(this.g);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.f995a.setTextColor(-1);
        this.f995a.setTextSize(2, 14.0f);
        this.f995a.setText("跳过");
        addView(this.f995a, layoutParams3);
    }

    private void gc() {
        l lVar = this.z;
        if (lVar != null) {
            lVar.removeMessages(1);
        }
        this.gz = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        gc();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.m.set(z);
        if (this.fo) {
            return;
        }
        if (!this.m.get()) {
            g();
        } else {
            dl();
        }
    }

    public void g() {
        try {
            l lVar = this.z;
            if (lVar != null) {
                lVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public void dl() {
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void z() {
        if (this.fo) {
            return;
        }
        gc();
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void z(boolean z) {
        this.fo = z;
        if (z) {
            gc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void setCountdownListener(z zVar) {
        this.gc = zVar;
        this.m.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void setCountDownTime(int i) {
        this.e = i;
        e();
        gc();
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 1) {
            m();
        }
    }

    private void m() {
        try {
            if (this.fo || this.dl == null) {
                return;
            }
            e();
            int i = this.gz;
            if (i >= this.e + 1) {
                z zVar = this.gc;
                if (zVar != null) {
                    zVar.z();
                    return;
                }
                return;
            }
            this.gz = i + 1;
            this.z.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void e() {
        if (this.dl != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.gz;
            int i2 = this.e;
            sb.append(i <= i2 ? i2 - i : 0).append("s");
            this.dl.setText(sb.toString());
        }
    }
}
