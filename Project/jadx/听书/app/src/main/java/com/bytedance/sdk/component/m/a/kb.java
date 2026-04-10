package com.bytedance.sdk.component.m.a;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(final com.bytedance.sdk.component.m.dl.dl dlVar) {
        final com.bytedance.sdk.component.m.dl.m mVarWp = dlVar.wp();
        com.bytedance.sdk.component.m.gc gcVarA = mVarWp.a();
        dlVar.z(false);
        try {
            com.bytedance.sdk.component.m.e eVarCall = gcVarA.call(new com.bytedance.sdk.component.m.g.dl(dlVar.getUrl(), dlVar.m(), dlVar.e(), dlVar.pf()));
            int iG = eVarCall.g();
            dlVar.z(eVarCall.z());
            if (eVarCall.g() == 200) {
                final byte[] bArr = (byte[]) eVarCall.dl();
                dlVar.z(new g(bArr, eVarCall));
                final String rawCacheKey = dlVar.getRawCacheKey();
                final com.bytedance.sdk.component.m.g gVarI = dlVar.i();
                if (gVarI.isRawMemoryCache()) {
                    mVarWp.g(dlVar.i()).z(rawCacheKey, bArr);
                }
                mVarWp.m().submit(new Runnable() { // from class: com.bytedance.sdk.component.m.a.kb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (gVarI.isDiskCache()) {
                            mVarWp.dl(dlVar.i()).z(rawCacheKey, bArr);
                        }
                    }
                });
                return;
            }
            mVarWp.gz();
            String.valueOf(eVarCall);
            Object objDl = eVarCall.dl();
            z(iG, eVarCall.a(), objDl instanceof Throwable ? (Throwable) objDl : null, dlVar);
        } catch (Throwable th) {
            z(1004, "net request failed!", th, dlVar);
        }
    }

    private void z(int i, String str, Throwable th, com.bytedance.sdk.component.m.dl.dl dlVar) {
        dlVar.z(new gz(i, str, th));
    }
}
