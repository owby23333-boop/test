package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class bn {
    public static int a(Context context) {
        SensorManager sensorManager;
        try {
            if (Build.VERSION.SDK_INT < 23 || (sensorManager = (SensorManager) context.getSystemService(com.umeng.analytics.pro.am.ac)) == null) {
                return 0;
            }
            List<Sensor> sensorList = sensorManager.getSensorList(-1);
            if (sensorList.size() <= 0) {
                return 0;
            }
            ListIterator<Sensor> listIterator = sensorList.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().getType() == 9) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long a() {
        DataInputStream dataInputStream;
        BufferedReader bufferedReader = null;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(dataInputStream));
                double dDoubleValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] strArrSplit = a(line).split(";");
                        if (strArrSplit != null && strArrSplit.length != 0) {
                            dDoubleValue = Double.valueOf(strArrSplit[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (dDoubleValue * 1000.0d));
                try {
                    dataInputStream.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader2.close();
                    return jCurrentTimeMillis;
                } catch (IOException unused5) {
                    return jCurrentTimeMillis;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            dataInputStream = null;
        }
    }

    public static String a(String str) {
        try {
            return str.replace("      ", ";").replace("     ", ";").replace("    ", ";").replace("   ", ";").replace("  ", ";").replace(" ", ";");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long b() {
        DataInputStream dataInputStream;
        BufferedReader bufferedReader = null;
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(dataInputStream));
                double dDoubleValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] strArrSplit = a(line).split(";");
                        if (strArrSplit != null && strArrSplit.length != 0) {
                            dDoubleValue = Double.valueOf(strArrSplit[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                System.currentTimeMillis();
                long j2 = (long) (dDoubleValue * 1000.0d);
                try {
                    dataInputStream.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader2.close();
                    return j2;
                } catch (IOException unused5) {
                    return j2;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            dataInputStream = null;
        }
    }
}
