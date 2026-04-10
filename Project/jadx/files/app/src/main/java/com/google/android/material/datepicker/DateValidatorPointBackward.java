package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f15243s;

    static class a implements Parcelable.Creator<DateValidatorPointBackward> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointBackward[] newArray(int i2) {
            return new DateValidatorPointBackward[i2];
        }
    }

    /* synthetic */ DateValidatorPointBackward(long j2, a aVar) {
        this(j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f15243s == ((DateValidatorPointBackward) obj).f15243s;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean f(long j2) {
        return j2 <= this.f15243s;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f15243s)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.f15243s);
    }

    private DateValidatorPointBackward(long j2) {
        this.f15243s = j2;
    }
}
