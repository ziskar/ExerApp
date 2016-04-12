package studio365.exerapp2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by 성훈 on 2016-04-04.
 */
public class WriteActivity extends AppCompatActivity {

    private DatePickerDialog dialog;
    private EditText dateText;
    private Calendar cal = Calendar.getInstance();
    private android.app.DatePickerDialog.OnDateSetListener listener = new android.app.DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateText.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            Toast.makeText(getApplicationContext(), year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        //actionBar back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateText = (EditText) findViewById(R.id.dateText);
        dialog = new DatePickerDialog(this, listener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));


    }

    public void dateDialog(View v) {
        //dialog를 보여주는 메소드
        dialog.show();
    }

    //actionBar back button method
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
