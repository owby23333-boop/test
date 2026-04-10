package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.dt;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
public class lt extends xo<dt> {
    final hy g;
    final te z;

    @Override // com.bytedance.embedapplog.xo, com.bytedance.embedapplog.gm
    public /* bridge */ /* synthetic */ boolean z(Context context) {
        return super.z(context);
    }

    lt() {
        super("com.hihonor.id");
        this.z = new te();
        this.g = new hy();
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<dt, String> z() {
        return new uy.g<dt, String>() { // from class: com.bytedance.embedapplog.lt.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public dt z(IBinder iBinder) {
                return dt.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(dt dtVar) {
                if (dtVar == null) {
                    com.bytedance.sdk.component.utils.wp.a("honor# ", "service is null");
                    return null;
                }
                dtVar.z(lt.this.z);
                dtVar.g(lt.this.g);
                return "";
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.xo, com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        new uy(context, dl(context), z()).z();
        gm.z zVar = new gm.z();
        zVar.g = this.z.g();
        zVar.dl = this.g.g();
        return zVar;
    }
}
