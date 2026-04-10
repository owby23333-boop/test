package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UtcDates.java */
/* JADX INFO: loaded from: classes2.dex */
class n {
    static AtomicReference<m> a = new AtomicReference<>();

    static Calendar a(Calendar calendar) {
        Calendar calendarB = b(calendar);
        Calendar calendarF = f();
        calendarF.set(calendarB.get(1), calendarB.get(2), calendarB.get(5));
        return calendarF;
    }

    static m b() {
        m mVar = a.get();
        return mVar == null ? m.b() : mVar;
    }

    private static TimeZone c() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar d() {
        Calendar calendarA = b().a();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        calendarA.setTimeZone(c());
        return calendarA;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone e() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar f() {
        return b((Calendar) null);
    }

    @TargetApi(24)
    static DateFormat g(Locale locale) {
        return a("yMMMEd", locale);
    }

    static java.text.DateFormat c(Locale locale) {
        return a(0, locale);
    }

    static java.text.DateFormat e(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) d(locale);
        simpleDateFormat.applyPattern(a(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    @TargetApi(24)
    static DateFormat f(Locale locale) {
        return a("yMMMd", locale);
    }

    static Calendar b(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(c());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    static DateFormat b(Locale locale) {
        return a("MMMEd", locale);
    }

    static long a(long j2) {
        Calendar calendarF = f();
        calendarF.setTimeInMillis(j2);
        return a(calendarF).getTimeInMillis();
    }

    static java.text.DateFormat d(Locale locale) {
        return a(2, locale);
    }

    @TargetApi(24)
    private static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(e());
        return instanceForSkeleton;
    }

    private static java.text.DateFormat a(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(c());
        return dateInstance;
    }

    static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(c());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String a(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R$string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R$string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R$string.mtrl_picker_text_input_year_abbr));
    }

    @TargetApi(24)
    static DateFormat a(Locale locale) {
        return a("MMMd", locale);
    }

    @NonNull
    private static String a(@NonNull String str) {
        int iA = a(str, "yY", 1, 0);
        if (iA >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int iA2 = a(str, "EMd", 1, iA);
        if (iA2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(a(str, str2, -1, iA) + 1, iA2), " ").trim();
    }

    private static int a(@NonNull String str, @NonNull String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 < 0 || i3 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i3) != '\'');
            }
            i3 += i2;
        }
        return i3;
    }
}
