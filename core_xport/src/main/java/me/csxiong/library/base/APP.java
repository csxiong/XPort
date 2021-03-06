package me.csxiong.library.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @Desc : 全局使用的Application
 * @Author : csxiong create on 2019/7/16
 */
public class APP extends Application {

    /**
     * 单例Application
     */
    protected static APP _INSTANCE;

    /**
     * Application的代理管理器
     */
    private AppDelegateManager mAppDelegate;

    /**
     * 单例实现及获取
     *
     * @return
     */
    public static APP get() {
        synchronized (APP.class) {
            if (_INSTANCE == null) {
                _INSTANCE = new APP();
            }
        }
        return _INSTANCE;
    }

    /**
     * Application生命周期
     */
    @Override
    public void onCreate() {
        super.onCreate();
        if (!shouldInit()) {
            return;
        }
        mAppDelegate.onCreate(this);
    }

    /**
     * Application生命周期
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        _INSTANCE = this;
        if (mAppDelegate == null) {
            mAppDelegate = new AppDelegateManager(this);
        }
        mAppDelegate.attachBaseContext(base);
    }

    /**
     * Application生命周期
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        mAppDelegate.onTerminate(this);
    }

    /**
     * 通过进程Id获取进程名
     *
     * @param pid
     * @return
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 进程判断
     *
     * @return
     */
    public boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

}
