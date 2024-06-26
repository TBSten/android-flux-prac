package me.tbsten.prac.flux

import me.tbsten.prac.flux.counter.CounterStore

// 本来はHiltでSingletonで保持するべきものをここでグローバル変数として定義

val singletonCounterStore = CounterStore()
