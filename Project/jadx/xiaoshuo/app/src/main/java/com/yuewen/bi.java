package com.yuewen;

import android.app.Activity;
import com.duokan.reader.domain.account.AccountType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface bi {
    default void a(Activity activity) {
    }

    default Map<String, String> c() {
        return new HashMap();
    }

    ea4 d();

    default Object f() {
        return null;
    }

    String g();

    boolean isEmpty();

    i3 j();

    String k();

    default void l() {
    }

    String m();

    default long n() {
        return -1L;
    }

    default void o() {
    }

    void q(tu1 tu1Var);

    default void r(Runnable runnable, Runnable runnable2) {
    }

    AccountType s();

    Map<String, String> t();

    default boolean v() {
        return false;
    }
}
