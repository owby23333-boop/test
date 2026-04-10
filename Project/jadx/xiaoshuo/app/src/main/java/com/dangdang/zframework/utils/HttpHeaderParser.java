package com.dangdang.zframework.utils;

import com.dangdang.zframework.network.command.Cache;
import com.google.common.net.HttpHeaders;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes10.dex */
public class HttpHeaderParser {
    public static Cache.Entry parseCacheHeaders(Map<String, String> map, byte[] bArr) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = map.get(HttpHeaders.DATE);
        long j2 = 0;
        long dateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            j = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    j = 0;
                }
                i++;
            }
            i = 1;
        } else {
            j = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long dateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        String str4 = map.get("ETag");
        if (i != 0) {
            j2 = jCurrentTimeMillis + (j * 1000);
        } else if (dateAsEpoch > 0 && dateAsEpoch2 >= dateAsEpoch) {
            j2 = jCurrentTimeMillis + (dateAsEpoch2 - dateAsEpoch);
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = bArr;
        entry.etag = str4;
        entry.softTtl = j2;
        entry.ttl = j2;
        entry.serverDate = dateAsEpoch;
        entry.responseHeaders = map;
        return entry;
    }

    public static String parseCharset(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] strArrSplit = str.split(";");
        for (int i = 1; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].trim().split(MscKeys.KEY_VAL_SEP);
            if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                return strArrSplit2[1];
            }
        }
        return "ISO-8859-1";
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0L;
        }
    }
}
