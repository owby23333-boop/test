package com.zackratos.ultimatebarx.ultimatebarx.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseCreator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/BaseCreator;", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Creator;", "tag", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;", "landscape", "", "(Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;Z)V", "getLandscape", "()Z", "getTag", "()Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseCreator implements Creator {
    private final boolean landscape;
    private final Tag tag;

    public BaseCreator(Tag tag, boolean z) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        this.tag = tag;
        this.landscape = z;
    }

    protected final Tag getTag() {
        return this.tag;
    }

    public /* synthetic */ BaseCreator(Tag tag, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tag, (i & 2) != 0 ? false : z);
    }

    protected final boolean getLandscape() {
        return this.landscape;
    }
}
