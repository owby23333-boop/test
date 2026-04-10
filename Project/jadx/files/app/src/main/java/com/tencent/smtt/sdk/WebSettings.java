package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private IX5WebSettings a;
    private android.webkit.WebSettings b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18959c;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);

        int value;

        TextSize(int i2) {
            this.value = i2;
        }
    }

    public enum ZoomDensity {
        FAR(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i2) {
            this.value = i2;
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.a = null;
        this.b = null;
        this.f18959c = false;
        this.a = null;
        this.b = webSettings;
        this.f18959c = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.a = null;
        this.b = null;
        this.f18959c = false;
        this.a = iX5WebSettings;
        this.b = null;
        this.f18959c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        Object objA;
        if (w.a().b()) {
            return w.a().c().i(context);
        }
        if (Build.VERSION.SDK_INT >= 17 && (objA = com.tencent.smtt.utils.j.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context)) != null) {
            return (String) objA;
        }
        return null;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(webSettings, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(webSettings, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        if (this.f18959c && this.a != null) {
            return this.a.getBlockNetworkImage();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getBlockNetworkImage();
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        if (this.f18959c && this.a != null) {
            return this.a.getBlockNetworkLoads();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return false;
        }
        return this.b.getBlockNetworkLoads();
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getCursiveFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getCursiveFontFamily();
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        if (this.f18959c && this.a != null) {
            return this.a.getDatabaseEnabled();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getDatabaseEnabled();
    }

    @TargetApi(5)
    @Deprecated
    public synchronized String getDatabasePath() {
        if (this.f18959c && this.a != null) {
            return this.a.getDatabasePath();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getDatabasePath();
    }

    public synchronized int getDefaultFixedFontSize() {
        if (this.f18959c && this.a != null) {
            return this.a.getDefaultFixedFontSize();
        }
        if (this.f18959c || this.b == null) {
            return 0;
        }
        return this.b.getDefaultFixedFontSize();
    }

    public synchronized int getDefaultFontSize() {
        if (this.f18959c && this.a != null) {
            return this.a.getDefaultFontSize();
        }
        if (this.f18959c || this.b == null) {
            return 0;
        }
        return this.b.getDefaultFontSize();
    }

    public synchronized String getDefaultTextEncodingName() {
        if (this.f18959c && this.a != null) {
            return this.a.getDefaultTextEncodingName();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getDefaultTextEncodingName();
    }

    @TargetApi(7)
    @Deprecated
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        String strName;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            strName = iX5WebSettings.getDefaultZoom().name();
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return null;
            }
            strName = webSettings.getDefaultZoom().name();
        }
        return ZoomDensity.valueOf(strName);
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (objA = com.tencent.smtt.utils.j.a(webSettings, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        if (this.f18959c && this.a != null) {
            return this.a.getDomStorageEnabled();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getDomStorageEnabled();
    }

    public synchronized String getFantasyFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getFantasyFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getFantasyFontFamily();
    }

    public synchronized String getFixedFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getFixedFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getFixedFontFamily();
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        if (this.f18959c && this.a != null) {
            return this.a.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized boolean getJavaScriptEnabled() {
        if (this.f18959c && this.a != null) {
            return this.a.getJavaScriptEnabled();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getJavaScriptEnabled();
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        if (this.f18959c && this.a != null) {
            return LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
        }
        if (this.f18959c || this.b == null) {
            return null;
        }
        return LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
    }

    @Deprecated
    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        if (this.f18959c && this.a != null) {
            return this.a.getLoadsImagesAutomatically();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getLoadsImagesAutomatically();
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 17 || (objA = com.tencent.smtt.utils.j.a(webSettings, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        if (this.f18959c && this.a != null) {
            return this.a.getMinimumFontSize();
        }
        if (this.f18959c || this.b == null) {
            return 0;
        }
        return this.b.getMinimumFontSize();
    }

    public synchronized int getMinimumLogicalFontSize() {
        if (this.f18959c && this.a != null) {
            return this.a.getMinimumLogicalFontSize();
        }
        if (this.f18959c || this.b == null) {
            return 0;
        }
        return this.b.getMinimumLogicalFontSize();
    }

    public synchronized int getMixedContentMode() {
        int iIntValue = -1;
        if (this.f18959c && this.a != null) {
            try {
                return this.a.getMixedContentMode();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        Object objA = com.tencent.smtt.utils.j.a(this.b, "getMixedContentMode", (Class<?>[]) new Class[0], new Object[0]);
        if (objA != null) {
            iIntValue = ((Integer) objA).intValue();
        }
        return iIntValue;
    }

    @Deprecated
    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (this.f18959c || (webSettings = this.b) == null || (objA = com.tencent.smtt.utils.j.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        if (this.f18959c && this.a != null) {
            return PluginState.valueOf(this.a.getPluginState().name());
        }
        if (this.f18959c || this.b == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        Object objA = com.tencent.smtt.utils.j.a(this.b, "getPluginState");
        if (objA == null) {
            return null;
        }
        return PluginState.valueOf(((WebSettings.PluginState) objA).name());
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        if (this.f18959c && this.a != null) {
            return this.a.getPluginsEnabled();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 17) {
            if (Build.VERSION.SDK_INT == 18) {
                return WebSettings.PluginState.ON == this.b.getPluginState();
            }
            return false;
        }
        Object objA = com.tencent.smtt.utils.j.a(this.b, "getPluginsEnabled");
        if (objA != null) {
            zBooleanValue = ((Boolean) objA).booleanValue();
        }
        return zBooleanValue;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        if (this.f18959c && this.a != null) {
            return this.a.getPluginsPath();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT > 17) {
            return "";
        }
        Object objA = com.tencent.smtt.utils.j.a(this.b, "getPluginsPath");
        return objA == null ? null : (String) objA;
    }

    public boolean getSafeBrowsingEnabled() {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        if (!this.f18959c && (webSettings = this.b) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return webSettings.getSafeBrowsingEnabled();
            }
            return false;
        }
        if (!this.f18959c || (iX5WebSettings = this.a) == null) {
            return false;
        }
        try {
            return iX5WebSettings.getSafeBrowsingEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public synchronized String getSansSerifFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getSansSerifFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getSansSerifFontFamily();
    }

    @Deprecated
    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSaveFormData();
    }

    @Deprecated
    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getSerifFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getSerifFontFamily();
    }

    public synchronized String getStandardFontFamily() {
        if (this.f18959c && this.a != null) {
            return this.a.getStandardFontFamily();
        }
        if (this.f18959c || this.b == null) {
            return "";
        }
        return this.b.getStandardFontFamily();
    }

    @Deprecated
    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        String strName;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            strName = iX5WebSettings.getTextSize().name();
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return null;
            }
            strName = webSettings.getTextSize().name();
        }
        return TextSize.valueOf(strName);
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        if (this.f18959c && this.a != null) {
            return this.a.getTextZoom();
        }
        if (this.f18959c || this.b == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            return this.b.getTextZoom();
        } catch (Exception unused) {
            Object objA = com.tencent.smtt.utils.j.a(this.b, "getTextZoom");
            if (objA == null) {
                return 0;
            }
            return ((Integer) objA).intValue();
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object objA;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.f18959c || (webSettings = this.b) == null || (objA = com.tencent.smtt.utils.j.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        if (this.f18959c && this.a != null) {
            return this.a.getUseWideViewPort();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.getUseWideViewPort();
    }

    @TargetApi(3)
    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        return (!this.f18959c || (iX5WebSettings = this.a) == null) ? (this.f18959c || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString() : iX5WebSettings.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowContentAccess(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setAllowContentAccess", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccess(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAllowFileAccess(z2);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setAllowFileAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheEnabled(z2);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setAppCacheMaxSize(long j2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheMaxSize(j2);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBlockNetworkImage(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBlockNetworkImage(z2);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z2) {
        if (this.f18959c && this.a != null) {
            this.a.setBlockNetworkLoads(z2);
        } else {
            if (this.f18959c || this.b == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                this.b.setBlockNetworkLoads(z2);
            }
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBuiltInZoomControls(z2);
        }
    }

    public void setCacheMode(int i2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setCacheMode(i2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setCacheMode(i2);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setCursiveFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabaseEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDatabaseEnabled(z2);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setDatabasePath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i2) {
        if (this.f18959c && this.a != null) {
            this.a.setDefaultFixedFontSize(i2);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setDefaultFixedFontSize(i2);
        }
    }

    public synchronized void setDefaultFontSize(int i2) {
        if (this.f18959c && this.a != null) {
            this.a.setDefaultFontSize(i2);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setDefaultFontSize(i2);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setDefaultTextEncodingName(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDisplayZoomControls(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setDisplayZoomControls", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDomStorageEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDomStorageEnabled(z2);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setEnableSmoothTransition", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setFantasyFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setFixedFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setFixedFontFamily(str);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationEnabled(z2);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z2) {
        if (this.f18959c && this.a != null) {
            this.a.setJavaScriptCanOpenWindowsAutomatically(z2);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setJavaScriptCanOpenWindowsAutomatically(z2);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z2) {
        try {
            if (this.f18959c && this.a != null) {
                this.a.setJavaScriptEnabled(z2);
            } else if (this.f18959c || this.b == null) {
            } else {
                this.b.setJavaScriptEnabled(z2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    @Deprecated
    public void setLightTouchEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLightTouchEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLightTouchEnabled(z2);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadWithOverviewMode(z2);
        }
    }

    public void setLoadsImagesAutomatically(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadsImagesAutomatically(z2);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 17) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public synchronized void setMinimumFontSize(int i2) {
        if (this.f18959c && this.a != null) {
            this.a.setMinimumFontSize(i2);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setMinimumFontSize(i2);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i2) {
        if (this.f18959c && this.a != null) {
            this.a.setMinimumLogicalFontSize(i2);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setMinimumLogicalFontSize(i2);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i2) {
        android.webkit.WebSettings webSettings;
        if ((!this.f18959c || this.a == null) && !this.f18959c && (webSettings = this.b) != null && Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.utils.j.a(webSettings, "setMixedContentMode", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    @Deprecated
    public void setNavDump(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNavDump(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setNavDump", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setNeedInitialFocus(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNeedInitialFocus(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setNeedInitialFocus(z2);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        if (this.f18959c && this.a != null) {
            this.a.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else {
            if (this.f18959c || this.b == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                com.tencent.smtt.utils.j.a(this.b, "setPluginState", (Class<?>[]) new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
            }
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginsEnabled(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setPluginsEnabled", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setPluginsPath(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            com.tencent.smtt.utils.j.a(this.b, "setPluginsPath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @Deprecated
    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setSafeBrowsingEnabled(boolean z2) {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        if (!this.f18959c && (webSettings = this.b) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                webSettings.setSafeBrowsingEnabled(z2);
            }
        } else {
            if (!this.f18959c || (iX5WebSettings = this.a) == null) {
                return;
            }
            try {
                iX5WebSettings.setSafeBrowsingEnabled(z2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setSansSerifFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setSansSerifFontFamily(str);
        }
    }

    @Deprecated
    public void setSaveFormData(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSaveFormData(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSaveFormData(z2);
        }
    }

    @Deprecated
    public void setSavePassword(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSavePassword(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSavePassword(z2);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setSerifFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.f18959c && this.a != null) {
            this.a.setStandardFontFamily(str);
        } else if (this.f18959c || this.b == null) {
        } else {
            this.b.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportMultipleWindows(z2);
        }
    }

    public void setSupportZoom(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportZoom(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportZoom(z2);
        }
    }

    @Deprecated
    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i2) {
        if (this.f18959c && this.a != null) {
            this.a.setTextZoom(i2);
        } else if (!this.f18959c && this.b != null) {
            if (Build.VERSION.SDK_INT < 14) {
                return;
            }
            try {
                this.b.setTextZoom(i2);
            } catch (Exception unused) {
                com.tencent.smtt.utils.j.a(this.b, "setTextZoom", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i2));
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.j.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setUseWideViewPort(boolean z2) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWideViewPort(z2);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUseWideViewPort(z2);
        }
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else {
            if (this.f18959c || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        if (this.f18959c && this.a != null) {
            return this.a.supportMultipleWindows();
        }
        if (this.f18959c || this.b == null) {
            return false;
        }
        return this.b.supportMultipleWindows();
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        if (this.f18959c && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (this.f18959c || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportZoom();
    }
}
