// Generated by view binder compiler. Do not edit!
package com.example.cleanwashattempt2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cleanwashattempt2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final EditText loginEmail;

  @NonNull
  public final EditText loginPassword;

  @NonNull
  public final TextView loginTitle;

  @NonNull
  public final TextView signupRedirectText;

  private ActivityLoginBinding(@NonNull ScrollView rootView, @NonNull Button loginButton,
      @NonNull EditText loginEmail, @NonNull EditText loginPassword, @NonNull TextView loginTitle,
      @NonNull TextView signupRedirectText) {
    this.rootView = rootView;
    this.loginButton = loginButton;
    this.loginEmail = loginEmail;
    this.loginPassword = loginPassword;
    this.loginTitle = loginTitle;
    this.signupRedirectText = signupRedirectText;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.login_email;
      EditText loginEmail = ViewBindings.findChildViewById(rootView, id);
      if (loginEmail == null) {
        break missingId;
      }

      id = R.id.login_password;
      EditText loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.login_title;
      TextView loginTitle = ViewBindings.findChildViewById(rootView, id);
      if (loginTitle == null) {
        break missingId;
      }

      id = R.id.signupRedirectText;
      TextView signupRedirectText = ViewBindings.findChildViewById(rootView, id);
      if (signupRedirectText == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ScrollView) rootView, loginButton, loginEmail, loginPassword,
          loginTitle, signupRedirectText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
