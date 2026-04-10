package com.bytedance.pangle.m;

import android.os.SystemClock;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.i;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    interface z {
        boolean z(String str, int i);
    }

    public static void z() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, TtmlNode.START);
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((fo.e() || fo.fo() || fo.dl()) && com.bytedance.pangle.gc.a.g(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.gc.gc.g(new Runnable() { // from class: com.bytedance.pangle.m.m.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    m.g();
                }
            });
        }
    }

    public static synchronized void g() {
        Map<String, ?> all = g.z(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (dl().z(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    g.z(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    i.z().dl(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static z dl() {
        if (fo.fo()) {
            return new gc();
        }
        if (fo.e()) {
            return new a();
        }
        if (fo.dl()) {
            return new dl();
        }
        return new z() { // from class: com.bytedance.pangle.m.m.2
            @Override // com.bytedance.pangle.m.m.z
            public boolean z(String str, int i) {
                return true;
            }
        };
    }
}
