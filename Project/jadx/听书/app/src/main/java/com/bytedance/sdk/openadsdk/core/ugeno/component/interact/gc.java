package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fv;
import com.bytedance.sdk.openadsdk.core.ugeno.express.g;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends g {
    private boolean e;
    private final com.bytedance.sdk.openadsdk.core.zw.g fo;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.a gc;
    private int gz;
    private View m;
    private final e uy;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    protected int z() {
        return 1;
    }

    public gc(na naVar, boolean z, z zVar, dl dlVar) {
        super(naVar, zVar, dlVar);
        this.e = false;
        this.gz = 2;
        this.uy = new e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void g() {
                gc.this.e = true;
                gc.this.gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void dl() {
                gc.this.e = false;
                if (gc.this.m != null) {
                    gc.this.m.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void a() {
                if (sy.z() && gc.this.fo != null) {
                    gc.this.fo.z(gc.this.z);
                }
            }
        };
        this.fo = new com.bytedance.sdk.openadsdk.core.zw.g(naVar);
        this.f1334a = z;
    }

    public boolean dl() {
        return sy.z(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public boolean z(int i, int i2) {
        return sy.m(this.z).z(i, i2);
    }

    public void z(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap map = new HashMap();
            map.put("render_type", Integer.valueOf(z()));
            map.put("error_code", 100);
            this.dl.z(false, (Map<String, Object>) map);
            return;
        }
        String strA = sy.m(this.z).a();
        String strGc = sy.m(this.z).gc();
        this.gz = sy.m(this.z).z();
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z(strGc, strA, new com.bytedance.sdk.openadsdk.core.ugeno.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z(String str) {
                try {
                    gc.this.z(new JSONObject(str), viewGroup, view, z);
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final JSONObject jSONObject, final ViewGroup viewGroup, final View view, final boolean z) {
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectZ;
                if (gc.this.z == null) {
                    return;
                }
                if (gc.this.gz == 3) {
                    jSONObjectZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(gc.this.z, com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(view), jSONObject, gc.this.f1334a, null);
                } else {
                    jSONObjectZ = jSONObject;
                }
                g.z zVar = new g.z();
                zVar.gc(com.bytedance.sdk.openadsdk.core.ugeno.uy.z(gc.this.z, viewGroup, gc.this.f1334a));
                zVar.z(jSONObjectZ);
                zVar.z((iq) new fv());
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                zVar.g(height);
                zVar.z(width);
                zVar.z(com.bytedance.sdk.openadsdk.core.uy.ls().gc());
                zVar.uy(gc.this.z.gc());
                com.bytedance.sdk.openadsdk.core.ugeno.express.g gVarZ = zVar.z();
                if (gc.this.gz == 3) {
                    gc.this.gc = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(zw.getContext(), gc.this.z, gVarZ, viewGroup);
                } else {
                    gc.this.gc = new com.bytedance.sdk.openadsdk.core.ugeno.express.a(zw.getContext(), gc.this.z, gVarZ, viewGroup);
                }
                gc.this.gc.z(new com.bytedance.sdk.component.adexpress.g.gz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.3.1
                    @Override // com.bytedance.sdk.component.adexpress.g.gz
                    public void z(View view2, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                        gc.this.g.z(view2, i, dlVar);
                    }

                    @Override // com.bytedance.sdk.component.adexpress.g.gz
                    public void z(View view2, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
                        gc.this.g.z(view2, i, dlVar);
                    }
                });
                gc.this.gc.z(new gz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gz
                    public void z() {
                        if (gc.this.m != null) {
                            gc.this.m.setVisibility(8);
                            try {
                                if (gc.this.m.getParent() != null) {
                                    ((ViewGroup) gc.this.m.getParent()).removeView(gc.this.m);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                gc.this.dl.z(gc.this.z());
                gc.this.gc.z(new com.bytedance.sdk.component.adexpress.g.e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gc.3.3
                    @Override // com.bytedance.sdk.component.adexpress.g.e
                    public void z(View view2, v vVar) {
                        View childAt;
                        if (view2 == null) {
                            return;
                        }
                        gc.this.m = view2;
                        gc.this.m.setVisibility(8);
                        boolean z2 = false;
                        if ((gc.this.m instanceof ViewGroup) && ((ViewGroup) gc.this.m).getChildCount() > 0 && (childAt = ((ViewGroup) gc.this.m).getChildAt(0)) != null && childAt.getVisibility() == 8) {
                            z2 = true;
                        }
                        gc.this.z(viewGroup, view, gc.this.m, z, z2, gc.this.gc.a(), gc.this.fo);
                        gc.this.gc();
                    }

                    @Override // com.bytedance.sdk.component.adexpress.g.e
                    public void z(int i, String str) {
                        gc.this.g.z(viewGroup);
                        HashMap map = new HashMap();
                        map.put("error_code", Integer.valueOf(i));
                        map.put("error_msg", str);
                        map.put("render_type", Integer.valueOf(gc.this.z()));
                        gc.this.dl.z(false, (Map<String, Object>) map);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        View view = this.m;
        if (view == null || !this.e) {
            return;
        }
        view.setVisibility(0);
    }

    public void a() {
        this.m = null;
        com.bytedance.sdk.openadsdk.core.ugeno.express.a aVar = this.gc;
        if (aVar != null) {
            aVar.kb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g
    public e g() {
        return this.uy;
    }

    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        this.fo.z(gVar);
    }
}
