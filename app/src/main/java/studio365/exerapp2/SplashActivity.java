package studio365.exerapp2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 성훈 on 2016-03-26.
 */
public class SplashActivity extends AppCompatActivity {
    static int endTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //새로운 핸들러 생성 후 일정 딜레이 시간 이후 메시지를 보내 액티비티를 종료시킨다.
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0, endTime);
    }


}
