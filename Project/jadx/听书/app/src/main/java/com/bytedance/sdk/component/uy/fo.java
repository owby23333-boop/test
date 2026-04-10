package com.bytedance.sdk.component.uy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class fo implements Comparable<fo>, Runnable {
    private int mPriority;
    private String name;

    public fo(String str, int i) {
        this.mPriority = 0;
        this.mPriority = i == 0 ? 5 : i;
        this.name = str;
    }

    public fo(String str) {
        this.mPriority = 5;
        this.name = str;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    @Override // java.lang.Comparable
    public int compareTo(fo foVar) {
        if (getPriority() < foVar.getPriority()) {
            return 1;
        }
        return getPriority() >= foVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.name;
    }
}
