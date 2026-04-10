package com.bytedance.sdk.component.d.bf.e.zk;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
final class tg {
    private final int bf;
    private int d;
    private final String e;
    private int ga;
    private char[] p;
    private int tg;
    private int vn;

    public tg(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.e = name;
        this.bf = name.length();
    }

    private String bf() {
        int i = this.d + 1;
        this.d = i;
        this.tg = i;
        this.ga = i;
        while (true) {
            int i2 = this.d;
            if (i2 == this.bf) {
                throw new IllegalStateException("Unexpected end of DN: " + this.e);
            }
            char[] cArr = this.p;
            char c = cArr[i2];
            if (c == '\"') {
                this.d = i2 + 1;
                while (true) {
                    int i3 = this.d;
                    if (i3 >= this.bf || this.p[i3] != ' ') {
                        break;
                    }
                    this.d = i3 + 1;
                }
                char[] cArr2 = this.p;
                int i4 = this.tg;
                return new String(cArr2, i4, this.ga - i4);
            }
            if (c == '\\') {
                cArr[this.ga] = ga();
            } else {
                cArr[this.ga] = c;
            }
            this.d++;
            this.ga++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.ga = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.d
            int r1 = r0 + 4
            int r2 = r6.bf
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L98
            r6.tg = r0
            int r0 = r0 + 1
            r6.d = r0
        L10:
            int r0 = r6.d
            int r1 = r6.bf
            if (r0 == r1) goto L54
            char[] r1 = r6.p
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.ga = r0
            int r0 = r0 + 1
            r6.d = r0
        L31:
            int r0 = r6.d
            int r1 = r6.bf
            if (r0 >= r1) goto L56
            char[] r1 = r6.p
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.d = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.d = r0
            goto L10
        L54:
            r6.ga = r0
        L56:
            int r0 = r6.ga
            int r1 = r6.tg
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.e(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.p
            int r3 = r6.tg
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L98:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.e.zk.tg.d():java.lang.String");
    }

    private String e() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        int i6;
        char c2;
        char c3;
        while (true) {
            i = this.d;
            i2 = this.bf;
            if (i >= i2 || this.p[i] != ' ') {
                break;
            }
            this.d = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.tg = i;
        this.d = i + 1;
        while (true) {
            i3 = this.d;
            i4 = this.bf;
            if (i3 >= i4 || (c3 = this.p[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.d = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.e);
        }
        this.ga = i3;
        if (this.p[i3] == ' ') {
            while (true) {
                i5 = this.d;
                i6 = this.bf;
                if (i5 >= i6 || (c2 = this.p[i5]) == '=' || c2 != ' ') {
                    break;
                }
                this.d = i5 + 1;
            }
            if (this.p[i5] != '=' || i5 == i6) {
                throw new IllegalStateException("Unexpected end of DN: " + this.e);
            }
        }
        this.d++;
        while (true) {
            int i7 = this.d;
            if (i7 >= this.bf || this.p[i7] != ' ') {
                break;
            }
            this.d = i7 + 1;
        }
        int i8 = this.ga;
        int i9 = this.tg;
        if (i8 - i9 > 4) {
            char[] cArr = this.p;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.tg = i9 + 4;
            }
        }
        char[] cArr2 = this.p;
        int i10 = this.tg;
        return new String(cArr2, i10, i8 - i10);
    }

    private char ga() {
        int i = this.d + 1;
        this.d = i;
        if (i == this.bf) {
            throw new IllegalStateException("Unexpected end of DN: " + this.e);
        }
        char c = this.p[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return vn();
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.tg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.ga - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String tg() {
        /*
            r8 = this;
            int r0 = r8.d
            r8.tg = r0
            r8.ga = r0
        L6:
            int r0 = r8.d
            int r1 = r8.bf
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.p
            int r2 = r8.tg
            int r3 = r8.ga
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.p
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.ga
            int r4 = r3 + 1
            r8.ga = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.d = r0
            goto L6
        L3e:
            int r0 = r8.ga
            int r2 = r0 + 1
            r8.ga = r2
            char r2 = r8.ga()
            r1[r0] = r2
            int r0 = r8.d
            int r0 = r0 + 1
            r8.d = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.tg
            int r3 = r8.ga
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.ga
            r8.vn = r2
            int r0 = r0 + 1
            r8.d = r0
            int r0 = r2 + 1
            r8.ga = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.d
            int r1 = r8.bf
            if (r0 >= r1) goto L83
            char[] r2 = r8.p
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.ga
            int r7 = r1 + 1
            r8.ga = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.d = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.p
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.p
            int r2 = r8.tg
            int r3 = r8.vn
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.e.zk.tg.tg():java.lang.String");
    }

    private char vn() {
        int i;
        int i2;
        int iE = e(this.d);
        this.d++;
        if (iE < 128) {
            return (char) iE;
        }
        if (iE < 192 || iE > 247) {
            return '?';
        }
        if (iE <= 223) {
            i = iE & 31;
            i2 = 1;
        } else if (iE <= 239) {
            i = iE & 15;
            i2 = 2;
        } else {
            i = iE & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.d + 1;
            this.d = i4;
            if (i4 == this.bf || this.p[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.d = i5;
            int iE2 = e(i5);
            this.d++;
            if ((iE2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (iE2 & 63);
        }
        return (char) i;
    }

    private int e(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.bf) {
            char[] cArr = this.p;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else {
                if (c < 'A' || c > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.e);
                }
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.e);
                }
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.e);
    }

    public String e(String str) {
        String strBf;
        this.d = 0;
        this.tg = 0;
        this.ga = 0;
        this.vn = 0;
        this.p = this.e.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i = this.d;
            if (i == this.bf) {
                return null;
            }
            char c = this.p[i];
            if (c == '\"') {
                strBf = bf();
            } else if (c != '#') {
                strBf = (c == '+' || c == ',' || c == ';') ? "" : tg();
            } else {
                strBf = d();
            }
            if (str.equalsIgnoreCase(strE)) {
                return strBf;
            }
            int i2 = this.d;
            if (i2 >= this.bf) {
                return null;
            }
            char c2 = this.p[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.e);
            }
            this.d = i2 + 1;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.e);
    }
}
