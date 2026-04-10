package com.bytedance.adsdk.ugeno.widget.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.m.a;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.m.z;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.g;
import com.bytedance.adsdk.ugeno.z;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private boolean bw;
    private String cb;
    private z.C0047z dt;
    private String k;
    private String o;
    private String wx;
    private boolean xf;
    private int xo;
    private int yt;

    public z(Context context) {
        super(context);
        this.wx = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        gz();
        ((UGTextView) this.gc).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected void na() {
        super.na();
        if (this.xf) {
            ((UGTextView) this.gc).setTextColor(this.xo);
        }
        if (this.bw) {
            if (this.n) {
                z(this.dt);
            } else {
                dl(this.yt);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    protected void xl() {
        super.xl();
        if (this.xf) {
            ((UGTextView) this.gc).setTextColor(this.wo);
        }
        if (this.bw) {
            if (this.n) {
                z(this.ly);
            } else {
                dl(this.eo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(android.graphics.drawable.Drawable r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r4.wx
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case -1781065991: goto L2d;
                case -1354837162: goto L23;
                case -207799939: goto L19;
                case 113114: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r1 = "row"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 3
            goto L38
        L19:
            java.lang.String r1 = "row_reverse"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r1 = "column"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = r3
            goto L38
        L2d:
            java.lang.String r1 = "column_reverse"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = r2
            goto L38
        L37:
            r0 = -1
        L38:
            r1 = 0
            if (r0 == 0) goto L57
            if (r0 == r3) goto L4f
            if (r0 == r2) goto L47
            T extends android.view.View r0 = r4.gc
            com.bytedance.adsdk.ugeno.widget.text.UGTextView r0 = (com.bytedance.adsdk.ugeno.widget.text.UGTextView) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r5, r1, r1, r1)
            return
        L47:
            T extends android.view.View r0 = r4.gc
            com.bytedance.adsdk.ugeno.widget.text.UGTextView r0 = (com.bytedance.adsdk.ugeno.widget.text.UGTextView) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r1, r1, r5)
            return
        L4f:
            T extends android.view.View r0 = r4.gc
            com.bytedance.adsdk.ugeno.widget.text.UGTextView r0 = (com.bytedance.adsdk.ugeno.widget.text.UGTextView) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r5, r1, r1)
            return
        L57:
            T extends android.view.View r0 = r4.gc
            com.bytedance.adsdk.ugeno.widget.text.UGTextView r0 = (com.bytedance.adsdk.ugeno.widget.text.UGTextView) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r1, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.z.z.g(android.graphics.drawable.Drawable):void");
    }

    private void gz() {
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        ((UGTextView) this.gc).setCompoundDrawables(null, null, null, null);
        if (this.k.startsWith("local://")) {
            try {
                g(gz.z(this.g, a.g(this.g, this.k.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.k, new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.widget.z.z.1
            @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
            public void z(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.z.z.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.g(new BitmapDrawable(z.this.g.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.wx = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.xo = com.bytedance.adsdk.ugeno.m.z.z(str2);
                this.xf = true;
                break;
            case "image":
                this.k = str2;
                break;
            case "highlightImage":
                this.cb = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.m.z.dl(str2)) {
                    this.n = true;
                    this.dt = com.bytedance.adsdk.ugeno.m.z.g(str2);
                } else {
                    this.yt = com.bytedance.adsdk.ugeno.m.z.z(str2);
                    this.n = false;
                }
                this.bw = true;
                break;
            case "highlightBackgroundImage":
                this.o = str2;
                break;
        }
    }
}
