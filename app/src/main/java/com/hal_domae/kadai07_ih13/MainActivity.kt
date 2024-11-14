package com.hal_domae.kadai07_ih13

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hal_domae.kadai07_ih13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = listOf(
            "モンスター01",
            "モンスター02",
            "モンスター03",
            "モンスター04",
            "モンスター05",
            "モンスター06",
            "モンスター07",
            "モンスター08",
        )

        // 1つ目の引数thisはコンテキスト(アプリやアクティビティの情報)
        // 2つ目の引数はリストの各項目に使うレイアウト(R.layout.simple_expandable_list_item_1はテキスト項目が1つだけあるレイアウト)
        // 3つ目の引数はリストに表示するデータ
//        binding.list.adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_expandable_list_item_1,
//            data
//        )
        binding.list.adapter = SimpleAdapter(
            this,
            listData,
            R.layout.list_item,
            arrayOf("image","name"),
            intArrayOf(R.id.image, R.id.name)
        )
        binding.list.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                this@MainActivity,
                "${listData[i]["name"]}を選択しました",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}