package com.dicoding.submissonandroidbeginner

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.submissonandroidbeginner.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvRate: TextView
    private lateinit var tvDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            imgPhoto = imgItemPhoto
            tvName = tvItemName
            tvDescription = tvItemDescription
            tvRate = tvItemRate
        }


        val dataDetail = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_NAME, Player::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_NAME)
        }

        Log.d(tag, "onCreate")

        tvName.text = dataDetail?.name

        if (dataDetail != null) {
            Glide
                .with(this)
                .load(dataDetail.photo)
                .centerCrop()
                .into(imgPhoto)
        }

        tvDescription.text = dataDetail?.description

        tvRate.text = dataDetail?.rate
        supportActionBar?.title = dataDetail?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    companion object {
        const val EXTRA_NAME = "extra_name"

        const val tag = "Detail Activity"
    }

}

