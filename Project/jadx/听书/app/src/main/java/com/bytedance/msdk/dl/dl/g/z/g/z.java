package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.dl.dl.g.z.g.g {
    private com.bytedance.msdk.dl.m.g.g dl;
    private com.bytedance.msdk.api.z.g g;

    public z(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        this.g = gVar2;
        this.dl = gVar;
        if (gVar2 == null) {
            z(new com.bytedance.msdk.api.z("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj != null && ((Integer) obj).intValue() == 4) {
                Object obj2 = map.get("tt_ad_origin_type");
                if (obj2 != null) {
                    int iIntValue = ((Integer) obj2).intValue();
                    if (iIntValue == 1) {
                        g(context.getApplicationContext());
                        return;
                    } else if (iIntValue == 2) {
                        dl(context.getApplicationContext());
                        return;
                    } else {
                        z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch"));
                        return;
                    }
                }
                return;
            }
            new dl().z(context.getApplicationContext());
        }
    }

    private void g(final Context context) {
        lq lqVarZ = z(context);
        if (lqVarZ == null) {
            return;
        }
        g.z zVarG = com.bytedance.msdk.z.dl.g.z(this.g, this.dl.wp(), this.dl.ls(), this.dl.p(), this.dl.uf(), false).z(this.g.uf()).g(this.g.sy());
        float fV = this.g.v();
        float fPf = this.g.pf();
        boolean z = com.bytedance.msdk.z.dl.g.z(this.g);
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native express autoHeight:" + z + " width:" + fV + "  height:" + fPf);
        if (fPf > 0.0f && !z) {
            zVarG.z(fV).g(fPf);
        } else {
            zVarG.z(fV).g(0.0f);
        }
        lqVarZ.z(zVarG.z(), new com.bytedance.sdk.openadsdk.tb.z.g.z.m(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.1
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
            public void z(int i, String str) {
                z.this.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
            public void z(List<v> list) {
                if (list == null || list.size() == 0) {
                    z.this.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                for (v vVar : list) {
                    if (vVar != null) {
                        z.this.new g(context, vVar).kb();
                        return;
                    }
                }
            }
        });
    }

    private void dl(final Context context) {
        lq lqVarZ = z(context);
        if (lqVarZ == null) {
            return;
        }
        g.z zVarZ = com.bytedance.msdk.z.dl.g.z(this.g, this.dl.wp(), this.dl.ls(), this.dl.p(), this.dl.uf(), false);
        zVarZ.z(this.g.uf()).g(this.g.sy());
        lqVarZ.z(zVarZ.z(), new com.bytedance.sdk.openadsdk.tb.z.g.z.dl(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.2
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.dl
            public void z(int i, String str) {
                z.this.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.dl
            public void z(List<com.bytedance.sdk.openadsdk.ls.dl.g.uy> list) {
                if (list == null || list.isEmpty()) {
                    z.this.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(z.this.new C0097z(context, list.get(0)));
                z.this.z(arrayList);
            }
        });
    }

    class g extends com.bytedance.msdk.g.dl {
        v fo;
        private final com.bytedance.sdk.openadsdk.uf.z.g.z.g i;
        private boolean kb;
        private volatile boolean wp = false;

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.z.g.z qz() {
            return (com.bytedance.msdk.z.g.z) this.e;
        }

        g(Context context, v vVar) {
            Map<String, Object> mapGz;
            Function function = null;
            com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar = new com.bytedance.sdk.openadsdk.uf.z.g.z.g(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.g.3
                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, int i) {
                    if (g.this.e instanceof com.bytedance.msdk.z.g.z) {
                        g.this.qz().z(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void g(View view, int i) {
                    if (g.this.e instanceof com.bytedance.msdk.z.g.z) {
                        g.this.qz().g(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, String str, int i) {
                    z.this.z(new com.bytedance.msdk.api.z(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, float f, float f2) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(g.this);
                    z.this.z(arrayList);
                }
            };
            this.i = gVar;
            this.fo = vVar;
            kb(vVar.g());
            wp(this.fo.dl());
            e(true);
            this.fo.z(gVar);
            if (context instanceof Activity) {
                this.fo.z((Activity) context, new com.bytedance.sdk.openadsdk.js.z.g.z.z(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.g.1
                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void g() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z(int i, String str, boolean z) {
                        if (g.this.kb) {
                            return;
                        }
                        g.this.kb = true;
                        if (g.this.e instanceof com.bytedance.msdk.z.g.z) {
                            com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                            g.this.qz().f_();
                        }
                    }
                });
            }
            if (!z.this.dl.z() || (mapGz = this.fo.gz()) == null) {
                return;
            }
            double dZ = com.bytedance.msdk.z.dl.g.z(mapGz.get("price"));
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(dZ)));
            z(dZ <= 0.0d ? 0.0d : dZ);
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapGz;
            v vVar = this.fo;
            if (vVar == null || (mapGz = vVar.gz()) == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "getMediaExtraInfo ".concat(String.valueOf(mapGz)));
            dl(mapGz);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public void kb() {
            v vVar = this.fo;
            if (vVar != null) {
                vVar.a();
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public View fo() {
            v vVar = this.fo;
            if (vVar != null) {
                return vVar.z();
            }
            return null;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            v vVar = this.fo;
            return vVar != null ? com.bytedance.msdk.z.dl.g.dl(vVar.gz()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            this.wp = true;
            com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.fo != null) {
                        g.this.fo.gc();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.wp;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            v vVar = this.fo;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.z(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            v vVar = this.fo;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.g(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, final com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.fo != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.fo.z(activity, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.g.4
                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z(int i, String str, boolean z) {
                        if (g.this.kb) {
                            return;
                        }
                        g.this.kb = true;
                        com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z(i, str, z);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void g() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.g();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.fo != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.fo.z(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            v vVar = this.fo;
            if (vVar != null) {
                return vVar.z(activity);
            }
            return super.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            v vVar = this.fo;
            if (vVar != null) {
                return vVar.m();
            }
            return super.he();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(dlVar)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(dlVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(dlVar)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(dlVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(gVar)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(gVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.dl.dl.g.z.g.z$z, reason: collision with other inner class name */
    class C0097z extends com.bytedance.msdk.g.dl {
        private boolean i;
        private com.bytedance.sdk.openadsdk.ls.dl.g.uy kb;
        private Context wp;
        private volatile boolean v = false;
        com.bytedance.sdk.openadsdk.io.z.g.z.z fo = new com.bytedance.sdk.openadsdk.io.z.g.z.z(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.z.3
            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(View view, i iVar) {
                if (C0097z.this.e instanceof com.bytedance.msdk.z.g.z) {
                    C0097z.this.qz().z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void g(View view, i iVar) {
                if (C0097z.this.e instanceof com.bytedance.msdk.z.g.z) {
                    C0097z.this.qz().z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(i iVar) {
                if (C0097z.this.e instanceof com.bytedance.msdk.z.g.z) {
                    C0097z.this.qz().g(null);
                }
            }
        };

        @Override // com.bytedance.msdk.g.dl
        public boolean tb() {
            return true;
        }

        C0097z(Context context, com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
            Map<String, Object> mapIq;
            this.kb = uyVar;
            this.wp = context;
            com.bytedance.sdk.openadsdk.ls.dl.g.dl dlVarJs = uyVar.js();
            if (dlVarJs != null) {
                iq(dlVarJs.z());
                zw(dlVarJs.dl());
                uf(dlVarJs.a());
                sy(dlVarJs.g());
                HashMap map = new HashMap();
                Map<String, String> mapGc = dlVarJs.gc();
                if (mapGc != null && mapGc.size() > 0) {
                    map.putAll(mapGc);
                }
                gc(map);
                if (com.bytedance.msdk.z.dl.g.z("5.4.0.3")) {
                    wp(dlVarJs.e());
                }
                if (com.bytedance.msdk.z.dl.g.z("6.8.1.6")) {
                    uy(dlVarJs.gz());
                }
                kb(dlVarJs.fo());
            }
            x(uyVar.e());
            lq(uyVar.gz());
            h(uyVar.fo());
            hh(uyVar.v() != null ? uyVar.v().dl() : null);
            kb(uyVar.p());
            wp(uyVar.ls());
            mc(uyVar.i());
            a(uyVar.uy());
            gz(uyVar.ls() == 4);
            e(false);
            if (uyVar.p() == 16 || uyVar.p() == 3 || uyVar.p() == 2 || uyVar.p() == 131) {
                if (uyVar.pf() != null && !uyVar.pf().isEmpty() && uyVar.pf().get(0) != null) {
                    com.bytedance.sdk.openadsdk.ls.dl.g.wp wpVar = uyVar.pf().get(0);
                    l(wpVar.dl());
                    js(wpVar.z());
                    fv(wpVar.g());
                }
            } else if (uyVar.p() == 4 && uyVar.pf() != null && uyVar.pf().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.wp> it = uyVar.pf().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().dl());
                }
                z((List<String>) arrayList);
            }
            kb(uyVar.p());
            if (!z.this.dl.z() || (mapIq = uyVar.iq()) == null) {
                return;
            }
            double dZ = com.bytedance.msdk.z.dl.g.z(mapIq.get("price"));
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dZ)));
            z(dZ <= 0.0d ? 0.0d : dZ);
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapIq;
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar == null || (mapIq = uyVar.iq()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapIq.get("coupon"));
            map.put("live_room", mapIq.get("live_room"));
            map.put("product", mapIq.get("product"));
            dl(map);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar2;
            View viewQ;
            View viewFindViewById;
            super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar3 = this.kb;
            if (uyVar3 != null) {
                uyVar3.z(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.fo);
                this.kb.z(activity, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.z.1
                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void g() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z(int i, String str, boolean z) {
                        if (C0097z.this.i) {
                            return;
                        }
                        C0097z.this.i = true;
                        if (C0097z.this.e instanceof com.bytedance.msdk.z.g.z) {
                            com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                            C0097z.this.qz().f_();
                        }
                    }
                });
            }
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar4 = this.kb;
            if (uyVar4 != null && uyVar4.m() != null && uyVar != null && (viewFindViewById = viewGroup.findViewById(uyVar.wp)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.wp);
                    imageView.setImageBitmap(this.kb.m());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.api.gc.dl(this.wp, 38.0f);
                    layoutParams.height = com.bytedance.msdk.api.gc.dl(this.wp, 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.kb.m());
                }
            }
            if (uyVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(uyVar.e)) == null || (uyVar2 = this.kb) == null || (viewQ = uyVar2.q()) == null) {
                return;
            }
            g(viewQ);
            frameLayout.removeAllViews();
            frameLayout.addView(viewQ, -1, -1);
        }

        @Override // com.bytedance.msdk.g.dl
        public int jz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                return uyVar.dl();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public int oz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                return uyVar.a();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            this.v = true;
            com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.z.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0097z.this.kb != null) {
                        C0097z.this.kb.z((com.bytedance.sdk.openadsdk.iq.z.g.z.z) null);
                        C0097z.this.kb.z((com.bytedance.sdk.openadsdk.ls.dl.z.g) null);
                        C0097z.this.kb.io();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.v;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            return uyVar != null ? com.bytedance.msdk.z.dl.g.dl(uyVar.iq()) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.z.g.z qz() {
            return (com.bytedance.msdk.z.g.z) this.e;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                return com.bytedance.msdk.z.dl.g.z(uyVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                return com.bytedance.msdk.z.dl.g.g(uyVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, final com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.kb.z(activity, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.z.4
                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z(int i, String str, boolean z) {
                        if (C0097z.this.i) {
                            return;
                        }
                        C0097z.this.i = true;
                        com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z(i, str, z);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void g() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.g();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                if (dialog instanceof TTDislikeDialogAbstract) {
                    this.kb.g(dialog, numArr);
                }
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.kb.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Dialog dialog, Integer[] numArr) {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.kb.z(dialog, numArr);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native : getDislikeInfo");
            return this.kb.fv();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                uyVar.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(gVar)));
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.kb;
            if (uyVar != null) {
                uyVar.z(gVar);
            }
        }
    }

    class dl extends com.bytedance.msdk.g.dl {
        v fo;
        private boolean i;
        SoftReference<FrameLayout> uy;
        private boolean v;
        final Object kb = new Object();
        private volatile boolean pf = false;
        private final com.bytedance.sdk.openadsdk.uf.z.g.z.g ls = new com.bytedance.sdk.openadsdk.uf.z.g.z.g(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.dl.4
            @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
            public void z(View view, int i) {
                if (dl.this.e instanceof com.bytedance.msdk.z.g.z) {
                    dl.this.qz().z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
            public void g(View view, int i) {
                if (dl.this.e instanceof com.bytedance.msdk.z.g.z) {
                    dl.this.qz().g(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
            public void z(View view, String str, int i) {
                dl.this.v = false;
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_banner", com.bytedance.msdk.z.gc.gc.g(z.this.dl.g(), z.this.dl.wp()) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
            public void z(View view, float f, float f2) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_banner", com.bytedance.msdk.z.gc.gc.g(z.this.dl.g(), z.this.dl.wp()) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + dl.this.uy);
                if (dl.this.uy != null) {
                    FrameLayout frameLayout = dl.this.uy.get();
                    if (frameLayout != null) {
                        com.bytedance.msdk.api.gc.z(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    dl.this.v = true;
                }
            }
        };

        dl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.z.g.z qz() {
            return (com.bytedance.msdk.z.g.z) this.e;
        }

        public void z(final Context context) {
            lq lqVarZ = z.this.z(context);
            if (lqVarZ == null) {
                return;
            }
            g.z zVarZ = com.bytedance.msdk.z.dl.g.z(z.this.g, z.this.dl.wp(), z.this.dl.ls(), z.this.dl.p(), z.this.dl.uf(), false);
            float fV = z.this.g.v();
            zVarZ.z(fV).g(z.this.g.pf());
            lqVarZ.dl(zVarZ.z(), new com.bytedance.sdk.openadsdk.tb.z.g.z.m(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.dl.1
                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
                public void z(int i, String str) {
                    z.this.z(new com.bytedance.msdk.api.z(i, str));
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
                public void z(List<v> list) {
                    Map<String, Object> mapGz;
                    if (list == null || list.size() == 0 || context == null) {
                        z.this.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                        return;
                    }
                    dl.this.fo = list.get(0);
                    if (context instanceof Activity) {
                        dl.this.fo.z((Activity) context, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.dl.1.1
                            @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                            public void g() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                            public void z() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                            public void z(int i, String str, boolean z) {
                                if (dl.this.i) {
                                    return;
                                }
                                dl.this.i = true;
                                if (dl.this.e instanceof com.bytedance.msdk.z.g.z) {
                                    com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                                    dl.this.qz().f_();
                                }
                            }
                        });
                    }
                    dl.this.e(true);
                    dl dlVar = dl.this;
                    dlVar.wp(dlVar.fo.dl());
                    dl dlVar2 = dl.this;
                    dlVar2.kb(dlVar2.fo.g());
                    if (z.this.dl.z() && (mapGz = dl.this.fo.gz()) != null) {
                        double dZ = com.bytedance.msdk.z.dl.g.z(mapGz.get("price"));
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", com.bytedance.msdk.z.gc.gc.g(z.this.dl.g(), z.this.dl.wp()) + "pangle banner 返回的 cpm价格：" + dZ);
                        dl dlVar3 = dl.this;
                        if (dZ <= 0.0d) {
                            dZ = 0.0d;
                        }
                        dlVar3.z(dZ);
                    }
                    dl.this.fo.z(dl.this.ls);
                    dl.this.uy = new SoftReference<>(new FrameLayout(context));
                    dl.this.fo.a();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(dl.this);
                    z.this.z(arrayList);
                }
            });
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapGz;
            v vVar = this.fo;
            if (vVar == null || (mapGz = vVar.gz()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapGz.get("coupon"));
            map.put("live_room", mapGz.get("live_room"));
            map.put("product", mapGz.get("product"));
            dl(map);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            v vVar = this.fo;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.z(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            v vVar = this.fo;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.g(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            v vVar = this.fo;
            return vVar != null ? com.bytedance.msdk.z.dl.g.dl(vVar.gz()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public synchronized View fo() {
            SoftReference<FrameLayout> softReference = this.uy;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.kb) {
                if (frameLayout == null) {
                    try {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        long j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS + jUptimeMillis;
                        while (!this.v && jUptimeMillis < j) {
                            this.kb.wait(j - jUptimeMillis);
                            jUptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            this.pf = true;
            com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (dl.this.fo != null) {
                        dl.this.fo.z((com.bytedance.sdk.openadsdk.uf.z.g.z.z) null);
                        dl.this.fo.gc();
                    }
                }
            });
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.pf;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, final com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.fo != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.fo.z(activity, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.z.dl.3
                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void z(int i, String str, boolean z) {
                        if (dl.this.i) {
                            return;
                        }
                        dl.this.i = true;
                        com.bytedance.msdk.core.g.z.z(z.this.dl.g());
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.z(i, str, z);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                    public void g() {
                        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                        if (zVar2 != null) {
                            zVar2.g();
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.fo != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.fo.z(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            if (this.fo == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.fo.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            if (this.fo == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : getDislikeInfo");
            return this.fo.m();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(gVar)));
            v vVar = this.fo;
            if (vVar != null) {
                vVar.z(gVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void zw(int i) {
            if (this.fo != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i)));
                this.fo.z(i);
            }
        }
    }
}
