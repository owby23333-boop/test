package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: GetRequest.java */
/* JADX INFO: loaded from: classes2.dex */
class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f14754d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f14755e = Pattern.compile("GET /(.*) HTTP");
    public final String a;
    public final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14756c;

    public d(String str) {
        k.a(str);
        long jA = a(str);
        this.b = Math.max(0L, jA);
        this.f14756c = jA >= 0;
        this.a = b(str);
    }

    public static d a(InputStream inputStream) throws IOException {
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

    private String b(String str) {
        Matcher matcher = f14755e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.b + ", partial=" + this.f14756c + ", uri='" + this.a + "'}";
    }

    private long a(String str) {
        Matcher matcher = f14754d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
