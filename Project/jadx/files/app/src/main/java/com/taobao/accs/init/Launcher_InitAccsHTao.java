package com.taobao.accs.init;

import android.app.Application;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Launcher_InitAccsHTao extends Launcher_InitAccs {
    @Override // com.taobao.accs.init.Launcher_InitAccs
    public void init(Application application, HashMap<String, Object> map) {
        Launcher_InitAccs.defaultAppkey = "";
        super.init(application, map);
        com.taobao.accs.client.a.b = "com.taobao.taobao.TaobaoIntentService";
    }
}
