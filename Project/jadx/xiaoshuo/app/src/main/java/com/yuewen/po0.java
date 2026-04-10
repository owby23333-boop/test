package com.yuewen;

import com.yuewen.ah0;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class po0<T> implements ah0.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<ah0<T>> f16083a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ah0<T> f16084b;

    @Override // com.yuewen.ah0.a
    public void a(ah0<T> ah0Var, boolean z) {
        if (!z) {
            if (ah0Var == this.f16084b) {
                this.f16084b = null;
                return;
            }
            return;
        }
        this.f16084b = ah0Var;
        for (ah0<T> ah0Var2 : this.f16083a) {
            if (ah0Var2 != ah0Var && ah0Var2.isChecked()) {
                ah0Var2.setChecked(false);
            }
        }
    }

    public void b(ah0<T> ah0Var) {
        if (this.f16083a.contains(ah0Var)) {
            return;
        }
        this.f16083a.add(ah0Var);
        ah0Var.d(this);
    }

    public ah0<T> c() {
        return this.f16084b;
    }

    public void d(String str) {
        for (ah0<T> ah0Var : this.f16083a) {
            if (ah0Var.c().equals(str)) {
                ah0Var.setChecked(true);
            } else {
                ah0Var.setChecked(false);
            }
        }
    }
}
