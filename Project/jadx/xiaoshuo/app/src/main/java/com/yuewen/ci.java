package com.yuewen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.User;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ci implements rz3, xl3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<ci> f9662b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9663a;

    public ci(Context context) {
        this.f9663a = context;
    }

    public static void O(kv3<ci> kv3Var) {
        f9662b = kv3Var;
    }

    public static ci b() {
        kv3<ci> kv3Var = f9662b;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public abstract User A();

    public abstract bi B();

    public String C() {
        return "";
    }

    public String D() {
        return "";
    }

    public boolean E() {
        return false;
    }

    public abstract boolean F();

    public abstract boolean G();

    public abstract st1 H();

    public abstract void I(cr2 cr2Var);

    public void J(cr2 cr2Var) {
    }

    public abstract void K(@NonNull cr2 cr2Var);

    public abstract void L(String str, @NonNull cr2 cr2Var);

    public void M(String str, xt1 xt1Var, zu2 zu2Var) {
    }

    public abstract void N(l3 l3Var);

    public abstract void a(l3 l3Var);

    public abstract bi g();

    public AccountType i() {
        return AccountType.NONE;
    }

    public Set<String> o() {
        return null;
    }

    public abstract String s();

    public abstract bi u();

    public String w() {
        return "";
    }

    public abstract st1 x();

    public abstract User y();
}
