package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class uo1 implements to1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f18532b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<vo1> f18533a = new LinkedList<>();

    @Override // com.yuewen.to1
    public View c(View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.yuewen.to1
    public int h(int i, int i2) {
        return i - i2;
    }

    @Override // com.yuewen.to1
    public void j(vo1 vo1Var) {
        if (this.f18533a.contains(vo1Var)) {
            return;
        }
        this.f18533a.add(vo1Var);
    }

    @Override // com.yuewen.to1
    public void l(vo1 vo1Var) {
        this.f18533a.remove(vo1Var);
    }

    public void p(int i, int i2) {
        Iterator<vo1> it = this.f18533a.iterator();
        while (it.hasNext()) {
            it.next().b(i, i2);
        }
    }

    public void q() {
        Iterator<vo1> it = this.f18533a.iterator();
        while (it.hasNext()) {
            it.next().i(getItemCount());
        }
    }

    public void r(int i, int i2) {
        Iterator<vo1> it = this.f18533a.iterator();
        while (it.hasNext()) {
            it.next().n(i, i2);
        }
    }

    public void s(int i, int i2, int i3) {
        Iterator<vo1> it = this.f18533a.iterator();
        while (it.hasNext()) {
            it.next().m(i, i2, i3);
        }
    }

    public void t(int i, int i2) {
        Iterator<vo1> it = this.f18533a.iterator();
        while (it.hasNext()) {
            it.next().o(i, i2);
        }
    }
}
