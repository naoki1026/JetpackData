package com.example.jetpackdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdata.data.model.Person
import com.example.jetpackdata.viewModel.MyViewModel
import com.example.jetpackdata.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Name
        val nameObserver = Observer<String> { newName ->
            binding.frmName.setText(newName, TextView.BufferType.NORMAL)
        }
        myViewModel.name.observe(this, nameObserver)

        // Mail
        val mailObserver = Observer<String> { newMail ->
            binding.frmEmail.setText(newMail, TextView.BufferType.NORMAL)
        }
        myViewModel.mail.observe(this, mailObserver)

        // Age
        val ageObserver = Observer<String> { newAge ->
            binding.frmAge.setText(newAge, TextView.BufferType.NORMAL)
        }
        myViewModel.age.observe(this, ageObserver)

        // All
        val allObserver = Observer<String> { newAll ->
            binding.text1.setText(newAll, TextView.BufferType.NORMAL)
        }
        myViewModel.allText.observe(this, allObserver)


        binding.button1.setOnClickListener {
            myViewModel.add(
                binding.frmName.text.toString(),
                binding.frmEmail.text.toString(),
                binding.frmAge.text.toString().toInt()
            )

            myViewModel.name.value = ""
            myViewModel.mail.value = ""
            myViewModel.age.value = "0"
            myViewModel.allText.value = myViewModel.allByText()
        }



    }
}