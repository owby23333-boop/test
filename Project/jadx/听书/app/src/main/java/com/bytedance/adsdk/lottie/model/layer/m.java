package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.tb;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class m extends e {
    private final LinearLayout.LayoutParams fo;
    private LinearLayout gz;
    private z i;
    private final List<TextView> kb;
    private SpannableStringBuilder pf;
    private final List<String> uy;
    private SpannableStringBuilder v;
    private String wp;

    public m(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, Context context) {
        List<fo.g> listDl;
        super(gzVar, gzVar2);
        this.fo = new LinearLayout.LayoutParams(-2, -2);
        this.uy = new ArrayList();
        this.kb = new ArrayList();
        if (this.e == null || (listDl = this.e.dl()) == null || listDl.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.gz = linearLayout;
        linearLayout.setOrientation(0);
        g(listDl.get(0).fo);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.gz.addView(linearLayout2);
        List<String> listV = v();
        int i = 0;
        while (i < listDl.size()) {
            fo.g gVar = listDl.get(i);
            TextView textView = new TextView(context);
            z(textView, gVar, (listV == null || i >= listV.size()) ? "" : listV.get(i), i, listDl.size() - 1, listDl.get(0));
            if (gVar.gz != 0) {
                this.fo.bottomMargin = (int) (gVar.gz * com.bytedance.adsdk.lottie.gc.fo.z());
                linearLayout2.addView(textView, this.fo);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        z(this.gz, (int) (this.e.z() * fZ), (int) (this.e.g() * fZ));
    }

    private void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gz.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals(TtmlNode.LEFT)) {
            this.gz.setGravity(19);
        } else if (str.equals(TtmlNode.RIGHT)) {
            this.gz.setGravity(21);
        } else {
            this.gz.setGravity(17);
        }
    }

    private void z(TextView textView, fo.g gVar, String str, int i, int i2, fo.g gVar2) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            str = "";
            textView.setText("");
        }
        if (!TextUtils.isEmpty(gVar.dl)) {
            textView.setTextColor(Color.parseColor(gVar.dl));
        } else if (!TextUtils.isEmpty(gVar.f144a)) {
            textView.setTextColor(Color.parseColor(gVar.f144a));
        }
        if (!TextUtils.isEmpty(gVar.gc)) {
            textView.setBackgroundColor(Color.parseColor(gVar.gc));
        }
        if (gVar.e == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, gVar.m);
        if (gVar.uy != null && gVar.uy.z > 0 && !TextUtils.isEmpty(gVar.uy.g)) {
            if (this.v == null) {
                this.v = new SpannableStringBuilder(str);
            }
            if (this.i == null) {
                this.i = new z();
            }
            this.i.g = Color.parseColor(gVar.uy.g);
            this.i.dl = gVar.uy.z * com.bytedance.adsdk.lottie.gc.fo.z();
            this.v.clear();
            this.v.clearSpans();
            this.v.append((CharSequence) str);
            this.v.setSpan(this.i, 0, str.length(), 33);
            textView.setText(this.v);
        }
        if (gVar.kb != null && gVar.kb.z > 0 && !TextUtils.isEmpty(gVar.kb.g)) {
            if (this.pf == null) {
                this.pf = new SpannableStringBuilder(str);
            }
            if (this.i == null) {
                this.i = new z();
            }
            this.i.f187a = Color.parseColor(gVar.kb.g);
            this.i.gc = gVar.kb.z * com.bytedance.adsdk.lottie.gc.fo.z();
            this.pf.clear();
            this.pf.clearSpans();
            this.pf.append((CharSequence) str);
            this.pf.setSpan(this.i, 0, str.length(), 33);
            textView.setText(this.pf);
        }
        if (gVar2.i > 0) {
            textView.setMaxLines(gVar2.i);
            if (gVar2.wp == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (gVar2.wp == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (gVar2.wp == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.e, com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.gz != null) {
            canvas.save();
            canvas.concat(matrix);
            z(i);
            dl(gz());
            this.gz.draw(canvas);
            canvas.restore();
            return;
        }
        super.g(canvas, matrix, i);
    }

    private void dl(float f) {
        List<fo.g> listDl;
        if (this.e == null || (listDl = this.e.dl()) == null || listDl.size() <= 0) {
            return;
        }
        this.gz.setOrientation(0);
        g(listDl.get(0).fo);
        if (this.gz.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.gz.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.gz.removeAllViews();
        if (linearLayout.getChildCount() != listDl.size()) {
            return;
        }
        List<String> listV = v();
        this.kb.clear();
        int i = 0;
        while (i < listDl.size()) {
            fo.g gVar = listDl.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.kb.add(textView);
            z(textView, gVar, (listV == null || i >= listV.size()) ? "" : listV.get(i), i, listDl.size() - 1, listDl.get(0));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listDl.size(); i2++) {
            fo.g gVar2 = listDl.get(i2);
            TextView textView2 = this.kb.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (gVar2.gz != 0) {
                this.fo.bottomMargin = (int) (gVar2.gz * com.bytedance.adsdk.lottie.gc.fo.z());
                linearLayout.addView(textView2, this.fo);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.gz.setAlpha(f);
        this.gz.addView(linearLayout);
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
        z(this.gz, (int) (this.e.z() * fZ), (int) (this.e.g() * fZ));
    }

    private List<String> v() {
        tb tbVarUf;
        List<fo.g> listDl;
        if (this.e == null || this.g == null || (tbVarUf = this.g.uf()) == null) {
            return null;
        }
        String strA = this.e.a();
        if ((!TextUtils.isEmpty(strA) || !TextUtils.isEmpty(this.wp)) && (listDl = this.e.dl()) != null) {
            String strZ = this.wp;
            if (TextUtils.isEmpty(strZ)) {
                strZ = tbVarUf.z(strA);
            }
            if (!TextUtils.isEmpty(strZ)) {
                int length = strZ.length();
                this.uy.clear();
                for (int i = 0; i < listDl.size(); i++) {
                    fo.g gVar = listDl.get(i);
                    int iMax = gVar.z;
                    int iMax2 = gVar.g;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.uy.add("");
                    } else {
                        if (listDl.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.uy.add(strZ.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.uy;
            }
        }
        return null;
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void z(String str) {
        this.wp = str;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class z implements LineBackgroundSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f187a;
        private float dl;
        private int g;
        private float gc;
        private final Paint z = new Paint();

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.dl > 0.0f) {
                this.z.setColor(this.g);
                this.z.setStrokeWidth(this.dl);
                float f = i4 + this.dl;
                canvas.drawLine(i, f, i2, f, this.z);
            }
            if (this.gc > 0.0f) {
                this.z.setColor(this.f187a);
                this.z.setStrokeWidth(this.gc);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.z);
            }
        }
    }
}
