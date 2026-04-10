package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final ThreadLocal<DateFormat> a = new a();
    private static final String[] b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f940c = new DateFormat[b.length];

    static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1154n);
            return simpleDateFormat;
        }
    }

    public static String a(Date date) {
        return a.get().format(date);
    }

    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        synchronized (b) {
            int length = b.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat simpleDateFormat = f940c[i2];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(b[i2], Locale.US);
                    simpleDateFormat.setTimeZone(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1154n);
                    f940c[i2] = simpleDateFormat;
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
}
