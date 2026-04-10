package com.anythink.expressad.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.s;

/* JADX INFO: loaded from: classes2.dex */
public class ATAdChoice extends ATImageView {
    private static String a = "ATAdChoice";
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f12280e;

    /* JADX INFO: renamed from: com.anythink.expressad.widget.ATAdChoice$1, reason: invalid class name */
    final class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            ATAdChoice.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    public ATAdChoice(Context context) {
        super(context);
        this.b = "";
        this.f12278c = "";
        this.f12279d = "";
        this.f12280e = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    private void b() {
        Context context = this.f12280e;
        if (context != null) {
            b.a(context).a(this.b, new AnonymousClass1());
        }
    }

    private void c() {
        if (TextUtils.isEmpty(this.f12279d)) {
            return;
        }
        s.a(this.f12280e, this.f12279d, null);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (TextUtils.isEmpty(this.f12279d)) {
            return true;
        }
        s.a(this.f12280e, this.f12279d, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCampaign(com.anythink.expressad.out.j r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.anythink.expressad.foundation.d.c
            if (r0 == 0) goto L91
            com.anythink.expressad.foundation.d.c r4 = (com.anythink.expressad.foundation.d.c) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L40
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            if (r2 == 0) goto L40
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            java.lang.String r2 = r2.c()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            java.lang.String r2 = r2.b()
            r3.f12279d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L40
            com.anythink.expressad.foundation.d.c$a r4 = r4.v()
            java.lang.String r4 = r4.d()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L40
            r4 = 1
            goto L41
        L40:
            r4 = 0
        L41:
            if (r4 != 0) goto L78
            com.anythink.expressad.d.b.a()
            com.anythink.expressad.foundation.b.a r4 = com.anythink.expressad.foundation.b.a.b()
            r4.e()
            com.anythink.expressad.d.a r4 = com.anythink.expressad.d.b.b()
            if (r4 == 0) goto L77
            java.lang.String r2 = r4.H()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L77
            java.lang.String r2 = r4.J()
            r3.f12279d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L77
            java.lang.String r4 = r4.I()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L77
            r4 = 1
            goto L78
        L77:
            r4 = 0
        L78:
            java.lang.String r0 = r3.b
            r3.setImageUrl(r0)
            if (r4 == 0) goto L91
            android.content.Context r4 = r3.f12280e
            if (r4 == 0) goto L91
            com.anythink.expressad.foundation.g.d.b r4 = com.anythink.expressad.foundation.g.d.b.a(r4)
            java.lang.String r0 = r3.b
            com.anythink.expressad.widget.ATAdChoice$1 r1 = new com.anythink.expressad.widget.ATAdChoice$1
            r1.<init>()
            r4.a(r0, r1)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.widget.ATAdChoice.setCampaign(com.anythink.expressad.out.j):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.anythink.expressad.foundation.d.c r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L3a
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            if (r2 == 0) goto L3a
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            java.lang.String r2 = r2.c()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L3a
            com.anythink.expressad.foundation.d.c$a r2 = r4.v()
            java.lang.String r2 = r2.b()
            r3.f12279d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L3a
            com.anythink.expressad.foundation.d.c$a r4 = r4.v()
            java.lang.String r4 = r4.d()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3a
            r4 = 1
            goto L3b
        L3a:
            r4 = 0
        L3b:
            if (r4 != 0) goto L72
            com.anythink.expressad.d.b.a()
            com.anythink.expressad.foundation.b.a r4 = com.anythink.expressad.foundation.b.a.b()
            r4.e()
            com.anythink.expressad.d.a r4 = com.anythink.expressad.d.b.b()
            if (r4 == 0) goto L71
            java.lang.String r2 = r4.H()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L71
            java.lang.String r2 = r4.J()
            r3.f12279d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L71
            java.lang.String r4 = r4.I()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L71
            r4 = 1
            goto L72
        L71:
            r4 = 0
        L72:
            java.lang.String r0 = r3.b
            r3.setImageUrl(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.widget.ATAdChoice.a(com.anythink.expressad.foundation.d.c):boolean");
    }

    public ATAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.f12278c = "";
        this.f12279d = "";
        this.f12280e = context;
        a();
    }

    public ATAdChoice(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = "";
        this.f12278c = "";
        this.f12279d = "";
        this.f12280e = context;
        a();
    }
}
