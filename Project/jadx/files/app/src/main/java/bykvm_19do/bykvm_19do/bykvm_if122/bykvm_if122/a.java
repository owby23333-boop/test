package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.Context;
import android.location.Address;
import anet.channel.strategy.dispatch.DispatchConstants;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b {
    private Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f1722c = "sp_multi_ttmadnet_config";
    private final e0 b = e0.a(this.f1722c, g());

    public a(Context context) {
        this.a = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public Address a(Context context) {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String a(Context context, String str, String str2) {
        return this.b.a(str, str2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.b.b(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.b.b(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.b.b(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.b.b(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.b.b(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String[] a() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String b() {
        return DispatchConstants.ANDROID;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int c() {
        return 4741;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String d() {
        return com.anythink.expressad.foundation.g.a.D;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int e() {
        return com.bytedance.msdk.base.b.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String f() {
        return w.d(this.a);
    }

    public Context g() {
        return this.a;
    }
}
