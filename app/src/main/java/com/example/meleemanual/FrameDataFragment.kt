package com.example.meleemanual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class FrameDataFragment : Fragment() {

    private lateinit var listView : ListView
    private lateinit var arrCharacter: ArrayList<MeleeCharacter>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_frame_data, container, false)

        listView = view.findViewById(R.id.listView)
        arrCharacter = ArrayList()
        arrCharacter.add(MeleeCharacter("Bowser", R.drawable.bowser))
        arrCharacter.add(MeleeCharacter("Captain Falcon", R.drawable.captainfalcon))
        arrCharacter.add(MeleeCharacter("Donkey Kong", R.drawable.donkeykong))
        arrCharacter.add(MeleeCharacter("Dr. Mario", R.drawable.drmario))
        arrCharacter.add(MeleeCharacter("Falco", R.drawable.falco))
        arrCharacter.add(MeleeCharacter("Fox", R.drawable.fox))
        arrCharacter.add(MeleeCharacter("Ganondorf", R.drawable.ganondorf))
        arrCharacter.add(MeleeCharacter("Ice Climbers", R.drawable.iceclimbers))
        arrCharacter.add(MeleeCharacter("Jigglypuff", R.drawable.jigglypuff))
        arrCharacter.add(MeleeCharacter("Kirby", R.drawable.kirby))
        arrCharacter.add(MeleeCharacter("Link", R.drawable.link))
        arrCharacter.add(MeleeCharacter("Luigi", R.drawable.luigi))
        arrCharacter.add(MeleeCharacter("Mario", R.drawable.mario))
        arrCharacter.add(MeleeCharacter("Marth", R.drawable.marth))
        arrCharacter.add(MeleeCharacter("Mewtwo", R.drawable.mewtwo))
        arrCharacter.add(MeleeCharacter("Mr. Game & Watch", R.drawable.mrgameandwatch))
        arrCharacter.add(MeleeCharacter("Ness", R.drawable.ness))
        arrCharacter.add(MeleeCharacter("Peach", R.drawable.peach))
        arrCharacter.add(MeleeCharacter("Pichu", R.drawable.pichu))
        arrCharacter.add(MeleeCharacter("Pikachu", R.drawable.pikachu))
        arrCharacter.add(MeleeCharacter("Roy", R.drawable.roy))
        arrCharacter.add(MeleeCharacter("Samus", R.drawable.samus))
        arrCharacter.add(MeleeCharacter("Yoshi", R.drawable.yoshi))
        arrCharacter.add(MeleeCharacter("Young Link", R.drawable.younglink))
        arrCharacter.add(MeleeCharacter("Zelda & Sheik", R.drawable.zeldasheik))

        listView.adapter = CustomAdapter(requireActivity().application, arrCharacter)
        return view
    }

}