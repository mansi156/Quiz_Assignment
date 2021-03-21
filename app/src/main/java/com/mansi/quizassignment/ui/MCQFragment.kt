package com.mansi.quizassignment.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mansi.quizassignment.R
import com.mansi.quizassignment.databinding.FragmentMCQBinding
import com.mansi.quizassignment.models.ItemResponse
import com.mansi.quizassignment.utils.Utils


class MCQFragment : Fragment() {
    lateinit var timer: CountDownTimer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMCQBinding>(inflater, R.layout.fragment_m_c_q,container,false)
        val safeArgs: MCQFragmentArgs by navArgs()
        val position = safeArgs.flowStepNumber
        val dataList = safeArgs.dataResponse

        onClickListener(binding, dataList, position + 1)
        timer(binding, dataList, position + 1)
        start()

        binding.mcqText.text= dataList?.data?.get(position)?.let { HtmlCompat.fromHtml(it.text, HtmlCompat.FROM_HTML_MODE_COMPACT) }
        binding.questionType.text = dataList!!.data[position].questionType
        binding.nextButton.text = getString(R.string.finish)
        binding.option1.text = dataList.data[position].mcqoptionSet[0].value
        binding.option2.text = dataList.data[position].mcqoptionSet[1].value
        binding.option3.text = dataList.data[position].mcqoptionSet[2].value
        binding.option4.text = dataList.data[position].mcqoptionSet[3].value
        onClickListener(binding, dataList, position)
        timer(binding, dataList, position)
        start()

        return binding.root
    }

    private fun timer(binding: FragmentMCQBinding, dataList: ItemResponse?, flowStepNumber: Int) {
        timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerText.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                cancel()
                findNavController().navigate(R.id.action_MCQFragment_to_FInishFragment)
                 }
            }
        }

    private fun start(){ timer.start() }

    private fun cancel(){ timer.cancel() }

    private fun onClickListener(binding: FragmentMCQBinding, dataList: ItemResponse?, flowStepNumber: Int) {
        binding.nextButton.setOnClickListener { view: View ->
            cancel()
            Utils.onClickListener(dataList, flowStepNumber)?.let { binding.nextButton.findNavController().navigate(R.id.action_MCQFragment_to_FInishFragment) }

        }
    }
}
