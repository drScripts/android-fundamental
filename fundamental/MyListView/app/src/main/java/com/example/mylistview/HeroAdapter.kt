package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context, private val heroes : ArrayList<HeroModel>) : BaseAdapter(){
    override fun getCount(): Int = heroes.size

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as HeroModel
        viewHolder.bind(hero)
        itemView.setOnClickListener {
            Toast.makeText(context,hero.name,Toast.LENGTH_SHORT).show()
        }
        return itemView
    }

    private inner class ViewHolder internal  constructor(view : View) {
        private val textName : TextView = view.findViewById(R.id.tv_hero_name)
        private val textDescription : TextView = view.findViewById(R.id.tv_hero_desc)
        private val heroImage : CircleImageView = view.findViewById(R.id.iv_hero)

        internal fun bind(hero : HeroModel){
            textName.text = hero.name
            textDescription.text = hero.description
            heroImage.setImageResource(hero.image)
        }
    }
}
