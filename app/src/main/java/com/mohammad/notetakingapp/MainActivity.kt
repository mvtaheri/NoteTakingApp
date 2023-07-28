package com.mohammad.notetakingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.mohammad.notetakingapp.database.NoteDatabase
import com.mohammad.notetakingapp.databinding.ActivityMainBinding
import com.mohammad.notetakingapp.repository.NoteRepository
import com.mohammad.notetakingapp.viewModel.NoteViewModel
import com.mohammad.notetakingapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
     lateinit var binding:ActivityMainBinding
     lateinit var noteViewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
       var toolbar:Toolbar
       toolbar=findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }
    private fun setUpViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory =NoteViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,viewModelProviderFactory)
                        .get(NoteViewModel::class.java)
    }
}