package com.bytedance.adsdk.ugeno.gc;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.gc.dl.g;
import com.bytedance.adsdk.ugeno.gc.g.z;
import com.bytedance.adsdk.ugeno.gc.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.dl.m f242a;
    private com.bytedance.adsdk.ugeno.g.dl dl;
    private boolean e;
    private Map<String, List<com.bytedance.adsdk.ugeno.gc.dl.g>> g;
    private com.bytedance.adsdk.ugeno.dl.g.z gc;
    private boolean gz;
    private boolean m;
    private z z;

    public fo(com.bytedance.adsdk.ugeno.g.dl dlVar, z zVar) {
        this.dl = dlVar;
        this.z = zVar;
        if (zVar != null) {
            this.g = zVar.z;
        }
        com.bytedance.adsdk.ugeno.g.dl dlVar2 = this.dl;
        if (dlVar2 != null && dlVar2.gb() && this.gc == null) {
            this.gc = new com.bytedance.adsdk.ugeno.dl.g.z();
        }
    }

    public void z(com.bytedance.adsdk.ugeno.dl.m mVar) {
        this.f242a = mVar;
    }

    public void z() {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ = z("shake");
        if (listZ == null || listZ.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listZ) {
            if (gVar != null) {
                gVar.z(this);
                gVar.z(new Object[0]);
            }
        }
    }

    public void g() {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ = z("twist");
        if (listZ == null || listZ.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listZ) {
            if (gVar != null) {
                gVar.z(this);
                gVar.z(new Object[0]);
            }
        }
    }

    public void dl() {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> value;
        z zVar = this.z;
        if (zVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.gc.dl.g>> entry : zVar.z.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : value) {
                    if (gVar instanceof com.bytedance.adsdk.ugeno.gc.dl.dl) {
                        gVar.z(this);
                        gVar.z(new Object[0]);
                    }
                }
            }
        }
    }

    public void a() {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ = z("animateState");
        if (listZ == null || listZ.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listZ) {
            if (gVar != null) {
                gVar.z(this);
                gVar.z(new Object[0]);
            }
        }
    }

    public void gc() {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ = z("timer");
        if (listZ == null || listZ.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listZ) {
            if (gVar != null) {
                gVar.z(this);
                gVar.z(new Object[0]);
            }
        }
    }

    public boolean z(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.dl.g.z zVar;
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ = z("touchStart");
        if (listZ != null && !listZ.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listZ) {
                if (gVar instanceof com.bytedance.adsdk.ugeno.gc.dl.gz) {
                    gVar.z(this);
                    gVar.z(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ2 = z("touchEnd");
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ3 = z("tap");
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listZ4 = z("slide");
        if (listZ != null && !listZ.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.gc.dl.g gVar2 : listZ2) {
                if (gVar2 instanceof com.bytedance.adsdk.ugeno.gc.dl.e) {
                    gVar2.z(this);
                    this.gz = gVar2.z(motionEvent);
                }
            }
        }
        if ((listZ3 == null || listZ3.isEmpty()) && (listZ4 == null || listZ4.isEmpty())) {
            return this.gz;
        }
        if (this.gz && motionEvent.getAction() == 1) {
            return true;
        }
        com.bytedance.adsdk.ugeno.dl.g.z zVar2 = this.gc;
        if (zVar2 != null) {
            if (zVar2.z(motionEvent)) {
                return false;
            }
            this.gc.z(this.dl, motionEvent);
        }
        if (listZ3 != null && !listZ3.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.gc.dl.g gVar3 : listZ3) {
                if (gVar3 instanceof com.bytedance.adsdk.ugeno.gc.dl.gc) {
                    gVar3.z(this);
                    this.m = gVar3.z(motionEvent);
                }
            }
        }
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && this.m) {
            return true;
        }
        if (listZ4 != null && !listZ4.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.gc.dl.g gVar4 : listZ4) {
                if (gVar4 instanceof com.bytedance.adsdk.ugeno.gc.dl.a) {
                    gVar4.z(this);
                    this.e = gVar4.z(motionEvent);
                }
            }
        }
        if ((action == 1 || action == 3) && !this.m && !this.e && (zVar = this.gc) != null) {
            zVar.z(this.dl);
        }
        return this.m || this.e;
    }

    private void z(String str, List<m.z> list) {
        com.bytedance.adsdk.ugeno.gc.g.z zVarZ;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (m.z zVar : list) {
            if (zVar != null && (zVarZ = z.C0046z.z(this.dl, str, zVar)) != null) {
                zVarZ.z();
                zVarZ.g();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.gc.dl.g> z(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.gc.dl.g>> map = this.g;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.g.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.kb
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, List<m.z> list) {
        z(str, list);
    }

    public static fo z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str) {
        com.bytedance.adsdk.ugeno.gc.dl.g gVarZ;
        if (dlVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                z zVar = new z(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (gVarZ = g.z.z(dlVar.fo().getContext(), dlVar, jSONObjectOptJSONObject, dlVar.uy())) != null) {
                        if (zVar.z.containsKey(gVarZ.e())) {
                            List<com.bytedance.adsdk.ugeno.gc.dl.g> list = zVar.z.get(gVarZ.e());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(gVarZ);
                                zVar.z.put(gVarZ.e(), arrayList);
                            } else {
                                list.add(gVarZ);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(gVarZ);
                            zVar.z.put(gVarZ.e(), arrayList2);
                        }
                        zVar.g.put(gVarZ.gz(), gVarZ);
                    }
                }
                return new fo(dlVar, zVar);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return null;
    }

    public static class z {
        public Map<String, com.bytedance.adsdk.ugeno.gc.dl.g> g;
        public Map<String, List<com.bytedance.adsdk.ugeno.gc.dl.g>> z;

        public z(Map<String, List<com.bytedance.adsdk.ugeno.gc.dl.g>> map, Map<String, com.bytedance.adsdk.ugeno.gc.dl.g> map2) {
            this.z = map;
            this.g = map2;
        }
    }
}
