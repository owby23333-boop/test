package com.drake.statelayout;

import android.view.View;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/drake/statelayout/StatusInfo;", "", "view", "Landroid/view/View;", "tag", "(Landroid/view/View;Ljava/lang/Object;)V", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class StatusInfo {
    private Object tag;
    private View view;

    public static /* synthetic */ StatusInfo copy$default(StatusInfo statusInfo, View view, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            view = statusInfo.view;
        }
        if ((i & 2) != 0) {
            obj = statusInfo.tag;
        }
        return statusInfo.copy(view, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final View getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getTag() {
        return this.tag;
    }

    public final StatusInfo copy(View view, Object tag) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new StatusInfo(view, tag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusInfo)) {
            return false;
        }
        StatusInfo statusInfo = (StatusInfo) other;
        return Intrinsics.areEqual(this.view, statusInfo.view) && Intrinsics.areEqual(this.tag, statusInfo.tag);
    }

    public int hashCode() {
        int iHashCode = this.view.hashCode() * 31;
        Object obj = this.tag;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "StatusInfo(view=" + this.view + ", tag=" + this.tag + ')';
    }

    public StatusInfo(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final View getView() {
        return this.view;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final void setView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view = view;
    }
}
