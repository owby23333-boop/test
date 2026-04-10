package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeSource.java */
/* JADX INFO: loaded from: classes2.dex */
class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final m f15335c = new m(null, null);

    @Nullable
    private final Long a;

    @Nullable
    private final TimeZone b;

    private m(@Nullable Long l2, @Nullable TimeZone timeZone) {
        this.a = l2;
        this.b = timeZone;
    }

    static m b() {
        return f15335c;
    }

    Calendar a() {
        return a(this.b);
    }

    Calendar a(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.a;
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        return calendar;
    }
}
