package com.zackratos.ultimatebarx.ultimatebarx.rom;

import android.content.Context;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;

/* JADX INFO: compiled from: Rom.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom;", "", "navigationBarExist", "", d.R, "Landroid/content/Context;", "Companion", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public interface Rom {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";

    boolean navigationBarExist(Context context);

    /* JADX INFO: compiled from: Rom.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom$Companion;", "", "()V", "KEY_VERSION_EMUI", "", "KEY_VERSION_MIUI", "KEY_VERSION_OPPO", "KEY_VERSION_SMARTISAN", "KEY_VERSION_VIVO", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
        public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
        public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
        public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
        public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";

        private Companion() {
        }
    }
}
