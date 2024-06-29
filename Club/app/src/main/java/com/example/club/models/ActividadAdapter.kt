package com.example.club.models
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.club.PagoNoSocioActivity
import com.example.club.R
import com.example.club.models.Actividad

class ActividadAdapter(private val actividades: MutableList<Actividad>) :
    RecyclerView.Adapter<ActividadAdapter.ActividadViewHolder>() {

    // ViewHolder para los elementos de la lista
    class ActividadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewActividad: ImageView = view.findViewById(R.id.imageViewActividad)
        val textViewNombreActividad: TextView = view.findViewById(R.id.textViewNombreActividad)
        val textViewCostoActividad: TextView = view.findViewById(R.id.textViewCostoActividad)
        val btnSeleccionar: Button = view.findViewById(R.id.btnSeleccionar)
    }

    // Infla el layout para cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actividad, parent, false)
        return ActividadViewHolder(view)
    }

    // Vincula los datos a los elementos de la vista
    override fun onBindViewHolder(holder: ActividadViewHolder, position: Int) {
        val actividad = actividades[position]
        holder.textViewNombreActividad.text = actividad.nombre
        holder.textViewCostoActividad.text = actividad.costo.toString()
        // Aquí podrías manejar la imagen de la actividad si tienes distintas
        holder.imageViewActividad.setImageResource(R.mipmap.icon_actividad)

        holder.btnSeleccionar.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PagoNoSocioActivity::class.java)
            context.startActivity(intent)
        }
    }

    // Retorna el tamaño de la lista de actividades
    override fun getItemCount(): Int {
        return actividades.size
    }
}