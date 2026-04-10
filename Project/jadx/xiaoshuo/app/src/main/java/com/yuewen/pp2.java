package com.yuewen;

import androidx.annotation.NonNull;
import com.duokan.core.io.InputException;
import com.duokan.core.io.OutputException;

/* JADX INFO: loaded from: classes3.dex */
public class pp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16094b;
    public boolean c;
    public String d;
    public long e;
    public final Throwable f;

    public pp2(int i) {
        this.f16093a = i;
        this.f = null;
    }

    public static boolean a(pp2 pp2Var, pp2 pp2Var2) {
        if (pp2Var == null && pp2Var2 == null) {
            return true;
        }
        return (pp2Var == null || pp2Var2 == null || pp2Var.f16093a != pp2Var2.f16093a) ? false : true;
    }

    public boolean b() {
        int i = this.f16093a;
        return i == 0 || i == 1;
    }

    @NonNull
    public String toString() {
        if (b()) {
            return "ok";
        }
        int i = this.f16093a;
        if (i >= 2000) {
            return String.format("server error(%d)", Integer.valueOf(i - 2000));
        }
        switch (i) {
            case 1001:
                return "login invalid";
            case 1002:
                return "no auth";
            case 1003:
                return "no link";
            case 1004:
            case 1005:
            case 1009:
            case 1010:
            default:
                return "unknown error";
            case 1006:
                return "flashmem problem";
            case 1007:
                return "bad size";
            case 1008:
                return "bad md5";
            case 1011:
                return "no network";
            case 1012:
                Object[] objArr = new Object[1];
                Throwable th = this.f;
                objArr[0] = th != null ? th.getClass().getSimpleName() : eq2.g;
                return String.format("exception(%s)", objArr);
        }
    }

    public pp2() {
        this.f16093a = -1;
        this.f = null;
    }

    public pp2(Throwable th) {
        this.f16093a = -1;
        if ((th instanceof InputException) && !g72.h().n()) {
            this.f16093a = 1011;
            this.f = th.getCause();
        } else if (th instanceof OutputException) {
            this.f16093a = 1006;
            this.f = th;
        } else {
            this.f16093a = 1012;
            this.f = th;
        }
    }
}
