package com.bytedance.sdk.openadsdk.core.component.reward.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTBaseVideoActivity f959a;
    private String e;
    private na gc;
    private String m;
    com.bytedance.sdk.openadsdk.core.kb.g.dl z;
    View g = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> dl = Collections.synchronizedMap(new HashMap());
    private long gz = 0;
    private long fo = 0;
    private long uy = 0;
    private long kb = 0;
    private long wp = 0;
    private long i = 0;
    private boolean pf = true;
    private final dl ls = new dl();
    private boolean v = false;

    public interface g {
        void dl(boolean z, long j, long j2, String str, String str2);

        void g(boolean z, long j, long j2, String str, String str2);

        void z(boolean z);

        void z(boolean z, long j, long j2, String str, String str2);

        void z(boolean z, long j, String str, String str2);

        void z(boolean z, String str, String str2);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.g.z$z, reason: collision with other inner class name */
    public interface InterfaceC0156z {
        void z(View view, uy uyVar);

        void z(String str, JSONObject jSONObject);
    }

    public z(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f959a = tTBaseVideoActivity;
    }

    public void z(na naVar, String str, String str2) {
        if (this.v) {
            return;
        }
        this.v = true;
        this.gc = naVar;
        this.m = str;
        gz();
        this.e = str2;
    }

    private void gz() {
        na naVar = this.gc;
        if (naVar == null || naVar.lt() != 4) {
            return;
        }
        this.z = gz.z((Context) this.f959a, this.gc, this.m, false);
    }

    public void z() {
        na naVar;
        if (this.z == null && (naVar = this.gc) != null && naVar.lt() == 4) {
            this.z = gz.z((Context) this.f959a, this.gc, this.m, false);
        }
    }

    public com.bytedance.sdk.openadsdk.core.kb.g.dl g() {
        return this.z;
    }

    public boolean dl() {
        return this.z != null;
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(this.f959a);
            this.z.z();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : this.dl.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().z();
            }
        }
    }

    public void gc() {
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : this.dl.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public void m() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : this.dl.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().g();
            }
        }
        try {
            z(this.e);
        } catch (Throwable th) {
            wp.dl("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    private void z(final String str) {
        e.g(new fo("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z.this.z(3).z(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    wp.dl("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected ls z(int i) {
        return com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z.z(com.bytedance.sdk.openadsdk.core.multipro.aidl.z.z(zw.getContext()).z(i));
    }

    public void z(final g gVar) {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.z;
        if (dlVar == null) {
            return;
        }
        dlVar.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.z.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z() {
                boolean z;
                if (System.currentTimeMillis() - z.this.gz > NativeExpressView.js) {
                    z.this.gz = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.z(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - z.this.uy > NativeExpressView.js) {
                    z.this.uy = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.z(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void g(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - z.this.fo > NativeExpressView.js) {
                    z.this.fo = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.g(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void dl(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - z.this.kb > NativeExpressView.js) {
                    z.this.kb = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.dl(z2, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - z.this.wp > NativeExpressView.js) {
                    z.this.wp = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = z;
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.z(z2, j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - z.this.i > NativeExpressView.js) {
                    z.this.i = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.z(z, str, str2);
                }
            }
        });
    }

    public void z(String str, boolean z) {
        if (this.dl.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.dl.get(str);
            if (dlVar != null) {
                if (z) {
                    dlVar.z(com.bytedance.sdk.openadsdk.core.kb.dl.uy.z(this.gc));
                }
                if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).gz().z(this.pf);
                } else if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gz) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gz) dlVar).m().z(this.pf);
                }
                dlVar.z(eo.js(this.gc), false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = gz.z(this.f959a, str, this.gc, this.m);
        if (z) {
            dlVarZ.z(com.bytedance.sdk.openadsdk.core.kb.dl.uy.z(this.gc));
        }
        if (dlVarZ instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
            ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVarZ).gz().z(this.pf);
        } else if (dlVarZ instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gz) {
            ((com.bytedance.sdk.openadsdk.core.kb.dl.gz) dlVarZ).m().z(this.pf);
        }
        this.dl.put(str, dlVarZ);
        dlVarZ.z(eo.js(this.gc), false);
    }

    public void z(final InterfaceC0156z interfaceC0156z) {
        this.z.z(1, new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.z.3
            @Override // com.bytedance.sdk.openadsdk.core.kb.a.dl.z
            public boolean z(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0156z.z(z.this.g, new uy());
                        z.this.g = null;
                        return true;
                    }
                    if (str2.equals("fullscreen_interstitial_ad") || str2.equals("rewarded_video")) {
                        str3.hashCode();
                        if (str3.equals("click_continue")) {
                            com.bytedance.sdk.openadsdk.core.i.a.g(z.this.gc, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.bytedance.sdk.openadsdk.core.i.a.g(z.this.gc, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void z(View view, InterfaceC0156z interfaceC0156z, uy uyVar) {
        if (this.z != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0156z.z("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0156z.z("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0156z.z("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0156z.z("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0156z.z(view, uyVar);
    }

    public dl e() {
        return this.ls;
    }

    public void z(z.InterfaceC0190z interfaceC0190z) {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(interfaceC0190z);
        }
    }

    public class dl implements DownloadListener {
        private boolean g = true;

        public dl() {
        }

        public void z(boolean z) {
            this.g = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            z(this.g);
            z.this.z(str, true);
            z.this.f959a.z(1);
        }
    }
}
