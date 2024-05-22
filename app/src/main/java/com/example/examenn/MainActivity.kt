package com.example.examenn

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener  {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //usar los botones
        binding.btnMetroKilometro.setOnClickListener(this)
        binding.btnMetroCentimetro.setOnClickListener(this)
        binding.btnMetroMilimetro.setOnClickListener(this)
    }
// funciones
    fun metrosKilometros(metro: String): String{
        var conversion = (metro.toFloat() / 1000)
        return "Son: $conversion Kilómetros"
    }

    fun metrosCentimetros(metro: String): String{
        var conversion = (metro.toFloat() * 100)
        return "Son: $conversion Centimetros"
    }
    fun metrosMilimetros(metro: String): String{
        var conversion = (metro.toFloat() * 1000)
        return "Son: $conversion Milimetros"
    }

    override fun onClick(v: View?) {
        // se ejecuta cuando le de click a un elemento
        //
        when(v){
            binding.btnMetroKilometro -> {
                if (binding.valorMetros.text.toString().isNotEmpty()){
                   /*Toast.makeText(this,metrosKilometros(binding.valorMetros.text.toString()),
                        Toast.LENGTH_LONG
                    ).show()
                    */

                    // resultado como mensaje
                    binding.resultado.text =  metrosKilometros(binding.valorMetros.text.toString())
                } else{
                   /* Toast.makeText(
                        this,
                        "Ingresa un número válido",
                        Toast.LENGTH_LONG
                    ).show()

                    */
                    val mensaje= "Ingresa un número válido"
                    binding.resultado.text = mensaje

                }
            }

            binding.btnMetroCentimetro -> {
                if (binding.valorMetros.text.toString().isNotEmpty()){

                    //resultado como alerta
                    Toast.makeText(this,
                        metrosCentimetros(binding.valorMetros.text.toString()),
                        Toast.LENGTH_LONG
                    ).show()
                } else{
                    Toast.makeText(
                        this,
                        "Ingresa un número válido",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            binding.btnMetroMilimetro -> {
                if (binding.valorMetros.text.toString().isNotEmpty()){
                    Toast.makeText(
                        this,
                        metrosMilimetros(binding.valorMetros.text.toString()),
                        Toast.LENGTH_LONG
                    ).show()
                } else{
                    Toast.makeText(
                        this,
                        "Ingresa un número válido",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
    }
}