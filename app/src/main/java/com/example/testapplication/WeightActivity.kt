package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.concurrent.fixedRateTimer

class Weight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        var field1=findViewById<TextView>(R.id.field1)
        var field2=findViewById<TextView>(R.id.field2)
        var field3=findViewById<TextView>(R.id.field3)
        var field4=findViewById<TextView>(R.id.field4)
        var field5=findViewById<TextView>(R.id.field5)
        var field6=findViewById<TextView>(R.id.field6)
        var field7=findViewById<TextView>(R.id.field7)
        var unitSpin=findViewById<Spinner>(R.id.unitSpin)
        var buttonConvert=findViewById<Button>(R.id.buttonConvert)
        var buttonLength=findViewById<Button>(R.id.buttonLength)
        buttonLength.setOnClickListener{
            var new=Intent(this,LengthActivity::class.java)
            startActivity(new)
        }
        var refresh=findViewById<FloatingActionButton>(R.id.refresh)
        refresh.setOnClickListener{
            field1.setText("")
            this.recreate()
            }
        var units= arrayListOf("kg","lbs","oz","tonne","mg","g")
        unitSpin.adapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,units)
        unitSpin.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                }
            }
        buttonConvert.setOnClickListener {
            var pound= 0.0F
            var oz=0.0F
            var tonne=0.0F
            var mg=0L
            var g=0L
            var kg=0.0F
            when(unitSpin.selectedItem){
                "kg"-> {
                    pound = ((field1.getText().toString().toFloat()) * 2.204623).toFloat()
                    oz = ((field1.getText().toString().toFloat()) * 35.273962).toFloat()
                    tonne = ((field1.getText().toString().toFloat()) * 0.001).toFloat()
                    mg = ((field1.getText().toString().toFloat()) * 1000000).toLong()
                    g = ((field1.getText().toString().toFloat()) * 1000).toLong()
                    kg=(field1.text.toString().toFloat())
                    }
                "lbs"->{
                    pound=(field1.text.toString().toFloat())
                    oz=((field1.text.toString().toFloat())*16).toFloat()
                    tonne=((field1.text.toString().toFloat())*0.000454).toFloat()
                    mg=((field1.text.toString().toFloat())*453592.37).toLong()
                    g=((field1.text.toString().toFloat())*453.59237).toLong()
                    kg=((field1.text.toString().toFloat())*0.4535923).toFloat()
                    }
                "oz"->{
                    pound=((field1.text.toString().toFloat())*0.0625).toFloat()
                    oz=(field1.text.toString().toFloat())
                    tonne=((field1.text.toString().toFloat())*0.0000283).toFloat()
                    mg=((field1.text.toString().toFloat())*28349.523).toLong()
                    g=((field1.text.toString().toFloat())*28.349523).toLong()
                    kg=((field1.text.toString().toFloat())*0.0283495).toFloat()
                    }
                "tonne"->{
                    pound=((field1.text.toString().toFloat())*2204.623).toFloat()
                    oz=((field1.text.toString().toFloat())*35273.96).toFloat()
                    tonne=(field1.text.toString().toFloat())
                    mg=((field1.text.toString().toFloat())*1000000000).toLong()
                    g=((field1.text.toString().toFloat())*1000000).toLong()
                    kg=((field1.text.toString().toFloat())*1000).toFloat()
                    }
                "mg"->{
                    pound=((field1.text.toString().toFloat())*0.000002).toFloat()
                    oz=((field1.text.toString().toFloat())*0.000035).toFloat()
                    tonne=((field1.text.toString().toFloat())*1E-9).toFloat()
                    mg=(field1.text.toString().toLong())
                    g=((field1.text.toString().toFloat())*0.001).toLong()
                    kg=((field1.text.toString().toFloat())*0.000001).toFloat()
                    }
                "g"->{
                    pound=((field1.text.toString().toFloat())*0.002205).toFloat()
                    oz=((field1.text.toString().toFloat())*0.035274).toFloat()
                    tonne=((field1.text.toString().toFloat())*0.000001).toFloat()
                    mg= ((field1.text.toString().toFloat())*1000).toLong()
                    g=(field1.text.toString().toLong())
                    kg=((field1.text.toString().toFloat())*0.001).toFloat()
                    }
            }
            field1.setText(field1.text.toString())
            field2.setText(pound.toString())
            field3.setText(oz.toString())
            field4.setText(tonne.toString())
            field5.setText(mg.toString())
            field6.setText(g.toString())
            field7.setText(kg.toString())
            Toast.makeText(this,"Converted",Toast.LENGTH_LONG).show()
        }
        var Button=findViewById<Button>(R.id.loginButton)
        Button.setOnClickListener {
            var i=Intent(this,LoginActivity::class.java)
                    startActivity(i)
        }
    }
}