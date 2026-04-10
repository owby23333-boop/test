package com.bytedance.msdk.api.a;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public boolean dl() {
        return true;
    }

    public fo g() {
        return null;
    }

    public boolean z() {
        return true;
    }

    public static v z(final com.bytedance.msdk.z.dl.dl dlVar) {
        return new v() { // from class: com.bytedance.msdk.api.a.v.1
            @Override // com.bytedance.msdk.api.a.v
            public boolean z() {
                com.bytedance.msdk.z.dl.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    return dlVar2.fo();
                }
                return super.z();
            }

            @Override // com.bytedance.msdk.api.a.v
            public fo g() {
                com.bytedance.msdk.z.dl.a aVarPf;
                com.bytedance.msdk.z.dl.dl dlVar2 = dlVar;
                if (dlVar2 != null && (aVarPf = dlVar2.pf()) != null && aVarPf.z() != 0.0d && aVarPf.g() != 0.0d) {
                    return new fo(aVarPf.z(), aVarPf.g());
                }
                return super.g();
            }

            @Override // com.bytedance.msdk.api.a.v
            public boolean dl() {
                com.bytedance.msdk.z.dl.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    return dlVar2.gz();
                }
                return super.dl();
            }
        };
    }
}
