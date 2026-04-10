package com.tramini.plugin.a.g;

/* JADX INFO: loaded from: classes3.dex */
public class d implements Comparable<d> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f19340s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f19341t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f19342u;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return this.f19342u > dVar.f19342u ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d) && (this == obj || this.f19340s.equals(((d) obj).f19340s))) {
            return true;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        try {
            return Integer.parseInt(this.f19340s);
        } catch (Throwable th) {
            th.printStackTrace();
            return super.hashCode();
        }
    }

    public String toString() {
        return d.class.getSimpleName() + " [ id: " + this.f19340s + ", value: " + this.f19341t + ", timeStamp: " + this.f19342u + " ]";
    }
}
