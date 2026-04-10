package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends BaseAdapter {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f15323x = n.f().getMaximum(4);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Month f15324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final DateSelector<?> f15325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Collection<Long> f15326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    b f15327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final CalendarConstraints f15328w;

    h(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f15324s = month;
        this.f15325t = dateSelector;
        this.f15328w = calendarConstraints;
        this.f15326u = dateSelector.l();
    }

    public void a(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f15326u.iterator();
        while (it.hasNext()) {
            a(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f15325t;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.l().iterator();
            while (it2.hasNext()) {
                a(materialCalendarGridView, it2.next().longValue());
            }
            this.f15326u = this.f15325t.l();
        }
    }

    int b() {
        return (this.f15324s.a() + this.f15324s.f15281w) - 1;
    }

    boolean c(int i2) {
        return (i2 + 1) % this.f15324s.f15280v == 0;
    }

    int d(int i2) {
        return (i2 - this.f15324s.a()) + 1;
    }

    boolean e(int i2) {
        return i2 >= a() && i2 <= b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15324s.f15281w + a();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f15324s.f15280v;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean b(int i2) {
        return i2 % this.f15324s.f15280v == 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int i2) {
        if (i2 < this.f15324s.a() || i2 > b()) {
            return null;
        }
        return Long.valueOf(this.f15324s.a(d(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.a(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.f15324s
            int r2 = r8.f15281w
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.f15324s
            long r7 = r8.a(r7)
            com.google.android.material.datepicker.Month r3 = r5.f15324s
            int r3 = r3.f15279u
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.c()
            int r4 = r4.f15279u
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.d.c(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.d.e(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.a(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.h.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    private void a(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.b(j2).equals(this.f15324s)) {
            a((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f15324s.a(j2)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    private void a(@Nullable TextView textView, long j2) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f15328w.a().f(j2)) {
            textView.setEnabled(true);
            if (a(j2)) {
                aVar = this.f15327v.b;
            } else if (n.d().getTimeInMillis() == j2) {
                aVar = this.f15327v.f15300c;
            } else {
                aVar = this.f15327v.a;
            }
        } else {
            textView.setEnabled(false);
            aVar = this.f15327v.f15304g;
        }
        aVar.a(textView);
    }

    private boolean a(long j2) {
        Iterator<Long> it = this.f15325t.l().iterator();
        while (it.hasNext()) {
            if (n.a(j2) == n.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void a(Context context) {
        if (this.f15327v == null) {
            this.f15327v = new b(context);
        }
    }

    int a() {
        return this.f15324s.a();
    }

    int a(int i2) {
        return a() + (i2 - 1);
    }
}
