package com.duokan.account;

import androidx.annotation.NonNull;
import com.yuewen.tt1;
import com.yuewen.xt1;

/* JADX INFO: loaded from: classes10.dex */
public interface i<T extends tt1> {

    public interface a {
        @NonNull
        String a();

        default int b() {
            return 0;
        }

        default int c() {
            return 0;
        }
    }

    T a(xt1 xt1Var);
}
