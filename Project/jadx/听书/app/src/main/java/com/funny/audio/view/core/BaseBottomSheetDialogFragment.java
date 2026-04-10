package com.funny.audio.view.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.umeng.analytics.pro.ar;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBottomSheetDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000b\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\u0007R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/funny/audio/view/core/BaseBottomSheetDialogFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", ar.g, "get_bd", "()Landroidx/viewbinding/ViewBinding;", "set_bd", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "bd", "getBd", "bd$delegate", "Lkotlin/Lazy;", "initDataFlag", "", "initViewFlag", "initData", "", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "releaseView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseBottomSheetDialogFragment<T extends ViewBinding> extends BottomSheetDialogFragment {
    private T _bd;

    /* JADX INFO: renamed from: bd$delegate, reason: from kotlin metadata */
    private final Lazy bd = LazyKt.lazy(new Function0<T>(this) { // from class: com.funny.audio.view.core.BaseBottomSheetDialogFragment$bd$2
        final /* synthetic */ BaseBottomSheetDialogFragment<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.jvm.functions.Function0
        public final ViewBinding invoke() {
            ViewBinding viewBinding = this.this$0.get_bd();
            Intrinsics.checkNotNull(viewBinding);
            return viewBinding;
        }
    });
    private boolean initDataFlag;
    private boolean initViewFlag;

    public void initData() {
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void releaseView() {
    }

    protected final T get_bd() {
        return this._bd;
    }

    protected final void set_bd(T t) {
        this._bd = t;
    }

    protected final T getBd() {
        return (T) this.bd.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
        try {
            this._bd = (T) ((Class) type).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, inflater, container, false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        T t = this._bd;
        if (t != null) {
            return t.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._bd = null;
        releaseView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.initViewFlag) {
            return;
        }
        initView(view);
        initData();
        this.initViewFlag = true;
    }
}
