package com.bytedance.sdk.component.fo.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.m;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z extends a {
    public z(wp wpVar) {
        super(wpVar);
    }

    public void z(final com.bytedance.sdk.component.fo.z.z zVar) {
        try {
            v.z zVar2 = new v.z();
            zVar2.z((Object) g());
            g(HttpHeaders.RANGE, "bytes=0-");
            if (TextUtils.isEmpty(this.m)) {
                zVar.z(this, new IOException("Url is Empty"));
                return;
            }
            zVar2.z(this.m);
            z(zVar2);
            this.dl.z(zVar2.z().g()).z(new com.bytedance.sdk.component.g.z.dl() { // from class: com.bytedance.sdk.component.fo.g.z.1
                @Override // com.bytedance.sdk.component.g.z.dl
                public void onFailure(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
                    com.bytedance.sdk.component.fo.z.z zVar3 = zVar;
                    if (zVar3 != null) {
                        zVar3.z(z.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.g.z.dl
                public void onResponse(com.bytedance.sdk.component.g.z.g gVar, ls lsVar) throws IOException {
                    int iIntValue;
                    byte[] bArr;
                    InputStream inputStreamDl;
                    if (zVar != null) {
                        HashMap map = new HashMap();
                        if (lsVar != null) {
                            com.bytedance.sdk.component.fo.g gVar2 = new com.bytedance.sdk.component.fo.g(lsVar.a(), lsVar.dl(), lsVar.gc(), map, null, lsVar.g(), lsVar.z());
                            if (lsVar.a()) {
                                InputStream inputStream = null;
                                try {
                                    m mVarE = lsVar.e();
                                    if (mVarE != null) {
                                        for (int i = 0; i < mVarE.z(); i++) {
                                            map.put(mVarE.z(i), mVarE.g(i));
                                        }
                                    }
                                    iIntValue = Long.valueOf(lsVar.m().z()).intValue();
                                    bArr = new byte[iIntValue];
                                    inputStreamDl = lsVar.m().dl();
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    if (inputStreamDl.read(bArr) == iIntValue) {
                                        gVar2.z(bArr);
                                    } else {
                                        gVar2 = new com.bytedance.sdk.component.fo.g(false, lsVar.dl(), "Byte opt fail", map, null, lsVar.g(), lsVar.z());
                                    }
                                    zVar.z(z.this, gVar2);
                                    if (inputStreamDl != null) {
                                        try {
                                            inputStreamDl.close();
                                            return;
                                        } catch (Throwable unused) {
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = inputStreamDl;
                                    try {
                                        com.bytedance.sdk.component.utils.wp.z(th);
                                        zVar.z(z.this, new IOException(th.getMessage()));
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                                return;
                                            } catch (Throwable unused2) {
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable unused3) {
                                            }
                                        }
                                        throw th3;
                                    }
                                }
                            }
                            zVar.z(z.this, gVar2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.bytedance.sdk.component.fo.g.a
    public com.bytedance.sdk.component.fo.g z() {
        InputStream inputStreamDl;
        try {
            v.z zVar = new v.z();
            zVar.z((Object) g());
            g(HttpHeaders.RANGE, "bytes=0-");
            if (TextUtils.isEmpty(this.m)) {
                com.bytedance.sdk.component.utils.wp.a("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            zVar.z(this.m);
            z(zVar);
            ls lsVarG = this.dl.z(zVar.z().g()).g();
            if (lsVarG == null || !lsVarG.a()) {
                return null;
            }
            HashMap map = new HashMap();
            m mVarE = lsVarG.e();
            if (mVarE != null) {
                for (int i = 0; i < mVarE.z(); i++) {
                    map.put(mVarE.z(i), mVarE.g(i));
                }
            }
            long jZ = lsVarG.m().z();
            byte[] bArr = new byte[Long.valueOf(jZ).intValue()];
            inputStreamDl = lsVarG.m().dl();
            try {
                if (inputStreamDl.read(bArr) == jZ) {
                    com.bytedance.sdk.component.fo.g gVar = new com.bytedance.sdk.component.fo.g(lsVarG.a(), lsVarG.dl(), lsVarG.gc(), map, null, lsVarG.g(), lsVarG.z());
                    gVar.z(bArr);
                    if (inputStreamDl != null) {
                        try {
                            inputStreamDl.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return gVar;
                }
                com.bytedance.sdk.component.fo.g gVar2 = new com.bytedance.sdk.component.fo.g(false, lsVarG.dl(), "Byte opt fail", map, null, lsVarG.g(), lsVarG.z());
                if (inputStreamDl != null) {
                    try {
                        inputStreamDl.close();
                    } catch (Throwable unused2) {
                    }
                }
                return gVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    com.bytedance.sdk.component.utils.wp.z(th);
                    if (inputStreamDl != null) {
                        try {
                            inputStreamDl.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (inputStreamDl != null) {
                        try {
                            inputStreamDl.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamDl = null;
        }
    }
}
