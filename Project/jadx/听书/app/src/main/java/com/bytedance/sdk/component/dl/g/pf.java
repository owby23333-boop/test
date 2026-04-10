package com.bytedance.sdk.component.dl.g;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface pf {
    public static final pf z = new pf() { // from class: com.bytedance.sdk.component.dl.g.pf.1
        @Override // com.bytedance.sdk.component.dl.g.pf
        public List<InetAddress> z(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> z(String str) throws UnknownHostException;
}
