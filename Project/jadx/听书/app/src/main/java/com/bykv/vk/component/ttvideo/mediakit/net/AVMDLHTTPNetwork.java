package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.g.z.dl;
import com.bytedance.sdk.component.g.z.g;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final uy JSON = uy.z("application/json");
    private static wp mClient;
    private g mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new wp().g().z(10L, TimeUnit.SECONDS).dl(10L, TimeUnit.SECONDS).g(10L, TimeUnit.SECONDS).z();
            }
        }
        v.z zVarZ = new v.z().z(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                zVarZ.z(str2, map.get(str2));
            }
        }
        g gVarZ = mClient.z(zVarZ.g());
        this.mCall = gVarZ;
        gVarZ.z(new dl() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.g.z.dl
            public void onFailure(g gVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.g.z.dl
            public void onResponse(g gVar, ls lsVar) throws Throwable {
                p pVarM;
                Throwable th;
                JSONObject jSONObject;
                try {
                    pVarM = lsVar.m();
                } catch (Throwable th2) {
                    pVarM = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject = new JSONObject(pVarM.g());
                        e = null;
                    } catch (Exception e) {
                        e = e;
                        com.bytedance.sdk.component.utils.wp.z(e);
                        jSONObject = null;
                    }
                    if (e == null && !lsVar.a()) {
                        e = new Exception("http fail");
                        lsVar.dl();
                    }
                    if (pVarM != null) {
                        try {
                            pVarM.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (pVarM != null) {
                        try {
                            pVarM.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new wp().g().z(10L, TimeUnit.SECONDS).dl(10L, TimeUnit.SECONDS).g(10L, TimeUnit.SECONDS).z();
            }
        }
        v.z zVarZ = new v.z().z(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                zVarZ.g(str2, map.get(str2));
            }
        }
        if (i == 1) {
            zVarZ.z(pf.z(JSON, String.valueOf(jSONObject)));
        }
        g gVarZ = mClient.z(zVarZ.g());
        this.mCall = gVarZ;
        gVarZ.z(new dl() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.g.z.dl
            public void onFailure(g gVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.g.z.dl
            public void onResponse(g gVar, ls lsVar) throws Throwable {
                p pVarM;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    pVarM = lsVar.m();
                } catch (Throwable th2) {
                    pVarM = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject2 = new JSONObject(pVarM.g());
                        string = null;
                    } catch (Exception e) {
                        string = e.toString();
                        com.bytedance.sdk.component.utils.wp.z(e);
                        jSONObject2 = null;
                    }
                    if (!lsVar.a()) {
                        string = lsVar.gc();
                        lsVar.dl();
                    }
                    if (pVarM != null) {
                        try {
                            pVarM.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string.toString()));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (pVarM != null) {
                        try {
                            pVarM.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        g gVar = this.mCall;
        if (gVar == null || gVar.a()) {
            return;
        }
        this.mCall.dl();
    }
}
