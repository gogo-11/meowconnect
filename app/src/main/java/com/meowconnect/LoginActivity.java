package com.meowconnect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // Инициализиране на TextView от layout-a
        TextView signUpPrompt = findViewById(R.id.singUpPrompt);
        String text = "Don't have an account? Sign Up";
        SpannableString spannableString = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // Стартиране на SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };


        int signUpStart = text.indexOf("Sign Up");
        int signUpEnd = signUpStart + "Sign Up".length();
        spannableString.setSpan(clickableSpan, signUpStart, signUpEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Задаване на текста на TextView
        signUpPrompt.setMovementMethod(LinkMovementMethod.getInstance());
        signUpPrompt.setText(spannableString);
    }
}
