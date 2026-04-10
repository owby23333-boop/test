package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class c extends com.google.android.material.internal.k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f15306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DateFormat f15307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final CalendarConstraints f15308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f15309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f15310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Runnable f15311x;

    /* JADX INFO: compiled from: DateFormatTextWatcher.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f15312s;

        a(String str) {
            this.f15312s = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = c.this.f15306s;
            DateFormat dateFormat = c.this.f15307t;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.f15312s) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(n.d().getTimeInMillis()))));
            c.this.a();
        }
    }

    /* JADX INFO: compiled from: DateFormatTextWatcher.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ long f15314s;

        b(long j2) {
            this.f15314s = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f15306s.setError(String.format(c.this.f15309v, d.a(this.f15314s)));
            c.this.a();
        }
    }

    c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f15307t = dateFormat;
        this.f15306s = textInputLayout;
        this.f15308u = calendarConstraints;
        this.f15309v = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f15310w = new a(str);
    }

    abstract void a();

    abstract void a(@Nullable Long l2);

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        this.f15306s.removeCallbacks(this.f15310w);
        this.f15306s.removeCallbacks(this.f15311x);
        this.f15306s.setError(null);
        a((Long) null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f15307t.parse(charSequence.toString());
            this.f15306s.setError(null);
            long time = date.getTime();
            if (this.f15308u.a().f(time) && this.f15308u.a(time)) {
                a(Long.valueOf(date.getTime()));
            } else {
                this.f15311x = a(time);
                a(this.f15306s, this.f15311x);
            }
        } catch (ParseException unused) {
            a(this.f15306s, this.f15310w);
        }
    }

    private Runnable a(long j2) {
        return new b(j2);
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }
}
