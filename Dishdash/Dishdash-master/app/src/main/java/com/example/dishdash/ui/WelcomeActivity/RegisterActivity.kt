package com.example.dishdash.ui.WelcomeActivity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import com.example.dishdash.R
import com.example.dishdash.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myUsername = binding.usernameEditText
        val myEmail = binding.emailEditText
        val myPassword = binding.passwordEditText


        setupView()
        setupAction()
        setMyButtonEnabled()


        binding.checkboxSnk.setOnCheckedChangeListener { _, _ ->
            setMyButtonEnabled()
        }

        myEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        myUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Tindakan sebelum teks berubah pada nameEditText
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Tindakan ketika teks berubah pada nameEditText
                setMyButtonEnabled()
            }

            override fun afterTextChanged(s: Editable?) {
                // Tindakan setelah teks berubah pada nameEditText
            }
        })
        myPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Tindakan sebelum teks berubah pada nameEditText
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Tindakan ketika teks berubah pada nameEditText
                val passwordText = s.toString()
                if (passwordText.length < 8) {
                    binding.btnRegister.isEnabled = false
                } else {
                    binding.passwordEditText.error = null // Hapus pesan error jika valid
                    setMyButtonEnabled() // Validasi email dan name
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Tindakan setelah teks berubah pada nameEditText
            }
        })
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }


    private fun setupAction(){
        binding.btnRegister.setOnClickListener {

        }
        binding.textLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun setMyButtonEnabled() {
        val nameText = binding.usernameEditText.text.toString()
        val emailText = binding.emailEditText.text.toString()
        val passwordText = binding.passwordEditText.text.toString()
        val isCheckboxChecked = binding.checkboxSnk.isChecked

        val isEmailValid = emailText.isNotEmpty()
        val isNameValid = nameText.isNotEmpty()
        val isPasswordValid = passwordText.length >= 8
        val isCheckboxValid = isCheckboxChecked

        Log.d("RegisterActivity", "Is Checkbox Valid: $isCheckboxValid")

        binding.btnRegister.isEnabled = isEmailValid && isNameValid && isPasswordValid && isCheckboxValid
    }
}