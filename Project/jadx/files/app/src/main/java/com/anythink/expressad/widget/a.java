package com.anythink.expressad.widget;

import android.view.View;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12282d = 2000;
    private long a = 0;

    protected abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.a > com.anythink.expressad.exoplayer.i.a.f9492f) {
            this.a = timeInMillis;
            a(view);
        }
    }
}
