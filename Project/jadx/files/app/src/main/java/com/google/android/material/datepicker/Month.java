package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final Calendar f15277s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final int f15278t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final int f15279u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final int f15280v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final int f15281w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final long f15282x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private String f15283y;

    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        this.f15277s = n.a(calendar);
        this.f15278t = this.f15277s.get(2);
        this.f15279u = this.f15277s.get(1);
        this.f15280v = this.f15277s.getMaximum(7);
        this.f15281w = this.f15277s.getActualMaximum(5);
        this.f15282x = this.f15277s.getTimeInMillis();
    }

    @NonNull
    static Month a(int i2, int i3) {
        Calendar calendarF = n.f();
        calendarF.set(1, i2);
        calendarF.set(2, i3);
        return new Month(calendarF);
    }

    @NonNull
    static Month b(long j2) {
        Calendar calendarF = n.f();
        calendarF.setTimeInMillis(j2);
        return new Month(calendarF);
    }

    @NonNull
    static Month c() {
        return new Month(n.d());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f15278t == month.f15278t && this.f15279u == month.f15279u;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f15278t), Integer.valueOf(this.f15279u)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.f15279u);
        parcel.writeInt(this.f15278t);
    }

    @NonNull
    String c(Context context) {
        if (this.f15283y == null) {
            this.f15283y = d.a(context, this.f15277s.getTimeInMillis());
        }
        return this.f15283y;
    }

    int b(@NonNull Month month) {
        if (this.f15277s instanceof GregorianCalendar) {
            return ((month.f15279u - this.f15279u) * 12) + (month.f15278t - this.f15278t);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    int a() {
        int firstDayOfWeek = this.f15277s.get(7) - this.f15277s.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f15280v : firstDayOfWeek;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull Month month) {
        return this.f15277s.compareTo(month.f15277s);
    }

    long b() {
        return this.f15277s.getTimeInMillis();
    }

    long a(int i2) {
        Calendar calendarA = n.a(this.f15277s);
        calendarA.set(5, i2);
        return calendarA.getTimeInMillis();
    }

    @NonNull
    Month b(int i2) {
        Calendar calendarA = n.a(this.f15277s);
        calendarA.add(2, i2);
        return new Month(calendarA);
    }

    int a(long j2) {
        Calendar calendarA = n.a(this.f15277s);
        calendarA.setTimeInMillis(j2);
        return calendarA.get(5);
    }
}
