package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.hh;
import com.bytedance.sdk.component.dl.g.i;
import com.bytedance.sdk.component.dl.g.q;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.efs.sdk.base.Constants;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements tb {
    private final i z;

    public z(i iVar) {
        this.z = iVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb
    public h z(tb.z zVar) throws IOException {
        sy syVarZ = zVar.z();
        sy.z zVarM = syVarZ.m();
        hh hhVarA = syVarZ.a();
        if (hhVarA != null) {
            q qVarZ = hhVarA.z();
            if (qVarZ != null) {
                zVarM.z(HttpHeaders.CONTENT_TYPE, qVarZ.toString());
            }
            long jG = hhVarA.g();
            if (jG != -1) {
                zVarM.z(HttpHeaders.CONTENT_LENGTH, Long.toString(jG));
                zVarM.g(HttpHeaders.TRANSFER_ENCODING);
            } else {
                zVarM.z(HttpHeaders.TRANSFER_ENCODING, "chunked");
                zVarM.g(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (syVarZ.z(HttpHeaders.HOST) == null) {
            zVarM.z(HttpHeaders.HOST, com.bytedance.sdk.component.dl.g.z.dl.z(syVarZ.z(), false));
        }
        if (syVarZ.z(HttpHeaders.CONNECTION) == null) {
            zVarM.z(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        }
        if (syVarZ.z(HttpHeaders.ACCEPT_ENCODING) == null && syVarZ.z(HttpHeaders.RANGE) == null) {
            zVarM.z(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            z = true;
        }
        List<com.bytedance.sdk.component.dl.g.wp> listZ = this.z.z(syVarZ.z());
        if (!listZ.isEmpty()) {
            zVarM.z(HttpHeaders.COOKIE, z(listZ));
        }
        if (syVarZ.z("User-Agent") == null) {
            zVarM.z("User-Agent", com.bytedance.sdk.component.dl.g.z.a.z());
        }
        h hVarZ = zVar.z(zVarM.z());
        gc.z(this.z, syVarZ.z(), hVarZ.e());
        h.z zVarZ = hVarZ.fo().z(syVarZ);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(hVarZ.z(HttpHeaders.CONTENT_ENCODING)) && gc.dl(hVarZ)) {
            com.bytedance.sdk.component.dl.z.uy uyVar = new com.bytedance.sdk.component.dl.z.uy(hVarZ.gz().dl());
            zVarZ.z(hVarZ.e().g().g(HttpHeaders.CONTENT_ENCODING).g(HttpHeaders.CONTENT_LENGTH).z());
            zVarZ.z(new gz(hVarZ.z(HttpHeaders.CONTENT_TYPE), -1L, com.bytedance.sdk.component.dl.z.wp.z(uyVar)));
        }
        return zVarZ.z();
    }

    private String z(List<com.bytedance.sdk.component.dl.g.wp> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.dl.g.wp wpVar = list.get(i);
            sb.append(wpVar.z()).append('=').append(wpVar.g());
        }
        return sb.toString();
    }
}
