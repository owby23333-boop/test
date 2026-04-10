package com.bytedance.sdk.component.dl.g.z.gc;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface i {
    public static final i z = new i() { // from class: com.bytedance.sdk.component.dl.g.z.gc.i.1
        @Override // com.bytedance.sdk.component.dl.g.z.gc.i
        public boolean z(int i, List<dl> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.i
        public boolean z(int i, List<dl> list, boolean z2) {
            return true;
        }

        @Override // com.bytedance.sdk.component.dl.g.z.gc.i
        public boolean z(int i, com.bytedance.sdk.component.dl.z.gc gcVar, int i2, boolean z2) throws IOException {
            gcVar.gz(i2);
            return true;
        }
    };

    boolean z(int i, com.bytedance.sdk.component.dl.z.gc gcVar, int i2, boolean z2) throws IOException;

    boolean z(int i, List<dl> list);

    boolean z(int i, List<dl> list, boolean z2);
}
