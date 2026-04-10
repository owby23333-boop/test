package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.bytedance.adsdk.ugeno.g.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<EditText> {
    private int cb;
    private int dt;
    private float k;
    private int o;
    private int wo;
    private String wx;
    private String xf;
    private String xo;
    private String yt;
    private int z;

    public z(Context context) {
        super(context);
        this.z = 1;
        this.cb = Integer.MAX_VALUE;
        this.dt = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public EditText z() {
        UGEditText uGEditText = new UGEditText(this.g);
        uGEditText.z(this);
        return uGEditText;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((EditText) this.gc).setInputType(this.z);
        ((EditText) this.gc).setText(this.xo);
        ((EditText) this.gc).setTextSize(1, this.k);
        ((EditText) this.gc).setTextColor(this.wo);
        ((EditText) this.gc).setLines(this.o);
        ((EditText) this.gc).setMaxLines(this.cb);
        ((EditText) this.gc).setGravity(this.dt);
        ((EditText) this.gc).setHint(this.xf);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.dt = wp(str2);
                break;
            case "textColor":
                this.wo = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "textStyle":
                this.wx = str2;
                break;
            case "textSize":
                this.k = Float.parseFloat(str2);
                break;
            case "hint":
                this.xf = str2;
                break;
            case "text":
                this.xo = str2;
                break;
            case "lines":
                this.o = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.cb = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.yt = str2;
                break;
            case "inputType":
                this.z = kb(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int kb(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1034364087: goto L33;
                case 3556653: goto L29;
                case 96619420: goto L1f;
                case 106642798: goto L15;
                case 1216985755: goto Lb;
                default: goto La;
            }
        La:
            goto L3d
        Lb:
            java.lang.String r0 = "password"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = 0
            goto L3e
        L15:
            java.lang.String r0 = "phone"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r3
            goto L3e
        L1f:
            java.lang.String r0 = "email"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r1
            goto L3e
        L29:
            java.lang.String r0 = "text"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = 4
            goto L3e
        L33:
            java.lang.String r0 = "number"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r2
            goto L3e
        L3d:
            r5 = -1
        L3e:
            if (r5 == 0) goto L4c
            if (r5 == r3) goto L4b
            if (r5 == r2) goto L4a
            if (r5 == r1) goto L47
            return r3
        L47:
            r5 = 32
            return r5
        L4a:
            return r2
        L4b:
            return r1
        L4c:
            r5 = 128(0x80, float:1.8E-43)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.input.z.kb(java.lang.String):int");
    }

    private int wp(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }
}
