package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.utils.r;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RangerInjector {

    public interface a {
        void dq(String str);
    }

    public interface b {
        void a(String str, long j2, long j3, String str2, String str3);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String D(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long E(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long F(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(JSONObject jSONObject) {
        try {
            return jSONObject.optString(UMModuleRegister.PROCESS);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, final String str2, final b bVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                bVar.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) r.d(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    r.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String strD = RangerInjector.D(content);
                                    long jE = RangerInjector.E(content);
                                    long jF = RangerInjector.F(content);
                                    String strG = RangerInjector.G(content);
                                    String strH = RangerInjector.H(content);
                                    if (bVar != null) {
                                        bVar.a(strD, jF, jE, strG, strH);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                try {
                                    method.invoke(pluginListener, objArr);
                                } catch (Throwable th2) {
                                    com.kwad.sdk.core.d.b.e("perfMonitor.RangerInjector", Log.getStackTraceString(th2));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (Exception e2) {
                    bVar.onError(Log.getStackTraceString(e2));
                }
            }
        } catch (Exception e3) {
            bVar.onError(Log.getStackTraceString(e3));
        }
    }

    @Keep
    public static void tryProxyOtherOutput(String str, String str2, String str3, final String str4, final a aVar) {
        try {
            final Logger.ILogWritter iLogWritter = (Logger.ILogWritter) r.X(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) r.X(str, str3);
            final int iIntValue = num != null ? num.intValue() : 4;
            r.a(Class.forName(str), str2, (Object) new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                @Keep
                public final boolean isLoggable(int i2) {
                    return true;
                }

                @Keep
                public final void logD(String str5, String str6) {
                    try {
                        if (iIntValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logD(String str5, String str6, Throwable th) {
                    try {
                        if (iIntValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6) {
                    try {
                        if (iIntValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6, Throwable th) {
                    try {
                        if (TextUtils.equals(str5, str4) && aVar != null) {
                            aVar.dq(Log.getStackTraceString(th));
                        }
                        if (iIntValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6) {
                    try {
                        if (iIntValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6, Throwable th) {
                    try {
                        if (iIntValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logK(String str5, String str6) {
                    try {
                        iLogWritter.logK(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6) {
                    try {
                        if (iIntValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6, Throwable th) {
                    try {
                        if (iIntValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6) {
                    try {
                        if (iIntValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6, Throwable th) {
                    try {
                        if (iIntValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
