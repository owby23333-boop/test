package com.bytedance.sdk.component.dl.g.z.fo;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f658a;
    private int dl;
    private char[] e;
    private final int g;
    private int gc;
    private int m;
    private final String z;

    a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.z = name;
        this.g = name.length();
    }

    private String z() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.dl;
            i2 = this.g;
            if (i >= i2 || this.e[i] != ' ') {
                break;
            }
            this.dl = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.f658a = i;
        this.dl = i + 1;
        while (true) {
            i3 = this.dl;
            i4 = this.g;
            if (i3 >= i4 || (c3 = this.e[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.dl = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.z);
        }
        this.gc = i3;
        if (this.e[i3] == ' ') {
            while (true) {
                i6 = this.dl;
                i7 = this.g;
                if (i6 >= i7 || (c2 = this.e[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.dl = i6 + 1;
            }
            if (this.e[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.z);
            }
        }
        do {
            i5 = this.dl + 1;
            this.dl = i5;
            if (i5 >= this.g) {
                break;
            }
        } while (this.e[i5] == ' ');
        int i8 = this.gc;
        int i9 = this.f658a;
        if (i8 - i9 > 4) {
            char[] cArr = this.e;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.f658a = i9 + 4;
            }
        }
        char[] cArr2 = this.e;
        int i10 = this.f658a;
        return new String(cArr2, i10, this.gc - i10);
    }

    private String g() {
        int i = this.dl + 1;
        this.dl = i;
        this.f658a = i;
        this.gc = i;
        while (true) {
            int i2 = this.dl;
            if (i2 == this.g) {
                throw new IllegalStateException("Unexpected end of DN: " + this.z);
            }
            char[] cArr = this.e;
            char c = cArr[i2];
            if (c == '\"') {
                this.dl = i2 + 1;
                while (true) {
                    int i3 = this.dl;
                    if (i3 >= this.g || this.e[i3] != ' ') {
                        break;
                    }
                    this.dl = i3 + 1;
                }
                char[] cArr2 = this.e;
                int i4 = this.f658a;
                return new String(cArr2, i4, this.gc - i4);
            }
            if (c == '\\') {
                cArr[this.gc] = gc();
            } else {
                cArr[this.gc] = c;
            }
            this.dl++;
            this.gc++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.gc = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String dl() {
        /*
            r6 = this;
            int r0 = r6.dl
            int r1 = r0 + 4
            int r2 = r6.g
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L96
            r6.f658a = r0
            int r0 = r0 + 1
            r6.dl = r0
        L10:
            int r0 = r6.dl
            int r1 = r6.g
            if (r0 == r1) goto L54
            char[] r1 = r6.e
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
            r6.gc = r0
            int r0 = r0 + 1
            r6.dl = r0
        L31:
            int r0 = r6.dl
            int r1 = r6.g
            if (r0 >= r1) goto L56
            char[] r1 = r6.e
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.dl = r0
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
            r6.dl = r0
            goto L10
        L54:
            r6.gc = r0
        L56:
            int r0 = r6.gc
            int r1 = r6.f658a
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
            int r5 = r6.z(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.e
            int r3 = r6.f658a
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.z
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L96:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.z
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.fo.a.dl():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r1 = r8.e;
        r2 = r8.f658a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        return new java.lang.String(r1, r2, r8.gc - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.dl
            r8.f658a = r0
            r8.gc = r0
        L6:
            int r0 = r8.dl
            int r1 = r8.g
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.e
            int r2 = r8.f658a
            int r3 = r8.gc
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.e
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
            int r3 = r8.gc
            int r4 = r3 + 1
            r8.gc = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.dl = r0
            goto L6
        L3e:
            int r0 = r8.gc
            int r2 = r0 + 1
            r8.gc = r2
            char r2 = r8.gc()
            r1[r0] = r2
            int r0 = r8.dl
            int r0 = r0 + 1
            r8.dl = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.e
            int r2 = r8.f658a
            int r3 = r8.gc
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.gc
            r8.m = r2
            int r0 = r0 + 1
            r8.dl = r0
            int r0 = r2 + 1
            r8.gc = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.dl
            int r1 = r8.g
            if (r0 >= r1) goto L85
            char[] r2 = r8.e
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.gc
            int r7 = r1 + 1
            r8.gc = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.dl = r0
            goto L6c
        L85:
            if (r0 == r1) goto L91
            char[] r1 = r8.e
            char r0 = r1[r0]
            if (r0 == r3) goto L91
            if (r0 == r4) goto L91
            if (r0 != r5) goto L6
        L91:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.e
            int r2 = r8.f658a
            int r3 = r8.m
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.fo.a.a():java.lang.String");
    }

    private char gc() {
        int i = this.dl + 1;
        this.dl = i;
        if (i == this.g) {
            throw new IllegalStateException("Unexpected end of DN: " + this.z);
        }
        char c = this.e[i];
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
                        return m();
                }
        }
    }

    private char m() {
        int i;
        int i2;
        int iZ = z(this.dl);
        this.dl++;
        if (iZ < 128) {
            return (char) iZ;
        }
        if (iZ < 192 || iZ > 247) {
            return '?';
        }
        if (iZ <= 223) {
            i = iZ & 31;
            i2 = 1;
        } else if (iZ <= 239) {
            i = iZ & 15;
            i2 = 2;
        } else {
            i = iZ & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.dl + 1;
            this.dl = i4;
            if (i4 == this.g || this.e[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.dl = i5;
            int iZ2 = z(i5);
            this.dl++;
            if ((iZ2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (iZ2 & 63);
        }
        return (char) i;
    }

    private int z(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.g) {
            throw new IllegalStateException("Malformed DN: " + this.z);
        }
        char[] cArr = this.e;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.z);
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
                throw new IllegalStateException("Malformed DN: " + this.z);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public String z(String str) {
        String strG;
        this.dl = 0;
        this.f658a = 0;
        this.gc = 0;
        this.m = 0;
        this.e = this.z.toCharArray();
        String strZ = z();
        if (strZ == null) {
            return null;
        }
        do {
            int i = this.dl;
            if (i == this.g) {
                return null;
            }
            char c = this.e[i];
            if (c == '\"') {
                strG = g();
            } else if (c == '#') {
                strG = dl();
            } else {
                strG = (c == '+' || c == ',' || c == ';') ? "" : a();
            }
            if (str.equalsIgnoreCase(strZ)) {
                return strG;
            }
            int i2 = this.dl;
            if (i2 >= this.g) {
                return null;
            }
            char c2 = this.e[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.z);
            }
            this.dl = i2 + 1;
            strZ = z();
        } while (strZ != null);
        throw new IllegalStateException("Malformed DN: " + this.z);
    }
}
