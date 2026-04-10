package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.g;
import com.bytedance.adsdk.lottie.model.g.ls;
import com.bytedance.adsdk.lottie.z.g.pf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends dl {
    private final StringBuilder e;
    private final Matrix fo;
    private com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> fv;
    private final RectF gz;
    private com.bytedance.adsdk.lottie.z.g.z<Typeface, Typeface> hh;
    private final LongSparseArray<String> i;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> io;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> iq;
    private com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> js;
    private final Paint kb;
    private final com.bytedance.adsdk.lottie.gz ls;
    private final com.bytedance.adsdk.lottie.m p;
    private final pf pf;
    private com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> q;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> sy;
    private com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> tb;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> uf;
    private final Paint uy;
    private final List<z> v;
    private final Map<com.bytedance.adsdk.lottie.model.a, List<com.bytedance.adsdk.lottie.z.z.a>> wp;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> zw;

    wp(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        super(gzVar, gzVar2);
        this.e = new StringBuilder(2);
        this.gz = new RectF();
        this.fo = new Matrix();
        int i = 1;
        this.uy = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.wp.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.kb = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.wp.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.wp = new HashMap();
        this.i = new LongSparseArray<>();
        this.v = new ArrayList();
        this.ls = gzVar;
        this.p = gzVar2.z();
        pf pfVarZ = gzVar2.js().z();
        this.pf = pfVarZ;
        pfVarZ.z(this);
        z(pfVarZ);
        com.bytedance.adsdk.lottie.model.z.kb kbVarTb = gzVar2.tb();
        if (kbVarTb != null && kbVarTb.z != null) {
            com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ = kbVarTb.z.z();
            this.fv = zVarZ;
            zVarZ.z(this);
            z(this.fv);
        }
        if (kbVarTb != null && kbVarTb.g != null) {
            com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ2 = kbVarTb.g.z();
            this.tb = zVarZ2;
            zVarZ2.z(this);
            z(this.tb);
        }
        if (kbVarTb != null && kbVarTb.dl != null) {
            com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ3 = kbVarTb.dl.z();
            this.iq = zVarZ3;
            zVarZ3.z(this);
            z(this.iq);
        }
        if (kbVarTb == null || kbVarTb.f188a == null) {
            return;
        }
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ4 = kbVarTb.f188a.z();
        this.io = zVarZ4;
        zVarZ4.z(this);
        z(this.io);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z2) {
        super.z(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.p.a().width(), this.p.a().height());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
        com.bytedance.adsdk.lottie.model.g gVarE = this.pf.e();
        com.bytedance.adsdk.lottie.model.dl dlVar = this.p.ls().get(gVarE.g);
        if (dlVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        z(gVarE, matrix);
        if (this.ls.sy()) {
            z(gVarE, matrix, dlVar, canvas);
        } else {
            z(gVarE, dlVar, canvas);
        }
        canvas.restore();
    }

    private void z(com.bytedance.adsdk.lottie.model.g gVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar = this.js;
        if (zVar != null) {
            this.uy.setColor(zVar.e().intValue());
        } else {
            com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2 = this.fv;
            if (zVar2 != null) {
                this.uy.setColor(zVar2.e().intValue());
            } else {
                this.uy.setColor(gVar.gz);
            }
        }
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar3 = this.q;
        if (zVar3 != null) {
            this.kb.setColor(zVar3.e().intValue());
        } else {
            com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar4 = this.tb;
            if (zVar4 != null) {
                this.kb.setColor(zVar4.e().intValue());
            } else {
                this.kb.setColor(gVar.fo);
            }
        }
        int iIntValue = ((this.f182a.z() == null ? 100 : this.f182a.z().e().intValue()) * 255) / 100;
        this.uy.setAlpha(iIntValue);
        this.kb.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar5 = this.zw;
        if (zVar5 != null) {
            this.kb.setStrokeWidth(zVar5.e().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar6 = this.iq;
        if (zVar6 != null) {
            this.kb.setStrokeWidth(zVar6.e().floatValue());
        } else {
            this.kb.setStrokeWidth(gVar.uy * com.bytedance.adsdk.lottie.gc.fo.z());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.bytedance.adsdk.lottie.model.g r21, android.graphics.Matrix r22, com.bytedance.adsdk.lottie.model.dl r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            com.bytedance.adsdk.lottie.z.g.z<java.lang.Float, java.lang.Float> r0 = r8.sy
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.e()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.dl
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = com.bytedance.adsdk.lottie.gc.fo.z(r22)
            java.lang.String r0 = r9.z
            java.util.List r12 = r8.z(r0)
            int r13 = r12.size()
            int r0 = r9.gc
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            com.bytedance.adsdk.lottie.z.g.z<java.lang.Float, java.lang.Float> r1 = r8.uf
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.e()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
            goto L4c
        L3d:
            com.bytedance.adsdk.lottie.z.g.z<java.lang.Float, java.lang.Float> r1 = r8.io
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r1.e()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4c:
            r14 = r0
            r15 = 0
            r0 = -1
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb3
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.i
            if (r0 != 0) goto L60
            r0 = 0
            goto L64
        L60:
            android.graphics.PointF r0 = r9.i
            float r0 = r0.x
        L64:
            r2 = r0
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.z(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L76:
            int r0 = r6.size()
            if (r5 >= r0) goto Lb0
            java.lang.Object r0 = r6.get(r5)
            com.bytedance.adsdk.lottie.model.layer.wp$z r0 = (com.bytedance.adsdk.lottie.model.layer.wp.z) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = com.bytedance.adsdk.lottie.model.layer.wp.z.z(r0)
            r4 = r24
            r8.z(r4, r9, r7, r1)
            java.lang.String r1 = com.bytedance.adsdk.lottie.model.layer.wp.z.g(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.z(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L76
        Lb0:
            int r6 = r17 + 1
            goto L51
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.wp.z(com.bytedance.adsdk.lottie.model.g, android.graphics.Matrix, com.bytedance.adsdk.lottie.model.dl, android.graphics.Canvas):void");
    }

    private void z(String str, com.bytedance.adsdk.lottie.model.g gVar, com.bytedance.adsdk.lottie.model.dl dlVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.lottie.model.a aVar = this.p.pf().get(com.bytedance.adsdk.lottie.model.a.z(str.charAt(i), dlVar.z(), dlVar.dl()));
            if (aVar != null) {
                z(aVar, f2, gVar, canvas);
                canvas.translate((((float) aVar.g()) * f2 * com.bytedance.adsdk.lottie.gc.fo.z()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.bytedance.adsdk.lottie.model.g r19, com.bytedance.adsdk.lottie.model.dl r20, android.graphics.Canvas r21) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.wp.z(com.bytedance.adsdk.lottie.model.g, com.bytedance.adsdk.lottie.model.dl, android.graphics.Canvas):void");
    }

    private void z(Canvas canvas, com.bytedance.adsdk.lottie.model.g gVar, int i, float f) {
        PointF pointF = gVar.wp;
        PointF pointF2 = gVar.i;
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        float f2 = (i * gVar.m * fZ) + (pointF == null ? 0.0f : (gVar.m * 0.6f * fZ) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.z[gVar.f163a.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.wp$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[g.z.values().length];
            z = iArr;
            try {
                iArr[g.z.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[g.z.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[g.z.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface z(com.bytedance.adsdk.lottie.model.dl dlVar) {
        Typeface typefaceE;
        com.bytedance.adsdk.lottie.z.g.z<Typeface, Typeface> zVar = this.hh;
        if (zVar != null && (typefaceE = zVar.e()) != null) {
            return typefaceE;
        }
        Typeface typefaceZ = this.ls.z(dlVar);
        return typefaceZ != null ? typefaceZ : dlVar.a();
    }

    private List<String> z(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void z(String str, com.bytedance.adsdk.lottie.model.g gVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strZ = z(str, length);
            length += strZ.length();
            z(strZ, gVar, canvas);
            canvas.translate(this.uy.measureText(strZ) + f, 0.0f);
        }
    }

    private List<z> z(String str, float f, com.bytedance.adsdk.lottie.model.dl dlVar, float f2, float f3, boolean z2) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z3 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z2) {
                com.bytedance.adsdk.lottie.model.a aVar = this.p.pf().get(com.bytedance.adsdk.lottie.model.a.z(cCharAt, dlVar.z(), dlVar.dl()));
                if (aVar != null) {
                    fMeasureText = ((float) aVar.g()) * f2 * com.bytedance.adsdk.lottie.gc.fo.z();
                }
            } else {
                fMeasureText = this.uy.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z3 = true;
                f6 = f7;
            } else if (z3) {
                z3 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                z zVarG = g(i);
                if (i3 == i2) {
                    zVarG.z(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    zVarG.z(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            g(i).z(str.substring(i2), f4);
        }
        return this.v.subList(0, i);
    }

    private z g(int i) {
        for (int size = this.v.size(); size < i; size++) {
            this.v.add(new z());
        }
        return this.v.get(i - 1);
    }

    private void z(com.bytedance.adsdk.lottie.model.a aVar, float f, com.bytedance.adsdk.lottie.model.g gVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.z.z.a> listZ = z(aVar);
        for (int i = 0; i < listZ.size(); i++) {
            Path pathA = listZ.get(i).a();
            pathA.computeBounds(this.gz, false);
            this.fo.reset();
            this.fo.preTranslate(0.0f, (-gVar.e) * com.bytedance.adsdk.lottie.gc.fo.z());
            this.fo.preScale(f, f);
            pathA.transform(this.fo);
            if (gVar.kb) {
                z(pathA, this.uy, canvas);
                z(pathA, this.kb, canvas);
            } else {
                z(pathA, this.kb, canvas);
                z(pathA, this.uy, canvas);
            }
        }
    }

    private void z(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void z(String str, com.bytedance.adsdk.lottie.model.g gVar, Canvas canvas) {
        if (gVar.kb) {
            z(str, this.uy, canvas);
            z(str, this.kb, canvas);
        } else {
            z(str, this.kb, canvas);
            z(str, this.uy, canvas);
        }
    }

    private void z(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.z.z.a> z(com.bytedance.adsdk.lottie.model.a aVar) {
        if (this.wp.containsKey(aVar)) {
            return this.wp.get(aVar);
        }
        List<ls> listZ = aVar.z();
        int size = listZ.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.lottie.z.z.a(this.ls, this, listZ.get(i), this.p));
        }
        this.wp.put(aVar, arrayList);
        return arrayList;
    }

    private String z(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!dl(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.i.indexOfKey(j) >= 0) {
            return this.i.get(j);
        }
        this.e.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.e.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.e.toString();
        this.i.put(j, string);
        return string;
    }

    private boolean dl(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class z {
        private float g;
        private String z;

        private z() {
            this.z = "";
            this.g = 0.0f;
        }

        void z(String str, float f) {
            this.z = str;
            this.g = f;
        }
    }
}
