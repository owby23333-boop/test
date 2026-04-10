package com.amgcyo.cuttadon.j.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MyFutrueTask.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends h<Boolean> {
    public g(Callable<Boolean> callable) {
        super(callable);
    }

    @Override // com.amgcyo.cuttadon.j.a.h
    public void a() {
        System.out.println("onFinish");
    }
}
