package activities

import kotlin.random.Random

fun main() {
    val hero = Hero("Hero", CharacterStats(hp = 25, def = 8))
    val enemy = Enemy("Goblin", CharacterStats(hp = 15, def = 5))


    println("Player's name is: ${hero.name}")
    println("Enemy's name is: ${enemy.name}")

    while (hero.characterStats.hp > 0 && enemy.characterStats.hp > 0){

        makeRandomMove(hero, enemy)
        makeRandomMove(enemy, hero)

        hero.receiveDamage()
        enemy.receiveDamage()

        println("${hero.name} HP is ${hero.characterStats.hp}")
        println("${enemy.name} HP is ${enemy.characterStats.hp}")
        println()

    }

    if (hero.characterStats.hp == 0){

        println("${enemy.name} won")
    }else{

        println("${hero.name} won")
    }


}

fun makeRandomMove(character: CharacterInterface, opponent: Character) {

    var move = listOf("attack", "defend", "heal").random()

    when(move){
        "attack" -> character.attack(opponent)
        "defend" -> character.defend()
        "heal" -> character.heal()
    }

}