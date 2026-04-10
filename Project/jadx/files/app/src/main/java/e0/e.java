package e0;

import android.content.Context;
import com.kuaishou.weapon.p0.bh;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: UpdateUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final List<String> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("com.tencent.mm");
        arrayList.add("com.eg.android.AlipayGphone");
        arrayList.add("com.xunmeng.pinduoduo");
        arrayList.add(AgooConstants.TAOBAO_PACKAGE);
        arrayList.add("com.baidu.searchbox");
        arrayList.add(TbsConfig.APP_QQ);
        arrayList.add(TbsConfig.APP_QB);
        arrayList.add("com.ss.android.ugc.aweme");
        arrayList.add("com.snda.wifilocating");
        arrayList.add("com.autonavi.minimap");
        arrayList.add("com.smile.gifmaker");
        arrayList.add("com.tencent.qqlive");
        arrayList.add("com.sankuai.meituan");
        arrayList.add("com.jingdong.app.mall");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.bytedance.ad.deliver");
        arrayList.add("com.bytedance.ad.videotool");
        arrayList.add("com.ss.android.lark");
        arrayList.add("com.taou.maimai");
        arrayList.add("com.kwad.demo");
        arrayList.add("com.union_test.toutiao");
        arrayList.add("com.qq.e.union.demo");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r11, com.sntech.ads.ISNADS r12) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.e.a(android.content.Context, com.sntech.ads.ISNADS):org.json.JSONObject");
    }

    public static boolean a() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"which", bh.f16586y});
            try {
                if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
                    processExec.destroy();
                    return true;
                }
                processExec.destroy();
                return false;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }

    public static String a(Context context) {
        try {
            return g.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
