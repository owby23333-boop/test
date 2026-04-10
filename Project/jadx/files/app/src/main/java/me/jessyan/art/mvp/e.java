package me.jessyan.art.mvp;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: IView.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    void addBookToShelfV6(Message message);

    void finishReadActivity();

    Context getHostContext();

    void handleMessage(@NonNull Message message);

    void hideLoading();

    void showEmpty();

    void showLoadSuccess();

    void showLoading(String str);

    void showLoginDialog(@NonNull String str);

    void showMessage(@NonNull String str);

    void showToasyErrorMessage(@NonNull String str);
}
