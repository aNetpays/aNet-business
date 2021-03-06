package in.anetpays.siddhant.anet_business.Login;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import in.anetpays.siddhant.anet_business.Constants.SharedPreferencesConstants;
import in.anetpays.siddhant.anet_business.Login.Fragments.LoginFragment;
import in.anetpays.siddhant.anet_business.MainActivity;
import in.anetpays.siddhant.anet_business.R;

import static in.anetpays.siddhant.anet_business.Constants.SharedPreferencesConstants.PREF_LOGIN;


public class MainLoginActivity extends AppCompatActivity
{
    private static FragmentManager fragmentManager;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_login);
        fragmentManager = this.getSupportFragmentManager();
        sharedPreferences = getSharedPreferences(PREF_LOGIN, MODE_PRIVATE);

        if(sharedPreferences.getBoolean(SharedPreferencesConstants.IS_LOGGED_IN, false))
        {
            gotoProfile();
            Log.d("Already Logged in", "Going to MainActivity");
        }
        else
        {
            if(savedInstanceState == null)
            {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, new LoginFragment(),
                        Utils.Login_Fragment).commit();
            }
        }
        findViewById(R.id.close_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void replaceFragment(){
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.frame, new LoginFragment(), Utils.Login_Fragment)
                .commit();
    }
    @Override
    public void onBackPressed(){
        Fragment ForgotPassword = fragmentManager.findFragmentByTag(Utils.Forgot_Password);
        Fragment SignupFragment = fragmentManager.findFragmentByTag(Utils.SignUp_Fragment);
        if(ForgotPassword != null)
        {
            replaceFragment();
        }

        else if(SignupFragment != null)
        {
            replaceFragment();
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void gotoProfile(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
