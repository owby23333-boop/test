package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.an;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class d {
    private static final Pattern amV = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern amW = Pattern.compile("GET /(.*) HTTP");
    public final long amX;
    public final boolean amY;
    public final String uri;

    private d(String str) {
        an.et(str);
        long jCx = cx(str);
        this.amX = Math.max(0L, jCx);
        this.amY = jCx >= 0;
        this.uri = cy(str);
    }

    public static d b(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new d(sb.toString());
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    private static long cx(String str) {
        Matcher matcher = amV.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String cy(String str) {
        Matcher matcher = amW.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.amX + ", partial=" + this.amY + ", uri='" + this.uri + "'}";
    }
}
