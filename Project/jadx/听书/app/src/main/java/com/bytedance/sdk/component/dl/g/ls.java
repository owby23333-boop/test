package com.bytedance.sdk.component.dl.g;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ls {
    public static final ls z = new ls() { // from class: com.bytedance.sdk.component.dl.g.ls.1
    };

    public interface z {
        ls z(gc gcVar);
    }

    public void z(gc gcVar, IOException iOException) {
    }

    public void z(gc gcVar, InetSocketAddress inetSocketAddress, Proxy proxy, io ioVar, IOException iOException) {
    }

    static z z(ls lsVar) {
        return new z() { // from class: com.bytedance.sdk.component.dl.g.ls.2
            @Override // com.bytedance.sdk.component.dl.g.ls.z
            public ls z(gc gcVar) {
                return ls.this;
            }
        };
    }
}
