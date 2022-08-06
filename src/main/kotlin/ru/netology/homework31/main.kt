package ru.netology.homework31

fun main () {
var amountSec =3*60*60
    println("был(а) " + agoToText(amountSec))
}
fun agoToText (amountSec:Int)= when  {
    (amountSec>=0 && amountSec<60)
    ->"только что"
    (amountSec>=60 && amountSec<60*60)
    -> DeclensionOfMinByCases(amountSec/60)
    (amountSec>=60*60 && amountSec<24*60*60)
    -> DeclensionOfHoursByCases(amountSec/(60*60))
    (amountSec>=24*60*60 && amountSec<2*24*60*60)
    ->"сегодня"
    (amountSec>=2*24*60*60 && amountSec<3*24*60*60)
    ->"вчера"
    else
    ->"давно"
}
fun DeclensionOfMinByCases (amountMin:Int)= when {
    amountMin==1 || (amountMin%10==1 && amountMin>20)
    ->"$amountMin минуту назад"

    amountMin in 2..4 ||( amountMin>20 && ( (amountMin%10)==2
            || (amountMin%10)==3 ||(amountMin%10)==4))
    ->"$amountMin минуты назад"
    else
    ->" $amountMin минут назад"

}
fun DeclensionOfHoursByCases (amountHours:Int)= when {
    amountHours==1 || (amountHours%10==1 && amountHours>20)
    ->"$amountHours час назад"

    amountHours in 2..4 ||( amountHours>20 && ( (amountHours%10)==2
            || (amountHours%10)==3 ||(amountHours%10)==4))
    ->"$amountHours часа назад"
    else
    ->" $amountHours часов назад"

}