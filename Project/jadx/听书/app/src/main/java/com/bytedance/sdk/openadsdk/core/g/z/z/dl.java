package com.bytedance.sdk.openadsdk.core.g.z.z;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.g.z.z.z;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    private e e;
    private boolean gz;
    private int m;

    @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z, com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.g.z.dl dlVar) {
        boolean z;
        g(this.z.lt());
        dl();
        final z.InterfaceC0171z interfaceC0171zZ = this.gc.z();
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.z.dl.1
            @Override // java.lang.Runnable
            public void run() {
                z.InterfaceC0171z interfaceC0171z = interfaceC0171zZ;
                if (interfaceC0171z != null) {
                    interfaceC0171z.z(dl.this.f1076a, dl.this.gc.dl());
                }
            }
        });
        Map<String, Object> mapGz = this.gc.gz();
        String strQ = this.dl.q();
        if (TextUtils.isEmpty(strQ)) {
            strQ = "clickEvent";
        }
        String str = strQ;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapGz.put("click_from_uchain", 1);
        mapGz.put("event_type", str);
        eo.hh();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.z);
        map2.put("click_chain", dlVar);
        map2.put("dpa_tag", this.dl.tb());
        map2.put(d.R, this.g);
        map2.put("event_tag", this.gc.fo());
        map2.put("source", Integer.valueOf(this.gc.e()));
        map2.put("view", this.f1076a);
        if (this.f1076a instanceof TextView) {
            CharSequence text = ((TextView) this.f1076a).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.f1076a instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.dl.z()));
        map2.put("handle_chain_data", map);
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarM = this.gc.m();
        if (dlVarM != null) {
            map2.put("download_adapter", dlVarM);
            map2.put("is_market_covert", Boolean.valueOf(dlVarM.dl()));
            map2.putAll(dlVarM.gc());
        }
        Map<String, Object> mapZ = com.bytedance.sdk.component.kb.gc.z.z().z(this.z.hashCode() + this.z.aq());
        this.e = (e) io.z(this.z.xn(), e.class);
        Object objRemove = mapZ.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.gz = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(gz()));
        map2.putAll(mapZ);
        map2.put("convert_from_downloader", Boolean.FALSE);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.gc.g()));
        map2.put("pip_controller", this.gc.wp());
        com.bytedance.sdk.openadsdk.core.fo.z.z.g.z zVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.g.z(this.z, this.g, this.gc.fo(), this.gc.e());
        zVar.z(!gz() && this.gc.a());
        zVar.g(this.gc.uy());
        map2.put("is_open_web_page", Boolean.FALSE);
        zVar.g(map2);
        map2.put("activity_type", Integer.valueOf(eo.z(zVar.z())));
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.dl.z()));
        com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(this.z, mapGz, str, map2, this.gc.fo(), new HashMap());
        a();
        return 0;
    }

    private boolean gz() {
        return fo() && g(this.f1076a) && !this.gc.g();
    }

    private boolean g(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387664 || view.getId() == 2114387957 || view.getId() == 2114387764 || view.getId() == 2114387686 || view.getId() == 2114387626) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (g(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean fo() {
        if (this.z == null || uy() || !na.g(this.z)) {
            return false;
        }
        if (this.m == 0) {
            this.m = eo.gz(this.z);
        }
        gc();
        e();
        m();
        if (this.m == 5 && kb() && e() && !gc() && !m()) {
            return false;
        }
        int i = this.m;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean uy() {
        return this.gz;
    }

    public boolean gc() {
        e eVar = this.e;
        if (eVar == null) {
            return false;
        }
        return eVar.z();
    }

    public boolean m() {
        e eVar = this.e;
        if (eVar == null) {
            return false;
        }
        return eVar.g();
    }

    protected boolean e() {
        if (this.z == null) {
            return true;
        }
        int iE = zw.g().e(eo.fo(this.z));
        if (iE == 1) {
            return v.a(this.g);
        }
        if (iE == 2) {
            return v.gc(this.g) || v.a(this.g) || v.m(this.g);
        }
        if (iE != 3) {
            return iE != 5 || v.a(this.g) || v.m(this.g);
        }
        return false;
    }

    private boolean kb() {
        return this.z != null && this.z.f() == 1 && na.g(this.z);
    }
}
