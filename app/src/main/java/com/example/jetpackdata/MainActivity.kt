package com.example.jetpackdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdata.viewModel.MyViewModel
import com.example.jetpackdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MyViewModelでViewModel()を継承する必要がある
        val myViewModel : MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.viewModel = myViewModel
        binding.person = myViewModel.person.get()

        binding.button1.setOnClickListener {
            val n = binding.frmName.text.toString()
            val m = binding.frmEmail.text.toString()
            val a = binding.frmAge.text.toString().toInt()

            myViewModel.add(n, m, a)
            myViewModel.person.get()!!.name.set("name")
            myViewModel.person.get()!!.mail.set("mail@address")
            myViewModel.person.get()!!.age.set("0")
            myViewModel.allText.set(myViewModel.allByText())
        }
    }
}