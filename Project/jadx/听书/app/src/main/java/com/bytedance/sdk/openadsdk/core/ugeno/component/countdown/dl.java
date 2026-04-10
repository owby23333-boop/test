package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class dl extends com.bytedance.adsdk.ugeno.widget.text.g {
    private String cb;
    private String k;
    private String o;
    private String wx;
    private String yt;

    public dl(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        wp(this.z);
        ((UGTextView) this.gc).setGravity(17);
    }

    public void z(int i, int i2, int i3, boolean z, boolean z2) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put("index", i2);
            jSONObject.put("count", i3);
            boolean z3 = i2 == 1;
            if (z) {
                if (z3) {
                    str = this.cb;
                } else {
                    str = this.o;
                }
            } else if (z2) {
                str = this.wx;
            } else {
                str = this.k;
            }
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            this.yt = string;
            wp(string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    protected void wp(String str) {
        ((UGTextView) this.gc).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.gc).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                a((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.k = str2;
                break;
            case "text2":
                this.wx = str2;
                break;
            case "text3":
                this.cb = str2;
                break;
            case "text4":
                this.o = str2;
                break;
        }
    }
}
