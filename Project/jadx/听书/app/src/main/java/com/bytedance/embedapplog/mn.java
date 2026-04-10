package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
final class mn {
    static gm z(Context context) {
        if (fo.js()) {
            return new by(new kb());
        }
        if (fo.tb() && kb.z()) {
            return new kb();
        }
        if (bb.z()) {
            return new bb(context);
        }
        if (fo.i() && fo.v()) {
            return new zd();
        }
        if (fo.i() && !fo.v()) {
            return new lt();
        }
        if (fo.z(context) || fo.i()) {
            return new zd();
        }
        if (fo.zw()) {
            return new by();
        }
        if (fo.iq()) {
            return new fp();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (fo.io()) {
                return new jc();
            }
            if (fo.sy()) {
                return new vt();
            }
            if (fo.uf()) {
                return new kp();
            }
            if (fo.hh()) {
                return new eo();
            }
            gy gyVar = new gy(context);
            return gyVar.z(context) ? gyVar : new bw();
        }
        if (fo.pf() || !zd.dl(context)) {
            return null;
        }
        return new zd();
    }
}
