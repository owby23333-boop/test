package com.duokan.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.AnyThread;
import com.duokan.core.sys.BasicInflater;
import com.yuewen.dr1;
import com.yuewen.w01;
import com.yuewen.x01;
import com.yuewen.xv1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class ManagedContext extends MutableContextWrapper implements xv1 {
    public static xv1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x01 f2772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Configuration f2773b;
    public Resources c;
    public dr1 d;
    public Map<String, Object> e;

    public ManagedContext(Context context) {
        super(context);
        this.f2772a = new x01();
        this.d = new dr1();
        this.e = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.app.Activity] */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.app.Application] */
    public static xv1 h(Context context) {
        while (context != 0 && !(context instanceof xv1)) {
            if (context instanceof Application) {
                xv1 xv1Var = f;
                if (xv1Var != null) {
                    return xv1Var;
                }
                synchronized (ManagedContext.class) {
                    xv1 xv1Var2 = f;
                    if (xv1Var2 != null) {
                        return xv1Var2;
                    }
                    if (AppWrapper.v() == null) {
                        f = new AppWrapper((Application) context);
                    } else {
                        f = AppWrapper.v();
                    }
                    return f;
                }
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                context = activity.getParent() != null ? activity.getParent() : activity.getApplication();
            } else {
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : 0;
            }
        }
        return (xv1) context;
    }

    @Override // com.yuewen.xv1
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.c != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f2773b != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f2773b = new Configuration(configuration);
    }

    public final xv1 g() {
        return h(getApplicationContext());
    }

    @Override // com.yuewen.xv1
    @AnyThread
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater;
        dr1 dr1Var = this.d;
        LayoutInflater layoutInflater2 = dr1Var.f10324a;
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        LayoutInflater layoutInflater3 = (LayoutInflater) super.getSystemService("layout_inflater");
        if (dr1Var.f10325b == layoutInflater3 && (layoutInflater = dr1Var.c) != null) {
            return layoutInflater;
        }
        dr1 dr1Var2 = new dr1();
        dr1Var2.f10325b = layoutInflater3;
        if (layoutInflater3 != null) {
            dr1Var2.c = layoutInflater3.cloneInContext(this);
        } else {
            dr1Var2.c = new BasicInflater(this);
        }
        this.d = dr1Var2;
        return dr1Var2.c;
    }

    @Override // com.yuewen.xv1
    public Configuration getOverrideConfiguration() {
        return this.f2773b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.c == null) {
            Configuration configuration = this.f2773b;
            if (configuration == null) {
                this.c = super.getResources();
            } else {
                this.c = createConfigurationContext(configuration).getResources();
            }
        }
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        Object layoutInflater = this.e.get(str);
        if (layoutInflater == null) {
            layoutInflater = "layout_inflater".equals(str) ? getLayoutInflater() : super.getSystemService(str);
            this.e.put(str, layoutInflater);
        }
        return layoutInflater;
    }

    public final void i(Context context) {
        super.setBaseContext(context);
    }

    @Override // com.yuewen.xv1
    public <T extends w01> T queryFeature(Class<T> cls) {
        xv1 xv1VarH;
        T t = (T) queryLocalFeature(cls);
        return (t != null || (xv1VarH = h(getBaseContext())) == null || xv1VarH == this) ? t : (T) xv1VarH.queryFeature(cls);
    }

    @Override // com.yuewen.xv1
    public <T extends w01> T queryLocalFeature(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return (T) this.f2772a.b(cls);
    }

    @Override // com.yuewen.xv1
    public boolean registerGlobalFeature(w01 w01Var) {
        if (w01Var == null) {
            return false;
        }
        return g() == this ? registerLocalFeature(w01Var) : g().registerGlobalFeature(w01Var);
    }

    @Override // com.yuewen.xv1
    public boolean registerLocalFeature(w01 w01Var) {
        return this.f2772a.c(w01Var);
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
    }

    @Override // com.yuewen.xv1
    @AnyThread
    public void setLayoutInflater(LayoutInflater layoutInflater) {
        dr1 dr1Var = new dr1();
        dr1Var.f10324a = layoutInflater;
        this.d = dr1Var;
    }

    @Override // com.yuewen.xv1
    public boolean unregisterGlobalFeature(w01 w01Var) {
        return g() == this ? unregisterLocalFeature(w01Var) : g().unregisterGlobalFeature(w01Var);
    }

    @Override // com.yuewen.xv1
    public boolean unregisterLocalFeature(w01 w01Var) {
        return this.f2772a.d(w01Var);
    }
}
