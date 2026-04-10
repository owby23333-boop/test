package com.bytedance.sdk.component.d.bf.e.d;

import com.xiaomi.accountsdk.utils.DateUtils;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class tg {
    private static final String[] bf;
    private static final DateFormat[] d;
    private static final ThreadLocal<DateFormat> e = new ThreadLocal<DateFormat>() { // from class: com.bytedance.sdk.component.d.bf.e.d.tg.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(com.bytedance.sdk.component.d.bf.e.d.p);
            return simpleDateFormat;
        }
    };

    static {
        String[] strArr = {DateUtils.PATTERN_RFC1123, DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        bf = strArr;
        d = new DateFormat[strArr.length];
    }

    public static Date e(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = e.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = bf;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                DateFormat[] dateFormatArr = d;
                DateFormat simpleDateFormat = dateFormatArr[i];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(bf[i], Locale.US);
                    simpleDateFormat.setTimeZone(com.bytedance.sdk.component.d.bf.e.d.p);
                    dateFormatArr[i] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }

    public static String e(Date date) {
        return e.get().format(date);
    }
}
