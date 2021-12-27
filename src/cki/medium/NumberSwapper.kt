package cki.medium

/**
 * swap numbers without temp variables
 */
fun main() {
    var a = 10
    var b = 5
    //using addition
    a += b
    b = a - b
    a -= b
    println("a = $a  / b = $b")

    // using bit operation
    a = a.xor(b)
    b = a.xor(b)
    a = a.xor(b)
    println("a = $a  / b = $b")
}