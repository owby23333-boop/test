package com.bytedance.pangle.e;

import android.os.RemoteException;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a;
import com.bytedance.pangle.dl;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.uy;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl.z {
    private static volatile z z;

    public static z g() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.pangle.dl
    public boolean z(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.dl
    public int g(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.bytedance.pangle.dl
    public boolean z(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.dl
    public void z(int i, a aVar) throws RemoteException {
        Zeus.registerPluginStateListener(new dl(aVar, i));
    }

    @Override // com.bytedance.pangle.dl
    public void z(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listDl = uy.z().dl();
        Iterator<ZeusPluginStateListener> it = listDl.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof dl) && ((dl) next).z() == i) {
                break;
            }
        }
        if (next != null) {
            listDl.remove(next);
        }
    }
}
