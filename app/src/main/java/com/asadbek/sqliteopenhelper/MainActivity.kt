package com.asadbek.sqliteopenhelper

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asadbek.sqliteopenhelper.databinding.ActivityMainBinding
import com.asadbek.sqliteopenhelper.model.User
import com.asadbek.sqliteopenhelper.offline.OfflineBaza

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<User>
    lateinit var binding: ActivityMainBinding
    lateinit var offlineBaza: OfflineBaza
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        offlineBaza = OfflineBaza(this)
        binding.btnSave.setOnClickListener {
            if (binding.edt.text.isNotEmpty()){
                offlineBaza.addUser(User(binding.edt.text.toString().trim()))
                Toast.makeText(this, "Ma`lumot qo`shildi!", Toast.LENGTH_SHORT).show()
                binding.edt.text.clear()
                onResm()
            }
        }
        onResm()
    }
    @SuppressLint("SetTextI18n")
    private fun onResm(){
        offlineBaza.getAllUser().forEach {
            list.add(it)
        }
        if (list.isNotEmpty()){
            list.forEach {
                binding.txtShow.text = "\t" + it.name
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }
}