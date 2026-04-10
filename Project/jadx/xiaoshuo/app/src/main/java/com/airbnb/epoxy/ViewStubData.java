package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/airbnb/epoxy/ViewStubData;", "", "viewGroup", "Landroid/view/ViewGroup;", "viewStub", "Landroid/view/ViewStub;", "position", "", "(Landroid/view/ViewGroup;Landroid/view/ViewStub;I)V", "getPosition", "()I", "getViewGroup", "()Landroid/view/ViewGroup;", "getViewStub", "()Landroid/view/ViewStub;", "removeCurrentView", "", "resetStub", "setView", "view", "Landroid/view/View;", "useStubLayoutParams", "", "epoxy-adapter_release"}, k = 1, mv = {1, 4, 2})
final class ViewStubData {
    private final int position;

    @NotNull
    private final ViewGroup viewGroup;

    @NotNull
    private final ViewStub viewStub;

    public ViewStubData(@NotNull ViewGroup viewGroup, @NotNull ViewStub viewStub, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.viewGroup = viewGroup;
        this.viewStub = viewStub;
        this.position = i;
    }

    private final void removeCurrentView() {
        View childAt = this.viewGroup.getChildAt(this.position);
        if (childAt != null) {
            this.viewGroup.removeView(childAt);
            return;
        }
        throw new IllegalStateException("No view exists at position " + this.position);
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final ViewGroup getViewGroup() {
        return this.viewGroup;
    }

    @NotNull
    public final ViewStub getViewStub() {
        return this.viewStub;
    }

    public final void resetStub() {
        removeCurrentView();
        this.viewGroup.addView(this.viewStub, this.position);
    }

    public final void setView(@NotNull View view, boolean useStubLayoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        removeCurrentView();
        int inflatedId = this.viewStub.getInflatedId();
        if (inflatedId != -1) {
            view.setId(inflatedId);
        }
        if (useStubLayoutParams) {
            this.viewGroup.addView(view, this.position, this.viewStub.getLayoutParams());
        } else {
            this.viewGroup.addView(view, this.position);
        }
    }
}
