package com.yuewen;

import android.graphics.DrawFilter;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class df2 extends DrawFilter {
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Integer> f10152a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Integer> f10153b = new LinkedList<>();
    public int c = 0;

    public void a(int i) {
        this.f10152a.add(Integer.valueOf(i));
    }

    public void b(int i) {
        this.f10153b.add(Integer.valueOf(i));
    }

    public void c() {
        this.c |= 1;
    }

    public boolean d(int i) {
        return this.f10152a.contains(Integer.valueOf(i));
    }

    public boolean e(int i) {
        return this.f10153b.contains(Integer.valueOf(i));
    }

    public boolean f() {
        return (this.c & 1) == 1;
    }
}
