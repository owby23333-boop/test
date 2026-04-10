package com.tencent.smtt.sdk.ui.dialog.widget;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class b extends Button {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f19152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f19153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f19154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f19155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f19156i;

    public b(Context context, float f2, float f3, float f4, float f5, int i2) {
        super(context);
        this.f19154g = null;
        this.f19155h = null;
        this.f19156i = null;
        this.f19150c = f2;
        this.f19151d = f3;
        this.f19152e = f4;
        this.f19153f = f5;
        this.a = i2;
        this.b = Color.parseColor("#D0D0D0");
        a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, int i2, int i3) {
        float f2 = i2;
        this(context, f2, f2, f2, f2, i3);
    }

    public void a() {
        this.f19154g = new c(this.a, this.f19150c, this.f19151d, this.f19152e, this.f19153f);
        this.f19154g.a(getWidth(), getHeight());
        this.f19155h = new c(1342177280 | (this.a & ViewCompat.MEASURED_SIZE_MASK), this.f19150c, this.f19151d, this.f19152e, this.f19153f);
        this.f19155h.a(getWidth(), getHeight());
        this.f19156i = new c(this.b, this.f19150c, this.f19151d, this.f19152e, this.f19153f);
        this.f19156i.a(getWidth(), getHeight());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, -16842919}, this.f19154g);
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, this.f19155h);
        stateListDrawable.addState(new int[]{-16842910}, this.f19156i);
        setBackgroundDrawable(stateListDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        c cVar = this.f19154g;
        if (cVar != null) {
            cVar.a(i4 - i2, i5 - i3);
        }
        c cVar2 = this.f19155h;
        if (cVar2 != null) {
            cVar2.a(i4 - i2, i5 - i3);
        }
        c cVar3 = this.f19156i;
        if (cVar3 != null) {
            cVar3.a(i4 - i2, i5 - i3);
        }
    }
}
