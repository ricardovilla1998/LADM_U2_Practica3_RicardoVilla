package mx.edu.ittepic.ladm_u2_practica3_ricardovilla

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dados = arrayOf(R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6)
    var valorObtenido = 0
    var turno = 1
    var turno2 = 1
    var vuelta = 1
    var vuelta2 = 1
    // var dados2 = Array<FiguraGeometrica>(6) {FiguraGeometrica(BitmapFactory.decodeResource(resources, R.drawable.d1),200,500)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_comenzar.setOnClickListener {
            reinicia()
            btn_comenzar.isEnabled = false
            while (vuelta2 < 5) {

                while (turno2 < 5) {
                    var hiloAsincrono = HiloAsincrono(this)
                    hiloAsincrono.execute(turno2, turno2, turno2)

                    turno2++

                }
                vuelta2++

                turno2 = 1


            }










        }





    }

    fun tirarDados(){

        var d1 = (0..5).random()
        var d2 = (0..5).random()
        imageD1.setImageResource(dados[d1])
        imageD2.setImageResource(dados[d2])
        valorObtenido = (d1 + d2) +2

    }
    
    fun muestraGanador(){
        txtEstado1.setText("PERDISTE")
        txtEstado2.setText("PERDISTE")
        txtEstado3.setText("PERDISTE")
        txtEstado4.setText("PERDISTE")
        var puntos1 = txtPuntos1.text.toString().toInt()
        var puntos2 = txtPuntos2.text.toString().toInt()
        var puntos3 = txtPuntos3.text.toString().toInt()
        var puntos4 = txtPuntos4.text.toString().toInt()

        var arreglo = ArrayList<Int>()

        arreglo.add(puntos1)
        arreglo.add(puntos2)
        arreglo.add(puntos3)
        arreglo.add(puntos4)

        if(arreglo[0]==arreglo.max()){
            txtEstado1.setText("¡GANADOR!")
        }
        if(arreglo[1]==arreglo.max()){
            txtEstado2.setText("¡GANADOR!")
        }

        if(arreglo[2]==arreglo.max()){
            txtEstado3.setText("¡GANADOR!")
        }

        if(arreglo[3]==arreglo.max()){
            txtEstado4.setText("¡GANADOR!")
        }
    }

    fun reinicia(){
        turno = 1
        turno2 = 1
        vuelta = 1
        vuelta2 = 1
        txtPuntos1.setText("0")
        txtPuntos2.setText("0")
        txtPuntos3.setText("0")
        txtPuntos4.setText("0")
        txtEstado1.setText("ESPERANDO...")
        txtEstado2.setText("ESPERANDO...")
        txtEstado3.setText("ESPERANDO...")
        txtEstado4.setText("ESPERANDO...")
        btn_comenzar.isEnabled = true
    }






}
