package studio365.exerapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, SplashActivity.class));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.menu_main, menu);아랫줄의 원래 형태
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.write_actionBar:
                startActivity(new Intent(this, WriteActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
