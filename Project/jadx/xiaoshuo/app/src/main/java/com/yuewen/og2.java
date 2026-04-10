package com.yuewen;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class og2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, qg2> f15269a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qg2 f15270b;

    public void a() {
        this.f15269a.clear();
    }

    public qg2 b(String str) {
        qg2 qg2Var = this.f15269a.get(str);
        return qg2Var != null ? qg2Var : this.f15270b;
    }

    public void c(@NonNull qg2 qg2Var) {
        this.f15269a.put(qg2Var.type(), qg2Var);
    }

    public void d(@NonNull qg2 qg2Var) {
        this.f15270b = qg2Var;
    }
}
