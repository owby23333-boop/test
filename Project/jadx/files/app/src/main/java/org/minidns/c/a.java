package org.minidns.c;

import java.util.logging.Logger;

/* JADX INFO: compiled from: AbstractDnsServerLookupMechanism.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected static final Logger f21379u = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f21380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f21381t;

    protected a(String str, int i2) {
        this.f21380s = str;
        this.f21381t = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(d dVar) {
        return Integer.compare(getPriority(), dVar.getPriority());
    }

    @Override // org.minidns.c.d
    public final String getName() {
        return this.f21380s;
    }

    @Override // org.minidns.c.d
    public final int getPriority() {
        return this.f21381t;
    }
}
