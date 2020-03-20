package mx.edu.ittepic.ladm_u2_practica3_ricardovilla

import android.os.AsyncTask
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//PARAMS : TIPO DE PARAMETROS
//PROGRESS : MENSAJE DE LO QUE HARÁ POR MIENTRAS EL HILO
//RESULTADO : RESULTADO AL FINALIZAR EL HILO
class HiloAsincrono (p:MainActivity) : AsyncTask<Int,String,Int>(){

    var puntero = p

    override fun onPreExecute() {
        super.onPreExecute()
        //puntero.tirarDados()



    }

    override fun doInBackground(vararg params: Int?): Int {




        publishProgress(params[0].toString())

        return params[0]!!

    }

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)

        if(values[0].toString()=="1"){
            puntero.txtEstado1.setText("JUGANDO")
            puntero.txtEstado2.setText("ESPERANDO...")
            puntero.txtEstado3.setText("ESPERANDO...")
            puntero.txtEstado4.setText("ESPERANDO...")

        }
        if(values[0].toString()=="2"){
            puntero.txtEstado2.setText("JUGANDO")
            puntero.txtEstado1.setText("ESPERANDO...")
            puntero.txtEstado3.setText("ESPERANDO...")
            puntero.txtEstado4.setText("ESPERANDO...")
        }
        if(values[0].toString()=="3"){
            puntero.txtEstado3.setText("JUGANDO")
            puntero.txtEstado1.setText("ESPERANDO...")
            puntero.txtEstado2.setText("ESPERANDO...")
            puntero.txtEstado4.setText("ESPERANDO...")
        }
        if(values[0].toString()=="4"){
            puntero.txtEstado4.setText("JUGANDO")
            puntero.txtEstado1.setText("ESPERANDO...")
            puntero.txtEstado2.setText("ESPERANDO...")
            puntero.txtEstado3.setText("ESPERANDO...")
        }




    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        if(result==1){
            puntero.tirarDados()
            puntero.txtPuntos1.setText((puntero.txtPuntos1.text.toString().toInt() + puntero.valorObtenido).toString())
            puntero.setTitle("JUEGO: "+(puntero.vuelta++))




        }
        if(result==2){
            puntero.tirarDados()
            puntero.txtPuntos2.setText((puntero.txtPuntos2.text.toString().toInt() + puntero.valorObtenido).toString())

        }
        if(result==3){
            puntero.tirarDados()
            puntero.txtPuntos3.setText((puntero.txtPuntos3.text.toString().toInt() + puntero.valorObtenido).toString())

        }

        if(result==4){
            puntero.tirarDados()
            puntero.txtPuntos4.setText((puntero.txtPuntos4.text.toString().toInt() + puntero.valorObtenido).toString())
            if(puntero.vuelta > 4){
                puntero.muestraGanador()
                puntero.btn_comenzar.isEnabled = true
            }


        }

        Thread.sleep(2000)


    }

    override fun onCancelled() {

        super.onCancelled()



    }
}