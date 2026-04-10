package com.repack.bun.miitmdid.core;

import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.repack.bun.supplier.IIdentifierListener;
import com.repack.bun.supplier.IdSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import g.b;
import g.c.AsyncTaskC0563c;
import g0.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import v.c;
import v.d;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MdidSdk implements SupplierListener {
    private String _AddId;
    private IIdentifierListener _InnerListener;
    private a _setting;

    /* JADX INFO: renamed from: com.repack.bun.miitmdid.core.MdidSdk$do, reason: invalid class name */
    public static class Cdo {

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static final int[] f64do;

        static {
            int[] iArr = new int[p000else.Cdo.values().length];
            f64do = iArr;
            try {
                iArr[p000else.Cdo.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64do[p000else.Cdo.BLACKSHARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64do[p000else.Cdo.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f64do[p000else.Cdo.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f64do[p000else.Cdo.OPPO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f64do[p000else.Cdo.ONEPLUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f64do[p000else.Cdo.MOTO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f64do[p000else.Cdo.LENOVO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f64do[p000else.Cdo.ASUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f64do[p000else.Cdo.SAMSUNG.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f64do[p000else.Cdo.MEIZU.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f64do[p000else.Cdo.NUBIA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f64do[p000else.Cdo.QIKU.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f64do[p000else.Cdo.ZTE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f64do[p000else.Cdo.FREEMEOS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f64do[p000else.Cdo.SSUIOS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    @Keep
    public MdidSdk() {
        try {
            c.a(true);
        } catch (Exception e2) {
            c.a("mdidsdk", "extractor exception!", e2);
        }
    }

    private void SaveAddid(String str) {
    }

    private int _InnerFailed(int i2, IdSupplier idSupplier) {
        OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
        return i2;
    }

    public String CreateAdditionalId(List<String> list, List<String> list2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    stringBuffer.append(str);
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (String str2 : list2) {
                if (!TextUtils.isEmpty(str2)) {
                    stringBuffer.append(str2);
                }
            }
        }
        String string = stringBuffer.toString();
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes("UTF-8"));
            string = d.a(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | Exception unused) {
        }
        this._AddId = string;
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0128  */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int InitSdk(android.content.Context r8, com.repack.bun.supplier.IIdentifierListener r9) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.repack.bun.miitmdid.core.MdidSdk.InitSdk(android.content.Context, com.repack.bun.supplier.IIdentifierListener):int");
    }

    @Override // com.repack.bun.supplier.SupplierListener
    public void OnSupport(boolean z2, IdSupplier idSupplier) {
        String oaid;
        String vaid;
        String aaid;
        IIdentifierListener iIdentifierListener = this._InnerListener;
        if (iIdentifierListener != null) {
            iIdentifierListener.OnSupport(z2, idSupplier);
        }
        b bVar = new b();
        if (idSupplier != null) {
            oaid = idSupplier.getOAID();
            vaid = idSupplier.getVAID();
            aaid = idSupplier.getAAID();
            if (idSupplier instanceof InnerIdSupplier) {
                ((InnerIdSupplier) idSupplier).shutDown();
            }
        } else {
            oaid = "";
            vaid = oaid;
            aaid = vaid;
        }
        String str = this._AddId;
        if (str == null) {
            str = "";
        }
        try {
            String strA = f0.a.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s&ADDID=%s", "", oaid, vaid, aaid, str));
            v.b.a();
            g.c cVar = new g.c();
            Map<String, String> mapA = bVar.a();
            if (mapA != null && !mapA.isEmpty()) {
                cVar.f20811f.putAll(mapA);
            }
            cVar.f20811f.put("support", String.valueOf(z2 ? 1 : 0));
            cVar.f20808c = strA;
            cVar.a = "http://sdk.api.oaid.wocloud.cn/stat";
            cVar.f20812g = "POST";
            cVar.b = new b.a(bVar);
            cVar.new AsyncTaskC0563c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void UnInitSdk() {
    }

    @Keep
    public MdidSdk(boolean z2) {
        try {
            c.a(z2);
        } catch (Exception e2) {
            c.a("mdidsdk", "extractor exception!", e2);
        }
    }
}
