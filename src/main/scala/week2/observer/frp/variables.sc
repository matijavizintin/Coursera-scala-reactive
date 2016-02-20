import week2.observer.frp.StackableVariable

val caller = new StackableVariable(5)
caller.withValue(7){
    caller.value
}