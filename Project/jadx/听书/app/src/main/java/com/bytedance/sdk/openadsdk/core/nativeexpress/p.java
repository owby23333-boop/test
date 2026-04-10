package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class p extends com.bytedance.sdk.component.adexpress.g.z<BackupView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.g.dl f1282a;
    private ThemeStatusBroadcastReceiver dl;
    private View g;
    private com.bytedance.sdk.component.adexpress.g.e gc;
    private com.bytedance.sdk.component.adexpress.g.i m;
    private BackupView z;

    public p(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.g.i iVar) {
        this.g = view;
        this.dl = themeStatusBroadcastReceiver;
        this.m = iVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public void z(com.bytedance.sdk.component.adexpress.g.e eVar) {
        this.gc = eVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g();
        } else {
            com.bytedance.sdk.openadsdk.core.q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.p.1
                @Override // java.lang.Runnable
                public void run() {
                    p.this.g();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.bytedance.sdk.component.adexpress.g.dl dlVar = this.f1282a;
        boolean z = false;
        if (dlVar != null && dlVar.z((NativeExpressView) this.g, 0)) {
            z = true;
        }
        if (!z) {
            this.gc.z(107, (String) null);
            return;
        }
        this.m.e().uy();
        BackupView backupView = (BackupView) this.g.findViewWithTag("tt_express_backup_fl_tag_26");
        this.z = backupView;
        if (backupView != null) {
            backupView.setThemeChangeReceiver(this.dl);
            com.bytedance.sdk.component.adexpress.g.v vVar = new com.bytedance.sdk.component.adexpress.g.v();
            BackupView backupView2 = this.z;
            float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
            BackupView backupView3 = this.z;
            float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
            vVar.z(true);
            vVar.z(realWidth);
            vVar.g(realHeight);
            this.gc.z(this.z, vVar);
            return;
        }
        this.gc.z(107, (String) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public BackupView e() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.z
    public void z(com.bytedance.sdk.component.adexpress.g.dl dlVar) {
        this.f1282a = dlVar;
    }
}
