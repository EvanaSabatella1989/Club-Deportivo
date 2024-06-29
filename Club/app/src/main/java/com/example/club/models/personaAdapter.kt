package com.example.club.models
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.club.R

class personaAdapter (
    private val personas: List<persona>,
    private val onClick: (persona) -> Unit // Lambda para manejar clics
    ) : RecyclerView.Adapter<personaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return personaViewHolder(view)
    }

    override fun onBindViewHolder(holder: personaViewHolder, position: Int) {
        val persona = personas[position]
        holder.nombreApellidoTextView.text = "${persona.nombre} ${persona.apellido}"
        holder.estadoTextView.text = if (persona.isSocio) "Socio" else "No Socio"
        holder.iconoImageView.setImageResource(
            if (persona.isSocio) R.mipmap.icono_persona_socio else R.mipmap.icono_persona
        )
        // Configura el click listener
        holder.itemView.setOnClickListener {
            onClick(persona)
        }
    }

    override fun getItemCount() = personas.size
}