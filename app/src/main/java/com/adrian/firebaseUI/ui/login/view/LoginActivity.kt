package com.adrian.firebaseUI.ui.login.view

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.adrian.firebaseUI.R
import com.adrian.firebaseUI.ui.main.view.MainActivity
import com.facebook.CallbackManager
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class LoginActivity : AppCompatActivity() {

    object log {
        val TAG = LoginActivity::class.java.simpleName
    }

    private val RC_SIGN_IN = 9001

    val firebaseAuth = FirebaseAuth.getInstance()

    val callbackManager = CallbackManager.Factory.create();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        setContentView(R.layout.activity_login)


        btnFirebaseUI.setOnClickListener {
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder()
//                            .setTheme(getSelectedTheme())
                            .setTheme(R.style.AuthStyle)
//                            .setLogo(getSelectedLogo())
                            .setAvailableProviders(getSignInProviders())
                            .setTosUrl("https://eurobarca.com")
//                            .setPrivacyPolicyUrl(getSelectedPrivacyPolicyUrl())
                            .setIsSmartLockEnabled(false, true)
                            .setAllowNewEmailAccounts(true)
                            .build(),
                    RC_SIGN_IN)
        }


        try {
            val info = packageManager.getPackageInfo(
                    "com.adrian.firebaseUI",
                    PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.getEncoder().encodeToString(md.digest()))
            }
        } catch (e: PackageManager.NameNotFoundException) {

        } catch (e: NoSuchAlgorithmException) {

        }

    }

    private fun getSignInProviders(): MutableList<AuthUI.IdpConfig> {
        val selectedProviders = ArrayList<AuthUI.IdpConfig>()
        selectedProviders.add(AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build())
        selectedProviders.add(AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).setPermissions(getGooglePermissions()).build())
        selectedProviders.add(AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).setPermissions(getFacebookPermissions()).build())
//        selectedProviders.add(AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build())
//        selectedProviders.add(AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())
        return selectedProviders
    }

    override fun onResume() {
        super.onResume()
        if (checkCurrentUser()) {
            navigateToApp()
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode, data)
            return
        }
        if(resultCode == RESULT_CANCELED){
            toast("Unsuccessful singed in");
        }

        showSnackbar(R.string.unknown_response)
    }

    private fun handleSignInResponse(resultCode: Int, data: Intent?) {
        val response = IdpResponse.fromResultIntent(data)

        // Successfully signed in
        if (resultCode == Activity.RESULT_OK) {
            startSignedInActivity(response)
            finish()
            return
        } else {
            // Sign in failed
            if (response == null) {
                // User pressed back button
                showSnackbar(R.string.sign_in_cancelled)
                return
            }

            if (response.errorCode == ErrorCodes.NO_NETWORK) {
                showSnackbar(R.string.no_internet_connection)
                return
            }

            if (response.errorCode == ErrorCodes.UNKNOWN_ERROR) {
                showSnackbar(R.string.unknown_error)
                return
            }
        }

        showSnackbar(R.string.unknown_sign_in_response)
    }

    private fun startSignedInActivity(response: IdpResponse?) {
//        startActivity(
//                SignedInActivity.createIntent(
//                        this,
//                        response,
//                        SignedInActivity.SignedInConfig(
//                                getSelectedLogo(),
//                                getSelectedTheme(),
//                                getSelectedProviders(),
//                                getSelectedTosUrl(),
//                                mEnableCredentialSelector.isChecked(),
//                                mEnableHintSelector.isChecked())))
        navigateToApp()
    }

    private fun navigateToApp() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun checkCurrentUser(): Boolean {
        return firebaseAuth?.currentUser != null
    }

    private fun toast(stringId: Int) {
        Toast.makeText(this, resources.getString(stringId), Toast.LENGTH_SHORT).show()
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(@StringRes errorMessageRes: Int) {
        Snackbar.make(mRootView, errorMessageRes, Snackbar.LENGTH_LONG).show()
    }

    private fun getFacebookPermissions(): List<String> {
        val result = ArrayList<String>()
//        if (mFacebookScopeFriends.isChecked()) {
//            result.add("user_friends")
//        }
//        if (mFacebookScopePhotos.isChecked()) {
//            result.add("user_photos")
//        }
        return result
    }

    private fun getGooglePermissions(): List<String> {
        val result = ArrayList<String>()
//        if (mGoogleScopeYoutubeData.isChecked()) {
//            result.add("https://www.googleapis.com/auth/youtube.readonly")
//        }
//        if (mGoogleScopeDriveFile.isChecked()) {
//            result.add(Scopes.DRIVE_FILE)
//        }
        return result
    }
}
