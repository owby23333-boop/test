package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.k;
import com.anythink.expressad.foundation.h.o;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends i<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10540c = f.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f10541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.f.c.b[] f10542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10543f;

    private f(int i2, String str, Map<String, String> map, com.anythink.expressad.foundation.g.f.c.b[] bVarArr, com.anythink.expressad.foundation.g.f.e<String> eVar) {
        super(i2, str, eVar);
        this.f10543f = "---------Ij5ei4KM7KM7ae0KM7cH2ae0Ij5Ef1";
        this.f10541d = map;
        this.f10542e = bVarArr;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.anythink.expressad.foundation.g.f.i
    public final void a(OutputStream outputStream) {
        DataOutputStream dataOutputStream = (DataOutputStream) outputStream;
        try {
            try {
                if (this.f10542e != null) {
                    for (com.anythink.expressad.foundation.g.f.c.b bVar : this.f10542e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("--");
                        sb.append(this.f10543f);
                        sb.append("\r\n");
                        sb.append("Content-Disposition: form-data;name=\"" + bVar.f() + "\";filename=\"" + bVar.e() + "\"\r\n");
                        StringBuilder sb2 = new StringBuilder("Content-Type: ");
                        sb2.append(bVar.g());
                        sb2.append("\r\n\r\n");
                        sb.append(sb2.toString());
                        dataOutputStream.write(sb.toString().getBytes());
                        if (bVar.c() != null) {
                            byte[] bArr = new byte[1024];
                            int i2 = 0;
                            while (true) {
                                int i3 = bVar.c().read(bArr);
                                if (i3 == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr, 0, i3);
                                i2 += i3;
                                if (this.b != null) {
                                    this.b.a(bVar.a(), i2);
                                }
                            }
                            bVar.c().close();
                        } else {
                            dataOutputStream.write(bVar.d(), 0, bVar.d().length);
                        }
                        dataOutputStream.write("\r\n".getBytes());
                    }
                }
                dataOutputStream.writeBytes("--" + this.f10543f + "--\r\n");
                dataOutputStream.flush();
            } finally {
                try {
                    dataOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            o.d(f10540c, e3.getMessage());
            this.b.a(new com.anythink.expressad.foundation.g.f.a.a(2, null));
            try {
                dataOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f10541d.entrySet()) {
            sb.append("--");
            sb.append(this.f10543f);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString().getBytes();
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final void i() {
        super.i();
        HashMap map = new HashMap();
        map.put("Content-Type", "multipart/form-data; boundary=" + this.f10543f);
        a((Map<String, String>) map);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    protected final k<String> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        try {
            return k.a(new String(cVar.b, com.anythink.expressad.foundation.g.f.g.e.a(cVar.f10553d)), cVar);
        } catch (UnsupportedEncodingException e2) {
            o.d(f10540c, e2.getMessage());
            return k.a(new com.anythink.expressad.foundation.g.f.a.a(8, cVar));
        }
    }
}
