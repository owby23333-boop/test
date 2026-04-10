package com.bytedance.sdk.component.d.bf;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class pe {
    private final String d;
    private final String ga;
    private final String tg;
    private final String vn;
    private static final Pattern e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern bf = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private pe(String str, String str2, String str3, String str4) {
        this.d = str;
        this.tg = str2;
        this.ga = str3;
        this.vn = str4;
    }

    public static pe e(String str) {
        Matcher matcher = e.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = bf.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = strGroup3;
            }
        }
        return new pe(str, lowerCase, lowerCase2, str2);
    }

    public Charset bf() {
        return e((Charset) null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof pe) && ((pe) obj).d.equals(this.d);
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        return this.d;
    }

    public String e() {
        return this.tg;
    }

    public Charset e(Charset charset) {
        try {
            String str = this.vn;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
