package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.okhttp.Dispatcher
import kotlin.coroutines.CoroutineContext

lateinit var mRecyclerView : RecyclerView
val mAdapter : RecyclerAdapter = RecyclerAdapter()

var db = FirebaseFirestore.getInstance()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rvSuperheroList) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter
    }

    /*
    fun getSuperheros(): MutableList<Superhero>{
    var superheros:MutableList<Superhero> = ArrayList()
    var sh:String;var ed:String;var rn:String;var im:String;
    db.collection("SuperHeroes")
    .get()
    .addOnSuccessListener { result ->
    for (document in result) {
    sh=document.data["superheroe"] as String
    ed=document.data["Editorial"] as String
    rn=document.data["RealName"] as String
    im=document.data["imagen"] as String
    }}
    return superheros
    }
    */

    fun getSuperheros(): MutableList<Superhero>{
        var superheros:MutableList<Superhero> = ArrayList()
        superheros.add(Superhero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(Superhero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(Superhero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(Superhero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(Superhero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(Superhero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(Superhero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(Superhero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))
        return superheros
   }

}


