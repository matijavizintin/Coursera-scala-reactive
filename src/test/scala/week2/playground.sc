
def f1(): () => Integer = {
    def f2(): Integer = {
        5
    }
    f2
}

def f3(f: () => Integer) = {
    println(f())
}

f3(f1())