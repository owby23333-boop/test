package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final d f15241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final List<CalendarConstraints.DateValidator> f15242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final d f15239u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final d f15240v = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    static class a implements d {
        a() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.f(j2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    static class b implements d {
        b() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.f(j2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    static class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i2 = parcel.readInt();
            d dVar = (i2 != 2 && i2 == 1) ? CompositeDateValidator.f15239u : CompositeDateValidator.f15240v;
            return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), dVar, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    }

    private interface d {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2);

        int getId();
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f15242t.equals(compositeDateValidator.f15242t) && this.f15241s.getId() == compositeDateValidator.f15241s.getId();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean f(long j2) {
        return this.f15241s.a(this.f15242t, j2);
    }

    public int hashCode() {
        return this.f15242t.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeList(this.f15242t);
        parcel.writeInt(this.f15241s.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f15242t = list;
        this.f15241s = dVar;
    }
}
