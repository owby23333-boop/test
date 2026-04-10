package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.io;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class kb {
    public final String dl;
    public final int g;
    public final io z;

    public kb(io ioVar, int i, String str) {
        this.z = ioVar;
        this.g = i;
        this.dl = str;
    }

    public static kb z(String str) throws IOException {
        io ioVar;
        int i;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                ioVar = io.HTTP_1_0;
            } else if (iCharAt == 1) {
                ioVar = io.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            ioVar = io.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
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
            return new kb(ioVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.z == io.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ').append(this.g);
        if (this.dl != null) {
            sb.append(' ').append(this.dl);
        }
        return sb.toString();
    }
}
