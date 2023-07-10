package com.jetpack.hellowork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //llammanos a la funcion app
            app()
        }
    }
}

@Preview
@Composable
fun app() {

    //estamos diciendo que se crea un estado de tipo entero
    // y que lo recuerde (remember) sino se borraria y se crea en 0
    //rememberSaveable no deja destruir la actividad cuando hay rotacion
    var counter by rememberSaveable { mutableStateOf(0) }


    /*
    *Column hace que se coloquen los componentes uno debajo del otro
    * Tambien podemos agregar modifier a las columnas
    */
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp)
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.icon_fav),
                    contentDescription = "Favorito",
                    modifier = Modifier.clickable {counter++}
                )

                Text(text = counter.toString(), color = Color.White, modifier = Modifier.padding(start = 4.dp))
            }
            Text(
                text = "JETPACK",//texto
                fontSize = 20.sp,//tamaño
                color = Color.White,//color
                modifier = Modifier.fillMaxWidth(),//ocupar maximo ancho
                textAlign = TextAlign.Center//centrar texto
            )
            Text(text = "Hola")
            Text(text = "aprendiendo")
            Text(text = "Compose")


        }
    }

}




