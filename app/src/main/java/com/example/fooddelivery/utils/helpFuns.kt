package com.example.fooddelivery.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fooddelivery.R
import com.example.fooddelivery.domain.models.retrofit.Description
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

fun showToast(text: String) {
    Toast.makeText(APP_ACTIVITY_MAIN, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(context: Context, activity: AppCompatActivity) {
    val intent = Intent(context, activity::class.java)
    startActivity(intent)
    //overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    this.finish()
}

fun showSnackBar(view: View, title: String, color: Int) {
    val snack = Snackbar.make(view, title, Snackbar.LENGTH_SHORT)
        .setTextColor(Color.WHITE)
        .setBackgroundTint(APP_ACTIVITY_MAIN.getColor(color))
        .setActionTextColor(APP_ACTIVITY_MAIN.getColor(R.color.white))
    snack.setAction(APP_ACTIVITY_MAIN.getString(R.string.cancel)) {
        snack.dismiss()
    }
    snack.show()

}

fun CircleImageView.downloadIcon(path: String) {
    Picasso.get().load(path)
        .placeholder(R.drawable.ic_no_image)
        .error(R.drawable.ic_no_image)
        .into(this)
}

fun joinIngredientsInOne(model: Description): String {
    var ingredients = ""
    if(model.strIngredient1 != ""){
        ingredients = ingredients + model.strIngredient1 + ", "
    }
    if(model.strIngredient2 != ""){
        ingredients = ingredients + ", " + model.strIngredient2
    }
    if(model.strIngredient3 != ""){
        ingredients = ingredients + ", " + model.strIngredient3
    }
    if(model.strIngredient4 != ""){
        ingredients = ingredients + ", " + model.strIngredient4
    }
    if(model.strIngredient5 != ""){
        ingredients = ingredients + ", " + model.strIngredient5
    }
    if(model.strIngredient6 != ""){
        ingredients = ingredients + ", " + model.strIngredient6
    }
    if(model.strIngredient7 != ""){
        ingredients = ingredients + ", " + model.strIngredient7
    }
    if(model.strIngredient8 != ""){
        ingredients = ingredients + ", " + model.strIngredient8
    }
    if(model.strIngredient9 != ""){
        ingredients = ingredients + ", " + model.strIngredient9
    }
    if(model.strIngredient10 != ""){
        ingredients = ingredients + ", " + model.strIngredient10
    }
    if(model.strIngredient11 != ""){
        ingredients = ingredients + ", " + model.strIngredient11
    }
    if(model.strIngredient12 != ""){
        ingredients = ingredients + ", " + model.strIngredient12
    }
    if(model.strIngredient13 != ""){
        ingredients = ingredients + ", " + model.strIngredient13
    }
    if(model.strIngredient14 != ""){
        ingredients = ingredients + ", " + model.strIngredient14
    }
    if(model.strIngredient15 != ""){
        ingredients = ingredients + ", " + model.strIngredient15
    }
    if(model.strIngredient16 != ""){
        ingredients = ingredients + ", " + model.strIngredient16
    }
    if(model.strIngredient17 != ""){
        ingredients = ingredients + ", " + model.strIngredient17
    }
    if(model.strIngredient18 != ""){
        ingredients = ingredients + ", " + model.strIngredient18
    }
    if(model.strIngredient19 != ""){
        ingredients = ingredients + ", " + model.strIngredient19
    }
    if(model.strIngredient20 != ""){
        ingredients = ingredients + ", " + model.strIngredient20
    }
    return ingredients
}