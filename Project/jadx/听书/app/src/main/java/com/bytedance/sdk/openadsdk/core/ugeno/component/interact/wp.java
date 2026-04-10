package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends com.bytedance.adsdk.ugeno.g.dl<InteractWebView> {
    private Map<String, Object> wo;
    private String z;

    public wp(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public InteractWebView z() {
        this.gc = new InteractWebView(this.g);
        return (InteractWebView) this.gc;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        this.wo = this.fo.g();
        ((InteractWebView) this.gc).setUGenExtraMap(this.wo);
        ((InteractWebView) this.gc).setUGenContext(this.fo);
        ((InteractWebView) this.gc).m();
        ((InteractWebView) this.gc).e();
        JSONObject jSONObjectUy = uy();
        if (jSONObjectUy != null) {
            com.bytedance.sdk.component.widget.g.z zVar = new com.bytedance.sdk.component.widget.g.z();
            zVar.z(jSONObjectUy.optInt("meta_hashcode", 0));
            ((InteractWebView) this.gc).setMaterialMeta(zVar);
        }
        gz();
    }

    public void gz() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.gc).loadUrl(this.z);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        if (str.equals(QMUISkinValueBuilder.SRC)) {
            if (TextUtils.isEmpty(this.z) || !this.z.startsWith("http")) {
                this.z = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.z = str2;
            }
        }
    }
}
