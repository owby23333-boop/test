package com.bytedance.sdk.component.zk;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements Comparable<p>, Runnable {
    private String bf;
    private int e;

    public p(String str, int i) {
        this.e = 0;
        this.e = i == 0 ? 5 : i;
        this.bf = str;
    }

    public String bf() {
        return this.bf;
    }

    public void e(int i) {
        this.e = i;
    }

    public int e() {
        return this.e;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        if (e() < pVar.e()) {
            return 1;
        }
        return e() >= pVar.e() ? -1 : 0;
    }

    public p(String str) {
        this.e = 5;
        this.bf = str;
    }
}
