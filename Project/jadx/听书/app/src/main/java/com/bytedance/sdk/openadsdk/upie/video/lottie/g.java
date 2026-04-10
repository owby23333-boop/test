package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.upie.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bykv.vk.openvk.component.video.api.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1480a;
    private final int dl;
    private final com.bykv.vk.openvk.component.video.api.z fo;
    private final int g;
    private final com.bykv.vk.openvk.component.video.api.renderview.g kb;
    private long m;
    private LottieAnimationView wp;
    private final String z = "UpieVideoPlayer";
    private int gc = 0;
    private volatile boolean e = false;
    private volatile boolean gz = false;
    private final Map<z.InterfaceC0029z, z.InterfaceC0029z> uy = new ConcurrentHashMap();

    static /* synthetic */ int z(g gVar) {
        int i = gVar.gc;
        gVar.gc = i + 1;
        return i;
    }

    public g(com.bykv.vk.openvk.component.video.api.z zVar, com.bytedance.sdk.openadsdk.upie.z zVar2, com.bykv.vk.openvk.component.video.api.renderview.g gVar) {
        this.fo = zVar;
        this.g = zVar2.a();
        this.dl = zVar2.gc();
        this.kb = gVar;
        if (gVar instanceof UpieVideoView) {
            this.wp = ((UpieVideoView) gVar).getLottieAnimationView();
        }
        z(zVar2.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.z.g.dl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.1
                @Override // java.lang.Runnable
                public void run() {
                    String strZ = com.bytedance.sdk.openadsdk.upie.g.z().z(str);
                    if (!TextUtils.isEmpty(strZ)) {
                        wp.z("UpieVideoPlayer", "--==-- lottie use cache ok");
                        g.this.z(strZ, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.g.z().z(str, new g.z<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.1.1
                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(String str2) {
                                wp.z("UpieVideoPlayer", "--==-- lottie load jsonStr ok");
                                g.this.z(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(int i, String str2) {
                                wp.z("UpieVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    g.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, i, str2));
                                    return;
                                }
                                g.z(g.this);
                                if (g.this.gc <= 3) {
                                    g.this.z(str);
                                } else {
                                    g.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bykv.vk.openvk.component.video.api.dl.g gVar) {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f1480a) {
                    return;
                }
                g.this.f1480a = true;
                wp.z("UpieVideoPlayer", "--==--play err, code: " + gVar.z() + ", extra: " + gVar.g() + ", msg: " + gVar.dl());
                Iterator it = g.this.uy.entrySet().iterator();
                while (it.hasNext()) {
                    ((z.InterfaceC0029z) ((Map.Entry) it.next()).getKey()).z(g.this, gVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.e = true;
                if (g.this.wp != null) {
                    g.this.wp.z(str, str2);
                }
                g.this.tb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.4
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.gz && g.this.e) {
                    g.this.fo.g();
                    if (g.this.wp != null) {
                        g.this.wp.z();
                        if (g.this.m > 0) {
                            g gVar = g.this;
                            gVar.g(gVar.m);
                        }
                    }
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(a aVar) {
        wp.z("UpieVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(aVar)));
        this.fo.z(aVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z) {
        wp.z("UpieVideoPlayer", "--==--isMute: ".concat(String.valueOf(z)));
        this.fo.z(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(int i) {
        wp.z("UpieVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
        this.fo.z(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z, long j, boolean z2) {
        wp.z("UpieVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.fo.z(z, j, z2);
        this.m = j;
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).z();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z() {
        wp.z("UpieVideoPlayer", "--==--restart");
        this.fo.z();
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.wp.setProgress(0.0f);
            this.wp.z();
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).z();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g() {
        wp.z("UpieVideoPlayer", "--==--play");
        this.fo.g();
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.g();
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).z();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl() {
        wp.z("UpieVideoPlayer", "--==--pause");
        this.fo.dl();
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.e();
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).g();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void a() {
        wp.z("UpieVideoPlayer", "--==--stop");
        this.fo.a();
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.e();
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).g();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void gc() {
        wp.z("UpieVideoPlayer", "--==--release");
        this.fo.gc();
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.kb;
        if (gVar instanceof UpieVideoView) {
            ((UpieVideoView) gVar).g();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(long j) {
        wp.z("UpieVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.fo.z(j);
        g(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = fv();
            }
            if (duration > 0) {
                this.wp.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean m() {
        return this.fo.m();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(boolean z) {
        this.fo.g(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceHolder surfaceHolder) {
        this.fo.z(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceHolder e() {
        return this.fo.e();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceTexture surfaceTexture) {
        this.fo.z(surfaceTexture);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceTexture gz() {
        return this.fo.gz();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean fo() {
        boolean z = !this.f1480a && this.fo.fo();
        wp.z("UpieVideoPlayer", "--==--isCompleted: " + z + ",      errorInvoked: " + this.f1480a);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean uy() {
        boolean z = !this.f1480a && this.fo.uy();
        wp.z("UpieVideoPlayer", "--==--isStarted: " + z + ",      errorInvoked: " + this.f1480a);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int kb() {
        return this.g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int wp() {
        return this.dl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean i() {
        boolean z = !this.f1480a && this.fo.i();
        wp.z("UpieVideoPlayer", "--==--isPlaying: " + z + ",      errorInvoked: " + this.f1480a);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean v() {
        boolean z = !this.f1480a && this.fo.v();
        wp.z("UpieVideoPlayer", "--==--isPaused: " + z + ",      errorInvoked: " + this.f1480a);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean pf() {
        boolean z = !this.f1480a && this.fo.pf();
        wp.z("UpieVideoPlayer", "--==--isReleased: " + z + ",      errorInvoked: " + this.f1480a);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long ls() {
        return this.fo.ls();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int p() {
        return this.fo.p();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long fv() {
        return this.fo.fv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long js() {
        return this.fo.js();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl(boolean z) {
        this.fo.dl(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final z.InterfaceC0029z interfaceC0029z) {
        if (interfaceC0029z == null) {
            return;
        }
        z.InterfaceC0029z interfaceC0029z2 = new z.InterfaceC0029z() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.5
            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar) {
                interfaceC0029z.z(g.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, final long j) {
                com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC0029z.z(g.this, j);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar) {
                com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.g.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gz = true;
                        if (!g.this.e) {
                            g.this.fo.dl();
                        }
                        interfaceC0029z.g(g.this);
                        g.this.tb();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, com.bykv.vk.openvk.component.video.api.dl.g gVar) {
                g.this.z(gVar);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, boolean z) {
                interfaceC0029z.z(g.this, z);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void dl(com.bykv.vk.openvk.component.video.api.z zVar) {
                interfaceC0029z.dl(g.this);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2) {
                z.InterfaceC0029z interfaceC0029z3 = interfaceC0029z;
                g gVar = g.this;
                interfaceC0029z3.z((com.bykv.vk.openvk.component.video.api.z) gVar, gVar.g, g.this.dl);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2, int i3) {
                interfaceC0029z.z(g.this, i, i2, i3);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
                interfaceC0029z.z((com.bykv.vk.openvk.component.video.api.z) g.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
                interfaceC0029z.g(g.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j, long j2) {
                interfaceC0029z.z(g.this, j, j2);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, JSONObject jSONObject, String str) {
                interfaceC0029z.z(g.this, jSONObject, str);
            }
        };
        this.uy.put(interfaceC0029z, interfaceC0029z2);
        this.fo.z(interfaceC0029z2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(int i) {
        this.fo.g(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(float f) {
        this.fo.z(f);
        LottieAnimationView lottieAnimationView = this.wp;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }
}
