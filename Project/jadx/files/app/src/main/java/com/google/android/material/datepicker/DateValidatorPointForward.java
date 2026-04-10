package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f15244s;

    static class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j2, a aVar) {
        this(j2);
    }

    @NonNull
    public static DateValidatorPointForward a(long j2) {
        return new DateValidatorPointForward(j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f15244s == ((DateValidatorPointForward) obj).f15244s;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean f(long j2) {
        return j2 >= this.f15244s;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f15244s)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.f15244s);
    }

    private DateValidatorPointForward(long j2) {
        this.f15244s = j2;
    }
}
