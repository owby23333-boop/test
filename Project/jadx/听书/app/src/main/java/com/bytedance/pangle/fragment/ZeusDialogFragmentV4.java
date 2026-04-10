package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public class ZeusDialogFragmentV4 extends DialogFragment {
    Application.ActivityLifecycleCallbacks callbacks = new g(this);

    public ZeusDialogFragmentV4() {
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

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        try {
            return new Dialog(ZeusTransformUtils.wrapperContext(getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0])), getTheme());
        } catch (IllegalAccessException e) {
            m.z(e);
            return null;
        } catch (NoSuchMethodException e2) {
            m.z(e2);
            return null;
        } catch (InvocationTargetException e3) {
            m.z(e3);
            return null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
