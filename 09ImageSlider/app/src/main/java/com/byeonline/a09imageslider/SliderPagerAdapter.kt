package com.byeonline.a09imageslider

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.fragment_slider.view.*

class SliderPagerAdapter : PagerAdapter {
    val context: Context
    val images: IntArray
    lateinit var inflator: LayoutInflater

    constructor(context: Context,images: IntArray): super() {
        this.context = context
        this.images = images
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return  images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val rv = inflator.inflate(R.layout.fragment_slider,container,false)
        rv.imageView.setImageResource(images[position])
        container.addView(rv)
        return rv
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }


}