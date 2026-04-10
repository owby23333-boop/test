package com.yuewen;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class ug1 extends xd2 {
    public int e;
    public int f;
    public int g;
    public List<v52<String>> h;
    public String i;

    public ug1() {
        this.e = 5000;
        this.f = 10000;
        this.g = 0;
        this.h = null;
        this.i = "";
    }

    public ug1 g(String str, String str2) {
        if (this.h == null) {
            this.h = new LinkedList();
        }
        this.h.add(new v52<>(str, str2));
        return this;
    }

    @Override // com.yuewen.xd2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ug1 a(int i) {
        return (ug1) super.a(i);
    }

    @Override // com.yuewen.xd2
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ug1 b(String str, String str2) {
        return (ug1) super.b(str, str2);
    }

    public ug1 j(List<v52<String>> list) {
        this.h = list;
        return this;
    }

    @Override // com.yuewen.xd2
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ug1 d(ne2 ne2Var) {
        return (ug1) super.d(ne2Var);
    }

    public ug1 l(int i) {
        this.g = i;
        return this;
    }

    @Override // com.yuewen.xd2
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ug1 e(String str) {
        return (ug1) super.e(str);
    }

    @Override // com.yuewen.xd2
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ug1 f(oe2 oe2Var) {
        return (ug1) super.f(oe2Var);
    }

    public ug1 o(int i, int i2) {
        this.e = i;
        this.f = i2;
        return this;
    }

    public ug1(ug1 ug1Var) {
        this.e = 5000;
        this.f = 10000;
        this.g = 0;
        this.h = null;
        this.i = "";
        this.e = ug1Var.e;
        this.f = ug1Var.f;
        this.g = ug1Var.g;
        this.f19864a = ug1Var.f19864a;
        this.h = ug1Var.h;
        this.f19865b = ug1Var.f19865b;
        this.c = ug1Var.c;
        this.d = ug1Var.d;
    }
}
