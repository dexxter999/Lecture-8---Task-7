package com.example.fieldapplication

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fieldapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonAddField.setOnClickListener {
            if (binding.checkboxField.isChecked) {
                addEditTextWithNumber()
                clearText()
            } else {
                addEditTextWithText()
                clearText()
            }
        }

    }


    private fun addEditTextWithText() {
        val editText = EditText(this)
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            100
        ).also { it.setMargins(20, 20, 20, 0) }
        editText.setBackgroundResource(R.drawable.custom_edit_text)
        if (binding.etFieldName.text.isEmpty()) {
            Toast.makeText(this, "Fill the Field Name please!", Toast.LENGTH_SHORT).show()
        } else {
            editText.hint = binding.etFieldName.text
            editText.setHintTextColor(Color.WHITE)
            binding.etFields.addView(editText)
        }

    }


    private fun addEditTextWithNumber() {
        val editTextNumber = EditText(this)
        editTextNumber.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            100
        ).also { it.setMargins(20, 20, 20, 0) }
        editTextNumber.setBackgroundResource(R.drawable.custom_edit_text)
        if (binding.etFieldName.text.isEmpty()) {
            Toast.makeText(this, "Fill the Field Name please!", Toast.LENGTH_SHORT).show()
        } else {
            editTextNumber.inputType = InputType.TYPE_CLASS_NUMBER
            editTextNumber.hint = binding.etFieldName.text
            editTextNumber.setHintTextColor(Color.WHITE)
            binding.etFields.addView(editTextNumber)
        }
    }

    private fun clearText() {
        binding.etFieldName.text.clear()
    }
}