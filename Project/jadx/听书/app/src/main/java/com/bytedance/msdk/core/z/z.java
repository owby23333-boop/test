package com.bytedance.msdk.core.z;

import android.util.SparseArray;
import com.bytedance.msdk.api.a.z.dl.dl;
import com.bytedance.sdk.openadsdk.ls.a;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static dl z(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new dl() { // from class: com.bytedance.msdk.core.z.z.1
                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void z(long j) {
                    function.apply(a.z().z(8166).z(Void.class).z(8074, Long.valueOf(j)).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void g(long j) {
                    function.apply(a.z().z(8167).z(Void.class).z(8074, Long.valueOf(j)).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void z() {
                    function.apply(a.z().z(8168).z(Void.class).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void dl(long j) {
                    function.apply(a.z().z(8169).z(Void.class).z(8074, Long.valueOf(j)).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void g() {
                    function.apply(a.z().z(8170).z(Void.class).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void z(int i, int i2) {
                    function.apply(a.z().z(8171).z(Void.class).z(8014, Integer.valueOf(i)).z(8075, Integer.valueOf(i2)).g());
                }

                @Override // com.bytedance.msdk.api.a.z.e.gc
                public void z(long j, int i, int i2) {
                    function.apply(a.z().z(8172).z(Void.class).z(8014, Integer.valueOf(i)).z(8075, Integer.valueOf(i2)).z(8074, Long.valueOf(j)).g());
                }
            };
        }
        return null;
    }
}
