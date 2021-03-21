package com.mansi.quizassignment.ui
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mansi.quizassignment.R
import com.mansi.quizassignment.databinding.FragmentUploadBinding
import com.mansi.quizassignment.models.ItemResponse
import com.mansi.quizassignment.utils.Utils

class UploadFragment : Fragment() {
    lateinit var timer: CountDownTimer
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentUploadBinding>(inflater, R.layout.fragment_upload,container,false)

        val safeArgs: UploadFragmentArgs by navArgs()
        val position = safeArgs.flowStepNumber
        val dataList = safeArgs.dataResponse

        binding.uploadText.text= dataList?.data?.get(position)?.let { HtmlCompat.fromHtml(it.text, HtmlCompat.FROM_HTML_MODE_COMPACT) }
        binding.questionType.text = dataList!!.data[position].questionType
        onClickListener(binding, dataList, position + 1)
        timer(binding, dataList, position + 1)
        start()

        return binding.root
    }

    private fun timer(binding: FragmentUploadBinding, dataList: ItemResponse?, flowStepNumber: Int) {
        timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerText.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                Utils.onClickListener(dataList, flowStepNumber)?.let { findNavController().navigate(it) }
            }
        }
    }

    private fun start(){ timer.start() }

    private fun cancel(){ timer.cancel() }

    private fun onClickListener(binding: FragmentUploadBinding, dataList: ItemResponse?, flowStepNumber: Int) {
        binding.nextButton.setOnClickListener { view: View ->
            cancel()
            Utils.onClickListener(dataList, flowStepNumber)?.let { findNavController().navigate(it) }

        }
    }

}