package com.example.testdbentity.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.login.database.LoginEntity;
import com.example.testdbentity.login.database.LoginViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class LoginTabFragment extends Fragment {
    private LoginViewModel loginViewModel;
    private BookingHotelViewModel bookingHotelViewModel;

    private boolean checkEmail, checkPass = false;

    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
    public LoginTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    private void loginWithGoogle(View view)
    {
        ImageButton googleLogin = view.findViewById(R.id.login_google);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(getContext(), gso);

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = gsc.getSignInIntent();
                startActivityForResult(signInIntent, 1000);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToMainPage();
            }
            catch (ApiException e)
            {

            }
        }
    }

    private void navigateToMainPage() {
        getActivity().finish();
        Intent intent = new Intent(getActivity(), MainPageActivity.class);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_tab, container, false);
        TextInputEditText email = view.findViewById(R.id.login_tab_email);
        TextInputEditText pass = view.findViewById(R.id.login_tab_password);
        Button login = view.findViewById(R.id.login_button);

        //check
        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_NEXT)
                {
                    String emailInput = email.getText().toString();
                    if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
                    {
                        pass.requestFocus();
                        checkEmail = true;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Sai định dạng email!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        pass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_DONE)
                {
                    String passInput = pass.getText().toString();
                    if(!passInput.isEmpty() && pass.length() >= 3)
                    {
                        pass.requestFocus();
                        checkPass = true;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Không đủ bảo mật!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String emailInput = email.getText().toString();
                    String passInput = pass.getText().toString();
                    loginViewModel.getAccountSameEmail(emailInput).observe(getActivity(), new Observer<LoginEntity>() {
                        @Override
                        public void onChanged(LoginEntity loginEntity) {
                            if (loginEntity == null) {
                                Toast.makeText(getContext(), "Tai khoan chua ton tai!", Toast.LENGTH_SHORT).show();
                            } else {
                                if(passInput.equals(loginEntity.passwordAccount))
                                {
                                    //login
                                    Toast.makeText(getContext(), "Login!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity(), MainPageActivity.class);

                                    if(loginEntity != null)
                                    {
                                        bookingHotelViewModel.getInformationOneUser(loginEntity.idAccount).observe(getActivity(), new Observer<InformationEntity>() {
                                            @Override
                                            public void onChanged(InformationEntity informationEntity) {
                                                int x = 0;
                                                if(informationEntity != null)
                                                {
                                                    x = informationEntity.idInformationUser;
                                                }
                                                intent.putExtra("idUserInformation", x);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                }
                                else
                                {
                                    Toast.makeText(getContext(), "Sai mat khau!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
            }
        });
        loginWithGoogle(view);
        return view;
    }
    private void checkInputMail()
    {

    }
}
