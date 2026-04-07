package com.BlueBerry;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity{

    private static final String TAG = "BlueBerry_app";
    private static final boolean D = true;
    public static final int REQUEST_PERMISSION_FINE = 1001;

    private int mPermissionCheck=-1;
    private Resources mAppRes;
    private Context szPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);

        mAppRes = this.getResources();
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_FINE);
    }
    /* Intro Configuration */
    public void moveFunc(View view){
        switch(view.getId()) {
            case R.id.goMainActivity:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.goP1BTN:
                startActivity(new Intent(this, p1Activity.class));
                break;
            case R.id.goP2BTN:
                startActivity(new Intent(this, p2Activity.class));
                break;
            case R.id.goP3BTN:
                startActivity(new Intent(this, p3Activity.class));
                break;
            case R.id.goP4BTN:
                startActivity(new Intent(this, p4Activity.class));
                break;
            case R.id.goP5BTN:
                startActivity(new Intent(this, p5Activity.class));
                break;
            case R.id.goP6BTN:
                startActivity(new Intent(this, p6Activity.class));
                break;
            case R.id.goP7BTN:
                startActivity(new Intent(this, p7Activity.class));
                break;
            case R.id.goP8BTN:
                startActivity(new Intent(this, p8Activity.class));
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_FINE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //-권한 허용
                    Log.i(TAG, mAppRes.getString(R.string.permission_granted));
                } else {
                    //-허용 불가
                    Toast.makeText(this, R.string.permission_denied, Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }
    //- Bluetooth 기기 검색이 가능하도록 권한 허용 요청 ---------------------------------------------------------------------
    private void requestPermission(String szPermission, int reqCode){

        //- 위치 검색 권한 허용 여부 검사
        mPermissionCheck = ContextCompat.checkSelfPermission(this, szPermission);

        if(mPermissionCheck != PackageManager.PERMISSION_GRANTED)
        {
            //- 허용 불가 된 경우 사용자가 재 확인 요청
            ActivityCompat.requestPermissions(this,  new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, reqCode);
        }
    }
}
