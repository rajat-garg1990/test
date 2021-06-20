package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class LengthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)
        var buttonWeight=findViewById<Button>(R.id.buttonWeight)
        buttonWeight.setOnClickListener {
            var new=Intent(this,Weight::class.java)
            startActivity(new)
        }
        var field1=findViewById<TextView>(R.id.field1)
        var field2=findViewById<TextView>(R.id.field2)
        var field3=findViewById<TextView>(R.id.field3)
        var field4=findViewById<TextView>(R.id.field4)
        var field5=findViewById<TextView>(R.id.field5)
        var field6=findViewById<TextView>(R.id.field6)
        var field7=findViewById<TextView>(R.id.field7)
        var field8=findViewById<TextView>(R.id.field8)
        var unitSpin=findViewById<Spinner>(R.id.unitSpin)
        var units= arrayListOf("m","inch","feet","yard","mile","km","cm")
        unitSpin.adapter=
            ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,units)
        unitSpin.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }
        var refresh=findViewById<FloatingActionButton>(R.id.refresh)
        refresh.setOnClickListener{
            field1.setText("")
            this.recreate()
        }
        var buttonConvert=findViewById<Button>(R.id.buttonConvert)
        buttonConvert.setOnClickListener {
            var inches: Float = ((field1.getText().toString().toFloat())*39.370079).toFloat()
            var feet: Float = ((field1.getText().toString().toFloat())*3.28084).toFloat()
            var yard: Float = ((field1.getText().toString().toFloat())*1.093613).toFloat()
            var mile: Float = ((field1.getText().toString().toFloat())*0.000621).toFloat()
            var km: Float = ((field1.getText().toString().toFloat())*0.001).toFloat()
            var cm: Float = ((field1.getText().toString().toFloat())*100).toFloat()
            field1.setText(field1.text.toString())
            field2.setText(inches.toString())
            field3.setText(feet.toString())
            field4.setText(yard.toString())
            field5.setText(mile.toString())
            field6.setText(km.toString())
            field7.setText(cm.toString())
            Toast.makeText(this,"Converted", Toast.LENGTH_LONG).show()
            var sb=Snackbar.make(it,"Converted",Snackbar.LENGTH_INDEFINITE)
            sb.setAction("Refresh") {
                field1.setText("")
                this.recreate()
            }
            sb.show()
        }
    }
}