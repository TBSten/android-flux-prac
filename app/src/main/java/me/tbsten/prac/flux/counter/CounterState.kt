package me.tbsten.prac.flux.counter

data class CounterState(
    val count: Int,
    val canChange: Boolean,
) {
    companion object {
        val Initial = CounterState(
            count = 0,
            canChange = true,
        )
    }
}
