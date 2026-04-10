package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final w a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f955c;

    public k(w wVar, int i2, String str) {
        this.a = wVar;
        this.b = i2;
        this.f955c = str;
    }

    public static k a(String str) throws IOException {
        w wVar;
        String strSubstring;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                wVar = w.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                wVar = w.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            wVar = w.HTTP_1_0;
            i2 = 4;
        }
        int i3 = i2 + 3;
        if (str.length() < i3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i4 = Integer.parseInt(str.substring(i2, i3));
            if (str.length() <= i3) {
                strSubstring = "";
            } else {
                if (str.charAt(i3) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i2 + 4);
            }
            return new k(wVar, i4, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.b);
        if (this.f955c != null) {
            sb.append(' ');
            sb.append(this.f955c);
        }
        return sb.toString();
    }
}
