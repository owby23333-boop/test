package com.yuewen;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public class x01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<w01> f19749a = new LinkedList<>();

    public synchronized void a() {
        this.f19749a.clear();
    }

    public final synchronized <T extends w01> T b(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        for (w01 w01Var : this.f19749a) {
            if (cls.isAssignableFrom(w01Var.getClass())) {
                return cls.cast(w01Var);
            }
        }
        return null;
    }

    public final synchronized boolean c(w01 w01Var) {
        if (w01Var == null) {
            return false;
        }
        this.f19749a.remove(w01Var);
        this.f19749a.addFirst(w01Var);
        return true;
    }

    public final synchronized boolean d(w01 w01Var) {
        if (w01Var == null) {
            return true;
        }
        return this.f19749a.remove(w01Var);
    }
}
