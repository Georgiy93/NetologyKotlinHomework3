package ru.netology.homework32

val scan = java.util.Scanner(System.`in`)
fun main() {
    var typeCard = "Visa"
    //Сумму предыдущих переводов в этом месяце
    // и общий уплаченный налог занесем в массив
    var summaForMonthAndTotalTax = Array(2) { 0.0; 0.0 }

    while (true) {
        println("Введите сумму платежа в руб. или введите 0 для выхода")

        var summa: Int = scan.nextInt()
        if (summa == 0) {
            break;
        }
        summa *= 100

        summaForMonthAndTotalTax = resultSummaForMonthAndTotalTax(
            typeCard,
            summa, summaForMonthAndTotalTax
        )

    }
}

fun resultSummaForMonthAndTotalTax(typeCard: String, summa: Int,
    summaForMonthAndTotalTax: Array<Double>): Array<Double> {

    var outPut: String
    var resultSummaForMonthAndTotalTax = summaForMonthAndTotalTax
    when (typeCard) {

        "Mastercard", "Maestro", "Visa", "Мир" ->
            when {
                summa > 15000000 ->
                    outPut = "Сумма платежа превышает дневной лимит, попробуйте завтра. \n" +
                            "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "

                resultSummaForMonthAndTotalTax[0] > 60000000 ->
                    outPut = "Превышен месячный лимит, попробуйте в следующем месяце. \n" +
                            "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "

                else -> {
                    resultSummaForMonthAndTotalTax[0] += (summa - typeTaxes(typeCard, summa))

                    resultSummaForMonthAndTotalTax[1] += typeTaxes(typeCard, summa)
                    outPut = "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "
                }
            }


        else ->
            when {
                summa > 1500000 ->
                    outPut = "Сумма платежа превышает дневной лимит, попробуйте завтра. \n" +
                            "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "

                resultSummaForMonthAndTotalTax[0] > 4000000 ->
                    outPut = "Превышен месячный лимит, попробуйте в следующем месяце. \n" +
                            "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "

                else -> {
                    resultSummaForMonthAndTotalTax[0] += summa - typeTaxes(typeCard, summa)
                    resultSummaForMonthAndTotalTax[1] += typeTaxes(typeCard, summa)
                    outPut = "Общая коммисия составила:" +
                            resultSummaForMonthAndTotalTax[1] + " коп. "
                }


            }

    }


    println(outPut)
    return resultSummaForMonthAndTotalTax
}

fun typeTaxes(typeCard: String, summa: Int): Double = when (typeCard) {
    "Mastercard", "Maestro" ->
        when {
            summa <= 7500000 -> 0.0
            else -> summa * 0.006 + 2000
        }

    "Visa", "Мир" ->
        when {
            (summa * 0.0075 < 3500) -> 3500.0
            else -> summa * 0.0075
        }

    else -> 0.0
}


