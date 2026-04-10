package com.bytedance.sdk.component.g.z;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends gz implements Cloneable {
    static final List<i> gz = com.bytedance.sdk.component.g.z.g.uy.z(i.HTTP_2, i.HTTP_1_1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f723a;
    public TimeUnit dl;
    public TimeUnit e;
    public List<i> fo;
    public long g;
    public TimeUnit gc;
    public com.bytedance.sdk.component.g.z.z.z.z kb;
    public long m;
    public Set<String> uy;
    public List<fo> z;

    public a z() {
        return null;
    }

    public g z(v vVar) {
        return null;
    }

    public wp() {
        this(new z());
    }

    public wp(z zVar) {
        this.g = zVar.dl;
        this.f723a = zVar.gc;
        this.m = zVar.e;
        this.dl = zVar.f724a;
        this.gc = zVar.m;
        this.e = zVar.gz;
        this.z = zVar.z;
        this.fo = zVar.fo;
        this.uy = zVar.uy;
        this.kb = zVar.g;
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TimeUnit f724a;
        public long dl;
        public long e;
        List<i> fo;
        public com.bytedance.sdk.component.g.z.z.z.z g;
        public long gc;
        public TimeUnit gz;
        public Bundle kb;
        public TimeUnit m;
        public Set<String> uy;
        public final List<fo> z;

        public z() {
            this.z = new ArrayList();
            this.dl = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f724a = TimeUnit.MILLISECONDS;
            this.gc = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.m = TimeUnit.MILLISECONDS;
            this.e = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gz = TimeUnit.MILLISECONDS;
        }

        public z(String str) {
            this.z = new ArrayList();
            this.dl = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f724a = TimeUnit.MILLISECONDS;
            this.gc = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.m = TimeUnit.MILLISECONDS;
            this.e = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gz = TimeUnit.MILLISECONDS;
            this.fo = wp.gz;
        }

        public z(wp wpVar) {
            this.z = new ArrayList();
            this.dl = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.f724a = TimeUnit.MILLISECONDS;
            this.gc = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.m = TimeUnit.MILLISECONDS;
            this.e = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.gz = TimeUnit.MILLISECONDS;
            this.dl = wpVar.g;
            this.f724a = wpVar.dl;
            this.gc = wpVar.f723a;
            this.m = wpVar.gc;
            this.e = wpVar.m;
            this.gz = wpVar.e;
            this.fo = wpVar.fo;
            this.uy = wpVar.uy;
        }

        public z z(long j, TimeUnit timeUnit) {
            this.dl = j;
            this.f724a = timeUnit;
            return this;
        }

        public z g(long j, TimeUnit timeUnit) {
            this.gc = j;
            this.m = timeUnit;
            return this;
        }

        public z dl(long j, TimeUnit timeUnit) {
            this.e = j;
            this.gz = timeUnit;
            return this;
        }

        public z z(com.bytedance.sdk.component.g.z.z.z.z zVar) {
            this.g = zVar;
            return this;
        }

        public z z(fo foVar) {
            this.z.add(foVar);
            return this;
        }

        public z z(Set<String> set) {
            this.uy = set;
            return this;
        }

        public z z(List<i> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(i.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(i.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(i.SPDY_3);
            this.fo = Collections.unmodifiableList(arrayList);
            return this;
        }

        public z z(Bundle bundle) {
            this.kb = bundle;
            return this;
        }

        public wp z() {
            if (com.bytedance.sdk.component.g.z.z.z.z().g()) {
                return com.bytedance.sdk.component.g.z.z.z.g(this);
            }
            return com.bytedance.sdk.component.g.z.z.z.z(this);
        }
    }

    public z g() {
        return new z(this);
    }
}
