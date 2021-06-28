//package com.example.sentia2.utils
//
//import androidx.annotation.DrawableRes
//
//import android.graphics.Bitmap
//import android.graphics.drawable.Drawable
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.target.CustomTarget
//import com.bumptech.glide.request.transition.Transition
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//const val DEFAULT_PROPERTY_IMAGE = R.drawable.ic_baseline_home_work_24
//const val DEFAULT_AGENT_IMAGE = R.drawable.ic_outline_face_24
//
//@ExperimentalCoroutinesApi
//fun loadPicture(
//    url: String,
//    @DrawableRes defaultImage: Int
//): Bitmap? {
//
//
////  Get the network image from URL
//    Glide.with(LocalContext.current)
//        .asBitmap()
//        .load(url)
//        .placeholder(defaultImage)
//        .into(object: CustomTarget<Bitmap>(){
//
//            override fun onLoadCleared(placeholder: Drawable?){}
//
//            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                bitmapState.value = resource
//            }
//        })
//
//    return bitmapState
//}
//
//
//@ExperimentalCoroutinesApi
//fun loadAgentPicture(
//    url: String,
//    @DrawableRes defaultImage: Int
//): MutableState<Bitmap?> {
//
//    val bitmapState: MutableState<Bitmap?> = remember {mutableStateOf(value = null)}
//
////  Get the network image from URL
//    Glide.with(LocalContext.current)
//        .asBitmap()
//        .load(url)
//        .placeholder(defaultImage)
//        .override(200,200)
//        .thumbnail(0.25f)
//        .into(object: CustomTarget<Bitmap>(){
//            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                bitmapState.value = resource
//            }
//            override fun onLoadCleared(placeholder: Drawable?) {
//            }
//        })
//
//    return bitmapState
//}
//
////fun loadImages(
////    url: String,
////    @DrawableRes defaultImage: Int
////){
////
////}