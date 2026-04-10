package com.google.zxing.oned.rss.expanded.decoders;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: GeneralAppIdDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class r {
    private final com.google.zxing.common.a a;
    private final CurrentParsingState b = new CurrentParsingState();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f16231c = new StringBuilder();

    r(com.google.zxing.common.a aVar) {
        this.a = aVar;
    }

    private n b() throws FormatException {
        l lVarD;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.b()) {
                lVarD = a();
                zB = lVarD.b();
            } else if (this.b.c()) {
                lVarD = c();
                zB = lVarD.b();
            } else {
                lVarD = d();
                zB = lVarD.b();
            }
            if (!(iA != this.b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarD.a();
    }

    private o c(int i2) throws FormatException {
        int i3 = i2 + 7;
        if (i3 > this.a.c()) {
            int iA = a(i2, 4);
            return iA == 0 ? new o(this.a.c(), 10, 10) : new o(this.a.c(), iA - 1, 10);
        }
        int iA2 = a(i2, 7) - 8;
        return new o(i3, iA2 / 11, iA2 % 11);
    }

    private l d() throws FormatException {
        while (i(this.b.a())) {
            o oVarC = c(this.b.a());
            this.b.b(oVarC.a());
            if (oVarC.d()) {
                return new l(oVarC.e() ? new n(this.b.a(), this.f16231c.toString()) : new n(this.b.a(), this.f16231c.toString(), oVarC.c()), true);
            }
            this.f16231c.append(oVarC.b());
            if (oVarC.e()) {
                return new l(new n(this.b.a(), this.f16231c.toString()), true);
            }
            this.f16231c.append(oVarC.c());
        }
        if (f(this.b.a())) {
            this.b.d();
            this.b.a(4);
        }
        return new l(false);
    }

    private boolean e(int i2) {
        int i3;
        if (i2 + 1 > this.a.c()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.a.c(); i4++) {
            if (i4 == 2) {
                if (!this.a.a(i2 + 2)) {
                    return false;
                }
            } else if (this.a.a(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean f(int i2) {
        int i3;
        if (i2 + 1 > this.a.c()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.a.c(); i4++) {
            if (this.a.a(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean g(int i2) {
        int iA;
        if (i2 + 5 > this.a.c()) {
            return false;
        }
        int iA2 = a(i2, 5);
        if (iA2 < 5 || iA2 >= 16) {
            return i2 + 6 <= this.a.c() && (iA = a(i2, 6)) >= 16 && iA < 63;
        }
        return true;
    }

    private boolean h(int i2) {
        int iA;
        if (i2 + 5 > this.a.c()) {
            return false;
        }
        int iA2 = a(i2, 5);
        if (iA2 >= 5 && iA2 < 16) {
            return true;
        }
        if (i2 + 7 > this.a.c()) {
            return false;
        }
        int iA3 = a(i2, 7);
        if (iA3 < 64 || iA3 >= 116) {
            return i2 + 8 <= this.a.c() && (iA = a(i2, 8)) >= 232 && iA < 253;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 + 7 > this.a.c()) {
            return i2 + 4 <= this.a.c();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.a.a(i4);
            }
            if (this.a.a(i3)) {
                return true;
            }
            i3++;
        }
    }

    String a(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n nVarA = a(i2, str);
            String strA = q.a(nVarA.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = nVarA.d() ? String.valueOf(nVarA.c()) : null;
            if (i2 == nVarA.a()) {
                return sb.toString();
            }
            i2 = nVarA.a();
            str = strValueOf;
        }
    }

    private l c() throws FormatException {
        while (h(this.b.a())) {
            m mVarB = b(this.b.a());
            this.b.b(mVarB.a());
            if (mVarB.c()) {
                return new l(new n(this.b.a(), this.f16231c.toString()), true);
            }
            this.f16231c.append(mVarB.b());
        }
        if (d(this.b.a())) {
            this.b.a(3);
            this.b.f();
        } else if (e(this.b.a())) {
            if (this.b.a() + 5 < this.a.c()) {
                this.b.a(5);
            } else {
                this.b.b(this.a.c());
            }
            this.b.d();
        }
        return new l(false);
    }

    int a(int i2, int i3) {
        return a(this.a, i2, i3);
    }

    static int a(com.google.zxing.common.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.a(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    n a(int i2, String str) throws FormatException {
        this.f16231c.setLength(0);
        if (str != null) {
            this.f16231c.append(str);
        }
        this.b.b(i2);
        n nVarB = b();
        if (nVarB != null && nVarB.d()) {
            return new n(this.b.a(), this.f16231c.toString(), nVarB.c());
        }
        return new n(this.b.a(), this.f16231c.toString());
    }

    private m b(int i2) throws FormatException {
        char c2;
        int iA = a(i2, 5);
        if (iA == 15) {
            return new m(i2 + 5, '$');
        }
        if (iA >= 5 && iA < 15) {
            return new m(i2 + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i2, 7);
        if (iA2 >= 64 && iA2 < 90) {
            return new m(i2 + 7, (char) (iA2 + 1));
        }
        if (iA2 >= 90 && iA2 < 116) {
            return new m(i2 + 7, (char) (iA2 + 7));
        }
        switch (a(i2, 8)) {
            case TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK /* 232 */:
                c2 = '!';
                break;
            case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /* 233 */:
                c2 = '\"';
                break;
            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS /* 234 */:
                c2 = '%';
                break;
            case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL /* 235 */:
                c2 = '&';
                break;
            case TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS /* 236 */:
                c2 = '\'';
                break;
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS /* 237 */:
                c2 = '(';
                break;
            case TbsListener.ErrorCode.TPATCH_FAIL /* 238 */:
                c2 = ')';
                break;
            case TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL /* 239 */:
                c2 = '*';
                break;
            case TbsListener.ErrorCode.TPATCH_VERSION_FAILED /* 240 */:
                c2 = '+';
                break;
            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /* 241 */:
                c2 = ',';
                break;
            case TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION /* 242 */:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw FormatException.f();
        }
        return new m(i2 + 8, c2);
    }

    private l a() {
        while (g(this.b.a())) {
            m mVarA = a(this.b.a());
            this.b.b(mVarA.a());
            if (mVarA.c()) {
                return new l(new n(this.b.a(), this.f16231c.toString()), true);
            }
            this.f16231c.append(mVarA.b());
        }
        if (d(this.b.a())) {
            this.b.a(3);
            this.b.f();
        } else if (e(this.b.a())) {
            if (this.b.a() + 5 < this.a.c()) {
                this.b.a(5);
            } else {
                this.b.b(this.a.c());
            }
            this.b.e();
        }
        return new l(false);
    }

    private boolean d(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.a.c()) {
            return false;
        }
        while (i2 < i3) {
            if (this.a.a(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private m a(int i2) {
        char c2;
        int iA = a(i2, 5);
        if (iA == 15) {
            return new m(i2 + 5, '$');
        }
        if (iA >= 5 && iA < 15) {
            return new m(i2 + 5, (char) ((iA + 48) - 5));
        }
        int iA2 = a(i2, 6);
        if (iA2 >= 32 && iA2 < 58) {
            return new m(i2 + 6, (char) (iA2 + 33));
        }
        switch (iA2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iA2)));
        }
        return new m(i2 + 6, c2);
    }
}
