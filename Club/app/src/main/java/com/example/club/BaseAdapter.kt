package com.example.club

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.club.databinding.ItemCuotaBinding
import com.example.club.models.cuota
import com.example.club.models.cuotaPersona

 class BaseAdapter(private val context: Context, private val arrayList:java.util.ArrayList<cuotaPersona>)
     :BaseAdapter() {
    //private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
/*
        val binding= ItemCuotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var convertView=convertView
        convertView =binding.root

        binding.fecha1.text=arrayList[position].fechaVencimiento
        binding.estado1.text="$ "+"${arrayList[position].monto}"
        binding.Nombresocio.text="${arrayList[position].nombre}"+" "+"${arrayList[position].apellido}"
        binding.periodo.text= arrayList[position].periodo

       // val textViewCuota= convertView.findViewById<TextView>(R.id.periodo)
        val button = convertView.findViewById<Button>(R.id.btnPagar)
        val quota = getItem(position) as cuotaPersona

        button.setOnClickListener {
            val intent = Intent(context,SeleccionFomaPagoActivity::class.java).apply{
                putExtra("monto", quota.monto)
                putExtra("periodo", quota.periodo)
            }
            context.startActivity(intent)
        }
        return convertView*/

        val binding: ItemCuotaBinding
        val view: View

        if (convertView == null) {
            binding = ItemCuotaBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemCuotaBinding
            view = convertView
        }

        val quotaPersona = arrayList[position]

        binding.fecha1.text = quotaPersona.fechaVencimiento
        var estado = binding.estado1
        estado.text = "$ ${quotaPersona.monto}"

        var nombreSocio = binding.Nombresocio
        nombreSocio.text = "${quotaPersona.nombre} ${quotaPersona.apellido}"
        nombreSocio.layoutParams.width = 400

        binding.periodo.text = quotaPersona.periodo

        val button = binding.btnPagar
        button.layoutParams.height = 38

        button.isEnabled = quotaPersona.medioPago==null

        button.setOnClickListener {
            if (button.isEnabled) {
                val intent = Intent(context, SeleccionFomaPagoActivity::class.java).apply {
                    putExtra("idCuota", quotaPersona.idCuota)
                    putExtra("monto", quotaPersona.monto)
                    putExtra("periodo", quotaPersona.periodo)
                }
                context.startActivity(intent)
            }
        }

        return view

    }
}