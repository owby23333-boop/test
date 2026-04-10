package com.zackratos.ultimatebarx.ultimatebarx.rom;

import android.content.Context;
import com.umeng.analytics.pro.d;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ContextKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseRom.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H%J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0015¨\u0006\t"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/rom/BaseRom;", "Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom;", "()V", "fullScreenGestureOn", "", d.R, "Landroid/content/Context;", "navigationBarExist", "screenIndicatorOn", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseRom implements Rom {
    protected abstract boolean fullScreenGestureOn(Context context);

    protected boolean screenIndicatorOn(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return false;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.rom.Rom
    public boolean navigationBarExist(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (fullScreenGestureOn(context)) {
            return screenIndicatorOn(context);
        }
        return ContextKt.commonNavigationBarExist(context);
    }
}
