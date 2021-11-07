package pk.edu.uiit18arid2509.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText naName, emEmail, phPhone, passPassword, cpassConfirmPassword, ctryCountry;
    Button btnRegister, btnReset;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        actions();

    }

    private void actions() {
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String name = naName.getText().toString();
                String email = emEmail.getText().toString();
                String phone = phPhone.getText().toString();
                String password = passPassword.getText().toString();
                String country = ctryCountry.getText().toString();
                long userdata = db.singup(name,email,password,phone,country);
                if(userdata==-1){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Submit",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,Login.class);

                    startActivity(intent);
                }



            }


        });
    }
     private void initialization(){
        db = new DbHelper(this);
         naName = (EditText) findViewById(R.id.naName);
         emEmail = (EditText) findViewById(R.id.emEmail);
         phPhone = (EditText) findViewById(R.id.phPhone);
         passPassword = (EditText) findViewById(R.id.passPassword);
         cpassConfirmPassword = (EditText) findViewById(R.id.cpassConfirmPassword);
         ctryCountry = (EditText) findViewById(R.id.ctryCountry);
         btnRegister = (Button) findViewById(R.id.btnRegister);
         btnReset = (Button) findViewById(R.id.btnReset);
         btnReset.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 naName.setText("");
                 emEmail.setText("");
                 phPhone.setText("");
                 passPassword.setText("");
                 cpassConfirmPassword.setText("");
                 ctryCountry.setText("");

             }
         });

    }


}


