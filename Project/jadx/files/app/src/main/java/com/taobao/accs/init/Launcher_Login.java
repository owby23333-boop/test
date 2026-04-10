package com.taobao.accs.init;

import android.app.Application;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Launcher_Login implements Serializable {
    public void init(Application application, HashMap<String, Object> map) {
        ALog.i("Launcher_Login", "login", new Object[0]);
        ThreadPoolExecutorFactory.execute(new e(this, map));
    }
}
