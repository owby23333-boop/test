package com.yuewen;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class jr1<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<E> f13047b = new LinkedList<>();

    public jr1(int i) {
        this.f13046a = i;
    }

    public boolean add(E e) {
        this.f13047b.add(e);
        while (this.f13047b.size() > this.f13046a) {
            this.f13047b.remove();
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f13047b.iterator();
    }
}
