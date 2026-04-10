package com.yuewen;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class ie<TResult> implements ge<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<ge<TResult>> f12464a = new CopyOnWriteArrayList<>();

    @Override // com.yuewen.ge
    public void a() {
        Iterator<ge<TResult>> it = this.f12464a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.yuewen.ge
    public void b(TResult tresult) {
        Iterator<ge<TResult>> it = this.f12464a.iterator();
        while (it.hasNext()) {
            it.next().b(tresult);
        }
    }

    public void c(ge<TResult> geVar) {
        this.f12464a.add(geVar);
    }

    public void d() {
        this.f12464a.clear();
    }

    public boolean e() {
        return this.f12464a.isEmpty();
    }

    public void f(ge<TResult> geVar) {
        this.f12464a.remove(geVar);
    }

    @Override // com.yuewen.ge
    public void onFailed(int i, String str) {
        Iterator<ge<TResult>> it = this.f12464a.iterator();
        while (it.hasNext()) {
            it.next().onFailed(i, str);
        }
    }
}
