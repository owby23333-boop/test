package me.drakeet.multitype;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
class BinderNotFoundException extends RuntimeException {
    BinderNotFoundException(@NonNull Class<?> cls) {
        super("Do you have registered {className}.class to the binder in the adapter/pool?".replace("{className}", cls.getSimpleName()));
    }
}
