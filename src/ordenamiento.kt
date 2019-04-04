import com.sun.xml.internal.bind.v2.model.annotation.Quick
import java.util.Arrays

fun main (artg: Array<String>){

    println("\nOriginal list:")
    val array = listOf<Int>(1, 1, 7, 9, 12, 1, 2, 3, 6, 4, 5)
    println(array)
    println("\nOrdered list:")
    val ordered =  quicksort(array)
    println(ordered)
    val deleteDuplicate = deleteElement(ordered, 1)
    println(deleteDuplicate)
}


fun <T:Comparable<T>>deleteElement(items:List<T>, count: Int): Boolean {
    var count2 = count

    for (i in 0 until items.count()){
        if(items[i] === items[i+1]){
            count2 ++
            var removeAt: T = (items as ArrayList).removeAt(i)
            if(count2 > 2){
                return false
            }
            deleteElement(items, count2)
        }
    }

    return true
}

fun <T:Comparable<T>>quicksort(items:List<T>):List<T>{
    if (items.count() < 1) return items
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)
}