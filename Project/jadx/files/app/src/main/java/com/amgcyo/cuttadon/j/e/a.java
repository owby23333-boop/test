package com.amgcyo.cuttadon.j.e;

import android.view.View;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;
import java.util.Calendar;

/* JADX INFO: compiled from: AvoidDoubleClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f4081s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4082t;

    protected a(int i2) {
        this.f4082t = i2;
    }

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f4081s <= this.f4082t) {
            o.b(o.d(R.string.operating_busy));
        } else {
            this.f4081s = timeInMillis;
            a(view);
        }
    }
}
