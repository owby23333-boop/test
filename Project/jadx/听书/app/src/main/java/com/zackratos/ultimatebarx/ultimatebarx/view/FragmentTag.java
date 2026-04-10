package com.zackratos.ultimatebarx.ultimatebarx.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FragmentTag.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag;", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;", "()V", "navigationBarViewTag", "", "getNavigationBarViewTag", "()Ljava/lang/String;", "statusBarViewTag", "getStatusBarViewTag", "Companion", "Holder", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class FragmentTag implements Tag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String navigationBarViewTag;
    private final String statusBarViewTag;

    private FragmentTag() {
        this.statusBarViewTag = "com.zackratos.ultimatebarx.ultimatebarx_fragment_status_bar";
        this.navigationBarViewTag = "com.zackratos.ultimatebarx.ultimatebarx_fragment_navigation_bar";
    }

    public /* synthetic */ FragmentTag(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FragmentTag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag$Companion;", "", "()V", "instance", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag;", "getInstance", "()Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FragmentTag getInstance() {
            return Holder.INSTANCE.getINSTANCE();
        }
    }

    /* JADX INFO: compiled from: FragmentTag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag$Holder;", "", "()V", "INSTANCE", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag;", "getINSTANCE", "()Lcom/zackratos/ultimatebarx/ultimatebarx/view/FragmentTag;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final FragmentTag INSTANCE = new FragmentTag(null);

        private Holder() {
        }

        public final FragmentTag getINSTANCE() {
            return INSTANCE;
        }
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.view.Tag
    public String getStatusBarViewTag() {
        return this.statusBarViewTag;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.view.Tag
    public String getNavigationBarViewTag() {
        return this.navigationBarViewTag;
    }
}
