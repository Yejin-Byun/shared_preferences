package com.example.shared_preferences

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shared_preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data 저장 성공", Toast.LENGTH_SHORT).show()
        }
        loadData()
    }

    // 데이터를 저장하는 함수
    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() // pref의 수정 모드

        // putString 의 첫 번째 인자는 키, 두 번째 인자는 실제 데이터 값
        edit.putString("name", binding.etHello.text.toString())
        edit.apply() // 저장 완료
    }

    // 데이터를 불러오는 함수
    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        // pref.getString()
        // 첫 번째 인자는 키, 두 번째 인자는 데이터가 존재하지 않을 경우의 값
        binding.etHello.setText(pref.getString("name", ""))
    }

}