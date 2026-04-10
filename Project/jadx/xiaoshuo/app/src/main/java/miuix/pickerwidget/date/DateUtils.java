package miuix.pickerwidget.date;

import android.content.Context;
import android.text.format.DateFormat;
import java.util.TimeZone;
import miuix.core.util.Pools;
import miuix.pickerwidget.R;

/* JADX INFO: loaded from: classes6.dex */
public class DateUtils {
    private static final Pools.Pool<Calendar> CALENDAR_POOL = Pools.createSoftReferencePool(new Pools.Manager<Calendar>() { // from class: miuix.pickerwidget.date.DateUtils.1
        @Override // miuix.core.util.Pools.Manager
        public Calendar createInstance() {
            return new Calendar();
        }
    }, 1);
    public static final int FORMAT_12HOUR = 16;
    public static final int FORMAT_24HOUR = 32;
    public static final int FORMAT_ABBREV_ALL = 28672;
    public static final int FORMAT_ABBREV_MONTH = 4096;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 8192;
    public static final int FORMAT_NO_AM_PM = 64;
    public static final int FORMAT_NUMERIC_DATE = 32768;
    public static final int FORMAT_SHOW_BRIEF_TIME = 12;
    public static final int FORMAT_SHOW_DATE = 896;
    public static final int FORMAT_SHOW_HOUR = 8;
    public static final int FORMAT_SHOW_MILLISECOND = 1;
    public static final int FORMAT_SHOW_MINUTE = 4;
    public static final int FORMAT_SHOW_MONTH = 256;
    public static final int FORMAT_SHOW_MONTH_DAY = 128;
    public static final int FORMAT_SHOW_SECOND = 2;
    public static final int FORMAT_SHOW_TIME = 15;
    public static final int FORMAT_SHOW_TIME_ZONE = 2048;
    public static final int FORMAT_SHOW_WEEKDAY = 1024;
    public static final int FORMAT_SHOW_YEAR = 512;

    public DateUtils() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String formatDateTime(Context context, long j, int i) {
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        String string = formatDateTime(context, sbAcquire, j, i, null).toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string;
    }

    public static String formatRelativeTime(Context context, long j, boolean z) {
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        String string = formatRelativeTime(context, sbAcquire, j, z, null).toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string;
    }

    private static int getDatePatternResId(int i) {
        if ((i & 32768) == 32768) {
            if ((i & 512) == 512) {
                return (i & 256) == 256 ? (i & 128) == 128 ? R.string.fmt_date_numeric_year_month_day : R.string.fmt_date_numeric_year_month : R.string.fmt_date_numeric_year;
            }
            if ((i & 256) == 256) {
                return (i & 128) == 128 ? R.string.fmt_date_numeric_month_day : R.string.fmt_date_numeric_month;
            }
            if ((i & 128) == 128) {
                return R.string.fmt_date_numeric_day;
            }
            throw new IllegalArgumentException("no any time date");
        }
        if ((i & 4096) == 4096) {
            if ((i & 512) == 512) {
                return (i & 256) == 256 ? (i & 128) == 128 ? R.string.fmt_date_short_year_month_day : R.string.fmt_date_short_year_month : R.string.fmt_date_year;
            }
            if ((i & 256) == 256) {
                return (i & 128) == 128 ? R.string.fmt_date_short_month_day : R.string.fmt_date_short_month;
            }
            if ((i & 128) == 128) {
                return R.string.fmt_date_day;
            }
            throw new IllegalArgumentException("no any time date");
        }
        if ((i & 512) == 512) {
            return (i & 256) == 256 ? (i & 128) == 128 ? R.string.fmt_date_long_year_month_day : R.string.fmt_date_long_year_month : R.string.fmt_date_year;
        }
        if ((i & 256) == 256) {
            return (i & 128) == 128 ? R.string.fmt_date_long_month_day : R.string.fmt_date_long_month;
        }
        if ((i & 128) == 128) {
            return R.string.fmt_date_day;
        }
        throw new IllegalArgumentException("no any time date");
    }

    private static int getFormatResId(int i) {
        return (i & 1024) == 1024 ? (i & FORMAT_SHOW_DATE) != 0 ? (i & 15) != 0 ? (i & 2048) == 2048 ? R.string.fmt_weekday_date_time_timezone : R.string.fmt_weekday_date_time : (i & 2048) == 2048 ? R.string.fmt_weekday_date_timezone : R.string.fmt_weekday_date : (i & 15) != 0 ? (i & 2048) == 2048 ? R.string.fmt_weekday_time_timezone : R.string.fmt_weekday_time : (i & 2048) == 2048 ? R.string.fmt_weekday_timezone : R.string.fmt_weekday : (i & FORMAT_SHOW_DATE) != 0 ? (i & 15) != 0 ? (i & 2048) == 2048 ? R.string.fmt_date_time_timezone : R.string.fmt_date_time : (i & 2048) == 2048 ? R.string.fmt_date_timezone : R.string.fmt_date : (i & 15) != 0 ? (i & 2048) == 2048 ? R.string.fmt_time_timezone : R.string.fmt_time : (i & 2048) == 2048 ? R.string.fmt_timezone : R.string.empty;
    }

    private static int getTimePatternResId(Calendar calendar, int i) {
        if ((i & 16384) == 16384 && (((i & 1) != 1 || calendar.get(22) == 0) && (i & 14) != 0)) {
            i &= -2;
            if (((i & 2) != 2 || calendar.get(21) == 0) && (i & 12) != 0) {
                i &= -3;
                if (calendar.get(20) == 0 && (i & 8) != 0) {
                    i &= -5;
                }
            }
        }
        if ((i & 8) == 8) {
            return (i & 16) == 16 ? (i & 64) == 64 ? (i & 4) == 4 ? (i & 2) == 2 ? (i & 1) == 1 ? R.string.fmt_time_12hour_minute_second_millis : R.string.fmt_time_12hour_minute_second : R.string.fmt_time_12hour_minute : R.string.fmt_time_12hour : (i & 4) == 4 ? (i & 2) == 2 ? (i & 1) == 1 ? R.string.fmt_time_12hour_minute_second_millis_pm : R.string.fmt_time_12hour_minute_second_pm : R.string.fmt_time_12hour_minute_pm : R.string.fmt_time_12hour_pm : (i & 4) == 4 ? (i & 2) == 2 ? (i & 1) == 1 ? R.string.fmt_time_24hour_minute_second_millis : R.string.fmt_time_24hour_minute_second : R.string.fmt_time_24hour_minute : R.string.fmt_time_24hour;
        }
        if ((i & 4) == 4) {
            return (i & 2) == 2 ? (i & 1) == 1 ? R.string.fmt_time_minute_second_millis : R.string.fmt_time_minute_second : R.string.fmt_time_minute;
        }
        if ((i & 2) == 2) {
            return (i & 1) == 1 ? R.string.fmt_time_second_millis : R.string.fmt_time_second;
        }
        if ((i & 1) == 1) {
            return R.string.fmt_time_millis;
        }
        throw new IllegalArgumentException("no any time date");
    }

    private static int getWeekdayPatternResId(int i) {
        return (i & 8192) == 8192 ? R.string.fmt_weekday_short : R.string.fmt_weekday_long;
    }

    public static String formatDateTime(Context context, long j, int i, TimeZone timeZone) {
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        String string = formatDateTime(context, sbAcquire, j, i, timeZone).toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string;
    }

    public static String formatRelativeTime(Context context, long j, boolean z, TimeZone timeZone) {
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        String string = formatRelativeTime(context, sbAcquire, j, z, timeZone).toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string;
    }

    public static StringBuilder formatDateTime(Context context, StringBuilder sb, long j, int i) {
        return formatDateTime(context, sb, j, i, null);
    }

    public static StringBuilder formatRelativeTime(Context context, StringBuilder sb, long j, boolean z) {
        return formatRelativeTime(context, sb, j, z, null);
    }

    public static StringBuilder formatDateTime(Context context, StringBuilder sb, long j, int i, TimeZone timeZone) {
        if ((i & 16) == 0 && (i & 32) == 0) {
            i |= DateFormat.is24HourFormat(context) ? 32 : 16;
        }
        String string = context.getString(getFormatResId(i));
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        Calendar calendarAcquire = CALENDAR_POOL.acquire();
        calendarAcquire.setTimeZone(timeZone);
        calendarAcquire.setTimeInMillis(j);
        int length = string.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = string.charAt(i2);
            if (cCharAt == 'D') {
                sbAcquire.append(context.getString(getDatePatternResId(i)));
            } else if (cCharAt == 'T') {
                sbAcquire.append(context.getString(getTimePatternResId(calendarAcquire, i)));
            } else if (cCharAt != 'W') {
                sbAcquire.append(cCharAt);
            } else {
                sbAcquire.append(context.getString(getWeekdayPatternResId(i)));
            }
        }
        calendarAcquire.format(context, sb, sbAcquire);
        Pools.getStringBuilderPool().release(sbAcquire);
        CALENDAR_POOL.release(calendarAcquire);
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.StringBuilder formatRelativeTime(android.content.Context r16, java.lang.StringBuilder r17, long r18, boolean r20, java.util.TimeZone r21) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: miuix.pickerwidget.date.DateUtils.formatRelativeTime(android.content.Context, java.lang.StringBuilder, long, boolean, java.util.TimeZone):java.lang.StringBuilder");
    }
}
