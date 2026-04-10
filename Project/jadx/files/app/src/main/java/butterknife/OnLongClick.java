package butterknife;

import androidx.annotation.IdRes;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import com.umeng.message.common.inter.ITagManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = ITagManager.STATUS_TRUE, name = "onLongClick", parameters = {"android.view.View"}, returnType = "boolean")}, setter = "setOnLongClickListener", targetType = "android.view.View", type = "android.view.View.OnLongClickListener")
public @interface OnLongClick {
    @IdRes
    int[] value() default {-1};
}
