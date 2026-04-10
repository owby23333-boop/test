package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
final class d {
    private final String a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f939g;

    d(X500Principal x500Principal) {
        this.a = x500Principal.getName("RFC2253");
        this.b = this.a.length();
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        char c2 = this.f939g[i2];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            i3 = c2 - '7';
        }
        char c3 = this.f939g[i5];
        if (c3 >= '0' && c3 <= '9') {
            i4 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i4 = c3 - 'W';
        } else {
            if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            i4 = c3 - '7';
        }
        return (i3 << 4) + i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r0 = r9.f939g;
        r1 = r9.f936d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return new java.lang.String(r0, r1, r9.f937e - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r9 = this;
            int r0 = r9.f935c
            r9.f936d = r0
            r9.f937e = r0
        L6:
            int r0 = r9.f935c
            int r1 = r9.b
            if (r0 < r1) goto L1a
            char[] r0 = r9.f939g
            int r1 = r9.f936d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f937e
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            goto La6
        L1a:
            char[] r1 = r9.f939g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5e
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r2 = r9.f937e
            int r3 = r2 + 1
            r9.f937e = r3
            char r3 = r1[r0]
            char r3 = (char) r3
            r1[r2] = r3
            goto L4c
        L3e:
            int r0 = r9.f937e
            int r2 = r0 + 1
            r9.f937e = r2
            char r2 = r9.b()
            r1[r0] = r2
            int r0 = r9.f935c
        L4c:
            int r0 = r0 + 1
            r9.f935c = r0
            goto L6
        L51:
            char[] r0 = r9.f939g
            int r1 = r9.f936d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f937e
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            goto La6
        L5e:
            int r2 = r9.f937e
            r9.f938f = r2
            int r0 = r0 + 1
            r9.f935c = r0
            int r0 = r2 + 1
            r9.f937e = r0
            char r0 = (char) r6
            r1[r2] = r0
        L6d:
            int r1 = r9.f935c
            int r2 = r9.b
            if (r1 >= r2) goto L86
            char[] r2 = r9.f939g
            char r7 = r2[r1]
            if (r7 != r6) goto L86
            int r7 = r9.f937e
            int r8 = r7 + 1
            r9.f937e = r8
            r2[r7] = r0
            int r1 = r1 + 1
            r9.f935c = r1
            goto L6d
        L86:
            int r0 = r9.f935c
            int r1 = r9.b
            if (r0 == r1) goto L9a
            char[] r1 = r9.f939g
            char r2 = r1[r0]
            if (r2 == r3) goto L9a
            char r2 = r1[r0]
            if (r2 == r4) goto L9a
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9a:
            char[] r0 = r9.f939g
            int r1 = r9.f936d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f938f
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
        La6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.d.a():java.lang.String");
    }

    private char b() {
        this.f935c++;
        int i2 = this.f935c;
        if (i2 == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        char[] cArr = this.f939g;
        char c2 = cArr[i2];
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
                            return c();
                    }
                    break;
            }
        }
        return cArr[i2];
    }

    private char c() {
        int i2;
        int iA = a(this.f935c);
        this.f935c++;
        if (iA >= 128) {
            if (iA < 192 || iA > 247) {
                return '?';
            }
            if (iA <= 223) {
                iA &= 31;
                i2 = 1;
            } else if (iA <= 239) {
                i2 = 2;
                iA &= 15;
            } else {
                i2 = 3;
                iA &= 7;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                this.f935c++;
                int i4 = this.f935c;
                if (i4 == this.b || this.f939g[i4] != '\\') {
                    return '?';
                }
                this.f935c = i4 + 1;
                int iA2 = a(this.f935c);
                this.f935c++;
                if ((iA2 & 192) != 128) {
                    return '?';
                }
                iA = (iA << 6) + (iA2 & 63);
            }
        }
        return (char) iA;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        r6.f937e = r6.f935c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.f935c
            int r1 = r0 + 4
            int r2 = r6.b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La2
            r6.f936d = r0
        Lc:
            int r0 = r0 + 1
            r6.f935c = r0
            int r0 = r6.f935c
            int r1 = r6.b
            if (r0 == r1) goto L5a
            char[] r1 = r6.f939g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L5a
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L5a
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L5a
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L44
            r6.f937e = r0
        L33:
            int r0 = r0 + 1
            r6.f935c = r0
            int r0 = r6.f935c
            int r1 = r6.b
            if (r0 >= r1) goto L5e
            char[] r1 = r6.f939g
            char r1 = r1[r0]
            if (r1 != r4) goto L5e
            goto L33
        L44:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L57
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L57
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            char r2 = (char) r2
            r1[r0] = r2
        L57:
            int r0 = r6.f935c
            goto Lc
        L5a:
            int r0 = r6.f935c
            r6.f937e = r0
        L5e:
            int r0 = r6.f937e
            int r1 = r6.f936d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L8b
            r2 = r0 & 1
            if (r2 == 0) goto L8b
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L71:
            int r4 = r2.length
            if (r3 >= r4) goto L81
            int r4 = r6.a(r1)
            byte r4 = (byte) r4
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L71
        L81:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f939g
            int r3 = r6.f936d
            r1.<init>(r2, r3, r0)
            return r1
        L8b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto Lba
        Lb9:
            throw r0
        Lba:
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.d.d():java.lang.String");
    }

    private String e() {
        char[] cArr;
        while (true) {
            int i2 = this.f935c;
            if (i2 >= this.b || this.f939g[i2] != ' ') {
                break;
            }
            this.f935c = i2 + 1;
        }
        int i3 = this.f935c;
        if (i3 == this.b) {
            return null;
        }
        this.f936d = i3;
        do {
            this.f935c = i3 + 1;
            i3 = this.f935c;
            if (i3 >= this.b) {
                break;
            }
            cArr = this.f939g;
            if (cArr[i3] == '=') {
                break;
            }
        } while (cArr[i3] != ' ');
        int i4 = this.f935c;
        if (i4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.f937e = i4;
        if (this.f939g[i4] == ' ') {
            while (true) {
                int i5 = this.f935c;
                if (i5 >= this.b) {
                    break;
                }
                char[] cArr2 = this.f939g;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.f935c = i5 + 1;
            }
            char[] cArr3 = this.f939g;
            int i6 = this.f935c;
            if (cArr3[i6] != '=' || i6 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        int i7 = this.f935c;
        do {
            this.f935c = i7 + 1;
            i7 = this.f935c;
            if (i7 >= this.b) {
                break;
            }
        } while (this.f939g[i7] == ' ');
        int i8 = this.f937e;
        int i9 = this.f936d;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.f939g;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                char[] cArr5 = this.f939g;
                int i10 = this.f936d + 1;
                if (cArr5[i10] == 'I' || cArr5[i10] == 'i') {
                    char[] cArr6 = this.f939g;
                    int i11 = this.f936d + 2;
                    if (cArr6[i11] == 'D' || cArr6[i11] == 'd') {
                        this.f936d += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.f939g;
        int i12 = this.f936d;
        return new String(cArr7, i12, this.f937e - i12);
    }

    private String f() {
        this.f935c++;
        this.f936d = this.f935c;
        int i2 = this.f936d;
        while (true) {
            this.f937e = i2;
            int i3 = this.f935c;
            if (i3 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char[] cArr = this.f939g;
            if (cArr[i3] == '\"') {
                do {
                    this.f935c = i3 + 1;
                    i3 = this.f935c;
                    if (i3 >= this.b) {
                        break;
                    }
                } while (this.f939g[i3] == ' ');
                char[] cArr2 = this.f939g;
                int i4 = this.f936d;
                return new String(cArr2, i4, this.f937e - i4);
            }
            if (cArr[i3] == '\\') {
                cArr[this.f937e] = b();
            } else {
                cArr[this.f937e] = cArr[i3];
            }
            this.f935c++;
            i2 = this.f937e + 1;
        }
    }

    public String a(String str) {
        this.f935c = 0;
        this.f936d = 0;
        this.f937e = 0;
        this.f938f = 0;
        this.f939g = this.a.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i2 = this.f935c;
            if (i2 == this.b) {
                return null;
            }
            char c2 = this.f939g[i2];
            String strA = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a() : d() : f();
            if (str.equalsIgnoreCase(strE)) {
                return strA;
            }
            int i3 = this.f935c;
            if (i3 >= this.b) {
                return null;
            }
            char[] cArr = this.f939g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f935c++;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
