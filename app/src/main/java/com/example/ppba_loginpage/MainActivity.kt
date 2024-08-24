package com.example.ppba_loginpage

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ppba_loginpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                if (username.isEmpty()|| password.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Masukan email dan password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (username == "admin" && password == "Admin#1234") {
                    Toast.makeText(this@MainActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }

            btnShowPassword.setOnClickListener {
                if (etPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    btnShowPassword.setImageResource(R.drawable.ic_visibility_on)
                } else {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    btnShowPassword.setImageResource(R.drawable.ic_visibility_off)
                }
            }
        }
    }
}
