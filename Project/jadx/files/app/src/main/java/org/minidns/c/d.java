package org.minidns.c;

import java.util.List;

/* JADX INFO: compiled from: DnsServerLookupMechanism.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d extends Comparable<d> {
    List<String> a0();

    String getName();

    int getPriority();

    boolean isAvailable();
}
