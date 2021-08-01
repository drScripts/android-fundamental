package com.example.mysubmission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PersonLinearAdapter(private val context : Context,private val listPerson : ArrayList<PersonModel>) :
    RecyclerView.Adapter<PersonLinearAdapter.PersonViewHolder>()  {

    class PersonViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        var personImage : ImageView = item.findViewById(R.id.person_img)
        var personName : TextView = item.findViewById(R.id.person_name)
        var personLocation : TextView = item.findViewById(R.id.person_location)
        var personCompany : TextView = item.findViewById(R.id.person_company)
        var personUsername : TextView = item.findViewById(R.id.person_username)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_person,parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        Glide.with(context)
            .load(listPerson[position].image)
            .apply(RequestOptions().override(100,100))
            .into(holder.personImage)
        holder.personName.text = listPerson[position].name
        holder.personUsername.text = listPerson[position].username
        holder.personCompany.text = listPerson[position].company
        holder.personLocation.text = listPerson[position].location
        holder.itemView.setOnClickListener {
            val detailIntent = Intent(context,PersonDetail::class.java)
            detailIntent.putExtra(PersonDetail.EXTRA_PERSON,listPerson[position])
            context.startActivity(detailIntent)
        }
    }

    override fun getItemCount(): Int = listPerson.size
}









