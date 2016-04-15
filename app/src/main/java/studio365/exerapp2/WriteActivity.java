package studio365.exerapp2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class WriteActivity extends AppCompatActivity {

    //날짜 설정
    private DatePickerDialog dialog;
    private TextView dateText;
    private Calendar cal = Calendar.getInstance();

    //횟수,중량,세트 설정
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    //운동이름 스피너 설정

    ArrayList<String> exer_name = new ArrayList<>();
    ArrayList<String> exer_default = new ArrayList<>();


    //운동이름 저장 설정
    EditText ed_id;


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

        //numberpicker 설정 나중에 클래스로 만들어서 사용(15,1,50)
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

        //운동이름 추가 스피너 초기 설정
        refresh_Exername();
    }

    //운동이름 추가 다이얼로그 설정
    public void addExer_name(View v){
        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.exername_popup, null);

        ed_id = (EditText) linear.findViewById(R.id.ed_id);

        new AlertDialog.Builder(this).setTitle("추가").setView(linear)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        exer_name.add(ed_id.getText().toString());
                        Toast.makeText(getApplicationContext(),ed_id.getText().toString(), Toast.LENGTH_SHORT).show();
                        refresh_Exername();
                    }
                }).setNegativeButton("취소", null).show();
    }

    //datepicker dialog 설정
    public void dateDialog(View v) {
        //dialog를 보여주는 메소드
        dialog.show();
    }

    //운동이름 스피너 설정
    public void refresh_Exername() {
        //exer_default 설정
        if(exer_default.size()==0){
            exer_default.add("입력 후 사용해주세요");

        }

        //운동 이름 array(exer_name)가 비어있다면 기본값을 띄워주고, 아니라면 목록을 띄워줌
        if(exer_name.size()==0){
            ArrayAdapter<String> aa = new ArrayAdapter<> (this,
                    android.R.layout.simple_spinner_item ,
                    exer_default);
            // Spinner를 선언하고 main.xml에 선언한 Spinner 객체로 초기화
            Spinner sp = (Spinner)findViewById(R.id.spinner);
            sp.setAdapter(aa);
        }
        else {
            //String형을 관리하는 ArrayAdapter 선언,정의
            //this = 본 activity의 context
            // android.R.layout.simple_spinner_item: 안드로이드 라이브러리에 기본으로 내장된  spinner의 item을 위한 layout 리소스 파일
            // exer_name: spinner item list에 뿌려질 실제 data (운동목록)

            ArrayAdapter<String> aa = new ArrayAdapter<> (this,
                    android.R.layout.simple_spinner_item ,
                    exer_name);
            // Spinner를 선언하고 main.xml에 선언한 Spinner 객체로 초기화
            Spinner sp = (Spinner)findViewById(R.id.spinner);
            sp.setAdapter(aa);
        }

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
