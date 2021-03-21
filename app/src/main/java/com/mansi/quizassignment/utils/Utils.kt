package com.mansi.quizassignment.utils

import android.util.Log
import androidx.navigation.NavDirections
import com.mansi.quizassignment.models.ItemResponse
import com.mansi.quizassignment.ui.StartGameFragmentDirections

object Utils {
      fun onClickListener(dataList: ItemResponse?, flowStepNumber: Int) : NavDirections? {
        var action : NavDirections? = null
          Log.d("flowStepNumber", flowStepNumber.toString())
            if (dataList != null) {
                when (dataList.data[flowStepNumber].questionType) {
                    "FileUpload" -> {
                         action =
                            StartGameFragmentDirections.actionStartGameFragmentToUploadFragment(
                                flowStepNumber,
                                dataList
                            )
                    }
                    "Essay" -> {
                         action =
                            StartGameFragmentDirections.actionStartGameFragmentToEssayFragment(
                                flowStepNumber,
                                dataList
                            )

                    }
                    "MCQ" -> {
                         action =
                            StartGameFragmentDirections.actionStartGameFragmentToMCQFragment(
                                flowStepNumber,
                                dataList
                            )

                    }
                }

            }
        return action
    }

}