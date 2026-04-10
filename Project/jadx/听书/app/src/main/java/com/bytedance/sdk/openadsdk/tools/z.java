package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.ti.z.dl;
import com.bytedance.sdk.openadsdk.hh.e;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements dl.z {
    private g g = new g();
    private final dl.z z;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tools.z$z, reason: collision with other inner class name */
    private interface InterfaceC0223z {
        void z(String str, String str2);
    }

    public z(dl.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void z(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            z(str, str2, new InterfaceC0223z() { // from class: com.bytedance.sdk.openadsdk.tools.z.1
                @Override // com.bytedance.sdk.openadsdk.tools.z.InterfaceC0223z
                public void z(String str3, String str4) {
                    z.this.z.z(str3, str4);
                }
            });
        } else {
            this.z.z(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void g(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            z(str, str2, new InterfaceC0223z() { // from class: com.bytedance.sdk.openadsdk.tools.z.2
                @Override // com.bytedance.sdk.openadsdk.tools.z.InterfaceC0223z
                public void z(String str3, String str4) {
                    z.this.z.g(str3, str4);
                }
            });
        } else {
            this.z.g(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void dl(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            z(str, str2, new InterfaceC0223z() { // from class: com.bytedance.sdk.openadsdk.tools.z.3
                @Override // com.bytedance.sdk.openadsdk.tools.z.InterfaceC0223z
                public void z(String str3, String str4) {
                    z.this.z.dl(str3, str4);
                }
            });
        } else {
            this.z.dl(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void a(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            z(str, str2, new InterfaceC0223z() { // from class: com.bytedance.sdk.openadsdk.tools.z.4
                @Override // com.bytedance.sdk.openadsdk.tools.z.InterfaceC0223z
                public void z(String str3, String str4) {
                    z.this.z.a(str3, str4);
                }
            });
        } else {
            this.z.a(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void z(String str, String str2, Throwable th) {
        this.z.z(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void gc(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            z(str, str2, new InterfaceC0223z() { // from class: com.bytedance.sdk.openadsdk.tools.z.5
                @Override // com.bytedance.sdk.openadsdk.tools.z.InterfaceC0223z
                public void z(String str3, String str4) {
                    z.this.z.gc(str3, str4);
                }
            });
        } else {
            this.z.gc(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void g(String str, String str2, Throwable th) {
        this.z.g(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void z(String str, Throwable th) {
        this.z.z(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
    public void z() {
        this.z.z();
    }

    private void z(final String str, final String str2, final InterfaceC0223z interfaceC0223z) {
        try {
            if (e.z()) {
                e.g(new fo("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.z.6
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g.z(str, str2, interfaceC0223z);
                    }
                });
            } else {
                this.g.z(str, str2, interfaceC0223z);
            }
        } catch (Throwable th) {
            wp.g("", "print big Str failed!", th);
        }
    }

    private class g {
        private g() {
        }

        void z(String str, String str2, InterfaceC0223z interfaceC0223z) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0223z.z(z(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String z(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }
}
