package com.example.customlog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.customlogger_sdk.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Logger 초기화
        Logger.init(this, true);

        // 로그 출력
        Logger.d("Debug log");
        Logger.e("Error log");

        // 로그 파일에 저장
        Logger.saveLogsToFile("app_log.txt");
    }
}
