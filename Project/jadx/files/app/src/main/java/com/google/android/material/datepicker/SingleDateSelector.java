package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R$attr;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Long f15293s;

    static class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f15293s = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String b(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f15293s;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, d.d(l2.longValue()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void g(long j2) {
        this.f15293s = Long.valueOf(j2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> j() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean k() {
        return this.f15293s != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> l() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f15293s;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.f15293s);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long m() {
        return this.f15293s;
    }

    class a extends c {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ j f15294y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, j jVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f15294y = jVar;
        }

        @Override // com.google.android.material.datepicker.c
        void a(@Nullable Long l2) {
            if (l2 == null) {
                SingleDateSelector.this.a();
            } else {
                SingleDateSelector.this.g(l2.longValue());
            }
            this.f15294y.a(SingleDateSelector.this.m());
        }

        @Override // com.google.android.material.datepicker.c
        void a() {
            this.f15294y.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f15293s = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull j<Long> jVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.d.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatA = n.a();
        String strA = n.a(viewInflate.getResources(), simpleDateFormatA);
        textInputLayout.setPlaceholderText(strA);
        Long l2 = this.f15293s;
        if (l2 != null) {
            editText.setText(simpleDateFormatA.format(l2));
        }
        editText.addTextChangedListener(new a(strA, simpleDateFormatA, textInputLayout, calendarConstraints, jVar));
        s.g(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int a(Context context) {
        return com.google.android.material.i.b.a(context, R$attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }
}
