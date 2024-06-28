package com.example.club.models
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.club.R

class personaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nombreApellidoTextView: TextView = itemView.findViewById(R.id.text_nombre_usuario)
    val estadoTextView: TextView = itemView.findViewById(R.id.text_estado_usuario)
    val iconoImageView: ImageView = itemView.findViewById(R.id.icon_usuario)
}