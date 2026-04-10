package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends BaseAdapter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f15316v;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final Calendar f15317s = n.f();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f15318t = this.f15317s.getMaximum(7);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f15319u = this.f15317s.getFirstDayOfWeek();

    static {
        f15316v = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    private int a(int i2) {
        int i3 = i2 + this.f15319u;
        int i4 = this.f15318t;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f15318t;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f15317s.set(7, a(i2));
        textView.setText(this.f15317s.getDisplayName(7, f15316v, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f15317s.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Integer getItem(int i2) {
        if (i2 >= this.f15318t) {
            return null;
        }
        return Integer.valueOf(a(i2));
    }
}
