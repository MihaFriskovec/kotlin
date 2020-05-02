fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(options: Array<String>): String =  options[(Math.random() * options.size).toInt()]

fun getUserChoice(options: Array<String>): String {
    var userChoice = ""
    var isValidChoice = false
    while (!isValidChoice) {
        print("Please chose one of the following:")
        for (option in options) print(" $option")
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput in options) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }

    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    var result = ""
    result = if (userChoice == gameChoice) "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) "You Win!"
    else "You Lose!"

    println(result)
}