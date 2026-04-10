package com.bytedance.sdk.component.bf.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class wu extends v implements Cloneable {
    static final List<xu> v = com.bytedance.sdk.component.bf.e.bf.zk.e(xu.HTTP_2, xu.HTTP_1_1);
    public long bf;
    public TimeUnit d;
    public List<zk> e;
    public TimeUnit ga;
    public Set<String> m;
    public TimeUnit p;
    public long tg;
    public long vn;
    final List<xu> zk;

    public wu() {
        this(new e());
    }

    public e bf() {
        return new e(this);
    }

    public bf e(bh bhVar) {
        return null;
    }

    public static final class e {
        public long bf;
        public TimeUnit d;
        public final List<zk> e;
        public TimeUnit ga;
        public TimeUnit p;
        public long tg;
        List<xu> v;
        public long vn;
        public Set<String> zk;

        public e() {
            this.e = new ArrayList();
            this.bf = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.d = timeUnit;
            this.tg = 10000L;
            this.ga = timeUnit;
            this.vn = 10000L;
            this.p = timeUnit;
        }

        public e bf(long j, TimeUnit timeUnit) {
            this.tg = j;
            this.ga = timeUnit;
            return this;
        }

        public e d(long j, TimeUnit timeUnit) {
            this.vn = j;
            this.p = timeUnit;
            return this;
        }

        public e e(long j, TimeUnit timeUnit) {
            this.bf = j;
            this.d = timeUnit;
            return this;
        }

        public e e(zk zkVar) {
            this.e.add(zkVar);
            return this;
        }

        public e e(Set<String> set) {
            this.zk = set;
            return this;
        }

        public e e(List<xu> list) {
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.contains(xu.HTTP_1_1)) {
                if (!arrayList.contains(xu.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(xu.SPDY_3);
                        this.v = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                }
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
        }

        public e(String str) {
            this.e = new ArrayList();
            this.bf = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.d = timeUnit;
            this.tg = 10000L;
            this.ga = timeUnit;
            this.vn = 10000L;
            this.p = timeUnit;
            this.v = wu.v;
        }

        public wu e() {
            return com.bytedance.sdk.component.bf.e.e.e.e(this);
        }

        public e(wu wuVar) {
            this.e = new ArrayList();
            this.bf = 10000L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.d = timeUnit;
            this.tg = 10000L;
            this.ga = timeUnit;
            this.vn = 10000L;
            this.p = timeUnit;
            this.bf = wuVar.bf;
            this.d = wuVar.d;
            this.tg = wuVar.tg;
            this.ga = wuVar.ga;
            this.vn = wuVar.vn;
            this.p = wuVar.p;
            this.v = wuVar.zk;
            this.zk = wuVar.m;
        }
    }

    public wu(e eVar) {
        this.bf = eVar.bf;
        this.tg = eVar.tg;
        this.vn = eVar.vn;
        List<zk> list = eVar.e;
        this.d = eVar.d;
        this.ga = eVar.ga;
        this.p = eVar.p;
        this.e = list;
        this.zk = eVar.v;
        this.m = eVar.zk;
    }

    public tg e() {
        return null;
    }
}
