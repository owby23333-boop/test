package cn.kuaipan.android.utils;

import android.os.SystemClock;
import com.dangdang.zframework.utils.DateUtil;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UnknownFormatConversionException;

/* JADX INFO: loaded from: classes.dex */
public class OAuthTimeUtils {
    private static final SimpleDateFormat sFormat;
    private static final StringBuffer sFormatBuffer;
    private static final FieldPosition sFormatFieldPos;
    private static final ParsePosition sFormatPosition;
    private static long sTimeDiff;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2);
        sFormat = simpleDateFormat;
        sFormatPosition = new ParsePosition(0);
        sFormatBuffer = new StringBuffer();
        sFormatFieldPos = new FieldPosition(0);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0800"));
    }

    public static long currentTime() {
        return sTimeDiff == 0 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + sTimeDiff;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static synchronized Date parser(String str, Date date) {
        if (str == null) {
            return date;
        }
        try {
            ParsePosition parsePosition = sFormatPosition;
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(0);
            Date date2 = sFormat.parse(str, parsePosition);
            if (parsePosition.getErrorIndex() == -1) {
                if (parsePosition.getIndex() != 0) {
                    date = date2;
                }
                return date;
            }
            throw new UnknownFormatConversionException("Date: " + str);
        } catch (Exception unused) {
            throw new UnknownFormatConversionException("Date:" + str);
        }
    }

    public static void setRealTime(long j) {
        sTimeDiff = j - SystemClock.elapsedRealtime();
    }

    public static Date stringToDate(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2).parse(str);
    }

    public static long stringToLong(String str, String str2) throws ParseException {
        Date dateStringToDate = stringToDate(str, str2);
        if (dateStringToDate == null) {
            return 0L;
        }
        return dateToLong(dateStringToDate);
    }

    public static synchronized String toString(long j) {
        StringBuffer stringBuffer;
        stringBuffer = sFormatBuffer;
        stringBuffer.delete(0, stringBuffer.length());
        return sFormat.format(new Date(j), stringBuffer, sFormatFieldPos).toString();
    }
}
