package com.kotlin.mvvm.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kotlin.helper.base.BaseViewModel
import com.kotlin.helper.ext.toStartActivity
import com.kotlin.mvvm.R
import com.kotlin.mvvm.app.base.BaseActivity
import com.kotlin.mvvm.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>() {

    //语速 范围：0.1~~1.5
    private var voiceSpeed: Float = 0.3f

    //音调 范围：0.1~~2.0
    private var voicePitch: Float = 1.0f

    //语音播报
//    private var mSpeech: TextToSpeech? = null

    private val countDownTimer: CountDownTimer by lazy {
        object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                jumpToMainActivity()
            }

            override fun onTick(t: Long) {
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(Color.parseColor("#F4F4F4"))
            .error(R.drawable.load_error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(applicationContext)
            .load("https://ae01.alicdn.com/kf/U6de089ce45ff468a8f06c50e19ad7379N.jpg")
            .apply(options)
            .into(mDataBind.splashImage)
        countDownTimer.start()
//        val isFirst = mmkv.getBoolean(ValueKey.isFirst,true)
//        mmkv.putBoolean(ValueKey.isFirst,false)
        //判断是否是第一次请求
//        if(isFirst){
//
//        }else{
//
//        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mSpeech = TextToSpeech(this@SplashActivity, TTSListener())
//    }
//
//    inner class TTSListener : TextToSpeech.OnInitListener {
//        override fun onInit(status: Int) {
//            if (status == TextToSpeech.SUCCESS) {
//                Log.i("SplashActivity", "onInit: TTS引擎初始化成功")
//
//            } else {
//                Log.i("SplashActivity", "onInit: TTS引擎初始化失败")
//            }
//        }
//    }
//
//    private fun play() {
//        val supported = mSpeech?.setLanguage(Locale.CHINESE)
//        mSpeech?.setSpeechRate(voiceSpeed)
//        mSpeech?.setPitch(voicePitch)
//        if ((supported != TextToSpeech.LANG_AVAILABLE) && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
//            Log.i("SplashActivity", "中文设置失败")
//        } else {
//            Log.i("SplashActivity", "中文设置成功")
//            mSpeech?.speak("欢迎回归！", TextToSpeech.QUEUE_FLUSH, null)
//        }
//    }

    private fun jumpToMainActivity() {
        toStartActivity(MainActivity::class.java)
        finish()
    }

    override fun onDestroy() {
//        if (mSpeech != null) {
//            mSpeech!!.stop()
//            mSpeech!!.shutdown()
//            mSpeech = null
//        }
        countDownTimer.cancel()
        super.onDestroy()
    }

    override fun showToolBar() = false
}