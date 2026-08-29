package aquarium

class Aquarium {
    var width: Int = 20;
    var height: Int = 40;
    var length: Int = 100;

    fun volume(): Int {

        val volume: Int =  width * height * length / 1000;
        return volume;

    }
}