package com.mansi.quizassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mansi.quizassignment.R
import com.mansi.quizassignment.databinding.FragmentStartGameBinding
import com.mansi.quizassignment.models.ItemResponse
import com.mansi.quizassignment.utils.Constants
import com.mansi.quizassignment.utils.Utils


class StartGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      val binding = DataBindingUtil.inflate<FragmentStartGameBinding>(inflater, R.layout.fragment_start_game,container,false)

        val dataList = arguments?.getParcelable<ItemResponse>(Constants.DATA_LIST)

        val safeArgs: StartGameFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber
        onClickListener(binding, dataList, flowStepNumber)
        return binding.root
    }

    private fun onClickListener(binding: FragmentStartGameBinding, dataList: ItemResponse?, flowStepNumber: Int) {
        binding.startButton.setOnClickListener { view: View ->
            Utils.onClickListener(dataList, flowStepNumber)?.let {
                findNavController().navigate(it) }

        }
    }

}