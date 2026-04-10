package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.p.z;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.sdk.openadsdk.ls.dl.g.v {
    protected Dialog fo;
    protected z gz;
    private Integer[] z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int dl() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int g() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public Map<String, Object> gz() {
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.g.z kb() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.ls.dl.g.a m() {
        return null;
    }

    public abstract na uy();

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public View z() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
    }

    protected void z(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void gc() {
        if (uy() != null) {
            com.bytedance.sdk.openadsdk.core.io.z(uy().dc());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Dialog dialog, Integer[] numArr) {
        this.fo = dialog;
        this.z = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.g.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (g.this.uy() != null) {
                        g gVar = g.this;
                        gVar.z(gVar.uy().ct());
                    }
                }
            });
        } catch (Throwable unused) {
        }
        z(this.fo);
    }

    protected void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        Dialog dialog;
        if (gVar == null || (dialog = this.fo) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.z.g.z(gVar, dialog, this.z);
    }

    protected static class z implements com.bytedance.sdk.openadsdk.core.kb.g.z {
        private String g;
        private WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> z;

        public z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar, String str) {
            this.g = "";
            this.z = new WeakReference<>(zVar);
            this.g = str;
        }

        public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
            this.z = new WeakReference<>(zVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z() {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().z();
            }
            z.C0193z.z(this.g, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().z(j, j2, str, str2);
            }
            if (j > 0) {
                z.C0193z.z(this.g, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void g(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().g(j, j2, str, str2);
            }
            if (j > 0) {
                z.C0193z.z(this.g, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void dl(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().dl(j, j2, str, str2);
            }
            if (j > 0) {
                z.C0193z.z(this.g, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().z(j, str, str2);
            }
            z.C0193z.z(this.g, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.kb.g.z> weakReference = this.z;
            if (weakReference != null && weakReference.get() != null) {
                this.z.get().z(str, str2);
            }
            z.C0193z.z(this.g, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        if (uy() != null) {
            com.bytedance.sdk.openadsdk.core.io.z(uy().dc(), gVar, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        }
    }
}
