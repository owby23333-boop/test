package com.bytedance.sdk.openadsdk.api.plugin.mb;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
final class ox {
    private int b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14706h;
    private int hj;
    private char[] ko;
    private final String mb;
    private final int ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14707u;

    ox(X500Principal x500Principal) {
        this.mb = x500Principal.getName("RFC2253");
        this.ox = this.mb.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.f14706h = r6.b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b() {
        /*
            r6 = this;
            int r0 = r6.b
            int r1 = r0 + 4
            int r2 = r6.ox
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La8
            r6.hj = r0
            int r0 = r0 + 1
            r6.b = r0
        L10:
            int r0 = r6.b
            int r1 = r6.ox
            if (r0 == r1) goto L61
            char[] r1 = r6.ko
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L61
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.f14706h = r0
            int r0 = r0 + 1
            r6.b = r0
        L37:
            int r0 = r6.b
            int r1 = r6.ox
            if (r0 >= r1) goto L65
            char[] r1 = r6.ko
            char r1 = r1[r0]
            if (r1 != r4) goto L65
            int r0 = r0 + 1
            r6.b = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r6.b
            int r0 = r0 + 1
            r6.b = r0
            goto L10
        L61:
            int r0 = r6.b
            r6.f14706h = r0
        L65:
            int r0 = r6.f14706h
            int r1 = r6.hj
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L91
            r2 = r0 & 1
            if (r2 == 0) goto L91
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L78:
            int r4 = r2.length
            if (r3 >= r4) goto L87
            int r4 = r6.mb(r1)
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L78
        L87:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.ko
            int r3 = r6.hj
            r1.<init>(r2, r3, r0)
            return r1
        L91:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.mb
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.mb
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto Lc0
        Lbf:
            throw r0
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.mb.ox.b():java.lang.String");
    }

    private char h() {
        this.b++;
        int i2 = this.b;
        if (i2 == this.ox) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        char c2 = this.ko[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return u();
                    }
                    break;
            }
        }
        return this.ko[this.b];
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.ko;
        r2 = r8.hj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.f14706h - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String hj() {
        /*
            r8 = this;
            int r0 = r8.b
            r8.hj = r0
            r8.f14706h = r0
        L6:
            int r0 = r8.b
            int r1 = r8.ox
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.ko
            int r2 = r8.hj
            int r3 = r8.f14706h
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.ko
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f14706h
            int r3 = r2 + 1
            r8.f14706h = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.b = r0
            goto L6
        L40:
            int r0 = r8.f14706h
            int r2 = r0 + 1
            r8.f14706h = r2
            char r2 = r8.h()
            r1[r0] = r2
            int r0 = r8.b
            int r0 = r0 + 1
            r8.b = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.ko
            int r2 = r8.hj
            int r3 = r8.f14706h
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f14706h
            r8.f14707u = r2
            int r0 = r0 + 1
            r8.b = r0
            int r0 = r2 + 1
            r8.f14706h = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.b
            int r1 = r8.ox
            if (r0 >= r1) goto L87
            char[] r1 = r8.ko
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f14706h
            int r7 = r2 + 1
            r8.f14706h = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.b = r0
            goto L6e
        L87:
            int r0 = r8.b
            int r1 = r8.ox
            if (r0 == r1) goto L9b
            char[] r1 = r8.ko
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.ko
            int r2 = r8.hj
            int r3 = r8.f14707u
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.mb.ox.hj():java.lang.String");
    }

    private String mb() {
        while (true) {
            int i2 = this.b;
            if (i2 >= this.ox || this.ko[i2] != ' ') {
                break;
            }
            this.b = i2 + 1;
        }
        int i3 = this.b;
        if (i3 == this.ox) {
            return null;
        }
        this.hj = i3;
        this.b = i3 + 1;
        while (true) {
            int i4 = this.b;
            if (i4 >= this.ox) {
                break;
            }
            char[] cArr = this.ko;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.b = i4 + 1;
        }
        int i5 = this.b;
        if (i5 >= this.ox) {
            throw new IllegalStateException("Unexpected end of DN: " + this.mb);
        }
        this.f14706h = i5;
        if (this.ko[i5] == ' ') {
            while (true) {
                int i6 = this.b;
                if (i6 >= this.ox) {
                    break;
                }
                char[] cArr2 = this.ko;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.b = i6 + 1;
            }
            char[] cArr3 = this.ko;
            int i7 = this.b;
            if (cArr3[i7] != '=' || i7 == this.ox) {
                throw new IllegalStateException("Unexpected end of DN: " + this.mb);
            }
        }
        this.b++;
        while (true) {
            int i8 = this.b;
            if (i8 >= this.ox || this.ko[i8] != ' ') {
                break;
            }
            this.b = i8 + 1;
        }
        int i9 = this.f14706h;
        int i10 = this.hj;
        if (i9 - i10 > 4) {
            char[] cArr4 = this.ko;
            if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                char[] cArr5 = this.ko;
                int i11 = this.hj;
                if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                    char[] cArr6 = this.ko;
                    int i12 = this.hj;
                    if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                        this.hj += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.ko;
        int i13 = this.hj;
        return new String(cArr7, i13, this.f14706h - i13);
    }

    private String ox() {
        this.b++;
        this.hj = this.b;
        this.f14706h = this.hj;
        while (true) {
            int i2 = this.b;
            if (i2 == this.ox) {
                throw new IllegalStateException("Unexpected end of DN: " + this.mb);
            }
            char[] cArr = this.ko;
            if (cArr[i2] == '\"') {
                this.b = i2 + 1;
                while (true) {
                    int i3 = this.b;
                    if (i3 >= this.ox || this.ko[i3] != ' ') {
                        break;
                    }
                    this.b = i3 + 1;
                }
                char[] cArr2 = this.ko;
                int i4 = this.hj;
                return new String(cArr2, i4, this.f14706h - i4);
            }
            if (cArr[i2] == '\\') {
                cArr[this.f14706h] = h();
            } else {
                cArr[this.f14706h] = cArr[i2];
            }
            this.b++;
            this.f14706h++;
        }
    }

    private char u() {
        int i2;
        int i3;
        int iMb = mb(this.b);
        this.b++;
        if (iMb < 128) {
            return (char) iMb;
        }
        if (iMb < 192 || iMb > 247) {
            return '?';
        }
        if (iMb <= 223) {
            i3 = iMb & 31;
            i2 = 1;
        } else if (iMb <= 239) {
            i2 = 2;
            i3 = iMb & 15;
        } else {
            i2 = 3;
            i3 = iMb & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.b++;
            int i5 = this.b;
            if (i5 == this.ox || this.ko[i5] != '\\') {
                return '?';
            }
            this.b = i5 + 1;
            int iMb2 = mb(this.b);
            this.b++;
            if ((iMb2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (iMb2 & 63);
        }
        return (char) i3;
    }

    private int mb(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.ox) {
            char c2 = this.ko[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.mb);
                }
                i3 = c2 - '7';
            }
            char c3 = this.ko[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.mb);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.mb);
    }

    public String mb(String str) {
        String strOx;
        this.b = 0;
        this.hj = 0;
        this.f14706h = 0;
        this.f14707u = 0;
        this.ko = this.mb.toCharArray();
        String strMb = mb();
        if (strMb == null) {
            return null;
        }
        do {
            int i2 = this.b;
            if (i2 == this.ox) {
                return null;
            }
            char c2 = this.ko[i2];
            if (c2 == '\"') {
                strOx = ox();
            } else if (c2 != '#') {
                strOx = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : hj();
            } else {
                strOx = b();
            }
            if (str.equalsIgnoreCase(strMb)) {
                return strOx;
            }
            int i3 = this.b;
            if (i3 >= this.ox) {
                return null;
            }
            char[] cArr = this.ko;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.mb);
            }
            this.b++;
            strMb = mb();
        } while (strMb != null);
        throw new IllegalStateException("Malformed DN: " + this.mb);
    }
}
