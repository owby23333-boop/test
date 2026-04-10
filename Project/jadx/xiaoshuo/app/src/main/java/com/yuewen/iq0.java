package com.yuewen;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktLayoutOption;
import com.duokan.kernel.txtlib.DktRenderTextInfo;
import com.duokan.kernel.txtlib.DktRenderer;
import com.duokan.reader.BaseEnv;
import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public class iq0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DktLayoutOption f12560a = new DktLayoutOption();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12561b = "";
    public final RectF c = new RectF();
    public final Rect d = new Rect();
    public final Point e = new Point();
    public final Paint f = new Paint();
    public final Rect g = new Rect();
    public final Rect h = new Rect();
    public int i = 19;
    public double j = w51.l;
    public boolean k = false;
    public int l = 0;
    public int m = 0;
    public Typeface n = null;
    public Typeface o = null;
    public DktRenderTextInfo p = null;
    public String q = "";
    public String r = null;
    public int s = -16777216;
    public int t = Integer.MAX_VALUE;
    public TextUtils.TruncateAt u = TextUtils.TruncateAt.END;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public static final DktRenderer y = new DktRenderer();
    public static String z = null;
    public static String A = null;
    public static Typeface B = null;
    public static Typeface C = null;

    public iq0() {
        if (z == null) {
            z = BaseEnv.get().r1().getAbsolutePath();
            A = BaseEnv.get().q1().getAbsolutePath();
            try {
                Typeface typefaceA = BaseEnv.get().A(z);
                C = typefaceA;
                B = typefaceA;
            } catch (Throwable unused) {
            }
        }
        DktLayoutOption dktLayoutOption = this.f12560a;
        dktLayoutOption.mFontSize = 16.0d;
        dktLayoutOption.mLineGap = 1.2d;
        dktLayoutOption.mParaSpacing = 1.2d - 1.0d;
        dktLayoutOption.mTabStop = 4.0d;
        dktLayoutOption.mIndent = w51.l;
        dktLayoutOption.mZhFontPath = z;
        dktLayoutOption.mEnFontPath = A;
        dktLayoutOption.mAlignType = e(this.i);
        this.f.setAntiAlias(true);
        this.f.setSubpixelText(true);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize((float) this.f12560a.mFontSize);
        this.f.setColor(this.s);
    }

    public static int a(int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i < 0) {
            return 0;
        }
        int[] iArr = dktRenderTextInfo.mCharCharsets;
        if (i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    public static boolean b(RectF rectF, int i, DktRenderTextInfo dktRenderTextInfo) {
        if (i < 0) {
            return false;
        }
        int i2 = i * 2;
        int i3 = i2 + 1;
        float[] fArr = dktRenderTextInfo.mCharTopLefts;
        if (i3 >= fArr.length) {
            return false;
        }
        float[] fArr2 = dktRenderTextInfo.mCharBottomRights;
        if (i3 >= fArr2.length || i3 >= dktRenderTextInfo.mCharXYs.length) {
            return false;
        }
        rectF.left = fArr[i2];
        rectF.top = fArr[i3];
        rectF.right = fArr2[i2];
        rectF.bottom = fArr2[i3];
        return true;
    }

    public static int d(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public void A(boolean z2) {
        this.x = z2;
    }

    public void B(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
            r();
        }
    }

    public void C(double d) {
        double dMax = Math.max(w51.l, d);
        if (Double.compare(this.j, dMax) != 0) {
            this.j = dMax;
            s();
        }
    }

    public void D(int i) {
        if (this.i != i) {
            this.i = i;
            this.f12560a.mAlignType = e(i);
            this.p = null;
            s();
        }
    }

    public void E(double d) {
        double dMax = Math.max(1.0d, d);
        if (Double.compare(this.f12560a.mLineGap, dMax) != 0) {
            this.f12560a.mLineGap = dMax;
            s();
        }
    }

    public void F(int i) {
        int iMax = Math.max(1, i);
        if (this.t != iMax) {
            this.t = iMax;
            s();
        }
    }

    public void G(double d) {
        double dMax = Math.max(w51.l, d);
        if (Double.compare(this.f12560a.mParaSpacing, dMax) != 0) {
            this.f12560a.mParaSpacing = dMax;
            s();
        }
    }

    public void H(double d) {
        if (Double.compare(this.f12560a.mTabStop, d) != 0) {
            this.f12560a.mTabStop = d;
            s();
        }
    }

    public void I(String str) {
        String str2 = this.q;
        this.q = str;
        if (TextUtils.equals(str2, str)) {
            return;
        }
        this.r = null;
        s();
    }

    public void J(int i) {
        if (this.s != i) {
            this.s = i;
            this.f.setColor(i);
            invalidateSelf();
        }
    }

    public void K(int i) {
        DktLayoutOption dktLayoutOption = this.f12560a;
        double d = i;
        if (dktLayoutOption.mFontSize != d) {
            dktLayoutOption.mFontSize = d;
            this.p = null;
            this.f.setTextSize(i);
            s();
        }
    }

    public void L(File file) {
        try {
            this.f12560a.mZhFontPath = file.getAbsolutePath();
            this.n = Typeface.createFromFile(this.f12560a.mEnFontPath);
            s();
        } catch (Throwable unused) {
        }
    }

    public final String M(String str, int i, int i2) {
        try {
            return str.substring(str.offsetByCodePoints(0, i), str.offsetByCodePoints(0, i2));
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean c() {
        return this.w;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.iq0.draw(android.graphics.Canvas):void");
    }

    public final int e(int i) {
        int i2 = i & 7;
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 5 ? 3 : 1;
        }
        return 0;
    }

    public final Typeface f() {
        Typeface typeface = this.o;
        return typeface != null ? typeface : C;
    }

    public double g() {
        return this.f12560a.mIndent;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        w();
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        w();
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        v();
        return this.p.mLineCount;
    }

    public double i() {
        return this.f12560a.mLineGap;
    }

    public double j() {
        return this.f12560a.mParaSpacing;
    }

    public final String k() {
        String str = TextUtils.isEmpty(this.q) ? "" : this.q;
        if (!this.w) {
            return str;
        }
        if (this.r == null) {
            this.r = DkUtils.chs2chtText(str);
        }
        return this.r;
    }

    public double l() {
        return this.f12560a.mTabStop;
    }

    public String m() {
        return this.q;
    }

    public Rect n() {
        v();
        return this.h;
    }

    public String o(RectF rectF) {
        v();
        StringBuilder sb = new StringBuilder();
        RectF rectFA = e84.n.a();
        int i = 0;
        int i2 = 0;
        while (i < this.q.length()) {
            int i3 = i + 1;
            String strSubstring = this.q.substring(i, i3);
            int i4 = i + i2;
            String strSubstring2 = this.p.mChars.substring(i4, i4 + 1);
            if (!strSubstring2.equals(strSubstring)) {
                i2--;
                sb.append(strSubstring);
            } else {
                if (!b(rectFA, i4, this.p) || rectFA.isEmpty() || !rectF.contains(rectFA)) {
                    break;
                }
                sb.append(strSubstring2);
            }
            i = i3;
        }
        e84.n.d(rectFA);
        return sb.toString();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.equals(this.g)) {
            return;
        }
        r();
        if (rect.width() != this.g.width() || rect.height() != this.g.height()) {
            s();
        }
        this.g.set(rect);
    }

    public float p() {
        return (float) this.f12560a.mFontSize;
    }

    public final Typeface q() {
        return this.o != null ? this.n : B;
    }

    public final void r() {
        this.p = null;
        invalidateSelf();
    }

    public final void s() {
        this.k = false;
        r();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean t() {
        v();
        return this.p.mFollowAfter;
    }

    public boolean u() {
        return this.k;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v31 int, still in use, count: 3, list:
          (r3v31 int) from 0x008b: ARITH (r12v3 int) = (r3v31 int) * (2 int)
          (r3v31 int) from 0x00ac: INVOKE (r11v4 java.lang.String), (r3v31 int) VIRTUAL call: java.lang.String.substring(int):java.lang.String A[MD:(int):java.lang.String (c), WRAPPED]
          (r3v31 int) from 0x00dc: ARITH (r3v31 int) + (r11v14 int) A[WRAPPED]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:106)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:90)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:141)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:116)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    public final void v() {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.iq0.v():void");
    }

    public final void w() {
        DkBox renderBoxByHeight;
        if (this.k) {
            return;
        }
        Rect bounds = getBounds();
        DktLayoutOption dktLayoutOption = this.f12560a;
        int i = this.t;
        dktLayoutOption.mIndent = (i <= 1 || dktLayoutOption.mAlignType == 2) ? w51.l : this.j;
        if (i < Integer.MAX_VALUE) {
            renderBoxByHeight = y.getRenderBoxByLineCount(k(), this.f12560a, bounds.width(), this.t, this.u == TextUtils.TruncateAt.END);
        } else {
            renderBoxByHeight = y.getRenderBoxByHeight(k(), this.f12560a, bounds.width(), bounds.height(), this.u == TextUtils.TruncateAt.END);
        }
        float f = renderBoxByHeight.mX1 - renderBoxByHeight.mX0;
        float f2 = renderBoxByHeight.mY1 - renderBoxByHeight.mY0;
        this.l = Math.round(f);
        this.m = Math.round(f2);
        this.k = true;
    }

    public void x(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            s();
        }
    }

    public void y(TextUtils.TruncateAt truncateAt) {
        TextUtils.TruncateAt truncateAt2 = this.u;
        TextUtils.TruncateAt truncateAt3 = TextUtils.TruncateAt.MIDDLE;
        if (truncateAt != truncateAt3) {
            truncateAt3 = TextUtils.TruncateAt.END;
        }
        this.u = truncateAt3;
        if (truncateAt3 != truncateAt2) {
            this.p = null;
            s();
        }
    }

    public void z(File file) {
        try {
            this.f12560a.mEnFontPath = file.getAbsolutePath();
            this.o = Typeface.createFromFile(this.f12560a.mEnFontPath);
            s();
        } catch (Throwable unused) {
        }
    }
}
