package hogwarts.info.presentation.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hogwarts.info.R
import hogwarts.info.data.model.Character

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }


    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        private val characterName: TextView = itemView.findViewById(R.id.character_name)
        private val wandCore: TextView = itemView.findViewById(R.id.wand_core)
        private val wandLength: TextView = itemView.findViewById(R.id.wand_length)
        private val wandWood: TextView = itemView.findViewById(R.id.wand_wood)

        fun bind(character: Character) {
            Glide.with(itemView).load(character.image).placeholder(R.drawable.character_empty_image).into(characterImage)
            characterName.text = character.name
            wandCore.text = character.wand.core
            wandLength.text = character.wand.length.toString()
            wandWood.text = character.wand.wood
        }
    }
}
