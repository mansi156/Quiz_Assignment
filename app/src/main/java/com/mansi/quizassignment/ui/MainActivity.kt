package com.mansi.quizassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import com.mansi.quizassignment.R
import com.mansi.quizassignment.databinding.ActivityMainBinding
import com.mansi.quizassignment.models.ItemResponse
import com.mansi.quizassignment.utils.Constants


class MainActivity : AppCompatActivity() {

   // internal val headlinesFragmentSharedViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val objectArrayString: String = resources.openRawResource(R.raw.demojson).bufferedReader().use { it.readText() }
        val objectArray = Gson().fromJson(objectArrayString, ItemResponse::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bundle = Bundle()
        bundle.putParcelable(Constants.DATA_LIST,objectArray)
        navController.setGraph(navController.graph,bundle)

      //  navController.




//        headlinesFragmentSharedViewModel.email.observe(this, {
//            when (objectArray.data[it].questionType){
//                "FileUpload" -> ,
//                "Essay" -> "" ,
//                "MCQ" -> ""
//            }
//
//        }


//        <action
//        android:id="@+id/action_startGameFragment_to_MCQFragment"
//        app:destination="@id/MCQFragment"
//        app:enterAnim="@anim/fragment_open_enter"
//        app:exitAnim="@anim/fragment_open_exit" />
//                view.findViewById<Button>(R.id.play_btn).setOnClickListener {
//            view.findNavController().navigate(R.id.action_title_screen_to_in_game)
        }




    }

