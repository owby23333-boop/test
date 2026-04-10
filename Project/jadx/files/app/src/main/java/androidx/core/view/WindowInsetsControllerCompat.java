package androidx.core.view;

import android.R;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void controlWindowInsetsAnimation(int i2, long j2, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int i2) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean z2) {
        }

        public void setAppearanceLightStatusBars(boolean z2) {
        }

        void setSystemBarsBehavior(int i2) {
        }

        void show(int i2) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        @Nullable
        private final View mView;

        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window window, @Nullable View view) {
            this.mWindow = window;
            this.mView = view;
        }

        private void hideForType(int i2) {
            if (i2 == 1) {
                setSystemUiFlag(4);
            } else if (i2 == 2) {
                setSystemUiFlag(2);
            } else {
                if (i2 != 8) {
                    return;
                }
                ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            }
        }

        private void showForType(int i2) {
            if (i2 == 1) {
                unsetSystemUiFlag(4);
                unsetWindowFlag(1024);
                return;
            }
            if (i2 == 2) {
                unsetSystemUiFlag(2);
                return;
            }
            if (i2 != 8) {
                return;
            }
            final View currentFocus = this.mView;
            if (currentFocus == null || !(currentFocus.isInEditMode() || currentFocus.onCheckIsTextEditor())) {
                currentFocus = this.mWindow.getCurrentFocus();
            } else {
                currentFocus.requestFocus();
            }
            if (currentFocus == null) {
                currentFocus = this.mWindow.findViewById(R.id.content);
            }
            if (currentFocus == null || !currentFocus.hasWindowFocus()) {
                return;
            }
            currentFocus.post(new Runnable() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl20.1
                @Override // java.lang.Runnable
                public void run() {
                    ((InputMethodManager) currentFocus.getContext().getSystemService("input_method")).showSoftInput(currentFocus, 0);
                }
            });
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i2, long j2, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    hideForType(i3);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i2) {
            if (i2 == 0) {
                unsetSystemUiFlag(6144);
                return;
            }
            if (i2 == 1) {
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
            } else {
                if (i2 != 2) {
                    return;
                }
                unsetSystemUiFlag(2048);
                setSystemUiFlag(4096);
            }
        }

        protected void setSystemUiFlag(int i2) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        protected void setWindowFlag(int i2) {
            this.mWindow.addFlags(i2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    showForType(i3);
                }
            }
        }

        protected void unsetSystemUiFlag(int i2) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((i2 ^ (-1)) & decorView.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int i2) {
            this.mWindow.clearFlags(i2);
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z2) {
            if (!z2) {
                unsetSystemUiFlag(8192);
                return;
            }
            unsetWindowFlag(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z2) {
            if (!z2) {
                unsetSystemUiFlag(16);
                return;
            }
            unsetWindowFlag(DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;

        Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.2
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public void onControllableInsetsChanged(@NonNull WindowInsetsController windowInsetsController, int i2) {
                    Impl30 impl30 = Impl30.this;
                    if (impl30.mInsetsController == windowInsetsController) {
                        onControllableInsetsChangedListener.onControllableInsetsChanged(impl30.mCompatController, i2);
                    }
                }
            };
            this.mListeners.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.mInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i2, long j2, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i2, j2, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.1
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationController == null ? null : this.mCompatAnimController);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i3) {
                    this.mCompatAnimController = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    windowInsetsAnimationControlListenerCompat.onReady(this.mCompatAnimController, i3);
                }
            });
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i2) {
            this.mInsetsController.hide(i2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListenerRemove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (onControllableInsetsChangedListenerRemove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListenerRemove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z2) {
            if (z2) {
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z2) {
            if (z2) {
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i2) {
            this.mInsetsController.setSystemBarsBehavior(i2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i2) {
            this.mInsetsController.show(i2);
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i2);
    }

    @RequiresApi(30)
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsController, this);
        } else {
            this.mImpl = new Impl();
        }
    }

    @NonNull
    @RequiresApi(30)
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i2, long j2, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i2, j2, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int i2) {
        this.mImpl.hide(i2);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z2) {
        this.mImpl.setAppearanceLightNavigationBars(z2);
    }

    public void setAppearanceLightStatusBars(boolean z2) {
        this.mImpl.setAppearanceLightStatusBars(z2);
    }

    public void setSystemBarsBehavior(int i2) {
        this.mImpl.setSystemBarsBehavior(i2);
    }

    public void show(int i2) {
        this.mImpl.show(i2);
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.mImpl = new Impl30(window, this);
            return;
        }
        if (i2 >= 26) {
            this.mImpl = new Impl26(window, view);
            return;
        }
        if (i2 >= 23) {
            this.mImpl = new Impl23(window, view);
        } else if (i2 >= 20) {
            this.mImpl = new Impl20(window, view);
        } else {
            this.mImpl = new Impl();
        }
    }
}
