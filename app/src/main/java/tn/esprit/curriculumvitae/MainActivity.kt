package tn.esprit.curriculumvitae

import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var txtFullName: TextView? = null
    private var txtAge: TextView? = null
    private var txtEmail: TextView? = null

    private var rbHomme: RadioButton? = null
    private var rbFemme: RadioButton? = null

    private var seekBarAndroid: SeekBar? = null
    private var seekBarIos: SeekBar? = null
    private var seekBarFlutter: SeekBar? = null

    private var btnNext: Button? = null
    private var btnReset: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFullName = findViewById(R.id.txtFullName)
        txtAge = findViewById(R.id.txtAge)
        txtEmail = findViewById(R.id.txtEmail)

        rbHomme = findViewById(R.id.rbHomme)
        rbFemme = findViewById(R.id.rbFemme)

        seekBarAndroid = findViewById(R.id.seekBarAndroid)
        seekBarIos = findViewById(R.id.seekBarIos)
        seekBarFlutter = findViewById(R.id.seekBarFlutter)

        btnNext = findViewById(R.id.btnNext)
        btnReset = findViewById(R.id.btnReset)

        btnNext!!.setOnClickListener{
            clickNext()
        }

        btnReset!!.setOnClickListener{
            clickReset()
        }

    }

    private fun clickNext() {
        if(validate()){

            val skillAndroid = seekBarAndroid?.progress!!
            val skillIos = seekBarIos?.progress!!
            val skillFlutter = seekBarFlutter?.progress!!

            if(skillAndroid > 80 && skillIos > 80 && skillFlutter > 80){
                Toast.makeText(this, "Vous avez d'excellent skills !", Toast.LENGTH_SHORT).show()
            }else if (skillAndroid > skillIos && skillAndroid > skillFlutter && skillAndroid >80){
                Toast.makeText(this, "Vous êtes excellent en Android !", Toast.LENGTH_SHORT).show()
            }else if (skillIos > skillAndroid && skillIos > skillFlutter && skillIos >80){
                Toast.makeText(this, "Vous êtes excellent en iOS !", Toast.LENGTH_SHORT).show()
            }else if (skillFlutter > skillAndroid && skillFlutter > skillIos && skillFlutter >80){
                Toast.makeText(this, "Vous êtes excellent en Flutter !", Toast.LENGTH_SHORT).show()
            }else if(skillAndroid <= 30 && skillIos <= 30 && skillFlutter <= 30){
                Toast.makeText(this, "Vous devez travailler vos skills !", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Vous avez de bons skills !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validate(): Boolean {
        if (txtFullName?.text!!.isEmpty() || txtAge?.text!!.isEmpty() || txtEmail?.text!!.isEmpty()){
            Toast.makeText(this, "Check your input !", Toast.LENGTH_SHORT).show()
            return false
        }

        if(!rbHomme?.isChecked!! && !rbFemme?.isChecked!! ){
            Toast.makeText(this, "Choose your gender !", Toast.LENGTH_SHORT).show()
            return false
        }

        if(!EMAIL_ADDRESS.matcher(txtEmail?.text!!).matches()){
            Toast.makeText(this, "Check your email !", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun clickReset() {
        txtFullName?.text = ""
        txtAge?.text = ""
        txtEmail?.text = ""
        rbHomme?.isChecked = true
        rbFemme?.isChecked = false
        seekBarAndroid?.progress = 0
        seekBarIos?.progress = 0
        seekBarFlutter?.progress = 0
    }
}