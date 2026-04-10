package com.bytedance.sdk.component.g.z.z.z;

import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.g.z.i;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends ls {
    private com.bytedance.sdk.component.g.z.z.z.z g;

    public dl(com.bytedance.sdk.component.g.z.z.z.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.ls
    public void z(com.bytedance.sdk.component.dl.g.gc gcVar, InetSocketAddress inetSocketAddress, Proxy proxy, io ioVar, IOException iOException) {
        super.z(gcVar, inetSocketAddress, proxy, ioVar, iOException);
        com.bytedance.sdk.component.g.z.z.z.z zVar = this.g;
        if (zVar != null) {
            zVar.z(new z(gcVar), inetSocketAddress, proxy, z(ioVar), iOException);
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.ls
    public void z(com.bytedance.sdk.component.dl.g.gc gcVar, IOException iOException) {
        super.z(gcVar, iOException);
        com.bytedance.sdk.component.g.z.z.z.z zVar = this.g;
        if (zVar != null) {
            zVar.z(new z(gcVar), iOException);
        }
    }

    private static class z implements com.bytedance.sdk.component.g.z.g {
        com.bytedance.sdk.component.dl.g.gc z;

        @Override // com.bytedance.sdk.component.g.z.g
        public com.bytedance.sdk.component.g.z.ls g() throws IOException {
            return null;
        }

        /* JADX INFO: renamed from: gc, reason: merged with bridge method [inline-methods] */
        public com.bytedance.sdk.component.g.z.g clone() {
            return null;
        }

        @Override // com.bytedance.sdk.component.g.z.g
        public void z(com.bytedance.sdk.component.g.z.dl dlVar) {
        }

        public z(com.bytedance.sdk.component.dl.g.gc gcVar) {
            this.z = gcVar;
        }

        @Override // com.bytedance.sdk.component.g.z.g
        public v z() {
            return new gz(this.z.z());
        }

        @Override // com.bytedance.sdk.component.g.z.g
        public void dl() {
            this.z.dl();
        }

        @Override // com.bytedance.sdk.component.g.z.g
        public boolean a() {
            return this.z.a();
        }
    }

    private i z(io ioVar) {
        try {
            return i.z(ioVar.toString());
        } catch (IOException unused) {
            return null;
        }
    }
}
