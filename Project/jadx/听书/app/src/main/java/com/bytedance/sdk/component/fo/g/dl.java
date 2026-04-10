package com.bytedance.sdk.component.fo.g;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.e;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.m;
import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import com.bytedance.sdk.component.g.z.z;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends a {
    private boolean fo;
    private com.bytedance.sdk.component.g.z.z gz;
    private Map<String, String> uy;
    public static final com.bytedance.sdk.component.g.z.z z = new z.C0133z().z().g();
    public static final com.bytedance.sdk.component.g.z.z g = new z.C0133z().g();

    public dl(wp wpVar) {
        super(wpVar);
        this.gz = z;
        this.fo = false;
        this.uy = new HashMap();
    }

    public void z(String str, String str2) {
        if (str == null) {
            com.bytedance.sdk.component.fo.a.gc.z("GetExecutor", "name cannot be null !!!");
        } else {
            this.uy.put(str, str2);
        }
    }

    public void z(final com.bytedance.sdk.component.fo.z.z zVar) {
        try {
            v.z zVar2 = new v.z();
            if (this.fo) {
                zVar2.z(this.m);
            } else {
                e.z zVar3 = new e.z();
                Uri uri = Uri.parse(this.m);
                zVar3.z(uri.getScheme());
                zVar3.g(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    zVar3.dl(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.uy.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.uy.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        zVar3.z(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                zVar2.z(zVar3.g());
            }
            z(zVar2);
            zVar2.z(this.gz);
            zVar2.z((Object) g());
            this.dl.z(zVar2.z().g()).z(new com.bytedance.sdk.component.g.z.dl() { // from class: com.bytedance.sdk.component.fo.g.dl.1
                @Override // com.bytedance.sdk.component.g.z.dl
                public void onFailure(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
                    com.bytedance.sdk.component.fo.z.z zVar4 = zVar;
                    if (zVar4 != null) {
                        zVar4.z(dl.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.g.z.dl
                public void onResponse(com.bytedance.sdk.component.g.z.g gVar, ls lsVar) throws IOException {
                    if (zVar != null) {
                        HashMap map = new HashMap();
                        if (lsVar != null) {
                            m mVarE = lsVar.e();
                            if (mVarE != null) {
                                for (int i = 0; i < mVarE.z(); i++) {
                                    map.put(mVarE.z(i), mVarE.g(i));
                                }
                            }
                            p pVarM = lsVar.m();
                            zVar.z(dl.this, new com.bytedance.sdk.component.fo.g(lsVar.a(), lsVar.dl(), lsVar.gc(), map, pVarM == null ? "" : pVarM.g(), lsVar.g(), lsVar.z()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.fo.a.gc.z()) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
            if (zVar != null) {
                zVar.z(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.fo.g.a
    public com.bytedance.sdk.component.fo.g z() {
        try {
            v.z zVar = new v.z();
            String strG = "";
            if (this.fo) {
                zVar.z(this.m);
            } else {
                e.z zVar2 = new e.z();
                Uri uri = Uri.parse(this.m);
                zVar2.z(uri.getScheme());
                zVar2.g(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    zVar2.dl(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.uy.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.uy.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        zVar2.z(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                zVar.z(zVar2.g());
            }
            z(zVar);
            zVar.z(this.gz);
            zVar.z((Object) g());
            ls lsVarG = this.dl.z(zVar.z().g()).g();
            if (lsVarG == null) {
                return null;
            }
            HashMap map = new HashMap();
            m mVarE = lsVarG.e();
            if (mVarE != null) {
                for (int i = 0; i < mVarE.z(); i++) {
                    map.put(mVarE.z(i), mVarE.g(i));
                }
            }
            p pVarM = lsVarG.m();
            if (pVarM != null) {
                strG = pVarM.g();
            }
            return new com.bytedance.sdk.component.fo.g(lsVarG.a(), lsVarG.dl(), lsVarG.gc(), map, strG, lsVarG.g(), lsVarG.z());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }
}
