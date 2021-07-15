package com.example.myflexiblefragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class OptionDialogFragment : DialogFragment(), View.OnClickListener {
     private lateinit var btnChoose : Button
     private lateinit var btnClose : Button
     private lateinit var rgOptions : RadioGroup
     private lateinit var rbSaf : RadioButton
     private lateinit var rbMou : RadioButton
     private lateinit var rbLvg : RadioButton
     private lateinit var rbMoyes : RadioButton
     private var optionDialogListener : OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbSaf = view.findViewById(R.id.rb_saf)
        rbLvg = view.findViewById(R.id.rb_lvg)
        rbMou = view.findViewById(R.id.rb_mou)
        rbMoyes = view.findViewById(R.id.rb_moyes)

        btnClose.setOnClickListener(this)
        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_choose -> {
                val checkedOptions = rgOptions.checkedRadioButtonId
                if(checkedOptions != -1){
                    var choach : String? = null
                    when(checkedOptions){
                        R.id.rb_moyes -> choach = rbMoyes.text.toString().trim()
                        R.id.rb_mou -> choach = rbMou.text.toString().trim()
                        R.id.rb_lvg -> choach = rbLvg.text.toString().trim()
                        R.id.rb_saf -> choach = rbLvg.text.toString().trim()
                    }
                    this.optionDialogListener?.onOptionChoosen(choach)
                    dialog?.dismiss()
                }
            }
            R.id.btn_close -> {
                dialog?.cancel()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if(fragment is DetailCategoryFragment){
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChoosen(text: String?)
    }
}


