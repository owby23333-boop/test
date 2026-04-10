package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.g.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<RichTextView> {
    private int cb;
    private int dt;
    private float k;
    private int o;
    private int wo;
    private String wx;
    private String yt;
    private String z;

    public z(Context context) {
        super(context);
        this.cb = Integer.MAX_VALUE;
        this.dt = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public RichTextView z() {
        RichTextView richTextView = new RichTextView(this.g);
        richTextView.z(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((RichTextView) this.gc).setRichText(this.z);
        ((RichTextView) this.gc).setTextSize(1, this.k);
        ((RichTextView) this.gc).setTextColor(this.wo);
        ((RichTextView) this.gc).setLines(this.o);
        ((RichTextView) this.gc).setMaxLines(this.cb);
        ((RichTextView) this.gc).setGravity(this.dt);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.dt = kb(str2);
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
            case "text":
                this.z = str2;
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
        }
    }

    private int kb(String str) {
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
