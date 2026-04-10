package com.bytedance.sdk.component.fo.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.gc;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.m;
import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends a {
    pf z;

    public gc(wp wpVar) {
        super(wpVar);
        this.z = null;
    }

    public void dl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.z = pf.z(uy.z("application/json; charset=utf-8"), str);
    }

    public void z(JSONObject jSONObject) {
        this.z = pf.z(uy.z("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void z(Map<String, String> map) {
        gc.z zVar = new gc.z();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                zVar.z(str, map.get(str));
            }
        }
        this.z = zVar.z();
    }

    public void z(String str, byte[] bArr) {
        this.z = pf.z(uy.z(str), bArr);
    }

    public void z(final com.bytedance.sdk.component.fo.z.z zVar) {
        try {
            v.z zVar2 = new v.z();
            if (TextUtils.isEmpty(this.m)) {
                zVar.z(this, new IOException("Url is Empty"));
                return;
            }
            zVar2.z(this.m);
            if (this.z == null) {
                if (zVar != null) {
                    zVar.z(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                z(zVar2);
                zVar2.z((Object) g());
                this.dl.z(zVar2.z(this.z).g()).z(new com.bytedance.sdk.component.g.z.dl() { // from class: com.bytedance.sdk.component.fo.g.gc.1
                    @Override // com.bytedance.sdk.component.g.z.dl
                    public void onFailure(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
                        com.bytedance.sdk.component.fo.z.z zVar3 = zVar;
                        if (zVar3 != null) {
                            zVar3.z(gc.this, iOException);
                        }
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.bytedance.sdk.component.g.z.dl
                    public void onResponse(com.bytedance.sdk.component.g.z.g gVar, ls lsVar) throws IOException {
                        com.bytedance.sdk.component.fo.g gVar2;
                        com.bytedance.sdk.component.fo.z.z zVar3 = zVar;
                        if (zVar3 != null) {
                            if (lsVar == null) {
                                zVar3.z(gc.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.fo.g gVar3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                m mVarE = lsVar.e();
                                if (mVarE != null) {
                                    for (int i = 0; i < mVarE.z(); i++) {
                                        String strZ = mVarE.z(i);
                                        String strG = mVarE.g(i);
                                        map.put(strZ, strG);
                                        if (strZ != null && strZ.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strG == null ? "" : strG.toLowerCase());
                                        }
                                    }
                                }
                                try {
                                    if (com.bytedance.sdk.component.fo.a.z.z(map)) {
                                        byte[] bArrA = lsVar.m().a();
                                        gVar2 = new com.bytedance.sdk.component.fo.g(lsVar.a(), lsVar.dl(), lsVar.gc(), map, null, lsVar.g(), lsVar.z());
                                        gVar2.z(bArrA);
                                    } else if (gc.this.e) {
                                        byte[] bArrA2 = lsVar.m().a();
                                        gc gcVar = gc.this;
                                        gVar2 = new com.bytedance.sdk.component.fo.g(lsVar.a(), lsVar.dl(), lsVar.gc(), map, new String(bArrA2, gcVar.z(gcVar.z(lsVar.m()))), lsVar.g(), lsVar.z());
                                        gVar2.z(bArrA2);
                                    } else {
                                        gVar2 = new com.bytedance.sdk.component.fo.g(lsVar.a(), lsVar.dl(), lsVar.gc(), map, lsVar.m().g(), lsVar.g(), lsVar.z());
                                    }
                                    gc.this.z(gVar2, lsVar);
                                } catch (Throwable th) {
                                    th = th;
                                    gVar3 = gVar2;
                                    gVar2 = gVar3;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (gVar2 != null) {
                                zVar.z(gc.this, gVar2);
                                return;
                            }
                            com.bytedance.sdk.component.fo.z.z zVar4 = zVar;
                            gc gcVar2 = gc.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            zVar4.z(gcVar2, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            zVar.z(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.fo.g.a
    public com.bytedance.sdk.component.fo.g z() {
        com.bytedance.sdk.component.fo.g gVar;
        try {
            v.z zVar = new v.z();
            if (TextUtils.isEmpty(this.m)) {
                com.bytedance.sdk.component.fo.a.gc.z("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.fo.g(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            zVar.z(this.m);
            if (this.z == null) {
                com.bytedance.sdk.component.fo.a.gc.z("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.fo.g(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            z(zVar);
            zVar.z((Object) g());
            ls lsVarG = this.dl.z(zVar.z(this.z).g()).g();
            if (lsVarG == null) {
                return null;
            }
            HashMap map = new HashMap();
            m mVarE = lsVarG.e();
            if (mVarE != null) {
                for (int i = 0; i < mVarE.z(); i++) {
                    String strZ = mVarE.z(i);
                    String strG = mVarE.g(i);
                    map.put(strZ, strG);
                    if (strZ != null && strZ.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strG == null ? "" : strG.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.fo.a.z.z(map)) {
                byte[] bArrA = lsVarG.m().a();
                gVar = new com.bytedance.sdk.component.fo.g(lsVarG.a(), lsVarG.dl(), lsVarG.gc(), map, null, lsVarG.g(), lsVarG.z());
                gVar.z(bArrA);
            } else if (this.e) {
                byte[] bArrA2 = lsVarG.m().a();
                gVar = new com.bytedance.sdk.component.fo.g(lsVarG.a(), lsVarG.dl(), lsVarG.gc(), map, new String(bArrA2, z(z(lsVarG.m()))), lsVarG.g(), lsVarG.z());
                gVar.z(bArrA2);
            } else {
                gVar = new com.bytedance.sdk.component.fo.g(lsVarG.a(), lsVarG.dl(), lsVarG.gc(), map, lsVarG.m().g(), lsVarG.g(), lsVarG.z());
            }
            z(gVar, lsVarG);
            return gVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.fo.g(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset z(uy uyVar) {
        try {
            return uyVar != null ? uyVar.z(com.bytedance.sdk.component.g.z.g.uy.z) : com.bytedance.sdk.component.g.z.g.uy.z;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.g.z.g.uy.z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uy z(p pVar) {
        try {
            return pVar.gc();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.fo.g gVar, ls lsVar) {
        if (gVar == null || lsVar == null) {
            return;
        }
        gVar.z(lsVar.fo());
    }
}
