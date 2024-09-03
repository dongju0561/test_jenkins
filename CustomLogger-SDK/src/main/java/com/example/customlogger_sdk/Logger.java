package com.example.customlogger_sdk;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static String TAG = "CustomLogger";
    private static boolean isDebug = true;
    private static Context appContext;

    public static void saveLogsToFile(String fileName) {
        if (appContext == null) {
            throw new IllegalStateException("Logger is not initialized. Call Logger.init() first.");
        }

        File logFile = new File(appContext.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName);

        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.append("Saved logs at: ").append(String.valueOf(System.currentTimeMillis())).append("\n");
            writer.append("---- LOG BEGIN ----\n");
            writer.append("Your log message here\n"); // 실제 로그를 추가하는 로직 필요
            writer.append("---- LOG END ----\n\n");
            Log.d(TAG, "Logs saved to: " + logFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 초기화 메서드
    public static void init(Context context, boolean debugMode) {
        appContext = context.getApplicationContext();
        isDebug = debugMode;
    }

    // 디버그 로그 출력
    public static void d(String message) {
        if (isDebug) {
            Log.d(TAG, message);
        }
    }

    // 에러 로그 출력
    public static void e(String message) {
        Log.e(TAG, message);
    }

    // 로그 태그를 사용자 정의
    public static void setCustomTag(String customTag) {
        TAG = customTag;
    }

    public static void log(int logLevel, String message) {
        switch (logLevel) {
            case Log.VERBOSE:
                Log.v(TAG, message);
                break;
            case Log.DEBUG:
                Log.d(TAG, message);
                break;
            case Log.INFO:
                Log.i(TAG, message);
                break;
            case Log.WARN:
                Log.w(TAG, message);
                break;
            case Log.ERROR:
                Log.e(TAG, message);
                break;
            default:
                Log.d(TAG, message);
        }
    }
}
