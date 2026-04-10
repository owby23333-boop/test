package com.zackratos.ultimatebarx.ultimatebarx.rom;

import android.content.Context;
import android.provider.Settings;
import com.umeng.analytics.pro.d;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ContextKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MiuiRom.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0015J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0015¨\u0006\b"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/rom/MiuiRom;", "Lcom/zackratos/ultimatebarx/ultimatebarx/rom/BaseRom;", "()V", "fullScreenGestureOn", "", d.R, "Landroid/content/Context;", "screenIndicatorOn", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class MiuiRom extends BaseRom {
    @Override // com.zackratos.ultimatebarx.ultimatebarx.rom.BaseRom
    protected boolean fullScreenGestureOn(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", -1) > 0;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.rom.BaseRom
    protected boolean screenIndicatorOn(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int navigationBarHeight = ContextKt.getNavigationBarHeight(context);
        return navigationBarHeight > 0 && ContextKt.getScreenHeight(context) / navigationBarHeight > 30;
    }
}
