package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes2.dex */
class d {
    static String a(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - ((long) TimeZone.getDefault().getOffset(j2)), 36);
    }

    static String b(long j2) {
        return a(j2, Locale.getDefault());
    }

    static String c(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? n.f(locale).format(new Date(j2)) : n.d(locale).format(new Date(j2));
    }

    static String d(long j2) {
        return c(j2, Locale.getDefault());
    }

    static String e(long j2) {
        return d(j2, Locale.getDefault());
    }

    static String b(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? n.b(locale).format(new Date(j2)) : n.c(locale).format(new Date(j2));
    }

    static String d(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? n.g(locale).format(new Date(j2)) : n.c(locale).format(new Date(j2));
    }

    static String a(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return n.a(locale).format(new Date(j2));
        }
        return n.e(locale).format(new Date(j2));
    }

    static String c(long j2) {
        return b(j2, Locale.getDefault());
    }

    static String a(long j2) {
        return a(j2, (SimpleDateFormat) null);
    }

    static String a(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar calendarD = n.d();
        Calendar calendarF = n.f();
        calendarF.setTimeInMillis(j2);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j2));
        }
        if (calendarD.get(1) == calendarF.get(1)) {
            return b(j2);
        }
        return d(j2);
    }

    static Pair<String, String> a(@Nullable Long l2, @Nullable Long l3) {
        return a(l2, l3, null);
    }

    static Pair<String, String> a(@Nullable Long l2, @Nullable Long l3, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return Pair.create(null, null);
        }
        if (l2 == null) {
            return Pair.create(null, a(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return Pair.create(a(l2.longValue(), simpleDateFormat), null);
        }
        Calendar calendarD = n.d();
        Calendar calendarF = n.f();
        calendarF.setTimeInMillis(l2.longValue());
        Calendar calendarF2 = n.f();
        calendarF2.setTimeInMillis(l3.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
        }
        if (calendarF.get(1) == calendarF2.get(1)) {
            if (calendarF.get(1) == calendarD.get(1)) {
                return Pair.create(a(l2.longValue(), Locale.getDefault()), a(l3.longValue(), Locale.getDefault()));
            }
            return Pair.create(a(l2.longValue(), Locale.getDefault()), c(l3.longValue(), Locale.getDefault()));
        }
        return Pair.create(c(l2.longValue(), Locale.getDefault()), c(l3.longValue(), Locale.getDefault()));
    }
}
