package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import anet.channel.util.HttpConstant;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements t {
    private final m a;

    public a(m mVar) {
        this.a = mVar;
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i2);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        y yVarB = aVar.b();
        y.a aVarF = yVarB.f();
        z zVarA = yVarB.a();
        if (zVarA != null) {
            u uVarB = zVarA.b();
            if (uVarB != null) {
                aVarF.b("Content-Type", uVarB.toString());
            }
            long jA = zVarA.a();
            if (jA != -1) {
                aVarF.b("Content-Length", Long.toString(jA));
                aVarF.a(DownloadUtils.TRANSFER_ENCODING);
            } else {
                aVarF.b(DownloadUtils.TRANSFER_ENCODING, DownloadUtils.VALUE_CHUNKED);
                aVarF.a("Content-Length");
            }
        }
        boolean z2 = false;
        if (yVarB.a(HttpConstant.HOST) == null) {
            aVarF.b(HttpConstant.HOST, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(yVarB.g(), false));
        }
        if (yVarB.a("Connection") == null) {
            aVarF.b("Connection", com.anythink.expressad.foundation.g.f.g.c.f10570c);
        }
        if (yVarB.a("Accept-Encoding") == null && yVarB.a("Range") == null) {
            z2 = true;
            aVarF.b("Accept-Encoding", "gzip");
        }
        List<l> listA = this.a.a(yVarB.g());
        if (!listA.isEmpty()) {
            aVarF.b(HttpConstant.COOKIE, a(listA));
        }
        if (yVarB.a("User-Agent") == null) {
            aVarF.b("User-Agent", bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.d.a());
        }
        a0 a0VarA = aVar.a(aVarF.a());
        e.a(this.a, yVarB.g(), a0VarA.m());
        a0.a aVarA = a0VarA.p().a(yVarB);
        if (z2 && "gzip".equalsIgnoreCase(a0VarA.b("Content-Encoding")) && e.b(a0VarA)) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j jVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j(a0VarA.i().k());
            aVarA.a(a0VarA.m().a().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(a0VarA.b("Content-Type"), -1L, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(jVar)));
        }
        return aVarA.a();
    }
}
