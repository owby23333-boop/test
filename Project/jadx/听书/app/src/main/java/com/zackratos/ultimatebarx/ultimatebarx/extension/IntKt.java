package com.zackratos.ultimatebarx.ultimatebarx.extension;

import kotlin.Metadata;

/* JADX INFO: compiled from: Int.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¨\u0006\b"}, d2 = {"addFlags", "", "flags", "clearFlags", "contain", "", "setFlags", "mask", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class IntKt {
    private static final int setFlags(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static final boolean contain(int i, int i2) {
        return i != clearFlags(i, i2);
    }

    private static final int addFlags(int i, int i2) {
        return setFlags(i, i2, i2);
    }

    private static final int clearFlags(int i, int i2) {
        return setFlags(i, 0, i2);
    }
}
