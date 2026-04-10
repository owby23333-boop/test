package com.bytedance.sdk.component.d.bf;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface s {
    public static final s e = new s() { // from class: com.bytedance.sdk.component.d.bf.s.1
        @Override // com.bytedance.sdk.component.d.bf.s
        public List<InetAddress> e(String str) throws UnknownHostException {
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

    List<InetAddress> e(String str) throws UnknownHostException;
}
