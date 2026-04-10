package kotlin.jvm;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.taobao.aranger.constant.Constants;
import kotlin.reflect.c;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmClassMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "JvmClassMappingKt")
public final class a {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public static final <T> Class<T> a(@NotNull c<T> cVar) {
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.c) cVar).a();
        if (!cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        cls = (Class<T>) Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        cls = (Class<T>) Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        cls = (Class<T>) Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        cls = (Class<T>) Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        cls = (Class<T>) Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals(Constants.VOID)) {
                        cls = (Class<T>) Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        cls = (Class<T>) Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        cls = (Class<T>) Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        cls = (Class<T>) Short.class;
                    }
                    break;
            }
        }
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    }
}
