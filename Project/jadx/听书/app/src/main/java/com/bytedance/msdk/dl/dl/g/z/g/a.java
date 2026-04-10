package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public void z(final boolean z2, lq lqVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.msdk.dl.dl.g.z.g gVar2) {
        if (lqVar == null || gVar2 == null) {
            return;
        }
        lqVar.g(gVar, new com.bytedance.sdk.openadsdk.tb.z.g.z.m(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.a.1
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
            public void z(int i, String str) {
                gVar2.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.m
            public void z(List<v> list) {
                if (list == null || list.size() == 0) {
                    gVar2.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (v vVar : list) {
                    if (vVar != null) {
                        arrayList.add(new z(vVar, z2));
                    }
                }
                gVar2.z(arrayList);
            }
        });
    }

    private static class z extends com.bytedance.msdk.g.dl {
        com.bytedance.sdk.openadsdk.uf.z.g.z.g fo;
        private v kb;
        com.bytedance.sdk.openadsdk.uf.z.g.z.dl uy;

        @Override // com.bytedance.msdk.g.dl
        public boolean tb() {
            return true;
        }

        z(v vVar, boolean z) {
            Map<String, Object> mapGz;
            Function function = null;
            this.fo = new com.bytedance.sdk.openadsdk.uf.z.g.z.g(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.a.z.1
                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, int i) {
                    if (z.this.m != null) {
                        z.this.m.z(view);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void g(View view, int i) {
                    if (z.this.m != null) {
                        z.this.m.z();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, String str, int i) {
                    if (z.this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                        ((com.bytedance.msdk.api.a.z.dl.a) z.this.m).z(view, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.g
                public void z(View view, float f, float f2) {
                    if (z.this.m instanceof com.bytedance.msdk.api.a.z.dl.a) {
                        ((com.bytedance.msdk.api.a.z.dl.a) z.this.m).z(f, f2);
                    }
                }
            };
            this.uy = new com.bytedance.sdk.openadsdk.uf.z.g.z.dl(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.a.z.2
                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void z() {
                    if (z.this.g != null) {
                        z.this.g.z();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void z(int i, int i2) {
                    if (z.this.g != null) {
                        z.this.g.z(new com.bytedance.msdk.api.z(i, "MediaPlayer inter error code:".concat(String.valueOf(i2))));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void g() {
                    if (z.this.g != null) {
                        z.this.g.g();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void dl() {
                    if (z.this.g != null) {
                        z.this.g.dl();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void a() {
                    if (z.this.g != null) {
                        z.this.g.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void z(long j, long j2) {
                    if (z.this.g != null) {
                        z.this.g.z(j, j2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.uf.z.g.z.dl
                public void gc() {
                    if (z.this.g != null) {
                        z.this.g.gc();
                    }
                }
            };
            this.kb = vVar;
            kb(vVar.g());
            wp(this.kb.dl());
            e(true);
            if (z && (mapGz = vVar.gz()) != null) {
                double dZ = com.bytedance.msdk.z.dl.g.z(mapGz.get("price"));
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：".concat(String.valueOf(dZ)));
                z(dZ <= 0.0d ? 0.0d : dZ);
            }
            this.kb.z(this.fo);
            this.kb.z(this.uy);
            z(MediationConstant.EXTRA_ADID, Long.valueOf(gm()));
            z(MediationConstant.EXTRA_CID, Long.valueOf(pd()));
            Map<String, Object> mapGz2 = this.kb.gz();
            if (mapGz2 != null) {
                a(mapGz2);
                z(MediationConstant.EXTRA_LOG_EXTRA, mapGz2.toString());
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapGz;
            v vVar = this.kb;
            if (vVar == null || (mapGz = vVar.gz()) == null) {
                return null;
            }
            dl(mapGz);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public void kb() {
            v vVar = this.kb;
            if (vVar != null) {
                vVar.a();
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public View fo() {
            v vVar = this.kb;
            if (vVar != null) {
                return vVar.z();
            }
            return null;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            v vVar = this.kb;
            return vVar != null ? com.bytedance.msdk.z.dl.g.dl(vVar.gz()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            v vVar = this.kb;
            if (vVar != null) {
                vVar.gc();
                this.kb = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.kb == null;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            v vVar = this.kb;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.z(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            v vVar = this.kb;
            if (vVar != null) {
                return com.bytedance.msdk.z.dl.g.g(vVar.gz());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.kb.z(activity, zVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.kb.z(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            v vVar = this.kb;
            if (vVar != null) {
                return vVar.z(activity);
            }
            return super.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            v vVar = this.kb;
            if (vVar != null) {
                return vVar.m();
            }
            return super.he();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.kb.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void uy(boolean z) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            v vVar = this.kb;
            if (vVar != null) {
                vVar.z(z);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(dlVar)));
            v vVar = this.kb;
            if (vVar != null) {
                vVar.z(dlVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(gVar)));
            v vVar = this.kb;
            if (vVar != null) {
                vVar.z(gVar);
            }
        }
    }
}
