package com.example.calapp

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.Snackbar
import android.os.Bundle
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonTimes.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var input1 = editText1.text.toString()
        var input2 = editText2.text.toString()

        if (input1.equals("") || input2.equals("")){
            Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_INDEFINITE).setAction("了解"){
                Log.d("UI_PARTS", "Snackbarをタップした")
            }.show()

        }else {
            var i1 = input1.toDouble()
            var i2 = input2.toDouble()

            when (v.id) {
                R.id.buttonPlus -> calcPlus(i1, i2)
                R.id.buttonMinus -> calcMinus(i1, i2)
                R.id.buttonTimes -> calcTimes(i1, i2)
                R.id.buttonDivide -> calcDivide(i1, i2)
            }
        }
    }

    private fun calcPlus(i1: Double, i2: Double) {
        var total = i1 + i2
        nextPage(total)
    }

    private fun calcMinus(i1: Double, i2: Double) {
        var total = i1 - i2
        nextPage(total)
    }

    private fun calcTimes(i1: Double, i2: Double) {
        var total = i1 * i2
        nextPage(total)
    }

    private fun calcDivide(i1: Double, i2: Double) {
        var total = i1 / i2
        nextPage(total)
    }

    private fun nextPage(total: Double){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("TOTAL", total)
        startActivity(intent)
    }

}