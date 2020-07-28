package br.com.souzabrunoj.architecturesample.widget

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.souzabrunoj.architecturesample.R
import br.com.souzabrunoj.domain.commom.Helper.EMPTY_STRING

open class TextInput @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    protected val inputTextLabelField: TextView by lazy { findViewById<TextView>(R.id.tv_text_input_label) }
    protected val inputTextField: EditText by lazy { findViewById<EditText>(R.id.ed_text_input) }
    protected val inputTextErrorField: TextView by lazy { findViewById<TextView>(R.id.tv_message_error) }

    init {
        setupViews(attrs)
    }

    private fun setupViews(attrs: AttributeSet?) {
        inflate(context, R.layout.widget_text_input, this)
        attrs?.apply {
            with(context.obtainStyledAttributes(this, R.styleable.TextInput)) {
                text = getString(R.styleable.TextInput_android_text) ?: EMPTY_STRING
                label = getString(R.styleable.TextInput_label) ?: EMPTY_STRING
                errorMessage = getString(R.styleable.TextInput_error_message) ?: EMPTY_STRING
                inputType = getInt(R.styleable.TextInput_android_inputType, InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
                recycle()
            }
        }
    }

    var text: String = EMPTY_STRING
        get() = inputTextField.text.toString()
        set(value) {
            inputTextField.setText(value)
            field = value
        }

    var label: String = EMPTY_STRING
        set(value) {
            inputTextLabelField.text = value
            field = value
        }

    var errorMessage: String? = null
        set(value) {
            value?.let {
                inputTextErrorField.text = it
            }
            field = value
        }

    var inputType: Int = 0
        set(value) {
            inputTextField.inputType = value
            inputTextField.typeface = Typeface.DEFAULT
            field = value
        }

    fun showError() {
        inputTextErrorField.visibility = View.VISIBLE
    }

    fun clearError() {
        inputTextErrorField.visibility = View.GONE
    }
}