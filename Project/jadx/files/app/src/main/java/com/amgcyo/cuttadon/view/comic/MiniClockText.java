package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class MiniClockText extends AppCompatTextView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final CharSequence f4468v = "HH:mm";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Calendar f4469s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4470t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f4471u;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MiniClockText.this.f4469s.setTimeInMillis(System.currentTimeMillis());
            MiniClockText miniClockText = MiniClockText.this;
            miniClockText.setText(DateFormat.format(MiniClockText.f4468v, miniClockText.f4469s));
            long jUptimeMillis = SystemClock.uptimeMillis();
            MiniClockText.this.getHandler().postAtTime(MiniClockText.this.f4471u, jUptimeMillis + (1000 - (jUptimeMillis % 1000)));
        }
    }

    public MiniClockText(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4470t) {
            return;
        }
        this.f4470t = true;
        this.f4471u.run();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4470t) {
            getHandler().removeCallbacks(this.f4471u);
            this.f4470t = false;
        }
    }

    public MiniClockText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        if (this.f4469s == null) {
            this.f4469s = Calendar.getInstance();
        }
    }

    public MiniClockText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4470t = false;
        this.f4471u = new a();
        a();
    }
}
