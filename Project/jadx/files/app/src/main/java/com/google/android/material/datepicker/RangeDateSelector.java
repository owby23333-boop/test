package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.internal.s;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f15284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private Long f15285t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private Long f15286u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Long f15287v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private Long f15288w = null;

    static class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f15285t = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f15286u = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    private boolean a(long j2, long j3) {
        return j2 <= j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void g(long j2) {
        Long l2 = this.f15285t;
        if (l2 == null) {
            this.f15285t = Long.valueOf(j2);
        } else if (this.f15286u == null && a(l2.longValue(), j2)) {
            this.f15286u = Long.valueOf(j2);
        } else {
            this.f15286u = null;
            this.f15285t = Long.valueOf(j2);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> j() {
        if (this.f15285t == null || this.f15286u == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f15285t, this.f15286u));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean k() {
        Long l2 = this.f15285t;
        return (l2 == null || this.f15286u == null || !a(l2.longValue(), this.f15286u.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> l() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f15285t;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.f15286u;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.f15285t);
        parcel.writeValue(this.f15286u);
    }

    class a extends com.google.android.material.datepicker.c {
        final /* synthetic */ j A;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f15289y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f15290z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, j jVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f15289y = textInputLayout2;
            this.f15290z = textInputLayout3;
            this.A = jVar;
        }

        @Override // com.google.android.material.datepicker.c
        void a(@Nullable Long l2) {
            RangeDateSelector.this.f15287v = l2;
            RangeDateSelector.this.a(this.f15289y, this.f15290z, this.A);
        }

        @Override // com.google.android.material.datepicker.c
        void a() {
            RangeDateSelector.this.f15287v = null;
            RangeDateSelector.this.a(this.f15289y, this.f15290z, this.A);
        }
    }

    class b extends com.google.android.material.datepicker.c {
        final /* synthetic */ j A;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f15291y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f15292z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, j jVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f15291y = textInputLayout2;
            this.f15292z = textInputLayout3;
            this.A = jVar;
        }

        @Override // com.google.android.material.datepicker.c
        void a(@Nullable Long l2) {
            RangeDateSelector.this.f15288w = l2;
            RangeDateSelector.this.a(this.f15291y, this.f15292z, this.A);
        }

        @Override // com.google.android.material.datepicker.c
        void a() {
            RangeDateSelector.this.f15288w = null;
            RangeDateSelector.this.a(this.f15291y, this.f15292z, this.A);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String b(@NonNull Context context) {
        Resources resources = context.getResources();
        if (this.f15285t == null && this.f15286u == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l2 = this.f15286u;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, d.a(this.f15285t.longValue()));
        }
        Long l3 = this.f15285t;
        if (l3 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, d.a(l2.longValue()));
        }
        Pair<String, String> pairA = d.a(l3, l2);
        return resources.getString(R$string.mtrl_picker_range_header_selected, pairA.first, pairA.second);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> m() {
        return new Pair<>(this.f15285t, this.f15286u);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int a(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return com.google.android.material.i.b.a(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull j<Pair<Long, Long>> jVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.d.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f15284s = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatA = n.a();
        Long l2 = this.f15285t;
        if (l2 != null) {
            editText.setText(simpleDateFormatA.format(l2));
            this.f15287v = this.f15285t;
        }
        Long l3 = this.f15286u;
        if (l3 != null) {
            editText2.setText(simpleDateFormatA.format(l3));
            this.f15288w = this.f15286u;
        }
        String strA = n.a(viewInflate.getResources(), simpleDateFormatA);
        textInputLayout.setPlaceholderText(strA);
        textInputLayout2.setPlaceholderText(strA);
        editText.addTextChangedListener(new a(strA, simpleDateFormatA, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, jVar));
        editText2.addTextChangedListener(new b(strA, simpleDateFormatA, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, jVar));
        s.g(editText);
        return viewInflate;
    }

    private void b(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f15284s);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull j<Pair<Long, Long>> jVar) {
        Long l2 = this.f15287v;
        if (l2 != null && this.f15288w != null) {
            if (a(l2.longValue(), this.f15288w.longValue())) {
                this.f15285t = this.f15287v;
                this.f15286u = this.f15288w;
                jVar.a(m());
                return;
            } else {
                b(textInputLayout, textInputLayout2);
                jVar.a();
                return;
            }
        }
        a(textInputLayout, textInputLayout2);
        jVar.a();
    }

    private void a(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f15284s.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }
}
