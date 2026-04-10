package com.bytedance.sdk.gromore.z.z.e.gc;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.msdk.dl.a.wp;
import com.bytedance.sdk.gromore.z.z.gc.a;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends pf {
    private com.bytedance.sdk.openadsdk.sy.z.g.z.z dl;
    private com.bytedance.sdk.openadsdk.sy.z.g.z.z g;
    private wp z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public long a() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public int dl() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    public z(wp wpVar) {
        this.z = wpVar;
        m();
    }

    private void m() {
        wp wpVar = this.z;
        if (wpVar == null) {
            return;
        }
        wpVar.z(new com.bytedance.msdk.api.a.z.gz.z() { // from class: com.bytedance.sdk.gromore.z.z.e.gc.z.1
            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.z zVar) {
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void i_() {
                if (z.this.g != null) {
                    z.this.g.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void j_() {
                if (z.this.g != null) {
                    z.this.g.g();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void dl() {
                if (z.this.g != null) {
                    z.this.g.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void a() {
                if (z.this.g != null) {
                    z.this.g.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void gc() {
                if (z.this.g != null) {
                    z.this.g.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                z zVar2 = z.this;
                zVar2.z(zVar, zVar2.g, "CSJMRewardAd normal");
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void m() {
                if (z.this.g != null) {
                    z.this.g.m();
                }
            }
        });
        this.z.g(new com.bytedance.msdk.api.a.z.gz.z() { // from class: com.bytedance.sdk.gromore.z.z.e.gc.z.2
            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.z zVar) {
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void i_() {
                if (z.this.dl != null) {
                    z.this.dl.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void j_() {
                if (z.this.dl != null) {
                    z.this.dl.g();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void dl() {
                if (z.this.dl != null) {
                    z.this.dl.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void a() {
                if (z.this.dl != null) {
                    z.this.dl.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void gc() {
                if (z.this.dl != null) {
                    z.this.dl.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                z zVar2 = z.this;
                zVar2.z(zVar, zVar2.dl, "CSJMRewardAd play again");
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void m() {
                if (z.this.dl != null) {
                    z.this.dl.m();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.msdk.api.dl.z zVar, com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar2, String str) {
        Bundle bundle;
        String str2;
        a.z(zVar, str);
        if (zVar2 == null || zVar == null) {
            return;
        }
        boolean z = zVar.z();
        float fG = zVar.g();
        String strDl = zVar.dl();
        Map<String, Object> mapA = zVar.a();
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        Object obj = mapA.get(MediationConstant.KEY_REWARD_TYPE);
        int iIntValue = 0;
        int iIntValue2 = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = mapA.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, strDl);
        bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, fG);
        Object obj3 = mapA.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj3 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj3).booleanValue());
        }
        Object obj4 = mapA.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = mapA.get(MediationConstant.KEY_REASON);
        if (obj5 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj5).intValue());
        }
        Object obj6 = mapA.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = mapA.get(MediationConstant.KEY_ERROR_CODE);
        if (obj7 instanceof Integer) {
            Integer num = (Integer) obj7;
            iIntValue = num.intValue();
            bundle.putInt(MediationConstant.KEY_ERROR_CODE, num.intValue());
        }
        Object obj8 = mapA.get(MediationConstant.KEY_ERROR_MSG);
        if (obj8 instanceof String) {
            String str3 = (String) obj8;
            bundle.putString(MediationConstant.KEY_ERROR_MSG, str3);
            str2 = str3;
        } else {
            str2 = "";
        }
        Object obj9 = mapA.get(MediationConstant.KEY_ADN_NAME);
        if (obj9 instanceof String) {
            bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj9);
        }
        Object obj10 = mapA.get(MediationConstant.KEY_ECPM);
        if (obj10 instanceof String) {
            bundle.putString(MediationConstant.KEY_ECPM, (String) obj10);
        }
        zVar2.z(z, iIntValue2, bundle);
        if (com.bytedance.msdk.z.dl.g.z("6.4.0.0")) {
            zVar2.z(z, (int) fG, strDl != null ? strDl : "", iIntValue, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void g(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        this.dl = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar) {
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.gc.z.3
                @Override // com.bytedance.msdk.api.a.z.g
                public void g() {
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z() {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z();
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, int i, int i2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.g(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void g(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.dl(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(Activity activity) {
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(Activity activity, Object obj, String str) {
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public int z() {
        wp wpVar = this.z;
        if (wpVar != null) {
            return wpVar.p();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public Map<String, Object> g() {
        wp wpVar = this.z;
        if (wpVar != null) {
            return wpVar.fv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public m gc() {
        return new com.bytedance.sdk.gromore.z.z.gc.z(new g(this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z(gVar);
        }
    }
}
