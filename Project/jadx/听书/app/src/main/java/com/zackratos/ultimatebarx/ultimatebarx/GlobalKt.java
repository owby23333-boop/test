package com.zackratos.ultimatebarx.ultimatebarx;

import kotlin.Metadata;

/* JADX INFO: compiled from: Global.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"manager", "Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "getManager", "()Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "needApply", "", "getNeedApply", "()Z", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class GlobalKt {
    private static final boolean needApply = true;

    public static final UltimateBarXManager getManager() {
        return UltimateBarXManager.INSTANCE.getInstance();
    }

    public static final boolean getNeedApply() {
        return needApply;
    }
}
