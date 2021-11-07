package pk.edu.uiit18arid2509.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView login;
    EditText loginEmail, loginPass;
    Button loginSubmit;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initial();
    }

    private void initial(){
        login=(TextView) findViewById(R.id.login);
        loginEmail=(EditText) findViewById(R.id.loginEmail);
        loginPass=(EditText) findViewById(R.id.loginPass);
        loginSubmit=(Button) findViewById(R.id.loginSubmit);
    }
}