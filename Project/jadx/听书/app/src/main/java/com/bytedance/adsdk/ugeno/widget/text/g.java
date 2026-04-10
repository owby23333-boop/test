package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.gz;
import com.google.common.base.Ascii;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl<UGTextView> {
    private float bw;
    private int cb;
    private int dh;
    private int dt;
    private float fp;
    private float gy;
    private float hy;
    private float k;
    private float kp;
    private float lt;
    private int o;

    @Deprecated
    private float te;
    protected int wo;
    private int wx;
    private TextUtils.TruncateAt xf;

    @Deprecated
    private TextUtils.TruncateAt xo;
    private int yt;
    protected String z;
    private boolean zb;

    @Deprecated
    private float zd;

    public g(Context context) {
        super(context);
        this.wo = -16777216;
        this.k = 12.0f;
        this.cb = Integer.MAX_VALUE;
        this.yt = GravityCompat.START;
        this.xf = TextUtils.TruncateAt.END;
        this.bw = -1.0f;
        this.gy = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UGTextView z() {
        UGTextView uGTextView = new UGTextView(this.g);
        uGTextView.z(this);
        return uGTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        if (TextUtils.equals("null", this.z)) {
            this.z = "";
        }
        kb(this.z);
        ((UGTextView) this.gc).setTextSize(1, this.k);
        ((UGTextView) this.gc).setTextColor(this.wo);
        ((UGTextView) this.gc).setLines(this.o);
        ((UGTextView) this.gc).setMaxLines(this.cb);
        ((UGTextView) this.gc).setGravity(this.yt);
        ((UGTextView) this.gc).setIncludeFontPadding(false);
        m(this.dt);
        if (h()) {
            z(this.xf);
        } else {
            z(this.xo);
        }
        if (this.bw > 0.0f) {
            if (h()) {
                jq();
            } else {
                gz();
            }
        }
        ((UGTextView) this.gc).setBreakStrategy(0);
        if (h()) {
            if (this.zb) {
                if (this.kp <= 0.0f) {
                    this.kp = 1.0E-5f;
                }
                ((UGTextView) this.gc).setShadowLayer(this.kp, this.hy, this.lt, this.dh);
            }
        } else {
            ((UGTextView) this.gc).setShadowLayer(this.kp, this.zd, this.te, this.dh);
        }
        if (this.wx == 1) {
            ((UGTextView) this.gc).setTypeface(Typeface.DEFAULT, this.wx);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((UGTextView) this.gc).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.gy, this.wx == 2));
        } else if (this.gy >= 500.0f) {
            ((UGTextView) this.gc).setTypeface(Typeface.DEFAULT, 1);
        }
        if (gz.z(this.g, this.k) > 0.0f) {
            ((UGTextView) this.gc).setLetterSpacing(this.fp / gz.z(this.g, this.k));
        }
    }

    private void gz() {
        ((UGTextView) this.gc).setLineSpacing(0.0f, this.bw);
    }

    private void jq() {
        if (this.bw <= 3.0f) {
            ((UGTextView) this.gc).setLineSpacing(0.0f, this.bw);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(gz.z(this.g, (this.bw - (this.k * 1.2f)) / 2.0f));
            ((UGTextView) this.gc).setPadding(((UGTextView) this.gc).getPaddingLeft(), ((UGTextView) this.gc).getPaddingTop() + iRound, ((UGTextView) this.gc).getPaddingRight(), ((UGTextView) this.gc).getPaddingBottom() + iRound);
            ((UGTextView) this.gc).setLineHeight(Math.round(gz.z(this.g, this.bw)));
        }
    }

    public void kb(String str) {
        this.z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.z = "";
        }
        ((UGTextView) this.gc).setText(this.z);
    }

    public void m(int i) {
        this.dt = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.gc).setPaintFlags(i);
    }

    public void z(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.gc).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals(QMUISkinValueBuilder.TEXT_COLOR)) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = 11;
                }
                break;
            case -734428249:
                if (str.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                    b = 12;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = 13;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = 14;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = 15;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = 16;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 17;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = Ascii.DC2;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = 19;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.kp = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 1:
                this.dh = com.bytedance.adsdk.ugeno.m.z.z(str2);
                this.zb = true;
                break;
            case 2:
                this.hy = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case 3:
                this.lt = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case 4:
                this.yt = pf(str2);
                break;
            case 5:
                this.wo = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case 6:
                this.wx = v(str2);
                break;
            case 8:
                this.k = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 9:
                this.dt = ls(str2);
                break;
            case 10:
                this.zd = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 11:
                this.te = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 12:
                float fZ = com.bytedance.adsdk.ugeno.m.dl.z(str2, -1.0f);
                this.gy = fZ;
                if (fZ < 1.0f || fZ > 1000.0f) {
                    this.gy = 400.0f;
                }
                break;
            case 13:
                this.bw = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1.0f);
                break;
            case 14:
                this.z = str2;
                break;
            case 15:
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0);
                break;
            case 16:
                this.xf = i(str2);
                break;
            case 17:
                int iZ = com.bytedance.adsdk.ugeno.m.dl.z(str2, Integer.MAX_VALUE);
                this.cb = iZ > 0 ? iZ : Integer.MAX_VALUE;
                break;
            case 18:
                this.xo = wp(str2);
                break;
            case 19:
                this.fp = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt wp(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.xo = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.xo = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.xo = TextUtils.TruncateAt.START;
                break;
            default:
                this.xo = null;
                break;
        }
        return this.xo;
    }

    private TextUtils.TruncateAt i(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int v(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1178781136(0xffffffffb9bd3a30, float:-3.6092242E-4)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r0 == r1) goto L21
            r1 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "bold"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r2
            goto L36
        L21:
            java.lang.String r0 = "normal"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r3
            goto L36
        L2b:
            java.lang.String r0 = "italic"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r4
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3b
            goto L3e
        L3b:
            r2 = r3
            goto L3e
        L3d:
            r2 = r4
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.text.g.v(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int pf(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    b = 0;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    b = 1;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    b = 2;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    b = 3;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    private int ls(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
