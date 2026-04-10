package com.bytedance.sdk.component.dl.g;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f642a;
    private final String dl;
    private final String gc;
    private final String m;
    private static final Pattern z = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private q(String str, String str2, String str3, String str4) {
        this.dl = str;
        this.f642a = str2;
        this.gc = str3;
        this.m = str4;
    }

    public static q z(String str) {
        Matcher matcher = z.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = g.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 != null) {
                    if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                        strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    }
                } else {
                    strGroup2 = matcher2.group(3);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = strGroup2;
            }
        }
        return new q(str, lowerCase, lowerCase2, str2);
    }

    public String z() {
        return this.f642a;
    }

    public String g() {
        return this.gc;
    }

    public Charset dl() {
        return z((Charset) null);
    }

    public Charset z(Charset charset) {
        try {
            String str = this.m;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.dl;
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).dl.equals(this.dl);
    }

    public int hashCode() {
        return this.dl.hashCode();
    }
}
