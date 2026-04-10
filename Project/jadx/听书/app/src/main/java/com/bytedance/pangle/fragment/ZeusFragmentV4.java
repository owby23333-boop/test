package com.bytedance.pangle.fragment;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class ZeusFragmentV4 extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new g(this);

    public ZeusFragmentV4() {
        z.z(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e) {
            m.z(e);
            return super.getContext();
        } catch (NoSuchMethodException e2) {
            m.z(e2);
            return super.getContext();
        } catch (InvocationTargetException e3) {
            m.z(e3);
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
