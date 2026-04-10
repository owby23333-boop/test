package anetwork.channel.cache;

import anet.channel.util.HttpHelper;
import anetwork.channel.cache.Cache;
import com.umeng.message.utils.HttpRequest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final TimeZone a = TimeZone.getTimeZone("GMT");
    private static final ThreadLocal<SimpleDateFormat> b = new ThreadLocal<>();

    public static String a(long j2) {
        return a().format(new Date(j2));
    }

    private static long a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date date = a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return date.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static Cache.Entry a(Map<String, List<String>> map) {
        long j2;
        long j3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control");
        boolean z2 = true;
        int i2 = 0;
        if (singleHeaderFieldByKey != null) {
            String[] strArrSplit = singleHeaderFieldByKey.split(",");
            j2 = 0;
            while (true) {
                if (i2 >= strArrSplit.length) {
                    break;
                }
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.equals("no-cache")) {
                    j2 = 0;
                    break;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
        } else {
            j2 = 0;
            z2 = false;
        }
        String singleHeaderFieldByKey2 = HttpHelper.getSingleHeaderFieldByKey(map, HttpRequest.HEADER_DATE);
        long jA = singleHeaderFieldByKey2 != null ? a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, HttpRequest.HEADER_EXPIRES);
        long jA2 = singleHeaderFieldByKey3 != null ? a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, "Last-Modified");
        long jA3 = singleHeaderFieldByKey4 != null ? a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, HttpRequest.HEADER_ETAG);
        if (z2) {
            jCurrentTimeMillis += j2 * 1000;
        } else {
            if (jA <= 0 || jA2 < jA) {
                j3 = jA3;
                if (j3 <= 0) {
                    jCurrentTimeMillis = 0;
                }
                if (jCurrentTimeMillis != 0 && singleHeaderFieldByKey5 == null) {
                    return null;
                }
                Cache.Entry entry = new Cache.Entry();
                entry.f561t = singleHeaderFieldByKey5;
                entry.f563v = jCurrentTimeMillis;
                entry.f562u = j3;
                entry.f564w = map;
                return entry;
            }
            jCurrentTimeMillis += jA2 - jA;
        }
        j3 = jA3;
        if (jCurrentTimeMillis != 0) {
        }
        Cache.Entry entry2 = new Cache.Entry();
        entry2.f561t = singleHeaderFieldByKey5;
        entry2.f563v = jCurrentTimeMillis;
        entry2.f562u = j3;
        entry2.f564w = map;
        return entry2;
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = b.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(a);
        b.set(simpleDateFormat2);
        return simpleDateFormat2;
    }
}
