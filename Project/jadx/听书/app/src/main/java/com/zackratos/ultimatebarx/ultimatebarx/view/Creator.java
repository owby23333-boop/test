package com.zackratos.ultimatebarx.ultimatebarx.view;

import android.content.Context;
import android.view.View;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;

/* JADX INFO: compiled from: Creator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/Creator;", "", "getNavigationBarView", "Landroid/view/View;", d.R, "Landroid/content/Context;", "fitWindow", "", "getStatusBarView", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public interface Creator {
    View getNavigationBarView(Context context, boolean fitWindow);

    View getStatusBarView(Context context, boolean fitWindow);
}
