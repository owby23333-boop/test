package butterknife;

import androidx.annotation.IdRes;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.message.common.inter.ITagManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = ITagManager.STATUS_TRUE, name = "onEditorAction", parameters = {"android.widget.TextView", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "android.view.KeyEvent"}, returnType = "boolean")}, setter = "setOnEditorActionListener", targetType = "android.widget.TextView", type = "android.widget.TextView.OnEditorActionListener")
public @interface OnEditorAction {
    @IdRes
    int[] value() default {-1};
}
