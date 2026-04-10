package com.anythink.expressad.foundation.g.d;

import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.f;
import com.anythink.expressad.foundation.g.f.k;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.anythink.expressad.foundation.g.g.a {
    private static final String a = "ImageWorker";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10501h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f10502i;

    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    public d(String str, String str2, String str3) {
        this.f10498e = str;
        this.f10499f = str2;
        this.f10500g = str3;
    }

    private String h() {
        return this.f10498e;
    }

    private String i() {
        return this.f10499f;
    }

    private String j() {
        return this.f10500g;
    }

    private boolean k() {
        return this.f10501h;
    }

    private a l() {
        return this.f10502i;
    }

    private static void m() {
    }

    private void n() {
        try {
            File file = new File(this.f10500g);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.anythink.expressad.foundation.g.f.h.a.a(file, this.f10499f, new f<Void>() { // from class: com.anythink.expressad.foundation.g.d.d.1
                @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
                public final void a() {
                }

                @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
                public final void a(long j2, long j3) {
                }

                @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
                public final void a(k kVar) {
                    String unused = d.this.f10500g;
                    d.this.d();
                }

                @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
                public final void a(com.anythink.expressad.foundation.g.f.a.a aVar) {
                    d dVar = d.this;
                    dVar.b(dVar.f10499f, "load image from http faild because http return code: " + aVar.a + ".image url is " + d.this.f10499f);
                }
            });
        } catch (Exception e2) {
            b(this.f10499f, e2.getMessage());
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (OutOfMemoryError e3) {
            b(this.f10499f, e3.getMessage());
        }
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void b() {
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void c() {
    }

    protected final void d() {
        if (!new File(this.f10500g).exists()) {
            b(this.f10499f, "load image faild.because file[" + this.f10500g + "] is not exist!");
            return;
        }
        String str = this.f10499f;
        String str2 = this.f10500g;
        a aVar = this.f10502i;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        a aVar = this.f10502i;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    public final void a(boolean z2) {
        this.f10501h = z2;
    }

    public final void a(a aVar) {
        this.f10502i = aVar;
    }

    private void a(String str, String str2) {
        a aVar = this.f10502i;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void a() {
        if (!this.f10501h) {
            if (TextUtils.isEmpty(this.f10500g)) {
                b(this.f10499f, "save path is null.");
                return;
            }
            File file = new File(this.f10500g);
            if (file.exists() && file.length() > 0) {
                d();
                return;
            } else {
                n();
                return;
            }
        }
        n();
    }
}
