package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.zk.p;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.s.vn;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements TTILog {
    private bf bf = new bf();
    private final TTILog e;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tools.e$e, reason: collision with other inner class name */
    public interface InterfaceC0176e {
        void e(String str, String str2);
    }

    public e(TTILog tTILog) {
        this.e = tTILog;
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void d(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.e.d(str, str2);
        } else {
            e(str, str2, new InterfaceC0176e() { // from class: com.bytedance.sdk.openadsdk.tools.e.2
                @Override // com.bytedance.sdk.openadsdk.tools.e.InterfaceC0176e
                public void e(String str3, String str4) {
                    e.this.e.d(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void flush() {
        this.e.flush();
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void forceLogSharding() {
        this.e.forceLogSharding();
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void i(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.e.i(str, str2);
        } else {
            e(str, str2, new InterfaceC0176e() { // from class: com.bytedance.sdk.openadsdk.tools.e.3
                @Override // com.bytedance.sdk.openadsdk.tools.e.InterfaceC0176e
                public void e(String str3, String str4) {
                    e.this.e.i(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void v(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.e.v(str, str2);
        } else {
            e(str, str2, new InterfaceC0176e() { // from class: com.bytedance.sdk.openadsdk.tools.e.1
                @Override // com.bytedance.sdk.openadsdk.tools.e.InterfaceC0176e
                public void e(String str3, String str4) {
                    e.this.e.v(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.e.w(str, str2);
        } else {
            e(str, str2, new InterfaceC0176e() { // from class: com.bytedance.sdk.openadsdk.tools.e.4
                @Override // com.bytedance.sdk.openadsdk.tools.e.InterfaceC0176e
                public void e(String str3, String str4) {
                    e.this.e.w(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.e.e(str, str2);
        } else {
            e(str, str2, new InterfaceC0176e() { // from class: com.bytedance.sdk.openadsdk.tools.e.5
                @Override // com.bytedance.sdk.openadsdk.tools.e.InterfaceC0176e
                public void e(String str3, String str4) {
                    e.this.e.e(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, Throwable th) {
        this.e.w(str, th);
    }

    public class bf {
        private bf() {
        }

        public void e(String str, String str2, InterfaceC0176e interfaceC0176e) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0176e.e(e(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String e(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2, Throwable th) {
        this.e.e(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2, Throwable th) {
        this.e.w(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, Throwable th) {
        this.e.e(str, th);
    }

    private void e(final String str, final String str2, final InterfaceC0176e interfaceC0176e) {
        try {
            if (vn.e()) {
                vn.bf(new p("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.bf.e(str, str2, interfaceC0176e);
                    }
                });
            } else {
                this.bf.e(str, str2, interfaceC0176e);
            }
        } catch (Throwable th) {
            wu.bf("", "print big Str failed!", th);
        }
    }
}
