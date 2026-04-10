package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends RecyclerView.Adapter<b> {
    private final MaterialCalendar<?> a;

    /* JADX INFO: compiled from: YearGridAdapter.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f15336s;

        a(int i2) {
            this.f15336s = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.a.a(o.this.a.g().a(Month.a(this.f15336s, o.this.a.i().f15278t)));
            o.this.a.a(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* JADX INFO: compiled from: YearGridAdapter.java */
    public static class b extends RecyclerView.ViewHolder {
        final TextView a;

        b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    o(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    @NonNull
    private View.OnClickListener c(int i2) {
        return new a(i2);
    }

    int b(int i2) {
        return this.a.g().e().f15279u + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.g().f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        int iB = b(i2);
        String string = bVar.a.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        bVar.a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iB)));
        bVar.a.setContentDescription(String.format(string, Integer.valueOf(iB)));
        com.google.android.material.datepicker.b bVarH = this.a.h();
        Calendar calendarD = n.d();
        com.google.android.material.datepicker.a aVar = calendarD.get(1) == iB ? bVarH.f15303f : bVarH.f15301d;
        Iterator<Long> it = this.a.j().l().iterator();
        while (it.hasNext()) {
            calendarD.setTimeInMillis(it.next().longValue());
            if (calendarD.get(1) == iB) {
                aVar = bVarH.f15302e;
            }
        }
        aVar.a(bVar.a);
        bVar.a.setOnClickListener(c(iB));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    int a(int i2) {
        return i2 - this.a.g().e().f15279u;
    }
}
