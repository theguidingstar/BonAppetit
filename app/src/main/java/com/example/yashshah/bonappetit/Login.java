package com.example.yashshah.bonappetit;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs2";
    public static final String Name = "nameKey";
    public static final String Password = "passKey";

    Boolean spclear=false;
    int backButtonCount=0;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private static DBHelper mydb;
    private ViewFlipper mViewFlipper;
    LinearLayout login_forgot_password;
    RelativeLayout Linear_layout_login;
    TextView textView_signUp,textView_Login,textView_forget_password_login,textView_forget_password_signup;
    EditText login_email,editTextPassword_login,Sign_up_Name,Sign_up_Number,Sign_up_Email,Sign_up_Password;
    TextInputLayout Login_editText_email_textInputlayout,Linear_editTextPassword,signup_name,signup_number,signup_email,signup_password;
    Button buttonLogin,buttonSignup;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sp.edit();
        Linear_layout_login=(RelativeLayout)findViewById(R.id.Linear_layout_login);
        Intent intent=getIntent();
        spclear=intent.getBooleanExtra("spclear",false);
        if(spclear)
        {
            editor.clear();
            editor.commit();
        }

        mydb=new DBHelper(getApplicationContext());
        signup_name=(TextInputLayout)findViewById(R.id.texInputLayout_sign_up_name);
        signup_number=(TextInputLayout)findViewById(R.id.texInputLayout_sign_up_number);
        signup_email=(TextInputLayout)findViewById(R.id.texInputLayout_sign_up_email);
        signup_password=(TextInputLayout)findViewById(R.id.texInputLayout_sign_up_Password);
        mViewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        textView_Login=(TextView)findViewById(R.id.loginTextView);
        textView_signUp=(TextView)findViewById(R.id.SignUpTextView);
        textView_forget_password_login=(TextView)findViewById(R.id.ForgetPasswordLogin);
        textView_forget_password_signup=(TextView)findViewById(R.id.ForgetPasswordSignUp);
        mViewFlipper.setInAnimation(this, R.anim.slide_in);
        login_email=(EditText)findViewById(R.id.Login_editText_email);
        Login_editText_email_textInputlayout=(TextInputLayout)findViewById(R.id.Login_editText_email_textInputlayout);
        login_forgot_password=(LinearLayout)findViewById(R.id.login_forgot_password);
        Linear_editTextPassword=(TextInputLayout)findViewById(R.id.Linear_editTextPassword);
        editTextPassword_login=(EditText)findViewById(R.id.editTextPassword_login);
        buttonLogin=(Button)findViewById(R.id.buttonLogin);
        buttonSignup=(Button)findViewById(R.id.buttonSignup);
        Sign_up_Name=(EditText)findViewById(R.id.Sign_up_Name);
        Sign_up_Number=(EditText)findViewById(R.id.Sign_up_Number);
        Sign_up_Email=(EditText)findViewById(R.id.Sign_up_EMail);
        Sign_up_Password=(EditText)findViewById(R.id.Sign_up_Password);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            verifyStoragePermissions(this);
            return;
        }

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName()) {
                    return;
                }


                if (!validateNumber()) {
                    return;
                }

                if (!validateEmail()) {
                    return;
                }

                if (!validatePassword()) {
                    return;
                }


                String Name=Sign_up_Name.getText().toString();
                String Number=Sign_up_Number.getText().toString();
                String Email=Sign_up_Email.getText().toString();
                String pass=Sign_up_Password.getText().toString();
                System.out.println(Name+"......"+Number+"....."+Email);
                Boolean signup=mydb.insertContact(Name,Number,Email,pass);
                if(signup) {
                    Toast.makeText(getApplicationContext(), "Sign Up SuccessFul", Toast.LENGTH_SHORT).show();
                    mViewFlipper.showNext();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sign Up Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateEmailLogin()) {
                    return;
                }

                if (!validatePasswordLogin()) {
                    return;
                }

                ArrayList<String> stringArrayListEmail=new ArrayList<String>();
                ArrayList<String> stringArrayListPassword=new ArrayList<String>();
                List<details> contacts = mydb.getAllContactsID();
                for (details cn : contacts) {
                    stringArrayListEmail.add(cn.getName());
                    stringArrayListPassword.add(cn.getPhone());
                }

                String Entered_Email=login_email.getText().toString().trim();
                String Entered_Password=editTextPassword_login.getText().toString().trim();
                int i1=1;
                while (i1==1) {
                    for (int i = 0; i < stringArrayListEmail.size(); i++) {
                        System.out.println(Entered_Email + "..." + stringArrayListEmail.get(i).toString());
                        System.out.println(Entered_Password + "..." + stringArrayListPassword.get(i).toString());
                        if ((stringArrayListEmail.get(i).toString().matches(Entered_Email)) && (stringArrayListPassword.get(i).toString().matches(Entered_Password))) {
                            editor.putString(Name, Entered_Email);
                            editor.putString(Password, Entered_Password);
                            editor.commit();
                            Intent intent = new Intent(getApplicationContext(), Main_Navigation_activity.class);
                            intent.putExtra("email",Entered_Email);
                            startActivity(intent);
                            return;
                        }
                    }
                    i1++;
                }

                Toast.makeText(getApplicationContext(),"Sign up or Enter Correct Email ID Password",Toast.LENGTH_LONG).show();
            }
        });

        textView_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewFlipper.showNext();
            }
        });

        textView_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewFlipper.showPrevious();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }

    }

    private boolean validateName() {
        if (Sign_up_Name.getText().toString().trim().isEmpty()) {
            signup_name.setError("Please Enter Name");
            requestFocus(Sign_up_Name);
            return false;
        } else {
            signup_name.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (Sign_up_Password.getText().toString().trim().isEmpty()) {
            signup_password.setError("Please Enter Name");
            requestFocus(Sign_up_Password);
            return false;
        } else {
            signup_password.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmailLogin() {
        String email = login_email.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            Login_editText_email_textInputlayout.setError("Enter Appropiate Email");
            requestFocus(login_email);
            return false;
        } else {
            Login_editText_email_textInputlayout.setErrorEnabled(false);
        }

        return true;

    }

    private boolean validatePasswordLogin() {
        if (editTextPassword_login.getText().toString().trim().isEmpty()) {
            Linear_editTextPassword.setError("Please Your Password");
            requestFocus(editTextPassword_login);
            return false;
        } else {
            Linear_editTextPassword.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = Sign_up_Email.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            signup_email.setError("Enter Appropiate Email");
            requestFocus(Sign_up_Email);
            return false;
        } else {
            signup_email.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNumber() {
        if (Sign_up_Number.getText().toString().trim().isEmpty()) {
            signup_email.setError("Enter Number");
            requestFocus(Sign_up_Number);
            return false;
        } else {
            signup_email.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher
    {

        private View view;

        private MyTextWatcher(View view)
        {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
        }

        public void afterTextChanged(Editable editable)
        {
            switch (view.getId())
            {
                case R.id.Sign_up_Name:
                    validateName();
                    break;
                case R.id.Sign_up_EMail:
                    validateEmail();
                    break;
                case R.id.Sign_up_Number:
                    validateNumber();
                    break;

                case R.id.Sign_up_Password:
                    validateNumber();
                    break;

                case R.id.Login_editText_email:
                    validateEmailLogin();
                    break;

                case R.id.editTextPassword_login:
                    validatePasswordLogin();
                    break;
            }
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        int callPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
        int readCpntactPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
        int writeContactPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_CONTACTS);


        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED
                || callPermission != PackageManager.PERMISSION_GRANTED || readCpntactPermission!= PackageManager.PERMISSION_GRANTED
                ||writeContactPermission != PackageManager.PERMISSION_GRANTED ) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
