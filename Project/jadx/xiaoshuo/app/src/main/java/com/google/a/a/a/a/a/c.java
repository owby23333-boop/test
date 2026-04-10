package com.google.a.a.a.a.a;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<d, List<Throwable>> f6781a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f6782b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        while (true) {
            Reference<? extends Throwable> referencePoll = this.f6782b.poll();
            if (referencePoll == null) {
                break;
            }
            this.f6781a.remove(referencePoll);
        }
        List<Throwable> list = this.f6781a.get(new d(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.f6781a.putIfAbsent(new d(th, this.f6782b), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
