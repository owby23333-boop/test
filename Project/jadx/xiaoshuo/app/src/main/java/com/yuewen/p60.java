package com.yuewen;

import android.os.Looper;
import com.duokan.reader.domain.document.Anchor;
import com.duokan.reader.domain.document.CharAnchor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f15943a = false;

    public boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public k60 b(k60[] k60VarArr, CharAnchor charAnchor) {
        k60 k60VarB;
        k60 k60Var = null;
        for (int i = 0; i < k60VarArr.length; i++) {
            if (k60VarArr[i].l()) {
                if (l(k60VarArr[i], charAnchor)) {
                    break;
                }
                k60Var = k60VarArr[i];
            }
        }
        return (k60Var == null || k60Var.c().length <= 0 || (k60VarB = b(k60Var.c(), charAnchor)) == null) ? k60Var : k60VarB;
    }

    public k60 c(k60[] k60VarArr, k60 k60Var) {
        k60 k60VarC = null;
        for (int i = 0; i < k60VarArr.length; i++) {
            if (k60VarArr[i].l()) {
                if (k60VarArr[i].e() > k60Var.e()) {
                    k60VarC = k60VarArr[i];
                }
                if (k60VarC != null) {
                    return k60VarC;
                }
                if (k60VarArr[i].b() > 0) {
                    k60VarC = c(k60VarArr[i].c(), k60Var);
                }
                if (k60VarC != null) {
                    return k60VarC;
                }
            }
        }
        return null;
    }

    public k60 d(k60[] k60VarArr, k60 k60Var) {
        k60 k60VarD = null;
        for (int length = k60VarArr.length - 1; length >= 0; length--) {
            if (k60VarArr[length].l()) {
                if (k60VarArr[length].b() > 0) {
                    k60VarD = d(k60VarArr[length].c(), k60Var);
                }
                if (k60VarD != null) {
                    return k60VarD;
                }
                if (k60VarArr[length].e() < k60Var.e()) {
                    k60VarD = k60VarArr[length];
                }
                if (k60VarD != null) {
                    return k60VarD;
                }
            }
        }
        return null;
    }

    public abstract k60 e(Anchor anchor);

    public k60 f(k60 k60Var) {
        if (k60Var == null) {
            return null;
        }
        return c(j(), k60Var);
    }

    public k60 g(k60 k60Var) {
        if (k60Var == null) {
            return null;
        }
        return d(j(), k60Var);
    }

    public k60 h(Anchor anchor) {
        k60 k60VarE = e(anchor);
        if (k60VarE == null) {
            return null;
        }
        return j()[k60VarE.k()];
    }

    public abstract String i();

    public abstract k60[] j();

    public abstract int k();

    public abstract boolean l(k60 k60Var, CharAnchor charAnchor);

    public abstract void m(k60 k60Var);

    public abstract void n(String str);
}
