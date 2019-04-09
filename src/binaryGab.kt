class binaryGab{


    fun toBinary(decimalNumber: Int, binaryString: String = "") : String {
        while (decimalNumber > 0) {
            val temp = "${binaryString}${decimalNumber%2}"
            return toBinary(decimalNumber/2, temp)
        }
        return binaryString.reversed()
    }

    fun solution(N: Int){
        var count = 0
        var gap = 0
        var decimal = this.toBinary(N,"")
        for (i in 0 until decimal.count()){
            if(decimal[i].equals('0')){
                count = count + 1
            } else{
                if(count>gap){
                    gap = count
                }
                count = 0
            }
        }
        println("gap: " + gap.toString())
    }
}