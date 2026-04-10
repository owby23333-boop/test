package org.json.alipay;

import com.fasterxml.jackson.core.JsonPointer;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.eq2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Reader f21196b;
    private char c;
    private boolean d;

    public c(Reader reader) {
        this.f21196b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.d = false;
        this.f21195a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(char r6) throws org.json.alipay.JSONException {
        /*
            r5 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
        L5:
            char r1 = r5.b()
            if (r1 == 0) goto L62
            r2 = 10
            if (r1 == r2) goto L62
            r3 = 13
            if (r1 == r3) goto L62
            r4 = 92
            if (r1 == r4) goto L1e
            if (r1 != r6) goto L5e
            java.lang.String r6 = r0.toString()
            return r6
        L1e:
            char r1 = r5.b()
            r4 = 98
            if (r1 == r4) goto L5c
            r4 = 102(0x66, float:1.43E-43)
            if (r1 == r4) goto L59
            r4 = 110(0x6e, float:1.54E-43)
            if (r1 == r4) goto L55
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L51
            r2 = 120(0x78, float:1.68E-43)
            r3 = 16
            if (r1 == r2) goto L46
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L43
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L41
            goto L5e
        L41:
            r1 = 4
            goto L47
        L43:
            r1 = 9
            goto L5e
        L46:
            r1 = 2
        L47:
            java.lang.String r1 = r5.a(r1)
            int r1 = java.lang.Integer.parseInt(r1, r3)
            char r1 = (char) r1
            goto L5e
        L51:
            r0.append(r3)
            goto L5
        L55:
            r0.append(r2)
            goto L5
        L59:
            r1 = 12
            goto L5e
        L5c:
            r1 = 8
        L5e:
            r0.append(r1)
            goto L5
        L62:
            java.lang.String r6 = "Unterminated string"
            org.json.alipay.JSONException r6 = r5.a(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.a(char):java.lang.String");
    }

    public char b() throws JSONException {
        if (this.d) {
            this.d = false;
            char c = this.c;
            if (c != 0) {
                this.f21195a++;
            }
            return c;
        }
        try {
            int i = this.f21196b.read();
            if (i <= 0) {
                this.c = (char) 0;
                return (char) 0;
            }
            this.f21195a++;
            char c2 = (char) i;
            this.c = c2;
            return c2;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public char c() {
        char cB;
        char cB2;
        char cB3;
        while (true) {
            cB = b();
            if (cB == '/') {
                char cB4 = b();
                if (cB4 == '*') {
                    while (true) {
                        char cB5 = b();
                        if (cB5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (cB5 == '*') {
                            if (b() == '/') {
                                break;
                            }
                            a();
                        }
                    }
                } else {
                    if (cB4 != '/') {
                        a();
                        return JsonPointer.SEPARATOR;
                    }
                    do {
                        cB2 = b();
                        if (cB2 == '\n' || cB2 == '\r') {
                            break;
                        }
                    } while (cB2 != 0);
                }
            } else if (cB == '#') {
                do {
                    cB3 = b();
                    if (cB3 == '\n' || cB3 == '\r') {
                        break;
                    }
                } while (cB3 != 0);
            } else if (cB == 0 || cB > ' ') {
                break;
            }
        }
        return cB;
    }

    public Object d() {
        char c = c();
        if (c != '\"') {
            if (c != '[') {
                if (c == '{') {
                    a();
                    return new b(this);
                }
                if (c != '\'') {
                    if (c != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char cB = c;
                        while (cB >= ' ' && ",:]}/\\\"[{;=#".indexOf(cB) < 0) {
                            stringBuffer.append(cB);
                            cB = b();
                        }
                        a();
                        String strTrim = stringBuffer.toString().trim();
                        if (strTrim.equals("")) {
                            throw a("Missing value");
                        }
                        if (strTrim.equalsIgnoreCase(com.duokan.reader.domain.payment.a.c)) {
                            return Boolean.TRUE;
                        }
                        if (strTrim.equalsIgnoreCase(MscKeys.VAL_FALSE)) {
                            return Boolean.FALSE;
                        }
                        if (strTrim.equalsIgnoreCase(eq2.g)) {
                            return b.f21193a;
                        }
                        if ((c < '0' || c > '9') && c != '.' && c != '-' && c != '+') {
                            return strTrim;
                        }
                        if (c == '0') {
                            try {
                                return (strTrim.length() <= 2 || !(strTrim.charAt(1) == 'x' || strTrim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(strTrim, 8)) : new Integer(Integer.parseInt(strTrim.substring(2), 16));
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            try {
                                try {
                                    return new Integer(strTrim);
                                } catch (Exception unused2) {
                                    return strTrim;
                                }
                            } catch (Exception unused3) {
                                return new Long(strTrim);
                            }
                        } catch (Exception unused4) {
                            return new Double(strTrim);
                        }
                    }
                }
            }
            a();
            return new a(this);
        }
        return a(c);
    }

    public String toString() {
        return " at character " + this.f21195a;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    public String a(int i) throws JSONException {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int i3 = this.f21196b.read(cArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.f21195a += i2;
        if (i2 < i) {
            throw a("Substring bounds error");
        }
        this.c = cArr[i - 1];
        return new String(cArr);
    }

    public JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public void a() {
        int i;
        if (this.d || (i = this.f21195a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f21195a = i - 1;
        this.d = true;
    }
}
