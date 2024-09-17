package activities

import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt

class Hero(name: String, characterStats: CharacterStats) : Character(name, characterStats), CharacterInterface {

    override fun attack(target: Character) {
        target.damageQueued = Random.nextInt(1..40)
        println("$name Attacked ${target.name} for ${target.damageQueued}!")
    }

    override fun defend() {
        val supposedDefense = characterStats.def
        defenseQueued = supposedDefense
    }

    override fun heal() {
        val amount = Random.nextInt(20)
        characterStats.hp += amount
        println("$name Healed $amount")
    }

    override fun receiveDamage() {
        val supposedDamage = damageQueued - defenseQueued
        val limitedDamage = max(0, supposedDamage)
        damageQueued = limitedDamage

        val newHp = characterStats.hp - damageQueued
        val limitedHp = max(0, newHp)
        characterStats.hp = limitedHp

        if (defenseQueued > 0){
            println("$name successfully defended and took $limitedDamage damage!")
        }

        damageQueued = 0
        defenseQueued = 0

    }
}
