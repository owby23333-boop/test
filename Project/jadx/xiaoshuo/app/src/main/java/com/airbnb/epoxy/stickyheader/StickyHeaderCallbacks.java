package com.airbnb.epoxy.stickyheader;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/airbnb/epoxy/stickyheader/StickyHeaderCallbacks;", "", "isStickyHeader", "", "position", "", "setupStickyHeaderView", "", "stickyHeader", "Landroid/view/View;", "teardownStickyHeaderView", "epoxy-adapter_release"}, k = 1, mv = {1, 4, 2})
public interface StickyHeaderCallbacks {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setupStickyHeaderView(@NotNull StickyHeaderCallbacks stickyHeaderCallbacks, @NotNull View stickyHeader) {
            Intrinsics.checkNotNullParameter(stickyHeader, "stickyHeader");
        }

        public static void teardownStickyHeaderView(@NotNull StickyHeaderCallbacks stickyHeaderCallbacks, @NotNull View stickyHeader) {
            Intrinsics.checkNotNullParameter(stickyHeader, "stickyHeader");
        }
    }

    boolean isStickyHeader(int position);

    void setupStickyHeaderView(@NotNull View stickyHeader);

    void teardownStickyHeaderView(@NotNull View stickyHeader);
}
