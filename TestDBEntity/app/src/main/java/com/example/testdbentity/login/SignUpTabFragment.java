package com.example.testdbentity.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.MainPageActivity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.login.database.LoginEntity;
import com.example.testdbentity.login.database.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class SignUpTabFragment extends Fragment {
    private LoginViewModel loginViewModel;
    private BookingHotelViewModel bookingHotelViewModel;
    boolean checkAdd;
    TextInputEditText email;
    TextInputEditText pass;
    TextInputEditText repass;
    TextInputEditText phonenumber;
    TextInputEditText firstname;
    TextInputEditText lastname;
    String passInput = "";

    boolean checkEmail, checkPass, checkRePass, checkPhone = false;
    public SignUpTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_tab, container, false);
        email = view.findViewById(R.id.sign_up_tab_email);
        pass = view.findViewById(R.id.sign_up_tab_password);
        repass = view.findViewById(R.id.sign_up_tab_re_password);
        phonenumber = view.findViewById(R.id.sign_up_tab_phone);
        firstname = view.findViewById(R.id.sign_up_tab_first_name);
        lastname = view.findViewById(R.id.sign_up_tab_last_name);
        Button signUp = view.findViewById(R.id.button_sign_up);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        checkAdd = false;

        boolean checkDone = checkInput();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String emailS = email.getText().toString();
                    String passS = pass.getText().toString();
                    String repassS = repass.getText().toString();
                    String firstnameS = firstname.getText().toString();
                    String lastnameS = lastname.getText().toString();
                    String phonenumberS = phonenumber.getText().toString();
                    //lay dia chi email trong table xem da co chua
                    loginViewModel.getAccountSameEmail(emailS).observe(getActivity(), new Observer<LoginEntity>() {
                        @Override
                        public void onChanged(LoginEntity loginEntity) {
                            if(loginEntity != null && !checkAdd)
                            {
                                //neu co roi
                                Toast.makeText(getContext(), "Tai khoan da ton tai!", Toast.LENGTH_SHORT).show();
                            }
                            else if(loginEntity != null && checkAdd)
                            {
                                List<InformationEntity> informationEntities = new ArrayList<>();
                                //add thong tin nguoi dung moi
                                InformationEntity informationEntity = new InformationEntity(firstnameS, lastnameS, phonenumberS, 1, emailS);
                                informationEntity.foreignKeyInformationUser = loginEntity.idAccount;
                                informationEntities.add(informationEntity);
                                bookingHotelViewModel.insertInformation(informationEntities);
                                Toast.makeText(getContext(), "Dang ky thanh cong:" + String.valueOf(loginEntity.idAccount), Toast.LENGTH_SHORT).show();

                                //check null
                                bookingHotelViewModel.getInformationOneUser(loginEntity.idAccount).observe(getActivity(), new Observer<InformationEntity>() {
                                    @Override
                                    public void onChanged(InformationEntity informationEntity) {
                                        Intent intent = new Intent(getActivity(), MainPageActivity.class);
                                        if(informationEntity != null)
                                        {
                                            intent.putExtra("idUserInformation", informationEntity.idInformationUser);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Toast.makeText(getContext(), "Dang ky khong thanh cong", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else if(!passS.equals(repassS))
                            {
                                //check pass xem trung nhau chua
                                Toast.makeText(getContext(), "Khong hop le!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                //neu email chua ton tai va pass hop le
                                loginEntity = new LoginEntity(firstnameS, lastnameS, emailS, passS, phonenumberS);
                                loginViewModel.createAccount(loginEntity);
                                checkAdd = true;
                                //loginEntity nay la cai de add. Sau khi add se co idAccount khac. Nen sau khi add no se quay lai ham observe
                                //boi vi no da add nen coi nhu thay doi

                            }
                        }
                    });

                }

        });
        return view;
    }
    private boolean checkInput()
    {
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
                if(i == EditorInfo.IME_ACTION_NEXT)
                {
                    passInput = pass.getText().toString();
                    if(!passInput.isEmpty() && passInput.length() >= 3)
                    {
                        repass.requestFocus();
                        checkPass = true;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Bảo mật yếu!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        repass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_NEXT)
                {
                    String repassInput = repass.getText().toString();
                    if(!repassInput.isEmpty() && repassInput.length() >= 3 && repassInput.equals(passInput))
                    {
                        phonenumber.requestFocus();
                        checkRePass = true;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Bảo mật yếu!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        phonenumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_DONE)
                {
                    String phoneInput = phonenumber.getText().toString();
                    if(!phoneInput.isEmpty() && (phoneInput.length() == 10 || phoneInput.length() == 11))
                    {
                        checkPhone = true;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Bảo mật yếu!", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        if (checkEmail && checkPass && checkRePass && checkPhone)
        {
            return true;
        }
        return false;
    }
}