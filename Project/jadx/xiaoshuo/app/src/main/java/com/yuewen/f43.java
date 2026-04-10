package com.yuewen;

import com.yuewen.a94;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class f43 implements a94.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a94> f11051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g94 f11052b;
    public final int c;

    public f43(List<a94> list, int i, g94 g94Var) {
        this.f11051a = list;
        this.c = i;
        this.f11052b = g94Var;
    }

    @Override // com.yuewen.a94.a
    public void a(g94 g94Var) {
        if (this.c >= this.f11051a.size()) {
            return;
        }
        this.f11051a.get(this.c).a(new f43(this.f11051a, this.c + 1, g94Var));
    }

    @Override // com.yuewen.a94.a
    public g94 request() {
        return this.f11052b;
    }
}
