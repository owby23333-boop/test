package com.bytedance.sdk.component.d.bf.e.d;

import com.bytedance.sdk.component.d.bf.wl;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class wu {
    public final int bf;
    public final String d;
    public final wl e;

    public wu(wl wlVar, int i, String str) {
        this.e = wlVar;
        this.bf = i;
        this.d = str;
    }

    public static wu e(String str) throws IOException {
        wl wlVar;
        int i;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                wlVar = wl.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                wlVar = wl.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            wlVar = wl.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new wu(wlVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e == wl.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.bf);
        if (this.d != null) {
            sb.append(' ');
            sb.append(this.d);
        }
        return sb.toString();
    }
}
