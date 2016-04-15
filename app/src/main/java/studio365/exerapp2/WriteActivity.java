package studio365.exerapp2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class WriteActivity extends AppCompatActivity {

    private DatePickerDialog dialog;
    private TextView dateText;
    private Calendar cal = Calendar.getInstance();

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    //datepickerdialog listener설정
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
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateText = (TextView) findViewById(R.id.dateText);
        dialog = new DatePickerDialog(this, listener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

        //나중에 클래스로 만들어서 사용(15,1,50)
        numberPicker1 = (NumberPicker)findViewById(R.id.numberPicker1);
        numberPicker1.setMaxValue(50);
        numberPicker1.setMinValue(1);
        numberPicker1.setValue(15);

        numberPicker2 = (NumberPicker)findViewById(R.id.numberPicker2);
        numberPicker2.setMaxValue(400);
        numberPicker2.setMinValue(1);
        numberPicker2.setValue(10);

        numberPicker3 = (NumberPicker)findViewById(R.id.numberPicker3);
        numberPicker3.setMaxValue(30);
        numberPicker3.setMinValue(1);
        numberPicker3.setValue(3);


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
