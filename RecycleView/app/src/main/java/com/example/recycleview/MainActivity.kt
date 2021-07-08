package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private var list:ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.heroes_tc)
        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroData.dataList)
        showresyclerList()
    }

    private fun showresyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }

    private fun showRecyclerCard(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardHeroAdapter(list)
        rvHeroes.adapter = cardHeroAdapter
    }

    private fun showRecyclerGrid(){
        // implement Grid Layout Manager
        rvHeroes.layoutManager = GridLayoutManager(this,2)
        // Get Grid Adapter
        val gridHeroAdapter = GridHeroAdapter(list)
        // Set Grid Adapter
        rvHeroes.adapter = gridHeroAdapter
    }

    // create options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(id : Int){
        when(id){
            R.id.action_list -> {
                showresyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                showRecyclerCard()
            }
        }
    }
}




