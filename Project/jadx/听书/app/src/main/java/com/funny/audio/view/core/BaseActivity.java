package com.funny.audio.view.core;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.d;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/funny/audio/view/core/BaseActivity;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "Tag", "", "getTag", "()Ljava/lang/String;", ar.g, "get_bd", "()Landroidx/viewbinding/ViewBinding;", "set_bd", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "bd", "getBd", "bd$delegate", "Lkotlin/Lazy;", d.R, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getResources", "Landroid/content/res/Resources;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "releaseData", "releaseView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseActivity<T extends ViewBinding> extends AppCompatActivity {
    private final String Tag;
    private T _bd;

    /* JADX INFO: renamed from: bd$delegate, reason: from kotlin metadata */
    private final Lazy bd;
    private Context context;

    public void initData() {
    }

    public void initView() {
    }

    public void releaseData() {
    }

    public void releaseView() {
    }

    public BaseActivity() {
        String simpleName = Reflection.getOrCreateKotlinClass(BaseActivity.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        this.Tag = simpleName;
        this.context = this;
        this.bd = LazyKt.lazy(new Function0<T>(this) { // from class: com.funny.audio.view.core.BaseActivity$bd$2
            final /* synthetic */ BaseActivity<T> this$0;

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
    }

    public String getTag() {
        return this.Tag;
    }

    protected final Context getContext() {
        return this.context;
    }

    protected final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
        try {
            T t = (T) ((Class) type).getDeclaredMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
            this._bd = t;
            Intrinsics.checkNotNull(t);
            setContentView(t.getRoot());
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this._bd = null;
        releaseView();
        releaseData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources;
    }
}
