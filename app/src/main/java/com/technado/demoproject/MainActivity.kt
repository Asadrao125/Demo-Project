package com.technado.demoproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.technado.demoproject.models.MovieModel
import com.technado.demoproject.view_model.MovieListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel: MovieListViewModel
        var moviesList: List<MovieModel?>

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnApiCall = findViewById<Button>(R.id.btnApiCall)

        btnApiCall.setOnClickListener(View.OnClickListener {
            viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
            viewModel.getMoviesListObserver()!!.observe(this, object : Observer<List<MovieModel?>?> {
                override fun onChanged(movieModels: List<MovieModel?>?) {
                    if (movieModels != null) {
                        moviesList = movieModels
                        Toast.makeText(this@MainActivity, "" + moviesList.size, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, "No Result Found", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            viewModel.makeApiCall()
        })

        btnLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Login Button Pressed", Toast.LENGTH_SHORT)
            var email = edtEmail.text.toString()
            var password = edtPassword.text.toString()
            loginApi(email, password);
        })
    }

    private fun loginApi(email: String, password: String) {

    }
}