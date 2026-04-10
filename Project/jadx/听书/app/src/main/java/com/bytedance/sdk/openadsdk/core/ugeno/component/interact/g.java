package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.pf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f1334a = false;
    protected dl dl;
    protected z g;
    private EasyPlayableContainer gc;
    protected final na z;

    public abstract e g();

    protected abstract int z();

    public abstract boolean z(int i, int i2);

    public g(na naVar, z zVar, dl dlVar) {
        this.z = naVar;
        this.g = zVar;
        this.dl = dlVar;
    }

    protected void z(final ViewGroup viewGroup, final View view, final View view2, final boolean z, final boolean z2, final float[] fArr, final com.bytedance.sdk.openadsdk.core.zw.g gVar) {
        final HashMap map = new HashMap();
        map.put("render_type", Integer.valueOf(z()));
        if (viewGroup == null || view == null || view2 == null) {
            map.put("error_code", 102);
            this.dl.z(false, (Map<String, Object>) map);
        } else {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.z(view.getWidth(), view.getHeight())) {
                        boolean[] zArr = {true};
                        pf pfVarZ = g.this.z(zArr, fArr, gVar, view.getWidth(), view.getHeight());
                        if (!zArr[0]) {
                            g.this.z(gVar);
                            return;
                        }
                        g.this.dl.g(g.this.z());
                        if (view2.getParent() != null) {
                            ((ViewGroup) view2.getParent()).removeView(view2);
                        }
                        g.this.gc = new EasyPlayableContainer(zw.getContext(), g.this.g(), pfVarZ, g.this.z);
                        g.this.gc.setTag("easy_pfwv");
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams.gravity = 17;
                        g.this.gc.addView(view2, layoutParams);
                        map.put("container_name", viewGroup.getClass().getName());
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int[] iArr2 = new int[2];
                        viewGroup.getLocationInWindow(iArr2);
                        ViewGroup viewGroup2 = viewGroup;
                        if (viewGroup2 instanceof RelativeLayout) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
                            layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                            g.this.gc.setLayoutParams(layoutParams2);
                            viewGroup.addView(g.this.gc);
                            if (!z) {
                                viewGroup.setClipChildren(false);
                            }
                            if (z2) {
                                map.put("error_code", 105);
                            } else {
                                g.this.dl.z(true, (Map<String, Object>) map);
                                g.this.z(gVar, pfVarZ);
                                return;
                            }
                        } else if (viewGroup2 instanceof FrameLayout) {
                            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                            layoutParams3.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                            g.this.gc.setLayoutParams(layoutParams3);
                            viewGroup.addView(g.this.gc);
                            if (!z) {
                                viewGroup.setClipChildren(false);
                            }
                            if (z2) {
                                map.put("error_code", 105);
                            } else {
                                g.this.dl.z(true, (Map<String, Object>) map);
                                g.this.z(gVar, pfVarZ);
                                return;
                            }
                        }
                        g.this.dl.z(false, (Map<String, Object>) map);
                        return;
                    }
                    map.put("view_width", Integer.valueOf(view.getWidth()));
                    map.put("view_height", Integer.valueOf(view.getHeight()));
                    map.put("error_code", 103);
                    g.this.dl.z(false, (Map<String, Object>) map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pf z(boolean[] zArr, float[] fArr, com.bytedance.sdk.openadsdk.core.zw.g gVar, float f, float f2) {
        pf pfVarZ = gVar != null ? pf.z(gVar.g()) : null;
        if (fArr == null) {
            if (pfVarZ == null) {
                return new pf(0.0d, 0.0d, oq.a(zw.getContext(), f), oq.a(zw.getContext(), f2));
            }
            return pfVarZ;
        }
        final pf pfVarZ2 = z(fArr, f, f2);
        if (pfVarZ == null) {
            return pfVarZ2;
        }
        double dZ = pf.z(pfVarZ, pfVarZ2);
        final double d = pfVarZ2.dl * pfVarZ2.f1189a;
        final double d2 = pfVarZ.dl * pfVarZ.f1189a;
        final pf pfVarG = pf.g(pfVarZ, pfVarZ2);
        final double d3 = pfVarG != null ? pfVarG.dl * pfVarG.f1189a : 0.0d;
        if (gVar != null) {
            gVar.z(new com.bytedance.sdk.openadsdk.core.zw.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g.2
                @Override // com.bytedance.sdk.openadsdk.core.zw.dl
                public JSONObject getMaxRectJson() {
                    return pf.z(pfVarG);
                }

                @Override // com.bytedance.sdk.openadsdk.core.zw.dl
                public double getExceedAreaRate() {
                    double d4 = d2;
                    if (d4 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d <= 0.0d) {
                        return -1.0d;
                    }
                    return (d3 - d4) / d4;
                }

                @Override // com.bytedance.sdk.openadsdk.core.zw.dl
                public JSONObject getActualRectJson() {
                    return pf.z(pfVarZ2);
                }
            });
        }
        if (d2 <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        if (d <= 0.0d) {
            zArr[0] = false;
            return null;
        }
        double d4 = dZ / d;
        boolean z = d4 >= 0.8d;
        com.bytedance.sdk.component.utils.wp.z("xeasy", "A:" + d2 + " B:" + d + " o:" + dZ + " R:" + d4);
        if (z) {
            return pfVarG;
        }
        zArr[0] = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.zw.g gVar, pf pfVar) {
        if (gVar != null) {
            gVar.z(true, pf.z(pfVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.zw.g gVar) {
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.g("xeasy", e.getMessage());
            }
            gVar.z(false, jSONObject);
        }
    }

    private pf z(float[] fArr, float f, float f2) {
        int iA = oq.a(zw.getContext(), f);
        int iA2 = oq.a(zw.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (iA - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        return new pf(f3, f4, f5, (iA2 - f4) - fArr[2] >= 0.0f ? r15 : 0.0f);
    }
}
