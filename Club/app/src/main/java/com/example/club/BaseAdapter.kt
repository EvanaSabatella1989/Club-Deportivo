package com.example.club

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

        val binding= ItemCuotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var convertView=convertView
        convertView =binding.root

        binding.fecha1.text=arrayList[position].fechaVencimiento
        binding.estado1.text=arrayList[position].monto.toString()
        binding.Nombresocio.text="${arrayList[position].nombre}"+" "+"${arrayList[position].apellido}"

        return convertView
    }
}