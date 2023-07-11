package dev.scjoao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)

        btEnviar.setOnClickListener{
            if (etNome.text.isBlank()){
                etNome.error = "Digite o nome!"
            }else{
                tvResultado.text = etNome.text
            }
        }

        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)

        btAbrirNovaTela.setOnClickListener{
            val novaTelaIntent = Intent(this, ResultadoActivity::class.java)

            val nomeDigitado = etNome.text.toString()

            novaTelaIntent.putExtra("NOME_DIGITADO", nomeDigitado)

            startActivity(novaTelaIntent)
        }
    }
}