package com.amgcyo.cuttadon.view.numbertextview;

import android.animation.TypeEvaluator;
import java.math.BigDecimal;

/* JADX INFO: compiled from: BigDecimalEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
class a implements TypeEvaluator {
    a() {
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f2, Object obj, Object obj2) {
        BigDecimal bigDecimal = (BigDecimal) obj;
        return ((BigDecimal) obj2).subtract(bigDecimal).multiply(new BigDecimal("" + f2)).add(bigDecimal);
    }
}
