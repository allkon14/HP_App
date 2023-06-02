package hogwarts.info.presentation.spells

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hogwarts.info.R
import hogwarts.info.data.model.Spell

class SpellAdapter(private val spells: List<Spell>) :
    RecyclerView.Adapter<SpellAdapter.SpellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spell, parent, false)
        return SpellViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        val spell = spells[position]
        holder.bind(spell)
    }

    override fun getItemCount(): Int {
        return spells.size
    }

    inner class SpellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val spellName: TextView = itemView.findViewById(R.id.spell_name)
        private val spellDescription: TextView = itemView.findViewById(R.id.spell_description)

        fun bind(spell: Spell) {
            spellName.text = spell.name
            spellDescription.text = spell.description
        }
    }
}
