package com.zackratos.ultimatebarx.ultimatebarx.extension;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"children", "", "Landroid/view/View;", "getChildren", "(Landroid/view/View;)Ljava/util/List;", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class ViewKt {
    public static final List<View> getChildren(View children) {
        Intrinsics.checkParameterIsNotNull(children, "$this$children");
        ArrayList arrayList = new ArrayList();
        if (children instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) children;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                arrayList.add(child);
                Intrinsics.checkExpressionValueIsNotNull(child, "child");
                arrayList.addAll(getChildren(child));
            }
        }
        return arrayList;
    }
}
