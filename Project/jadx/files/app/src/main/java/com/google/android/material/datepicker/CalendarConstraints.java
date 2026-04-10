package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.bytedance.pangle.ZeusPluginEventCallback;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final Month f15229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final Month f15230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final DateValidator f15231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Month f15232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f15233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f15234x;

    public interface DateValidator extends Parcelable {
        boolean f(long j2);
    }

    static class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f15235e = n.a(Month.a(1900, 0).f15282x);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f15236f = n.a(Month.a(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 11).f15282x);
        private long a;
        private long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f15237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DateValidator f15238d;

        b(@NonNull CalendarConstraints calendarConstraints) {
            this.a = f15235e;
            this.b = f15236f;
            this.f15238d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.a = calendarConstraints.f15229s.f15282x;
            this.b = calendarConstraints.f15230t.f15282x;
            this.f15237c = Long.valueOf(calendarConstraints.f15232v.f15282x);
            this.f15238d = calendarConstraints.f15231u;
        }

        @NonNull
        public b a(long j2) {
            this.f15237c = Long.valueOf(j2);
            return this;
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f15238d);
            Month monthB = Month.b(this.a);
            Month monthB2 = Month.b(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.f15237c;
            return new CalendarConstraints(monthB, monthB2, dateValidator, l2 == null ? null : Month.b(l2.longValue()), null);
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    Month e() {
        return this.f15229s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f15229s.equals(calendarConstraints.f15229s) && this.f15230t.equals(calendarConstraints.f15230t) && ObjectsCompat.equals(this.f15232v, calendarConstraints.f15232v) && this.f15231u.equals(calendarConstraints.f15231u);
    }

    int f() {
        return this.f15233w;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f15229s, this.f15230t, this.f15232v, this.f15231u});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f15229s, 0);
        parcel.writeParcelable(this.f15230t, 0);
        parcel.writeParcelable(this.f15232v, 0);
        parcel.writeParcelable(this.f15231u, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.f15229s = month;
        this.f15230t = month2;
        this.f15232v = month3;
        this.f15231u = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f15234x = month.b(month2) + 1;
        this.f15233w = (month2.f15279u - month.f15279u) + 1;
    }

    boolean a(long j2) {
        if (this.f15229s.a(1) <= j2) {
            Month month = this.f15230t;
            if (j2 <= month.a(month.f15281w)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    Month b() {
        return this.f15230t;
    }

    int c() {
        return this.f15234x;
    }

    @Nullable
    Month d() {
        return this.f15232v;
    }

    public DateValidator a() {
        return this.f15231u;
    }

    Month a(Month month) {
        if (month.compareTo(this.f15229s) < 0) {
            return this.f15229s;
        }
        return month.compareTo(this.f15230t) > 0 ? this.f15230t : month;
    }
}
