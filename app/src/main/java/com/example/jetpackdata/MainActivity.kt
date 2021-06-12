package com.example.jetpackdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdata.data.viewModel.MyViewModel
import com.example.jetpackdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding : ActivityMainBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // MyViewModelでViewModel()を継承する必要がある
        val myViewModel : MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text1.text = updateData(myViewModel)
        binding.button1.setOnClickListener {
            val n = binding.frmName.text.toString()
            val m = binding.frmEmail.text.toString()
            val a = binding.frmAge.text.toString().toInt()
            myViewModel.add(n, m, a)
            binding.text1.text = updateData(myViewModel)
        }
    }

    private fun updateData(vm: MyViewModel): String {
        val data = vm.getAll()
        var people = ""
        for(item in data){
            people += item.to_s()
            people += "\n"
        }
        return people
    }
}