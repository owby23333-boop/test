package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
final class d {
    private static final Pattern aKR = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aKS = Pattern.compile("GET /(.*) HTTP");
    public final long aKT;
    public final boolean aKU;
    public final String uri;

    private d(String str) {
        ax.hh(str);
        long jEH = eH(str);
        this.aKT = Math.max(0L, jEH);
        this.aKU = jEH >= 0;
        this.uri = eI(str);
    }

    public static d b(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (!TextUtils.isEmpty(line)) {
                sb.append(line).append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    private static long eH(String str) {
        Matcher matcher = aKR.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eI(String str) {
        Matcher matcher = aKS.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aKT + ", partial=" + this.aKU + ", uri='" + this.uri + "'}";
    }
}
