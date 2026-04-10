package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Dialog f1273a;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.z dl;
    protected int e;
    protected boolean fo;
    protected na g;
    protected String gc;
    protected int gz;
    private NativeVideoTsView i;
    protected String kb;
    protected int m;
    protected boolean uy;
    public com.bytedance.sdk.openadsdk.core.multipro.g.z wp;
    protected Context z;

    public void b_(int i) {
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    protected abstract void z(View view, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar);

    public BackupView(Context context) {
        super(context);
        this.gc = "embeded_ad";
        this.fo = true;
        this.uy = true;
        this.wp = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
        z();
    }

    private void z() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public na getMeta() {
        return this.g;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.ls.dl.g.e eVar) {
        if (eVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.z) {
            this.dl = (com.bytedance.sdk.openadsdk.core.dislike.ui.z) eVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.f1273a = dialog;
    }

    public void gc() {
        Dialog dialog = this.f1273a;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.dl;
        if (zVar != null) {
            zVar.z();
        } else {
            TTDelegateActivity.z(getContext(), this.g);
        }
    }

    protected String getNameOrSource() {
        na naVar = this.g;
        if (naVar == null) {
            return "";
        }
        if (naVar.c() == null || TextUtils.isEmpty(this.g.c().dl())) {
            return !TextUtils.isEmpty(this.g.hy()) ? this.g.hy() : "";
        }
        return this.g.c().dl();
    }

    protected String getTitle() {
        if (this.g.c() != null && !TextUtils.isEmpty(this.g.c().dl())) {
            return this.g.c().dl();
        }
        if (TextUtils.isEmpty(this.g.hy())) {
            return !TextUtils.isEmpty(this.g.li()) ? this.g.li() : "";
        }
        return this.g.hy();
    }

    protected String getDescription() {
        if (TextUtils.isEmpty(this.g.li())) {
            return !TextUtils.isEmpty(this.g.he()) ? this.g.he() : "";
        }
        return this.g.li();
    }

    public float getRealWidth() {
        return oq.a(this.z, this.m);
    }

    public float getRealHeight() {
        return oq.a(this.z, this.e);
    }

    protected void z(View view, boolean z) {
        final com.bytedance.sdk.openadsdk.core.g.g gVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.z;
            na naVar = this.g;
            String str = this.gc;
            gVar = new com.bytedance.sdk.openadsdk.core.g.z(context, naVar, str, eo.g(str));
        } else {
            Context context2 = this.z;
            na naVar2 = this.g;
            String str2 = this.gc;
            gVar = new com.bytedance.sdk.openadsdk.core.g.g(context2, naVar2, str2, eo.g(str2));
        }
        view.setOnTouchListener(gVar);
        view.setOnClickListener(gVar);
        dl dlVar = new dl() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.dl
            public void z(View view2, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
                try {
                    zwVar.z().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).gc());
                } catch (JSONException unused) {
                }
                BackupView.this.z(view2, i, zwVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.g.z.g.z zVar = (com.bytedance.sdk.openadsdk.core.g.z.g.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.g.z.class);
        if (zVar != null) {
            zVar.z(dlVar);
            zVar.z(z ? 2 : 1);
        }
    }

    protected View z(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.i;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.g != null && this.z != null) {
            if (g()) {
                try {
                    NativeVideoTsView nativeVideoTsViewZ = z(this.z, this.g, this.gc, true, false);
                    this.i = nativeVideoTsViewZ;
                    nativeVideoTsViewZ.setAdCreativeClickListener(new NativeVideoTsView.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.z
                        public void z(View view, int i) {
                            z expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.z(view, i);
                        }
                    });
                    this.i.setVideoCacheUrl(this.kb);
                    this.i.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void z(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            BackupView.this.wp.z = z;
                            BackupView.this.wp.gc = j;
                            BackupView.this.wp.m = j2;
                            BackupView.this.wp.e = j3;
                            BackupView.this.wp.f1272a = z2;
                            BackupView.this.wp.gz = z3;
                        }
                    });
                    this.i.setIsAutoPlay(this.fo);
                    this.i.setIsQuiet(this.uy);
                } catch (Throwable unused) {
                    this.i = null;
                }
            }
            if (g() && (nativeVideoTsView = this.i) != null && nativeVideoTsView.z(0L, true, false)) {
                return this.i;
            }
        }
        return null;
    }

    protected NativeVideoTsView z(Context context, na naVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, naVar, str, z, z2);
    }

    private boolean g() {
        if (a()) {
            return dl();
        }
        na naVar = this.g;
        return naVar != null && na.g(naVar);
    }

    private boolean dl() {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarV;
        na naVar = this.g;
        return (naVar == null || naVar.nh() == 1 || (dlVarV = tf.v(this.g)) == null || TextUtils.isEmpty(dlVarV.wp())) ? false : true;
    }

    private boolean a() {
        return TextUtils.equals(this.gc, "splash_ad") || TextUtils.equals(this.gc, "cache_splash_ad");
    }

    protected void g(int i) {
        this.uy = com.bytedance.sdk.openadsdk.core.zw.g().a(this.gz);
        int iE = com.bytedance.sdk.openadsdk.core.zw.g().e(i);
        if (3 == iE) {
            this.fo = false;
            return;
        }
        if (1 != iE || !com.bytedance.sdk.component.utils.v.a(this.z)) {
            if (2 == iE) {
                if (com.bytedance.sdk.component.utils.v.gc(this.z) || com.bytedance.sdk.component.utils.v.a(this.z) || com.bytedance.sdk.component.utils.v.m(this.z)) {
                    this.fo = true;
                    return;
                }
                return;
            }
            if (5 != iE) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.v.a(this.z) && !com.bytedance.sdk.component.utils.v.m(this.z)) {
                return;
            }
        }
        this.fo = true;
    }

    protected void z(View view) {
        if (tf.v(this.g) == null || view == null) {
            return;
        }
        z(view, this.g.f() == 1 && this.fo);
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.z(this);
    }

    public com.bytedance.sdk.openadsdk.core.multipro.g.z getVideoModel() {
        return this.wp;
    }
}
