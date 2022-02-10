package com.example.helloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        etInputNumber.movementMethod = ScrollingMovementMethod()
        etInputNumber.isActivated
        etInputNumber.isPressed
        var text:String

        one.setOnClickListener {
                text =etInputNumber.text.toString() + "1"
            etInputNumber.setText(text)
            result(text)
        }

        two.setOnClickListener {
            text =etInputNumber.text.toString() + "2"
            etInputNumber.setText(text)
            result(text)
        }

        three.setOnClickListener {
            text =etInputNumber.text.toString() + "3"
            etInputNumber.setText(text)
            result(text)
        }

        four.setOnClickListener {
            text =etInputNumber.text.toString() + "4"
            etInputNumber.setText(text)
            result(text)
        }

        five.setOnClickListener {
            text =etInputNumber.text.toString() + "5"
            etInputNumber.setText(text)
            result(text)
        }

        six.setOnClickListener {
            text =etInputNumber.text.toString() + "6"
            etInputNumber.setText(text)
            result(text)
        }

        seven.setOnClickListener {
            text =etInputNumber.text.toString() + "7"
            etInputNumber.setText(text)
            result(text)
        }

        eight.setOnClickListener {
            text =etInputNumber.text.toString() + "8"
            etInputNumber.setText(text)
            result(text)
        }

        nine.setOnClickListener {
            text =etInputNumber.text.toString() + "9"
            etInputNumber.setText(text)
            result(text)
        }

        zero.setOnClickListener {
            text =etInputNumber.text.toString() + "0"
            etInputNumber.setText(text)
            result(text)
        }
            doublezero.setOnClickListener {
            text =etInputNumber.text.toString() + "00"
            etInputNumber.setText(text)
            result(text)
        }

        dot.setOnClickListener {
            text =etInputNumber.text.toString() + "."
            etInputNumber.setText(text)
            result(text)
        }

        plus.setOnClickListener {
            text= etInputNumber.text.toString()+ "+"
            etInputNumber.setText(text)
            check = check+1
        }

        minus.setOnClickListener {
            text = etInputNumber.text.toString() + "-"
            etInputNumber.setText(text)
            check=check+1
        }

        multiply.setOnClickListener {
            text = etInputNumber.text.toString() + "*"
            etInputNumber.setText(text)
            check=check+1
        }

        divide.setOnClickListener {
            text = etInputNumber.text.toString() + "/"
            etInputNumber.setText(text)
            check=check+1
        }

        percent.setOnClickListener {
            text = etInputNumber.text.toString() + "%"
            etInputNumber.setText(text)
            check=check+1
        }

        equal.setOnClickListener {
            text = etInputNumber.text.toString()
            etInputNumber.setText(text)
            etResult.setText(null)
        }

        clear.setOnClickListener {
            etInputNumber.setText(null)
            etResult.setText(null)
        }

        back.setOnClickListener {
            var backspace:String? = null
            if (etInputNumber.text.length>0){
                val stringBuilder = StringBuilder(etInputNumber.text)
                val find = etInputNumber.text.toString()
                val find2 = find.last()

                if (find2.equals('+')|| find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){

                    check = check-1
                }

                stringBuilder.deleteCharAt(etInputNumber.text.length-1)
                backspace = stringBuilder.toString()
                etInputNumber.setText(backspace)
                result(backspace)
            }
        }
    }

    private fun result(text: String) {

        var engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            var result:Any = engine.eval(text)
            var main = result.toString()

            if (check==0){
                etResult.setText(null)
            }else{
                etResult.setText(main)
            }
        }
        catch (e:ScriptException){
            Toast.makeText(this, "some exception occurs", Toast.LENGTH_SHORT).show()
        }
    }

}
