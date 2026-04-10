package com.yuewen;

import com.google.common.base.Preconditions;
import java.lang.Number;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes12.dex */
public class fh4<K, V extends Number> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TreeMap<Double, K> f11129a = new TreeMap<>();

    public fh4(List<uf2<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (uf2<K, V> uf2Var : list) {
            double dDoubleValue = uf2Var.e().doubleValue();
            double dDoubleValue2 = w51.l;
            Preconditions.checkArgument(dDoubleValue > w51.l, String.format("非法权重值：pair=%s", uf2Var));
            if (this.f11129a.size() != 0) {
                dDoubleValue2 = this.f11129a.lastKey().doubleValue();
            }
            this.f11129a.put(Double.valueOf(uf2Var.e().doubleValue() + dDoubleValue2), uf2Var.c());
        }
    }

    public K a() {
        return this.f11129a.get(this.f11129a.tailMap(Double.valueOf(this.f11129a.lastKey().doubleValue() * Math.random()), false).firstKey());
    }
}
