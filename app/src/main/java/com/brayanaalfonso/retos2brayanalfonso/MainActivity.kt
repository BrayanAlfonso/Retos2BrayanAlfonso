package com.brayanaalfonso.retos2brayanalfonso

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ejercicio #1

        val result: TextView = findViewById(R.id.txtresult)

        val options = arrayOf("Suma", "Resta", "Multiplicación", "División")
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        spinner.adapter = adapter

        val btnCalculate = findViewById<Button>(R.id.btnclicked)

        btnCalculate.setOnClickListener() {

            val num1:Int=findViewById<EditText?>(R.id.txtnum1).text.toString().toInt()
            val num2:Int=findViewById<EditText?>(R.id.txtnum2).text.toString().toInt()

            val position = spinner.selectedItemPosition

            when (options[position]){
                "Suma" ->  result.text = "El resultado de la suma ha sido: ${num1+num2}"
                "Resta" -> result.text = "El resultado de la resta ha sido: ${num1-num2}"
                "Multiplicación" -> result.text = "El resultado de la multiplicación ha sido: ${num1*num2}"
                "División" -> result.text = "El resultado de la división ha sido: ${num1/num2}"
                else-> result.text= "Has ingresado valores invalidos"
            }
        }

        //Ejercicio #2
        val optionsEx2= arrayOf("Fahrenheit", "Celsius", "Kelvin")

        val spinnerConvertOf= findViewById<Spinner>(R.id.spinnerConvertOf)
        val spinnerConvertTo= findViewById<Spinner>(R.id.spinnerConvertTo)

        val adapterEx2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, optionsEx2)
        spinnerConvertOf.adapter = adapterEx2
        spinnerConvertTo.adapter=adapterEx2

        val btnConvert=findViewById<Button>(R.id.btnConvert)

        btnConvert.setOnClickListener(){
            val degrees=findViewById<EditText>(R.id.txtDegrees).text.toString().toFloat()

            val convertOf= spinnerConvertOf.selectedItemPosition
            val convertTo=spinnerConvertTo.selectedItemPosition

            val result2:TextView=findViewById(R.id.txtResult2)

            if (convertOf==0 && convertTo==0){
                result2.text="Ya estan en grados Fahrenheit"
            }else if (convertOf==1 && convertTo==0){
                result2.text="La conversion de grados Celsius a grados Fahrenheit es de ${(degrees*9/5)+32} grados Fahrenheit "
            }else if (convertOf==2 && convertTo==0){
                result2.text="La conversion de grados Kelvin a grados Fahrenheit es de ${(degrees-273.15) * 9/5 + 32} grados Fahrenheit "
            }else if (convertOf==0 && convertTo==1){
                result2.text="La conversion de grados Fahrenheit a grados Celsius es de ${(degrees-32) * 5/9} grados Celsius "
            }else if (convertOf==1 && convertTo==1){
                result2.text="Ya estan en grados celsius"
            }else if (convertOf==2 && convertTo==1){
                result2.text="La conversion de grados Kelvin a grados Celsius es de ${degrees-273.15} grados Celsius "
            }else if (convertOf==0 && convertTo==2){
                result2.text="La conversion de Fahrenheit  a grados Kelvin es de ${(degrees+459.67) * 5/9} grados Kelvin "
            }else if (convertOf==1 && convertTo==2){
                result2.text="La conversion de Celsius  a grados Kelvin es de ${degrees+ 273.15} grados Kelvin "
            }else if (convertOf==2 && convertTo==2){
                result2.text="Ya estan en grados Kelvin"
            }else{
                result2.text="Has ingresado valores invalidos."
            }
        }

        //Ejercicio #3

        val btnCalculateTri=findViewById<Button>(R.id.btnCalculateTri)

        btnCalculateTri.setOnClickListener(){
            val side1=findViewById<EditText>(R.id.txtSide1).text.toString().toFloat()
            val side2=findViewById<EditText>(R.id.txtSide2).text.toString().toFloat()
            val side3=findViewById<EditText>(R.id.txtSide3).text.toString().toFloat()
            val result3:TextView=findViewById(R.id.txtResult3)

            if (side1==side2 && side1==side3){
                result3.text="El triangulo es equilatero ya que todos sus lados son iguales"
            }else if (side1==side2 || side1==side3 || side2==side3){
                result3.text="El triangulo es isóceles, ya que al menos dos de sus lados son iguales."
            }else if (side1!=side2 && side1!=side3 && side2!=side3){
                result3.text="El triangulo es escaleno, ya que ninguno de sus lados son iguales."
            }else{
                result3.text="Has ingresado valores incorrectos"
            }

        }



    }
}
