package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends RecyclerView.Adapter<b> {
    private final Context a;

    @NonNull
    private final CalendarConstraints b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateSelector<?> f15329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MaterialCalendar.k f15330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15331e;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f15332s;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f15332s = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (this.f15332s.getAdapter().e(i2)) {
                i.this.f15330d.a(this.f15332s.getAdapter().getItem(i2).longValue());
            }
        }
    }

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.ViewHolder {
        final TextView a;
        final MaterialCalendarGridView b;

        b(@NonNull LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            this.a = (TextView) linearLayout.findViewById(R$id.month_title);
            ViewCompat.setAccessibilityHeading(this.a, true);
            this.b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z2) {
                return;
            }
            this.a.setVisibility(8);
        }
    }

    i(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.k kVar) {
        Month monthE = calendarConstraints.e();
        Month monthB = calendarConstraints.b();
        Month monthD = calendarConstraints.d();
        if (monthE.compareTo(monthD) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthD.compareTo(monthB) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int iA = h.f15323x * MaterialCalendar.a(context);
        int iA2 = MaterialDatePicker.f(context) ? MaterialCalendar.a(context) : 0;
        this.a = context;
        this.f15331e = iA + iA2;
        this.b = calendarConstraints;
        this.f15329c = dateSelector;
        this.f15330d = kVar;
        setHasStableIds(true);
    }

    @NonNull
    CharSequence b(int i2) {
        return a(i2).c(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.b.e().b(i2).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        Month monthB = this.b.e().b(i2);
        bVar.a.setText(monthB.c(bVar.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthB.equals(materialCalendarGridView.getAdapter().f15324s)) {
            h hVar = new h(monthB, this.f15329c, this.b);
            materialCalendarGridView.setNumColumns(monthB.f15280v);
            materialCalendarGridView.setAdapter((ListAdapter) hVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().a(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.f(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f15331e));
        return new b(linearLayout, true);
    }

    @NonNull
    Month a(int i2) {
        return this.b.e().b(i2);
    }

    int a(@NonNull Month month) {
        return this.b.e().b(month);
    }
}
