package com.bytedance.sdk.component.gz.g.g.z;

import com.bytedance.sdk.component.gz.g.g.g;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.gz.z.gz;
import com.bytedance.sdk.component.utils.wp;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private StringBuffer z = new StringBuffer();
    private AtomicLong g = new AtomicLong(0);
    private AtomicLong dl = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f742a = new AtomicLong(0);
    private AtomicLong gc = new AtomicLong(0);
    private AtomicLong m = new AtomicLong(0);
    private AtomicLong e = new AtomicLong(0);
    private AtomicLong gz = new AtomicLong(0);
    private AtomicLong fo = new AtomicLong(0);
    private AtomicLong uy = new AtomicLong(0);
    private AtomicLong kb = new AtomicLong(0);
    private AtomicLong wp = new AtomicLong(0);
    private AtomicLong i = new AtomicLong(0);
    private AtomicLong v = new AtomicLong(0);
    private AtomicLong pf = new AtomicLong(0);
    private AtomicLong ls = new AtomicLong(0);
    private AtomicLong p = new AtomicLong(0);
    private AtomicLong fv = new AtomicLong(0);
    private AtomicLong js = new AtomicLong(0);
    private AtomicLong tb = new AtomicLong(0);
    private AtomicLong q = new AtomicLong(0);
    private AtomicLong iq = new AtomicLong(0);
    private AtomicLong zw = new AtomicLong(0);
    private AtomicLong io = new AtomicLong(0);

    public AtomicLong z() {
        return this.io;
    }

    public AtomicLong g() {
        return this.zw;
    }

    public AtomicLong dl() {
        return this.iq;
    }

    public AtomicLong a() {
        return this.q;
    }

    public AtomicLong gc() {
        return this.i;
    }

    public synchronized void z(long j) {
        this.g.getAndAdd(j);
        this.dl.incrementAndGet();
    }

    public JSONObject z(long j, gc gcVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = fo().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (wp().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = gz().get();
            jSONObject.put("save_upload_cost_ts_avg", (i().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.i.get());
            jSONObject.put("all_delete_count", v().get());
            jSONObject.put("success_delete_count", pf().get());
            jSONObject.put("invalid_delete_count", ls().get());
            jSONObject.put("will_save_count", p().get());
            jSONObject.put("did_send_count", uy().get());
            jSONObject.put("send_success_valid_count", fv().get());
            long j5 = e().get();
            jSONObject.put("send_success_invalid_count", js().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", kb().get());
            jSONObject.put("success_tm", a().get());
            jSONObject.put("queue_timeout_tm", dl().get());
            jSONObject.put("after_upload_tm", g().get());
            jSONObject.put("quit_tm", z().get());
            long j6 = q().get();
            long j7 = iq().get();
            jSONObject.put("success_request_cost_ts_avg", (zw().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = io().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", tb().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", gcVar.kb());
            jSONObject.put("app_start_time", g.dl);
            jSONObject.put("app_first_time", g.f739a);
            jSONObject.put("fail_code_list", this.z.toString());
            a aVarA = gcVar.a();
            if (aVarA != null) {
                jSONObject.put("is_debug", aVarA.z());
                gz gzVarWp = aVarA.wp();
                if (gzVarWp != null) {
                    jSONObject.put("is_plugin", gzVarWp.gz());
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObject;
    }

    public synchronized void m() {
        i().set(0L);
        q().set(0L);
        iq().set(0L);
        tb().set(0L);
        io().set(0L);
        zw().set(0L);
        js().set(0L);
        fv().set(0L);
        ls().set(0L);
        wp().set(0L);
        v().set(0L);
        p().set(0L);
        pf().set(0L);
        uy().set(0L);
        gz().set(0L);
        fo().set(0L);
        e().set(0L);
        kb().set(0L);
        a().set(0L);
        dl().set(0L);
        g().set(0L);
        z().set(0L);
        try {
            if (this.z.length() != 0) {
                this.z.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong e() {
        return this.fo;
    }

    public AtomicLong gz() {
        return this.gc;
    }

    public AtomicLong fo() {
        return this.dl;
    }

    public AtomicLong uy() {
        return this.kb;
    }

    public AtomicLong kb() {
        return this.tb;
    }

    public AtomicLong wp() {
        return this.g;
    }

    public AtomicLong i() {
        return this.f742a;
    }

    public AtomicLong v() {
        return this.m;
    }

    public AtomicLong pf() {
        return this.e;
    }

    public AtomicLong ls() {
        return this.gz;
    }

    public AtomicLong p() {
        return this.uy;
    }

    public AtomicLong fv() {
        return this.wp;
    }

    public AtomicLong js() {
        return this.v;
    }

    public AtomicLong tb() {
        return this.pf;
    }

    public AtomicLong q() {
        return this.ls;
    }

    public AtomicLong iq() {
        return this.p;
    }

    public AtomicLong zw() {
        return this.fv;
    }

    public AtomicLong io() {
        return this.js;
    }

    public StringBuffer uf() {
        return this.z;
    }
}
