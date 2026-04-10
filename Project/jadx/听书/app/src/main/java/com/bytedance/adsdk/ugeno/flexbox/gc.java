package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends com.bytedance.adsdk.ugeno.g.z<FlexboxLayout> {
    private int cb;
    private int k;
    private int o;
    private int wo;
    private int wx;

    public gc(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: jq, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout z() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.g);
        flexboxLayout.z(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((FlexboxLayout) this.gc).setFlexDirection(this.wo);
        ((FlexboxLayout) this.gc).setFlexWrap(this.k);
        ((FlexboxLayout) this.gc).setJustifyContent(this.wx);
        ((FlexboxLayout) this.gc).setAlignItems(this.cb);
        ((FlexboxLayout) this.gc).setAlignContent(this.o);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public z.C0045z gz() {
        return new z(this);
    }

    public static class z extends z.C0045z {
        public float gk;
        public int h;
        public float hh;
        public float l;
        public int lq;
        public int mc;
        public int sy;
        public int un;
        public int x;

        public z(com.bytedance.adsdk.ugeno.g.z zVar) {
            super(zVar);
            this.sy = 1;
            this.hh = 0.0f;
            this.l = 0.0f;
            this.h = -1;
            this.gk = -1.0f;
            this.x = -1;
            this.lq = -1;
            this.mc = 16777215;
            this.un = 16777215;
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        public void z(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.z(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.gk = a(str2);
                    break;
                case "order":
                    this.sy = z(str2);
                    break;
                case "flexShrink":
                    this.l = dl(str2);
                    break;
                case "flexGrow":
                    this.hh = g(str2);
                    break;
                case "alignSelf":
                    this.h = gc(str2);
                    break;
            }
        }

        private int z(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                wp.z(e);
                return 1;
            }
        }

        private float g(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                wp.z(e);
                return 0.0f;
            }
        }

        private float dl(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                wp.z(e);
                return 0.0f;
            }
        }

        private float a(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                wp.z(e);
                return -1.0f;
            }
        }

        private int gc(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.z z() {
            FlexboxLayout.z zVar = new FlexboxLayout.z((int) this.z, (int) this.g);
            zVar.leftMargin = (int) this.m;
            zVar.rightMargin = (int) this.e;
            zVar.topMargin = (int) this.gz;
            zVar.bottomMargin = (int) this.fo;
            zVar.dl(this.sy);
            zVar.a(this.h);
            zVar.z(this.hh);
            zVar.g(this.l);
            zVar.dl(this.gk);
            return zVar;
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        public String toString() {
            return "LayoutParams{mWidth=" + this.z + ", mHeight=" + this.g + ", mMargin=" + this.gc + ", mMarginLeft=" + this.m + ", mMarginRight=" + this.e + ", mMarginTop=" + this.gz + ", mMarginBottom=" + this.fo + ", mParams=" + this.io + ", mOrder=" + this.sy + ", mFlexGrow=" + this.hh + ", mFlexShrink=" + this.l + ", mAlignSelf=" + this.h + ", mFlexBasisPercent=" + this.gk + ", mMinWidth=" + this.x + ", mMinHeight=" + this.lq + ", mMaxWidth=" + this.mc + ", mMaxHeight=" + this.un + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.cb = v(str2);
                break;
            case "flexDirection":
                this.wo = kb(str2);
                break;
            case "alignContent":
                this.o = pf(str2);
                break;
            case "flexWrap":
                this.k = wp(str2);
                break;
            case "justifyContent":
                this.wx = i(str2);
                break;
        }
    }

    int kb(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int wp(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int i(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int v(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1881872635: goto L35;
                case -1720785339: goto L2b;
                case -1364013995: goto L21;
                case 1384876188: goto L17;
                case 1744442261: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            java.lang.String r0 = "flex_end"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r5
            goto L40
        L17:
            java.lang.String r0 = "flex_start"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r2
            goto L40
        L21:
            java.lang.String r0 = "center"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r4
            goto L40
        L2b:
            java.lang.String r0 = "baseline"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r3
            goto L40
        L35:
            java.lang.String r0 = "stretch"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r1
            goto L40
        L3f:
            r7 = -1
        L40:
            if (r7 == 0) goto L4c
            if (r7 == r5) goto L4b
            if (r7 == r4) goto L4a
            if (r7 == r3) goto L49
            return r1
        L49:
            return r3
        L4a:
            return r4
        L4b:
            return r5
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.gc.v(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int pf(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1881872635: goto L40;
                case -1364013995: goto L36;
                case -932331738: goto L2c;
                case 1384876188: goto L22;
                case 1682480591: goto L18;
                case 1744442261: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "flex_end"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r6
            goto L4b
        L18:
            java.lang.String r0 = "space_between"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r3
            goto L4b
        L22:
            java.lang.String r0 = "flex_start"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r2
            goto L4b
        L2c:
            java.lang.String r0 = "space_around"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r4
            goto L4b
        L36:
            java.lang.String r0 = "center"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r5
            goto L4b
        L40:
            java.lang.String r0 = "stretch"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r1
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L5a
            if (r8 == r6) goto L59
            if (r8 == r5) goto L58
            if (r8 == r4) goto L57
            if (r8 == r3) goto L56
            return r1
        L56:
            return r4
        L57:
            return r3
        L58:
            return r5
        L59:
            return r6
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.gc.pf(java.lang.String):int");
    }
}
