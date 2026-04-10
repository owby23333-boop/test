package org.minidns.dnslabel;

/* JADX INFO: compiled from: NonLdhLabel.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends DnsLabel {
    protected e(String str) {
        super(str);
    }

    protected static DnsLabel b(String str) {
        return i.c(str) ? new i(str) : d.c(str) ? new d(str) : new g(str);
    }
}
