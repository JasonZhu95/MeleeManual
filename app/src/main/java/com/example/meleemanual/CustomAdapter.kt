package com.example.meleemanual

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var character: ArrayList<MeleeCharacter>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var txtName: TextView
        var charImage: ImageView

        init {
            this.txtName = row?.findViewById(R.id.charName) as TextView
            this.charImage = row?.findViewById(R.id.meleeChar) as ImageView
        }
    }

    override fun getCount(): Int {
        return character.count()
    }

    override fun getItem(p0: Int): Any {
        return character.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (p1 == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.melee_character_list, p2, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = p1
            viewHolder = view.tag as ViewHolder
        }

        var character: MeleeCharacter = getItem(p0) as MeleeCharacter
        viewHolder.txtName.text = character.name
        viewHolder.charImage.setImageResource(character.image)
        return view as View
    }
}