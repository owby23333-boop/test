package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.g.z.z.z;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.qd;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl f1017a;
    private FrameLayout dl;
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.z> e;
    private Handler fo = new Handler(Looper.getMainLooper());
    private na g;
    private com.bytedance.sdk.openadsdk.core.g.z gc;
    private SoftReference<com.bytedance.sdk.openadsdk.ls.dl.z.dl> gz;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl m;
    private Context z;

    public interface z {
        void g();

        Context getActivity();

        void z();

        void z(long j);
    }

    public void z(Context context, na naVar) {
        this.z = context;
        this.g = naVar;
        this.dl = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dl.setLayoutParams(layoutParams);
        qd.g(this.g);
    }

    public ViewGroup z() {
        return this.dl;
    }

    public void z(String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.z zVar, com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.e = new SoftReference<>(zVar);
        if (dlVar != null) {
            this.gz = new SoftReference<>(dlVar);
        }
        HashMap map = new HashMap();
        map.put("splash_show_type", Integer.valueOf(i));
        com.bytedance.sdk.openadsdk.core.g.z zVar2 = new com.bytedance.sdk.openadsdk.core.g.z(this.z, this.g, str, 4);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
        SoftReference<com.bytedance.sdk.openadsdk.ls.dl.z.dl> softReference = this.gz;
        if (softReference == null) {
            z(str, this.dl, null);
        } else {
            z(str, this.dl, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.m);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gz.1
            @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
            public void z(View view, int i2) {
                if (gz.this.e != null && gz.this.e.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.z) gz.this.e.get()).g();
                }
                gz.this.dl();
            }
        });
        this.gc = zVar2;
        dl dlVar2 = this.f1017a;
        if (dlVar2 != null) {
            dlVar2.z(zVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.kb.g.dl z(na naVar, String str) {
        if (naVar.lt() == 4) {
            return com.bytedance.sdk.openadsdk.core.kb.gz.z(this.z, naVar, str, false);
        }
        return null;
    }

    private void z(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        na naVar = this.g;
        if (naVar == null || this.z == null || viewGroup == null) {
            return;
        }
        this.m = z(naVar, str);
        EmptyView emptyView = new EmptyView(this.z, viewGroup, this.g.wk());
        emptyView.z(this.g, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (dlVar != null) {
            z(dlVar);
        }
        emptyView.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gz.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z2) {
                if (gz.this.m != null && z2) {
                    gz.this.m.z();
                }
                gz.this.z(z2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                ViewGroup viewGroup2;
                Context context;
                if (gz.this.m != null) {
                    gz.this.m.z(false);
                }
                if (gz.this.m == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                gz.this.m.z((Activity) context);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
                if (gz.this.m != null) {
                    gz.this.m.g();
                }
            }
        });
    }

    private void z(final com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar2 = this.m;
        if (dlVar2 == null) {
            return;
        }
        dlVar2.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gz.3
            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z() {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.z(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void g(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.g(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void dl(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.dl(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, String str, String str2) {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.z(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(String str, String str2) {
                com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar3 = dlVar;
                if (dlVar3 != null) {
                    dlVar3.z(str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        this.fo.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gz.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.z) {
                    com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.z = false;
                    if (gz.this.m instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                        ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) gz.this.m).gz().z(new com.bytedance.sdk.openadsdk.core.kb.dl.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gz.4.1
                            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.z
                            public void z() {
                                gz.this.g();
                            }
                        });
                        return;
                    }
                    return;
                }
                gz.this.g();
            }
        }, 100L);
    }

    public void z(int i) {
        if (i == 2 && qd.z(this.g)) {
            this.f1017a = new a();
        }
        dl dlVar = this.f1017a;
        if (dlVar != null) {
            dlVar.z(this.z, this.dl, this.g);
            this.f1017a.z(this.gc);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, z zVar) {
        dl dlVar = this.f1017a;
        if (dlVar != null) {
            dlVar.z(aVar, zVar);
        }
    }

    public void g() {
        dl dlVar = this.f1017a;
        if (dlVar != null) {
            dlVar.g();
        }
    }

    public void z(boolean z2) {
        dl dlVar = this.f1017a;
        if (dlVar != null) {
            dlVar.z(z2);
        }
    }
}
