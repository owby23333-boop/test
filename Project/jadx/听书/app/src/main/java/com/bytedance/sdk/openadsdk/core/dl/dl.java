package com.bytedance.sdk.openadsdk.core.dl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.un.hh;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    private static volatile dl g;
    private volatile boolean gz;
    private SharedPreferences uy;
    private AtomicBoolean z = new AtomicBoolean(false);
    private AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f1035a = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger gc = new AtomicInteger(Integer.MAX_VALUE);
    private volatile String m = null;
    private AtomicInteger e = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger fo = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger kb = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger wp = new AtomicInteger(Integer.MAX_VALUE);

    private boolean z(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    private dl() {
    }

    public static dl z() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    public void z(boolean z) {
        this.z.set(z);
        if (z) {
            z("key_support_multiprocess", 1);
        }
    }

    public boolean g() {
        if (!this.gz) {
            this.z.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.gz = true;
        }
        return this.z.get();
    }

    private SharedPreferences wp() {
        return com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sp_bidding_opt_libra", 0);
    }

    public boolean dl() {
        try {
            if (this.f1035a.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.f1035a.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.f1035a.set(this.uy.getInt("key_req_body_opt", 1));
                }
            }
        } catch (Throwable unused) {
        }
        return this.f1035a.get() == 1;
    }

    public String a() {
        try {
            if (TextUtils.isEmpty(this.m)) {
                if (this.z.get()) {
                    this.m = com.bytedance.sdk.component.e.dl.z.g.g("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.m = this.uy.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.m = TextUtils.isEmpty(this.m) ? "api-access.pangolin-sdk-toutiao.com" : this.m;
        return this.m;
    }

    public int gc() {
        try {
            if (this.gc.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.gc.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.gc.set(this.uy.getInt("key_net_queue_limit", 7));
                }
            }
            return this.gc.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public int m() {
        try {
            if (this.e.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.e.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.e.set(this.uy.getInt("key_network_module", 1));
                }
            }
            return this.e.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public int e() {
        try {
            if (this.fo.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.fo.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.fo.set(this.uy.getInt("key_req_build_opt", 1));
                }
            }
            return this.fo.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean gz() {
        try {
            if (this.kb.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.kb.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "_use_pl_", 0));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.kb.set(this.uy.getInt("_use_pl_", 0));
                }
            }
        } catch (Throwable unused) {
        }
        return this.kb.get() == 1;
    }

    public boolean fo() {
        try {
            if (this.wp.get() == Integer.MAX_VALUE) {
                if (this.z.get()) {
                    this.wp.set(com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.uy == null) {
                        this.uy = wp();
                    }
                    this.wp.set(this.uy.getInt("boost_save_config", 0));
                }
                Logger.i("bstsdk", "isBstTwConf get: " + this.wp.get());
            }
            return this.wp.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void z(String str, int i) {
        try {
            if (this.z.get()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.uy == null) {
                this.uy = wp();
            }
            SharedPreferences.Editor editorEdit = this.uy.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    private void z(String str, String str2) {
        try {
            if (this.z.get()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.uy == null) {
                this.uy = wp();
            }
            SharedPreferences.Editor editorEdit = this.uy.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void uy() {
        try {
            com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra");
            SharedPreferences.Editor editorEdit = wp().edit();
            editorEdit.clear();
            editorEdit.apply();
            this.f1035a.set(0);
            this.gc.set(7);
            this.fo.set(0);
        } catch (Throwable unused) {
        }
    }

    public static String z(String str) {
        String strA = z().a();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return String.format("https://%s%s", strA, str);
    }

    public void z(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.m = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.bytedance.sdk.openadsdk.core.a.z.m()) {
                    return;
                }
                z("key_url_ads", strOptString);
                return;
            }
            int i = 1;
            int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
            int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
            this.f1035a.set(iOptInt2);
            int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
            this.gc.set(iOptInt3);
            int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
            this.fo.set(iOptInt4);
            if (!jSONObjectOptJSONObject.optBoolean("_use_pl_", false)) {
                i = 0;
            }
            int iOptInt5 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
            this.wp.set(iOptInt5);
            if (com.bytedance.sdk.openadsdk.core.a.z.m()) {
                return;
            }
            if (this.z.get()) {
                try {
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(iOptInt));
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(iOptInt2));
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(iOptInt3));
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(iOptInt4));
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(i));
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "key_url_ads", strOptString);
                    com.bytedance.sdk.component.e.dl.z.g.z("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(iOptInt5));
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (this.uy == null) {
                this.uy = wp();
            }
            SharedPreferences.Editor editorEdit = this.uy.edit();
            editorEdit.putInt("key_network_module", iOptInt);
            editorEdit.putInt("key_req_body_opt", iOptInt2);
            editorEdit.putInt("key_net_queue_limit", iOptInt3);
            editorEdit.putInt("key_req_build_opt", iOptInt4);
            editorEdit.putInt("_use_pl_", i);
            editorEdit.putString("key_url_ads", strOptString);
            editorEdit.putInt("boost_save_config", iOptInt5);
            editorEdit.commit();
        } catch (Throwable unused2) {
        }
    }

    public void kb() {
        e.z(new fo("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.dl.dl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (dl.this.dl.get()) {
                        return;
                    }
                    dl.this.dl.set(true);
                    dl.this.i();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean zDl = dl();
        if (zDl) {
            com.bytedance.sdk.openadsdk.core.component.splash.z.a.a();
            a.z();
            g.z();
        }
        try {
            if (!com.bytedance.sdk.openadsdk.core.a.z.dl()) {
                String strZ = z("/api/ad/union/ping");
                if (!TextUtils.isEmpty(strZ)) {
                    com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
                    dlVarDl.z(strZ);
                    dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.dl.dl.2
                        @Override // com.bytedance.sdk.component.fo.z.z
                        public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                        }

                        @Override // com.bytedance.sdk.component.fo.z.z
                        public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (zDl) {
            kb.z(3, false);
            z.z(zw.getContext(), 3);
            io.m();
            int i = com.bytedance.sdk.openadsdk.core.i.a.z;
            LogAdapter logAdapter = LogAdapter.z;
            v();
            hh.z(259200000L);
        }
    }

    private void v() {
        com.bytedance.sdk.openadsdk.core.uf.z zVar = new com.bytedance.sdk.openadsdk.core.uf.z();
        uy.g(zVar);
        uy.z();
        uy.a(zVar);
        uy.z(zVar);
        uy.gc(zVar);
        uy.dl(zVar);
        uy.a();
    }

    public boolean z(int i) {
        if (i <= 0) {
            return false;
        }
        return z(i, e());
    }
}
